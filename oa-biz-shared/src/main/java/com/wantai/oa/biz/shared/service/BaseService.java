/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.biz.shared.service;

import com.wantai.oa.common.dal.CommonDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 公共服务
 *
 * @author maping.mp
 * @version $Id: BaseService.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
public abstract class BaseService {

    /** 获取日志对象*/
    protected Logger              logger = Logger.getLogger(getClass());

    /** 事务模板类*/
    @Autowired
    protected TransactionTemplate transactionTemplate;

    @Autowired
    protected CommonDAO           commonDAO;

    /**
     * 公共服务类
     * @param bizCheck            业务检查接口
     * @param service             业务执行接口
     */
    public void service(BizCheck bizCheck, BizService service) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                bizCheck.bizCheck();
                service.execute();
            }
        });
    }
}
