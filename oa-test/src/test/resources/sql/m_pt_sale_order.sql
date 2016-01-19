-- 清空数据
delete from m_pt_sale_order;

-- 插入数据
insert into m_pt_sale_order
(
  system_number          ,
  order_status           ,
  check_status           ,
  order_source           ,
  platform_order_id      ,
  platform_order_number  ,
  store_room_id          ,
  store_room_name        ,
  buyers_id              ,
  buyers_name            ,
  sale_count             ,
  sale_total_money       ,
  receivables_total_money,
  pay_method             ,
  operate_time_1         ,
  operate_person_1       ,
  company_id             ,
  company_name           ,
  create_person          ,
  create_time            ,
  update_person          ,
  update_time
)
values(
  '123123213xxx',
  4,
  4,
  1,
  1,
  '1232132',
  1,
  'test',
  1,
  'jake',
  2,
  123.43,
  45334.23,
  99.23,
  1,
  2,
  1,
  '99999999999',
  1,
  1,
  1,
  2
);
