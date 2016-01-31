/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.impl;

import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.biz.shared.request.BaseRequest;
import com.wantai.oa.biz.shared.vo.BizBonusVO;
import com.wantai.oa.common.dal.CommonDAO;
import com.wantai.oa.common.dal.mappings.dos.performance.ConfigDo;
import com.wantai.oa.common.dal.mappings.dos.performance.SubConfigDo;
import com.wantai.oa.common.lang.enums.CustomerTypeEnum;
import com.wantai.oa.performance.common.request.BonusRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置服务
 *
 * @author maping.mp
 * @version $Id: BizConvertor.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class BizConvertor {

    @Autowired
    private CommonDAO commonDAO;

    /**
     * 将请求对象转转为子配置对象
     * @param request           请求对象
     * @return
     */
    public SubConfigDo convertRequest2SubConfig(BaseRequest request) {
        SubConfigDo subConfigDo = new SubConfigDo();
        subConfigDo.setBusinessConfigId(request.getBusinessConfigId());
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("configId", request.getBusinessConfigId());
        ConfigDo configDo = (ConfigDo) commonDAO.selectOne("Config.queryById", parameter);
        if (StringUtils.isBlank(request.getSubEventCode())) {
            subConfigDo.setSubEventCode(configDo.getBizEvent());
        } else {
            subConfigDo.setSubEventCode(request.getSubEventCode());
        }

        if (StringUtils.isBlank(request.getSubEventCodeName())) {
            subConfigDo.setSubEventCodeName(configDo.getBizEventName());
        } else {
            subConfigDo.setSubEventCodeName(request.getSubEventCodeName());

        }

        //如果客户类型为空,则默认为公司
        subConfigDo.setTarget(StringUtils.isBlank(request.getTarget()) ? CustomerTypeEnum.COMPANY
            .getCode() : request.getTarget());

        subConfigDo.setCustomerId(request.getCustomerId());
        subConfigDo.setValue(request.getValue());
        subConfigDo.setFromValue(request.getFromValue());
        subConfigDo.setToValue(request.getToValue());
        subConfigDo.setUnit(request.getUnit());
        subConfigDo.setEnable(request.isEnable() + "");
        subConfigDo.setOperator(UserHolder.getUser().getLoginName());
        subConfigDo.setLastModifiedOperator(UserHolder.getUser().getLoginName());
        return subConfigDo;
    }

    /**
     * 将岗位奖金配置对象转换为子配置对象
     * @param request               请求对象
     * @param config                业务请求对象
     * @return
     */
    public SubConfigDo convertBizBonus2SubConfig(BonusRequest request, BizBonusVO config) {
        SubConfigDo subConfigDo = new SubConfigDo();

        subConfigDo.setBusinessConfigId(config.getConfigId());
        ConfigDo configDo = (ConfigDo) commonDAO
            .selectOne("Config.queryById", config.getConfigId());
        subConfigDo.setSubEventCode(configDo.getBizEvent());
        subConfigDo.setSubEventCodeName(configDo.getBizEventName());

        //如果客户类型为空,则默认为公司
        subConfigDo.setTarget(request.getCustomerType());
        subConfigDo.setCustomerId(request.getCustomerId());

        if (StringUtils.equals(CustomerTypeEnum.COMPANY.getCode(), request.getCustomerType())) {
            subConfigDo.setValue(config.getCompanyValue());
            subConfigDo.setFromValue(config.getCompanyValue());
            subConfigDo.setToValue(config.getCompanyValue());
        } else {
            subConfigDo.setValue(config.getCustomValue());
            subConfigDo.setFromValue(config.getCustomValue());
            subConfigDo.setToValue(config.getCustomValue());
        }

        subConfigDo.setOrder(config.getOrder());
        subConfigDo.setUnit(config.getUnit());
        subConfigDo.setEnable(config.isEnable() + "");
        subConfigDo.setOperator(UserHolder.getUser().getLoginName());
        subConfigDo.setLastModifiedOperator(UserHolder.getUser().getLoginName());
        return subConfigDo;
    }
}
