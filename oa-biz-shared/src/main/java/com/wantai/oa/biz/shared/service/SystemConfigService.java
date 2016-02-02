/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.service;

/**
 * 公共配置服务类
 *
 * @author maping.mp
 * @version $Id: SystemConfigService.java, v 0.1 2015-1-04 下午09:28:59 maping.mp Exp $
 */
public interface SystemConfigService {

    /**
     * 查询配置数据
     * @param companyCode       公司码
     * @param companyId         公司id
     * @param key               key
     * @return                  配置的值
     */
    Object getValue(String companyCode, String companyId, String key);

    /**
     * 查询配置boolean数据
     * @param companyCode       公司码
     * @param companyId         公司id
     * @param key               key
     * @return                  配置的值
     */
    boolean getBoolean(String companyCode, String companyId, String key);

    /**
     * 查询配置数据
     * @param companyCode       公司码
     * @param companyId         公司id
     * @param key               key
     * @return                  配置的值
     */
    String getString(String companyCode, String companyId, String key);

    /**
     * 查询配置数据
     * @param companyCode       公司码
     * @param companyId         公司id
     * @param key               key
     * @return                  配置的值
     */
    int getInt(String companyCode, String companyId, String key);

    /**
     * 更新配置数据
     * @param companyCode       公司码
     * @param companyId         公司id
     * @param key               key
     * @param value             实际值
     */
    void update(String companyCode, String companyId, String key, Object value);

}
