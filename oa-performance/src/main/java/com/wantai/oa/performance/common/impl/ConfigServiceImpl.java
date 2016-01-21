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
import com.wantai.oa.common.dal.mappings.dos.performance.RatioDetailDo;
import com.wantai.oa.common.dal.mappings.dos.performance.SubConfigDo;
import com.wantai.oa.common.lang.constants.Constants;
import com.wantai.oa.common.lang.enums.ConfigTypeEnum;
import com.wantai.oa.common.lang.enums.CustomerTypeEnum;
import com.wantai.oa.common.lang.enums.ErrorCodeEnum;
import com.wantai.oa.common.lang.enums.UnitEnum;
import com.wantai.oa.common.lang.exception.CommonException;
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
import java.util.Optional;
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

    @Override
    public String getConfigValue(String configType, String companyCode, String companyId,
                                 String bizItem, String bizEvent, String data, String userId) {
        Map<String, Object> parameter = new HashMap();
        parameter.put("companyCode", companyCode);
        parameter.put("companyId", companyId);
        parameter.put("configType", configType);
        parameter.put("bizItem", bizItem);
        parameter.put("bizEvent", bizEvent);

        List<SubConfigDo> subConfigs = (List<SubConfigDo>) commonDAO.findAll(
            "SubConfig.findAllSubConfig", parameter);
        Assert.notEmpty(subConfigs, "业务事项(" + bizItem + "," + bizEvent + ")子项配置为空!");

        ConfigTypeEnum type = ConfigTypeEnum.getByCode(configType.toUpperCase());
        if (type == null) {
            throw new CommonException(ErrorCodeEnum.RULE_ERROR_NOT_SUPPORT_CONFIG_TYPE);
        }

        StringBuilder value = new StringBuilder();

        // 岗位系数计算公式为当前用户完成指标情况获取已配置好的区间系数值
        if (type == ConfigTypeEnum.GWXS) {
            value.append(getGwxs(data, subConfigs));
        }

        // 岗位奖金和岗位提成,计算公式为当前用户完成指标数*单价
        if (type == ConfigTypeEnum.GWJJ || type == ConfigTypeEnum.GWTC) {
            value.append(getGwjjOrGwtc(userId, data, subConfigs));
        }

        return value.length() == 0 ? "0" : value.toString();
    }

    /**
     * 计算岗位奖金或者岗位提成
     *
     * @param userId            用户id
     * @param data              当前用户指标完成情况
     * @param subConfigs        当前业务配置的系数区间值列表
     * @return                  根据公式计算得出
     */
    private String getGwjjOrGwtc(String userId, String data, List<SubConfigDo> subConfigs) {
        double price = getCustomConfigValue(userId, subConfigs);
        double counts = Double.parseDouble(data);
        return price * counts + "";
    }

    private double getCustomConfigValue(String userId, List<SubConfigDo> subConfigs) {
        double result = 0d;
        Optional<SubConfigDo> customerValue = subConfigs
            .stream()
            .filter(
                config -> StringUtils.equals(config.getTarget(),
                    CustomerTypeEnum.CUSTOMER.getCode())
                          && StringUtils.equals(userId, config.getCustomerId())).findFirst();

        Optional<SubConfigDo> companyValue = subConfigs
            .stream()
            .filter(
                config -> StringUtils.equals(config.getTarget(), CustomerTypeEnum.COMPANY.getCode()))
            .findAny();

        if (customerValue.isPresent()) {
            result = Double.parseDouble(customerValue.get().getValue());
        } else {
            result = Double.parseDouble(companyValue.get().getValue());
        }
        return result;
    }

    /**
     * 计算岗位系数值
     * @param data              当前用户指标完成情况
     * @param subConfigs        当前业务配置的系数区间值列表
     * @return                  完成指标匹配区间对应的系数值
     */
    private String getGwxs(String data, List<SubConfigDo> subConfigs) {
        String result = data;
        double value = Double.parseDouble(data);
        for (int i = 0; i < subConfigs.size(); i++) {
            SubConfigDo config = subConfigs.get(i);

            double from = Double.parseDouble(config.getFromValue());
            double to = Double.parseDouble(config.getToValue());

            if (from <= value && value <= to) {
                result = config.getValue();
            }
        }

        //如果超出最大区间值,则取最大值
        double maxValue = subConfigs.stream()
            .mapToDouble(config -> Double.parseDouble(config.getToValue())).max().getAsDouble();

        if (value >= maxValue) {
            result = maxValue + "";
        }
        return result;
    }

    @Override
    public void addRatioDetail(String configType, String companyCode, String companyId,
                               String bizItem, String bizEvent, String data, String customerId) {
        execute(() -> {
            ConfigDo config = queryConfig(companyCode, companyId, bizItem, bizEvent);
            Assert.notNull(config,
                String.format("(%s,%s,%s,%s)主配置对象为空!", companyCode, companyId, bizItem, bizEvent));

            RatioDetailDo detailDo = new RatioDetailDo();
            detailDo.setCompanyCode(companyCode);
            detailDo.setCompanyId(companyId);
            detailDo.setOperator(Constants.SYSTEM);
            detailDo.setLastModifiedOperator(Constants.SYSTEM);
            detailDo.setBizItem(bizItem);
            detailDo.setBizEvent(bizEvent);
            detailDo.setValue(data);
            detailDo.setTotal(detailDo.getCount() * Double.parseDouble(data));
            detailDo.setCustomerId(customerId);
            detailDo.setConfigType(configType);
            detailDo.setUnit(UnitEnum.FEN.getMessage());
            commonDAO.insert("RatioDetail.addRatioDetail", detailDo);
        });
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
