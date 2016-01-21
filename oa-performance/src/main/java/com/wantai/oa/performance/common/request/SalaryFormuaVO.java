package com.wantai.oa.performance.common.request;

import com.wantai.oa.common.lang.enums.CacluTypeEnum;
import com.wantai.oa.common.lang.enums.KpiTypeEnum;

/**
 * 工资计算请求对象
 *
 * @author maping.mp
 * @version $Id: SalaryFormuaVO.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class SalaryFormuaVO {

    /** 是否有基本工资*/
    private boolean hasBasicSalary;

    /** 是否有星级工资*/
    private boolean hasStarSalary;

    /** 是否有保底工资*/
    private boolean hasLowestSalary;

    /** 是否有工龄工资*/
    private boolean hasWorkSalary;

    /** 绩效考核方式 */
    private String  checkRule     = KpiTypeEnum.BET.getCode();

    /** 绩效计算方式 */
    private String  ratioCaclType = CacluTypeEnum.AVG.getCode();

    /** 是否有补贴 */
    private boolean hasSubsitSalary;

    /** 是否有奖金 */
    private boolean hasBonusSalary;

    /** 是否有扣款 */
    private boolean hasDeductSalary;

    /** 是否有其它扣款 */
    private boolean hasWithholdSalary;

    public boolean isHasBasicSalary() {
        return hasBasicSalary;
    }

    public void setHasBasicSalary(boolean hasBasicSalary) {
        this.hasBasicSalary = hasBasicSalary;
    }

    public boolean isHasStarSalary() {
        return hasStarSalary;
    }

    public void setHasStarSalary(boolean hasStarSalary) {
        this.hasStarSalary = hasStarSalary;
    }

    public boolean isHasLowestSalary() {
        return hasLowestSalary;
    }

    public void setHasLowestSalary(boolean hasLowestSalary) {
        this.hasLowestSalary = hasLowestSalary;
    }

    public boolean isHasWorkSalary() {
        return hasWorkSalary;
    }

    public void setHasWorkSalary(boolean hasWorkSalary) {
        this.hasWorkSalary = hasWorkSalary;
    }

    public String getCheckRule() {
        return checkRule;
    }

    public void setCheckRule(String checkRule) {
        this.checkRule = checkRule;
    }

    public String getRatioCaclType() {
        return ratioCaclType;
    }

    public void setRatioCaclType(String ratioCaclType) {
        this.ratioCaclType = ratioCaclType;
    }

    public boolean isHasSubsitSalary() {
        return hasSubsitSalary;
    }

    public void setHasSubsitSalary(boolean hasSubsitSalary) {
        this.hasSubsitSalary = hasSubsitSalary;
    }

    public boolean isHasBonusSalary() {
        return hasBonusSalary;
    }

    public void setHasBonusSalary(boolean hasBonusSalary) {
        this.hasBonusSalary = hasBonusSalary;
    }

    public boolean isHasDeductSalary() {
        return hasDeductSalary;
    }

    public void setHasDeductSalary(boolean hasDeductSalary) {
        this.hasDeductSalary = hasDeductSalary;
    }

    public boolean isHasWithholdSalary() {
        return hasWithholdSalary;
    }

    public void setHasWithholdSalary(boolean hasWithholdSalary) {
        this.hasWithholdSalary = hasWithholdSalary;
    }
}
