/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common;

import com.wantai.oa.biz.shared.request.BaseRequest;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.biz.shared.vo.SubBizEventVO;
import com.wantai.oa.common.dal.mappings.dos.performance.ConfigDo;
import com.wantai.oa.common.dal.mappings.dos.performance.SubConfigDo;

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
     * @param mainConfigId          主表配置id
     * @return                      子表数据集合
     */
    List<SubBizEventVO> querySubEventsVo(Long mainConfigId);

    /**
     * 根据业务事项事件查询子配置数据
     * @param companyCode           公司code
     * @param companyId             公司id
     * @param bizItem               业务事项编号
     * @param bizEvent              事件编号
     * @param subEventCode          子事件编号
     * @param customerId            客户id
     * @return                      单条子事件配置数据
     */
    SubConfigDo querySingleSubConfig(String companyCode, String companyId, String bizItem,
                                     String bizEvent, String subEventCode, String customerId);

    /**
     * 根据参数查询配置数据
     * @param companyCode           公司code
     * @param companyId             公司id
     * @param bizItem               业务事项编号
     * @param bizEvent              事件编号
     * @return                      查询数据对象
     */
    ConfigDo queryConfig(String companyCode, String companyId, String bizItem, String bizEvent);

    /**
     * 根据参数查询配置数据
     * @param companyCode           公司code
     * @param companyId             公司id
     * @param configType            配置类型
     * @param bizItem               业务事项编号
     * @param bizEvent              事件编号
     * @return                      查询数据对象
     */
    ConfigDo queryConfig(String companyCode, String companyId, String configType, String bizItem,
                         String bizEvent);

    /**
     * 根据当前data值和业务事项事件配置的数据区间定为到最终得分
     *
     * @param configType            配置类型
     * @param companyCode           公司code
     * @param companyId             公司id
     * @param bizItem               业务事项
     * @param bizEvent              业务事件
     * @param data                  当前实际数据值
     * @param customerId            用户id
     * @return                      配置的最终得分
     */
    String getConfigValue(String configType, String companyCode, String companyId, String bizItem,
                          String bizEvent, String data, String customerId);

    /**
     * 新增系数计算流水
     *
     * @param configType            配置类型
     * @param companyCode           公司code
     * @param companyId             公司id
     * @param bizItem               业务事项
     * @param bizEvent              业务事件
     * @param data                  当前实际数据值
     * @param customerId            客户编号
     * @return                      配置的最终得分
     */
    void addRatioDetail(String configType, String companyCode, String companyId, String bizItem,
                        String bizEvent, String data, String customerId);

}
