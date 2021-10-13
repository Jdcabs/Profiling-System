CREATE DATABASE  IF NOT EXISTS `demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `demo`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phonenumber` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('david','david','john david cabal','concepcion uno',9683228845),('niggawatz','jdcabal015','Rafael Canlas','sunnisquare malanday city',9605645647);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resident`
--

DROP TABLE IF EXISTS `resident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resident` (
  `resident_id` bigint NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `middle_initial` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `suffix` varchar(20) DEFAULT NULL,
  `phone_number` bigint NOT NULL,
  `address` varchar(150) NOT NULL,
  `email_address` varchar(150) NOT NULL,
  `status` varchar(50) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `1stDose_ManufacturerName` varchar(100) DEFAULT NULL,
  `1stDose_BatchNo` varchar(30) DEFAULT NULL,
  `1stDose_VaccinationDate` date DEFAULT NULL,
  `2ndDose_ManufacturerName` varchar(100) DEFAULT NULL,
  `2ndDose_BatchNo` varchar(30) DEFAULT NULL,
  `2ndDose_VaccinationDate` date DEFAULT NULL,
  `deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`resident_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resident`
--

LOCK TABLES `resident` WRITE;
/*!40000 ALTER TABLE `resident` DISABLE KEYS */;
INSERT INTO `resident` VALUES (719853,'nigga','watzz','asda','',96912344,'Concepcion dos','david@gmail.com','Single','Male','None','None','0000-00-00','None','None','0000-00-00',1),(793528,'Johndavid','Samson','Cabal','',9605645647,'3 E Gonzales St. Concepcion Uno Marikina City','Johndavidcabal00@gmail.com','Single','','None','None',NULL,'None','None',NULL,0),(889267,'Johndavid','samson','Cabal','',9605645647,'Concepcion Uno Marikina City','@gmail.com','Single','','Moderna','057D214','2021-08-06','Moderna','055E21A','2021-09-09',0),(933082,'sadasda','asdasd','asdasd','asd',1231231231,'asdasd','asdasd@gmail.com','Widowed','Female','None','None','0000-00-00','None','None','0000-00-00',0);
/*!40000 ALTER TABLE `resident` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-13 20:42:31
