
-- 增量脚本
alter table OA_BUSINESS_CONFIG add column context TEXT  COMMENT  '主配置表扩展字段';

-- 更新业务事项的web扩展css属性

update OA_BUSINESS_CONFIG set context='{icon0:\'DataTextImg1\',icon1:\'DataTextImges1\'}'
where company_code='99999999999' and company_id='1'
      and config_type='GWXS' and biz_item='100000000000' and biz_event='10000001';


update OA_BUSINESS_CONFIG set context='{icon0:\'DataTextImg2\',icon1:\'DataTextImges2\'}'
where company_code='99999999999' and company_id='1'
      and config_type='GWXS' and biz_item='200000000000';


update OA_BUSINESS_CONFIG set context='{icon0:\'DataTextImg4\',icon1:\'DataTextImges4\'}'
where company_code='99999999999' and company_id='1'
      and config_type='GWXS' and biz_item='400000000000';


update OA_BUSINESS_CONFIG set context='{icon0:\'DataTextImg6\',icon1:\'DataTextImges6\'}'
where company_code='99999999999' and company_id='1'
      and config_type='GWXS' and biz_item='700000000000';


update OA_BUSINESS_CONFIG set context='{icon0:\'DataTextImg8\',icon1:\'DataTextImges8\'}'
where company_code='99999999999' and company_id='1'
      and config_type='GWXS' and biz_item='800000000000';



-- 基础设置页面基础设置

insert into OA_SYSTEM_CONFIG(company_code, company_id, name, value, memo, gmt_create, gmt_modified, operator, last_modified_oeprator)
values('99999999999','1','revenueStartEnable','true','个税起征点是否启用',now(),now(),'system','system');


insert into OA_SYSTEM_CONFIG(company_code, company_id, name, value, memo, gmt_create, gmt_modified, operator, last_modified_oeprator)
values('99999999999','1','socialEnable','true','社保是否启用',now(),now(),'system','system');


insert into OA_SYSTEM_CONFIG(company_code, company_id, name, value, memo, gmt_create, gmt_modified, operator, last_modified_oeprator)
values('99999999999','1','socialSettingType','COMPANY','社保设置方式-默认公司',now(),now(),'system','system');


insert into OA_SYSTEM_CONFIG(company_code, company_id, name, value, memo, gmt_create, gmt_modified, operator, last_modified_oeprator)
values('99999999999','1','fundEnable','true','公积金是否启用',now(),now(),'system','system');


insert into OA_SYSTEM_CONFIG(company_code, company_id, name, value, memo, gmt_create, gmt_modified, operator, last_modified_oeprator)
values('99999999999','1','fundSettingType','COMPANY','公积金设置方式-默认公司',now(),now(),'system','system');



