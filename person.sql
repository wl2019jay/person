/*
Navicat MySQL Data Transfer

Source Server         : 11
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : person

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-03-23 14:56:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `tip` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(11) NOT NULL DEFAULT '0',
  `pid` int(11) DEFAULT NULL,
  `cityname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_companies
-- ----------------------------
DROP TABLE IF EXISTS `t_companies`;
CREATE TABLE `t_companies` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `company_code` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `company_name` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `company_desc` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  `image` mediumblob,
  `addrees` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `tell_phone` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `cost_mode_id` int(11) DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_cost_model
-- ----------------------------
DROP TABLE IF EXISTS `t_cost_model`;
CREATE TABLE `t_cost_model` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `model_code` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `model_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `cost_type` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `cost_sigle_price` double DEFAULT NULL,
  `remark` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_economic_man
-- ----------------------------
DROP TABLE IF EXISTS `t_economic_man`;
CREATE TABLE `t_economic_man` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `phone` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `ID_image` blob,
  `invitation_code` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_employees
-- ----------------------------
DROP TABLE IF EXISTS `t_employees`;
CREATE TABLE `t_employees` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_code` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `city_id_1` int(11) DEFAULT NULL,
  `city_id_2` int(11) DEFAULT NULL,
  `city_id_3` int(11) DEFAULT NULL,
  `city_id_4` int(11) DEFAULT NULL,
  `address_detail` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `id_num` int(18) DEFAULT NULL,
  `enable_flag` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_employees_economicman_ref
-- ----------------------------
DROP TABLE IF EXISTS `t_employees_economicman_ref`;
CREATE TABLE `t_employees_economicman_ref` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `employees_id` int(11) DEFAULT NULL,
  `economic_man_id` int(11) DEFAULT NULL,
  `recommend_date` date DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_employees_work
-- ----------------------------
DROP TABLE IF EXISTS `t_employees_work`;
CREATE TABLE `t_employees_work` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `frozen_flag` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `is_settlement` varchar(8) COLLATE utf8_bin DEFAULT 'N',
  `recommend_id` int(11) DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_employees_work_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_employees_work_detail`;
CREATE TABLE `t_employees_work_detail` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `work_id` int(11) DEFAULT NULL,
  `work_date` date DEFAULT NULL,
  `work_hours` int(11) DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_employee_idcard
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_idcard`;
CREATE TABLE `t_employee_idcard` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `front_image` mediumblob,
  `back_image` mediumblob,
  `employee_id` int(11) DEFAULT NULL,
  `Name` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `nation` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `birth` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `idnum` varchar(18) COLLATE utf8_bin DEFAULT NULL,
  `ValidDate` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_function
-- ----------------------------
DROP TABLE IF EXISTS `t_function`;
CREATE TABLE `t_function` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `function_code` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `function_name` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `function_url` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `parent_Id` int(11) DEFAULT NULL,
  `enable_flag` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '1',
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `role_name` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `enable_flag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_role_function
-- ----------------------------
DROP TABLE IF EXISTS `t_role_function`;
CREATE TABLE `t_role_function` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `function_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update_by` int(11) DEFAULT NULL,
  `last_update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
