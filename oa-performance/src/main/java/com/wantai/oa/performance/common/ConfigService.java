/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common;

import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.performance.common.request.ConfigRequest;

import java.util.List;

/**
 * 配置服务
 *
 * @author maping.mp
 * @version $Id: ConfigService.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public interface ConfigService {

    /**
     * 新增配置对象
     * @param requestList   请求参数
     */
    void addConfig(List<ConfigRequest> requestList);

    /**
     * 更新配置对象
     * @param requestList   请求参数
     */
    void update(List<ConfigRequest> requestList);

    /**
     * 删除配置对象
     * @param requestList   请求参数
     */
    void delete(List<ConfigRequest> requestList);

    /**
     * 根据配置类型查询所有的配置对象
     * @param companyCode   公司code
     * @param companyId     公司id
     * @param configType    配置类型key
     * @return              配置结果
     */
    List<ConfigVO> queryConfigs(String companyCode, int companyId, String configType);
}
