package com.wantai.oa.biz.shared.vo;

import java.util.List;

/**
 * Desc: 简要信息
 * Date: 2016-01-12
 * Time: 下午 2:54
 * author: weiquan
 * Created by IntelliJ IDEA.
 */
public class UserMenuVO {
    /**
    	 *
    	 */
    	private static final long serialVersionUID = 1L;

    	/*private Integer menuId;//菜单id
    	private Integer menuPid;//菜单父id
    	private String name;//菜单名称
    	private String uri;//菜单地址
    */
    	/*"id" : "7",
    	"pid" : "0",
    	"name" : "\u7ee9\u6548\u4e2d\u5fc3",
    	"sort" : "3",
    	"url" : "\/Performance\/index",
    	"menu_source" : "1",
    	"status" : "0",
    	"is_show" : "1",
    	"is_flow" : "0",
    	"expanded" : false,
    	"leaf" : true
    	"children" : [{*/

    	private Integer id;
    	private Integer pid;
    	private String name;
    	private String sort;
    	private String url;
    	private String menu_source;
    	private String status;
    	private String is_show;
    	private String is_flow;
    	private Boolean expanded;
    	private Boolean leaf;
    	private	List<UserMenuVO> children;

    	public String getSort() {
    		return sort;
    	}
    	public void setSort(String sort) {
    		this.sort = sort;
    	}
    	public String getUrl() {
    		return url;
    	}
    	public void setUrl(String url) {
    		this.url = url;
    	}
    	public String getMenu_source() {
    		return menu_source;
    	}
    	public void setMenu_source(String menu_source) {
    		this.menu_source = menu_source;
    	}
    	public String getStatus() {
    		return status;
    	}
    	public void setStatus(String status) {
    		this.status = status;
    	}
    	public String getIs_show() {
    		return is_show;
    	}
    	public void setIs_show(String is_show) {
    		this.is_show = is_show;
    	}
    	public String getIs_flow() {
    		return is_flow;
    	}
    	public void setIs_flow(String is_flow) {
    		this.is_flow = is_flow;
    	}
    	public Boolean getExpanded() {
    		return expanded;
    	}
    	public void setExpanded(Boolean expanded) {
    		this.expanded = expanded;
    	}
    	public Boolean getLeaf() {
    		return leaf;
    	}
    	public void setLeaf(Boolean leaf) {
    		this.leaf = leaf;
    	}
    	public List<UserMenuVO> getChildren() {
    		return children;
    	}
    	public void setChildren(List<UserMenuVO> children) {
    		this.children = children;
    	}
    	public String getName() {
    		return name;
    	}
    	public void setName(String name) {
    		this.name = name;
    	}
    	public Integer getPid() {
    		return pid;
    	}
    	public void setPid(Integer pid) {
    		this.pid = pid;
    	}
    	public Integer getId() {
    		return id;
    	}
    	public void setId(Integer id) {
    		this.id = id;
    	}
}
