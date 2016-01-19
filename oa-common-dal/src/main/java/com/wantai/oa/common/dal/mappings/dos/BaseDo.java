/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础DO对象
 * @author maping.mp
 * @version $Id: BaseDo.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class BaseDo implements Serializable {
    /** 逻辑主键id */
    Long   id;

    /** 公司码 */
    String companyCode;

    /** 公司id */
    String companyId;

    /** 备注 */
    String memo;

    /** 操作员 */
    String operator;

    /** 最后一次修改操作员 */
    String lastModifiedOperator;

    /** 创建日期 */
    Date   gmtCreate;

    /** 最后一次修改日期 */
    Date   gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLastModifiedOperator() {
        return lastModifiedOperator;
    }

    public void setLastModifiedOperator(String lastModifiedOperator) {
        this.lastModifiedOperator = lastModifiedOperator;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BaseDo baseDo = (BaseDo) o;

        if (id != null ? !id.equals(baseDo.id) : baseDo.id != null)
            return false;
        if (companyCode != null ? !companyCode.equals(baseDo.companyCode)
            : baseDo.companyCode != null)
            return false;
        return !(companyId != null ? !companyId.equals(baseDo.companyId) : baseDo.companyId != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyCode != null ? companyCode.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        return result;
    }
}
