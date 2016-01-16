/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.request;

import com.wantai.oa.biz.shared.request.BaseRequest;
import com.wantai.oa.biz.shared.vo.RevenueVO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 基础设置请求对象
 *
 * @author maping.mp
 * @version $Id: BasicRequest.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public class BasicRequest extends BaseRequest {

    /** 每月工龄工资 */
    @NotNull(message = "工龄工资不能为空")
    @NotEmpty(message = "工龄工资不能为空")
    @Digits(message = "工龄工资必须为数字", integer = 10, fraction = 2)
    private String          workYearSalary;

    /** 每月最大工龄工资*/
    @NotNull(message = "每月最大工龄工资不能为空")
    @NotEmpty(message = "每月最大工龄工资不能为空")
    @Digits(message = "每月最大工龄工资必须为数字", integer = 10, fraction = 2)
    private String          maxSalaryPerMonth = "1000";

    //~~~~~~~税率相关
    /** 个税起征点 */
    @NotNull(message = "起征点不能为空")
    @Min(value = 3500, message = "起征点必须大于${value}")
    private Integer         start             = 3500;

    /** 个税设置list*/
    private List<RevenueVO> revenueVOList;

    /** 社保基数*/
    @NotNull(message = "社保基数不能为空")
    @NotEmpty(message = "社保基数不能为空")
    @Digits(message = "社保基数必须为数字", integer = 10, fraction = 2)
    private String          socailBasic;

    /** 社保缴纳比例*/
    @NotNull(message = "社保缴纳比例不能为空")
    @NotEmpty(message = "社保缴纳比例不能为空")
    @Digits(message = "社保缴纳比例必须为数字", integer = 10, fraction = 2)
    private String          socailPercent;

    /** 公积金基数*/
    @NotNull(message = "公积金基数不能为空")
    @NotEmpty(message = "公积金基数不能为空")
    @Digits(message = "公积金基数必须为数字", integer = 10, fraction = 2)
    private String          gjjBasic;

    /** 公积金缴纳比例*/
    @NotNull(message = "公积金缴纳比例不能为空")
    @NotEmpty(message = "公积金缴纳比例不能为空")
    @Digits(message = "公积金缴纳比例必须为数字", integer = 10, fraction = 2)
    private String          gjjPercent;

    public String getMaxSalaryPerMonth() {
        return maxSalaryPerMonth;
    }

    public void setMaxSalaryPerMonth(String maxSalaryPerMonth) {
        this.maxSalaryPerMonth = maxSalaryPerMonth;
    }

    public String getWorkYearSalary() {
        return workYearSalary;
    }

    public void setWorkYearSalary(String workYearSalary) {
        this.workYearSalary = workYearSalary;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
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
}
