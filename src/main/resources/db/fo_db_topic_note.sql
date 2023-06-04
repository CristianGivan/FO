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
-- Table structure for table `topic_note`
--

DROP TABLE IF EXISTS `topic_note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_note` (
  `topic_note_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `note_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`topic_note_id`),
  KEY `FK5mlhpo7eefxwq90tvnpahfus7` (`note_id`),
  KEY `FKm9gd2x6rxqmu79hja2wigd5oi` (`topic_id`),
  CONSTRAINT `FK5mlhpo7eefxwq90tvnpahfus7` FOREIGN KEY (`note_id`) REFERENCES `note` (`note_id`),
  CONSTRAINT `FKm9gd2x6rxqmu79hja2wigd5oi` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_note`
--

LOCK TABLES `topic_note` WRITE;
/*!40000 ALTER TABLE `topic_note` DISABLE KEYS */;
INSERT INTO `topic_note` VALUES (1,'2023-06-04 13:04:19',1,1),(2,'2023-06-04 13:04:19',2,1),(3,'2023-06-04 13:04:19',3,1),(4,'2023-06-04 13:04:19',1,2),(5,'2023-06-04 13:04:19',2,2),(6,'2023-06-04 13:04:19',3,2),(7,'2023-06-04 13:04:19',1,3),(8,'2023-06-04 13:04:19',2,3),(9,'2023-06-04 13:04:19',3,3);
/*!40000 ALTER TABLE `topic_note` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 13:46:31
