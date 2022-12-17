/*
Navicat MySQL Data Transfer

Source Server         : spring-test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : spring_test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001


Date: 2022-05-17 15:28:12
*/

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS spring_test;
CREATE DATABASE spring_test;

USE spring_test;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'tom', '1234','ADMIN');
INSERT INTO `user` VALUES ('2', 'jerry', '1234','USER');
INSERT INTO `user` VALUES ('3', 'master', '1234','ADMIN,USER,MANAGER');
INSERT INTO `user` VALUES ('4', 'tony', '1234','MANAGER');


DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `user_id` int(11) DEFAULT NULL,
   `point` int(11) DEFAULT 0,
   PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `award_log`;
CREATE TABLE `award_log` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `award_id` int(11) DEFAULT NULL,
    `point` int(11) DEFAULT 0,
    `description` varchar(100) DEFAULT NULL,
    `grant_date` DATETIME,
    PRIMARY KEY (id)
);

