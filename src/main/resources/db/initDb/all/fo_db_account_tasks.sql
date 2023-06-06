-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: fo_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `account_tasks`
--

DROP TABLE IF EXISTS `account_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_tasks` (
  `account_tasks_id` bigint NOT NULL,
  `account_date` datetime DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`account_tasks_id`),
  KEY `FKbr2jp9mdxd4kpna1p81jk38f` (`account_id`),
  KEY `FKfvmok81mf2gq5as0otcs70oxv` (`tasks_id`),
  CONSTRAINT `FKbr2jp9mdxd4kpna1p81jk38f` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FKfvmok81mf2gq5as0otcs70oxv` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_tasks`
--

LOCK TABLES `account_tasks` WRITE;
/*!40000 ALTER TABLE `account_tasks` DISABLE KEYS */;
INSERT INTO `account_tasks` VALUES (1,'2023-06-04 20:26:41',1,1),(2,'2023-06-04 20:26:50',2,2),(3,'2023-06-04 20:26:59',3,3),(4,'2023-06-04 20:27:06',4,4),(5,'2023-06-04 20:27:11',4,5),(6,'2023-06-04 20:27:16',5,5);
/*!40000 ALTER TABLE `account_tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-05 10:58:53
