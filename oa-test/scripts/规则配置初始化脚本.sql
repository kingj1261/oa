-- 岗位绩效数据规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, gmt_create, gmt_modified, operator, last_modified_oeprator) VALUES ('99999999999',1,'GWXS','100000000000','10000001','
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

','岗位绩效数据规则',now(),now(),'system','system');


-- 事业部长目标系数
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, gmt_create, gmt_modified, operator, last_modified_oeprator) VALUES ('99999999999',1,'GWXS','200000000000','20000013','
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
','事业部长系数数据规则',now(),now(),'system','system');


-- 品牌经理目标系数规则
insert into OA_RULES(company_code, company_id, config_type, biz_item, biz_event, rules, data_extract_type, data_extract_shell, memo, gmt_create, gmt_modified, operator, last_modified_oeprator) VALUES ('99999999999',1,'GWXS','200000000000','20000014','
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

','BEAN','ppjlFactLoader','品牌经理目标系数规则',now(),now(),'system','system');