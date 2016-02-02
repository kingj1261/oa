-- 岗位绩效数据规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo,context, gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','100000000000','10000001','
 package com.wantai.oa.rules.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;


 rule "操行系数规则定义(100000000000,10000001)"
 when
    $user:  User()
    $score: HashMap(containsKey("configType")
            && get("configType")=="gwxs"
            && containsKey("customerId")
            && get("customerId")==$user.id
            && get("bizItem")=="100000000000"
            && get("bizEvent")=="10000001")
 then
    context.caclulateRatioDetail((String)$score.get("configType"),(String)$score.get("bizItem"),(String)$score.get("bizEvent"),(String)$score.get("scores"),String.valueOf($user.getId()));
 end

','SQL','
 select   \'gwxs\'                  configType,
          message.customer_id       customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          supervise.out_limit_days  scores
 from     oa_message message ,
          oa_supervise supervise
 where supervise.message_id=message.id
 and message.company_code=\'${companyCode}\'
 and message.company_id=\'${companyId}\'

','岗位绩效数据规则','{}',now(),now(),'system','system');


-- 事业部长目标系数
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo,context, gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','200000000000','20000013','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "事业部长系数(200000000000,20000013)"
 when
     $user: User()
     $saleCount: HashMap(containsKey("gwxs")
     && get("configType")=="gwxs"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000013")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("saleCounts"),String.valueOf($user.getId()));
  end

','SQL','
  select
    \'gwxs\'                            configType,
    orders.customer_id                  customerId,
    \'${bizItem}\'                      bizItem,
    \'${bizEvent}\'                     bizEvent,
    COALESCE(sum(orders.sale_count),0)  saleCounts
  from m_c_sale_order orders
    where orders.order_status=(
      select max(status) from m_menu where menu_jm=\'ZCXSWJ\'
      group by menu_jm
    )
    and orders.company_code=\'${companyCode}\'
    and orders.company_id=\'${companyId}\'
    AND FROM_UNIXTIME(create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
    AND FROM_UNIXTIME(create_time)<=LAST_DAY(CURRENT_DATE)
    group by orders.customer_id
','事业部长系数数据规则','{}',now(),now(),'system','system');


-- 品牌经理目标系数规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo,context, gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','200000000000','20000014','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "品牌经理目标系数(200000000000,20000014)"
 when
     $user:         User(roles contains "ppjl")
     $saleOrder:    SaleOrderDo(customerId==$user.id
                    && configType=="gwxs"
                    && bizItem=="200000000000"
                    && bizEvent=="20000014")
  then
     context.caclulateRatioDetail($saleOrder.getConfigType(),$saleOrder.getBizItem(),$saleOrder.getBizEvent(),String.valueOf($saleOrder.getSaleCounts()),String.valueOf($user.getId()));
  end

','BEAN','roleBasedFactLoader','品牌经理目标系数规则','{"role":"ppjl"}',now(),now(),'system','system');


-- 销售主管目标系数规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','200000000000','20000015','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "销售主管目标系数(200000000000,20000015)"
 when
     $user:         User(roles contains "xszg")
     $saleOrder:    SaleOrderDo(customerId==$user.id
                    && configType=="gwxs"
                    && bizItem=="200000000000"
                    && bizEvent=="20000015")
  then
     context.caclulateRatioDetail($saleOrder.getConfigType(),$saleOrder.getBizItem(),$saleOrder.getBizEvent(),String.valueOf($saleOrder.getSaleCounts()),String.valueOf($user.getId()));
  end

','BEAN','roleBasedFactLoader','销售主管目标系数规则','{"role":"xszg"}',now(),now(),'system','system');




-- 销售顾问目标系数规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','200000000000','20000016','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "销售顾问目标系数(200000000000,20000016)"

 when
     $user: User(roles contains "xsgw")
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwxs"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000016")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("saleCounts"),String.valueOf($user.getId()));
  end

','SQL',
'
 select
    \'gwxs\'                            configType,
    orders.customer_id                  customerId,
    \'${bizItem}\'                      bizItem,
    \'${bizEvent}\'                     bizEvent,
    COALESCE(sum(orders.sale_count),0)  saleCounts
 from m_c_sale_order orders,
        (
          SELECT DISTINCT user.id
          FROM
            m_b_role role,
            m_b_user_role userRole,
            m_b_user user
          WHERE role.id = userRole.role_id
                AND role.jm = \'xsgw\'
                AND user.id = userRole.user_id
        )users
    where orders.order_status=(
      select max(status) from m_menu where menu_jm=\'ZCXSWJ\'
      group by menu_jm
    )
    and orders.company_code=\'${companyCode}\'
    and orders.company_id=\'${companyId}\'
    and orders.customer_id=users.id
    AND FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
    AND FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
    group by orders.customer_id

