-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: loanapplication
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
-- Table structure for table `loan_data`
--

DROP TABLE IF EXISTS `loan_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan_data` (
  `loan_no` bigint NOT NULL AUTO_INCREMENT,
  `Customer_id` bigint NOT NULL,
  `loan_amount` decimal(18,0) DEFAULT NULL,
  `loan_pending_amount` decimal(18,0) DEFAULT NULL,
  `loan_paid_amount` decimal(18,0) DEFAULT NULL,
  `loan_status` varchar(250) DEFAULT NULL,
  `loan_interest_percentage` decimal(18,0) DEFAULT NULL,
  `loan_interest_amount` decimal(18,0) DEFAULT NULL,
  `loan_total_payable_amount` decimal(18,0) DEFAULT NULL,
  `loan_issue_date` date DEFAULT NULL,
  PRIMARY KEY (`loan_no`),
  KEY `Customer_id` (`Customer_id`),
  CONSTRAINT `loan_data_ibfk_1` FOREIGN KEY (`Customer_id`) REFERENCES `customer_data` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_data`
--

LOCK TABLES `loan_data` WRITE;
/*!40000 ALTER TABLE `loan_data` DISABLE KEYS */;
INSERT INTO `loan_data` VALUES (2,2,10000,10000,1000,'PENDING',10,1000,11000,'2023-12-25'),(3,1,15000,0,15750,'COMPLETED',5,750,15750,'2023-12-25'),(4,3,1500,0,1500,'COMPLETED',0,0,1500,'2023-12-25'),(5,4,10000,0,11000,'COMPLETED',10,1000,11000,'2023-12-25'),(6,4,20000,0,20000,'COMPLETED',0,0,20000,'2023-12-25'),(7,4,5000,0,5000,'COMPLETED',0,0,5000,'2023-12-25'),(8,2,1000,0,1000,'COMPLETED',0,0,1000,'2023-12-25'),(9,3,6000,0,6000,'COMPLETED',0,0,6000,'2023-12-25'),(10,5,1000,0,1100,'COMPLETED',10,100,1100,'2023-12-25'),(11,6,20000,10000,10000,'PENDING',0,0,20000,'2023-12-25'),(12,3,10000,10000,0,'PENDING',0,0,10000,'2023-12-25');
/*!40000 ALTER TABLE `loan_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-25 20:46:22
