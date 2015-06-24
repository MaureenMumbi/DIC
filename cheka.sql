CREATE DATABASE  IF NOT EXISTS `dic` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dic`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: dic
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `abusecode`
--

DROP TABLE IF EXISTS `abusecode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abusecode` (
  `AbuseCodeID` int(11) NOT NULL AUTO_INCREMENT,
  `AbuseCode` varchar(45) DEFAULT NULL,
  `QID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`AbuseCodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abusecode`
--

LOCK TABLES `abusecode` WRITE;
/*!40000 ALTER TABLE `abusecode` DISABLE KEYS */;
INSERT INTO `abusecode` VALUES (1,'Within 24 hours',NULL),(2,'Within 7 days',NULL),(3,'Within 30 days',NULL),(4,'More thaan 30 days ago',NULL);
/*!40000 ALTER TABLE `abusecode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ages`
--

DROP TABLE IF EXISTS `ages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ages` (
  `Ages_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ages` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Ages_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ages`
--

LOCK TABLES `ages` WRITE;
/*!40000 ALTER TABLE `ages` DISABLE KEYS */;
INSERT INTO `ages` VALUES (1,'null'),(2,'null'),(3,'null'),(4,'null'),(5,'null');
/*!40000 ALTER TABLE `ages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alcohol_codes`
--

DROP TABLE IF EXISTS `alcohol_codes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alcohol_codes` (
  `Alcohol_CodesID` int(11) NOT NULL AUTO_INCREMENT,
  `Alcohol_Codes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Alcohol_CodesID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alcohol_codes`
--

LOCK TABLES `alcohol_codes` WRITE;
/*!40000 ALTER TABLE `alcohol_codes` DISABLE KEYS */;
INSERT INTO `alcohol_codes` VALUES (1,'5 or More times a week'),(2,'2 or 4 times a week'),(3,'Once a week or less'),(4,'Monthly or less');
/*!40000 ALTER TABLE `alcohol_codes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `audit`
--

DROP TABLE IF EXISTS `audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `audit` (
  `AuditID` int(50) NOT NULL AUTO_INCREMENT,
  `UniqueID` varchar(45) DEFAULT NULL,
  `DrnkAlc` varchar(200) DEFAULT NULL,
  `AlchHav` varchar(200) DEFAULT NULL,
  `DrnkOcc` varchar(200) DEFAULT NULL,
  `StpDrnk` varchar(200) DEFAULT NULL,
  `FailDrnk` varchar(200) DEFAULT NULL,
  `RemHap` varchar(200) DEFAULT NULL,
  `NeedAlc` varchar(200) DEFAULT NULL,
  `GuiltDrnk` varchar(200) DEFAULT NULL,
  `InjureDrnk` varchar(200) DEFAULT NULL,
  `FriendDrnk` varchar(200) DEFAULT NULL,
  `DrnkAlctxt` varchar(45) DEFAULT NULL,
  `AlchHavtxt` varchar(45) DEFAULT NULL,
  `DrnkOcctxt` varchar(45) DEFAULT NULL,
  `StpDrnktxt` varchar(45) DEFAULT NULL,
  `FailDrnktxt` varchar(45) DEFAULT NULL,
  `RemHaptxt` varchar(45) DEFAULT NULL,
  `NeedAlctxt` varchar(45) DEFAULT NULL,
  `GuiltDrnktxt` varchar(45) DEFAULT NULL,
  `InjureDrnktxt` varchar(45) DEFAULT NULL,
  `FriendDrnktxt` varchar(45) DEFAULT NULL,
  `FinalAudit` int(11) DEFAULT NULL,
  PRIMARY KEY (`AuditID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audit`
--

LOCK TABLES `audit` WRITE;
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `behaviourscode`
--

DROP TABLE IF EXISTS `behaviourscode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `behaviourscode` (
  `BehavioursCodeID` int(11) NOT NULL AUTO_INCREMENT,
  `BehavioursCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BehavioursCodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `behaviourscode`
--

LOCK TABLES `behaviourscode` WRITE;
/*!40000 ALTER TABLE `behaviourscode` DISABLE KEYS */;
INSERT INTO `behaviourscode` VALUES (1,'N/A'),(2,'Never'),(3,'Sometimes (<50%)'),(4,'Most times (>50%)'),(5,'Always (100%)');
/*!40000 ALTER TABLE `behaviourscode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadrecode`
--

DROP TABLE IF EXISTS `cadrecode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadrecode` (
  `CadreCodeID` int(11) NOT NULL AUTO_INCREMENT,
  `CadreCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CadreCodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadrecode`
--

LOCK TABLES `cadrecode` WRITE;
/*!40000 ALTER TABLE `cadrecode` DISABLE KEYS */;
INSERT INTO `cadrecode` VALUES (1,'Doctor'),(3,'Nurse'),(4,'Community Volunteer'),(5,'Counselor'),(6,'Other');
/*!40000 ALTER TABLE `cadrecode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `childage`
--

DROP TABLE IF EXISTS `childage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `childage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ChildID` varchar(45) DEFAULT NULL,
  `UniqueID` varchar(200) DEFAULT NULL,
  `AgeBrackets` varchar(200) DEFAULT NULL,
  `NoChild` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `childage`
--

LOCK TABLES `childage` WRITE;
/*!40000 ALTER TABLE `childage` DISABLE KEYS */;
INSERT INTO `childage` VALUES (1,'L.L.L/2013-08-24/44','','null','5'),(2,'L.L.M/2013-08-24/45','','[Ljava.lang.String;@108994b','5'),(3,'O.O.O/2013-08-24/46','Kajiado/08/2013/46','[Ljava.lang.String;@15396c0','3'),(4,'O.O.O/2013-08-24/48','Kajiado/08/2013/48','[Ljava.lang.String;@e4d0d2','3'),(5,'O.O.O/2013-08-24/49','Kajiado/08/2013/49','[Ljava.lang.String;@1f3de6d','3'),(6,'O.O.O/2013-08-24/50','Kajiado/08/2013/50','[Ljava.lang.String;@13532ad','3'),(7,'P.O.H/2013-08-24/53','Nakuru/08/2013/53','[Ljava.lang.String;@7370ad','3'),(8,'uuu/2013-08-24/54','Nakuru/08/2013/54','[Ljava.lang.String;@1587174','3'),(9,'P.K.O/2013-08-24/55','Kajiado/08/2013/55','[Ljava.lang.String;@bfa784','1'),(10,'U.H.G/2013-08-24/56','Kajiado/08/2013/56','[Ljava.lang.String;@23b95e','1'),(11,'I,L,O/2013-08-25/57','Kajiado/08/2013/57','nullon  ','null4  '),(12,'S.K.L/2013-08-25/58','Nakuru/08/2013/58','null1  5  ','null1    3    1  '),(13,'S.K.L/2013-08-25/59','Nakuru/08/2013/59','null1  5  ','null1    3    1  '),(14,'O.P.I/2013-08-26/60','Kajiado/08/2013/60','null1  3  5  ','null          '),(15,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','1',''),(16,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','2',''),(17,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','3',''),(18,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','4',''),(19,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','5',''),(20,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','1',''),(21,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','2',''),(22,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','3',''),(23,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','4',''),(24,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','5',''),(25,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','1',''),(26,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','2',''),(27,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','3',''),(28,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','4',''),(29,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','5',''),(30,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','1',''),(31,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','2',''),(32,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','3',''),(33,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','4',''),(34,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','5',''),(35,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','1',''),(36,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','2',''),(37,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','3',''),(38,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','4',''),(39,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','5',''),(40,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','1','1'),(41,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','2','1'),(42,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','4','1'),(43,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','5','1'),(44,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','1','4'),(45,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','2','4'),(46,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','4','4'),(47,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','5','4'),(48,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','1','2'),(49,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','2','2'),(50,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','4','2'),(51,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','5','2'),(52,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','1','8'),(53,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','2','8'),(54,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','4','8'),(55,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','5','8'),(56,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','1','10'),(57,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','2','10'),(58,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','4','10'),(59,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','5','10'),(60,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','1','1'),(61,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','2','4'),(62,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','3','2'),(63,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','4','8'),(64,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','5','10'),(65,'kkk/2013-08-26/64','Kajiado/08/2013/64','1','5'),(66,'kkk/2013-08-26/64','Kajiado/08/2013/64','3',''),(67,'P.o.l/2013-08-28/66','Kajiado/08/2013/66','2',''),(68,'P.o.l/2013-08-28/66','Kajiado/08/2013/66','5',''),(69,'M.N.O/2013-08-29/69','Kajiado/08/2013/69','5','4'),(70,'M.N.O/2013-08-29/70','Nakuru/08/2013/70','2','2'),(71,'M.N.O/2013-08-29/71','Nakuru/08/2013/71','2','2'),(72,'M.N.O/2013-08-29/72','Nakuru/08/2013/72','2','2'),(73,'O.P.I/2013-08-29/73','Nakuru/08/2013/73','1','2'),(74,'O.P.I/2013-08-29/73','Nakuru/08/2013/73','3','4'),(75,'M.N.O/2013-08-29/74','Kajiado/08/2013/74','1','1'),(76,'L.L.L/2013-08-29/101','Kajiado/08/2013/101','2','2'),(77,'L.L.L/2013-08-29/102','Kajiado/08/2013/102','2','2'),(78,'L.L.L/2013-08-29/103','Kajiado/08/2013/103','2','2'),(79,'L.L.L/2013-08-29/104','Kajiado/08/2013/104','2','2'),(80,'L.L.L/2013-08-29/105','Kajiado/08/2013/105','2','2'),(81,'L.L.L/2013-08-29/106','Kajiado/08/2013/106','2','2'),(82,'QQQ/2013-08-30/118','Nakuru/08/2013/118','1','6'),(83,'O.P.I/2013-08-31/122','','1','2'),(84,'O.P.I/2013-08-31/122','','2','1'),(85,'O.O.O/2013-09-02/123','','2','5'),(86,'L.L.L/2013-09-04/124','','2','3'),(87,'L.L.L/2013-09-04/124','','4','2'),(88,'MMM/2013-09-05/125','Laikipia/09/2013/124','2','5'),(89,'M.N.O/2013-09-06/126','Kajiado/09/2013/125','4','1'),(90,'ooo/2013-09-09/127','Kajiado/09/2013/126','2','6');
/*!40000 ALTER TABLE `childage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientlearnt`
--

DROP TABLE IF EXISTS `clientlearnt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientlearnt` (
  `ClientLearntID` int(11) NOT NULL AUTO_INCREMENT,
  `ClientLearnt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ClientLearntID`),
  UNIQUE KEY `ClientLearnt_UNIQUE` (`ClientLearnt`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientlearnt`
--

LOCK TABLES `clientlearnt` WRITE;
/*!40000 ALTER TABLE `clientlearnt` DISABLE KEYS */;
INSERT INTO `clientlearnt` VALUES (1,'Friend'),(3,'Health Providers'),(4,'Others'),(2,'Peer Educator');
/*!40000 ALTER TABLE `clientlearnt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientmember`
--

DROP TABLE IF EXISTS `clientmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientmember` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MemberID` varchar(45) DEFAULT NULL,
  `UniqueID` varchar(45) DEFAULT NULL,
  `MemID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientmember`
--

LOCK TABLES `clientmember` WRITE;
/*!40000 ALTER TABLE `clientmember` DISABLE KEYS */;
INSERT INTO `clientmember` VALUES (1,'L.L.L/2013-09-04/124','','1'),(2,'L.L.L/2013-09-04/124','','2'),(3,'L.L.L/2013-09-04/124','','2'),(4,'L.L.L/2013-09-04/124','','1'),(5,'MMM/2013-09-05/125','Laikipia/09/2013/124','1'),(6,'MMM/2013-09-05/125','Laikipia/09/2013/124','2'),(7,'MMM/2013-09-05/125','Laikipia/09/2013/124','1'),(8,'MMM/2013-09-05/125','Laikipia/09/2013/124','1'),(9,'M.N.O/2013-09-06/126','Kajiado/09/2013/125','1'),(10,'M.N.O/2013-09-06/126','Kajiado/09/2013/125','1'),(11,'M.N.O/2013-09-06/126','Kajiado/09/2013/125','2'),(12,'M.N.O/2013-09-06/126','Kajiado/09/2013/125','1'),(13,'ooo/2013-09-09/127','Kajiado/09/2013/126','1'),(14,'ooo/2013-09-09/127','Kajiado/09/2013/126','2'),(15,'ooo/2013-09-09/127','Kajiado/09/2013/126','1'),(16,'ooo/2013-09-09/127','Kajiado/09/2013/126','1');
/*!40000 ALTER TABLE `clientmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientoccupation`
--

DROP TABLE IF EXISTS `clientoccupation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientoccupation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CoccID` varchar(45) DEFAULT NULL,
  `UniqueID` varchar(45) DEFAULT NULL,
  `OccupationID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientoccupation`
--

LOCK TABLES `clientoccupation` WRITE;
/*!40000 ALTER TABLE `clientoccupation` DISABLE KEYS */;
INSERT INTO `clientoccupation` VALUES (1,'L.L.L/2013-08-24/44','','on'),(2,'L.L.M/2013-08-24/45','','[Ljava.lang.String;@1883bab'),(3,'O.O.O/2013-08-24/46','Kajiado/08/2013/46','[Ljava.lang.String;@ce2b6b'),(4,'O.O.O/2013-08-24/48','Kajiado/08/2013/48','[Ljava.lang.String;@49a82c'),(5,'O.O.O/2013-08-24/49','Kajiado/08/2013/49','[Ljava.lang.String;@18ff64b'),(6,'O.O.O/2013-08-24/50','Kajiado/08/2013/50','[Ljava.lang.String;@191fe86'),(7,'P.O.H/2013-08-24/53','Nakuru/08/2013/53','[Ljava.lang.String;@ea743d'),(8,'uuu/2013-08-24/54','Nakuru/08/2013/54','[Ljava.lang.String;@180b2dc'),(9,'P.K.O/2013-08-24/55','Kajiado/08/2013/55','[Ljava.lang.String;@8f06fd'),(10,'U.H.G/2013-08-24/56','Kajiado/08/2013/56','[Ljava.lang.String;@15ee823'),(11,'I,L,O/2013-08-25/57','Kajiado/08/2013/57','null2  on  '),(12,'S.K.L/2013-08-25/58','Nakuru/08/2013/58','null4  6  '),(13,'S.K.L/2013-08-25/59','Nakuru/08/2013/59','null4  6  '),(14,'O.P.I/2013-08-26/60','Kajiado/08/2013/60','null4  '),(15,'O.P.I/2013-08-26/61','Kajiado/08/2013/61','4'),(16,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','1'),(17,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','2'),(18,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','3'),(19,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','4'),(20,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','5'),(21,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','6'),(22,'O.P.I/2013-08-26/62','Kajiado/08/2013/62','7'),(23,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','1'),(24,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','2'),(25,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','3'),(26,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','4'),(27,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','5'),(28,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','6'),(29,'P.I.L/2013-08-26/63','Nakuru/08/2013/63','7'),(30,'kkk/2013-08-26/64','Kajiado/08/2013/64','4'),(31,'kkk/2013-08-26/64','Kajiado/08/2013/64','6'),(32,'P.o.l/2013-08-28/66','Kajiado/08/2013/66','4'),(33,'P.o.l/2013-08-28/66','Kajiado/08/2013/66','6'),(34,'M.N.O/2013-08-29/69','Kajiado/08/2013/69','1'),(35,'M.N.O/2013-08-29/70','Nakuru/08/2013/70','4'),(36,'M.N.O/2013-08-29/71','Nakuru/08/2013/71','4'),(37,'M.N.O/2013-08-29/72','Nakuru/08/2013/72','4'),(38,'O.P.I/2013-08-29/73','Nakuru/08/2013/73','4'),(39,'M.N.O/2013-08-29/74','Kajiado/08/2013/74','4'),(40,'M.O.L/2013-08-29/75','Kajiado/08/2013/75','3'),(41,'M.O.L/2013-08-29/75','Kajiado/08/2013/75','4'),(42,'M.O.L/2013-08-29/76','Kajiado/08/2013/76','3'),(43,'M.O.L/2013-08-29/76','Kajiado/08/2013/76','4'),(44,'M.O.L/2013-08-29/77','Kajiado/08/2013/77','3'),(45,'M.O.L/2013-08-29/77','Kajiado/08/2013/77','4'),(46,'L.L.L/2013-08-29/101','Kajiado/08/2013/101','4'),(47,'L.L.L/2013-08-29/102','Kajiado/08/2013/102','4'),(48,'L.L.L/2013-08-29/103','Kajiado/08/2013/103','4'),(49,'L.L.L/2013-08-29/104','Kajiado/08/2013/104','4'),(50,'L.L.L/2013-08-29/105','Kajiado/08/2013/105','4'),(51,'L.L.L/2013-08-29/106','Kajiado/08/2013/106','4'),(52,'mmm/2013-08-30/108','Kajiado/08/2013/108','1'),(53,'mmm/2013-08-30/109','Kajiado/08/2013/109','1'),(54,'QQQ/2013-08-30/118','Nakuru/08/2013/118','4'),(55,'M.N.O/2013-08-30/120','','3'),(56,'M.N.O/2013-08-30/120','','6'),(57,'dsfsgfd/2013-08-30/121','','6'),(58,'O.P.I/2013-08-31/122','','2'),(59,'O.P.I/2013-08-31/122','','6'),(60,'O.O.O/2013-09-02/123','','4'),(61,'L.L.L/2013-09-04/124','','2'),(62,'L.L.L/2013-09-04/124','','3'),(63,'MMM/2013-09-05/125','Laikipia/09/2013/124','2'),(64,'MMM/2013-09-05/125','Laikipia/09/2013/124','6'),(65,'M.N.O/2013-09-06/126','Kajiado/09/2013/125','2'),(66,'ooo/2013-09-09/127','Kajiado/09/2013/126','2'),(67,'ooo/2013-09-09/127','Kajiado/09/2013/126','4');
/*!40000 ALTER TABLE `clientoccupation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientoparea`
--

DROP TABLE IF EXISTS `clientoparea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientoparea` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COPID` varchar(45) DEFAULT NULL,
  `UniqueID` varchar(45) DEFAULT NULL,
  `AreaOpID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientoparea`
--

LOCK TABLES `clientoparea` WRITE;
/*!40000 ALTER TABLE `clientoparea` DISABLE KEYS */;
INSERT INTO `clientoparea` VALUES (1,'L.L.L/2013-09-04/124','','2'),(2,'L.L.L/2013-09-04/124','','4'),(3,'MMM/2013-09-05/125','Laikipia/09/2013/124','2'),(4,'MMM/2013-09-05/125','Laikipia/09/2013/124','8'),(5,'M.N.O/2013-09-06/126','Kajiado/09/2013/125','2'),(6,'ooo/2013-09-09/127','Kajiado/09/2013/126','2'),(7,'ooo/2013-09-09/127','Kajiado/09/2013/126','4');
/*!40000 ALTER TABLE `clientoparea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codes`
--

DROP TABLE IF EXISTS `codes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codes` (
  `CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `CodeName` varchar(45) DEFAULT NULL,
  `SubDomainID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codes`
--

LOCK TABLES `codes` WRITE;
/*!40000 ALTER TABLE `codes` DISABLE KEYS */;
INSERT INTO `codes` VALUES (1,'Codes for A','1'),(2,'Codes for I','1'),(3,'Codes for J','1'),(4,'Codes for L','1'),(5,'Codes for N(c)','2'),(6,'Codes for P(d)','2'),(7,'Codes for Q(b), R(c)','4');
/*!40000 ALTER TABLE `codes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `condomcode`
--

DROP TABLE IF EXISTS `condomcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condomcode` (
  `CondomCodeID` int(11) NOT NULL AUTO_INCREMENT,
  `CondomCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CondomCodeID`),
  UNIQUE KEY `CondomCode_UNIQUE` (`CondomCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condomcode`
--

LOCK TABLES `condomcode` WRITE;
/*!40000 ALTER TABLE `condomcode` DISABLE KEYS */;
INSERT INTO `condomcode` VALUES (1,'Always'),(3,'Never'),(2,'Sometimes');
/*!40000 ALTER TABLE `condomcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `condomprovider`
--

DROP TABLE IF EXISTS `condomprovider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condomprovider` (
  `CondomProviderID` int(11) NOT NULL AUTO_INCREMENT,
  `CondomProvider` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CondomProviderID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condomprovider`
--

LOCK TABLES `condomprovider` WRITE;
/*!40000 ALTER TABLE `condomprovider` DISABLE KEYS */;
INSERT INTO `condomprovider` VALUES (1,'null'),(2,'today ');
/*!40000 ALTER TABLE `condomprovider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cscode`
--

DROP TABLE IF EXISTS `cscode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cscode` (
  `CSCodeID` int(11) NOT NULL AUTO_INCREMENT,
  `CSCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CSCodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cscode`
--

LOCK TABLES `cscode` WRITE;
/*!40000 ALTER TABLE `cscode` DISABLE KEYS */;
INSERT INTO `cscode` VALUES (2,'hxcvbhd'),(3,'yessnull '),(4,'nbnhj'),(5,'bv');
/*!40000 ALTER TABLE `cscode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currentstatus`
--

DROP TABLE IF EXISTS `currentstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currentstatus` (
  `currentStatusID` int(11) NOT NULL AUTO_INCREMENT,
  `currentStatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`currentStatusID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currentstatus`
--

LOCK TABLES `currentstatus` WRITE;
/*!40000 ALTER TABLE `currentstatus` DISABLE KEYS */;
INSERT INTO `currentstatus` VALUES (1,'Always'),(2,'Sometimes'),(3,'Never');
/*!40000 ALTER TABLE `currentstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diclearn`
--

DROP TABLE IF EXISTS `diclearn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diclearn` (
  `DICLearnID` int(50) NOT NULL AUTO_INCREMENT,
  `UniqueID` varchar(200) NOT NULL,
  `DICLearnHow` varchar(200) NOT NULL,
  PRIMARY KEY (`DICLearnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diclearn`
--

LOCK TABLES `diclearn` WRITE;
/*!40000 ALTER TABLE `diclearn` DISABLE KEYS */;
/*!40000 ALTER TABLE `diclearn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dicname`
--

DROP TABLE IF EXISTS `dicname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dicname` (
  `DICNameID` int(11) NOT NULL AUTO_INCREMENT,
  `DICName` varchar(45) DEFAULT NULL,
  `DistrictID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DICNameID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dicname`
--

LOCK TABLES `dicname` WRITE;
/*!40000 ALTER TABLE `dicname` DISABLE KEYS */;
INSERT INTO `dicname` VALUES (1,'Nakuru Central','1'),(2,'Salgaa ','2'),(3,'Naivasha','3'),(4,'Narok','4'),(5,'Nanyuki','5'),(29,'Nakuru Central','2'),(30,'Nakuru Central','3'),(31,'Nakuru Central','4'),(32,'Nakuru Central','5'),(33,'Salgaa ','1'),(34,'Salgaa','3'),(35,'Salgaa','4'),(36,'Salgaa','5'),(37,'Naivasha','1'),(38,'Naivasha','2'),(39,'Naivasha','4'),(40,'Naivasha','5'),(41,'Narok','1'),(42,'Narok','2'),(43,'Narok','3'),(44,'Narok','5'),(45,'Nanyuki','2'),(46,'Nanyuki','3'),(47,'Nanyuki','4'),(48,'Nanyuki','1');
/*!40000 ALTER TABLE `dicname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district` (
  `DistrictID` int(11) NOT NULL AUTO_INCREMENT,
  `DistrictName` varchar(45) DEFAULT NULL,
  `DICName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DistrictID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,'Kajiado','Kajiado East'),(2,'Nakuru','Nakuru West'),(3,'Nakuru','Nakuru East');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `districts`
--

DROP TABLE IF EXISTS `districts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `districts` (
  `DistrictID` int(11) NOT NULL AUTO_INCREMENT,
  `District` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DistrictID`),
  UNIQUE KEY `District_UNIQUE` (`District`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `districts`
--

LOCK TABLES `districts` WRITE;
/*!40000 ALTER TABLE `districts` DISABLE KEYS */;
INSERT INTO `districts` VALUES (5,'Baringo'),(1,'Kajiado'),(2,'Laikipia'),(3,'Nakuru'),(4,'Narok');
/*!40000 ALTER TABLE `districts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domains`
--

DROP TABLE IF EXISTS `domains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domains` (
  `DomainID` int(11) NOT NULL AUTO_INCREMENT,
  `Domain` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DomainID`),
  UNIQUE KEY `Domain_UNIQUE` (`Domain`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domains`
--

LOCK TABLES `domains` WRITE;
/*!40000 ALTER TABLE `domains` DISABLE KEYS */;
INSERT INTO `domains` VALUES (1,'Risk Assessment'),(2,'Risk Reduction');
/*!40000 ALTER TABLE `domains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `douche_code`
--

DROP TABLE IF EXISTS `douche_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `douche_code` (
  `douche_CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `douche_Code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`douche_CodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `douche_code`
--

LOCK TABLES `douche_code` WRITE;
/*!40000 ALTER TABLE `douche_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `douche_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dummy`
--

DROP TABLE IF EXISTS `dummy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dummy` (
  `UniqueID` int(11) NOT NULL AUTO_INCREMENT,
  `FHIClient` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UniqueID`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dummy`
--

LOCK TABLES `dummy` WRITE;
/*!40000 ALTER TABLE `dummy` DISABLE KEYS */;
INSERT INTO `dummy` VALUES (1,'FHIClient'),(2,'FHIClient'),(3,'FHIClient'),(4,'FHIClient'),(5,'FHIClient'),(6,'FHIClient'),(7,'FHIClient'),(8,'FHIClient'),(9,'FHIClient'),(10,'FHIClient'),(11,'FHIClient'),(12,'FHIClient'),(13,'FHIClient'),(14,'FHIClient'),(15,'FHIClient'),(16,'FHIClient'),(17,'FHIClient'),(18,'FHIClient'),(19,'FHIClient'),(20,'FHIClient'),(21,'FHIClient'),(22,'FHIClient'),(23,'FHIClient'),(24,'FHIClient'),(25,'FHIClient'),(26,'FHIClient'),(27,'FHIClient'),(28,'FHIClient'),(29,'FHIClient'),(30,'FHIClient'),(31,'FHIClient'),(32,'FHIClient'),(33,'FHIClient'),(34,'FHIClient'),(35,'FHIClient'),(36,'FHIClient'),(37,'FHIClient'),(38,'FHIClient'),(39,'FHIClient'),(40,'FHIClient'),(41,'FHIClient'),(42,'FHIClient'),(43,'FHIClient'),(44,'FHIClient'),(45,'FHIClient'),(46,'FHIClient'),(47,'FHIClient'),(48,'FHIClient'),(49,'FHIClient'),(50,'FHIClient'),(51,'FHIClient'),(52,'FHIClient'),(53,'FHIClient'),(54,'FHIClient'),(55,'FHIClient'),(56,'FHIClient'),(57,'FHIClient'),(58,'FHIClient'),(59,'FHIClient'),(60,'FHIClient'),(61,'FHIClient'),(62,'FHIClient'),(63,'FHIClient'),(64,'FHIClient'),(65,'FHIClient'),(66,'FHIClient'),(67,'FHIClient'),(68,'FHIClient'),(69,'FHIClient'),(70,'FHIClient'),(71,'FHIClient'),(72,'FHIClient'),(73,'FHIClient'),(74,'FHIClient'),(75,'FHIClient'),(76,'FHIClient'),(77,'FHIClient'),(78,'FHIClient'),(79,'FHIClient'),(80,'FHIClient'),(81,'FHIClient'),(82,'FHIClient'),(83,'FHIClient'),(84,'FHIClient'),(85,'FHIClient'),(86,'FHIClient'),(87,'FHIClient'),(88,'FHIClient'),(89,'FHIClient'),(90,'FHIClient'),(91,'FHIClient'),(92,'FHIClient'),(93,'FHIClient'),(94,'FHIClient'),(95,'FHIClient'),(96,'FHIClient'),(97,'FHIClient'),(98,'FHIClient'),(99,'FHIClient'),(100,'FHIClient'),(101,'FHIClient'),(102,'FHIClient'),(103,'FHIClient'),(104,'FHIClient'),(105,'FHIClient'),(106,'FHIClient'),(107,'FHIClient'),(108,'FHIClient'),(109,'FHIClient'),(110,'FHIClient'),(111,'FHIClient'),(112,'FHIClient'),(113,'FHIClient'),(114,'FHIClient'),(115,'FHIClient'),(116,'FHIClient'),(117,'FHIClient'),(118,'FHIClient'),(119,'FHIClient'),(120,'FHIClient'),(121,'FHIClient'),(122,'FHIClient'),(123,'FHIClient'),(124,'FHIClient'),(125,'FHIClient'),(126,'FHIClient');
/*!40000 ALTER TABLE `dummy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educationlevel`
--

DROP TABLE IF EXISTS `educationlevel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educationlevel` (
  `EducationLevelID` int(11) NOT NULL AUTO_INCREMENT,
  `EducationLevel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EducationLevelID`),
  UNIQUE KEY `EducationLevel_UNIQUE` (`EducationLevel`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationlevel`
--

LOCK TABLES `educationlevel` WRITE;
/*!40000 ALTER TABLE `educationlevel` DISABLE KEYS */;
INSERT INTO `educationlevel` VALUES (4,'Post-Secondary'),(1,'Pre-Primary '),(2,'Primary'),(3,'Secondary');
/*!40000 ALTER TABLE `educationlevel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollment` (
  `UniqueID` varchar(100) NOT NULL,
  `ClientInit` varchar(45) DEFAULT NULL,
  `DOE` text,
  `District` varchar(45) DEFAULT NULL,
  `DICName` varchar(45) DEFAULT NULL,
  `DOB` varchar(45) DEFAULT NULL,
  `Sex` varchar(45) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `MaritalStatus` varchar(45) DEFAULT NULL,
  `Children` varchar(45) DEFAULT NULL,
  `ChildNo` text,
  `Religion` varchar(45) DEFAULT NULL,
  `EducationLevel` varchar(45) DEFAULT NULL,
  `PhoneNo` varchar(45) DEFAULT NULL,
  `Residence` varchar(45) DEFAULT NULL,
  `OperationArea` varchar(45) DEFAULT NULL,
  `Occupation` varchar(45) DEFAULT NULL,
  `MemberOfID` varchar(45) DEFAULT NULL,
  `DICLearn` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `PhoneNo1` varchar(45) DEFAULT NULL,
  `Venue` varchar(45) DEFAULT NULL,
  `AgeID` varchar(45) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `SecondName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UniqueID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment`
--

LOCK TABLES `enrollment` WRITE;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
INSERT INTO `enrollment` VALUES ('Kajiado/09/2013/123','L.L.L','09/09/2013','1','Nakuru Central','08/09/1950',' Male ',63,' 2 ','Yes','5','Muslim','4','0712894123','2','null','null','null','3','mollymumbi@gmail.com','0712789065','3','null','MAUREEN','Mumbi','Maina'),('Kajiado/09/2013/125','M.N.O','06/09/2013','1','Salgaa ','15/09/1952','Male',60,'2','Yes','1','Christian','1','0712894123','4','M.N.O/2013-09-06/126','M.N.O/2013-09-06/126','M.N.O/2013-09-06/126','3','mollymumbi@gmail.com','0712789065','4','M.N.O/2013-09-06/126',NULL,NULL,NULL),('Kajiado/09/2013/126','ooo','11/09/2013','1','','09/09/1997','Male',16,'2','Yes','6','Muslim','4','0712894123','3','ooo/2013-09-09/127','ooo/2013-09-09/127','ooo/2013-09-09/127','3','mollymumbi@gmail.com','0712789065','4','ooo/2013-09-09/127',NULL,NULL,NULL),('Laikipia/09/2013/124','MMM','19/09/2013','2','Naivasha','13/09/1988','Male',24,'2','Yes','5','Christian','1','0712894123','3','MMM/2013-09-05/125','MMM/2013-09-05/125','MMM/2013-09-05/125','3','mollymumbi@gmail.com','0712789065','3','MMM/2013-09-05/125',NULL,NULL,NULL);
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fpmethods_code`
--

DROP TABLE IF EXISTS `fpmethods_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fpmethods_code` (
  `FPMethods_CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `FPMethods_Code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`FPMethods_CodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fpmethods_code`
--

LOCK TABLES `fpmethods_code` WRITE;
/*!40000 ALTER TABLE `fpmethods_code` DISABLE KEYS */;
INSERT INTO `fpmethods_code` VALUES (1,'Pills'),(2,'Injectable'),(3,'Condoms'),(4,'Tubal Ligation'),(5,'IUD'),(6,'Rhythm'),(7,'Traditional');
/*!40000 ALTER TABLE `fpmethods_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indicatoractivities`
--

DROP TABLE IF EXISTS `indicatoractivities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `indicatoractivities` (
  `activityID` int(11) NOT NULL AUTO_INCREMENT,
  `unit` varchar(45) DEFAULT NULL,
  `DistrictID` varchar(45) DEFAULT NULL,
  `activityTitle` varchar(45) DEFAULT NULL,
  `startDate` text,
  `endDate` text,
  `men` text,
  `women` text,
  PRIMARY KEY (`activityID`),
  KEY `DistrictID` (`DistrictID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indicatoractivities`
--

LOCK TABLES `indicatoractivities` WRITE;
/*!40000 ALTER TABLE `indicatoractivities` DISABLE KEYS */;
/*!40000 ALTER TABLE `indicatoractivities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indicatorresults`
--

DROP TABLE IF EXISTS `indicatorresults`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `indicatorresults` (
  `resultID` int(11) NOT NULL AUTO_INCREMENT,
  `activityID` int(11) DEFAULT NULL,
  `districtID` int(11) DEFAULT NULL,
  `baseLine` text,
  `menTarget` text,
  `womenTarget` text,
  `menAchieved` text,
  `womenAchieved` text,
  `reportingPeriod` text,
  `financialYear` text,
  `indicatorresultscol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`resultID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indicatorresults`
--

LOCK TABLES `indicatorresults` WRITE;
/*!40000 ALTER TABLE `indicatorresults` DISABLE KEYS */;
/*!40000 ALTER TABLE `indicatorresults` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge_code`
--

DROP TABLE IF EXISTS `knowledge_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge_code` (
  `Knowledge_CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `Knowledge_Code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Knowledge_CodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_code`
--

LOCK TABLES `knowledge_code` WRITE;
/*!40000 ALTER TABLE `knowledge_code` DISABLE KEYS */;
INSERT INTO `knowledge_code` VALUES (1,'Low'),(2,'Average'),(3,'Good');
/*!40000 ALTER TABLE `knowledge_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lastsex_code`
--

DROP TABLE IF EXISTS `lastsex_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lastsex_code` (
  `LastSex_CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `LastSex_Code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`LastSex_CodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lastsex_code`
--

LOCK TABLES `lastsex_code` WRITE;
/*!40000 ALTER TABLE `lastsex_code` DISABLE KEYS */;
INSERT INTO `lastsex_code` VALUES (1,'Within 24 hours'),(2,'Within 7 days'),(3,'Within 30 days'),(4,'More than 30 days ago');
/*!40000 ALTER TABLE `lastsex_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marital_status`
--

DROP TABLE IF EXISTS `marital_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marital_status` (
  `Marital_StatusID` int(11) NOT NULL AUTO_INCREMENT,
  `Marital_Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Marital_StatusID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marital_status`
--

LOCK TABLES `marital_status` WRITE;
/*!40000 ALTER TABLE `marital_status` DISABLE KEYS */;
INSERT INTO `marital_status` VALUES (1,'Married'),(2,'Single'),(3,'Live-in-Partners'),(4,'Divorced'),(5,'Separated'),(6,'Widowed');
/*!40000 ALTER TABLE `marital_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MemberID` varchar(45) DEFAULT NULL,
  `UniqueID` varchar(50) DEFAULT NULL,
  `MemberName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occupation`
--

DROP TABLE IF EXISTS `occupation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `occupation` (
  `OccupationID` int(11) NOT NULL AUTO_INCREMENT,
  `Occupation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OccupationID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occupation`
--

LOCK TABLES `occupation` WRITE;
/*!40000 ALTER TABLE `occupation` DISABLE KEYS */;
INSERT INTO `occupation` VALUES (1,'small business'),(2,'Hawking'),(3,'Farming'),(4,'Casual laborer'),(5,'Artisan'),(6,'Formal Employment'),(7,'Sex Work'),(8,'None');
/*!40000 ALTER TABLE `occupation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operationarea`
--

DROP TABLE IF EXISTS `operationarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operationarea` (
  `OperationAreaID` int(11) NOT NULL AUTO_INCREMENT,
  `OperationArea` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OperationAreaID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operationarea`
--

LOCK TABLES `operationarea` WRITE;
/*!40000 ALTER TABLE `operationarea` DISABLE KEYS */;
INSERT INTO `operationarea` VALUES (2,'Naivasha'),(3,'Njoro '),(4,'Nairobi    '),(5,'Nakuru   '),(6,'Kisumu  ');
/*!40000 ALTER TABLE `operationarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `placetreated_code`
--

DROP TABLE IF EXISTS `placetreated_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `placetreated_code` (
  `PlaceTreated_CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `PlaceTreated_Code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PlaceTreated_CodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `placetreated_code`
--

LOCK TABLES `placetreated_code` WRITE;
/*!40000 ALTER TABLE `placetreated_code` DISABLE KEYS */;
INSERT INTO `placetreated_code` VALUES (1,'Self-Treatment'),(2,'Government Hospital'),(3,'Private Hospital'),(4,'Did not seek treatment'),(5,'Other');
/*!40000 ALTER TABLE `placetreated_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qstresults`
--

DROP TABLE IF EXISTS `qstresults`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qstresults` (
  `UniqueID` int(50) NOT NULL AUTO_INCREMENT,
  `QuestionID` int(50) NOT NULL,
  `QuestionAns` varchar(400) NOT NULL,
  `UniqClientID` varchar(200) NOT NULL,
  PRIMARY KEY (`UniqueID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qstresults`
--

LOCK TABLES `qstresults` WRITE;
/*!40000 ALTER TABLE `qstresults` DISABLE KEYS */;
/*!40000 ALTER TABLE `qstresults` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questioncodes`
--

DROP TABLE IF EXISTS `questioncodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questioncodes` (
  `QuestionCodesID` int(11) NOT NULL AUTO_INCREMENT,
  `QuestionCodes` varchar(45) DEFAULT NULL,
  `QID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`QuestionCodesID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questioncodes`
--

LOCK TABLES `questioncodes` WRITE;
/*!40000 ALTER TABLE `questioncodes` DISABLE KEYS */;
INSERT INTO `questioncodes` VALUES (1,'','null'),(2,'null','null'),(3,'null','null'),(4,'null','null'),(5,'null','null'),(6,'null','null'),(7,'null','null');
/*!40000 ALTER TABLE `questioncodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QuestionsID` varchar(45) DEFAULT NULL,
  `DomainID` varchar(45) DEFAULT NULL,
  `SubDomainID` varchar(45) DEFAULT NULL,
  `Question` varchar(200) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `isCoded` varchar(45) DEFAULT NULL,
  `hasDependant` varchar(45) DEFAULT NULL,
  `dependantValue` varchar(45) DEFAULT NULL,
  `DependantQuestion` varchar(45) DEFAULT NULL,
  `questionNo` varchar(45) DEFAULT NULL,
  `questionsName` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `required` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'A','1','SEXUAL PRACTICES  ','A.  When did you last have sexual intercourse?','text','Yes','No','none',NULL,NULL,NULL,NULL,NULL),(2,'B','1','SEXUAL PRACTICES','B.  Did you use a condom?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(3,'C','1','SEXUAL PRACTICES','C.  Genders of your sex partners?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(4,'D','1','SEXUAL PRACTICES','D.  When was the last time you had sex with a paying partner?','Text','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(5,'E','1','SEXUAL PRACTICES','E.  Average number of paying clients per week:(Probe for the last 3 months)','Text','No','Yes','E',NULL,NULL,NULL,NULL,NULL),(6,'F','1','SEXUAL PRACTICES','F.  Do you have a non-paying partner(husband,boyfriend)','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(7,'G','1','SEXUAL PRACTICES','G.  How many non-paying partners do you have?','Text','No','Yes','F',NULL,NULL,NULL,NULL,NULL),(8,'H','1','SEXUAL PRACTICES','H.  In the last one month, how many times did you have sex with a paying partner?','Text','No','Yes','G',NULL,NULL,NULL,NULL,NULL),(9,'I1','1','SEXUAL PRACTICES','Vaginal Sex','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(10,'I2','1','SEXUAL PRACTICES','Oral Sex','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(11,'I3','1','SEXUAL PRACTICES','Anal Sex','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(12,'J1','1','SEXUAL PRACTICES','Vaginal Sex','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(13,'J2','1','SEXUAL PRACTICES','Oral Sex','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(14,'J','1','SEXUAL PRACTICES','Anal Sex','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(15,'K','1','SEXUAL PRACTICES','K.  Who provides the condoms?','Dropdown','No','Yes','J',NULL,NULL,NULL,NULL,NULL),(16,'L1','1','SEXUAL PRACTICES','L. a)Any of your partners in the last six months known/suspected to be HIV+?','Dropdown','No','NO',NULL,NULL,NULL,NULL,NULL,NULL),(17,'L2','1','SEXUAL PRACTICES','b)  If yes, How many?','Text','No','Yes','L1',NULL,NULL,NULL,NULL,NULL),(19,'L3','1','SEXUAL PRACTICES','c) Did you use a condom with this partner?','Dropodown','Yes','Yes','L2',NULL,NULL,NULL,NULL,NULL),(20,'M1','1','SEXUAL PRACTICES','i) Discharge through the genitals?','Dropdown','No','No','',NULL,NULL,NULL,NULL,NULL),(21,'M2','1','SEXUAL PRACTICES','ii) Pain when passing urine?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(22,'M3','1','SEXUAL PRACTICES','iii) Pain when engaging in Sex?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(23,'M4','1','SEXUAL PRACTICES','iv) Swelling in Genital areas?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(24,'M5','1','SEXUAL PRACTICES','v) Genital sores or ulcers?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(25,'M6','1','SEXUAL PRACTICES','vi) Discoloration of urine?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(26,'M7','1','SEXUAL PRACTICES','vii) Abdominal Pain?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(27,'N1','1','STI/HIV','N. a) Did you seek treatment','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(28,'N2','1','STI/HIV','b) If yes, where did you seek treatment?','Dropdown','Yes','Yes','N1',NULL,NULL,NULL,NULL,NULL),(29,'O1','1','STI/HIV','O. a)Do you use lubricants?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(30,'O2','1','STI/HIV','b) If yes, What do you use?','Dropdown','No','Yes','O1',NULL,NULL,NULL,NULL,NULL),(31,'O3','1','STI/HIV','c) If yes, When do you use lubricants?','Dropdown','No','Yes','O2',NULL,NULL,NULL,NULL,NULL),(32,'P1','1','FAMILY PLANNING','P. a) Are you pregnant?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(33,'P2','1','FAMILY PLANNING','b) Do you wish to have children with the next 2 years?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(34,'P3','1','FAMILY PLANNING','c) Do you use any family planning method?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(35,'P4','1','FAMILY PLANNING','d) If yes, which method?','Dropdown','Yes','yes','P3',NULL,NULL,NULL,NULL,NULL),(36,'S1','1','DOUCHING','S. a) Do you practice Vaginal Douching?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(37,'S2','1','DOUCHING','b) When do you douche?','Checkbox','Yes','Yes','S1',NULL,NULL,NULL,NULL,NULL),(38,'Q1','1','SUBSTANCE ABUSE','Q. a)Have you used alcohol in the past 3 months?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(39,'Q2','1','SUBSTANCE ABUSE','b) If yes, how often do you take alcohol?','Dropdown','Yes','Yes','Q1',NULL,NULL,NULL,NULL,NULL),(40,'R1','1','SUBSTANCE ABUSE','R. a)Have you used any other drug in the last 3 mo','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(41,'R2','1','SUBSTANCE ABUSE','b) If yes, which one?','Text','No','yes','R2',NULL,NULL,NULL,NULL,NULL),(42,'R3','1','SUBSTANCE ABUSE','c) How often?','Dropdown','Yes','Yes','R3',NULL,NULL,NULL,NULL,NULL),(43,'T1','1','SEXUAL AND GENDER BASED VIOLENCE','a) Have you been beaten or seriously threatened by your partner or anyone of the opposite sex?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(44,'T2','1','SEXUAL AND GENDER BASED VIOLENCE','When was the last time?','Dropdown','Yes','Yes','T1',NULL,NULL,NULL,NULL,NULL),(45,'T3','1','SEXUAL AND GENDER BASED VIOLENCE','b) Have you been raped by your partner or any other person?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(46,'T4','1','SEXUAL AND GENDER BASED VIOLENCE','When was the last time','Dropodwn','Yes','Yes','T2',NULL,NULL,NULL,NULL,NULL),(47,'T5','1','SEXUAL AND GENDER BASED VIOLENCE','c)Does your partner deliberately deprive you of economic support>','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(48,'T6','1','SEXUAL AND GENDER BASED VIOLENCE','When was the last time?','Dropdown','Yes','Yes','T5',NULL,NULL,NULL,NULL,NULL),(49,'T7','1','SEXUAL GENDER BASED VIOLENCE','d) Does your partner deliberately say or do bad things in order to hurt you?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(50,'T8','1','SEXUAL GENDER BASED VIOLENCE','When was the last time','Dropdown','Yes','Yes','T7',NULL,NULL,NULL,NULL,NULL),(51,'T9','1','SEXUAL GENDER BASED VIOLENCE','e) Do any partner related problems affect your use of condoms, FP or seeking health services through disclosure and adherence to treatment?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(52,'T10','1','SEXUAL GENDER BASED VIOLENCE','When was the last time?','Dropdown','yes','Yes','T10',NULL,NULL,NULL,NULL,NULL),(53,'U1','1','SEXUAL GENDER BASED VIOLENCE','U. a)Did you seek treatment after this happened?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(54,'U2','1','SEXUAL GENDER BASED VIOLENCE','b) Where did you seek treatment?','Dropdown','Yes','Yes','U1',NULL,NULL,NULL,NULL,NULL),(55,'V1','1','SEXUAL GENDER BASED VIIOLENCE','V. a)Did you report?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(56,'V2','1','SEXUAL GENDER BASED VIIOLENCE','b) If yes, where?','Checkbox','Yes','Yes','V1',NULL,NULL,NULL,NULL,NULL),(57,'W','1','DATE','Date of Assesment','Textbox','No','No','',NULL,NULL,NULL,NULL,NULL),(58,'A1','2','A','Date of Assessment','Text','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(59,'A2','2','A','Cadre of Provider','Dropdown','Yes ','No',NULL,NULL,NULL,NULL,NULL,NULL),(60,'B1','2','B','100% Condom use with paying partners:','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(61,'B2','2','B','100% condom use with non-paying partner(s)','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(62,'B1.1','2','B','Condoms Provided Today?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(63,'B1.2','2','B','If yes,how many condoms?','Text','No','Yes','B1.1',NULL,NULL,NULL,NULL,NULL),(64,'B3','2','B','Water-Based Lubricants','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(65,'B3.1','2','B','Water-Based Lubricants Provided today','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(66,'B3.2','2','B','If yes,how many WBL?','Text','No','Yes','B3.1',NULL,NULL,NULL,NULL,NULL),(67,'C','2','C','Audit Score:','Text','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(68,'D1','2','D','Knowledge on HIV,STIs,FP,TB','Dropdown','Yes','No',NULL,NULL,NULL,NULL,NULL,NULL),(69,'D2','2','D','Health Education provided today?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(70,'D3','2','D','Appointment for next session(s)','Text','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(71,'E1','2','E','Tested today','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(72,'E2','2','E','Tested with partner?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(73,'F1','2','F','Provided an STI checkup today?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(74,'F2','2','F','Next Checkup date','Text','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(75,'G1','2','G','Screened Today?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(76,'G2','2','G','If not,appointment for next screening','Text','No','Yes','G1',NULL,NULL,NULL,NULL,NULL),(77,'H1','2','H','Screened Today?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(78,'H2','2','H','Appointment for next checkup','Text','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(79,'I','2','I','Referral provided today?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(80,'J1','2','J','Currently on method?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(81,'J2','2','J','Provided method today?','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(82,'J3','2','J','If Yes, what method?','Text','No','Yes','J2',NULL,NULL,NULL,NULL,NULL),(83,'J4','2','J','If not on method and not provided, why?','Text','No','Yes','J1, J2',NULL,NULL,NULL,NULL,NULL),(84,'K','2','K','Linked to IGA Group','Dropdown','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(85,'O3A','2','O','Anal Sex','CheckBox','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(86,'O3B','2','O','Vaginal Sex','CheckBox','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(87,'O2A','2','O','KYJelly','CheckBox','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(88,'O2B','2','O','Saliva','CheckBox','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(89,'O2C','2','O','Others','CheckBox','No','No',NULL,NULL,NULL,NULL,NULL,NULL),(90,NULL,NULL,'',NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `religion`
--

DROP TABLE IF EXISTS `religion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `religion` (
  `Religion_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Religion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Religion_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `religion`
--

LOCK TABLES `religion` WRITE;
/*!40000 ALTER TABLE `religion` DISABLE KEYS */;
INSERT INTO `religion` VALUES (1,'Christian    '),(2,'Muslim'),(3,'Other');
/*!40000 ALTER TABLE `religion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportcode`
--

DROP TABLE IF EXISTS `reportcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportcode` (
  `ReportCodeID` int(11) NOT NULL AUTO_INCREMENT,
  `ReportCode` varchar(45) DEFAULT NULL,
  `QID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ReportCodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportcode`
--

LOCK TABLES `reportcode` WRITE;
/*!40000 ALTER TABLE `reportcode` DISABLE KEYS */;
INSERT INTO `reportcode` VALUES (1,'Police',NULL),(2,'Chief',NULL),(3,'Village Elder',NULL);
/*!40000 ALTER TABLE `reportcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residence`
--

DROP TABLE IF EXISTS `residence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `residence` (
  `ResidenceID` int(50) NOT NULL AUTO_INCREMENT,
  `UniqueID` varchar(200) NOT NULL,
  `ResidenceName` varchar(200) NOT NULL,
  PRIMARY KEY (`ResidenceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residence`
--

LOCK TABLES `residence` WRITE;
/*!40000 ALTER TABLE `residence` DISABLE KEYS */;
/*!40000 ALTER TABLE `residence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residencearea`
--

DROP TABLE IF EXISTS `residencearea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `residencearea` (
  `ResidenceAreaID` int(11) NOT NULL AUTO_INCREMENT,
  `ResidenceArea` varchar(45) DEFAULT NULL,
  `QID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ResidenceAreaID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residencearea`
--

LOCK TABLES `residencearea` WRITE;
/*!40000 ALTER TABLE `residencearea` DISABLE KEYS */;
INSERT INTO `residencearea` VALUES (1,'Nakuru','16'),(2,'Naivasha','16'),(3,'Gilgil','16'),(4,'Nanyuki','16'),(5,'Ngong','16'),(6,'Narok','16'),(7,'Salgaa','16'),(8,'Makutano','16');
/*!40000 ALTER TABLE `residencearea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskassessment`
--

DROP TABLE IF EXISTS `riskassessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskassessment` (
  `CounsellorID` int(50) NOT NULL AUTO_INCREMENT,
  `DOA` varchar(45) DEFAULT NULL,
  `District` varchar(45) DEFAULT NULL,
  `DICName` varchar(45) DEFAULT NULL,
  `ClientInit` varchar(10) DEFAULT NULL,
  `UniqueID` varchar(100) DEFAULT NULL,
  `Sex` varchar(45) DEFAULT NULL,
  `SexLast` varchar(45) DEFAULT NULL,
  `CondomUse` varchar(45) DEFAULT NULL,
  `SexPartGender` varchar(45) DEFAULT NULL,
  `ActiveSexWork` varchar(45) DEFAULT NULL,
  `NoPayingClients` int(11) DEFAULT NULL,
  `RegPartner` varchar(15) DEFAULT NULL,
  `NoRegPartner` varchar(45) DEFAULT NULL,
  `TimeRegPartner` varchar(45) DEFAULT NULL,
  `PracticeVaginal` varchar(45) DEFAULT NULL,
  `PracticeOral` varchar(45) DEFAULT NULL,
  `PracticeAnal` varchar(45) DEFAULT NULL,
  `CondomVaginal` varchar(45) DEFAULT NULL,
  `CondomOral` varchar(45) DEFAULT NULL,
  `CondomAnal` varchar(45) DEFAULT NULL,
  `CondomProvider` varchar(45) DEFAULT NULL,
  `HIVPartStatus` varchar(45) DEFAULT NULL,
  `NoHIVPartStatus` varchar(45) DEFAULT NULL,
  `PartCondomUse` varchar(30) DEFAULT NULL,
  `LubricantUse` varchar(20) DEFAULT NULL,
  `KYJelly` varchar(45) DEFAULT NULL,
  `Saliva` varchar(45) DEFAULT NULL,
  `OtherLubricants` varchar(45) DEFAULT NULL,
  `LubUseAnal` varchar(45) DEFAULT NULL,
  `LubUseVaginal` varchar(45) DEFAULT NULL,
  `AlcoholUse` varchar(25) DEFAULT NULL,
  `AlcoholFrequency` varchar(45) DEFAULT NULL,
  `DrugUse` varchar(25) DEFAULT NULL,
  `DrugType` varchar(45) DEFAULT NULL,
  `DrugFrequency` varchar(45) DEFAULT NULL,
  `VaginalDouche` varchar(45) DEFAULT NULL,
  `AfterSexDouche` varchar(45) DEFAULT NULL,
  `BathDouche` varchar(45) DEFAULT NULL,
  `CdBurstDouche` varchar(45) DEFAULT NULL,
  `OtherDouche` varchar(45) DEFAULT NULL,
  `VerbalInsults` varchar(45) DEFAULT NULL,
  `Hit` varchar(45) DEFAULT NULL,
  `ForcedSex` varchar(45) DEFAULT NULL,
  `LastVerbalInsult` varchar(45) DEFAULT NULL,
  `LastVerbalInsultHit` varchar(45) DEFAULT NULL,
  `LastVerbalInsultForced` varchar(45) DEFAULT NULL,
  `SeekTreatment` varchar(15) DEFAULT NULL,
  `PlaceTreated` varchar(45) DEFAULT NULL,
  `ReportPolice` varchar(45) DEFAULT NULL,
  `DGenitals` varchar(45) DEFAULT NULL,
  `PUrine` varchar(45) DEFAULT NULL,
  `PSex` varchar(45) DEFAULT NULL,
  `SGenitals` varchar(45) DEFAULT NULL,
  `GSores` varchar(45) DEFAULT NULL,
  `DiscolorUrine` varchar(45) DEFAULT NULL,
  `AbdominalPain` varchar(45) DEFAULT NULL,
  `STISeekTreat` varchar(45) DEFAULT NULL,
  `STIPlaceTreated` varchar(45) DEFAULT NULL,
  `Pregnant` varchar(45) DEFAULT NULL,
  `HaveKids` varchar(45) DEFAULT NULL,
  `UseFP` varchar(45) DEFAULT NULL,
  `FPMethodUsed` varchar(45) DEFAULT NULL,
  `VerbalAbuse` varchar(45) DEFAULT NULL,
  `VerbalAbuseTime` varchar(45) DEFAULT NULL,
  `PartnerProblem` varchar(45) DEFAULT NULL,
  `PartnerProblemTime` varchar(45) DEFAULT NULL,
  `ReportWhere` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CounsellorID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskassessment`
--

LOCK TABLES `riskassessment` WRITE;
/*!40000 ALTER TABLE `riskassessment` DISABLE KEYS */;
INSERT INTO `riskassessment` VALUES (1,'09/05/2012','nakuru','nakuru','K.L.M','nakuru/12/2013/10','Male','Within 24hrs','Yes','Male','Yes',6,'Yes','4','5','Most times(>50%)','Never','Most times(`>50%)','N/A','Sometimes(<50%)','N/A','Self','Yes','5','Always','Yes','null','null','bvhv','null','null',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null','Yes','5 or more times/week','Yes','5 or more times/week','5 or more times/week','Yes','','','','nbn','Yes','No','Yes','Within Last 24 hrs','null','Within Last 24 hrs','Yes','Self Treatment','Yes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null','Yes','5 or more times/week','Yes','5 or more times/week','5 or more times/week','Yes','','','','nbn','Yes','No','Yes','Within Last 24 hrs','null','Within Last 24 hrs','Yes','Self Treatment','Yes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'08/09/2013','Nakuru','HGHJS','NMG','naks/06/2013/3','Male','Within 24hrs','Yes','Male','Yes',8,'Yes','9','2','Never','Never','Never','N/A','N/A','N/A','Self','Yes','6','Always','Yes','null','null','','null','null','Yes','5 or more times/week','Yes','hgh','5 or more times/week','Yes','AfterSexDouche','BathDouche','null','','No','No','No','null','null','null','Yes','Self Treatment','Yes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null','Yes','5 or more times/week','No','null','null','Yes','AfterSexDouche','null','CdBurstDouche','','Yes','Yes','Yes','Within Last 24 hrs','Within Last 24 hrs','Within Last 24 hrs','Yes','Did not seek treatment','No',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'','nakuru','nakuru','ADF','nakuru/02/2012/12','Male','Within 24hrs','Yes','Male','Yes',9,'Yes','5','8','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Never','Always(100%)','Both','No','null','null','Yes','null','null','','null','null','Yes','5 or more times/week','Yes','hjklj','5 or more times/week','Yes','AfterSexDouche','BathDouche','null','','Yes','No','Yes','Within Last 24 hrs','null','Within Last 24 hrs','Yes','Other','Yes',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'09/09/2012','null','null','null','null','null','More than 30 days ago','Yes','Male','Yes',9,'Yes','10','null','Never','Sometimes(<50%)','Never','Sometimes(<50%)','Most times(>50%)','Always(100%)','Client','Yes','6','Sometimes','Yes','KYJelly','Saliva','','null','LubUseVaginal','Yes','5 or more times/week','Yes','Bhang','5 or more times/week','Yes','AfterSexDouche','null','CdBurstDouche','','No','Yes','No','null','Within Last 24 hrs','null','Yes','Private Hospital','Yes','No','Yes','No','Yes','null','Yes','No','Yes','Government Hospital','null','Yes','No','Condoms','Yes','Within Last 24 hrs','No','Within Last 24 hrs','Chief'),(15,'09/09/2012','Nakuru','HGHJS','NMG','naks/06/2013/4','Male','More than 30 days ago','Yes','Male','Yes',5,'Yes','5','null','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Sometimes(<50%)','Client','Yes','5','Sometimes','Yes','null','null','','null','null','Yes','5 or more times/week','Yes','bgheudb','2 to 4 times/week','No','null','null','null','null','Yes','Yes','Yes','Within Last 24 hrs','Within Last 24 hrs','Within Last 24 hrs','Yes','Self Treatment','Yes','Yes','Yes','Yes','Yes','null','Yes','Yes','Yes','Never had any of this signs','null','Yes','Yes','Pills','Yes','Within Last 24 hrs','Yes','Within Last 24 hrs','Police');
/*!40000 ALTER TABLE `riskassessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskassessmentdetails`
--

DROP TABLE IF EXISTS `riskassessmentdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskassessmentdetails` (
  `RiskAssessDetailID` int(50) NOT NULL AUTO_INCREMENT,
  `AssessmentID` varchar(45) DEFAULT NULL,
  `QuestionID` varchar(45) DEFAULT NULL,
  `DirectAnswers` varchar(200) DEFAULT NULL,
  `CodedAnswers` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RiskAssessDetailID`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskassessmentdetails`
--

LOCK TABLES `riskassessmentdetails` WRITE;
/*!40000 ALTER TABLE `riskassessmentdetails` DISABLE KEYS */;
INSERT INTO `riskassessmentdetails` VALUES (1,'Aphia/16/09/2013/Kajiado/09/2013/123','W','16/09/2013','1'),(2,'Aphia/16/09/2013/Kajiado/09/2013/123','A','2','1'),(3,'Aphia/16/09/2013/Kajiado/09/2013/123','B','Yes','1'),(4,'Aphia/16/09/2013/Kajiado/09/2013/123','C','Yes','1'),(5,'Aphia/16/09/2013/Kajiado/09/2013/123','C','Yes','1'),(6,'Aphia/16/09/2013/Kajiado/09/2013/123','D','null','1'),(7,'Aphia/16/09/2013/Kajiado/09/2013/123','E','89000000','1'),(8,'Aphia/16/09/2013/Kajiado/09/2013/123','F','Yes','1'),(9,'Aphia/16/09/2013/Kajiado/09/2013/123','G','8','1'),(10,'Aphia/16/09/2013/Kajiado/09/2013/123','H','8','1'),(11,'Aphia/16/09/2013/Kajiado/09/2013/123','I1','4','1'),(12,'Aphia/16/09/2013/Kajiado/09/2013/123','I2','5','1'),(13,'Aphia/16/09/2013/Kajiado/09/2013/123','I3','3','1'),(14,'Aphia/16/09/2013/Kajiado/09/2013/123','J1','4','1'),(15,'Aphia/16/09/2013/Kajiado/09/2013/123','J2','4','1'),(16,'Aphia/16/09/2013/Kajiado/09/2013/123','J','5','1'),(17,'Aphia/16/09/2013/Kajiado/09/2013/123','K','Both','1'),(18,'Aphia/16/09/2013/Kajiado/09/2013/123','L1','Yes','1'),(19,'Aphia/16/09/2013/Kajiado/09/2013/123','L2','7','1'),(20,'Aphia/16/09/2013/Kajiado/09/2013/123','L3','3','1'),(21,'Aphia/16/09/2013/Kajiado/09/2013/123','M1','Yes','1'),(22,'Aphia/16/09/2013/Kajiado/09/2013/123','M2','Yes','1'),(23,'Aphia/16/09/2013/Kajiado/09/2013/123','M3','No','1'),(24,'Aphia/16/09/2013/Kajiado/09/2013/123','M4','No','1'),(25,'Aphia/16/09/2013/Kajiado/09/2013/123','M5','null','1'),(26,'Aphia/16/09/2013/Kajiado/09/2013/123','M6','Yes','1'),(27,'Aphia/16/09/2013/Kajiado/09/2013/123','M7','No','1'),(28,'Aphia/16/09/2013/Kajiado/09/2013/123','N1','Yes','1'),(29,'Aphia/16/09/2013/Kajiado/09/2013/123','N2','3','1'),(30,'Aphia/16/09/2013/Kajiado/09/2013/123','O1','Yes','1'),(31,'Aphia/16/09/2013/Kajiado/09/2013/123','O2','','1'),(32,'Aphia/16/09/2013/Kajiado/09/2013/123','O2','','1'),(33,'Aphia/16/09/2013/Kajiado/09/2013/123','O2','','1'),(34,'Aphia/16/09/2013/Kajiado/09/2013/123','O3','LubUseAnal','1'),(35,'Aphia/16/09/2013/Kajiado/09/2013/123','O3','LubUseAnal','1'),(36,'Aphia/16/09/2013/Kajiado/09/2013/123','P1','null','1'),(37,'Aphia/16/09/2013/Kajiado/09/2013/123','P2','Yes','1'),(38,'Aphia/16/09/2013/Kajiado/09/2013/123','P3','Yes','1'),(39,'Aphia/16/09/2013/Kajiado/09/2013/123','P4','7','1'),(40,'Aphia/16/09/2013/Kajiado/09/2013/123','Q1','Yes','1'),(41,'Aphia/16/09/2013/Kajiado/09/2013/123','Q2','2','1'),(42,'Aphia/16/09/2013/Kajiado/09/2013/123','R1','Yes','1'),(43,'Aphia/16/09/2013/Kajiado/09/2013/123','R2','Miraa','1'),(44,'Aphia/16/09/2013/Kajiado/09/2013/123','R3','1','1'),(45,'Aphia/16/09/2013/Kajiado/09/2013/123','S1','Yes','1'),(46,'Aphia/16/09/2013/Kajiado/09/2013/123','S2','','1'),(47,'Aphia/16/09/2013/Kajiado/09/2013/123','S2','','1'),(48,'Aphia/16/09/2013/Kajiado/09/2013/123','S2','','1'),(49,'Aphia/16/09/2013/Kajiado/09/2013/123','S2','','1'),(50,'Aphia/16/09/2013/Kajiado/09/2013/123','T1','Yes','1'),(51,'Aphia/16/09/2013/Kajiado/09/2013/123','T2','2','1'),(52,'Aphia/16/09/2013/Kajiado/09/2013/123','T3','Yes','1'),(53,'Aphia/16/09/2013/Kajiado/09/2013/123','T4','3','1'),(54,'Aphia/16/09/2013/Kajiado/09/2013/123','T5','Yes','1'),(55,'Aphia/16/09/2013/Kajiado/09/2013/123','T6','4','1'),(56,'Aphia/16/09/2013/Kajiado/09/2013/123','T7','Yes','1'),(57,'Aphia/16/09/2013/Kajiado/09/2013/123','T8','2','1'),(58,'Aphia/16/09/2013/Kajiado/09/2013/123','T9','Yes','1'),(59,'Aphia/16/09/2013/Kajiado/09/2013/123','T10','4','1'),(60,'Aphia/16/09/2013/Kajiado/09/2013/123','U1','Yes','1'),(61,'Aphia/16/09/2013/Kajiado/09/2013/123','U2','4','1'),(62,'Aphia/16/09/2013/Kajiado/09/2013/123','V1','Yes','1'),(63,'Aphia/16/09/2013/Kajiado/09/2013/123','V2','3','1'),(64,'Aphia/27/10/2013/Kajiado/09/2013/123','W','27/10/2013','1'),(65,'Aphia/27/10/2013/Kajiado/09/2013/123','A','1','1'),(66,'Aphia/27/10/2013/Kajiado/09/2013/123','B','Yes','1'),(67,'Aphia/27/10/2013/Kajiado/09/2013/123','C','Yes','1'),(68,'Aphia/27/10/2013/Kajiado/09/2013/123','C','Male','1'),(69,'Aphia/27/10/2013/Kajiado/09/2013/123','D','1','1'),(70,'Aphia/27/10/2013/Kajiado/09/2013/123','E','444','1'),(71,'Aphia/27/10/2013/Kajiado/09/2013/123','F','Yes','1'),(72,'Aphia/27/10/2013/Kajiado/09/2013/123','G','l','1'),(73,'Aphia/27/10/2013/Kajiado/09/2013/123','H','k','1'),(74,'Aphia/27/10/2013/Kajiado/09/2013/123','I1','2','1'),(75,'Aphia/27/10/2013/Kajiado/09/2013/123','I2','3','1'),(76,'Aphia/27/10/2013/Kajiado/09/2013/123','I3','4','1'),(77,'Aphia/27/10/2013/Kajiado/09/2013/123','J1','2','1'),(78,'Aphia/27/10/2013/Kajiado/09/2013/123','J2','3','1'),(79,'Aphia/27/10/2013/Kajiado/09/2013/123','J','4','1'),(80,'Aphia/27/10/2013/Kajiado/09/2013/123','K','Self','1'),(81,'Aphia/27/10/2013/Kajiado/09/2013/123','L1','No','1'),(82,'Aphia/27/10/2013/Kajiado/09/2013/123','L2','null','1'),(83,'Aphia/27/10/2013/Kajiado/09/2013/123','L3','null','1'),(84,'Aphia/27/10/2013/Kajiado/09/2013/123','M1','Yes','1'),(85,'Aphia/27/10/2013/Kajiado/09/2013/123','M2','No','1'),(86,'Aphia/27/10/2013/Kajiado/09/2013/123','M3','No','1'),(87,'Aphia/27/10/2013/Kajiado/09/2013/123','M4','Yes','1'),(88,'Aphia/27/10/2013/Kajiado/09/2013/123','M5','No','1'),(89,'Aphia/27/10/2013/Kajiado/09/2013/123','M6','Yes','1'),(90,'Aphia/27/10/2013/Kajiado/09/2013/123','M7','No','1'),(91,'Aphia/27/10/2013/Kajiado/09/2013/123','N1','Yes','1'),(92,'Aphia/27/10/2013/Kajiado/09/2013/123','N2','1','1'),(93,'Aphia/27/10/2013/Kajiado/09/2013/123','O1','Yes','1'),(94,'Aphia/27/10/2013/Kajiado/09/2013/123','O2','KYJelly','1'),(95,'Aphia/27/10/2013/Kajiado/09/2013/123','O2','null','1'),(96,'Aphia/27/10/2013/Kajiado/09/2013/123','O2','','1'),(97,'Aphia/27/10/2013/Kajiado/09/2013/123','O3','LubUseVaginal','1'),(98,'Aphia/27/10/2013/Kajiado/09/2013/123','O3','null','1'),(99,'Aphia/27/10/2013/Kajiado/09/2013/123','P1','Yes','1'),(100,'Aphia/27/10/2013/Kajiado/09/2013/123','P2','No','1'),(101,'Aphia/27/10/2013/Kajiado/09/2013/123','P3','Yes','1'),(102,'Aphia/27/10/2013/Kajiado/09/2013/123','P4','1','1'),(103,'Aphia/27/10/2013/Kajiado/09/2013/123','Q1','Yes','1'),(104,'Aphia/27/10/2013/Kajiado/09/2013/123','Q2','3','1'),(105,'Aphia/27/10/2013/Kajiado/09/2013/123','R1','Yes','1'),(106,'Aphia/27/10/2013/Kajiado/09/2013/123','R2','l','1'),(107,'Aphia/27/10/2013/Kajiado/09/2013/123','R3','1','1'),(108,'Aphia/27/10/2013/Kajiado/09/2013/123','S1','Yes','1'),(109,'Aphia/27/10/2013/Kajiado/09/2013/123','S2','AfterSexDouche','1'),(110,'Aphia/27/10/2013/Kajiado/09/2013/123','S2','BathDouche','1'),(111,'Aphia/27/10/2013/Kajiado/09/2013/123','S2','null','1'),(112,'Aphia/27/10/2013/Kajiado/09/2013/123','S2','','1'),(113,'Aphia/27/10/2013/Kajiado/09/2013/123','T1','No','1'),(114,'Aphia/27/10/2013/Kajiado/09/2013/123','T2','null','1'),(115,'Aphia/27/10/2013/Kajiado/09/2013/123','T3','Yes','1'),(116,'Aphia/27/10/2013/Kajiado/09/2013/123','T4','1','1'),(117,'Aphia/27/10/2013/Kajiado/09/2013/123','T5','No','1'),(118,'Aphia/27/10/2013/Kajiado/09/2013/123','T6','null','1'),(119,'Aphia/27/10/2013/Kajiado/09/2013/123','T7','Yes','1'),(120,'Aphia/27/10/2013/Kajiado/09/2013/123','T8','3','1'),(121,'Aphia/27/10/2013/Kajiado/09/2013/123','T9','Yes','1'),(122,'Aphia/27/10/2013/Kajiado/09/2013/123','T10','2','1'),(123,'Aphia/27/10/2013/Kajiado/09/2013/123','U1','Yes','1'),(124,'Aphia/27/10/2013/Kajiado/09/2013/123','U2','1','1'),(125,'Aphia/27/10/2013/Kajiado/09/2013/123','V1','No','1'),(126,'Aphia/27/10/2013/Kajiado/09/2013/123','V2','null','1');
/*!40000 ALTER TABLE `riskassessmentdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskassessmentmain`
--

DROP TABLE IF EXISTS `riskassessmentmain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskassessmentmain` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AssessmentID` varchar(45) DEFAULT NULL,
  `AssessmentDate` varchar(45) DEFAULT NULL,
  `UniqueID` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskassessmentmain`
--

LOCK TABLES `riskassessmentmain` WRITE;
/*!40000 ALTER TABLE `riskassessmentmain` DISABLE KEYS */;
INSERT INTO `riskassessmentmain` VALUES (1,'Aphia/16/09/2013/Kajiado/09/2013/123','16/09/2013','Kajiado/09/2013/123'),(2,'Aphia/27/10/2013/Kajiado/09/2013/123','27/10/2013','Kajiado/09/2013/123');
/*!40000 ALTER TABLE `riskassessmentmain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskreduction`
--

DROP TABLE IF EXISTS `riskreduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskreduction` (
  `NurseID` int(11) NOT NULL AUTO_INCREMENT,
  `ClientInit` varchar(45) DEFAULT NULL,
  `UniqueID` varchar(45) DEFAULT NULL,
  `DICName` varchar(45) DEFAULT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `CasualCdUse` varchar(45) DEFAULT NULL,
  `CdProvided` varchar(45) DEFAULT NULL,
  `NoCD` varchar(45) DEFAULT NULL,
  `RegCdUse` varchar(45) DEFAULT NULL,
  `RegCdAction` varchar(45) DEFAULT NULL,
  `WBLubricant` varchar(45) DEFAULT NULL,
  `WBLubAction` varchar(45) DEFAULT NULL,
  `AlDrugUseScore` varchar(45) DEFAULT NULL,
  `AlDrugUseAction` varchar(45) DEFAULT NULL,
  `HSFTKnowToday` varchar(45) DEFAULT NULL,
  `HSFTKnowTodayAction` varchar(45) DEFAULT NULL,
  `HSFTAppointment` varchar(45) DEFAULT NULL,
  `HSFTAppointmentAction` varchar(45) DEFAULT NULL,
  `NextAppt` varchar(45) DEFAULT NULL,
  `NextApptAction` varchar(45) DEFAULT NULL,
  `HIVTodayTest` varchar(45) DEFAULT NULL,
  `HIVTodayTestAction` varchar(45) DEFAULT NULL,
  `HIVTestPart` varchar(45) DEFAULT NULL,
  `HIVTestPartAction` varchar(45) DEFAULT NULL,
  `AltIncomeSource` varchar(45) DEFAULT NULL,
  `AltIncomeSourceAction` varchar(45) DEFAULT NULL,
  `STICheck` varchar(45) DEFAULT NULL,
  `STICheckAction` varchar(45) DEFAULT NULL,
  `STINextCheck` varchar(45) DEFAULT NULL,
  `STINextCheckAction` varchar(45) DEFAULT NULL,
  `CCScreening` varchar(45) DEFAULT NULL,
  `CCScreeningAction` varchar(45) DEFAULT NULL,
  `CCAppointment` varchar(45) DEFAULT NULL,
  `CCAppointmentAction` varchar(45) DEFAULT NULL,
  `FPCurrentMethod` varchar(45) DEFAULT NULL,
  `FPCurrMAction` varchar(45) DEFAULT NULL,
  `FPMethod` varchar(45) DEFAULT NULL,
  `FPMethodAction` varchar(45) DEFAULT NULL,
  `FPMethodType` varchar(45) DEFAULT NULL,
  `FPMethodTypeAction` varchar(45) DEFAULT NULL,
  `NoMethod` varchar(45) DEFAULT NULL,
  `NoMethodAction` varchar(45) DEFAULT NULL,
  `Cadre` varchar(45) DEFAULT NULL,
  `NoWBL` varchar(45) DEFAULT NULL,
  `TBCheck` varchar(45) DEFAULT NULL,
  `TBCheckAction` varchar(45) DEFAULT NULL,
  `GBVCheck` varchar(45) DEFAULT NULL,
  `GBVCheckAction` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`NurseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskreduction`
--

LOCK TABLES `riskreduction` WRITE;
/*!40000 ALTER TABLE `riskreduction` DISABLE KEYS */;
/*!40000 ALTER TABLE `riskreduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskreduction1`
--

DROP TABLE IF EXISTS `riskreduction1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskreduction1` (
  `ID` int(50) NOT NULL AUTO_INCREMENT,
  `PlanID` varchar(200) NOT NULL,
  `QID` varchar(200) NOT NULL,
  `CurrentStatus` text NOT NULL,
  `Action` varchar(400) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskreduction1`
--

LOCK TABLES `riskreduction1` WRITE;
/*!40000 ALTER TABLE `riskreduction1` DISABLE KEYS */;
/*!40000 ALTER TABLE `riskreduction1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskreduction2`
--

DROP TABLE IF EXISTS `riskreduction2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskreduction2` (
  `ID` int(50) NOT NULL AUTO_INCREMENT,
  `PlanID` varchar(200) NOT NULL,
  `RiskReductionID` varchar(200) NOT NULL,
  `UniqueID` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskreduction2`
--

LOCK TABLES `riskreduction2` WRITE;
/*!40000 ALTER TABLE `riskreduction2` DISABLE KEYS */;
/*!40000 ALTER TABLE `riskreduction2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskreductiondetails`
--

DROP TABLE IF EXISTS `riskreductiondetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskreductiondetails` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RiskReductionID` varchar(45) DEFAULT NULL,
  `QID` varchar(45) DEFAULT NULL,
  `currentStatus` varchar(45) DEFAULT NULL,
  `Action` varchar(45) DEFAULT NULL,
  `Appointments` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskreductiondetails`
--

LOCK TABLES `riskreductiondetails` WRITE;
/*!40000 ALTER TABLE `riskreductiondetails` DISABLE KEYS */;
INSERT INTO `riskreductiondetails` VALUES (1,'Aphia/14-08-2013/Laikipia/09/2013/124','B1','2','Condoms were provided_5_5_5',''),(2,'Aphia/14-08-2013/Laikipia/09/2013/124','B2','2','Improvement',''),(3,'Aphia/14-08-2013/Laikipia/09/2013/124','B3','3','WBL Provided_5_5_5',''),(4,'Aphia/14-08-2013/Laikipia/09/2013/124','C','null','5',''),(5,'Aphia/14-08-2013/Laikipia/09/2013/124','D1','1','Hiv know',''),(6,'Aphia/14-08-2013/Laikipia/09/2013/124','D2','Yes','Health betther',''),(7,'Aphia/14-08-2013/Laikipia/09/2013/124','E1','Yes','NBVN',''),(8,'Aphia/14-08-2013/Laikipia/09/2013/124','E2','Yes','B N',''),(9,'Aphia/14-08-2013/Laikipia/09/2013/124','F1','No','MNBN',''),(10,'Aphia/14-08-2013/Laikipia/09/2013/124','G1','Yes','NBJ',''),(11,'Aphia/14-08-2013/Laikipia/09/2013/124','H1','No','VCV',''),(12,'Aphia/14-08-2013/Laikipia/09/2013/124','I','No','B VNVB',''),(13,'Aphia/14-08-2013/Laikipia/09/2013/124','J1','Yes','VCVB',''),(14,'Aphia/14-08-2013/Laikipia/09/2013/124','J2','Yes','BVBN',''),(15,'Aphia/14-08-2013/Laikipia/09/2013/124','J3','MAAA','EEEE',''),(16,'Aphia/14-08-2013/Laikipia/09/2013/124','J4','LLLLL','KKKKK',''),(17,'Aphia/14-08-2013/Laikipia/09/2013/124','K','Yes','NBV',''),(18,'Aphia/14-08-2013/Laikipia/09/2013/124','D3','','MANHJUS','09/09/2013'),(19,'Aphia/14-08-2013/Laikipia/09/2013/124','F2','','null','null'),(20,'Aphia/14-08-2013/Laikipia/09/2013/124','H2','','null ','null'),(21,'Aphia/20-08-2013/Kajiado/09/2013/125','B1','1','Condoms were provided_5',''),(22,'Aphia/20-08-2013/Kajiado/09/2013/125','B2','2','Improvement',''),(23,'Aphia/20-08-2013/Kajiado/09/2013/125','B3','3','WBL Not Provided_null',''),(24,'Aphia/20-08-2013/Kajiado/09/2013/125','C','null','nm',''),(25,'Aphia/20-08-2013/Kajiado/09/2013/125','D2','Yes','average',''),(26,'Aphia/20-08-2013/Kajiado/09/2013/125','E1','Yes','health education',''),(27,'Aphia/20-08-2013/Kajiado/09/2013/125','E2','No','HIV Testing',''),(28,'Aphia/20-08-2013/Kajiado/09/2013/125','F1','Yes','Tested with partner?',''),(29,'Aphia/20-08-2013/Kajiado/09/2013/125','G1','Yes','Provided an STI checkup today?',''),(30,'Aphia/20-08-2013/Kajiado/09/2013/125','H1','No','Cervical Cancer Screening',''),(31,'Aphia/20-08-2013/Kajiado/09/2013/125','I','Yes','screened',''),(32,'Aphia/20-08-2013/Kajiado/09/2013/125','J1','Yes','nbnjghjghj',''),(33,'Aphia/20-08-2013/Kajiado/09/2013/125','J2','No','nm',''),(34,'Aphia/20-08-2013/Kajiado/09/2013/125','J3','null','kj',''),(35,'Aphia/20-08-2013/Kajiado/09/2013/125','J4','null','null',''),(36,'Aphia/20-08-2013/Kajiado/09/2013/125','K','Yes','null',''),(37,'Aphia/20-08-2013/Kajiado/09/2013/125','D3','','null','09/09/2013'),(38,'Aphia/20-08-2013/Kajiado/09/2013/125','F2','','cc','null'),(39,'Aphia/20-08-2013/Kajiado/09/2013/125','G2','','tb screening','07/12/2013'),(40,'Aphia/20-08-2013/Kajiado/09/2013/125','H2','','Next Checkup date','09/09/2013');
/*!40000 ALTER TABLE `riskreductiondetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskreductionmain`
--

DROP TABLE IF EXISTS `riskreductionmain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskreductionmain` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RiskReductionID` varchar(45) DEFAULT NULL,
  `DOA` varchar(45) DEFAULT NULL,
  `CadreProvider` varchar(45) DEFAULT NULL,
  `UniqueID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskreductionmain`
--

LOCK TABLES `riskreductionmain` WRITE;
/*!40000 ALTER TABLE `riskreductionmain` DISABLE KEYS */;
INSERT INTO `riskreductionmain` VALUES (1,'Aphia/14-08-2013/Laikipia/09/2013/124','14-08-2013','4','Laikipia/09/2013/124'),(2,'Aphia/20-08-2013/Kajiado/09/2013/125','20-08-2013','4','Kajiado/09/2013/125');
/*!40000 ALTER TABLE `riskreductionmain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riskreductionservice`
--

DROP TABLE IF EXISTS `riskreductionservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riskreductionservice` (
  `ServiceID` int(11) NOT NULL AUTO_INCREMENT,
  `SubDomainID` varchar(45) DEFAULT NULL,
  `Service` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ServiceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riskreductionservice`
--

LOCK TABLES `riskreductionservice` WRITE;
/*!40000 ALTER TABLE `riskreductionservice` DISABLE KEYS */;
/*!40000 ALTER TABLE `riskreductionservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `ServicesID` int(11) NOT NULL,
  `UniqueID` varchar(45) DEFAULT NULL,
  `RiskReductionServiceID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ServicesID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexcode`
--

DROP TABLE IF EXISTS `sexcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sexcode` (
  `SexCodeID` int(11) NOT NULL AUTO_INCREMENT,
  `SexCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SexCodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexcode`
--

LOCK TABLES `sexcode` WRITE;
/*!40000 ALTER TABLE `sexcode` DISABLE KEYS */;
INSERT INTO `sexcode` VALUES (2,'null'),(3,'null'),(4,'vhgfbvbvc ');
/*!40000 ALTER TABLE `sexcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexint_code`
--

DROP TABLE IF EXISTS `sexint_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sexint_code` (
  `SexInt_CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `SexInt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SexInt_CodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexint_code`
--

LOCK TABLES `sexint_code` WRITE;
/*!40000 ALTER TABLE `sexint_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `sexint_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stitreatment_code`
--

DROP TABLE IF EXISTS `stitreatment_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stitreatment_code` (
  `STITreatment_CodeID` int(11) NOT NULL AUTO_INCREMENT,
  `STITreatment_Code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`STITreatment_CodeID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stitreatment_code`
--

LOCK TABLES `stitreatment_code` WRITE;
/*!40000 ALTER TABLE `stitreatment_code` DISABLE KEYS */;
INSERT INTO `stitreatment_code` VALUES (1,'Never had any of these signs'),(2,'Medication from friend/self'),(3,'Drop in Centres'),(4,'Government Hospital'),(5,'Private Clinic or Hospital'),(6,'Medication from chemist'),(7,'Herbalist'),(8,'Did  not seek treatment');
/*!40000 ALTER TABLE `stitreatment_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subdomain`
--

DROP TABLE IF EXISTS `subdomain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subdomain` (
  `SubDomainID` int(11) NOT NULL AUTO_INCREMENT,
  `DomainID` varchar(45) DEFAULT NULL,
  `SubDomain` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SubDomainID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subdomain`
--

LOCK TABLES `subdomain` WRITE;
/*!40000 ALTER TABLE `subdomain` DISABLE KEYS */;
INSERT INTO `subdomain` VALUES (1,'1','Sexual Practices'),(2,'1','STI/HIV'),(3,'1','FAMILY PLANNING'),(4,'1','SUBSTANCE ABUSE'),(5,'1','DOUCHING'),(6,'1','SEXUAL AND GENDER BASED VIOLENCE');
/*!40000 ALTER TABLE `subdomain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Username` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `PhoneNo` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Location` varchar(45) DEFAULT NULL,
  `AccessLevel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Maureen Mumbi','Maureen','maureen','0712894282','mollymumbi@gmail.com','Nakuru','1'),(2,'m','m','m','0712894282','mollymumbi@gmail.com','nakuru','2'),(3,'gvghjf','bvcbn','m','0712894123','mollymumbi@gmail.com','naks','1'),(4,'gvghjf','bvcbn','m','0712894123','mollymumbi@gmail.com','naks','1'),(5,'gvghjf','bvcbn','m','0712894123','mollymumbi@gmail.com','naks','1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venue`
--

DROP TABLE IF EXISTS `venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venue` (
  `VenueID` int(11) NOT NULL AUTO_INCREMENT,
  `Venue` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`VenueID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venue`
--

LOCK TABLES `venue` WRITE;
/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` VALUES (1,'Street'),(2,'Home'),(3,'Truck Stop '),(4,'Sex Den'),(5,'Bar/Night Club'),(6,'Escort'),(7,'Massage Parlour '),(8,'Other');
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-09 15:33:56