','销售顾问目标系数规则','{}',now(),now(),'system','system');


-- 配件规则
-- 销售目标系数
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','400000000000','40000004','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "配件-销售目标系数(400000000000,40000004)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwxs"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="400000000000"
     && get("bizEvent")=="40000004")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("totalAmount"),String.valueOf($user.getId()));
  end

','SQL',
        '
         select
            \'gwxs\'                                    configType,
            orders.operate_person_1                     customerId,
            \'${bizItem}\'                              bizItem,
            \'${bizEvent}\'                             bizEvent,
            COALESCE(sum(orders.sale_total_money),0)    totalAmount
         from m_pt_sale_order orders
            where orders.order_status=(
              select max(status) from m_menu where menu_jm=\'XSWJ\'
              group by menu_jm
            )
            and orders.company_name=\'${companyCode}\'
            and orders.company_id=\'${companyId}\'
            AND FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
            AND FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
            group by orders.operate_person_1

        ','配件-销售目标系数规则','{}',now(),now(),'system','system');


-- 未完待续
-- 配件库存准确率系数
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','400000000000','40000005','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "配件-库存准确率系数(400000000000,40000005)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwxs"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="400000000000"
     && get("bizEvent")=="40000005")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("ratio"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwxs\'                                                       configType,
          orders.customerId,
          \'${bizItem}\'                                                  bizItem,
          \'${bizEvent}\'                                                 bizEvent,
          COALESCE(sum(lossDetail.profit_loss_quantity),0)/orders.counts  ratio
          from (
              select
              orders.operate_person_1 customerId,
              COALESCE(sum(orders.total_number),0) counts
              from m_pt_inventory_order orders
              where orders.order_status=(
                select max(status) from m_menu where menu_jm=\'PJPDWJ\'
                group by menu_jm
              )
              and orders.company_code=\'${companyCode}\'
              and orders.company_id=\'${companyId}\'
              AND FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
              AND FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
              group by orders.operate_person_1
          )orders,
          m_pt_profit_loss_order  lossOrder,
          m_pt_profit_loss_detail lossDetail

          where  lossOrder.operate_person_1=orders.customerId
          and    lossOrder.id=lossDetail.order_id
          and    lossOrder.company_code=\'${companyCode}\'
          and    lossOrder.company_id=\'${companyId}\'
          AND FROM_UNIXTIME(lossOrder.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND FROM_UNIXTIME(lossOrder.create_time)<=LAST_DAY(CURRENT_DATE)
          group  by  lossDetail.order_id
        ','配件-库存准确率系数','{}',now(),now(),'system','system');


-- 挂靠
-- 挂靠-销售目标系数
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','700000000000','70000003','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "挂靠-销售目标系数(700000000000,70000003)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwxs"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="700000000000"
     && get("bizEvent")=="70000003")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select  \'gwxs\'                configType,
            orders.operate_person_1 customerId,
            \'${bizItem}\'          bizItem,
            \'${bizEvent}\'         bizEvent,
            COALESCE(count(1),0)    counts
    from
              m_f_affiliated_order orders
              where orders.order_status=(
                select max(status) from m_menu where menu_jm=\'GKWJ\'
                group by menu_jm
              )
              and orders.company_code=\'${companyCode}\'
              and orders.company_id=\'${companyId}\'
              AND FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
              AND FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
              group by orders.operate_person_1
        ','配件-库存准确率系数','{}',now(),now(),'system','system');



-- 保险-逾期保险系数
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','800000000000','80000005','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "保险-逾期保险系数(800000000000,80000005)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwxs"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000005")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwxs\'             configType,
          orders.customer_id    customerId,
          \'${bizItem}\'        bizItem,
          \'${bizEvent}\'       bizEvent,
          COALESCE(count(1),0)  counts
    from
                m_f_insurance_order orders,
                m_f_insurance_detail detail
    where orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          and   now()>date_add(FROM_UNIXTIME(detail.become_effective_time/1000,''%Y-%m-%d %h:%i:%s''),interval 1 year)
          AND FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.customer_id
        ','保险-逾期保险系数','{}',now(),now(),'system','system');



-- 保险-保险销售产值系数
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWXS','800000000000','80000006','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "保险-保险销售产值系数(800000000000,80000006)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwxs"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000006")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("totalAmount"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwxs\'                                                  configType,
           orders.customer_id                                        customerId,
           \'${bizItem}\'                                            bizItem,
           \'${bizEvent}\'                                           bizEvent,
           COALESCE(sum(jqx_bao_fee),0)+COALESCE(sum(syx_bao_fee),0) totalAmount
          from
                m_f_insurance_order orders

          where  orders.order_status=(
                    select max(status) from m_menu where menu_jm=\'TBWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.customer_id

        ','保险-保险销售产值系数','{}',now(),now(),'system','system');



-- 岗位奖金规则
-- 整车-车辆采购
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000002','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-车辆采购(200000000000,20000002)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000002")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                configType,
          orders.operate_person_1  customerId,
          \'${bizItem}\' bizItem,
          \'${bizEvent}\' bizEvent,
          COALESCE(count(1),0) counts
          from
                m_c_purchase_order orders

          where  orders.order_status>(
                    select max(status) from m_menu where menu_jm=\'DDSP\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1

        ','整车-车辆采购','{}',now(),now(),'system','system');


-- 整车-车辆采购
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000003','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-上装采购(200000000000,20000003)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000003")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                configType,
          orders.operate_person_1  customerId,
          \'${bizItem}\' bizItem,
          \'${bizEvent}\' bizEvent,
          COALESCE(count(1),0) counts
          from
               m_c_purchase_order orders,
               m_c_uprefit details
          where  orders.order_status>(
                    select max(status) from m_menu where menu_jm=\'SZHTSP\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          and   details.order_id=orders.id
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1

        ','整车-上装采购','{}',now(),now(),'system','system');



-- 整车-验收入库
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000004','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-验收入库(200000000000,20000004)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000004")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                configType,
          orders.operate_person_1  customerId,
          \'${bizItem}\' bizItem,
          \'${bizEvent}\' bizEvent,
          COALESCE(count(1),0) counts
          from
               m_c_purchase_order orders,
               m_c_purchase_detail details
          where  orders.order_status>(
                    select max(status) from m_menu where menu_jm=\'RSRK\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          and   details.order_id=orders.id
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1

        ','整车-验收入库','{}',now(),now(),'system','system');


-- 整车-实销处理
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000005','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-实销处理(200000000000,20000005)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000005")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                 configType,
          orders.operate_person_1   customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          COALESCE(count(1),0)      counts
          from
               m_c_true_sale_order orders
          where  orders.order_status=(
                    select max(status) from m_menu where menu_jm=\'SXWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1
        ','整车-实销处理','{}',now(),now(),'system','system');


-- 整车-合格证新增
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000007','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-合格证新增(200000000000,20000007)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000007")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                 configType,
          orders.operate_person_1   customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          COALESCE(count(1),0)      counts
          from
               m_c_certificate_add_order orders
          where  orders.order_status=(
                    select max(status) from m_menu where menu_jm=\'HGZWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1
        ','整车-合格证新增','{}',now(),now(),'system','system');



-- 整车-合格证变更
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000008','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-合格证变更(200000000000,20000008)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000008")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                 configType,
          orders.operate_person_1   customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          COALESCE(count(1),0)      counts
          from
               m_c_certificate_alter_order orders
          where  orders.order_status=(
                    select max(status) from m_menu where menu_jm=\'BGWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1
        ','整车-合格证变更','{}',now(),now(),'system','system');





-- 整车-参与行销
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000009','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-参与行销(200000000000,20000009)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000009")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                 configType,
          orders.operate_person_1   customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          COALESCE(count(1),0)      counts
          from
               m_b_sell_center orders
          where  orders.order_status=(
                    select max(status) from m_menu where menu_jm=\'XXWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1
        ','整车-参与行销','{}',now(),now(),'system','system');





-- 整车-电话回访客户
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000010','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-电话回访客户(200000000000,20000010)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000010")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'             configType,
          orders.customer_id    customerId,
          \'${bizItem}\'        bizItem,
          \'${bizEvent}\'       bizEvent,
          COALESCE(count(1),0)  counts
          from
               m_return_record orders
          where orders.return_way=1
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.customer_id
        ','整车-电话回访客户','{}',now(),now(),'system','system');



-- 整车-车辆出入库管理
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000011','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-车辆出入库管理(200000000000,20000011)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000011")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
SELECT \'gwjj\'         configType,
       \'${bizItem}\'   bizItem,
       \'${bizEvent}\'  bizEvent,
        a.customerId,
        sum(a.counts)   counts
FROM   (
        SELECT orders.operate_person_1             customerId,
                     COALESCE(Sum(orders.sale_count), 0) counts
              FROM   m_c_sale_order orders
              WHERE  orders.order_status >= (SELECT Max(status)
                                             FROM   m_menu
                                             WHERE  menu_jm = \'CLJJ\'
                                             GROUP  BY menu_jm)
                     AND   orders.company_code = \'${companyCode}\'
                     AND   orders.company_id = \'${companyId}\'
                     AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
                     AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
              GROUP  BY orders.operate_person_1

        UNION ALL

        SELECT orders.operate_person_1 customerId,
              COALESCE(Count(1), 0)   counts
             FROM   m_c_borrow_car_order orders
             WHERE  orders.order_status >= (SELECT Max(status)
                                            FROM   m_menu
                                            WHERE  menu_jm = \'JCSS\'
                                            GROUP  BY menu_jm)
                    AND orders.company_code =  \'${companyCode}\'
                    AND orders.company_id = \'${companyId}\'
                    AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
                    AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
             GROUP  BY orders.operate_person_1
        UNION ALL

        SELECT orders.operate_person_1 customerId,
              COALESCE(Count(1), 0)   counts
           FROM   m_c_purchase_order orders,
             m_c_purchase_detail detail
           WHERE  orders.order_status >= (SELECT Max(status)
                                          FROM   m_menu
                                          WHERE  menu_jm = ''YSRK''
                                          GROUP  BY menu_jm)
                  AND   orders.company_code = \'${companyCode}\'
                  AND   orders.company_id = \'${companyId}\'
                  AND   detail.order_id = orders.id
                  AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
                  AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
           GROUP  BY orders.operate_person_1
  )a  group by a.customerId

        ','整车-车辆出入库管理','{}',now(),now(),'system','system');



-- 整车-库存车辆盘点
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','200000000000','20000012','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-库存车辆盘点(200000000000,20000012)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000012")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                 configType,
          orders.operate_person_1   customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          COALESCE(count(1),0)      counts
          from
               m_c_inventory_order orders
          where  orders.order_status=(
                    select max(status) from m_menu where menu_jm=\'PDWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1
        ','整车-库存车辆盘点','{}',now(),now(),'system','system');





-- 维修-保内库盘点
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','300000000000','30000003','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "维修-保内库盘点(300000000000,30000003)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="300000000000"
     && get("bizEvent")=="30000003")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                 configType,
          orders.operate_person_1   customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          COALESCE(count(1),0)      counts
          from
               m_pt_inventory_order orders
          where  orders.order_status>=(
                    select max(status) from m_menu where menu_jm=\'PJPDWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1
        ','维修-保内库盘点','{}',now(),now(),'system','system');




-- 维修-发运单登记
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','300000000000','30000005','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "维修-发运单登记(300000000000,30000005)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="300000000000"
     && get("bizEvent")=="30000005")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                 configType,
          orders.operate_person_1   customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          COALESCE(count(1),0)      counts
          from
               m_pt_purchase_order orders
          where  orders.order_status>=(
                    select max(status) from m_menu where menu_jm=\'CJFH\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          and   orders.order_number is not null
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1
        ','维修-发运单登记','{}',now(),now(),'system','system');





-- 配件-配件价格调整
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','400000000000','40000000','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "配件-配件价格调整(400000000000,40000000)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="400000000000"
     && get("bizEvent")=="40000000")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'                 configType,
          orders.operate_person_1   customerId,
          \'${bizItem}\'            bizItem,
          \'${bizEvent}\'           bizEvent,
          COALESCE(count(1),0)      counts
          from
               m_pt_alert_price_order orders
          where  orders.order_status>=(
                    select max(status) from m_menu where menu_jm=\'TJWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
          group by orders.operate_person_1
        ','配件-配件价格调整','{}',now(),now(),'system','system');




-- 配件-库房全盘
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','400000000000','40000002','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "配件-库房全盘(400000000000,40000002)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="400000000000"
     && get("bizEvent")=="40000002")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'         configType,
           a.store_room_id,
           \'${bizItem}\'   bizItem,
           \'${bizEvent}\'  bizEvent,
           a.counts,
           b.customerId
    from (
           select store_room_id,count(1) counts
             from  m_pt_parts_goods orders
               where   orders.company_code=\'${companyCode}\'
               and     orders.company_id=\'${companyId}\'
               AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
               AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
             group by store_room_id
         )a,

      (
       select orders.store_room_id,
              orders.operate_person_1 customerId,
              count(1) counts
        from
          m_pt_inventory_order orders,
          m_pt_inventory_detail detail
        where orders.id=detail.order_id
        and orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'PJPDWJ\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.store_room_id,orders.operate_person_1
      )b
      where a.store_room_id=b.store_room_id

        ','配件-库房全盘','{}',now(),now(),'system','system');



-- 配件-库房抽盘
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','400000000000','40000003','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "配件-库房抽盘(400000000000,40000003)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="400000000000"
     && get("bizEvent")=="40000003")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwjj\'           configType,
           a.store_room_id,
           \'${bizItem}\'     bizItem,
           \'${bizEvent}\'    bizEvent,
           a.counts,
           b.customerId
    from (
           select store_room_id,count(1) counts
             from  m_pt_parts_goods orders
               where   orders.company_code=\'${companyCode}\'
               and     orders.company_id=\'${companyId}\'
               AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
               AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
             group by store_room_id
         )a,

      (
       select orders.store_room_id,
              orders.operate_person_1 customerId,
              count(1) counts
        from
          m_pt_inventory_order orders,
          m_pt_inventory_detail detail
        where orders.id=detail.order_id
        and orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = ''PJPDWJ''
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.store_room_id,orders.operate_person_1
      )b

      where a.store_room_id=b.store_room_id
        ','配件-库房抽盘','{}',now(),now(),'system','system');




-- 牌证-办理行驶证
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','500000000000','50000000','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "牌证-办理行驶证(500000000000,50000000)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="500000000000"
     && get("bizEvent")=="50000000")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
       select
             \'gwjj\'           configType,
             \'${bizItem}\'     bizItem,
             \'${bizEvent}\'    bizEvent,
             orders.customer_id customerId,
             count(1) counts
        from
          m_c_license_order orders
        where orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'SHXXSC\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        and   orders.drive_license_img is not null
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.customer_id

        ','牌证-办理行驶证','{}',now(),now(),'system','system');





-- 牌证-办理道路运输证
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','500000000000','50000001','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "牌证-办理道路运输证(500000000000,50000001)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="500000000000"
     && get("bizEvent")=="50000001")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
       select
             \'gwjj\'           configType,
             \'${bizItem}\'     bizItem,
             \'${bizEvent}\'    bizEvent,
             orders.customer_id customerId,
             count(1)           counts
        from
          m_c_license_order orders
        where orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'SHXXSC\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        and   orders.transport_license_img is not null
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.customer_id

        ','牌证-办理道路运输证','{}',now(),now(),'system','system');



-- 牌证-办理危化证
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','500000000000','50000003','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "牌证-办理危化证(500000000000,50000003)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="500000000000"
     && get("bizEvent")=="50000003")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
       select
             \'gwjj\'           configType,
             \'${bizItem}\'     bizItem,
             \'${bizEvent}\'    bizEvent,
             orders.customer_id customerId,
             count(1)           counts
        from
          m_c_license_order orders
        where orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'SHXXSC\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        and   orders.hazardous_license_img is not null
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.customer_id

        ','牌证-办理危化证','{}',now(),now(),'system','system');





-- 挂靠-签订《安全责任书》
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','700000000000','70000000','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "挂靠-签订《安全责任书》(700000000000,70000000)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="700000000000"
     && get("bizEvent")=="70000000")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
        SELECT
               \'gwjj\'                 configType,
               \'${bizItem}\'           bizItem,
               \'${bizEvent}\'          bizEvent,
               orders.operate_person_1  customerId,
               count(1)                 counts
        FROM m_f_affiliated_order orders,
             m_contract_record record
        WHERE orders.order_status>
            ( SELECT Max(status)
             FROM m_menu
             WHERE menu_jm = \'GKWJSP\'
             GROUP BY menu_jm )
          AND orders.company_code=\'${companyCode}\'
          AND orders.company_id=\'${companyId}\'
          AND record.module_id =
            ( SELECT id
             FROM m_menu
             WHERE menu_jm = \'GKYW\' )
          AND record.contract_type LIKE "《安全责任书》"
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        GROUP BY orders.operate_person_1

        ','挂靠-签订《安全责任书》','{}',now(),now(),'system','system');






-- 挂靠-签订《挂靠合同》
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','700000000000','70000001','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "挂靠-签订《挂靠合同》(700000000000,70000001)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="700000000000"
     && get("bizEvent")=="70000001")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
        SELECT
               \'gwjj\'                 configType,
               \'${bizItem}\'           bizItem,
               \'${bizEvent}\'          bizEvent,
               orders.operate_person_1  customerId,
               count(1)                 counts
        FROM m_f_affiliated_order orders,
             m_contract_record record
        WHERE orders.order_status>
            ( SELECT Max(status)
             FROM m_menu
             WHERE menu_jm = \'GKWJSP\'
             GROUP BY menu_jm )
          AND orders.company_code=\'${companyCode}\'
          AND orders.company_id=\'${companyId}\'
          AND record.module_id =
            ( SELECT id
             FROM m_menu
             WHERE menu_jm = \'GKYW\' )
          AND record.contract_type LIKE "《挂靠合同》"
          AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
          AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        GROUP BY orders.operate_person_1

        ','挂靠-签订《挂靠合同》','{}',now(),now(),'system','system');




-- 保险-办理商用车商业险
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','800000000000','80000000','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "保险-办理商用车商业险(800000000000,80000000)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000000")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwjj\'                 configType,
               \'${bizItem}\'           bizItem,
               \'${bizEvent}\'          bizEvent,
               orders.operate_person_1  customerId,
               count(1)                 counts
        from
          m_f_insurance_order orders,
          m_f_insurance_detail detail
        where  orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'TBWJ\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        and   detail.order_id=orders.id
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','保险-办理商用车商业险','{}',now(),now(),'system','system');





-- 保险-理赔日志
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','800000000000','80000001','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "保险-理赔日志(800000000000,80000001)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000001")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwjj\'                 configType,
               \'${bizItem}\'           bizItem,
               \'${bizEvent}\'          bizEvent,
               orders.operate_person_1  customerId,
               count(1)                 counts
        from
          m_f_insurance_order orders,
          m_f_insurance_detail detail
        where  orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'TBWJ\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        and   detail.order_id=orders.id
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','保险-理赔日志','{}',now(),now(),'system','system');





-- 保险-保险返利登记
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','800000000000','80000003','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "保险-保险返利登记(800000000000,80000003)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000003")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwjj\'                 configType,
               \'${bizItem}\'           bizItem,
               \'${bizEvent}\'          bizEvent,
               orders.operate_person_1  customerId,
               count(1)                 counts
        from
          m_f_budget_order orders,
          m_f_insurance_budget detail

        where detail.order_id=orders.id
        and   orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'YSWJ\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        and   detail.jqx_rebate_money >=0
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','保险-保险返利登记','{}',now(),now(),'system','system');




-- 保险-理赔登记
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWJJ','800000000000','80000004','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "保险-理赔登记(800000000000,80000004)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwjj"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000004")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwjj\'                   configType,
               \'${bizItem}\'             bizItem,
               \'${bizEvent}\'            bizEvent,
               orders.operate_person_1    customerId,
               count(1)                   counts
        from
          m_f_claims_order orders

        where   orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'LPWJ\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','保险-理赔登记','{}',now(),now(),'system','system');



-- 岗位提成

-- 整车-车辆溢价
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','200000000000','20000021','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-车辆溢价(200000000000,20000021)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000021")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("amount"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwtc\'                                 configType,
               \'${bizItem}\'                           bizItem,
               \'${bizEvent}\'                          bizEvent,
               orders.operate_person_1                  customerId,
               COALESCE(sum(sale_price-floor_price),0)  amount
        from
          m_c_sale_order orders

        where   orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'ZCXSWJ\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1

        ','整车-车辆溢价','{}',now(),now(),'system','system');




-- 整车-行销开发新客户提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','200000000000','20000022','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-行销开发新客户提成(200000000000,20000022)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000022")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("distance"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwtc\'                               configType,
               \'${bizItem}\'                         bizItem,
               \'${bizEvent}\'                        bizEvent,
               orders.operate_person_1                customerId,
               COALESCE(sum(true_total_distance),0)   distance
        from
          m_b_sell_center orders

        where   orders.order_status=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'XXWJ\'
          GROUP  BY menu_jm
        )
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','整车-行销开发新客户提成','{}',now(),now(),'system','system');




