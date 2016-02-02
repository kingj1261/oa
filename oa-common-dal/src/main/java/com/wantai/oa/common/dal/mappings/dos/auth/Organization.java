/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.auth;

public class Organization {
    /* INTEGER(10)- */
    private Integer id;

    /* VARCHAR(50)-账户名称 */
    private String  accountName;

    /* INTEGER(10)-父ID */
    private Integer pid;

    /* INTEGER(10)-公司父id */
    private Integer cid;

    /* VARCHAR(30)-组织机构名称 */
    private String  name;

    /* CHAR(64)-拼音简码 */
    private String  jm;

    /* BIT(0)-组织机构类型（1，公司   2，部门） */
    private Boolean type;

    /* VARCHAR(20)-法人代表 */
    private String  lawPerson;

    /* VARCHAR(20)-经营范围 */
    private String  businessScope;

    /* VARCHAR(100)-企业网址 */
    private String  website;

    /* CHAR(50)-开户银行 */
    private String  openBank;

    /* CHAR(11)-手机号码 */
    private String  mobilePhone;

    /* VARCHAR(20)-固定电话（座机） */
    private String  fixedPhone;

    /* VARCHAR(50)-账号 */
    private String  account;

    /* VARCHAR(100)-地址 */
    private String  address;

    /* VARCHAR(11)-集团公司码 */
    private String  companyCode;

    /* BIT(0)-是否是集团总公司1：是，0：不是 */
    private Boolean isHead;

    /* VARCHAR(100)-备注 */
    private String  remark;

    /* INTEGER(10)-创建人 */
    private Integer createPerson;

    /* INTEGER(10)-创建时间 */
    private Integer createTime;

    /* INTEGER(10)-修改人 */
    private Integer updatePerson;

    /* INTEGER(10)-修改时间 */
    private Integer updateTime;

    /* BIT(0)-是否删除  0未删除     1删除 */
    private Boolean isDel;

    /* getter of attribute id */
    public Integer getId() {
        return id;
    }

    /* setter of attribute id */
    public void setId(Integer id) {
        this.id = id;
    }

    /* getter of attribute accountName */
    public String getAccountName() {
        return accountName;
    }

    /* setter of attribute accountName */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /* getter of attribute pid */
    public Integer getPid() {
        return pid;
    }

    /* setter of attribute pid */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /* getter of attribute cid */
    public Integer getCid() {
        return cid;
    }

    /* setter of attribute cid */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /* getter of attribute name */
    public String getName() {
        return name;
    }

    /* setter of attribute name */
    public void setName(String name) {
        this.name = name;
    }

    /* getter of attribute jm */
    public String getJm() {
        return jm;
    }

    /* setter of attribute jm */
    public void setJm(String jm) {
        this.jm = jm;
    }

    /* getter of attribute type */
    public Boolean getType() {
        return type;
    }

    /* setter of attribute type */
    public void setType(Boolean type) {
        this.type = type;
    }

    /* getter of attribute lawPerson */
    public String getLawPerson() {
        return lawPerson;
    }

    /* setter of attribute lawPerson */
    public void setLawPerson(String lawPerson) {
        this.lawPerson = lawPerson;
    }

    /* getter of attribute businessScope */
    public String getBusinessScope() {
        return businessScope;
    }

    /* setter of attribute businessScope */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    /* getter of attribute website */
    public String getWebsite() {
        return website;
    }

    /* setter of attribute website */
    public void setWebsite(String website) {
        this.website = website;
    }

    /* getter of attribute openBank */
    public String getOpenBank() {
        return openBank;
    }

    /* setter of attribute openBank */
    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    /* getter of attribute mobilePhone */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /* setter of attribute mobilePhone */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /* getter of attribute fixedPhone */
    public String getFixedPhone() {
        return fixedPhone;
    }

    /* setter of attribute fixedPhone */
    public void setFixedPhone(String fixedPhone) {
        this.fixedPhone = fixedPhone;
    }

    /* getter of attribute account */
    public String getAccount() {
        return account;
    }

    /* setter of attribute account */
    public void setAccount(String account) {
        this.account = account;
    }

    /* getter of attribute address */
    public String getAddress() {
        return address;
    }

    /* setter of attribute address */
    public void setAddress(String address) {
        this.address = address;
    }

    /* getter of attribute companyCode */
    public String getCompanyCode() {
        return companyCode;
    }

    /* setter of attribute companyCode */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /* getter of attribute isHead */
    public Boolean getIsHead() {
        return isHead;
    }

    /* setter of attribute isHead */
    public void setIsHead(Boolean isHead) {
        this.isHead = isHead;
    }

    /* getter of attribute remark */
    public String getRemark() {
        return remark;
    }

    /* setter of attribute remark */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /* getter of attribute createPerson */
    public Integer getCreatePerson() {
        return createPerson;
    }

    /* setter of attribute createPerson */
    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    /* getter of attribute createTime */
    public Integer getCreateTime() {
        return createTime;
    }

    /* setter of attribute createTime */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /* getter of attribute updatePerson */
    public Integer getUpdatePerson() {
        return updatePerson;
    }

    /* setter of attribute updatePerson */
    public void setUpdatePerson(Integer updatePerson) {
        this.updatePerson = updatePerson;
    }

    /* getter of attribute updateTime */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /* setter of attribute updateTime */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    /* getter of attribute isDel */
    public Boolean getIsDel() {
        return isDel;
    }

    /* setter of attribute isDel */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}