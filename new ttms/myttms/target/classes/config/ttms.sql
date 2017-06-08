-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: ttms
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_no` varchar(20) NOT NULL,
  `emp_pass` varchar(20) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0',
  `emp_name` varchar(20) DEFAULT NULL,
  `emp_tel_num` varchar(20) DEFAULT NULL,
  `emp_addr` varchar(200) DEFAULT NULL,
  `emp_email` varchar(100) DEFAULT NULL,
  `emp_sex` varchar(5) DEFAULT NULL,
  `emp_birth` varchar(20) DEFAULT NULL,
  `emp_native` varchar(60) DEFAULT NULL,
  `emp_pic` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_no` (`emp_no`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (22,'dghdhfh','123456',0,'dfgdfg','15812341234','asdsad','123412341@qq.com','男','fgdgf','fghfghgf','/pic/图片1.png'),(13,'001','123456',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/pic/影厅.jpg'),(25,'123','12345678',0,'sdf','13923232323','sdf','111@qq.com','男','sdfsd','sdf','/pic/p1797280884.jpg'),(17,'fdgdfg','123456',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'/pic/可用.jpg');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_time` datetime DEFAULT NULL,
  `notice_content` text,
  `notice_title` varchar(60) DEFAULT '无',
  PRIMARY KEY (`notice_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (7,'2016-12-10 20:58:46','fdghdfhfgjhfgj','sdfsfgsdg'),(10,'2016-12-21 11:30:03','12312','456');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `play`
--

DROP TABLE IF EXISTS `play`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `play` (
  `play_id` int(11) NOT NULL AUTO_INCREMENT,
  `play_type` varchar(100) DEFAULT NULL,
  `play_lang` varchar(20) DEFAULT NULL,
  `play_name` varchar(200) DEFAULT NULL,
  `play_introduction` varchar(2000) DEFAULT NULL,
  `play_image` varchar(200) DEFAULT NULL,
  `play_length` int(11) DEFAULT NULL,
  `play_ticket_price` decimal(10,2) DEFAULT NULL,
  `play_status` smallint(6) DEFAULT NULL COMMENT '取值含义：\r\n            0：待安排演出\r\n            1：已安排演出\r\n            -1：下线',
  `play_actor` varchar(30) DEFAULT NULL,
  `play_up_time` varchar(30)     DEFAULT NULL,
  `play_down_time` varchar(30)    DEFAULT  NULL,
  `play_orign` varchar(20) DEFAULT NULL,
  `play_director` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`play_id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play`
--
/*写死的注释*/
LOCK TABLES `play` WRITE;
/*!40000 ALTER TABLE `play` DISABLE KEYS */;
INSERT INTO `play` VALUES (27,'123','123','1123',NULL,'/picture/图片1.png',123,23.00,0),(25,'fdf','dfgdfg','dgsg',NULL,'/picture/demo2.jpg',33,22.00,0),(28,'cvxv','cxvx','dfdvd',NULL,'/picture/标志.jpg',44,34.00,0);
/*!40000 ALTER TABLE `play` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale` (
  `sale_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `sale_time` datetime DEFAULT NULL,
  `sale_payment` decimal(10,2) DEFAULT NULL,
  `sale_change` decimal(10,2) DEFAULT NULL,
  `sale_type` smallint(6) DEFAULT NULL COMMENT '类别取值含义：\r\n            1：销售单\r\n            -1：退款单',
  `sale_status` smallint(6) DEFAULT NULL COMMENT '销售单状态如下：\r\n            0：代付款\r\n            1：已付款',
  PRIMARY KEY (`sale_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_item`
--

DROP TABLE IF EXISTS `sale_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale_item` (
  `sale_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ticket_id` bigint(20) DEFAULT NULL,
  `sale_ID` bigint(20) DEFAULT NULL,
  `sale_item_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`sale_item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_item`
--

LOCK TABLES `sale_item` WRITE;
/*!40000 ALTER TABLE `sale_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `sched_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_id` int(11) NOT NULL,
  `play_id` int(11) NOT NULL,
  `sched_time` datetime NOT NULL,
  `sched_ticket_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`sched_id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (18,16,27,'2016-12-12 15:00:00',23.00),(15,9,25,'2014-03-22 12:20:00',23.00),(16,9,25,'2014-03-22 12:30:00',56.00);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `seat_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_id` int(11) DEFAULT NULL,
  `seat_row` int(11) DEFAULT NULL,
  `seat_column` int(11) DEFAULT NULL,
  `seat_status` smallint(6) DEFAULT NULL COMMENT '取值含义：\r\n                       0：此处是空位，没有安排座椅\r\n                       1：完好的座位，可以使用\r\n                       -1：座位损坏，不能安排座位',
  PRIMARY KEY (`seat_id`)
) ENGINE=MyISAM AUTO_INCREMENT=542 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (98,8,1,1,0),(99,8,1,2,0),(100,8,1,3,0),(101,8,2,1,0),(102,8,2,2,0),(103,8,2,3,0),(104,9,1,1,0),(105,9,1,2,0),(106,9,1,3,0),(107,9,2,1,0),(108,9,2,2,1),(109,9,2,3,0),(110,9,3,1,0),(111,9,3,2,0),(112,9,3,3,0),(113,10,1,1,0),(114,10,1,2,0),(115,10,1,3,0),(116,10,2,1,0),(117,10,2,2,0),(118,10,2,3,0),(119,10,3,1,0),(120,10,3,2,0),(121,10,3,3,0),(122,11,1,1,0),(123,11,1,2,0),(124,11,1,3,0),(125,11,1,4,0),(126,11,2,1,0),(127,11,2,2,0),(128,11,2,3,0),(129,11,2,4,0),(130,11,3,1,0),(131,11,3,2,0),(132,11,3,3,0),(133,11,3,4,0),(134,11,4,1,0),(135,11,4,2,0),(136,11,4,3,0),(137,11,4,4,0),(138,12,1,1,0),(139,12,1,2,0),(140,12,1,3,0),(141,12,1,4,0),(142,12,1,5,0),(143,12,1,6,0),(144,12,1,7,0),(145,12,1,8,0),(146,12,1,9,0),(147,12,1,10,0),(148,12,1,11,0),(149,12,1,12,0),(150,12,2,1,0),(151,12,2,2,0),(152,12,2,3,0),(153,12,2,4,0),(154,12,2,5,0),(155,12,2,6,0),(156,12,2,7,0),(157,12,2,8,0),(158,12,2,9,0),(159,12,2,10,0),(160,12,2,11,0),(161,12,2,12,0),(162,12,3,1,0),(163,12,3,2,0),(164,12,3,3,0),(165,12,3,4,0),(166,12,3,5,0),(167,12,3,6,0),(168,12,3,7,0),(169,12,3,8,0),(170,12,3,9,0),(171,12,3,10,0),(172,12,3,11,0),(173,12,3,12,0),(174,12,4,1,0),(175,12,4,2,0),(176,12,4,3,0),(177,12,4,4,0),(178,12,4,5,0),(179,12,4,6,0),(180,12,4,7,0),(181,12,4,8,0),(182,12,4,9,0),(183,12,4,10,0),(184,12,4,11,0),(185,12,4,12,0),(186,12,5,1,0),(187,12,5,2,0),(188,12,5,3,0),(189,12,5,4,0),(190,12,5,5,0),(191,12,5,6,0),(192,12,5,7,0),(193,12,5,8,0),(194,12,5,9,0),(195,12,5,10,0),(196,12,5,11,0),(197,12,5,12,0),(198,12,6,1,0),(199,12,6,2,0),(200,12,6,3,0),(201,12,6,4,0),(202,12,6,5,0),(203,12,6,6,0),(204,12,6,7,0),(205,12,6,8,0),(206,12,6,9,0),(207,12,6,10,0),(208,12,6,11,0),(209,12,6,12,0),(210,12,7,1,0),(211,12,7,2,0),(212,12,7,3,0),(213,12,7,4,0),(214,12,7,5,0),(215,12,7,6,0),(216,12,7,7,0),(217,12,7,8,0),(218,12,7,9,0),(219,12,7,10,0),(220,12,7,11,0),(221,12,7,12,0),(222,12,8,1,0),(223,12,8,2,0),(224,12,8,3,0),(225,12,8,4,0),(226,12,8,5,0),(227,12,8,6,0),(228,12,8,7,0),(229,12,8,8,0),(230,12,8,9,0),(231,12,8,10,0),(232,12,8,11,0),(233,12,8,12,0),(234,12,9,1,0),(235,12,9,2,0),(236,12,9,3,0),(237,12,9,4,0),(238,12,9,5,0),(239,12,9,6,0),(240,12,9,7,0),(241,12,9,8,0),(242,12,9,9,0),(243,12,9,10,0),(244,12,9,11,0),(245,12,9,12,0),(246,12,10,1,0),(247,12,10,2,0),(248,12,10,3,0),(249,12,10,4,0),(250,12,10,5,0),(251,12,10,6,0),(252,12,10,7,0),(253,12,10,8,0),(254,12,10,9,0),(255,12,10,10,0),(256,12,10,11,0),(257,12,10,12,0),(258,12,11,1,0),(259,12,11,2,0),(260,12,11,3,0),(261,12,11,4,0),(262,12,11,5,0),(263,12,11,6,0),(264,12,11,7,0),(265,12,11,8,0),(266,12,11,9,0),(267,12,11,10,0),(268,12,11,11,0),(269,12,11,12,0),(270,12,12,1,0),(271,12,12,2,0),(272,12,12,3,0),(273,12,12,4,0),(274,12,12,5,0),(275,12,12,6,0),(276,12,12,7,0),(277,12,12,8,0),(278,12,12,9,0),(279,12,12,10,0),(280,12,12,11,0),(281,12,12,12,0),(282,13,1,1,0),(283,13,1,2,0),(284,13,1,3,0),(285,13,1,4,0),(286,13,1,5,0),(287,13,2,1,0),(288,13,2,2,0),(289,13,2,3,0),(290,13,2,4,0),(291,13,2,5,0),(292,13,3,1,0),(293,13,3,2,0),(294,13,3,3,0),(295,13,3,4,0),(296,13,3,5,0),(297,13,4,1,0),(298,13,4,2,0),(299,13,4,3,0),(300,13,4,4,0),(301,13,4,5,0),(302,13,5,1,0),(303,13,5,2,0),(304,13,5,3,0),(305,13,5,4,0),(306,13,5,5,0),(307,14,1,1,0),(308,14,1,2,0),(309,14,1,3,0),(310,14,2,1,0),(311,14,2,2,0),(312,14,2,3,0),(313,14,3,1,0),(314,14,3,2,0),(315,14,3,3,0),(316,15,1,1,0),(317,15,1,2,0),(318,15,1,3,0),(319,15,1,4,0),(320,15,2,1,0),(321,15,2,2,0),(322,15,2,3,0),(323,15,2,4,0),(324,15,3,1,0),(325,15,3,2,0),(326,15,3,3,0),(327,15,3,4,0),(328,15,4,1,0),(329,15,4,2,0),(330,15,4,3,0),(331,15,4,4,0),(332,16,1,1,0),(333,16,1,2,0),(334,16,1,3,0),(335,16,1,4,0),(336,16,1,5,0),(337,16,2,1,0),(338,16,2,2,0),(339,16,2,3,0),(340,16,2,4,0),(341,16,2,5,0),(342,16,3,1,0),(343,16,3,2,0),(344,16,3,3,0),(345,16,3,4,0),(346,16,3,5,0),(347,16,4,1,0),(348,16,4,2,0),(349,16,4,3,0),(350,16,4,4,0),(351,16,4,5,0),(352,16,5,1,0),(353,16,5,2,0),(354,16,5,3,0),(355,16,5,4,0),(356,16,5,5,0),(357,17,1,1,0),(358,17,1,2,0),(359,17,1,3,0),(360,17,1,4,0),(361,17,1,5,0),(362,17,1,6,0),(363,17,2,1,0),(364,17,2,2,0),(365,17,2,3,0),(366,17,2,4,0),(367,17,2,5,0),(368,17,2,6,0),(369,17,3,1,0),(370,17,3,2,0),(371,17,3,3,-1),(372,17,3,4,0),(373,17,3,5,0),(374,17,3,6,0),(375,17,4,1,0),(376,17,4,2,0),(377,17,4,3,0),(378,17,4,4,0),(379,17,4,5,0),(380,17,4,6,0),(381,17,5,1,0),(382,17,5,2,0),(383,17,5,3,0),(384,17,5,4,0),(385,17,5,5,0),(386,17,5,6,0),(387,17,6,1,0),(388,17,6,2,0),(389,17,6,3,0),(390,17,6,4,0),(391,17,6,5,0),(392,17,6,6,0),(393,18,1,1,0),(394,18,1,2,0),(395,18,1,3,0),(396,18,1,4,0),(397,18,1,5,0),(398,18,1,6,0),(399,18,1,7,0),(400,18,2,1,0),(442,19,1,1,0),(402,18,2,3,0),(403,18,2,4,0),(404,18,2,5,0),(405,18,2,6,0),(406,18,2,7,0),(407,18,3,1,0),(408,18,3,2,0),(409,18,3,3,1),(410,18,3,4,0),(411,18,3,5,0),(412,18,3,6,0),(413,18,3,7,0),(414,18,4,1,0),(415,18,4,2,0),(416,18,4,3,0),(417,18,4,4,0),(418,18,4,5,0),(419,18,4,6,0),(420,18,4,7,0),(421,18,5,1,0),(422,18,5,2,0),(423,18,5,3,0),(424,18,5,4,0),(425,18,5,5,0),(426,18,5,6,0),(427,18,5,7,0),(428,18,6,1,0),(429,18,6,2,0),(430,18,6,3,0),(431,18,6,4,0),(432,18,6,5,0),(433,18,6,6,0),(434,18,6,7,0),(435,18,7,1,0),(436,18,7,2,0),(437,18,7,3,0),(438,18,7,4,0),(439,18,7,5,0),(440,18,7,6,0),(441,18,7,7,0),(443,19,1,2,0),(444,19,1,3,0),(445,19,1,4,0),(446,19,1,5,0),(447,19,1,6,0),(448,19,1,7,0),(449,19,1,8,0),(450,19,1,9,0),(451,19,1,10,0),(452,19,2,1,0),(453,19,2,2,0),(454,19,2,3,0),(455,19,2,4,0),(456,19,2,5,0),(457,19,2,6,0),(458,19,2,7,0),(459,19,2,8,0),(460,19,2,9,0),(461,19,2,10,0),(462,19,3,1,0),(463,19,3,2,0),(464,19,3,3,0),(465,19,3,4,0),(466,19,3,5,0),(467,19,3,6,0),(468,19,3,7,0),(469,19,3,8,0),(470,19,3,9,0),(471,19,3,10,0),(472,19,4,1,0),(473,19,4,2,0),(474,19,4,3,0),(475,19,4,4,0),(476,19,4,5,0),(477,19,4,6,0),(478,19,4,7,0),(479,19,4,8,0),(480,19,4,9,0),(481,19,4,10,0),(482,19,5,1,0),(483,19,5,2,0),(484,19,5,3,0),(485,19,5,4,0),(486,19,5,5,0),(487,19,5,6,0),(488,19,5,7,0),(489,19,5,8,0),(490,19,5,9,0),(491,19,5,10,0),(492,19,6,1,0),(493,19,6,2,0),(494,19,6,3,0),(495,19,6,4,0),(496,19,6,5,0),(497,19,6,6,0),(498,19,6,7,0),(499,19,6,8,0),(500,19,6,9,0),(501,19,6,10,0),(502,19,7,1,0),(503,19,7,2,0),(504,19,7,3,0),(505,19,7,4,0),(506,19,7,5,0),(507,19,7,6,0),(508,19,7,7,0),(509,19,7,8,0),(510,19,7,9,0),(511,19,7,10,0),(512,19,8,1,0),(513,19,8,2,0),(514,19,8,3,0),(515,19,8,4,0),(516,19,8,5,0),(517,19,8,6,0),(518,19,8,7,0),(519,19,8,8,0),(520,19,8,9,0),(521,19,8,10,0),(522,19,9,1,0),(523,19,9,2,0),(524,19,9,3,0),(525,19,9,4,0),(526,19,9,5,0),(527,19,9,6,0),(528,19,9,7,0),(529,19,9,8,0),(530,19,9,9,0),(531,19,9,10,0),(532,19,10,1,0),(533,19,10,2,0),(534,19,10,3,0),(535,19,10,4,0),(536,19,10,5,0),(537,19,10,6,0),(538,19,10,7,0),(539,19,10,8,0),(540,19,10,9,0),(541,19,10,10,0);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studio`
--

DROP TABLE IF EXISTS `studio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studio` (
  `studio_id` int(11) NOT NULL AUTO_INCREMENT,
  `studio_name` varchar(100) NOT NULL,
  `studio_row_count` int(11) DEFAULT NULL,
  `studio_col_count` int(11) DEFAULT NULL,
  `studio_introduction` varchar(2000) DEFAULT NULL,
  `studio_flag` smallint(6) DEFAULT NULL COMMENT '取值含义：\r\n                        0：尚未生成座位，可以根据行列信息生成座位\r\n                        1：已经根据影厅的座位信息安排了座位，不能再安排座位；\r\n                        -1：影厅损坏或者废弃，不能使用',
  PRIMARY KEY (`studio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studio`
--

LOCK TABLES `studio` WRITE;
/*!40000 ALTER TABLE `studio` DISABLE KEYS */;
INSERT INTO `studio` VALUES (1,'rwetre',5,6,'fdfgdg',0),(7,'qaz',2,2,'',0),(10,'asdf',3,3,'',0),(4,'2',3,3,'',0),(11,'123',4,4,'',0),(12,'123323',12,12,'',0),(13,'32132',5,5,'',0),(14,'sdf',3,3,'',0),(15,'sadfsd',4,4,'',0),(16,'asdfsd',5,5,'',0),(17,'dfdsfsdfsd',6,6,'',0);
/*!40000 ALTER TABLE `studio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `ticket_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seat_id` int(11) DEFAULT NULL,
  `sched_id` int(11) DEFAULT NULL,
  `ticket_price` decimal(10,2) DEFAULT NULL,
  `ticket_status` smallint(6) DEFAULT NULL COMMENT '含义如下：\r\n            0：待销售\r\n            1：锁定\r\n            9：卖出',
  `ticket_locked_time` datetime DEFAULT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-06 16:16:46