-- 整车-回访客户提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','200000000000','20000023','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "整车-回访客户提成(200000000000,20000023)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000023")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("distance"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwtc\'                         configType,
               \'${bizItem}\'                   bizItem,
               \'${bizEvent}\'                  bizEvent,
               orders.operate_person_1          customerId,
               COALESCE(sum(line_distance),0)   distance
        from
           m_b_sell_center orders,
           m_b_sell_customer customer

        where orders.id=customer.sell_center_id
        and   customer.sell_type=2
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','整车-回访客户提成','{}',now(),now(),'system','system');



-- 配件-配件毛利提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','400000000000','40000006','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "配件-配件毛利提成(400000000000,40000006)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="400000000000"
     && get("bizEvent")=="40000006")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("distance"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwtc\'                         configType,
               \'${bizItem}\'                   bizItem,
               \'${bizEvent}\'                  bizEvent,
               orders.operate_person_1          customerId,
               COALESCE(sum(line_distance),0)   distance
        from
           m_b_sell_center orders,
           m_b_sell_customer customer

        where orders.id=customer.sell_center_id
        and   customer.sell_type=2
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','配件-配件毛利提成','{}',now(),now(),'system','system');





-- 牌证-上户牌证费提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','500000000000','50000006','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "牌证-上户牌证费提成(500000000000,50000006)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="500000000000"
     && get("bizEvent")=="50000006")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("amount"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwtc\'                             configType,
               \'${bizItem}\'                       bizItem,
               \'${bizEvent}\'                      bizEvent,
               orders.operate_person_1              customerId,
               COALESCE(sum(maori_total_fee),0)     amount
        from
           m_c_license_order orders

        where orders.order_status>=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'SHXXSP\'
          GROUP  BY menu_jm
        )
        and   orders.license_type=1
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','牌证-上户牌证费提成','{}',now(),now(),'system','system');







