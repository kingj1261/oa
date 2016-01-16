/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.performance.common.impl;

import com.wantai.oa.auth.core.UserHolder;
import com.wantai.oa.biz.shared.request.BaseRequest;
import com.wantai.oa.biz.shared.service.BaseService;
import com.wantai.oa.biz.shared.vo.BizEventVO;
import com.wantai.oa.biz.shared.vo.BizItemVO;
import com.wantai.oa.biz.shared.vo.ConfigVO;
import com.wantai.oa.biz.shared.vo.SubBizEventVO;
import com.wantai.oa.common.dal.mappings.dos.performance.ConfigDo;
import com.wantai.oa.common.dal.mappings.dos.performance.SubConfigDo;
import com.wantai.oa.common.lang.enums.CustomerTypeEnum;
import com.wantai.oa.performance.common.ConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
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
    public void addConfig(Long busConfigId, List<? extends BaseRequest> requests) {
        execute(() -> {
            commonDAO.delete("SubConfig.deleteSubConfig", busConfigId);
            requests.forEach(request -> {
                commonDAO.insert("SubConfig.addSubConfig", convert(request, new SubConfigDo()));
            });
        });
    }

    private Object convert(BaseRequest request, SubConfigDo subConfigDo) {
        subConfigDo.setBusinessConfigId(request.getBusinessConfigId());
        ConfigDo configDo = (ConfigDo) commonDAO.selectOne("Config.queryById", request);
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
        subConfigDo.setOperator(UserHolder.getUser().getLoginName());
        subConfigDo.setLastModifiedOperator(UserHolder.getUser().getLoginName());
        return subConfigDo;
    }

    @Override
    public ConfigVO queryConfigs(String companyCode, int companyId, String configType,
                                 boolean loadAllEvent, String bizItem) {
        Assert.hasText(companyCode, "公司码不能为空");
        Assert.notNull(companyId, "公司id不能为空");
        Assert.hasText(configType, "配置类型不能为空");

        List<ConfigDo> configDoList = getConfigDoList(companyCode, companyId, configType);
        if (CollectionUtils.isEmpty(configDoList)) {
            return new ConfigVO();
        }

        ConfigVO configVO = new ConfigVO();
        Set<BizItemVO> items = new TreeSet(new Comparator<BizItemVO>() {
            @Override
            public int compare(BizItemVO first, BizItemVO next) {
                return first.getOrder() - next.getOrder() < 0 ? -1 : (first.getOrder()
                                                                      - next.getOrder() == 0 ? 0
                    : 1);
            }
        });

        configDoList.forEach(configDo -> {
            configVO.setConfigType(configDo.getConfigType());
            BizItemVO itemVO = new BizItemVO();

            //如果指定了具体的业务事项事件
            if (StringUtils.isNotBlank(bizItem)) {

                //只有匹配了指定的业务事项时
                if (StringUtils.equals(configDo.getBizItem(), bizItem)) {
                    itemVO.setBizItem(configDo.getBizItem());
                    itemVO.setBizItemName(configDo.getBizItemName());
                    itemVO.setOrder(configDo.getBizItemOrder());
                    items.add(itemVO);
                }
            }
            //未指定业务事项事件,返回全部的业务事项集合
            else {
                itemVO.setBizItem(configDo.getBizItem());
                itemVO.setBizItemName(configDo.getBizItemName());
                itemVO.setOrder(configDo.getBizItemOrder());
                items.add(itemVO);
            }
        });

        // 是否加载子事件
        if (loadAllEvent) {
            items.forEach(item -> {
                List<ConfigDo> events = configDoList.stream()
                    .filter(config -> StringUtils.equals(item.getBizItem(), config.getBizItem()))
                    .collect(Collectors.toList());
                List<BizEventVO> eventVOs = new ArrayList<>(events.size());
                events.forEach(event -> {
                    BizEventVO eventVO = new BizEventVO();
                    eventVO.setConfigId(event.getId());
                    eventVO.setBizItem(event.getBizItem());
                    eventVO.setBizEvent(event.getBizEvent());
                    eventVO.setBizEventName(event.getBizEventName());
                    eventVO.setOrder(event.getBizEventOrder());
                    eventVO.setEnable(Boolean.parseBoolean(event.getEnable()));
                    eventVO.setUnit(event.getUnit());
                    eventVO.setSubEventList(querySubEventsVo(event.getId()));
                    eventVOs.add(eventVO);
                });
                eventVOs.sort(Comparator.comparing(BizEventVO::getOrder));
                item.setBizEvents(eventVOs);
            });
        }
        configVO.setBizItems(items);
        return configVO;
    }

    /**
     * 查询子事件集合
     * @param id
     * @return
     */
    @Override
    public List<SubBizEventVO> querySubEventsVo(Long id) {
        List<SubConfigDo> subConfigs = querySubConfigDOList(id);
        List<SubBizEventVO> eventList = new ArrayList<>();
        if (subConfigs != null) {
            subConfigs.forEach(config -> {
                SubBizEventVO event = new SubBizEventVO();
                event.setId(config.getId());
                event.setSubEventCode(config.getSubEventCode());
                event.setSubEventCodeName(config.getSubEventCodeName());
                event.setOrder(config.getOrder());
                event.setFromValue(config.getFromValue());
                event.setToValue(config.getToValue());
                event.setValue(config.getValue());
                event.setBusinessConfigId(config.getBusinessConfigId());
                event.setUnit(config.getUnit());
                event.setTarget(config.getTarget());
                event.setCustomerId(config.getCustomerId());
                eventList.add(event);
            });
        }
        eventList.sort(Comparator.comparing(SubBizEventVO::getOrder));
        return eventList;
    }

    @Override
    public SubConfigDo querySingleSubConfig(String companyCode, String companyId, String bizItem,
                                            String bizEvent, String subEventCode, String customerId) {
        Map<String, Object> parameter = new HashMap();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        parameter.put("bizItem", bizItem);
        parameter.put("bizEvent", bizEvent);
        parameter.put("subEventCode", subEventCode);
        String target = CustomerTypeEnum.COMPANY.getCode();
        if (StringUtils.isNotBlank(customerId)) {
            target = CustomerTypeEnum.CUSTOMER.getCode();
        }
        parameter.put("target", target);
        parameter.put("customerId", customerId);
        return (SubConfigDo) commonDAO.selectOne("SubConfig.querySingleSubConfig", parameter);
    }

    @Override
    public ConfigDo queryConfig(String companyCode, String companyId, String bizItem,
                                String bizEvent) {
        Map<String, Object> parameter = new HashMap();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        parameter.put("bizItem", bizItem);
        parameter.put("bizEvent", bizEvent);
        return (ConfigDo) commonDAO.selectOne("Config.querySingleConfig", parameter);
    }

    private List<SubConfigDo> querySubConfigDOList(Long mainConfigId) {
        Map<String, Object> paramter = new HashMap<>();
        paramter.put("mainConfigId", mainConfigId);
        return (List<SubConfigDo>) commonDAO.findAll("SubConfig.querySubConfigs", paramter);
    }

    private List<ConfigDo> getConfigDoList(String companyCode, int companyId, String configType) {
        Map<String, Object> paramter = new HashMap<>();
        paramter.put("companyCode", companyCode);
        paramter.put("companyId", companyId);
        paramter.put("configType", configType);
        return (List<ConfigDo>) commonDAO.findAll("Config.queryConfigs", paramter);
    }
}
