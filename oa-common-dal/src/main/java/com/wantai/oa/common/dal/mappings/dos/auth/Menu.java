/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.auth;

import java.io.Serializable;

/**
 * 权限菜单对象
 *
 * @author maping.mp
 * @version $Id: Menu.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
public class Menu implements Serializable {

    /**
     * 菜单编号
     */
    Integer id;

    /**
     * 菜单名称
     */
    String title;

    /**
     * 菜单链接
     */
    String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}