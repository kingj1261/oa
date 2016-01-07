/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.common.dal.mappings.dos.auth

import groovy.transform.ToString

/**
 * 用户角色对象
 * @author maping.mp
 * @version $Id: Role.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
@ToString
class Role implements Serializable{
    /** 角色id*/
    Integer id

    /** 角色名称*/
    String name

    /** 父角色编号*/
    Integer parentId
}