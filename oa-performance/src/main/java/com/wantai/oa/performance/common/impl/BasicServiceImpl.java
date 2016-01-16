/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.impl;

import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.vo.BasicConfigVO;
import com.wantai.oa.biz.shared.vo.RevenueVO;
import com.wantai.oa.common.dal.mappings.dos.performance.ConfigDo;
import com.wantai.oa.common.dal.mappings.dos.performance.RevenueDo;
import com.wantai.oa.common.dal.mappings.dos.performance.SubConfigDo;
import com.wantai.oa.common.lang.constants.Constants;
import com.wantai.oa.common.lang.enums.CustomerTypeEnum;
import com.wantai.oa.common.util.ObjectUtils;
import com.wantai.oa.performance.common.BasicService;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.request.BasicRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置服务
 *
 * @author maping.mp
 * @version $Id: BasicServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class BasicServiceImpl extends BaseService implements BasicService {

    /** 配置服务*/
    @Autowired
    private ConfigService configService;

    @Override
    public void addBasicConfig(BasicRequest request) {
        execute(() -> {

            String customerId = request.getCustomerId();

            //更新工龄工资设置
            updateWorkSalary(customerId, request.getWorkYearSalary(),
                request.getMaxSalaryPerMonth());

            //更新社保设置
            updateSocialConfig(customerId, request.getSocailBasic(), request.getSocailPercent());

            //更新公积金设置
            updateGjjConfig(customerId, request.getGjjBasic(), request.getGjjPercent());

            //更新个税设置
            updateTaxConfig(request);
        });
    }

    @Override
    public BasicConfigVO queryBasicConfig(String companyCode, String companyId) {
        BasicConfigVO configVO = new BasicConfigVO();

        //查询工龄工资设置
        SubConfigDo salary = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_GLGZ_EVENT, Constants.WORKYEAR_SALARY, null);
        configVO.setWorkYearSalary(salary.getValue());
        configVO.setMaxSalaryPerMonth(salary.getToValue());

        //查询个税起征点数据
        queryRevenueStart(configVO);

        //查询个税数据
        queryRevenueList(configVO);

        //查询社保设置
        querySocialConfig(companyCode, companyId, configVO);

        //查询公积金设置
        queryGjjConfig(companyCode, companyId, configVO);

        return configVO;
    }

    /**
     * 查询公积金设置
     * @param companyCode           公司编号
     * @param companyId             公司id
     * @param configVO              公共配置VO对象
     */
    private void queryGjjConfig(String companyCode, String companyId, BasicConfigVO configVO) {
        SubConfigDo wjjBasic = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_GJJ_EVENT, Constants.GJJ_BASIC, null);
        configVO.setGjjBasic(wjjBasic.getValue());

        SubConfigDo wjjRatio = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_GJJ_EVENT, Constants.GJJ_RATIO, null);
        configVO.setGjjPercent(wjjRatio.getValue());
    }

    /**
     * 查询社保设置
     * @param companyCode           公司编号
     * @param companyId             公司id
     * @param configVO              公共配置VO对象
     */
    private void querySocialConfig(String companyCode, String companyId, BasicConfigVO configVO) {
        SubConfigDo socialBasic = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_SOCIAL_EVENT, Constants.SOCIAL_BASIC, null);
        configVO.setSocailBasic(socialBasic.getValue());

        SubConfigDo socialRatio = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_SOCIAL_EVENT, Constants.SOCIAL_RATIO, null);
        configVO.setSocailPercent(socialRatio.getValue());
    }

    /**
     * 查询个税数据列表
     * @param configVO              当前公共配置VO
     */
    private void queryRevenueList(BasicConfigVO configVO) {
        Map<String, Object> paramter = new HashMap();
        paramter.put("key", Constants.REVENUE_START);
        paramter.put("companyCode", UserHolder.getUser().getCompanyCode());
        paramter.put("companyId", UserHolder.getUser().getCompanyId());
        List<RevenueDo> revenueDoList = (List<RevenueDo>) commonDAO.findAll("Revenue.queryRevenue",
            paramter);

        if (CollectionUtils.isNotEmpty(revenueDoList)) {
            List<RevenueVO> voList = new ArrayList<>();
            revenueDoList.forEach(revenueDo -> {
                RevenueVO vo = new RevenueVO();
                vo.setFromValue(revenueDo.getFromValue());
                vo.setToValue(revenueDo.getToValue());
                vo.setRatio(revenueDo.getRatio());
                vo.setDeducts(revenueDo.getDeducts());
                voList.add(vo);
            });
            configVO.setRevenueVOList(voList);
        } else {
            configVO.setRevenueVOList(new ArrayList<>());
        }
    }

    /**
     * 设置个税起征点
     * @param configVO              当前公共配置VO
     */
    private void queryRevenueStart(BasicConfigVO configVO) {
        Map<String, Object> paramter = new HashMap();
        paramter.put("key", Constants.REVENUE_START);
        paramter.put("companyCode", UserHolder.getUser().getCompanyCode());
        paramter.put("companyId", UserHolder.getUser().getCompanyId());
        String start = (String) commonDAO.selectOne("SystemConfig.query", paramter);
        configVO.setStart(start);
    }

    /**
     * 更新个税设置
     * @param request               请求对象
     */
    private void updateTaxConfig(BasicRequest request) {
        //更新个税起征点
        Map<String, Object> paramter = new HashMap();
        paramter.put("key", Constants.REVENUE_START);
        paramter.put("value", request.getStart());
        paramter.put("companyCode", UserHolder.getUser().getCompanyCode());
        paramter.put("companyId", UserHolder.getUser().getCompanyId());
        commonDAO.update("SystemConfig.update", paramter);

        //更新个税配置表(先删除,在新增)
        commonDAO.delete("Revenue.delete", paramter);

        if (CollectionUtils.isNotEmpty(request.getRevenueVOList())) {
            request.getRevenueVOList().forEach(taxVO -> {
                Map<String, Object> data = new HashMap();
                ObjectUtils.populate(taxVO, data);
                data.put("companyCode", UserHolder.getUser().getCompanyCode());
                data.put("companyId", UserHolder.getUser().getCompanyId());
                data.put("operator", UserHolder.getUser().getLoginName());
                data.put("lastModifiedOperator", UserHolder.getUser().getLoginName());
                commonDAO.insert("Revenue.add", data);
            });
        }
    }

    /**
     *
     * 创建参数
     *
     * @param customerId            客户编号
     * @param businessConfigId      配置编号
     * @param subEventCode          子事件编码
     * @param value                 事件值
     * @return                      返回paramter参数
     */
    private Map<String, Object> createParameter(String customerId, String businessConfigId,
                                                String subEventCode, String value) {
        Map<String, Object> paramter = new HashMap();
        String target = CustomerTypeEnum.COMPANY.getCode();
        if (StringUtils.isNotBlank(customerId)) {
            target = CustomerTypeEnum.CUSTOMER.getCode();
        }
        paramter.put("businessConfigId", businessConfigId);
        paramter.put("subEventCode", subEventCode);
        paramter.put("target", target);
        paramter.put("customerId", customerId);
        paramter.put("value", value);
        return paramter;
    }

    @Override
    public void updateSubConfig(String customerId, String businessConfigId, String subEventCode,
                                String value) {
        Map<String, Object> paramter = createParameter(customerId, businessConfigId, subEventCode,
            value);
        commonDAO.update("SubConfig.updateSubConfig", paramter);
    }

    @Override
    public void updateSubConfig(String customerId, String businessConfigId, String subEventCode,
                                String value, String toValue) {
        Map<String, Object> paramter = createParameter(customerId, businessConfigId, subEventCode,
            value);
        paramter.put("toValue", toValue);
        commonDAO.update("SubConfig.updateSubConfig", paramter);
    }

    /**
     * 更新社保配置
     * @param customerId            客户编号
     * @param socialBasic           社保基数
     * @param socialRatio           社保缴存比例
     */
    private void updateSocialConfig(String customerId, String socialBasic, String socialRatio) {

        ConfigDo configDo = configService.queryConfig(UserHolder.getUser().getCompanyCode(),
            UserHolder.getUser().getCompanyId() + "", Constants.JCSZ_BIZ_ITEM,
            Constants.JCSZ_SOCIAL_EVENT);
        Assert.notNull(configDo, "社保配置对象不能为空");
        updateSubConfig(customerId, configDo.getId() + "", Constants.SOCIAL_BASIC, socialBasic);
        updateSubConfig(customerId, configDo.getId() + "", Constants.SOCIAL_RATIO, socialRatio);
    }

    /**
     * 更新公积金配置
     * @param customerId            客户编号
     * @param gjjBasic              公积金基数
     * @param gjjRatio              公积金缴存比例
     */
    private void updateGjjConfig(String customerId, String gjjBasic, String gjjRatio) {
        ConfigDo configDo = configService.queryConfig(UserHolder.getUser().getCompanyCode(),
            UserHolder.getUser().getCompanyId() + "", Constants.JCSZ_BIZ_ITEM,
            Constants.JCSZ_GJJ_EVENT);
        Assert.notNull(configDo, "公积金配置对象不能为空");

        updateSubConfig(customerId, configDo.getId() + "", Constants.GJJ_BASIC, gjjBasic);
        updateSubConfig(customerId, configDo.getId() + "", Constants.GJJ_RATIO, gjjRatio);
    }

    /**
     * 更新工龄工资
     * @param customerId             客户编号
     * @param salaryPerMonth         每月工龄工资
     * @param maxSalaryPerMonth      每月最大工龄工资
     */
    private void updateWorkSalary(String customerId, String salaryPerMonth, String maxSalaryPerMonth) {
        ConfigDo configDo = configService.queryConfig(UserHolder.getUser().getCompanyCode(),
            UserHolder.getUser().getCompanyId() + "", Constants.JCSZ_BIZ_ITEM,
            Constants.JCSZ_GLGZ_EVENT);
        Assert.notNull(configDo, "工龄工资配置对象不能为空");
        updateSubConfig(customerId, configDo.getId() + "", Constants.WORKYEAR_SALARY,
            salaryPerMonth, maxSalaryPerMonth);
    }
}
