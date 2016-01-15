/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common;

import com.wantai.oa.biz.shared.request.BaseRequest;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.biz.shared.vo.SubBizEventVO;

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
     * @param busConfigId
     * @param requestList   请求参数
     */
    void addConfig(Long busConfigId, List<? extends BaseRequest> requestList);

    /**
     * 根据配置类型查询所有的配置对象
     * @param companyCode           公司code
     * @param companyId             公司id
     * @param configType            配置类型key
     * @param loadAllEvents         是否加载所有子配置数据
     * @param bizItem               是否加载所有子配置数据
     * @return                      配置结果
     */
    ConfigVO queryConfigs(String companyCode, int companyId, String configType,
                          boolean loadAllEvents, String bizItem);

    /**
     * 根据主表id查询子表配置数据
     * @param mainConfigId  主表配置id
     * @return              子表数据集合
     */
    List<SubBizEventVO> querySubEventsVo(Long mainConfigId);
}
