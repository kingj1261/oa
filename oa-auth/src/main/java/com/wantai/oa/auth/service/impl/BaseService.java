package com.wantai.oa.auth.service.impl;

import com.wantai.oa.common.dal.CommonDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通用服务基类
 * Created by mapingmp on 16/1/3.
 */
public abstract class BaseService {

    @Autowired
    protected CommonDAO commonDAO;

    public void setCommonDAO(CommonDAO commonDAO) {
        this.commonDAO = commonDAO;
    }
}
