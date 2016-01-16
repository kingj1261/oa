/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common;

import com.wantai.oa.biz.shared.vo.BasicConfigVO;
import com.wantai.oa.performance.common.request.BasicRequest;

/**
 * 配置服务
 *
 * @author maping.mp
 * @version $Id: BasicService.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public interface BasicService {

    /**
     * 新增基础配置
     * @param request
     */
    void addBasicConfig(BasicRequest request);

    /**
     * 更新子配置表数据(此方法不具备事务,必须在事务中调用)
     * @param customerId            客户编号
     * @param businessConfigId      主配置表id
     * @param subEventCode          子业务事件编码
     * @param value                 当前更新的值
     */
    void updateSubConfig(String customerId, String businessConfigId, String subEventCode,
                         String value);

    /**
     * 更新子配置表数据(此方法不具备事务,必须在事务中调用)
     * @param customerId            客户编号
     * @param businessConfigId      主配置表id
     * @param subEventCode          子业务事件编码
     * @param value                 当前更新的值
     * @param toValue               结束值
     */
    void updateSubConfig(String customerId, String businessConfigId, String subEventCode,
                         String value, String toValue);

    /**
     * 根据公司查询其公共设置
     * @param companyCode           公司码
     * @param companyId             公司id
     * @return                      公司公共配置对象
     */
    BasicConfigVO queryBasicConfig(String companyCode, String companyId);

}