-- 车贷-GPS费毛利提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','600000000000','60000005','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "车贷-GPS费毛利提成(600000000000,60000005)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="600000000000"
     && get("bizEvent")=="60000005")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("amount"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwtc\'                               configType,
               \'${bizItem}\'                         bizItem,
               \'${bizEvent}\'                        bizEvent,
               orders.operate_person_1                customerId,
               COALESCE(sum(detail.gps_fee_maori),0)  amount
        from
           m_f_budget_order orders,
           m_f_loan_budget  detail

        where orders.order_status>=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'YSWJ\'
          GROUP  BY menu_jm
        )
        and   orders.id=detail.order_id
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','车贷-GPS费毛利提成','{}',now(),now(),'system','system');





-- 车贷-档案费毛利提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','600000000000','60000006','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "车贷-档案费毛利提成(600000000000,60000006)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="600000000000"
     && get("bizEvent")=="60000006")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("amount"),String.valueOf($user.getId()));
  end

','SQL',
        '
        select
               \'gwtc\'                                     configType,
               \'${bizItem}\'                               bizItem,
               \'${bizEvent}\'                              bizEvent,
               orders.operate_person_1                      customerId,
               COALESCE(sum(detail.record_fee_maori),0)     amount
        from
           m_f_budget_order orders,
           m_f_loan_budget  detail

        where orders.order_status>=(
          SELECT Max(status)
          FROM   m_menu
          WHERE  menu_jm = \'YSWJ\'
          GROUP  BY menu_jm
        )
        and   orders.id=detail.order_id
        and   orders.company_code=\'${companyCode}\'
        and   orders.company_id=\'${companyId}\'
        AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
        AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
        group by orders.operate_person_1
        ','车贷-档案费毛利提成','{}',now(),now(),'system','system');




