/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.impl;

import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.service.UserService;
import com.wantai.oa.biz.shared.vo.BasicConfigVO;
import com.wantai.oa.biz.shared.vo.RevenueVO;
import com.wantai.oa.common.dal.mappings.dos.auth.Organization;
import com.wantai.oa.common.dal.mappings.dos.auth.User;
import com.wantai.oa.common.dal.mappings.dos.salary.OaSalaryDetails;
import com.wantai.oa.common.dal.mappings.dos.salary.SalaryDo;
import com.wantai.oa.common.lang.constants.Constants;
import com.wantai.oa.common.lang.enums.UnitEnum;
import com.wantai.oa.common.util.LoggerUtil;
import com.wantai.oa.performance.common.BasicService;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.SalaryService;
import com.wantai.oa.performance.common.WorkPerformanceService;
import com.wantai.oa.performance.common.request.BizConfigVO;
import com.wantai.oa.performance.common.request.WorkPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 工资服务实现类
 *
 * @author maping.mp
 * @version $Id: SalaryServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
@Qualifier("salaryService")
public class SalaryServiceImpl extends BaseService implements SalaryService {

    /** 配置服务*/
    @Autowired
    private ConfigService          configService;

    @Autowired
    private WorkPerformanceService workPerformanceService;

    @Autowired
    private UserService            userService;

    @Autowired
    private BasicService           basicService;

    @Override
    public void caculateSalary(String companyCode, String companyId) {
        //查询当前公司下所有用户信息
        List<User> users = userService.findUsers(companyCode, companyId);
        users.forEach(user -> caculateSalaryByCustomer(companyCode, companyId, user));
    }

    @Override
    public void caculateSalary() {
        List<Organization> organizations = (List<Organization>) commonDAO.findAll(
            "Organization.selectAll", new HashMap());
        organizations.forEach(org -> caculateSalary(org.getCompanyCode(), org.getId() + ""));
    }

    /**
     * 计算个人工资
     * @param companyCode           公司码
     * @param companyId             公司id
     * @param user                  当前用户
     */
    private void caculateSalaryByCustomer(String companyCode, String companyId, User user) {
        execute(() -> {
            //加载个人工资设置
            WorkPerformance workPerformance = workPerformanceService.queryWorkPerformance(
                companyCode, companyId, user.getId() + "");

            SalaryDo salaryDo = new SalaryDo();
            salaryDo.setCompanyCode(companyCode);
            salaryDo.setCompanyId(companyId);
            salaryDo.setCustomerId(user.getId() + "");

            //基本工资计算
            salaryDo.setBasicSalary(caculateBasicSalary(workPerformance, user));

            //星级工资计算
            salaryDo.setStarSalary(caculateStarSalary(workPerformance, user));

            //保底工资计算
            salaryDo.setLowestSalary(caculateLowestSalary(workPerformance, user));

            //工龄工资计算
            salaryDo.setWorkYearSalary(caculateWorkYearSalary(workPerformance, user));

            //考核绩效计算
            salaryDo.setKpi(caculateKpi(workPerformance, user));

            //岗位奖金
            salaryDo.setJjSalary(caculdateJj(workPerformance, user));

            //岗位补贴
            salaryDo.setSubsitySalary(caculdateSubsity(workPerformance, user));

            //奖金
            salaryDo.setBonusSalary(caculdateBouns(workPerformance, user));

            //提成
            salaryDo.setTcSalary(caculdateTc(workPerformance, user));

            //扣款
            salaryDo.setDuductSalary(caculateDeduct(workPerformance, user));

            //其它代扣
            salaryDo.setWithholdSalary(caculdateWithhold(workPerformance, user));

            //计算社保
            salaryDo.setSocailAmount(caculateSocial(workPerformance, user));

            //计算公积金
            salaryDo.setFundAmunt(caculdateFund(workPerformance, user));

            //计算保底工资差额
            salaryDo.setLowestSalaryDifference(caculdateLowestDiff(workPerformance, user));

            //计算应扣款合计
            salaryDo.setTotalWithholdingAmount(caculdateTotalWithhold(user, salaryDo));

            //计算应发工资
            caculdateSalary(user, salaryDo);

            //计算实发工资
            cacludateRealSalary(companyCode, companyId, user, salaryDo);

            //保存实发工资
            commonDAO.insert("Salary.insert", convert2SalaryDetail(salaryDo));
        });
    }

