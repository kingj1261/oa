/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.impl;

import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.service.Executable;
import com.wantai.oa.biz.shared.vo.BizEventVO;
import com.wantai.oa.biz.shared.vo.BizItemVO;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.common.dal.mappings.dos.performance.ConfigDo;
import com.wantai.oa.common.dal.mappings.dos.performance.SubConfigDo;
import com.wantai.oa.performance.common.ConfigService;
import com.wantai.oa.performance.common.request.ConfigRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 配置服务
 *
 * @author maping.mp
 * @version $Id: ConfigServiceImpl.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@Service
public class ConfigServiceImpl extends BaseService implements ConfigService {

    @Override
    public void addConfig(List<ConfigRequest> configRequests) {
        operate(
            configRequests,
            request -> commonDAO.insert("SubConfig.addSubConfig",
                convert(request, new SubConfigDo())));
    }

    /**
     * 通用配置处理模板方法
     * @param configRequests            配置对象
     * @param callback                  回调接口
     */
    private void operate(List<ConfigRequest> configRequests, Executable<ConfigRequest> callback) {
        final int[] rowIndex = { 1 };
        Assert.notNull(configRequests, "请求参数列表不能为空");
        configRequests.forEach(request -> {
            service(() -> {
                Assert.hasText(request.getFromValue(), message("第[%d]行开始值不能为空", rowIndex[0]));
                Assert.hasText(request.getToValue(), message("第[%d]行结束值不能为空", rowIndex[0]));
                Assert.hasText(request.getValue(), message("第[%d]行目标值不能为空", rowIndex[0]));
            }, () -> callback.execute(request));
            rowIndex[0]++;
        });
    }

    private Object convert(ConfigRequest request, SubConfigDo subConfigDo) {
        subConfigDo.setId(request.getId());
        subConfigDo.setBusinessConfigId(request.getBusinessConfigId());
        subConfigDo.setSubEventCode(request.getSubEventCode());
        subConfigDo.setValue(request.getValue());
        subConfigDo.setFromValue(request.getFromValue());
        subConfigDo.setToValue(request.getToValue());
        subConfigDo.setUnit(request.getUnit());
        subConfigDo.setOperator(request.getOperator());
        subConfigDo.setLastModifiedOperator(request.getLastModifiedOperator());
        return subConfigDo;
    }

    private String message(String message, int rowIndex) {
        return String.format(message, rowIndex);
    }

    @Override
    public void update(List<ConfigRequest> configRequests) {
        operate(
            configRequests,
            request -> commonDAO.update("SubConfig.updateSubConfig",
                convert(request, new SubConfigDo())));
    }

    @Override
    public void delete(List<ConfigRequest> configRequests) {
        operate(
            configRequests,
            request -> commonDAO.delete("SubConfig.deleteSubConfig",
                convert(request, new SubConfigDo())));
    }

    @Override
    public List<ConfigVO> queryConfigs(String companyCode, int companyId, String configType) {
        Assert.hasText(companyCode, "公司码不能为空");
        Assert.notNull(companyId, "公司id不能为空");
        Assert.hasText(configType, "配置类型不能为空");

        List<ConfigDo> configDoList = getConfigDoList(companyCode, companyId, configType);
        if (CollectionUtils.isEmpty(configDoList)) {
            return Collections.emptyList();
        }

        List<ConfigVO> configs = new ArrayList<>();
        ConfigVO configVO = new ConfigVO();
        Set<BizItemVO> items = new HashSet<>();

        configDoList.forEach(configDo -> {
            configVO.setConfigType(configDo.getConfigType());
            BizItemVO itemVO = new BizItemVO();

            itemVO.setBizItem(configDo.getBizItem());
            itemVO.setBizItemName(configDo.getBizItemName());
            itemVO.setOrder(configDo.getBizItemOrder());

            items.add(itemVO);
        });

        items.forEach(item -> {
            List<ConfigDo> events = configDoList.stream()
                .filter(config -> StringUtils.equals(item.getBizItem(), config.getBizItem()))
                .collect(Collectors.toList());

            List<BizEventVO> eventVOs = new ArrayList<>(events.size());
            events.forEach(event -> {
                BizEventVO eventVO = new BizEventVO();
                eventVO.setBizEvent(event.getBizEvent());
                eventVO.setBizEventName(event.getBizEventName());
                eventVO.setOrder(event.getBizEventOrder());
                eventVOs.add(eventVO);
            });

            item.setBizEvents(eventVOs);
        });

        configVO.setBizItems(items);
        configs.add(configVO);
        return configs;
    }

    private List<ConfigDo> getConfigDoList(String companyCode, int companyId, String configType) {
        Map<String, Object> paramter = new HashMap<>();
        paramter.put("companyCode", companyCode);
        paramter.put("companyId", companyId);
        paramter.put("configType", configType);
        return (List<ConfigDo>) commonDAO.findAll("Config.queryConfigs", paramter);
    }
}
