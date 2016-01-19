/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.auth;

import java.io.Serializable;

/**
 * 用户角色对象
 * @author maping.mp
 * @version $Id: Role.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class Role implements Serializable {
    /** 角色id*/
    Integer id;

    /** 角色名称*/
    String  name;

    /** 父角色编号*/
    Integer parentId;

    /** 角色编码*/
    String  code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}