    private OaSalaryDetails convert2SalaryDetail(SalaryDo salaryDo) {
        OaSalaryDetails detail = new OaSalaryDetails();
        detail.setMemo(salaryDo.getMemo());
        detail.setBasicSalary(new BigDecimal(salaryDo.getBasicSalary()));
        detail.setBetAmount(new BigDecimal(0));
        detail.setBonusAmount(new BigDecimal(salaryDo.getBonusSalary()));
        detail.setCompanyCode(salaryDo.getCompanyCode());
        detail.setCompanyId(Integer.parseInt(salaryDo.getCompanyId()));
        detail.setCurrency(UnitEnum.CNY.getCode());
        detail.setCustomerId(salaryDo.getCustomerId());
        detail.setDeductAmount(new BigDecimal(salaryDo.getDuductSalary()));
        detail.setEndTime(new Date());
        detail.setFundAmount(new BigDecimal(salaryDo.getFundAmunt()));
        detail.setGrossSalary(new BigDecimal(salaryDo.getGrossSalary()));
        detail.setGwjj(new BigDecimal(salaryDo.getJjSalary()));
        detail.setGwtc(new BigDecimal(salaryDo.getTcSalary()));
        detail.setLastModifiedOeprator(Constants.SYSTEM);
        detail.setLowestSalary(new BigDecimal(salaryDo.getLowestSalary()));
        detail.setLowestSalaryDifference(new BigDecimal(salaryDo.getLowestSalaryDifference()));
        detail.setNetSalary(new BigDecimal(salaryDo.getRealSalary()));
        detail.setOperator(Constants.SYSTEM);
        detail.setRatioAmount(new BigDecimal(salaryDo.getKpi()));
        detail.setRevenueAmount(new BigDecimal(salaryDo.getRevenueAmount()));
        detail.setSocailAmount(new BigDecimal(salaryDo.getSocailAmount()));
        detail.setStartSalary(new BigDecimal(salaryDo.getStarSalary()));
        detail.setStartTime(new Date());
        detail.setSubsityAmount(new BigDecimal(salaryDo.getSubsitySalary()));
        detail.setTotalWithholdingAmount(new BigDecimal(salaryDo.getTotalWithholdingAmount()));
        detail.setWithholdAmount(new BigDecimal(salaryDo.getWithholdSalary()));
        detail.setWorkYearsSalary(new BigDecimal(salaryDo.getWorkYearSalary()));
        return detail;
    }

    /**
     * 计算扣款总额
     * @param salaryDo          工资设置
     * @return                  公积金缴存金额
     */
    private double caculdateTotalWithhold(User user, SalaryDo salaryDo) {
        double totalAmount = salaryDo.getDuductSalary() + salaryDo.getWithholdSalary();
        LoggerUtil.info(logger, String.format("当前用户[%s]扣款合计金额为[%s]", user.getId(), totalAmount));
        return totalAmount;
    }

    /**
     * 计算保底工资差额
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  公积金缴存金额
     */
    private double caculdateLowestDiff(WorkPerformance workPerformance, User user) {
        double diffAmount = 0;
        LoggerUtil.info(logger, String.format("当前用户[%s]保底工资差额为[%s]", user.getId(), diffAmount));
        return diffAmount;
    }

    /**
     * 计算公积金
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  公积金缴存金额
     */
    private double caculdateFund(WorkPerformance workPerformance, User user) {
        //公积金金额=(个人缴纳+公司缴纳)=(基数*比例*2)
        double fundAmount = workPerformance.getGjjBasic() * workPerformance.getGjjPercent() * 2;
        LoggerUtil.info(logger, String.format("当前用户[%s]公积金缴存金额为[%s]", user.getId(), fundAmount));
        return fundAmount;
    }

    /**
     * 计算社保
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  社保缴存金额
     */
    private double caculateSocial(WorkPerformance workPerformance, User user) {
        //社保金额=(个人缴纳+公司缴纳)=(基数*比例*2)
        double socialAmount = workPerformance.getSocialBasic() * workPerformance.getSocialPercent()
                              * 2;
        LoggerUtil.info(logger, String.format("当前用户[%s]社保缴存金额为[%s]", user.getId(), socialAmount));
        return socialAmount;
    }

