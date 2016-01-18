package com.wantai.oa.biz.shared.vo;

import java.io.Serializable;

/**
 * Desc: 简要信息
 * Date: 2016-01-12
 * Time: 下午 2:58
 * author: weiquan
 * Created by IntelliJ IDEA.
 */
public class UserRoleVO implements Serializable{
    private static final long serialVersionUID = 1L;

    	private Integer roleid;//角色id

    	private String rolename;//角色名称

    	public Integer getRoleid() {
    		return roleid;
    	}

    	public void setRoleid(Integer roleid) {
    		this.roleid = roleid;
    	}

    	public String getRolename() {
    		return rolename;
    	}

    	public void setRolename(String rolename) {
    		this.rolename = rolename;
    	}

}
