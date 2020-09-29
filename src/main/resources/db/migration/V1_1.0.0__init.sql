
CREATE TABLE `hello_world`(
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `app_name` varchar(32) NOT NULL default '' COMMENT '应用名',
  `app_name_cn` varchar(32) NOT NULL default '' COMMENT '应用名（中文）',
  `app_desc` varchar(256) NOT NULL default '' COMMENT '应用名描述',
  `group` varchar(64) NOT NULL default '' COMMENT 'group',
  `artifact` varchar(64) NOT NULL default '' COMMENT 'artifact',
  `show_status` smallint NOT NULL default 0 COMMENT '展示状态：0，不展示;1，展示',
  `system_flag` smallint NOT NULL default 0 COMMENT '系统标示：0，非系统应用;1，系统应用',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='应用表';
