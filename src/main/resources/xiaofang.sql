/*
 Navicat Premium Data Transfer

 Source Server         : local-mysql
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : xiaofang

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 02/09/2020 20:19:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `is_imported` tinyint(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 'Bread', 1.00, 1);
INSERT INTO `goods` VALUES (2, 'Cocacola', 1.00, 0);
INSERT INTO `goods` VALUES (3, 'Beer', 1.00, 1);
INSERT INTO `goods` VALUES (4, 'Chocolate', 1.00, 0);
INSERT INTO `goods` VALUES (5, 'Pencil', 0.50, 1);
INSERT INTO `goods` VALUES (6, 'Notebool', 3.00, 0);

SET FOREIGN_KEY_CHECKS = 1;
