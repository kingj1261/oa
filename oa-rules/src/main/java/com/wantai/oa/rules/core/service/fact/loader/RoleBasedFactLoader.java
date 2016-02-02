/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.rules.core.service.fact.loader;

import com.wantai.oa.biz.shared.service.RoleService;
import com.wantai.oa.common.dal.CommonDAO;
import com.wantai.oa.common.dal.mappings.dos.auth.Role;
import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
import com.wantai.oa.common.dal.mappings.dos.rule.RuleDo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 部门经理目标系数事实数据加载
 * @author maping.mp
 * @version $Id: RoleBasedFactLoader.java, v 0.1 2015-1-04 下午09:28:59 maping.mp Exp $
 */
@Service("roleBasedFactLoader")
public class RoleBasedFactLoader implements FactLoader {

    @Autowired
    private CommonDAO   commonDAO;

    @Autowired
    private RoleService roleService;

    @Override
    public List load(RuleDo ruleDo) {

        List<SaleOrderDo> datas = new ArrayList<>();
        String currentRole = ruleDo.getString("role");
        //查询当前部门下所有员工的车辆销售记录(包括品牌经理和其所有下属员工)
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("companyCode", ruleDo.getCompanyCode());
        parameter.put("companyId", ruleDo.getCompanyId());
        parameter.put("configType", ruleDo.getConfigType());
        parameter.put("bizItem", ruleDo.getBizItem());
        parameter.put("bizEvent", ruleDo.getBizEvent());
        parameter.put("role", currentRole);

        List<SaleOrderDo> orders = (List<SaleOrderDo>) commonDAO.findAll(
            "Performance.findAllSaleOrders", parameter);
        if (CollectionUtils.isNotEmpty(orders)) {

            //设置订单对应用户角色
            orders.forEach(order -> {
                order.setConfigType(ruleDo.getConfigType());
                order.setRole(getRole(ruleDo, order.getCustomerId()));
            });

            //获取订单列表
            List<SaleOrderDo> leaderList = orders
                .stream()
                .filter(
                    order -> order.getRole() != null
                             && StringUtils.equals(order.getRole(), currentRole))
                .collect(Collectors.toList());

            Map<Integer, List<SaleOrderDo>> groupedOrders = orders.stream().collect(
                Collectors.groupingBy(SaleOrderDo::getDepartId));

            for (Integer departId : groupedOrders.keySet()) {
                findLeader(leaderList, departId).setSaleCounts(
                    getAllSaleCounts(groupedOrders.get(departId)));
            }

            datas.addAll(leaderList);
        }
        return datas;
    }

    private int getAllSaleCounts(List<SaleOrderDo> saleOrderDos) {
        return saleOrderDos.stream().mapToInt(order -> order.getSaleCounts()).sum();
    }

    private SaleOrderDo findLeader(List<SaleOrderDo> leaderList, Integer departId) {
        SaleOrderDo leader = leaderList.stream()
            .filter(order -> order.getDepartId().equals(departId)).findFirst().get();
        return leader;
    }

    private String getRole(RuleDo rule, int customerId) {
        List<Role> roles = (List<Role>) roleService.findRolesByUserId(customerId);
        Optional<Role> exists = roles.stream()
            .filter(role -> StringUtils.equals(rule.getString("role"), role.getCode())).findAny();
        return exists.isPresent() ? exists.get().getCode() : null;
    }
}
