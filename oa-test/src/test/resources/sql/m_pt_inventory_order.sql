delete from m_pt_inventory_order;

insert into m_pt_inventory_order
(
    system_number          ,
    order_status           ,
    check_status           ,
    store_room_id          ,
    store_room_name        ,
    joiner                 ,
    total_number           ,
    inventory_total_money  ,
    operate_person_1       ,
    operate_time_1         ,
    operate_person_2       ,
    operate_time_2         ,
    operate_time_3         ,
    operate_person_3       ,
    reject_reason_3        ,
    company_id             ,
    company_code           ,
    create_time            ,
    create_person          ,
    update_time            ,
    update_person
)
VALUES
(
   's32424324',
   4,
   3,
   2,
   'sfewfewf',
   '23424',
   1234,
   9923434.23,
   3,
   1,
   2,
   3,
   4,
   5,
   6,
   1,
   '99999999999',
   1,
   2,
   3,
   5
);