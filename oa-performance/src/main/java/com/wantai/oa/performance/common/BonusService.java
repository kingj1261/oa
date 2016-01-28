/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common;

import com.wantai.oa.performance.common.request.BonusRequest;

/**
 * 岗位奖金/提成服务
 *
 * @author maping.mp
 * @version $Id: BonusService.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public interface BonusService {

    /**
     * 新增配置对象
     * @param request       请求参数
     */
    void addBonusConfig(BonusRequest request);
}
