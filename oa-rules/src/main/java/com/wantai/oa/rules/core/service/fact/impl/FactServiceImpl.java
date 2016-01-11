/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.fact.impl;

import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import com.wantai.oa.rules.core.service.fact.FactService;
import com.wantai.oa.rules.core.service.fact.loader.FactLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 事实数据服务实现类
 * @author maping.mp
 * @version $Id: FactServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class FactServiceImpl extends BaseService implements FactService {

    @Autowired
    private FactLoader factLoader;

    @Override
    public List loadFactDatas(RuleDo ruleDo) {
        return factLoader.load(ruleDo);
    }
}
