/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package  com.wantai.oa.common.dal.mappings.dos.auth

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * 用户信息
 * @author maping.mp
 * @version $Id: User.groovy, v 0.1 2015-1-04 下午09:36:49 maping.mp Exp $
 */
@ToString
@EqualsAndHashCode(includes = ["id"])
class User implements Serializable{

    /** 用户编号*/
    Integer id

    /** 用户名称*/
    String name

    /** 用户登录名称*/
    String loginName

    /** 登陆密码*/
    String password
}