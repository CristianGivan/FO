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
-- Table structure for table `task_history`
--

DROP TABLE IF EXISTS `task_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_history` (
  `account_history_id` bigint NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `event_history_id` bigint NOT NULL,
  `expense_history_id` bigint NOT NULL,
  `expenses_history_id` bigint NOT NULL,
  `link_history_id` bigint NOT NULL,
  `person_history_id` bigint NOT NULL,
  `task_history_id` bigint NOT NULL,
  `tasks_history_id` bigint NOT NULL,
  `transaction_history_id` bigint NOT NULL,
  `account_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `link_id` bigint DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `task_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_history_id`),
  KEY `FKfy9n8ry0l7ufhhqewby3o4pe` (`account_id`),
  KEY `FKiw9nd8h62o8w6yclu7vhyev9r` (`user_id`),
  KEY `FK72gvgq5gsti5dg6qsvs4arhfx` (`event_id`),
  KEY `FKbpl6dbhwxu5r873wunraktmve` (`expense_id`),
  KEY `FKao94p07v5k5rli535suhxi8mm` (`expenses_id`),
  KEY `FKks46yxxrgf7c76dcxg5q9m5oo` (`link_id`),
  KEY `FKewfv7belr4et9v218n5kexhwf` (`person_id`),
  KEY `FKer57q2libi1e9njpj6faoxd2i` (`task_id`),
  KEY `FK47ur0p7wepwi1iam6jt2k2spp` (`tasks_id`),
  KEY `FKf65kpecmxcya99d90r0y6cvft` (`transaction_id`),
  CONSTRAINT `FK47ur0p7wepwi1iam6jt2k2spp` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FK72gvgq5gsti5dg6qsvs4arhfx` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`),
  CONSTRAINT `FKao94p07v5k5rli535suhxi8mm` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`),
  CONSTRAINT `FKbpl6dbhwxu5r873wunraktmve` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`),
  CONSTRAINT `FKer57q2libi1e9njpj6faoxd2i` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`),
  CONSTRAINT `FKewfv7belr4et9v218n5kexhwf` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKf65kpecmxcya99d90r0y6cvft` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  CONSTRAINT `FKfy9n8ry0l7ufhhqewby3o4pe` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FKiw9nd8h62o8w6yclu7vhyev9r` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKks46yxxrgf7c76dcxg5q9m5oo` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_history`
--

LOCK TABLES `task_history` WRITE;
/*!40000 ALTER TABLE `task_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-05 10:58:38
