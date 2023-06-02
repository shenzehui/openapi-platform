/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : openapi

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 02/06/2023 14:33:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for interface_info
-- ----------------------------
DROP TABLE IF EXISTS `interface_info`;
CREATE TABLE `interface_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `description` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '接口地址',
  `requestHeader` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '请求头',
  `responseHeader` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '用户名',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '接口状态（0：关闭，1：开启）',
  `method` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请求类型',
  `userId` bigint(0) NOT NULL COMMENT '创建人',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `isDeleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除(0-未删, 1-已删)',
  `requestParams` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '请求参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'openapi.`interface_info`' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interface_info
-- ----------------------------
INSERT INTO `interface_info` VALUES (21, '我的接口', '我的接口', 'http://localhost:8080', 'application/context', 'JSON', 0, 'POST', 1648960682721718273, '2023-04-20 16:31:41', '2023-04-25 20:09:49', 0, NULL);
INSERT INTO `interface_info` VALUES (22, 'testjiekou', 'testjiekou', 'http://localhost:8080', 'token', 'application/json', 0, 'POST', 1648960682721718273, '2023-04-21 11:14:32', '2023-04-21 11:14:32', 0, NULL);
INSERT INTO `interface_info` VALUES (23, 'getUsernameByPost', '获取用户名', 'http://localhost:8123/api/name/user', '{\"Content-Type\":\"applictaion/json\"}', '{\"Content-Type\":\"applictaion/json\"}', 1, 'POST', 1648960682721718273, '2023-04-22 12:57:26', '2023-04-25 17:53:26', 0, '[\n    {\n        \"name\":\"username\",\n        \"type\":\"string\"\n    }\n]');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userAccount` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
  `userPassword` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `unionId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信开放平台id',
  `mpOpenId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公众号openId',
  `userName` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `userAvatar` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `userProfile` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户简介',
  `userRole` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user' COMMENT '用户角色：user/admin/ban',
  `accessKey` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'accessKey',
  `secretKey` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'secretKey',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `isDelete` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_unionId`(`unionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1649637348552904706 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1648960682721718273, 'admin', 'b0dd3697a192885d7c055db46155b26a', NULL, NULL, 'admin', '', '', 'admin', 'szh', 'abcdefgh', '1970-01-01 00:00:00', '2023-06-01 19:33:36', 0);
INSERT INTO `user` VALUES (1649637348552904705, 'shenzehui', 'b0dd3697a192885d7c055db46155b26a', NULL, NULL, 'szh', 'https://img.chilling.tw/images/author/Ivy/0712001.jpg', NULL, 'user', '5d6988cf5c5918084a02b64ea1253e8a', 'ae43eddb4a683deb752fb84809984fe3', '2023-04-22 12:52:47', '2023-06-01 19:32:46', 0);

-- ----------------------------
-- Table structure for user_interface_info
-- ----------------------------
DROP TABLE IF EXISTS `user_interface_info`;
CREATE TABLE `user_interface_info`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(0) NOT NULL COMMENT '调用用户 id',
  `interfaceInfoId` bigint(0) NOT NULL COMMENT '接口 id',
  `totalNum` int(0) NOT NULL DEFAULT 0 COMMENT '总调用次数',
  `leftNum` int(0) NOT NULL DEFAULT 0 COMMENT '剩余调用次数',
  `status` int(0) NOT NULL DEFAULT 0 COMMENT '0-正常 1禁用',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `isDeleted` tinyint(0) NOT NULL DEFAULT 0 COMMENT '是否删除(0-未删, 1-已删)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '接口用户关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_interface_info
-- ----------------------------
INSERT INTO `user_interface_info` VALUES (1, 1648960682721718273, 1, 20, 20, 0, '2023-04-22 17:18:12', '2023-04-22 17:18:12', 0);
INSERT INTO `user_interface_info` VALUES (2, 1648960682721718273, 2, 20, 20, 0, '2023-04-22 17:20:14', '2023-04-25 18:32:35', 0);
INSERT INTO `user_interface_info` VALUES (3, 1648960682721718273, 23, 25, 15, 0, '2023-04-22 17:20:21', '2023-05-13 15:22:50', 0);
INSERT INTO `user_interface_info` VALUES (4, 1648960682721718273, 1, 23, 17, 0, '2023-04-22 17:20:21', '2023-04-25 18:33:32', 0);
INSERT INTO `user_interface_info` VALUES (5, 1648960682721718273, 3, 44, 17, 0, '2023-04-22 17:20:21', '2023-04-25 20:02:10', 0);
INSERT INTO `user_interface_info` VALUES (6, 1648960682721718273, 23, 25, 15, 0, '2023-04-22 17:20:21', '2023-05-13 15:22:50', 0);

SET FOREIGN_KEY_CHECKS = 1;