-- 车贷-利息毛利提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','600000000000','60000007','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "车贷-利息毛利提成(600000000000,60000007)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="600000000000"
     && get("bizEvent")=="60000007")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("amount"),String.valueOf($user.getId()));
  end

','SQL',
        '
        SELECT  \'gwtc\'                configType,
                \'${bizItem}\'          bizItem,
                \'${bizEvent}\'         bizEvent,
                a.customerId,
                sum(a.amount)           amount
        FROM
          ( SELECT orders.operate_person_1 customerId,
                   COALESCE(sum(detail.total_interest_maori),0) amount
           FROM m_f_budget_order orders,
                m_f_loan_budget detail
           WHERE orders.order_status =
               ( SELECT Max(status)
                FROM m_menu
                WHERE menu_jm = \'YSWJ\'
                GROUP BY menu_jm )
             AND   orders.id = detail.order_id
             AND   orders.company_code = \'${companyCode}\'
             AND   orders.company_id = \'${companyId}\'
             AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
             AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
           GROUP BY orders.operate_person_1

           UNION ALL SELECT orders.operate_person_1 customerId,
                            COALESCE(sum(detail.interest_maori),0) amount
           FROM m_f_budget_order orders,
                m_f_short_budget detail
           WHERE orders.order_status =
               ( SELECT Max(status)
                FROM m_menu
                WHERE menu_jm = \'YSWJ\'
                GROUP BY menu_jm )
             AND   orders.id = detail.order_id
             AND   orders.company_code = \'${companyCode}\'
             AND   orders.company_id =\'${companyId}\'
             AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
             AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
           GROUP BY orders.operate_person_1 )a
        GROUP BY a.customerId

        ','车贷-利息毛利提成','{}',now(),now(),'system','system');





