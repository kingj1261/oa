DROP TABLE IF EXISTS OA_BUSINESS_CONFIG ;
DROP TABLE IF EXISTS OA_SUB_BUSINESS_CONFIG;
DROP TABLE IF EXISTS OA_REVENUE_CONFIG;
DROP TABLE IF EXISTS OA_CUSTOM_PERFORMANCE_CONFIG;
DROP TABLE IF EXISTS OA_SALARY_CACULATE_FORMULA;
DROP TABLE IF EXISTS OA_PERFORMANCE_DETAILS;
DROP TABLE IF EXISTS OA_SALARY_DETAILS;
DROP TABLE IF EXISTS OA_RULES;

-- 绩效配置主表
CREATE TABLE OA_BUSINESS_CONFIG
(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code            VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id              INT NOT NULL COMMENT '公司id',
  config_type             VARCHAR(32) NOT NULL COMMENT '配置类型 绩效系数-jxxs 岗位奖金-gwjj 岗位提成-gwtc',
  biz_item                VARCHAR(12) NOT NULL COMMENT '业务事项',
  biz_event               VARCHAR(8) NOT NULL COMMENT '业务事件',
  biz_item_name           VARCHAR(128) NOT NULL COMMENT '业务事项名称',
  biz_event_name          VARCHAR(128) NOT NULL COMMENT '业务事件名称',
  biz_item_order          INT DEFAULT 0 COMMENT '业务事项顺序',
  biz_event_order         INT DEFAULT 0 COMMENT '事件顺序',
  enable                  VARCHAR(8) NOT NULL COMMENT '是否启用 true-启用 false-不启用 默认启用',
  start_time              DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '绩效指标设置开始时间',
  end_time                DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '绩效指标设置结束时间',
  memo                    VARCHAR(256) COMMENT '备注',
  gmt_create              DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT  '绩效配置主表';


-- 绩效配置子表
CREATE TABLE OA_SUB_BUSINESS_CONFIG(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  business_config_id      INT NOT NULL COMMENT '主配置表id',
  sub_event_code          VARCHAR(16) NOT NULL COMMENT '子业务事件',
  sub_event_code_name     VARCHAR(64) NOT NULL COMMENT '子业务事件名称',
  target                  VARCHAR(8) NOT NULL COMMENT '配置对象 公司-COMPANY 个人-CUSTOMER',
  customer_id             VARCHAR(32)  COMMENT '客户id',
  value                   VARCHAR(32) NOT NULL COMMENT '配置值',
  from_value              VARCHAR(32) NOT NULL COMMENT '配置区间开始值',
  to_value                VARCHAR(32) NOT NULL COMMENT '配置区间结束值',
  unit                    VARCHAR(8) NOT NULL COMMENT '值单位 元-人民币（156） 百分比-%',
  enable                  VARCHAR(8) NOT NULL DEFAULT 'true' COMMENT '是否启用 true-启用 false-不启用 默认启用',
  memo                    VARCHAR(256) COMMENT '备注',
  orders                  INT DEFAULT 0 COMMENT '排序',
  gmt_create              DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT '绩效配置子表';

-- 公司个税配置表
CREATE TABLE OA_REVENUE_CONFIG
(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code            VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id              INT NOT NULL COMMENT '公司id',
  from_value              DECIMAL(10,2) NOT NULL COMMENT '个税开始金额',
  to_value                DECIMAL(10,2) NOT NULL COMMENT '个税结束金额',
  revenue_ratio           DECIMAL(10,2) NOT NULL COMMENT '税率 保存小数值',
  deduct_amount           DECIMAL(10,2) NOT NULL COMMENT '速算扣除金额',
  start_time              DATETIME NOT NULL COMMENT '绩效指标设置开始时间',
  end_time                DATETIME NOT NULL COMMENT '绩效指标设置结束时间',
  memo                    VARCHAR(256) COMMENT '备注',
  gmt_create              DATETIME NOT NULL COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT '公司个税配置表';



-- 公共配置表
CREATE TABLE OA_SYSTEM_CONFIG
(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code            VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id              INT NOT NULL COMMENT '公司id',
  name                    VARCHAR(32) NOT NULL COMMENT '配置key',
  value                   VARCHAR(256) NOT NULL COMMENT '值',
  memo                    VARCHAR(256) COMMENT '备注',
  gmt_create              DATETIME NOT NULL COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT '公共配置表';


-- 个人绩效指标配置表
CREATE TABLE OA_CUSTOM_PERFORMANCE_CONFIG(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code            VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id              INT NOT NULL COMMENT '公司id',
  customer_id             VARCHAR(32) NOT NULL COMMENT '客户id',
  start_time              DATETIME NOT NULL COMMENT '绩效指标设置开始时间',
  end_time                DATETIME NOT NULL COMMENT '绩效指标设置结束时间',
  basic_salary            DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '基本工资',
  start_salary            DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '星级工资',
  lowest_salary           DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '保底工资',
  work_years_salary       DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '工龄工资',
  max_work_years_salary   DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '最大工龄工资',
  bet_amount              DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '对赌金额',
  currency                VARCHAR(12) NOT NULL COMMENT '单位：币种  元-人民币（156)',
  social_basic_amount     DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '社保基数，单位元，取unit（币种）字段',
  social_percent          DECIMAL NOT NULL DEFAULT 0 COMMENT '社保缴存比例，以小数保存 比如10% 存为 0.1',
  fund_basic_amount       DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '公积金基数，单位元，取unit（币种）字段',
  fund_percent            DECIMAL NOT NULL DEFAULT 0 COMMENT '公积金缴存比例，以小数保存 比如10% 存为 0.1',
  memo                    VARCHAR(256) COMMENT '备注',
  gmt_create              DATETIME NOT NULL COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT '个人绩效指标配置表';


-- 个人绩效指标业务事项事件配置表
CREATE TABLE OA_CUSTOM_PERFORMANCE_BIZ_CONFIG(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code            VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id              INT NOT NULL COMMENT '公司id',
  customer_id             VARCHAR(32) NOT NULL COMMENT '客户id',
  biz_item                VARCHAR(12) NOT NULL COMMENT '业务事项',
  biz_event               VARCHAR(8) NOT NULL COMMENT '业务事件',
  enable                  VARCHAR(8) NOT NULL DEFAULT 'true' COMMENT '是否生效,默认生效',
  start_time              DATETIME NOT NULL COMMENT '绩效指标设置开始时间',
  end_time                DATETIME NOT NULL COMMENT '绩效指标设置结束时间',
  memo                    VARCHAR(256) COMMENT '备注',
  gmt_create              DATETIME NOT NULL COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT '个人绩效指标业务事项事件配置表';

-- 工资计算公式
CREATE TABLE OA_SALARY_CACULATE_FORMULA(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code            VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id              INT NOT NULL COMMENT '公司id',
  customer_id             VARCHAR(32) NOT NULL COMMENT '客户id',
  start_time              DATETIME NOT NULL COMMENT '绩效指标设置开始时间',
  end_time                DATETIME NOT NULL COMMENT '绩效指标设置结束时间',
  has_basic_salary        VARCHAR(8) NOT NULL COMMENT '是否有基本工资，true-有 false-无',
  has_start_salary        VARCHAR(8) NOT NULL COMMENT '是否有星级工资，true-有 false-无',
  has_lowest_salary       VARCHAR(8) NOT NULL COMMENT '是否有保底工资，true-有 false-无',
  has_work_years_salary   VARCHAR(8) NOT NULL COMMENT '是否有工龄工资，true-有 false-无',
  check_rule              VARCHAR(8) NOT NULL COMMENT '考核方式 对赌-bet 岗位奖金+岗位提成- jjtc',
  ratio_caclu_type        VARCHAR(8) NOT NULL COMMENT '绩效计算方式 平均系数-average 系数跌乘-multipy',
  has_subsity_salary      VARCHAR(8) NOT NULL COMMENT '是否有补贴，true-有 false-无',
  has_bonus_salary        VARCHAR(8) NOT NULL COMMENT '是否有奖金，true-有 false-无',
  has_deduct_salary       VARCHAR(8) NOT NULL COMMENT '是否有扣款，true-有 false-无',
  has_withhold_salary     VARCHAR(8) NOT NULL COMMENT '是否有代扣，true-有 false-无',
  memo                    VARCHAR(256) COMMENT '备注',
  gmt_create              DATETIME NOT NULL COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT '工资计算公式';


-- 规则定义
CREATE TABLE OA_RULES(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code            VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id              INT NOT NULL COMMENT '公司id',
  config_type             VARCHAR(32) NOT NULL COMMENT '配置类型 绩效系数-jxxs 岗位奖金-gwjj 岗位提成-gwtc',
  biz_item                VARCHAR(12) NOT NULL COMMENT '业务事项',
  biz_event               VARCHAR(8) NOT NULL COMMENT '业务事件',
  rules                   TEXT COMMENT '业务规则',
  data_extract_type       VARCHAR(16) DEFAULT 'SQL' NOT NULL COMMENT '获取数据方式 ，默认为SQL',
  data_extract_shell      TEXT COMMENT '数据抽取脚本，默认为SQL语句',
  memo                    VARCHAR(256) COMMENT '备注',
  context                 TEXT COMMENT '扩展上下文字段,json格式存储',
  gmt_create              DATETIME NOT NULL COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT '规则定义';

-- 绩效计算流水数据
CREATE TABLE OA_PERFORMANCE_DETAILS(
  id                      INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code            VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id              INT NOT NULL COMMENT '公司id',
  customer_id             VARCHAR(32) NOT NULL COMMENT '客户id',
  start_time              DATETIME NOT NULL COMMENT '绩效指标设置开始时间',
  end_time                DATETIME NOT NULL COMMENT '绩效指标设置结束时间',
  config_type             VARCHAR(32) NOT NULL COMMENT '配置类型 绩效系数-jxxs 岗位奖金-gwjj 岗位提成-gwtc',
  biz_item                VARCHAR(12) NOT NULL COMMENT '业务事项',
  biz_event               VARCHAR(8) NOT NULL COMMENT '业务事件',
  value                   VARCHAR(32) NOT NULL COMMENT '实际值',
  unit                    VARCHAR(12) NOT NULL COMMENT '值单位 元-人民币（156）',
  count                   INT NOT NULL COMMENT '次数 绩效系数计算时默认为1',
  total                   DECIMAL(12,2) NOT NULL COMMENT '总值',
  out_biz_date            DATETIME COMMENT '外部事件发生时间（奖金、补贴、扣款、其它代扣)',
  memo                    VARCHAR(256) COMMENT '备注',
  gmt_create              DATETIME NOT NULL COMMENT '创建日期',
  gmt_modified            DATETIME NOT NULL COMMENT '最后修改日期',
  operator                VARCHAR(32) NOT NULL COMMENT '操作员',
  last_modified_oeprator  VARCHAR(32) NOT NULL COMMENT '最后一次修改日期'
)COMMENT '绩效计算流水数据';

-- 实际工资发放流水
CREATE TABLE OA_SALARY_DETAILS(
  id                        INT PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '逻辑主键',
  company_code              VARCHAR(32) NOT NULL COMMENT '公司码',
  company_id                INT NOT NULL COMMENT '公司id',
  customer_id               VARCHAR(32) NOT NULL COMMENT '客户id',
  start_time                DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '绩效指标设置开始时间',
  end_time                  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '绩效指标设置结束时间',
  basic_salary              DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '基本工资',
  start_salary              DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '星级工资',
  lowest_salary             DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '保底工资',
  work_years_salary         DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '工龄工资',
  bet_amount                DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '对赌金额',
  currency                  VARCHAR(12)  NOT NULL DEFAULT '156' COMMENT '单位：币种  元-人民币（156)',
  gwjj                      DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '岗位奖金',
  gwtc                      DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '岗位提成',
  ratio_amount              DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '考核绩效',
  subsity_amount            DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '补贴金额',
  bonus_amount              DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '奖金',
  deduct_amount             DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '扣款金额',
  withhold_amount           DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '代扣金额',
  socail_amount             DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '社保缴存金额',
  fund_amount               DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '公积金缴存金额',
  revenue_amount            DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '缴存个税',
  lowest_salary_difference  DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '保底工资差额',
  gross_salary              DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '应发工资',
  total_withholding_amount  DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '代扣款合计',
  net_salary                DECIMAL(9,2) NOT NULL DEFAULT 0 COMMENT '实发工资',
  memo                      VARCHAR(256) COMMENT '备注',
  gmt_create                DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  gmt_modified              DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改日期',
  operator                  VARCHAR(32)  NOT NULL COMMENT '操作员',
  last_modified_oeprator    VARCHAR(32)  NOT NULL COMMENT '最后一次修改日期'
)COMMENT '实际工资发放流水';