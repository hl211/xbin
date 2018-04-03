/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : hl

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-30 11:32:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `ip` varchar(45) DEFAULT NULL COMMENT '用户ip',
  `req_method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `req_url` text COMMENT '请求URL',
  `exec_method` varchar(200) DEFAULT NULL COMMENT '执行方法',
  `exec_time` bigint(20) DEFAULT NULL COMMENT '响应时间',
  `args` text COMMENT '参数',
  `return_val` text COMMENT '返回值',
  `exec_desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `status` varchar(45) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7211 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `perm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `perm_name` varchar(50) NOT NULL COMMENT '权限名称',
  `perm_data_url` varchar(100) NOT NULL COMMENT '连接路径或方法',
  `perm_parent_id` varchar(50) DEFAULT NULL COMMENT '上级菜单编码',
  `perm_type` varchar(2) DEFAULT '1' COMMENT '菜单类型：1是左导航菜单 2是按钮权限',
  `perm_create_date` varchar(30) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`perm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '超级管理员', 'all', null, '1', '1111');
INSERT INTO `sys_permission` VALUES ('2', '用户管理', 'user', null, '1', '111');
INSERT INTO `sys_permission` VALUES ('3', '用户查看', 'user:view', null, '1', '1111');
INSERT INTO `sys_permission` VALUES ('4', '角色管理', 'role', null, '1', '11111');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(40) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `role_update_user` int(11) DEFAULT NULL COMMENT '编辑者',
  `role_create_date` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `role_update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员', '111', '1111111', '2018-03-30 11:06:35');
INSERT INTO `sys_role` VALUES ('2', 'guest', '客人', null, null, null);
INSERT INTO `sys_role` VALUES ('3', 'test', '测试者', null, null, null);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `perm_id` bigint(20) NOT NULL COMMENT '权限id',
  `create_date` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`rp_id`),
  KEY `fk_sys_role_permission_role_id` (`role_id`),
  KEY `fk_sys_role_permission_perm_id` (`perm_id`),
  CONSTRAINT `fk_sys_role_permission_perm_id` FOREIGN KEY (`perm_id`) REFERENCES `sys_permission` (`perm_id`),
  CONSTRAINT `fk_sys_role_permission_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色按钮权限表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1', null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_account` varchar(30) NOT NULL COMMENT '登录账号',
  `user_pass` varchar(65) NOT NULL COMMENT '登录密码',
  `user_count` int(11) DEFAULT '0' COMMENT '登录次数',
  `user_tel` varchar(20) DEFAULT NULL COMMENT '手机',
  `user_email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `user_sex` int(11) DEFAULT NULL COMMENT '性别',
  `user_status` int(11) DEFAULT '1' COMMENT '用户状态0:表示禁用；1:表示启用',
  `user_birthday` varchar(30) DEFAULT NULL COMMENT '生日',
  `user_register_date` varchar(30) NOT NULL COMMENT '注册时间',
  `user_last_date` datetime DEFAULT NULL COMMENT '最近登录时间',
  `user_pass_date` datetime DEFAULT NULL COMMENT '用户密码修改时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_sys_user_login_account` (`user_account`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'hl', 'hl', '1', '1888', '111', '0', '1', '1111', '', null, null);
INSERT INTO `sys_user` VALUES ('2', 'jj', 'jj', '1', '1111', '11111', '0', '1', null, '11', null, null);
INSERT INTO `sys_user` VALUES ('3', 'bf', 'bf', '1', '11111', '1111111', '0', '1', '111', '1111111', null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` int(20) NOT NULL COMMENT '角色id',
  `create_date` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ur_id`),
  KEY `fk_sys_user_role_role_id` (`role_id`),
  KEY `fk_sys_user_role_user_id` (`user_id`),
  CONSTRAINT `fk_sys_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `fk_sys_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色映射表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null);