    /**
     * 计算应发工资
     *
     * 应发工资{
     *       基本工资 +星级工资+ 保底工资差额+工龄工资  + 岗位奖金 + 岗位提成 +
     *       [ （考核绩效+星级工资） *（系数叠乘-1） ]+ 奖金 + 补贴 - 扣款 -其他代扣
     * }
     * @param user              当前用户
     * @param salaryDo          工资对象
     */
    private void caculdateSalary(User user, SalaryDo salaryDo) {
        double salary = salaryDo.getBasicSalary();//基本工资
        salary += salaryDo.getStarSalary();//星级工资
        salary += salaryDo.getLowestSalaryDifference();//保底工资差额
        salary += salaryDo.getWorkYearSalary();//工龄工资
        salary += salaryDo.getBonusSalary();//岗位奖金
        salary += salaryDo.getTcSalary();//岗位提成

        salary += salaryDo.getJjSalary();//奖金
        salary += salaryDo.getSubsitySalary();//补贴
        salary -= salaryDo.getDuductSalary();//扣款
        salary -= salaryDo.getFundAmunt();//其他代扣
        salaryDo.setSalary(salary);
        LoggerUtil.info(logger, String.format("当前用户[%s]应发工资为[%s]", user.getId(), salary));
    }

    /**
     * 计算实发工资
     *
     * 计算公式为
     * 实发工资={ 应发工资{
     *                  基本工资 +星级工资+ 保底工资差额+工龄工资  + 岗位奖金 + 岗位提成 +
     *                  [ （考核绩效+星级工资） *（系数叠乘-1） ]+ 奖金 + 补贴 - 扣款 -其他代扣
     *                 }
     *          减去其它
     *
     *          {社保 + 公积金 + 个税 }
     *
     * @param companyCode
     * @param companyId
     *@param user               当前用户
     * @param salaryDo          工资对象   @return                  个人基本工资
     */
    private void cacludateRealSalary(String companyCode, String companyId, User user,
                                     SalaryDo salaryDo) {
        double salary = salaryDo.getSalary();//应发工资
        double realSalary = salary;

        realSalary -= salaryDo.getSocailAmount();//社保
        realSalary -= salaryDo.getFundAmunt();//公积金
        realSalary -= caculateRevenue(companyCode, companyId, user, salaryDo);//个税

        LoggerUtil.info(logger, String.format("当前用户[%s]实发工资为[%s]", user.getId(), realSalary));
        salaryDo.setRealSalary(realSalary);
    }

    /**
     * 个人所得税计算
     *
     * @param companyCode       公司码
     * @param companyId         公司id
     * @param user              当前用户
     * @param salaryDo          工资对象   @return                  个人应缴税收
     */
    private double caculateRevenue(String companyCode, String companyId, User user,
                                   SalaryDo salaryDo) {
        double revenueAmount;
        double taxRatio = 0, deducts = 0;
        BasicConfigVO configVO = basicService.queryBasicConfig(companyCode, companyId);

        //全月应纳税所得额=应发工资-社保-公积金-个税起征点
        double salary = salaryDo.getSalary() - salaryDo.getSocailAmount() - salaryDo.getFundAmunt()
                        - Double.parseDouble(configVO.getStart());

        List<RevenueVO> revenueList = configVO.getRevenueVOList();

        Optional<RevenueVO> range = revenueList.stream().filter(revenue -> {
            double fromValue = Double.parseDouble(revenue.getFromValue());
            double toValue = Double.parseDouble(revenue.getToValue());
            return salary > fromValue && salary <= toValue;
        }).findFirst();

        if (range.isPresent()) {
            RevenueVO revenueVO = range.get();
            taxRatio = Double.parseDouble(revenueVO.getRatio());
            deducts = Double.parseDouble(revenueVO.getDeducts());
        } else {
            RevenueVO max = revenueList.stream().max(Comparator.comparing(RevenueVO::getToValue))
                .get();

            double maxSalary = Double.parseDouble(max.getToValue());
            if (salary > maxSalary) {
                taxRatio = Double.parseDouble(max.getRatio());
                deducts = Double.parseDouble(max.getDeducts());
            }
        }

        revenueAmount = salary * taxRatio - deducts;

        //设置个税金额
        salaryDo.setRevenueAmount(revenueAmount);
        return revenueAmount < 0 ? 0 : revenueAmount;
    }

