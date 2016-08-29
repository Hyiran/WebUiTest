/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : testdate

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-03-01 16:54:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cases
-- ----------------------------
DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(255) NOT NULL COMMENT '用例名称',
  `function` varchar(255) DEFAULT NULL COMMENT '用例目的',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cases
-- ----------------------------
INSERT INTO `cases` VALUES ('1', 'cases.TestData', '测一下表的设计');
INSERT INTO `cases` VALUES ('2', 'cases.front.RegisterTest', '注册功能');
INSERT INTO `cases` VALUES ('3', 'cases.Clean', '清除老数据影响sql');
INSERT INTO `cases` VALUES ('4', 'cases.front.LoginTest', '登录功能');
INSERT INTO `cases` VALUES ('5', 'cases.front.AuthenticationTest', '实名认证');
INSERT INTO `cases` VALUES ('6', 'cases.front.ModifyPwd', '修改密码');
INSERT INTO `cases` VALUES ('7', 'cases.front.RechargeTest', '前台充值+后台审核');

-- ----------------------------
-- Table structure for datas
-- ----------------------------
DROP TABLE IF EXISTS `datas`;
CREATE TABLE `datas` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '输入数据的id',
  `group_id` int(11) NOT NULL,
  `step` int(11) NOT NULL COMMENT '第几步要用',
  `data` varchar(255) DEFAULT NULL COMMENT '数据',
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datas
-- ----------------------------
INSERT INTO `datas` VALUES ('1', '1', '1', '55');
INSERT INTO `datas` VALUES ('2', '1', '2', '54');
INSERT INTO `datas` VALUES ('6', '3', '1', '1000');
INSERT INTO `datas` VALUES ('7', '3', '2', '500');
INSERT INTO `datas` VALUES ('8', '4', '1', '15600210010');
INSERT INTO `datas` VALUES ('9', '4', '2', '111111');
INSERT INTO `datas` VALUES ('10', '4', '3', '111111');
INSERT INTO `datas` VALUES ('11', '4', '4', '15600210010');
INSERT INTO `datas` VALUES ('12', '4', '5', '888888');
INSERT INTO `datas` VALUES ('13', '5', '1', 'DELETE FROM user_member WHERE user_name=\'15600210010\';');
INSERT INTO `datas` VALUES ('14', '6', '2', 'DELETE FROM user_memberinfo WHERE user_name=\'15600210010\';');
INSERT INTO `datas` VALUES ('15', '7', '1', '15600212730');
INSERT INTO `datas` VALUES ('16', '7', '2', '111111');
INSERT INTO `datas` VALUES ('17', '8', '1', '15600212731');
INSERT INTO `datas` VALUES ('18', '8', '2', '99999999');
INSERT INTO `datas` VALUES ('19', '9', '1', '闫云毅');
INSERT INTO `datas` VALUES ('20', '9', '2', '410102197702110527');
INSERT INTO `datas` VALUES ('21', '9', '3', '15600210010');
INSERT INTO `datas` VALUES ('22', '9', '4', '111111');
INSERT INTO `datas` VALUES ('23', '10', '1', '222222');
INSERT INTO `datas` VALUES ('24', '10', '2', '222222');
INSERT INTO `datas` VALUES ('25', '11', '1', '1000');

-- ----------------------------
-- Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组的id',
  `case_id` int(11) NOT NULL COMMENT '所属用例',
  `result_correct` varchar(255) DEFAULT NULL COMMENT '预期测试结果',
  `result_actual` varchar(255) DEFAULT NULL COMMENT '实际测试结果',
  PRIMARY KEY (`id`),
  KEY `case_id` (`case_id`),
  CONSTRAINT `case_id` FOREIGN KEY (`case_id`) REFERENCES `cases` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('1', '1', '2', null);
INSERT INTO `groups` VALUES ('3', '1', '500', null);
INSERT INTO `groups` VALUES ('4', '2', '注册成功', null);
INSERT INTO `groups` VALUES ('5', '3', '0', null);
INSERT INTO `groups` VALUES ('6', '3', '0', null);
INSERT INTO `groups` VALUES ('7', '4', '登录成功', null);
INSERT INTO `groups` VALUES ('8', '4', '登录失败', null);
INSERT INTO `groups` VALUES ('9', '5', '实名认证成功', null);
INSERT INTO `groups` VALUES ('10', '6', '密码修改成功！', null);
INSERT INTO `groups` VALUES ('11', '7', '充值成功', null);
