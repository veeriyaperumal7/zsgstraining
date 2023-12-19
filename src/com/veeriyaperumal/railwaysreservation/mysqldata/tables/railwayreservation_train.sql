-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: railwayreservation
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `train` (
  `train_no` bigint NOT NULL AUTO_INCREMENT,
  `train_name` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `train_seater_carriage_count` int DEFAULT NULL,
  `train_seater_carriage_capacity` int DEFAULT NULL,
  `train_sleeper_carriage_count` int DEFAULT NULL,
  `train_sleeper_carriage_capacity` int DEFAULT NULL,
  `train_sleeper_carriage_upperbirth_capacity` int DEFAULT NULL,
  `train_sleeper_carriage_middlebirth_capacity` int DEFAULT NULL,
  `train_sleeper_carriage_lowerbirth_capacity` int DEFAULT NULL,
  `train_active_status` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`train_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (1001,'NELLAI EXPRESS',2,10,2,10,3,3,4,'ONLINE'),(1002,'CHENNAI EGMORE EXPRESS',2,10,2,10,3,3,4,'ONLINE');
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-19 17:33:38
