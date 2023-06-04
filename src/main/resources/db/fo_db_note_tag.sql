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
-- Table structure for table `note_tag`
--

DROP TABLE IF EXISTS `note_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_tag` (
  `note_tag_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `note_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`note_tag_id`),
  KEY `FKdchpnvg6njslx0ye4voybfwji` (`note_id`),
  KEY `FKcdpo2kwep1elf4i7fi4niltwn` (`tag_id`),
  CONSTRAINT `FKcdpo2kwep1elf4i7fi4niltwn` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKdchpnvg6njslx0ye4voybfwji` FOREIGN KEY (`note_id`) REFERENCES `note` (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_tag`
--

LOCK TABLES `note_tag` WRITE;
/*!40000 ALTER TABLE `note_tag` DISABLE KEYS */;
INSERT INTO `note_tag` VALUES (1,'2023-06-04 13:04:19',1,1),(2,'2023-06-04 13:04:19',1,2),(3,'2023-06-04 13:04:19',1,3),(4,'2023-06-04 13:04:19',1,4),(5,'2023-06-04 13:04:19',1,5),(6,'2023-06-04 13:04:19',2,6),(7,'2023-06-04 13:04:19',2,7),(8,'2023-06-04 13:04:19',2,8),(9,'2023-06-04 13:04:19',2,9),(10,'2023-06-04 13:04:19',2,10),(11,'2023-06-04 13:04:19',3,1),(12,'2023-06-04 13:04:19',3,2),(13,'2023-06-04 13:04:19',3,3),(14,'2023-06-04 13:04:19',3,4),(15,'2023-06-04 13:04:19',3,5),(16,'2023-06-04 13:04:19',3,6),(17,'2023-06-04 13:04:19',3,7),(18,'2023-06-04 13:04:19',3,8),(19,'2023-06-04 13:04:19',3,9);
/*!40000 ALTER TABLE `note_tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 13:46:17
