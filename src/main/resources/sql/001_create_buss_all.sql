--
-- Table structure for table `sys_user`
--
CREATE TABLE `sys_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(32) NOT NULL COMMENT '登录用户名',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(64) NOT NULL COMMENT '加密密码',
  `mobile` varchar(16) DEFAULT NULL COMMENT '联系方式',
  `is_administrator` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否超级管理员（0 否，1 是）',
  `create_user` varchar(32) NOT NULL COMMENT '创建用户',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `update_user` varchar(32) DEFAULT NULL COMMENT '最后更新用户',
  `update_date` datetime DEFAULT NULL COMMENT '最后更新时间',
  `remark` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) COMMENT='用户表';