    /**
     * 计算奖金
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculdateBouns(WorkPerformance workPerformance, User user) {
        return 0;
    }

    /**
     * 计算岗位奖金
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人岗位奖金
     */
    private double caculdateJj(WorkPerformance workPerformance, User user) {
        //查找当前用户生效的配置
        List<BizConfigVO> bizConfigVOs = workPerformance.getBizConfigVOs();
        List<BizConfigVO> enabledConfigs = bizConfigVOs.stream()
            .filter(config -> config.isEnable()).collect(Collectors.toList());

        //查询当前用户当前计算月内所有的计算指标数据

        //匹配所有的可用数据进行处理
        return 0;
    }

    /**
     * 计算提成
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人岗位提成
     */
    private double caculdateTc(WorkPerformance workPerformance, User user) {
        List<BizConfigVO> bizConfigVOs = workPerformance.getBizConfigVOs();

        return 0;
    }

    /**
     * 计算扣款
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculateDeduct(WorkPerformance workPerformance, User user) {
        LoggerUtil.info(logger, String.format("当前用户[%s]扣款金额为[%s]", user.getId(), 0));
        return 0;
    }

    /**
     * 计算补贴
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculdateSubsity(WorkPerformance workPerformance, User user) {
        LoggerUtil.info(logger, String.format("当前用户[%s]补贴金额为[%s]", user.getId(), 0));
        return 0;
    }

    /**
     * 计算绩效系数
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculateKpi(WorkPerformance workPerformance, User user) {
        return 0;
    }

    /**
     * 计算当前工龄工资
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculateWorkYearSalary(WorkPerformance workPerformance, User user) {
        double workYearSalary = Math.min(getWorkYears(user) * workPerformance.getMonthSalary(),
            workPerformance.getMaxMonthSalary());
        LoggerUtil.info(logger, String.format("当前用户[%s]工龄工资为[%s]", user.getId(), workYearSalary));
        return workYearSalary;
    }

    /**
     * 获取当前用户的工龄
     * @param user          当前用户
     * @return              用户入职到现在的月数,默认返回1
     */
    private int getWorkYears(User user) {
        return 1;
    }

    /**
     * 计算最低工资
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculateLowestSalary(WorkPerformance workPerformance, User user) {
        boolean hasLowestSalary = workPerformance.getSalaryFormuaVO().isHasLowestSalary();
        double lowestSalary = hasLowestSalary ? workPerformance.getLowestSalary() : 0;
        LoggerUtil.info(logger, String.format("当前用户[%s]最低工资为[%s]", user.getId(), lowestSalary));
        return lowestSalary;
    }

    /**
     * 计算星级工资
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculateStarSalary(WorkPerformance workPerformance, User user) {
        boolean hasStartSalary = workPerformance.getSalaryFormuaVO().isHasStarSalary();
        double startSalary = hasStartSalary ? workPerformance.getStarSalary() : 0;
        LoggerUtil.info(logger, String.format("当前用户[%s]星级工资为[%s]", user.getId(), startSalary));
        return startSalary;
    }

    /**
     * 计算基本工资
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculateBasicSalary(WorkPerformance workPerformance, User user) {
        boolean hasBasicSalary = workPerformance.getSalaryFormuaVO().isHasBasicSalary();
        double basicSalary = hasBasicSalary ? workPerformance.getBasicSalary() : 0;
        LoggerUtil.info(logger, String.format("当前用户[%s]基本工资为[%s]", user.getId() + "", basicSalary));
        return basicSalary;
    }

    /**
     * 计算其它代扣
     * @param workPerformance   个人岗位设置
     * @param user              当前用户
     * @return                  个人基本工资
     */
    private double caculdateWithhold(WorkPerformance workPerformance, User user) {
        LoggerUtil.info(logger, String.format("当前用户[%s]其它代扣金额为[%s]", user.getId() + "", 0));
        return 0;
    }
}
