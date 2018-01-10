/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : charles_blog

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 10/01/2018 22:20:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `phone` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '手机',
  `id_card` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证',
  `password` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` VALUES (1, 'Charles', '18814127283', '440182199512042311', 'jaycekon');
INSERT INTO `User` VALUES (4, '1234', '123', '1234', 'Jaycekon');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
