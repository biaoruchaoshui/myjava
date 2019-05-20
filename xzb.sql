-- MySQL dump 10.13  Distrib 5.5.15, for Win32 (x86)
--
-- Host: localhost    Database: lostfind2
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'zhangsan','111111'),(2,'zhangsi','111111');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'校园卡类'),(2,'生活用品'),(3,'书籍教材'),(4,'体育器材'),(5,'零食酒水');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `findstatement`
--

DROP TABLE IF EXISTS `findstatement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `findstatement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(4000) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_findstatement_user` (`uid`),
  CONSTRAINT `fk_findstatement_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `findstatement`
--

LOCK TABLES `findstatement` WRITE;
/*!40000 ALTER TABLE `findstatement` DISABLE KEYS */;
INSERT INTO `findstatement` VALUES (1,'我昨天在一教102丢失一个水壶，白色瓶盖黑色瓶身，哪位小哥哥小姐姐捡到请call 11121212, 奶茶重酬',1,'2019-05-18 14:11:30'),(2,'我昨天在一教102丢失一个水壶，白色瓶盖黑色瓶身，哪位小哥哥小姐姐捡到请call 11121212, 奶茶重酬',1,'2019-05-18 14:14:46'),(3,'昨天我在二教193丢失一把雨伞，有哪位小哥哥小姐姐捡到，请call me 545454, 奶茶重酬',1,'2019-05-18 17:33:06'),(4,'操场丢失一个蓝色背包，里面有几本考研复习书，如果有哪位同志捡到，请call 1115515，多谢，重酬',1,'2019-05-19 10:44:54'),(5,'5月28号我在北区到西区的路上遗失一部手机，里面有很多贵重物品，请捡到的朋友帮帮忙，重酬！！',1,'2019-05-19 15:15:17'),(6,'星期二我在二教103遗失水杯一个，如果有哪位同学看到，请联系我 55445454545，重酬',2,'2019-05-20 11:16:55'),(7,'周四我在一脚丢失一个水杯，请看到的小哥哥小姐姐联系我，重酬',3,'2019-05-20 11:33:23'),(8,'我昨天在一教102丢失一个水壶，白色瓶盖黑色瓶身，哪位小哥哥小姐姐捡到请call 11121212, 奶茶重酬，食堂随便吃',2,'2019-05-20 13:45:48');
/*!40000 ALTER TABLE `findstatement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `innerletter`
--

DROP TABLE IF EXISTS `innerletter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `innerletter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `formperson` varchar(255) DEFAULT NULL,
  `toperson` varchar(255) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `lettercode` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `innerletter`
--

LOCK TABLES `innerletter` WRITE;
/*!40000 ALTER TABLE `innerletter` DISABLE KEYS */;
INSERT INTO `innerletter` VALUES (4,'罗振兴','InnerLetterService.Admin','你好，管理员，45号上交教材，高数考研那本，是我的，请问明天你们有上班吗？','2019-05-19 15:01:35',0),(5,'罗振兴','管理员','你好！管理员，23号上交的那个红色书包是我的，请问你们明天早上上班吗？','2019-05-19 15:08:50',1),(7,'罗振兴','管理员','你好！请问你们明天上班吗？','2019-05-19 15:35:50',0),(9,'管理员','','是的，我们周五上班，你可以中午过来拿。','2019-05-19 21:08:35',0),(10,'管理员','','你好！周五我们正常上班的，你可以过来','2019-05-19 21:14:57',0),(11,'管理员','','是的，我们周五上班，你可以中午过来拿。','2019-05-19 21:15:51',0),(12,'管理员','','是的，我们周五上班，你可以中午过来拿。','2019-05-19 21:27:28',0),(19,'管理员','','你好，我是才u困','2019-05-19 21:57:21',0),(22,'管理员','','你好，我是才u困','2019-05-19 22:05:54',0),(23,'管理员','???','你好，我是蔡旭昆','2019-05-19 22:08:22',0),(25,'管理员','','你好，才u混','2019-05-19 22:10:53',0),(26,'管理员','???','我据闻啊登陆怕的 的的','2019-05-19 22:15:22',0),(33,'管理员','罗振兴','没有，我们明天放假','2019-05-19 23:53:44',0),(34,'张大大','管理员','你号，管理员，昨天上交的水杯是我的，我下午可以过去拿吗？','2019-05-20 11:17:44',0),(35,'管理员','罗振兴','后天才上班','2019-05-20 11:29:19',0),(36,'管理员','张大大','可以的，你过来把，三四点都可以','2019-05-20 11:29:40',0),(37,'张大大','管理员','ok，那我三点过去','2019-05-20 13:46:10',0);
/*!40000 ALTER TABLE `innerletter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lost`
--

DROP TABLE IF EXISTS `lost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pickDate` datetime DEFAULT NULL,
  `pickperson` varchar(255) DEFAULT NULL,
  `pickplace` varchar(255) DEFAULT NULL,
  `code` int(1) DEFAULT '0',
  `claimperson` varchar(255) DEFAULT NULL,
  `claimdate` datetime DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lost_category` (`cid`),
  CONSTRAINT `fk_lost_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lost`
--

LOCK TABLES `lost` WRITE;
/*!40000 ALTER TABLE `lost` DISABLE KEYS */;
INSERT INTO `lost` VALUES (1,'饭卡','2019-05-22 00:00:00','罗形心','一脚102',1,'16同新落于零','2019-05-14 00:00:00',1),(3,'水杯','2019-05-07 00:00:00','罗振','二教302',1,'张小红','2019-05-14 00:00:00',2),(4,'帽子','2019-05-13 00:00:00','小红','二教708',0,NULL,NULL,2),(5,'18年考研英语书','2019-05-09 00:00:00','罗正','操场',0,NULL,NULL,3),(6,'高数课本','2019-05-16 00:00:00','罗大','三教1545',0,NULL,NULL,3),(7,'可比克','2019-05-27 00:00:00','苏打','一脚102',0,NULL,NULL,5),(8,'篮球','2019-05-08 00:00:00','苏二','春晖园食堂',0,NULL,NULL,4),(9,'足球','2019-05-21 00:00:00','苏尔','北区食堂',0,NULL,NULL,4),(10,'羽毛球拍','2019-05-22 00:00:00','罗三','综合馆',0,NULL,NULL,4),(11,'乒乓球拍','2019-05-06 00:00:00','苏三','后门操场',0,NULL,NULL,4);
/*!40000 ALTER TABLE `lost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lostimage`
--

DROP TABLE IF EXISTS `lostimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lostimage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lostimage_lost` (`lid`),
  CONSTRAINT `fk_lostimage_lost` FOREIGN KEY (`lid`) REFERENCES `lost` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lostimage`
--

LOCK TABLES `lostimage` WRITE;
/*!40000 ALTER TABLE `lostimage` DISABLE KEYS */;
INSERT INTO `lostimage` VALUES (1,1,'type_single'),(3,3,'type_single'),(4,4,'type_single'),(5,5,'type_single'),(6,6,'type_single'),(7,7,'type_single'),(8,8,'type_single'),(9,10,'type_single'),(10,9,'type_single'),(11,11,'type_single');
/*!40000 ALTER TABLE `lostimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(4000) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `lid` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_review_lost` (`lid`),
  KEY `fk_review_user` (`uid`),
  CONSTRAINT `fk_review_lost` FOREIGN KEY (`lid`) REFERENCES `lost` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_review_user` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'这个似乎是我舍友罗大的',1,7,'2019-05-19 16:13:01'),(2,'谁的女朋友丢了',2,8,'2019-05-20 11:30:34');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'罗振兴','123456'),(2,'张大大','123456'),(3,'李大','111111'),(4,'小红','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-20 23:42:54
