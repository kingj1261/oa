package com.wantai.oa.biz.shared.vo;

import javax.xml.crypto.Data;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Desc: 封装的查询工资条信息的查询对象
 * Date: 2016-01-18
 * Time: 上午 12:34
 * author: weiquan
 * Created by IntelliJ IDEA.
 */
public class SalaryDetailQueryObjectVO implements Serializable{
    private String customerNameKey;
    private String realGrantTimeStart;
    private String realGrantTimeEnd;
    private BigDecimal lowGrossSalary;
    private BigDecimal topGrossSalary;
    private int page = 1;
    private int rows = 10;
	
    public int getPage() {
    	return page;
    }
	
    public void setPage(int page) {
    	this.page = page;
    }

	
    public int getRows() {
    	return rows;
    }

	
    public void setRows(int rows) {
    	this.rows = rows;
    }

	public String getCustomerNameKey() {
        return customerNameKey;
    }

    public void setCustomerNameKey(String customerNameKey) {
        this.customerNameKey = customerNameKey;
    }
    
    public String getRealGrantTimeStart() {
    	return realGrantTimeStart;
    }

	
    public void setRealGrantTimeStart(String realGrantTimeStart) {
    	this.realGrantTimeStart = realGrantTimeStart;
    }

	
    public String getRealGrantTimeEnd() {
    	return realGrantTimeEnd;
    }

	
    public void setRealGrantTimeEnd(String realGrantTimeEnd) {
    	this.realGrantTimeEnd = realGrantTimeEnd;
    }

	public BigDecimal getLowGrossSalary() {
        return lowGrossSalary;
    }

    public void setLowGrossSalary(BigDecimal lowGrossSalary) {
        this.lowGrossSalary = lowGrossSalary;
    }

    public BigDecimal getTopGrossSalary() {
        return topGrossSalary;
    }

    public void setTopGrossSalary(BigDecimal topGrossSalary) {
        this.topGrossSalary = topGrossSalary;
    }
}