-- 车贷-公证费毛利提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','600000000000','60000011','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "车贷-公证费毛利提成(600000000000,60000011)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="600000000000"
     && get("bizEvent")=="60000011")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("amount"),String.valueOf($user.getId()));
  end

','SQL',
        '
           SELECT
                  \'gwtc\'                                  configType,
                  \'${bizItem}\'                            bizItem,
                  \'${bizEvent}\'                           bizEvent,
                  orders.operate_person_1                   customerId,
                  COALESCE(sum(detail.notary_fee_maori),0)  amount
           FROM m_f_budget_order orders,
                m_f_loan_budget detail
           WHERE orders.order_status =
               ( SELECT Max(status)
                FROM m_menu
                WHERE menu_jm = \'YSWJ\'
                GROUP BY menu_jm )
             AND   orders.id = detail.order_id
             AND   orders.company_code = \'${companyCode}\'
             AND   orders.company_id =\'${companyId}\'
             AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
             AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
           GROUP BY orders.operate_person_1
        ','车贷-公证费毛利提成','{}',now(),now(),'system','system');




-- 车贷-车贷产值提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','600000000000','60000012','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "车贷-车贷产值提成(600000000000,60000012)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="600000000000"
     && get("bizEvent")=="60000012")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("amount"),String.valueOf($user.getId()));
  end

