/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.impl;

import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.vo.BizEventVO;
import com.wantai.oa.biz.shared.vo.BizItemVO;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.common.dal.mappings.dos.performance.PerformanceDo;
import com.wantai.oa.common.dal.mappings.dos.performance.SubConfigDo;
import com.wantai.oa.common.dal.mappings.dos.performance.UserBizEvent;
import com.wantai.oa.common.dal.mappings.dos.performance.UserFormula;
import com.wantai.oa.common.lang.constants.Constants;
import com.wantai.oa.common.lang.enums.ConfigTypeEnum;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.WorkPerformanceService;
import com.wantai.oa.performance.common.request.BizConfigVO;
import com.wantai.oa.performance.common.request.SalaryFormuaVO;
import com.wantai.oa.performance.common.request.WorkPerformanceRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 配置服务
 *
 * @author maping.mp
 * @version $Id: BasicServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class WorkPerformanceServiceImpl extends BaseService implements WorkPerformanceService {

    /** 配置服务*/
    @Autowired
    private ConfigService configService;

    /**
     * 查询公积金设置
     * @param companyCode           公司编号
     * @param companyId             公司id
     * @param customerId            用户id
     * @param result                公共配置VO对象
     */
    private void queryGjjConfig(String companyCode, String companyId, String customerId,
                                WorkPerformanceRequest result) {
        SubConfigDo wjjBasic = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_GJJ_EVENT, Constants.GJJ_BASIC, customerId);

        //个人设置为空,则查询公司级别设置
        if (wjjBasic == null) {
            wjjBasic = configService.querySingleSubConfig(companyCode, companyId,
                Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_SOCIAL_EVENT, Constants.SOCIAL_BASIC, null);
        }
        result.setGjjBasic(Double.parseDouble(wjjBasic.getValue()));

        SubConfigDo wjjRatio = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_GJJ_EVENT, Constants.GJJ_RATIO, customerId);

        //个人设置为空,则查询公司级别设置
        if (wjjRatio == null) {
            wjjRatio = configService.querySingleSubConfig(companyCode, companyId,
                Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_SOCIAL_EVENT, Constants.SOCIAL_BASIC, null);
        }
        result.setGjjPercent(Double.parseDouble(wjjRatio.getValue()));
    }

    /**
     * 查询社保设置
     * @param companyCode           公司编号
     * @param companyId             公司id
     * @param customerId            用户id
     * @param result                公共配置VO对象
     */
    private void querySocialConfig(String companyCode, String companyId, String customerId,
                                   WorkPerformanceRequest result) {
        SubConfigDo socialBasic = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_SOCIAL_EVENT, Constants.SOCIAL_BASIC,
            customerId);

        //个人设置为空,则查询公司级别设置
        if (socialBasic == null) {
            socialBasic = configService.querySingleSubConfig(companyCode, companyId,
                Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_SOCIAL_EVENT, Constants.SOCIAL_BASIC, null);
        }
        result.setSocialBasic(Double.parseDouble(socialBasic.getValue()));

        SubConfigDo socialRatio = configService.querySingleSubConfig(companyCode, companyId,
            Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_SOCIAL_EVENT, Constants.SOCIAL_RATIO,
            customerId);

        //个人设置为空,则查询公司级别设置
        if (socialRatio == null) {
            socialRatio = configService.querySingleSubConfig(companyCode, companyId,
                Constants.JCSZ_BIZ_ITEM, Constants.JCSZ_SOCIAL_EVENT, Constants.SOCIAL_BASIC, null);
        }
        result.setSocialPercent(Double.parseDouble(socialRatio.getValue()));
    }

    @Override
    public void addWorkPerformance(WorkPerformanceRequest request) {
        execute(() -> {
            //修改基本工资设置
            updateOrSaveBaseInfo(request);

            //修改业务事项事件配置
            updateOrSaveUserBizEvents(request);

            //修改用户计算公式
            updateOrSaveUserFormlua(request);
        });
    }

    /**
     * 更新或者新增用户工资计算公式
     * @param request                   请求对象
     */
    private void updateOrSaveUserFormlua(WorkPerformanceRequest request) {
        //删除用户公式设置
        //先删除配置
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", request.getCompanyCode());
        parameter.put("companyId", request.getCompanyId());
        parameter.put("customerId", request.getCustomerId());
        commonDAO.delete("UserSalaryFormula.deleteUserSalaryFormula", parameter);

        //新增用户公式设置

        UserFormula formula = new UserFormula();
        SalaryFormuaVO vo = request.getSalaryFormuaVO();

        formula.setCompanyCode(request.getCompanyCode());
        formula.setCompanyId(request.getCompanyId());
        formula.setCustomerId(request.getCustomerId());
        formula.setHasBasicSalary(vo.isHasBasicSalary() + "");
        formula.setHasBonusSalary(vo.isHasBonusSalary() + "");
        formula.setHasDeductSalary(vo.isHasDeductSalary() + "");
        formula.setHasLowestSalary(vo.isHasLowestSalary() + "");
        formula.setHasStartSalary(vo.isHasStarSalary() + "");
        formula.setHasSubsitySalary(vo.isHasSubsitSalary() + "");
        formula.setHasWithholdSalary(vo.isHasWithholdSalary() + "");
        formula.setHasWorkYearsSalary(vo.isHasWorkSalary() + "");
        formula.setOperator(request.getOperator());
        formula.setLastModifiedOperator(request.getOperator());
        formula.setCheckRule(vo.getCheckRule());
        formula.setRatioCacluType(vo.getRatioCaclType());

        commonDAO.insert("UserSalaryFormula.addUserSalaryFormula", formula);
    }

    /**
     * 设置基础信息
     * @param performanceDo     用户绩效设置对象
     * @param request           当前请求对象
     */
    private void setBaseInfo(PerformanceDo performanceDo, WorkPerformanceRequest request) {
        performanceDo.setCustomerId(request.getCustomerId());
        performanceDo.setOperator(request.getOperator());
        performanceDo.setLastModifiedOperator(request.getOperator());
        //基本设置
        performanceDo.setBasicSalary(request.getBasicSalary()); //基本工资
        performanceDo.setStarSalary(request.getStarSalary()); //星级工资
        performanceDo.setLowestSalary(request.getLowestSalary());//保底工资
        performanceDo.setWorkYearsSalary(request.getMonthSalary());//工龄工资
        performanceDo.setMaxWorkYearsSalary(request.getMaxMonthSalary());//封顶工龄工资
        performanceDo.setBetAmount(request.getBetAmount()); //对赌额

        performanceDo.setCompanyCode(request.getCompanyCode());
        performanceDo.setCompanyId(request.getCompanyId());

        //社保缴纳情况
        performanceDo.setSocialBasicAmount(request.getSocialBasic());
        performanceDo.setSocialPercent(request.getSocialPercent());

        //公积金缴纳情况
        performanceDo.setFundBasicAmount(request.getGjjBasic());
        performanceDo.setFundPercent(request.getGjjPercent());
    }

    /**
     * 设置用户业务事项事件配置
     * @param request           当前请求对象
     */
    private void updateOrSaveUserBizEvents(WorkPerformanceRequest request) {
        //先删除配置
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", request.getCompanyCode());
        parameter.put("companyId", request.getCompanyId());
        parameter.put("customerId", request.getCustomerId());
        commonDAO.delete("UserBizEvent.deleteUserBizEvent", parameter);

        //新增配置
        if (CollectionUtils.isNotEmpty(request.getBizConfigVOs())) {
            request.getBizConfigVOs().forEach(config -> {
                UserBizEvent event = new UserBizEvent();
                event.setCustomerId(request.getCustomerId());
                event.setBizItem(config.getBizItem());
                event.setBizEvent(config.getBizEvent());
                event.setEnable(config.isEnable() + "");
                event.setCompanyCode(request.getCompanyCode());
                event.setCompanyId(request.getCompanyId());
                event.setOperator(request.getOperator());
                event.setLastModifiedOperator(request.getOperator());

                commonDAO.insert("UserBizEvent.addUserBizEvent", event);
            });
        }
    }

    /**
     * 设置用户业基础信息
     * @param request           当前请求对象
     */
    private void updateOrSaveBaseInfo(WorkPerformanceRequest request) {
        List<PerformanceDo> userPerformances = queryUserPerformances(request.getCompanyCode(),
            request.getCompanyId(), request.getCustomerId());
        if (CollectionUtils.isEmpty(userPerformances)) {
            PerformanceDo performanceDo = new PerformanceDo();
            setBaseInfo(performanceDo, request);
            commonDAO.insert("Performance.addUserPerformance", performanceDo);
        } else {
            PerformanceDo performanceDo = userPerformances.get(0);
            commonDAO.delete("Performance.deleteUserPerformance", performanceDo.getId());
            setBaseInfo(performanceDo, request);
            commonDAO.insert("Performance.addUserPerformance", performanceDo);
        }
    }

    @Override
    public WorkPerformanceRequest queryWorkPerformance(String companyCode, String companyId,
                                                       String customerId) {
        WorkPerformanceRequest result = new WorkPerformanceRequest();

        //查询社保设置
        querySocialConfig(companyCode, companyId, customerId, result);

        //查询公积金设置
        queryGjjConfig(companyCode, companyId, customerId, result);

        //查询基础工资设置
        queryBaseSalaryConfig(companyCode, companyId, customerId, result);

        //查询系数列表设置
        queryBizItemAndEvents(companyCode, companyId, customerId, result);

        //查询岗位绩效工资设置
        queryFormulaConfig(companyCode, companyId, customerId, result);

        result.setCompanyCode(companyCode);
        result.setCompanyId(companyId);
        result.setCustomerId(customerId);

        return result;
    }

    /**
     * 查询当前用户工资计算公式
     * @param companyCode               公司码
     * @param companyId                 公司id
     * @param customerId                用户id
     * @param result                    结果
     */
    private void queryFormulaConfig(String companyCode, String companyId, String customerId,
                                    WorkPerformanceRequest result) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        parameter.put("customerId", customerId);
        List<UserFormula> userFormulas = (List<UserFormula>) commonDAO.findAll(
            "UserSalaryFormula.queryUserSalaryFormula", parameter);
        if (CollectionUtils.isNotEmpty(userFormulas)) {
            UserFormula formula = userFormulas.get(0);
            SalaryFormuaVO configVO = new SalaryFormuaVO();
            configVO.setCheckRule(formula.getCheckRule());
            configVO.setHasBasicSalary(Boolean.parseBoolean(formula.getHasBasicSalary()));
            configVO.setHasBonusSalary(Boolean.parseBoolean(formula.getHasBonusSalary()));
            configVO.setHasDeductSalary(Boolean.parseBoolean(formula.getHasDeductSalary()));
            configVO.setHasLowestSalary(Boolean.parseBoolean(formula.getHasLowestSalary()));
            configVO.setHasStarSalary(Boolean.parseBoolean(formula.getHasStartSalary()));
            configVO.setHasSubsitSalary(Boolean.parseBoolean(formula.getHasSubsitySalary()));
            configVO.setHasWithholdSalary(Boolean.parseBoolean(formula.getHasWithholdSalary()));
            configVO.setHasWorkSalary(Boolean.parseBoolean(formula.getHasWorkYearsSalary()));
            configVO.setRatioCaclType(formula.getRatioCacluType());
            result.setSalaryFormuaVO(configVO);
        }
    }

    /**
     * 查询当前用户设置的事项事件
     * @param companyCode               公司码
     * @param companyId                 公司id
     * @param customerId                用户id
     * @param result                    结果
     */
    private void queryBizItemAndEvents(String companyCode, String companyId, String customerId,
                                       WorkPerformanceRequest result) {

        //获取岗位绩效系数中配置的业务事项和事件
        List<BizConfigVO> events = getBizConfigVOs(companyCode, companyId);

        //查询当前用户设置的事项事件
        List<UserBizEvent> userBizEvents = getUserBizEvents(companyCode, companyId, customerId);

        //合并当前数据
        if (CollectionUtils.isNotEmpty(userBizEvents)) {
            userBizEvents.forEach(bizEvent -> {
                Optional<BizConfigVO> found = events
                    .stream()
                    .filter(
                        config -> StringUtils.equals(bizEvent.getBizItem(), config.getBizItem())
                                  && StringUtils.equals(bizEvent.getBizEvent(),
                                      config.getBizEvent())).findFirst();

                if (found.isPresent()) {
                    found.get().setEnable(Boolean.parseBoolean(bizEvent.getEnable()));
                }
            });
        }

        result.setBizConfigVOs(events);
    }

    private List<BizConfigVO> getBizConfigVOs(String companyCode, String companyId) {
        ConfigVO configVO = configService.queryConfigs(companyCode, Integer.parseInt(companyId),
            ConfigTypeEnum.GWXS.getCode(), true, null);
        Set<BizItemVO> bizItems = configVO.getBizItems();
        List<BizConfigVO> events = new ArrayList<>();
        bizItems.forEach(item -> {
            List<BizEventVO> eventVOList = item.getBizEvents();
            eventVOList.forEach(event -> {
                BizConfigVO userEvent = new BizConfigVO();
                userEvent.setBizItem(event.getBizItem());
                userEvent.setBizEvent(event.getBizEvent());
                //默认不选中
                userEvent.setEnable(false);
                events.add(userEvent);
            });
        });
        return events;
    }

    private List<UserBizEvent> getUserBizEvents(String companyCode, String companyId,
                                                String customerId) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        parameter.put("customerId", customerId);
        return (List<UserBizEvent>) commonDAO.findAll("UserBizEvent.queryUserBizEvent", parameter);
    }

    /**
     * 查询当前用户基本工资组成
     * @param companyCode               公司码
     * @param companyId                 公司id
     * @param customerId                用户id
     * @param result                    结果
     */
    private void queryBaseSalaryConfig(String companyCode, String companyId, String customerId,
                                       WorkPerformanceRequest result) {

        List<PerformanceDo> performanceList = queryUserPerformances(companyCode, companyId,
            customerId);
        if (CollectionUtils.isNotEmpty(performanceList)) {
            PerformanceDo performanceDo = performanceList.get(0);

            //基本设置
            result.setBasicSalary(performanceDo.getBasicSalary()); //基本工资
            result.setStarSalary(performanceDo.getStarSalary()); //星级工资
            result.setLowestSalary(performanceDo.getLowestSalary());//保底工资
            result.setMonthSalary(performanceDo.getWorkYearsSalary());//工龄工资
            result.setMaxMonthSalary(performanceDo.getMaxWorkYearsSalary());//封顶工龄工资
            result.setBetAmount(performanceDo.getBetAmount()); //对赌额

            //社保缴纳情况
            result.setSocialBasic(performanceDo.getSocialBasicAmount());
            result.setSocialPercent(performanceDo.getSocialPercent());

            //公积金缴纳情况
            result.setGjjBasic(performanceDo.getFundBasicAmount());
            result.setGjjPercent(performanceDo.getFundPercent());
        }

    }

    private List<PerformanceDo> queryUserPerformances(String companyCode, String companyId,
                                                      String customerId) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        parameter.put("customerId", customerId);
        return (List<PerformanceDo>) commonDAO.findAll("Performance.queryPerformanceConfig",
            parameter);
    }
}
