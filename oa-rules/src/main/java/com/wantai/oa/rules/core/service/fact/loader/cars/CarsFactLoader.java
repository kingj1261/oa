/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.fact.loader.cars;

import com.wantai.oa.common.dal.CommonDAO;
import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import com.wantai.oa.rules.core.service.fact.loader.FactLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆用途事实加载器
 * @author maping.mp
 * @version $Id: CarsFactLoader.java, v 0.1 2015-1-04 下午09:28:59 maping.mp Exp $
 */
@Service("carsFactLoader")
public class CarsFactLoader implements FactLoader {

    @Autowired
    private CommonDAO commonDAO;

    @Override
    public List load(RuleDo ruleDo) {
        return null;
    }
}