','SQL',
        '
        SELECT  \'gwtc\'                      configType,
                \'${bizItem}\'                bizItem,
                \'${bizEvent}\'               bizEvent,
                a.customerId,
                COALESCE(sum(a.amount),0)     amount
        FROM
          ( SELECT
                   orders.operate_person_1 customerId,
                   COALESCE(sum(detail.money+detail.first_pay_money+detail.total_interest_maori),0) amount
           FROM m_f_budget_order orders,
                m_f_loan_budget detail
           WHERE orders.order_status =
               ( SELECT Max(status)
                FROM m_menu
                WHERE menu_jm = \'YSWJ\'
                GROUP BY menu_jm )
             AND orders.id = detail.order_id
             AND orders.company_code = \'${companyCode}\'
             AND orders.company_id = \'${companyId}\'
             AND FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
             AND FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
             GROUP BY orders.operate_person_1

           UNION ALL

           SELECT orders.operate_person_1 customerId,
                  COALESCE(sum(detail.money+detail.interest_maori),0) amount
           FROM m_f_budget_order orders,
                m_f_short_budget detail
           WHERE orders.order_status =
               ( SELECT Max(status)
                FROM m_menu
                WHERE menu_jm = \'YSWJ\'
                GROUP BY menu_jm )
             AND orders.id = detail.order_id
             AND orders.company_code = \'${companyCode}\'
             AND orders.company_id =\'${companyId}\'
             AND FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
             AND FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
             GROUP BY orders.operate_person_1
          )a
        GROUP BY a.customerId

        ','车贷-车贷产值提成','{}',now(),now(),'system','system');



