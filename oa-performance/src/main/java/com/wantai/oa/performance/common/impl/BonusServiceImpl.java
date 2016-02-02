/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.impl;

import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.vo.BizBonusVO;
import com.wantai.oa.performance.common.BonusService;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.request.BonusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 岗位奖金/提成服务实现类
 *
 * @author maping.mp
 * @version $Id: BonusServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class BonusServiceImpl extends BaseService implements BonusService {

    /** 配置服务*/
    @Autowired
    private ConfigService configService;

    @Autowired
    private BizConvertor  bizConvertor;

    @Override
    public void addBonusConfig(BonusRequest request) {
        List<BizBonusVO> bizBonusVOList = request.getBizItems();
        bizBonusVOList.forEach(config -> {
            Long busConfigId = config.getConfigId();
            commonDAO.delete("SubConfig.deleteSubConfig", busConfigId);
            commonDAO.insert("SubConfig.addSubConfig",
                bizConvertor.convertBizBonus2SubConfig(request, config));
        });
    }
}
