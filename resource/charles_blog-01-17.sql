/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : charles_blog

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-01-17 14:44:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `phone` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '手机',
  `idCard` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证',
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Charles', '18814127283', '440182199512042311', 'jaycekon');
INSERT INTO `user` VALUES ('4', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('5', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('6', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('7', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('8', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('9', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('10', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('11', 'Charles', '18891202121', '4402912131231231', '952102');
INSERT INTO `user` VALUES ('12', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('13', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('14', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('15', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('16', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('17', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('18', '1234', '123', '1234', 'Jaycekon');
INSERT INTO `user` VALUES ('19', '1234', '123', '1234', 'Jaycekon');