-- 保险
-- 保险-老客户持续提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','800000000000','80000007','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "保险-老客户持续提成(800000000000,80000007)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000007")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
           SELECT \'gwtc\'                  configType,
                  \'${bizItem}\'            bizItem,
                  \'${bizEvent}\'           bizEvent,
                   orders.operate_person_1  customerId,
                   count(1)                 counts
           FROM m_f_insurance_order orders
             WHERE orders.order_status  = 2
             AND   orders.inseure_type=2
             AND   orders.company_code = \'${companyCode}\'
             AND   orders.company_id = \'${companyId}\'
             AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
             AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
             GROUP BY orders.operate_person_1
        ','保险-老客户持续提成','{}',now(),now(),'system','system');


-- 保险-新客户毛利提成
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator)
VALUES ('99999999999',1,'GWTC','800000000000','80000008','
 package com.wantai.oa.rules.defination.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.common.dal.mappings.dos.performance.SaleOrderDo;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;

 rule "保险-新客户毛利提成(800000000000,80000008)"

 when
     $user: User()
     $saleCount: HashMap(containsKey("configType")
     && get("configType")=="gwtc"
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000008")
  then
     context.caclulateRatioDetail((String)$saleCount.get("configType"),(String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("amount"),String.valueOf($user.getId()));
  end

','SQL',
        '
           SELECT \'gwtc\'                        configType,
                  \'${bizItem}\'                  bizItem,
                  \'${bizEvent}\'                 bizEvent,
                   orders.operate_person_1        customerId,
                    COALESCE(sum(total_maori),0)  amount
           FROM m_f_insurance_order orders
             WHERE orders.order_status  = 1
             AND   orders.inseure_type=1
             AND   orders.company_code = \'${companyCode}\'
             AND   orders.company_id = \'${companyId}\'
             AND   FROM_UNIXTIME(orders.create_time)>=DATE_SUB(CURRENT_DATE, INTERVAL DAYOFMONTH(CURRENT_DATE)-1 DAY)
             AND   FROM_UNIXTIME(orders.create_time)<=LAST_DAY(CURRENT_DATE)
             GROUP BY orders.operate_person_1
        ','保险-新客户毛利提成','{}',now(),now(),'system','system');