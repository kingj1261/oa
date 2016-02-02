/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.vo;

import com.wantai.oa.common.lang.enums.CustomerTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * 公共配置VO对象
 *
 * @author maping.mp
 * @version $Id: BaseRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BasicConfigVO implements Serializable {
    /** 每月工龄工资 */
    private String          workYearSalary;

    /** 每月最大工龄工资*/
    private String          maxSalaryPerMonth  = "1000";

    //~~~~~~~税率相关
    /** 个税起征点 */
    private String          start              = "3500";

    /** 个税设置list*/
    private List<RevenueVO> revenueVOList;

    /** 社保基数*/
    private String          socailBasic;

    /** 社保个人缴纳比例*/
    private String          socailPercent;

    /** 公积金基数*/
    private String          gjjBasic;

    /** 公积金个人缴纳比例*/
    private String          gjjPercent;

    /** 个税是否启用*/
    private boolean         revenueStartEnable = true;

    /** 社保设置是否启用*/
    private boolean         socialEnable       = true;

    /** 社保设置方式*/
    private String          socialSettingType  = CustomerTypeEnum.COMPANY.getCode();

    /** 公积金设置是否启用*/
    private boolean         fundEnable         = true;

    /** 公积金设置方式*/
    private String          fundSettingType    = CustomerTypeEnum.COMPANY.getCode();

    public String getWorkYearSalary() {
        return workYearSalary;
    }

    public void setWorkYearSalary(String workYearSalary) {
        this.workYearSalary = workYearSalary;
    }

    public String getMaxSalaryPerMonth() {
        return maxSalaryPerMonth;
    }

    public void setMaxSalaryPerMonth(String maxSalaryPerMonth) {
        this.maxSalaryPerMonth = maxSalaryPerMonth;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public List<RevenueVO> getRevenueVOList() {
        return revenueVOList;
    }

    public void setRevenueVOList(List<RevenueVO> revenueVOList) {
        this.revenueVOList = revenueVOList;
    }

    public String getSocailBasic() {
        return socailBasic;
    }

    public void setSocailBasic(String socailBasic) {
        this.socailBasic = socailBasic;
    }

    public String getSocailPercent() {
        return socailPercent;
    }

    public void setSocailPercent(String socailPercent) {
        this.socailPercent = socailPercent;
    }

    public String getGjjBasic() {
        return gjjBasic;
    }

    public void setGjjBasic(String gjjBasic) {
        this.gjjBasic = gjjBasic;
    }

    public String getGjjPercent() {
        return gjjPercent;
    }

    public void setGjjPercent(String gjjPercent) {
        this.gjjPercent = gjjPercent;
    }

    public boolean isRevenueStartEnable() {
        return revenueStartEnable;
    }

    public void setRevenueStartEnable(boolean revenueStartEnable) {
        this.revenueStartEnable = revenueStartEnable;
    }

    public boolean isSocialEnable() {
        return socialEnable;
    }

    public void setSocialEnable(boolean socialEnable) {
        this.socialEnable = socialEnable;
    }

    public String getSocialSettingType() {
        return socialSettingType;
    }

    public void setSocialSettingType(String socialSettingType) {
        this.socialSettingType = socialSettingType;
    }

    public boolean isFundEnable() {
        return fundEnable;
    }

    public void setFundEnable(boolean fundEnable) {
        this.fundEnable = fundEnable;
    }

    public String getFundSettingType() {
        return fundSettingType;
    }

    public void setFundSettingType(String fundSettingType) {
        this.fundSettingType = fundSettingType;
    }
}
