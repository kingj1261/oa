-- 岗位绩效数据规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo,context, gmt_create, gmt_modified, operator, last_modified_oeprator) VALUES ('99999999999',1,'GWXS','100000000000','10000001','
 package com.wantai.oa.rules.common;

 dialect "mvel"

 import java.util.*;
 import com.wantai.oa.common.dal.mappings.dos.auth.User;
 import com.wantai.oa.rules.core.service.context.RuleRuntimeContext;

 global RuleRuntimeContext context;


 rule "操行系数规则定义(100000000000,10000001)"
 when
    $user:  User()
    $score: HashMap(containsKey("gwxs")
            && containsKey("customerId")
            && get("customerId")==$user.id
            && get("bizItem")=="100000000000"
            && get("bizEvent")=="10000001")
 then
    context.caclulateRatioDetail((String)$score.get("bizItem"),(String)$score.get("bizEvent"),(String)$score.get("scores"),String.valueOf($user.getId()));
 end

','SQL','
 select \'gwxs\',
  message.customer_id customerId,
  \'100000000000\' bizItem,
  \'10000001\' bizEvent,
  supervise.out_limit_days scores
 from oa_message message ,oa_supervise supervise
 where supervise.message_id=message.id
 and message.company_code=\'${companyCode}\'
 and message.company_id=\'${companyId}\'

','岗位绩效数据规则','{}',now(),now(),'system','system');


-- 事业部长目标系数
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo,context, gmt_create, gmt_modified, operator, last_modified_oeprator) VALUES ('99999999999',1,'GWXS','200000000000','20000013','
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
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000013")
  then
     context.caclulateRatioDetail((String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("saleCounts"),String.valueOf($user.getId()));
  end

','SQL','
  select
    \'gwxs\',
    orders.customer_id customerId,
    \'200000000000\' bizItem,
    \'20000013\' bizEvent,
       COALESCE(sum(orders.sale_count),0) saleCounts
    from m_c_sale_order orders
    where orders.order_status=(
      select max(status) from m_menu where menu_jm=\'ZCXSWJ\'
      group by menu_jm
    )
    and orders.company_code=\'${companyCode}\'
    and orders.company_id=\'${companyId}\'
    group by orders.customer_id
','事业部长系数数据规则','{}',now(),now(),'system','system');


-- 品牌经理目标系数规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo,context, gmt_create, gmt_modified, operator, last_modified_oeprator) VALUES ('99999999999',1,'GWXS','200000000000','20000014','
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
                    && bizItem=="200000000000"
                    && bizEvent=="20000014")
  then
     context.caclulateRatioDetail($saleOrder.getBizItem(),$saleOrder.getBizEvent(),String.valueOf($saleOrder.getSaleCounts()),String.valueOf($user.getId()));
  end

','BEAN','roleBasedFactLoader','品牌经理目标系数规则','{"role":"ppjl"}',now(),now(),'system','system');


-- 销售主管目标系数规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, context,gmt_create, gmt_modified, operator, last_modified_oeprator) VALUES ('99999999999',1,'GWXS','200000000000','20000015','
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
                    && bizItem=="200000000000"
                    && bizEvent=="20000015")
  then
     context.caclulateRatioDetail($saleOrder.getBizItem(),$saleOrder.getBizEvent(),String.valueOf($saleOrder.getSaleCounts()),String.valueOf($user.getId()));
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
     $saleCount: HashMap(containsKey("gwxs")
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="200000000000"
     && get("bizEvent")=="20000016")
  then
     context.caclulateRatioDetail((String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("saleCounts"),String.valueOf($user.getId()));
  end

','SQL',
'
 select
    \'gwxs\',
    orders.customer_id customerId,
    \'200000000000\' bizItem,
    \'20000016\' bizEvent,
       COALESCE(sum(orders.sale_count),0) saleCounts
    from m_c_sale_order orders,
        (
          SELECT DISTINCT user.id
          FROM
            m_b_role role,
            m_b_user_role userRole,
            m_b_user user
          WHERE role.id = userRole.role_id
                AND role.jm = ''xsgw''
                AND user.id = userRole.user_id
        )users
    where orders.order_status=(
      select max(status) from m_menu where menu_jm=\'ZCXSWJ\'
      group by menu_jm
    )
    and orders.company_code=\'${companyCode}\'
    and orders.company_id=\'${companyId}\'
    and orders.customer_id=users.id
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
     $saleCount: HashMap(containsKey("gwxs")
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="400000000000"
     && get("bizEvent")=="40000004")
  then
     context.caclulateRatioDetail((String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("totalAmount"),String.valueOf($user.getId()));
  end

','SQL',
        '
         select
            \'gwxs\',
            orders.operate_person_1 customerId,
            \'400000000000\' bizItem,
            \'40000004\' bizEvent,
               COALESCE(sum(orders.sale_total_money),0) totalAmount
            from m_pt_sale_order orders
            where orders.order_status=(
              select max(status) from m_menu where menu_jm=\'XSWJ\'
              group by menu_jm
            )
            and orders.company_name=\'${companyCode}\'
            and orders.company_id=\'${companyId}\'
            group by orders.operate_person_1

        ','配件-销售目标系数规则','{}',now(),now(),'system','system');


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
     $saleCount: HashMap(containsKey("gwxs")
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="400000000000"
     && get("bizEvent")=="40000005")
  then
     context.caclulateRatioDetail((String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("ratio"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwxs\',
          orders.customerId,
          \'400000000000\' bizItem,
          \'40000005\' bizEvent,
          COALESCE(sum(lossDetail.profit_loss_quantity),0)/orders.counts ratio
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
              group by orders.operate_person_1
          )orders,
          m_pt_profit_loss_order  lossOrder,
          m_pt_profit_loss_detail lossDetail

          where  lossOrder.operate_person_1=orders.customerId
          and    lossOrder.id=lossDetail.order_id
          and    lossOrder.company_code=\'${companyCode}\'
          and    lossOrder.company_id=\'${companyId}\'
          group by  lossDetail.order_id
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
     $saleCount: HashMap(containsKey("gwxs")
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="700000000000"
     && get("bizEvent")=="70000003")
  then
     context.caclulateRatioDetail((String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwxs\',
          orders.operate_person_1 customerId,
          \'700000000000\' bizItem,
          \'70000003\' bizEvent,
          COALESCE(count(1),0) counts
          from
              m_f_affiliated_order orders
              where orders.order_status=(
                select max(status) from m_menu where menu_jm=\'GKWJ\'
                group by menu_jm
              )
              and orders.company_code=\'${companyCode}\'
              and orders.company_id=\'${companyId}\'
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
     $saleCount: HashMap(containsKey("gwxs")
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000005")
  then
     context.caclulateRatioDetail((String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("counts"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwxs\',
          orders.customer_id  customerId,
          \'800000000000\' bizItem,
          \'80000005\' bizEvent,
          COALESCE(count(1),0) counts
          from
                m_f_insurance_order orders,
                m_f_insurance_detail detail
          where orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          and   now()>date_add(FROM_UNIXTIME(detail.become_effective_time/1000,''%Y-%m-%d %h:%i:%s''),interval 1 year)
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
     $saleCount: HashMap(containsKey("gwxs")
     && containsKey("customerId")
     && get("customerId")==$user.id
     && get("bizItem")=="800000000000"
     && get("bizEvent")=="80000006")
  then
     context.caclulateRatioDetail((String)$saleCount.get("bizItem"),(String)$saleCount.get("bizEvent"),(String)$saleCount.get("totalAmount"),String.valueOf($user.getId()));
  end

','SQL',
        '
    select \'gwxs\',
          orders.customer_id  customerId,
          \'800000000000\' bizItem,
          \'80000006\' bizEvent,
          COALESCE(sum(jqx_bao_fee),0)+COALESCE(sum(syx_bao_fee),0) totalAmount
          from
                m_f_insurance_order orders

          where  orders.order_status=(
                    select max(status) from m_menu where menu_jm=\'TBWJ\'
                      group by menu_jm
                  )
          and   orders.company_code=\'${companyCode}\'
          and   orders.company_id=\'${companyId}\'
          group by orders.customer_id

        ','保险-保险销售产值系数','{}',now(),now(),'system','system');

