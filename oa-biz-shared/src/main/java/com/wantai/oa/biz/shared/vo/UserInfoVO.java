package com.wantai.oa.biz.shared.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Desc: 简要信息
 * Date: 2016-01-12
 * Time: 下午 2:45
 * author: weiquan
 * Created by IntelliJ IDEA.
 */
public class UserInfoVO implements Serializable{

		private static final long serialVersionUID = 1L;
       	private Integer erp_user_id;//erp表中的 user id
       	private String loginname;//erp 表中的 登陆名称
       	private String code;//公司码
       	private List<UserRoleVO> role;//erp中的角色集合
       	private Long dealerid;//买家中心的 商家ID  做为数据冗余
       	private String dealername;//买家中心的 商家ID  做为数据冗余
       	private String name;//erp中的 用户名字
       	private List<UserMenuVO> oa_menu_tree;
       	private List<UserMenuVO> seller_menu_list;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getErp_user_id() {
		return erp_user_id;
	}

	public void setErp_user_id(Integer erp_user_id) {
		this.erp_user_id = erp_user_id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserRoleVO> getRole() {
		return role;
	}

	public void setRole(List<UserRoleVO> role) {
		this.role = role;
	}

	public Long getDealerid() {
		return dealerid;
	}

	public void setDealerid(Long dealerid) {
		this.dealerid = dealerid;
	}

	public String getDealername() {
		return dealername;
	}

	public void setDealername(String dealername) {
		this.dealername = dealername;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserMenuVO> getOa_menu_tree() {
		return oa_menu_tree;
	}

	public void setOa_menu_tree(List<UserMenuVO> oa_menu_tree) {
		this.oa_menu_tree = oa_menu_tree;
	}

	public List<UserMenuVO> getSeller_menu_list() {
		return seller_menu_list;
	}

	public void setSeller_menu_list(List<UserMenuVO> seller_menu_list) {
		this.seller_menu_list = seller_menu_list;
	}
}
