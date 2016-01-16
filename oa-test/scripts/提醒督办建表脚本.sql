DROP TABLE IF EXISTS OA_MESSAGE;
DROP TABLE IF EXISTS OA_SUPERVISE;
DROP TABLE IF EXISTS OA_REMIND;

-- 消息表
CREATE TABLE OA_MESSAGE (
  id                     INT PRIMARY KEY NOT NULL AUTO_INCREMENT
  COMMENT '逻辑主键',
  company_code           VARCHAR(32)     NOT NULL
  COMMENT '公司码',
  company_id             INT             NOT NULL
  COMMENT '公司id',
  biz_item               VARCHAR(12)     NOT NULL
  COMMENT '业务事项',
  biz_event              VARCHAR(8)      NOT NULL
  COMMENT '业务事件',
  end_time               DATETIME        NOT NULL
  COMMENT '截止日期',
  customer_id            VARCHAR(32)     NOT NULL
  COMMENT '消息接收人编号',
  customer_name          VARCHAR(32)     NOT NULL
  COMMENT '消息接收人名称',
  read_status            VARCHAR(8)      NOT NULL
  COMMENT '阅读状态 R-已读 NR-未读',
  message_type           VARCHAR(8)      NOT NULL
  COMMENT '消息类型 SYSTEM-系统消息 BUSINESS-业务消息 OA-OA消息 ESHOP-电商消息',
  message_body           TEXT            NOT NULL
  COMMENT '消息体内容',
  memo                   VARCHAR(256) COMMENT '备注',
  gmt_create             DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建日期',
  gmt_modified           DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改日期',
  operator               VARCHAR(32)     NOT NULL
  COMMENT '操作员',
  last_modified_oeprator VARCHAR(32)     NOT NULL
  COMMENT '最后一次修改日期'
)
  COMMENT '消息表';


-- 督办表
CREATE TABLE OA_SUPERVISE (
  id             INT PRIMARY KEY NOT NULL AUTO_INCREMENT
  COMMENT '逻辑主键',
  message_id     INT             NOT NULL
  COMMENT '消息表id',
  out_limit_days INT             NOT NULL DEFAULT 0
  COMMENT '超期日期,单位为天',
  gmt_create     DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建日期',
  gmt_modified   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改日期'
)
  COMMENT '督办表';

-- 提醒表
CREATE TABLE OA_REMIND
(
  id           INT PRIMARY KEY NOT NULL AUTO_INCREMENT
  COMMENT '逻辑主键',
  message_id   INT             NOT NULL
  COMMENT '消息表id',
  remind_type  VARCHAR(32)     NOT NULL
  COMMENT '提醒类型 BUSINESS-业务提醒 OUT_TIME-到期提醒',
  gmt_create   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建日期',
  gmt_modified DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后修改日期'
)
  COMMENT '提醒表';

-- 索引
ALTER TABLE `oa_remind`
ADD UNIQUE INDEX `idx_message_id` (`message_id`);

ALTER TABLE `oa_supervise`
ADD UNIQUE INDEX `idx_message_id` (`message_id`);

