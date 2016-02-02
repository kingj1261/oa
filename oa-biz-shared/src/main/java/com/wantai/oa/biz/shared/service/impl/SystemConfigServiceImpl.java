/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.service.impl;

import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.service.SystemConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共配置服务类
 *
 * @author maping.mp
 * @version $Id: SystemConfigServiceImpl.java, v 0.1 2015-1-04 下午09:28:59 maping.mp Exp $
 */
@Service
public class SystemConfigServiceImpl extends BaseService implements SystemConfigService {

    @Override
    public Object getValue(String companyCode, String companyId, String key) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        parameter.put("key", key);
        return commonDAO.selectOne("SystemConfig.query", parameter);
    }

    @Override
    public boolean getBoolean(String companyCode, String companyId, String key) {
        String value = String.valueOf(getValue(companyCode, companyId, key));
        if (StringUtils.isNotBlank(value)) {
            return Boolean.parseBoolean(value);
        }
        throw new RuntimeException(String.format("数据库未配置值,companyCode=%s,companyId=%s,key=%s",
            companyCode, companyId, key));
    }

    @Override
    public String getString(String companyCode, String companyId, String key) {
        return String.valueOf(getValue(companyCode, companyId, key));
    }

    @Override
    public int getInt(String companyCode, String companyId, String key) {
        String value = String.valueOf(getValue(companyCode, companyId, key));
        if (StringUtils.isNotBlank(value)) {
            return Integer.parseInt(value);
        }
        throw new RuntimeException(String.format("数据库未配置值,companyCode=%s,companyId=%s,key=%s",
            companyCode, companyId, key));
    }

    @Override
    public void update(String companyCode, String companyId, String key, Object value) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        parameter.put("key", key);
        parameter.put("value", value == null ? "" : String.valueOf(value));
        commonDAO.update("SystemConfig.update", parameter);
    }
}
