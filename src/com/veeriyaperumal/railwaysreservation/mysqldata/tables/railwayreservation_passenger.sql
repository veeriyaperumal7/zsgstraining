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
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `passenger_id` bigint NOT NULL AUTO_INCREMENT,
  `passenger_name` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `passenger_dob` date DEFAULT NULL,
  `passenger_gender` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `passenger_place` varchar(250) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `passenger_mobile` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`passenger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'Perumal','2003-03-05','Male','Tirunelveli',6574658390),(2,'Sanjay','2002-05-07','Male','nellai',6574658673),(3,'ppsdg','2001-05-20','Male','dfgfds',6574648575),(4,'psdfhjs','2004-03-05','Male','dshf',7564846383),(5,'Perumal','2002-03-09','Male','Nellai',6574659923),(6,'Sanjay','2004-09-03','Male','Nellai',6547856785),(7,'Perumal','2004-03-01','Male','nellai',6576846586),(8,'Perumal','2010-03-06','Male','Nellai',6574839276),(9,'Perumal','2002-04-05','Male','Tirunelveli',6574857487),(10,'Perumal','2001-09-05','Male','Tirunelveli',6574859479),(11,'Perumal','2002-04-09','Male','dfsdff',6574658478),(12,'rrtrt','2002-04-09','Male','sfgfd',6574658478),(13,'3','2002-04-09','Male','dfghgsdg',6574658478),(14,'arestdesr','2002-04-09','Male','sgdfersgd',6574658478),(15,'thrtrt','2002-04-09','Male','erefdgf',6574658478),(16,'Perumal','2002-04-07','Male','Tirunelveli',6584668468),(17,'Perumal','2004-02-03','Male','Tirunelveli',6574856789),(18,'Perumal','2001-06-07','Male','Tirunelveli',6574658467),(19,'Ram','2004-04-05','Male','Tenkasi',6574657465),(20,'Mydeen','2001-04-07','Male','Nellai',6574658469),(21,'Subramani','1999-09-04','Male','Tenkasi',6574856784),(22,'Sam','1999-05-09','Male','Tirunelveli',6574857585),(23,'Madhan','1998-05-04','Male','Tenkasi',6574658354),(24,'Perumal','2001-03-04','Male','Tirunelveli',6584657464),(25,'Perumal','2001-04-26','Male','Tenkasi',6574657467),(26,'Anusha','2003-06-07','Female','Tenkasi',6574657465),(27,'Anusha','2001-09-07','Female','Tenkasi',6574637563),(28,'Anusha','2003-04-09','Female','Tenkasi',6574658364),(29,'Perumal','2001-04-26','Male','Tirunelveli',6574638478),(30,'tfhdfgg','2001-07-09','Male','nellai',6574658767),(31,'Perumal','2001-04-26','Male','Tirunelveli',6374357950),(32,'Subramani','2001-03-21','Male','Tenkasi',6574657465),(33,'Sanjay','2003-07-09','Male','Nellai',6574645675),(34,'Deva','2004-05-05','Male','Tenkasi',6574668675),(35,'Mydeen','2005-05-07','Male','Chennai',6574675643),(36,'Sam','2003-04-09','Male','Kalakad',6574732437),(37,'Anusha','2003-08-04','Female','Surandai',6575757886),(38,'Mathan','2005-09-07','Female','Surandai',6543267669),(39,'Ram','2003-06-07','Male','Surandai',6758493917),(40,'Natraj','2001-03-02','Male','Tenkasi',6758970475),(41,'Thubalan','2001-02-07','Male','Tenkasi',6574563856),(42,'Sam','1998-08-06','Male','Surandai',6574857684),(43,'Selvam','1998-09-07','Male','Trichendhur',6574657464),(44,'Maharaja','1997-09-06','Male','Chennai',6574657464),(45,'Thangam','2003-03-04','Male','Tenkasi',6574647564),(46,'Ramesh','2003-04-02','Male','Tenkasi',6574647464),(47,'MuthuKumarasamy','2001-03-05','Male','Tenkasi',6574637643),(48,'Siva','2002-03-04','Male','Tenkasi',6574657464);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-19 17:33:39
