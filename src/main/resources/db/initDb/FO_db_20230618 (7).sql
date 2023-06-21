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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` bigint NOT NULL,
  `balance` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  KEY `FK7m8ru44m93ukyb61dfxw0apf6` (`user_id`),
  CONSTRAINT `FK7m8ru44m93ukyb61dfxw0apf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,10,'2023-06-01 13:14:15','account1','type1',1),(2,20,'2023-06-04 15:44:15','account2','type2',1),(3,30,'2023-06-04 15:44:18','account3','type3',1),(4,40,'2023-06-04 15:44:21','account33','type33',1),(5,50,'2023-06-04 15:44:26','account333','type333',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_expenses`
--

DROP TABLE IF EXISTS `account_expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_expenses` (
  `account_expenses_id` bigint NOT NULL,
  `account_date` datetime DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `sum` double DEFAULT NULL,
  PRIMARY KEY (`account_expenses_id`),
  KEY `FKbj9canf7nwqeeb90wdh5s5cyq` (`account_id`),
  KEY `FKl3ua1m699m3ppshq11hdvweq5` (`expenses_id`),
  CONSTRAINT `FKbj9canf7nwqeeb90wdh5s5cyq` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FKl3ua1m699m3ppshq11hdvweq5` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_expenses`
--

LOCK TABLES `account_expenses` WRITE;
/*!40000 ALTER TABLE `account_expenses` DISABLE KEYS */;
INSERT INTO `account_expenses` VALUES (1,'2023-06-04 22:20:59',1,1,NULL),(2,'2023-06-04 22:21:09',2,2,NULL),(3,'2023-06-04 22:21:16',3,3,NULL),(4,'2023-06-04 22:21:24',4,4,NULL),(5,'2023-06-04 22:21:30',4,5,NULL),(6,'2023-06-04 22:21:34',5,5,NULL);
/*!40000 ALTER TABLE `account_expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_expenses_seq`
--

DROP TABLE IF EXISTS `account_expenses_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_expenses_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_expenses_seq`
--

LOCK TABLES `account_expenses_seq` WRITE;
/*!40000 ALTER TABLE `account_expenses_seq` DISABLE KEYS */;
INSERT INTO `account_expenses_seq` VALUES (7);
/*!40000 ALTER TABLE `account_expenses_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_history_seq`
--

DROP TABLE IF EXISTS `account_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_history_seq`
--

LOCK TABLES `account_history_seq` WRITE;
/*!40000 ALTER TABLE `account_history_seq` DISABLE KEYS */;
INSERT INTO `account_history_seq` VALUES (1);
/*!40000 ALTER TABLE `account_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_reminder`
--

DROP TABLE IF EXISTS `account_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_reminder` (
  `account_reminder_id` bigint NOT NULL,
  `account_date` datetime DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`account_reminder_id`),
  KEY `FKq0lk3dpdlmtd0a5xamma32xyk` (`account_id`),
  KEY `FKs7porohqs9hjnji9nynb9281s` (`reminder_id`),
  CONSTRAINT `FKq0lk3dpdlmtd0a5xamma32xyk` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FKs7porohqs9hjnji9nynb9281s` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_reminder`
--

LOCK TABLES `account_reminder` WRITE;
/*!40000 ALTER TABLE `account_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_reminder_seq`
--

DROP TABLE IF EXISTS `account_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_reminder_seq`
--

LOCK TABLES `account_reminder_seq` WRITE;
/*!40000 ALTER TABLE `account_reminder_seq` DISABLE KEYS */;
INSERT INTO `account_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `account_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_seq`
--

DROP TABLE IF EXISTS `account_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_seq`
--

LOCK TABLES `account_seq` WRITE;
/*!40000 ALTER TABLE `account_seq` DISABLE KEYS */;
INSERT INTO `account_seq` VALUES (6);
/*!40000 ALTER TABLE `account_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_tag`
--

DROP TABLE IF EXISTS `account_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_tag` (
  `account_tag_id` bigint NOT NULL,
  `account_date` datetime DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`account_tag_id`),
  KEY `FKpk1n0jd5qewq26dgiijwq282p` (`account_id`),
  KEY `FK3efxyu94ra1v388it46dfs66r` (`tag_id`),
  CONSTRAINT `FK3efxyu94ra1v388it46dfs66r` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKpk1n0jd5qewq26dgiijwq282p` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_tag`
--

LOCK TABLES `account_tag` WRITE;
/*!40000 ALTER TABLE `account_tag` DISABLE KEYS */;
INSERT INTO `account_tag` VALUES (1,'2023-06-04 15:56:54',1,1),(2,'2023-06-04 15:57:04',2,2),(3,'2023-06-04 15:57:10',3,3),(4,'2023-06-04 15:57:35',4,4),(5,'2023-06-04 15:58:39',4,5),(6,'2023-06-04 20:27:35',5,5);
/*!40000 ALTER TABLE `account_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_tag_seq`
--

DROP TABLE IF EXISTS `account_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_tag_seq`
--

LOCK TABLES `account_tag_seq` WRITE;
/*!40000 ALTER TABLE `account_tag_seq` DISABLE KEYS */;
INSERT INTO `account_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `account_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `account_tasks_seq`
--

DROP TABLE IF EXISTS `account_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_tasks_seq`
--

LOCK TABLES `account_tasks_seq` WRITE;
/*!40000 ALTER TABLE `account_tasks_seq` DISABLE KEYS */;
INSERT INTO `account_tasks_seq` VALUES (7);
/*!40000 ALTER TABLE `account_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_topic`
--

DROP TABLE IF EXISTS `account_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_topic` (
  `account_topic_id` bigint NOT NULL,
  `account_date` datetime DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`account_topic_id`),
  KEY `FKmo7e3nkkoavcf4u2yf36ipq2t` (`account_id`),
  KEY `FKaxf3wnk5w7615g715nkl1vqry` (`topic_id`),
  CONSTRAINT `FKaxf3wnk5w7615g715nkl1vqry` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKmo7e3nkkoavcf4u2yf36ipq2t` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_topic`
--

LOCK TABLES `account_topic` WRITE;
/*!40000 ALTER TABLE `account_topic` DISABLE KEYS */;
INSERT INTO `account_topic` VALUES (1,'2023-06-04 20:12:52',1,1),(2,'2023-06-04 20:12:57',2,2),(3,'2023-06-04 20:13:01',3,3),(4,'2023-06-04 20:13:04',4,4),(5,'2023-06-04 20:13:07',4,5),(6,'2023-06-04 20:28:08',5,5);
/*!40000 ALTER TABLE `account_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_topic_seq`
--

DROP TABLE IF EXISTS `account_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_topic_seq`
--

LOCK TABLES `account_topic_seq` WRITE;
/*!40000 ALTER TABLE `account_topic_seq` DISABLE KEYS */;
INSERT INTO `account_topic_seq` VALUES (7);
/*!40000 ALTER TABLE `account_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_transaction`
--

DROP TABLE IF EXISTS `account_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_transaction` (
  `account_transaction_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  `sum` double DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`account_transaction_id`),
  KEY `FKqonh25s0w6r5cf8jq88m6kd8o` (`account_id`),
  KEY `FK6xxmvl1tnux0xew6y0204fbbo` (`transaction_id`),
  CONSTRAINT `FK6xxmvl1tnux0xew6y0204fbbo` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  CONSTRAINT `FKqonh25s0w6r5cf8jq88m6kd8o` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_transaction`
--

LOCK TABLES `account_transaction` WRITE;
/*!40000 ALTER TABLE `account_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_transaction_seq`
--

DROP TABLE IF EXISTS `account_transaction_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_transaction_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_transaction_seq`
--

LOCK TABLES `account_transaction_seq` WRITE;
/*!40000 ALTER TABLE `account_transaction_seq` DISABLE KEYS */;
INSERT INTO `account_transaction_seq` VALUES (1);
/*!40000 ALTER TABLE `account_transaction_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_user`
--

DROP TABLE IF EXISTS `account_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_user` (
  `account_user_id` bigint NOT NULL,
  `account_date` datetime DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`account_user_id`),
  KEY `FKk23j4jgjehfo3chwjvthm88f3` (`account_id`),
  KEY `FK52dce9tk40s6vc8eave7n4erh` (`user_id`),
  CONSTRAINT `FK52dce9tk40s6vc8eave7n4erh` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKk23j4jgjehfo3chwjvthm88f3` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_user`
--

LOCK TABLES `account_user` WRITE;
/*!40000 ALTER TABLE `account_user` DISABLE KEYS */;
INSERT INTO `account_user` VALUES (1,'2023-06-04 15:44:09',1,1),(2,'2023-06-04 15:44:15',2,1),(3,'2023-06-04 15:44:18',3,1),(4,'2023-06-04 15:44:21',4,1),(5,'2023-06-04 15:44:26',5,1),(6,'2023-06-04 19:33:28',1,2),(7,'2023-06-04 19:33:54',1,3),(8,'2023-06-04 19:34:05',2,2),(9,'2023-06-04 19:34:10',3,2);
/*!40000 ALTER TABLE `account_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_user_seq`
--

DROP TABLE IF EXISTS `account_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_user_seq`
--

LOCK TABLES `account_user_seq` WRITE;
/*!40000 ALTER TABLE `account_user_seq` DISABLE KEYS */;
INSERT INTO `account_user_seq` VALUES (10);
/*!40000 ALTER TABLE `account_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `google_location` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FKda8tuywtf0gb6sedwk7la1pgi` (`user_id`),
  CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'2023-06-14 13:25:22','1','address1',1),(2,'2023-06-14 13:25:26','2','address2',1),(3,'2023-06-14 13:25:29','3','address3',1),(4,'2023-06-14 13:25:33','4','address4',1),(5,'2023-06-14 13:25:37','5','address5',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_history_seq`
--

DROP TABLE IF EXISTS `address_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_history_seq`
--

LOCK TABLES `address_history_seq` WRITE;
/*!40000 ALTER TABLE `address_history_seq` DISABLE KEYS */;
INSERT INTO `address_history_seq` VALUES (1);
/*!40000 ALTER TABLE `address_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_reminder`
--

DROP TABLE IF EXISTS `address_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_reminder` (
  `address_reminder_id` bigint NOT NULL,
  `address_date` datetime DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`address_reminder_id`),
  KEY `FKocndv24qf8d6lt975q67xcl9b` (`address_id`),
  KEY `FKn1ydl2qroea5v051eeauxagxb` (`reminder_id`),
  CONSTRAINT `FKn1ydl2qroea5v051eeauxagxb` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKocndv24qf8d6lt975q67xcl9b` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_reminder`
--

LOCK TABLES `address_reminder` WRITE;
/*!40000 ALTER TABLE `address_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_reminder_seq`
--

DROP TABLE IF EXISTS `address_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_reminder_seq`
--

LOCK TABLES `address_reminder_seq` WRITE;
/*!40000 ALTER TABLE `address_reminder_seq` DISABLE KEYS */;
INSERT INTO `address_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `address_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_seq`
--

DROP TABLE IF EXISTS `address_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_seq`
--

LOCK TABLES `address_seq` WRITE;
/*!40000 ALTER TABLE `address_seq` DISABLE KEYS */;
INSERT INTO `address_seq` VALUES (6);
/*!40000 ALTER TABLE `address_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_tag`
--

DROP TABLE IF EXISTS `address_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_tag` (
  `address_tag_id` bigint NOT NULL,
  `address_date` datetime DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`address_tag_id`),
  KEY `FK9ybbmrt04gjctlf5tj1p0mk9l` (`address_id`),
  KEY `FK8mggv80lsn331xa42585kim18` (`tag_id`),
  CONSTRAINT `FK8mggv80lsn331xa42585kim18` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FK9ybbmrt04gjctlf5tj1p0mk9l` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_tag`
--

LOCK TABLES `address_tag` WRITE;
/*!40000 ALTER TABLE `address_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_tag_seq`
--

DROP TABLE IF EXISTS `address_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_tag_seq`
--

LOCK TABLES `address_tag_seq` WRITE;
/*!40000 ALTER TABLE `address_tag_seq` DISABLE KEYS */;
INSERT INTO `address_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `address_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_tasks`
--

DROP TABLE IF EXISTS `address_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_tasks` (
  `address_tasks_id` bigint NOT NULL,
  `address_date` datetime DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`address_tasks_id`),
  KEY `FKskegyue7oy33aw15818rmmovw` (`address_id`),
  KEY `FK7xck938p1v326at96a0dapj60` (`tasks_id`),
  CONSTRAINT `FK7xck938p1v326at96a0dapj60` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKskegyue7oy33aw15818rmmovw` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_tasks`
--

LOCK TABLES `address_tasks` WRITE;
/*!40000 ALTER TABLE `address_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_tasks_seq`
--

DROP TABLE IF EXISTS `address_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_tasks_seq`
--

LOCK TABLES `address_tasks_seq` WRITE;
/*!40000 ALTER TABLE `address_tasks_seq` DISABLE KEYS */;
INSERT INTO `address_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `address_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_topic`
--

DROP TABLE IF EXISTS `address_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_topic` (
  `address_topic_id` bigint NOT NULL,
  `address_date` datetime DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`address_topic_id`),
  KEY `FKc40e8xso8y22dy39xhc6a5qrt` (`address_id`),
  KEY `FKkitb3ou7uxmnfxsd68pc2pjg3` (`topic_id`),
  CONSTRAINT `FKc40e8xso8y22dy39xhc6a5qrt` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `FKkitb3ou7uxmnfxsd68pc2pjg3` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_topic`
--

LOCK TABLES `address_topic` WRITE;
/*!40000 ALTER TABLE `address_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_topic_seq`
--

DROP TABLE IF EXISTS `address_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_topic_seq`
--

LOCK TABLES `address_topic_seq` WRITE;
/*!40000 ALTER TABLE `address_topic_seq` DISABLE KEYS */;
INSERT INTO `address_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `address_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_user`
--

DROP TABLE IF EXISTS `address_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_user` (
  `address_user_id` bigint NOT NULL,
  `address_date` datetime DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`address_user_id`),
  KEY `FKfmtj9b1cg7vb54nrgjnm8hqdp` (`address_id`),
  KEY `FKe9lmb3rbwq0goy6h1c129lodw` (`user_id`),
  CONSTRAINT `FKe9lmb3rbwq0goy6h1c129lodw` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKfmtj9b1cg7vb54nrgjnm8hqdp` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_user`
--

LOCK TABLES `address_user` WRITE;
/*!40000 ALTER TABLE `address_user` DISABLE KEYS */;
INSERT INTO `address_user` VALUES (1,'2023-06-14 13:25:22',1,1),(2,'2023-06-14 13:25:26',2,1),(3,'2023-06-14 13:25:29',3,1),(4,'2023-06-14 13:25:33',4,1),(5,'2023-06-14 13:25:37',5,1);
/*!40000 ALTER TABLE `address_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_user_seq`
--

DROP TABLE IF EXISTS `address_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_user_seq`
--

LOCK TABLES `address_user_seq` WRITE;
/*!40000 ALTER TABLE `address_user_seq` DISABLE KEYS */;
INSERT INTO `address_user_seq` VALUES (6);
/*!40000 ALTER TABLE `address_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates`
--

DROP TABLE IF EXISTS `dates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates` (
  `dates_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `dates_date` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`dates_id`),
  KEY `FK5ck7upcn9xg0mmi48kxvhv2fh` (`user_id`),
  CONSTRAINT `FK5ck7upcn9xg0mmi48kxvhv2fh` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates`
--

LOCK TABLES `dates` WRITE;
/*!40000 ALTER TABLE `dates` DISABLE KEYS */;
INSERT INTO `dates` VALUES (1,'2023-06-14 13:42:20','1','date1',1),(2,'2023-06-14 13:42:24','2','date2',1),(3,'2023-06-14 13:42:29','3','date3',1),(4,'2023-06-14 13:42:32','4','date4',1),(5,'2023-06-14 13:42:35','5','date5',1);
/*!40000 ALTER TABLE `dates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_history_seq`
--

DROP TABLE IF EXISTS `dates_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_history_seq`
--

LOCK TABLES `dates_history_seq` WRITE;
/*!40000 ALTER TABLE `dates_history_seq` DISABLE KEYS */;
INSERT INTO `dates_history_seq` VALUES (1);
/*!40000 ALTER TABLE `dates_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_reminder`
--

DROP TABLE IF EXISTS `dates_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_reminder` (
  `dates_reminder_id` bigint NOT NULL,
  `dates_date` datetime DEFAULT NULL,
  `dates_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`dates_reminder_id`),
  KEY `FKa0n04t2cpikjfsldbk2v9bbb7` (`dates_id`),
  KEY `FK9vm894cutj4sorfe5ohm2p57l` (`reminder_id`),
  CONSTRAINT `FK9vm894cutj4sorfe5ohm2p57l` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKa0n04t2cpikjfsldbk2v9bbb7` FOREIGN KEY (`dates_id`) REFERENCES `dates` (`dates_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_reminder`
--

LOCK TABLES `dates_reminder` WRITE;
/*!40000 ALTER TABLE `dates_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `dates_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_reminder_seq`
--

DROP TABLE IF EXISTS `dates_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_reminder_seq`
--

LOCK TABLES `dates_reminder_seq` WRITE;
/*!40000 ALTER TABLE `dates_reminder_seq` DISABLE KEYS */;
INSERT INTO `dates_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `dates_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_seq`
--

DROP TABLE IF EXISTS `dates_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_seq`
--

LOCK TABLES `dates_seq` WRITE;
/*!40000 ALTER TABLE `dates_seq` DISABLE KEYS */;
INSERT INTO `dates_seq` VALUES (6);
/*!40000 ALTER TABLE `dates_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_tag`
--

DROP TABLE IF EXISTS `dates_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_tag` (
  `dates_tag_id` bigint NOT NULL,
  `dates_date` datetime DEFAULT NULL,
  `dates_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`dates_tag_id`),
  KEY `FK345laq9ssi9b9frpnxjhk9r0f` (`dates_id`),
  KEY `FK7lacse5tgkrhni1j9gybn0r05` (`tag_id`),
  CONSTRAINT `FK345laq9ssi9b9frpnxjhk9r0f` FOREIGN KEY (`dates_id`) REFERENCES `dates` (`dates_id`),
  CONSTRAINT `FK7lacse5tgkrhni1j9gybn0r05` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_tag`
--

LOCK TABLES `dates_tag` WRITE;
/*!40000 ALTER TABLE `dates_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `dates_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_tag_seq`
--

DROP TABLE IF EXISTS `dates_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_tag_seq`
--

LOCK TABLES `dates_tag_seq` WRITE;
/*!40000 ALTER TABLE `dates_tag_seq` DISABLE KEYS */;
INSERT INTO `dates_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `dates_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_tasks`
--

DROP TABLE IF EXISTS `dates_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_tasks` (
  `dates_tasks_id` bigint NOT NULL,
  `dates_date` datetime DEFAULT NULL,
  `dates_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`dates_tasks_id`),
  KEY `FKqaknvlnc88tbf7uasfhy067ub` (`dates_id`),
  KEY `FK2rm6h8dg8ciilhe53w4e62c1y` (`tasks_id`),
  CONSTRAINT `FK2rm6h8dg8ciilhe53w4e62c1y` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKqaknvlnc88tbf7uasfhy067ub` FOREIGN KEY (`dates_id`) REFERENCES `dates` (`dates_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_tasks`
--

LOCK TABLES `dates_tasks` WRITE;
/*!40000 ALTER TABLE `dates_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `dates_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_tasks_seq`
--

DROP TABLE IF EXISTS `dates_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_tasks_seq`
--

LOCK TABLES `dates_tasks_seq` WRITE;
/*!40000 ALTER TABLE `dates_tasks_seq` DISABLE KEYS */;
INSERT INTO `dates_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `dates_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_topic`
--

DROP TABLE IF EXISTS `dates_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_topic` (
  `dates_topic_id` bigint NOT NULL,
  `dates_date` datetime DEFAULT NULL,
  `dates_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`dates_topic_id`),
  KEY `FK6wo6jmuj99cyn1unm3mbxyuf6` (`dates_id`),
  KEY `FKi9d1uonrew0eukiexb6h8741k` (`topic_id`),
  CONSTRAINT `FK6wo6jmuj99cyn1unm3mbxyuf6` FOREIGN KEY (`dates_id`) REFERENCES `dates` (`dates_id`),
  CONSTRAINT `FKi9d1uonrew0eukiexb6h8741k` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_topic`
--

LOCK TABLES `dates_topic` WRITE;
/*!40000 ALTER TABLE `dates_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `dates_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_topic_seq`
--

DROP TABLE IF EXISTS `dates_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_topic_seq`
--

LOCK TABLES `dates_topic_seq` WRITE;
/*!40000 ALTER TABLE `dates_topic_seq` DISABLE KEYS */;
INSERT INTO `dates_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `dates_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_user`
--

DROP TABLE IF EXISTS `dates_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_user` (
  `dates_user_id` bigint NOT NULL,
  `dates_date` datetime DEFAULT NULL,
  `dates_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`dates_user_id`),
  KEY `FK6122wcs2a4qc1lcuhladrpr1i` (`dates_id`),
  KEY `FK9xqef3vsy4hg3twir6cqw41vm` (`user_id`),
  CONSTRAINT `FK6122wcs2a4qc1lcuhladrpr1i` FOREIGN KEY (`dates_id`) REFERENCES `dates` (`dates_id`),
  CONSTRAINT `FK9xqef3vsy4hg3twir6cqw41vm` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_user`
--

LOCK TABLES `dates_user` WRITE;
/*!40000 ALTER TABLE `dates_user` DISABLE KEYS */;
INSERT INTO `dates_user` VALUES (1,'2023-06-14 13:42:20',1,1),(2,'2023-06-14 13:42:24',2,1),(3,'2023-06-14 13:42:29',3,1),(4,'2023-06-14 13:42:32',4,1),(5,'2023-06-14 13:42:35',5,1);
/*!40000 ALTER TABLE `dates_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dates_user_seq`
--

DROP TABLE IF EXISTS `dates_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dates_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dates_user_seq`
--

LOCK TABLES `dates_user_seq` WRITE;
/*!40000 ALTER TABLE `dates_user_seq` DISABLE KEYS */;
INSERT INTO `dates_user_seq` VALUES (6);
/*!40000 ALTER TABLE `dates_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document` (
  `document_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`document_id`),
  KEY `FKjhdxdv9sijhujiynqbb5jc010` (`user_id`),
  CONSTRAINT `FKjhdxdv9sijhujiynqbb5jc010` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (1,'2023-06-14 13:24:22','doc1','type1',1),(2,'2023-06-14 13:24:29','doc2','type2',1),(3,'2023-06-14 13:24:33','doc3','type3',1),(4,'2023-06-14 13:24:37','doc4','type4',1),(5,'2023-06-14 13:24:42','doc5','type5',1);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_history_seq`
--

DROP TABLE IF EXISTS `document_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_history_seq`
--

LOCK TABLES `document_history_seq` WRITE;
/*!40000 ALTER TABLE `document_history_seq` DISABLE KEYS */;
INSERT INTO `document_history_seq` VALUES (1);
/*!40000 ALTER TABLE `document_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_reminder`
--

DROP TABLE IF EXISTS `document_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_reminder` (
  `document_reminder_id` bigint NOT NULL,
  `document_date` datetime DEFAULT NULL,
  `document_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`document_reminder_id`),
  KEY `FK5f8w7pekniv5d862gu00nrty4` (`document_id`),
  KEY `FKk00729pygr7my8bwsou5o4bve` (`reminder_id`),
  CONSTRAINT `FK5f8w7pekniv5d862gu00nrty4` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`),
  CONSTRAINT `FKk00729pygr7my8bwsou5o4bve` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_reminder`
--

LOCK TABLES `document_reminder` WRITE;
/*!40000 ALTER TABLE `document_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_reminder_seq`
--

DROP TABLE IF EXISTS `document_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_reminder_seq`
--

LOCK TABLES `document_reminder_seq` WRITE;
/*!40000 ALTER TABLE `document_reminder_seq` DISABLE KEYS */;
INSERT INTO `document_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `document_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_seq`
--

DROP TABLE IF EXISTS `document_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_seq`
--

LOCK TABLES `document_seq` WRITE;
/*!40000 ALTER TABLE `document_seq` DISABLE KEYS */;
INSERT INTO `document_seq` VALUES (6);
/*!40000 ALTER TABLE `document_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_tag`
--

DROP TABLE IF EXISTS `document_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_tag` (
  `document_tag_id` bigint NOT NULL,
  `document_date` datetime DEFAULT NULL,
  `document_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`document_tag_id`),
  KEY `FK98udkjibnc8i311pudktnh2xj` (`document_id`),
  KEY `FKfnt25osbwbkgblqchc8npl00` (`tag_id`),
  CONSTRAINT `FK98udkjibnc8i311pudktnh2xj` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`),
  CONSTRAINT `FKfnt25osbwbkgblqchc8npl00` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_tag`
--

LOCK TABLES `document_tag` WRITE;
/*!40000 ALTER TABLE `document_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_tag_seq`
--

DROP TABLE IF EXISTS `document_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_tag_seq`
--

LOCK TABLES `document_tag_seq` WRITE;
/*!40000 ALTER TABLE `document_tag_seq` DISABLE KEYS */;
INSERT INTO `document_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `document_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_tasks`
--

DROP TABLE IF EXISTS `document_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_tasks` (
  `document_tasks_id` bigint NOT NULL,
  `document_date` datetime DEFAULT NULL,
  `document_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`document_tasks_id`),
  KEY `FKd5m0jpivcjd7nvoh8hstpm3rg` (`document_id`),
  KEY `FKh136hcgw7jca6k23mf28x9mf5` (`tasks_id`),
  CONSTRAINT `FKd5m0jpivcjd7nvoh8hstpm3rg` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`),
  CONSTRAINT `FKh136hcgw7jca6k23mf28x9mf5` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_tasks`
--

LOCK TABLES `document_tasks` WRITE;
/*!40000 ALTER TABLE `document_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_tasks_seq`
--

DROP TABLE IF EXISTS `document_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_tasks_seq`
--

LOCK TABLES `document_tasks_seq` WRITE;
/*!40000 ALTER TABLE `document_tasks_seq` DISABLE KEYS */;
INSERT INTO `document_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `document_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_topic`
--

DROP TABLE IF EXISTS `document_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_topic` (
  `document_topic_id` bigint NOT NULL,
  `document_date` datetime DEFAULT NULL,
  `document_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`document_topic_id`),
  KEY `FKpl3ovld5i0brxls4s7jo4uhpq` (`document_id`),
  KEY `FKrf4yhhfqupqqy6fl3xsp4e0k4` (`topic_id`),
  CONSTRAINT `FKpl3ovld5i0brxls4s7jo4uhpq` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`),
  CONSTRAINT `FKrf4yhhfqupqqy6fl3xsp4e0k4` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_topic`
--

LOCK TABLES `document_topic` WRITE;
/*!40000 ALTER TABLE `document_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_topic_seq`
--

DROP TABLE IF EXISTS `document_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_topic_seq`
--

LOCK TABLES `document_topic_seq` WRITE;
/*!40000 ALTER TABLE `document_topic_seq` DISABLE KEYS */;
INSERT INTO `document_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `document_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_user`
--

DROP TABLE IF EXISTS `document_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_user` (
  `document_user_id` bigint NOT NULL,
  `document_date` datetime DEFAULT NULL,
  `document_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`document_user_id`),
  KEY `FK8fgr0c6feep2otaif5oy1ndxx` (`document_id`),
  KEY `FK2f4ll6knil0en5ymw8g5ylf92` (`user_id`),
  CONSTRAINT `FK2f4ll6knil0en5ymw8g5ylf92` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK8fgr0c6feep2otaif5oy1ndxx` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_user`
--

LOCK TABLES `document_user` WRITE;
/*!40000 ALTER TABLE `document_user` DISABLE KEYS */;
INSERT INTO `document_user` VALUES (1,'2023-06-14 13:24:22',1,1),(2,'2023-06-14 13:24:29',2,1),(3,'2023-06-14 13:24:33',3,1),(4,'2023-06-14 13:24:37',4,1),(5,'2023-06-14 13:24:42',5,1);
/*!40000 ALTER TABLE `document_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_user_seq`
--

DROP TABLE IF EXISTS `document_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_user_seq`
--

LOCK TABLES `document_user_seq` WRITE;
/*!40000 ALTER TABLE `document_user_seq` DISABLE KEYS */;
INSERT INTO `document_user_seq` VALUES (6);
/*!40000 ALTER TABLE `document_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email` (
  `email_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`email_id`),
  KEY `FK4qxwfk0jqc0au545318wfiqxx` (`user_id`),
  CONSTRAINT `FK4qxwfk0jqc0au545318wfiqxx` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (1,'2023-06-14 13:26:28','E@1','email1',1),(2,'2023-06-14 13:26:35','E@2','email2',1),(3,'2023-06-14 13:26:41','E@3','email3',1),(4,'2023-06-14 13:26:45','E@4','email4',1),(5,'2023-06-14 13:26:48','E@5','email5',1);
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_history_seq`
--

DROP TABLE IF EXISTS `email_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_history_seq`
--

LOCK TABLES `email_history_seq` WRITE;
/*!40000 ALTER TABLE `email_history_seq` DISABLE KEYS */;
INSERT INTO `email_history_seq` VALUES (1);
/*!40000 ALTER TABLE `email_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_reminder`
--

DROP TABLE IF EXISTS `email_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_reminder` (
  `email_reminder_id` bigint NOT NULL,
  `email_date` datetime DEFAULT NULL,
  `email_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`email_reminder_id`),
  KEY `FKmg1csymwiqjuw45qfcg4bu5cu` (`email_id`),
  KEY `FKtiahs8bvqhwe3hbvaicj499h1` (`reminder_id`),
  CONSTRAINT `FKmg1csymwiqjuw45qfcg4bu5cu` FOREIGN KEY (`email_id`) REFERENCES `email` (`email_id`),
  CONSTRAINT `FKtiahs8bvqhwe3hbvaicj499h1` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_reminder`
--

LOCK TABLES `email_reminder` WRITE;
/*!40000 ALTER TABLE `email_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_reminder_seq`
--

DROP TABLE IF EXISTS `email_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_reminder_seq`
--

LOCK TABLES `email_reminder_seq` WRITE;
/*!40000 ALTER TABLE `email_reminder_seq` DISABLE KEYS */;
INSERT INTO `email_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `email_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_seq`
--

DROP TABLE IF EXISTS `email_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_seq`
--

LOCK TABLES `email_seq` WRITE;
/*!40000 ALTER TABLE `email_seq` DISABLE KEYS */;
INSERT INTO `email_seq` VALUES (6);
/*!40000 ALTER TABLE `email_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_tag`
--

DROP TABLE IF EXISTS `email_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_tag` (
  `email_tag_id` bigint NOT NULL,
  `email_date` datetime DEFAULT NULL,
  `email_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`email_tag_id`),
  KEY `FKg2w2941dv0pasioom0n5cgvlv` (`email_id`),
  KEY `FKpr5isd36t7nfsskpliab1ndmw` (`tag_id`),
  CONSTRAINT `FKg2w2941dv0pasioom0n5cgvlv` FOREIGN KEY (`email_id`) REFERENCES `email` (`email_id`),
  CONSTRAINT `FKpr5isd36t7nfsskpliab1ndmw` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_tag`
--

LOCK TABLES `email_tag` WRITE;
/*!40000 ALTER TABLE `email_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_tag_seq`
--

DROP TABLE IF EXISTS `email_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_tag_seq`
--

LOCK TABLES `email_tag_seq` WRITE;
/*!40000 ALTER TABLE `email_tag_seq` DISABLE KEYS */;
INSERT INTO `email_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `email_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_tasks`
--

DROP TABLE IF EXISTS `email_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_tasks` (
  `email_tasks_id` bigint NOT NULL,
  `email_date` datetime DEFAULT NULL,
  `email_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`email_tasks_id`),
  KEY `FK2d4ap64kso7e2uhw5unkrmsun` (`email_id`),
  KEY `FKuudtyok6hgcu1yui59ehogtm` (`tasks_id`),
  CONSTRAINT `FK2d4ap64kso7e2uhw5unkrmsun` FOREIGN KEY (`email_id`) REFERENCES `email` (`email_id`),
  CONSTRAINT `FKuudtyok6hgcu1yui59ehogtm` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_tasks`
--

LOCK TABLES `email_tasks` WRITE;
/*!40000 ALTER TABLE `email_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_tasks_seq`
--

DROP TABLE IF EXISTS `email_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_tasks_seq`
--

LOCK TABLES `email_tasks_seq` WRITE;
/*!40000 ALTER TABLE `email_tasks_seq` DISABLE KEYS */;
INSERT INTO `email_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `email_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_topic`
--

DROP TABLE IF EXISTS `email_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_topic` (
  `email_topic_id` bigint NOT NULL,
  `email_date` datetime DEFAULT NULL,
  `email_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`email_topic_id`),
  KEY `FK70d1kh8yo0tkvq1swwevb40q5` (`email_id`),
  KEY `FKh2tgu078d6nytmaa9euog43vg` (`topic_id`),
  CONSTRAINT `FK70d1kh8yo0tkvq1swwevb40q5` FOREIGN KEY (`email_id`) REFERENCES `email` (`email_id`),
  CONSTRAINT `FKh2tgu078d6nytmaa9euog43vg` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_topic`
--

LOCK TABLES `email_topic` WRITE;
/*!40000 ALTER TABLE `email_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `email_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_topic_seq`
--

DROP TABLE IF EXISTS `email_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_topic_seq`
--

LOCK TABLES `email_topic_seq` WRITE;
/*!40000 ALTER TABLE `email_topic_seq` DISABLE KEYS */;
INSERT INTO `email_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `email_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_user`
--

DROP TABLE IF EXISTS `email_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_user` (
  `email_user_id` bigint NOT NULL,
  `email_date` datetime DEFAULT NULL,
  `email_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`email_user_id`),
  KEY `FKq4l64xt5kcrexefjfof7thksa` (`email_id`),
  KEY `FKj2bsxcpa0alscn7gg6wx50gg0` (`user_id`),
  CONSTRAINT `FKj2bsxcpa0alscn7gg6wx50gg0` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKq4l64xt5kcrexefjfof7thksa` FOREIGN KEY (`email_id`) REFERENCES `email` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_user`
--

LOCK TABLES `email_user` WRITE;
/*!40000 ALTER TABLE `email_user` DISABLE KEYS */;
INSERT INTO `email_user` VALUES (1,'2023-06-14 13:26:28',1,1),(2,'2023-06-14 13:26:35',2,1),(3,'2023-06-14 13:26:41',3,1),(4,'2023-06-14 13:26:45',4,1),(5,'2023-06-14 13:26:48',5,1);
/*!40000 ALTER TABLE `email_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email_user_seq`
--

DROP TABLE IF EXISTS `email_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email_user_seq`
--

LOCK TABLES `email_user_seq` WRITE;
/*!40000 ALTER TABLE `email_user_seq` DISABLE KEYS */;
INSERT INTO `email_user_seq` VALUES (6);
/*!40000 ALTER TABLE `email_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `event_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `FKi8bsvlthqr8lngsyshiqsodak` (`user_id`),
  CONSTRAINT `FKi8bsvlthqr8lngsyshiqsodak` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'2023-06-14 18:11:46','Event1',1),(2,'2023-06-14 18:11:53','Event2',1),(3,'2023-06-14 18:11:58','Event3',1),(4,'2023-06-14 18:12:05','Event33',1),(5,'2023-06-14 18:12:08','Event333',1);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_expense`
--

DROP TABLE IF EXISTS `event_expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_expense` (
  `event_expense_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_expense_id`),
  KEY `FKqb86mkkhurxn02npieu0tc7xv` (`event_id`),
  KEY `FKfb3ytmh510vxl4o15dpwi5wkm` (`expense_id`),
  CONSTRAINT `FKfb3ytmh510vxl4o15dpwi5wkm` FOREIGN KEY (`expense_id`) REFERENCES `expenses` (`expenses_id`),
  CONSTRAINT `FKqb86mkkhurxn02npieu0tc7xv` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_expense`
--

LOCK TABLES `event_expense` WRITE;
/*!40000 ALTER TABLE `event_expense` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_expense_seq`
--

DROP TABLE IF EXISTS `event_expense_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_expense_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_expense_seq`
--

LOCK TABLES `event_expense_seq` WRITE;
/*!40000 ALTER TABLE `event_expense_seq` DISABLE KEYS */;
INSERT INTO `event_expense_seq` VALUES (1);
/*!40000 ALTER TABLE `event_expense_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_expenses`
--

DROP TABLE IF EXISTS `event_expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_expenses` (
  `event_expenses_id` bigint NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_expenses_id`),
  KEY `FKgquieqn0gklei1dfc32rv3hu1` (`event_id`),
  KEY `FKnp1of12nggto0b0cuhdda3lyt` (`expenses_id`),
  CONSTRAINT `FKgquieqn0gklei1dfc32rv3hu1` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`),
  CONSTRAINT `FKnp1of12nggto0b0cuhdda3lyt` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_expenses`
--

LOCK TABLES `event_expenses` WRITE;
/*!40000 ALTER TABLE `event_expenses` DISABLE KEYS */;
INSERT INTO `event_expenses` VALUES (1,'2023-06-14 20:09:02',1,1),(2,'2023-06-14 20:09:05',2,2),(3,'2023-06-14 20:09:09',3,3),(4,'2023-06-14 20:09:14',4,4),(5,'2023-06-14 20:09:23',4,5),(6,'2023-06-14 20:09:25',5,5);
/*!40000 ALTER TABLE `event_expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_expenses_seq`
--

DROP TABLE IF EXISTS `event_expenses_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_expenses_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_expenses_seq`
--

LOCK TABLES `event_expenses_seq` WRITE;
/*!40000 ALTER TABLE `event_expenses_seq` DISABLE KEYS */;
INSERT INTO `event_expenses_seq` VALUES (7);
/*!40000 ALTER TABLE `event_expenses_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_history_seq`
--

DROP TABLE IF EXISTS `event_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_history_seq`
--

LOCK TABLES `event_history_seq` WRITE;
/*!40000 ALTER TABLE `event_history_seq` DISABLE KEYS */;
INSERT INTO `event_history_seq` VALUES (1);
/*!40000 ALTER TABLE `event_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_person`
--

DROP TABLE IF EXISTS `event_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_person` (
  `event_person_id` bigint NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_person_id`),
  KEY `FKpmqgfnq8lnm52ofkr4s7lo9me` (`event_id`),
  KEY `FKlgigtkdw54k3eif4208c5n5yf` (`person_id`),
  CONSTRAINT `FKlgigtkdw54k3eif4208c5n5yf` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKpmqgfnq8lnm52ofkr4s7lo9me` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_person`
--

LOCK TABLES `event_person` WRITE;
/*!40000 ALTER TABLE `event_person` DISABLE KEYS */;
INSERT INTO `event_person` VALUES (1,'2023-06-14 20:10:50',1,1),(2,'2023-06-14 20:10:56',2,2),(3,'2023-06-14 20:10:58',3,3),(4,'2023-06-14 20:11:00',4,4),(5,'2023-06-14 20:11:02',4,5),(6,'2023-06-14 20:11:04',5,5);
/*!40000 ALTER TABLE `event_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_person_seq`
--

DROP TABLE IF EXISTS `event_person_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_person_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_person_seq`
--

LOCK TABLES `event_person_seq` WRITE;
/*!40000 ALTER TABLE `event_person_seq` DISABLE KEYS */;
INSERT INTO `event_person_seq` VALUES (7);
/*!40000 ALTER TABLE `event_person_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_reminder`
--

DROP TABLE IF EXISTS `event_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_reminder` (
  `event_reminder_id` bigint NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_reminder_id`),
  KEY `FKnhrxpvemv6ejpawrrtc53jf48` (`event_id`),
  KEY `FK8vgd2ab0bh9maddx7ixnqqc8a` (`reminder_id`),
  CONSTRAINT `FK8vgd2ab0bh9maddx7ixnqqc8a` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKnhrxpvemv6ejpawrrtc53jf48` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_reminder`
--

LOCK TABLES `event_reminder` WRITE;
/*!40000 ALTER TABLE `event_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_reminder_seq`
--

DROP TABLE IF EXISTS `event_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_reminder_seq`
--

LOCK TABLES `event_reminder_seq` WRITE;
/*!40000 ALTER TABLE `event_reminder_seq` DISABLE KEYS */;
INSERT INTO `event_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `event_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_seq`
--

DROP TABLE IF EXISTS `event_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_seq`
--

LOCK TABLES `event_seq` WRITE;
/*!40000 ALTER TABLE `event_seq` DISABLE KEYS */;
INSERT INTO `event_seq` VALUES (6);
/*!40000 ALTER TABLE `event_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_tag`
--

DROP TABLE IF EXISTS `event_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_tag` (
  `event_tag_id` bigint NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_tag_id`),
  KEY `FKfsc56xss2wsnywkg555jq7onb` (`event_id`),
  KEY `FKlhs43hrd40lqogbcf2xsevwo1` (`tag_id`),
  CONSTRAINT `FKfsc56xss2wsnywkg555jq7onb` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`),
  CONSTRAINT `FKlhs43hrd40lqogbcf2xsevwo1` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_tag`
--

LOCK TABLES `event_tag` WRITE;
/*!40000 ALTER TABLE `event_tag` DISABLE KEYS */;
INSERT INTO `event_tag` VALUES (1,'2023-06-14 20:05:07',1,1),(2,'2023-06-14 20:05:11',2,2),(3,'2023-06-14 20:05:13',3,3),(4,'2023-06-14 20:05:17',4,4),(5,'2023-06-14 20:05:18',4,5),(6,'2023-06-14 20:05:21',5,5);
/*!40000 ALTER TABLE `event_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_tag_seq`
--

DROP TABLE IF EXISTS `event_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_tag_seq`
--

LOCK TABLES `event_tag_seq` WRITE;
/*!40000 ALTER TABLE `event_tag_seq` DISABLE KEYS */;
INSERT INTO `event_tag_seq` VALUES (7);
/*!40000 ALTER TABLE `event_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_tasks`
--

DROP TABLE IF EXISTS `event_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_tasks` (
  `event_tasks_id` bigint NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_tasks_id`),
  KEY `FKjm3pyrujo97pxsj1vhroctx8w` (`event_id`),
  KEY `FKe87cwjxup73xes3r4m46ll2bq` (`tasks_id`),
  CONSTRAINT `FKe87cwjxup73xes3r4m46ll2bq` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKjm3pyrujo97pxsj1vhroctx8w` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_tasks`
--

LOCK TABLES `event_tasks` WRITE;
/*!40000 ALTER TABLE `event_tasks` DISABLE KEYS */;
INSERT INTO `event_tasks` VALUES (1,'2023-06-14 20:07:45',1,1),(2,'2023-06-14 20:07:48',2,2),(3,'2023-06-14 20:07:50',3,3),(4,'2023-06-14 20:07:54',4,4),(5,'2023-06-14 20:08:06',4,5),(6,'2023-06-14 20:08:09',5,5);
/*!40000 ALTER TABLE `event_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_tasks_seq`
--

DROP TABLE IF EXISTS `event_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_tasks_seq`
--

LOCK TABLES `event_tasks_seq` WRITE;
/*!40000 ALTER TABLE `event_tasks_seq` DISABLE KEYS */;
INSERT INTO `event_tasks_seq` VALUES (7);
/*!40000 ALTER TABLE `event_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_topic`
--

DROP TABLE IF EXISTS `event_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_topic` (
  `event_topic_id` bigint NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_topic_id`),
  KEY `FKtadmfn6pcomha5kx0l0gjvkhy` (`event_id`),
  KEY `FKevkjmshdun6j6sqte3ndf5st3` (`topic_id`),
  CONSTRAINT `FKevkjmshdun6j6sqte3ndf5st3` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKtadmfn6pcomha5kx0l0gjvkhy` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_topic`
--

LOCK TABLES `event_topic` WRITE;
/*!40000 ALTER TABLE `event_topic` DISABLE KEYS */;
INSERT INTO `event_topic` VALUES (1,'2023-06-14 20:06:57',1,1),(2,'2023-06-14 20:07:02',2,2),(3,'2023-06-14 20:07:04',3,3),(4,'2023-06-14 20:07:07',4,4),(5,'2023-06-14 20:07:10',4,5),(6,'2023-06-14 20:07:12',5,5);
/*!40000 ALTER TABLE `event_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_topic_seq`
--

DROP TABLE IF EXISTS `event_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_topic_seq`
--

LOCK TABLES `event_topic_seq` WRITE;
/*!40000 ALTER TABLE `event_topic_seq` DISABLE KEYS */;
INSERT INTO `event_topic_seq` VALUES (7);
/*!40000 ALTER TABLE `event_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_user`
--

DROP TABLE IF EXISTS `event_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_user` (
  `event_user_id` bigint NOT NULL,
  `event_date` datetime DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`event_user_id`),
  KEY `FKtc58o1e7bpugjcxuqr8l05l12` (`event_id`),
  KEY `FK67g39uhr99s8ney3d8tccqtf6` (`user_id`),
  CONSTRAINT `FK67g39uhr99s8ney3d8tccqtf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKtc58o1e7bpugjcxuqr8l05l12` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_user`
--

LOCK TABLES `event_user` WRITE;
/*!40000 ALTER TABLE `event_user` DISABLE KEYS */;
INSERT INTO `event_user` VALUES (1,'2023-06-14 18:11:46',1,1),(2,'2023-06-14 18:11:53',2,1),(3,'2023-06-14 18:11:58',3,1),(4,'2023-06-14 18:12:05',4,1),(5,'2023-06-14 18:12:08',5,1),(6,'2023-06-14 18:29:45',1,2),(7,'2023-06-14 18:29:47',1,3),(8,'2023-06-14 18:29:50',2,3),(9,'2023-06-14 18:29:52',2,2);
/*!40000 ALTER TABLE `event_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_user_seq`
--

DROP TABLE IF EXISTS `event_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_user_seq`
--

LOCK TABLES `event_user_seq` WRITE;
/*!40000 ALTER TABLE `event_user_seq` DISABLE KEYS */;
INSERT INTO `event_user_seq` VALUES (10);
/*!40000 ALTER TABLE `event_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense`
--

DROP TABLE IF EXISTS `expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense` (
  `expense_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `mean_quantity` double DEFAULT NULL,
  `mean_unit_price` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_for_mean` int DEFAULT NULL,
  `number_of_buys` int DEFAULT NULL,
  `producer` varchar(255) DEFAULT NULL,
  `number_mean` int DEFAULT NULL,
  `number_buys` int DEFAULT NULL,
  PRIMARY KEY (`expense_id`),
  KEY `FK758h5dgdblrpwoaaycbmn29i0` (`user_id`),
  CONSTRAINT `FK758h5dgdblrpwoaaycbmn29i0` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense`
--

LOCK TABLES `expense` WRITE;
/*!40000 ALTER TABLE `expense` DISABLE KEYS */;
INSERT INTO `expense` VALUES (1,'2023-06-04 22:05:40','expense1',1,'category1',1,1,'name1',1,1,'producer1',1,1),(2,'2023-06-04 22:05:51','expense2',1,'category2',2,2,'name2',2,2,'producer2',2,2),(3,'2023-06-04 22:06:01','expense3',1,'category3',3,3,'name3',3,3,'producer3',3,3),(4,'2023-06-04 22:06:09','name4 from producer4',1,'category33',4,4,'name33',4,4,'producer33',4,4),(5,'2023-06-04 22:06:15','name5 from producer5',1,'category333',5,5,'name333',5,5,'producer333',5,5);
/*!40000 ALTER TABLE `expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_history_seq`
--

DROP TABLE IF EXISTS `expense_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_history_seq`
--

LOCK TABLES `expense_history_seq` WRITE;
/*!40000 ALTER TABLE `expense_history_seq` DISABLE KEYS */;
INSERT INTO `expense_history_seq` VALUES (1);
/*!40000 ALTER TABLE `expense_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_reminder`
--

DROP TABLE IF EXISTS `expense_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_reminder` (
  `expense_reminder_id` bigint NOT NULL,
  `expense_date` datetime DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expense_reminder_id`),
  KEY `FKsogpiw70sti4l1ses6n4fehtf` (`expense_id`),
  KEY `FK1wgx9bmaniavsaxu5mns6nhll` (`reminder_id`),
  CONSTRAINT `FK1wgx9bmaniavsaxu5mns6nhll` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKsogpiw70sti4l1ses6n4fehtf` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_reminder`
--

LOCK TABLES `expense_reminder` WRITE;
/*!40000 ALTER TABLE `expense_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `expense_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_reminder_seq`
--

DROP TABLE IF EXISTS `expense_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_reminder_seq`
--

LOCK TABLES `expense_reminder_seq` WRITE;
/*!40000 ALTER TABLE `expense_reminder_seq` DISABLE KEYS */;
INSERT INTO `expense_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `expense_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_seq`
--

DROP TABLE IF EXISTS `expense_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_seq`
--

LOCK TABLES `expense_seq` WRITE;
/*!40000 ALTER TABLE `expense_seq` DISABLE KEYS */;
INSERT INTO `expense_seq` VALUES (6);
/*!40000 ALTER TABLE `expense_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_tag`
--

DROP TABLE IF EXISTS `expense_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_tag` (
  `expense_tag_id` bigint NOT NULL,
  `expense_date` datetime DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expense_tag_id`),
  KEY `FKlm5npj5s529f9n0f1j9xew5wg` (`expense_id`),
  KEY `FKblx5dgr8geeewx49d8106k6ow` (`tag_id`),
  CONSTRAINT `FKblx5dgr8geeewx49d8106k6ow` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKlm5npj5s529f9n0f1j9xew5wg` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_tag`
--

LOCK TABLES `expense_tag` WRITE;
/*!40000 ALTER TABLE `expense_tag` DISABLE KEYS */;
INSERT INTO `expense_tag` VALUES (1,'2023-06-08 15:56:18',1,1),(2,'2023-06-08 15:56:22',2,2),(3,'2023-06-08 15:56:26',3,3),(4,'2023-06-08 15:56:30',4,4),(5,'2023-06-08 15:56:34',4,5),(6,'2023-06-08 15:56:37',5,5);
/*!40000 ALTER TABLE `expense_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_tag_seq`
--

DROP TABLE IF EXISTS `expense_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_tag_seq`
--

LOCK TABLES `expense_tag_seq` WRITE;
/*!40000 ALTER TABLE `expense_tag_seq` DISABLE KEYS */;
INSERT INTO `expense_tag_seq` VALUES (7);
/*!40000 ALTER TABLE `expense_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_tasks`
--

DROP TABLE IF EXISTS `expense_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_tasks` (
  `expense_tasks_id` bigint NOT NULL,
  `expense_date` datetime DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expense_tasks_id`),
  KEY `FKpotpr0nrluxtph9wklmryblp7` (`expense_id`),
  KEY `FKa2453jm5jlu3k38sm5n07qcnd` (`tasks_id`),
  CONSTRAINT `FKa2453jm5jlu3k38sm5n07qcnd` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKpotpr0nrluxtph9wklmryblp7` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_tasks`
--

LOCK TABLES `expense_tasks` WRITE;
/*!40000 ALTER TABLE `expense_tasks` DISABLE KEYS */;
INSERT INTO `expense_tasks` VALUES (1,'2023-06-08 16:00:06',1,1),(2,'2023-06-08 16:00:23',2,2),(3,'2023-06-08 16:00:25',3,3),(4,'2023-06-08 16:00:28',4,4),(5,'2023-06-08 16:00:29',4,5),(6,'2023-06-08 16:00:31',5,5);
/*!40000 ALTER TABLE `expense_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_tasks_seq`
--

DROP TABLE IF EXISTS `expense_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_tasks_seq`
--

LOCK TABLES `expense_tasks_seq` WRITE;
/*!40000 ALTER TABLE `expense_tasks_seq` DISABLE KEYS */;
INSERT INTO `expense_tasks_seq` VALUES (7);
/*!40000 ALTER TABLE `expense_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_topic`
--

DROP TABLE IF EXISTS `expense_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_topic` (
  `expense_topic_id` bigint NOT NULL,
  `expense_date` datetime DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expense_topic_id`),
  KEY `FKmqmjmumidx8ustb8gx27xcqpa` (`expense_id`),
  KEY `FKq460j72e92i7jhm6n948xfoj4` (`topic_id`),
  CONSTRAINT `FKmqmjmumidx8ustb8gx27xcqpa` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`),
  CONSTRAINT `FKq460j72e92i7jhm6n948xfoj4` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_topic`
--

LOCK TABLES `expense_topic` WRITE;
/*!40000 ALTER TABLE `expense_topic` DISABLE KEYS */;
INSERT INTO `expense_topic` VALUES (1,'2023-06-08 15:59:25',1,1),(2,'2023-06-08 15:59:30',2,2),(3,'2023-06-08 15:59:33',3,3),(4,'2023-06-08 15:59:36',4,4),(5,'2023-06-08 15:59:37',4,5),(6,'2023-06-08 15:59:41',5,5);
/*!40000 ALTER TABLE `expense_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_topic_seq`
--

DROP TABLE IF EXISTS `expense_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_topic_seq`
--

LOCK TABLES `expense_topic_seq` WRITE;
/*!40000 ALTER TABLE `expense_topic_seq` DISABLE KEYS */;
INSERT INTO `expense_topic_seq` VALUES (7);
/*!40000 ALTER TABLE `expense_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_user`
--

DROP TABLE IF EXISTS `expense_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_user` (
  `expense_user_id` bigint NOT NULL,
  `expense_date` datetime DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expense_user_id`),
  KEY `FKoe5jqspejuedca8akxrinkx1q` (`expense_id`),
  KEY `FKrhaqujomyvsaha2hxx496618e` (`user_id`),
  CONSTRAINT `FKoe5jqspejuedca8akxrinkx1q` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`),
  CONSTRAINT `FKrhaqujomyvsaha2hxx496618e` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_user`
--

LOCK TABLES `expense_user` WRITE;
/*!40000 ALTER TABLE `expense_user` DISABLE KEYS */;
INSERT INTO `expense_user` VALUES (2,'2023-06-04 22:05:40',1,1),(3,'2023-06-04 22:05:51',2,1),(4,'2023-06-04 22:06:01',3,1),(5,'2023-06-04 22:06:09',4,1),(6,'2023-06-04 22:06:15',5,1),(7,'2023-06-08 15:55:19',1,2),(8,'2023-06-08 15:55:45',2,2);
/*!40000 ALTER TABLE `expense_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expense_user_seq`
--

DROP TABLE IF EXISTS `expense_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense_user_seq`
--

LOCK TABLES `expense_user_seq` WRITE;
/*!40000 ALTER TABLE `expense_user_seq` DISABLE KEYS */;
INSERT INTO `expense_user_seq` VALUES (9);
/*!40000 ALTER TABLE `expense_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses`
--

DROP TABLE IF EXISTS `expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses` (
  `expenses_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `checked_price` double DEFAULT NULL,
  `estimated_total_price` double DEFAULT NULL,
  `payed_date` datetime DEFAULT NULL,
  `shop` varchar(255) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`expenses_id`),
  KEY `FK2qife4sxyeoi1kwgvg769ks8y` (`user_id`),
  CONSTRAINT `FK2qife4sxyeoi1kwgvg769ks8y` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses`
--

LOCK TABLES `expenses` WRITE;
/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
INSERT INTO `expenses` VALUES (1,'2023-06-04 22:20:08','expenses1',1,10,10,'2023-06-01 13:14:15','shop1',10,'type1'),(2,'2023-06-04 22:20:20','expenses2',1,20,20,'2023-06-01 13:14:14','shop2',20,'type2'),(3,'2023-06-04 22:20:26','expenses3',1,30,30,'2023-06-02 13:14:14','shop3',30,'type3'),(4,'2023-06-04 22:20:33','expenses33',1,NULL,NULL,'2023-06-04 13:14:14','shop33',NULL,'type33'),(5,'2023-06-04 22:20:38','expenses333',1,NULL,NULL,NULL,'shop333',NULL,'type333');
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_expense`
--

DROP TABLE IF EXISTS `expenses_expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_expense` (
  `expenses_expense_id` bigint NOT NULL,
  `checks` bit(1) DEFAULT NULL,
  `estimated_price` double DEFAULT NULL,
  `expenses_date` datetime DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expenses_expense_id`),
  KEY `FKdif9h8v0ckbw9f419oa4a3pjx` (`user_id`),
  KEY `FK8asmd3rqvymlpfkirwri7dne8` (`expense_id`),
  KEY `FKnphktw0nv02b3f22tnnvpb0j4` (`expenses_id`),
  CONSTRAINT `FK8asmd3rqvymlpfkirwri7dne8` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`),
  CONSTRAINT `FKdif9h8v0ckbw9f419oa4a3pjx` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKnphktw0nv02b3f22tnnvpb0j4` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_expense`
--

LOCK TABLES `expenses_expense` WRITE;
/*!40000 ALTER TABLE `expenses_expense` DISABLE KEYS */;
INSERT INTO `expenses_expense` VALUES (1,NULL,NULL,'2023-06-07 21:28:54',NULL,NULL,NULL,NULL,1,1,1),(2,NULL,NULL,'2023-06-07 21:28:56',NULL,NULL,NULL,NULL,1,2,2),(3,NULL,NULL,'2023-06-07 21:28:58',NULL,NULL,NULL,NULL,1,3,3),(4,NULL,NULL,'2023-06-07 21:29:01',NULL,NULL,NULL,NULL,1,4,4),(5,NULL,NULL,'2023-06-07 21:29:03',NULL,NULL,NULL,NULL,1,4,5),(6,NULL,NULL,'2023-06-07 21:29:05',NULL,NULL,NULL,NULL,1,5,5);
/*!40000 ALTER TABLE `expenses_expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_expense_seq`
--

DROP TABLE IF EXISTS `expenses_expense_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_expense_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_expense_seq`
--

LOCK TABLES `expenses_expense_seq` WRITE;
/*!40000 ALTER TABLE `expenses_expense_seq` DISABLE KEYS */;
INSERT INTO `expenses_expense_seq` VALUES (7);
/*!40000 ALTER TABLE `expenses_expense_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_history_seq`
--

DROP TABLE IF EXISTS `expenses_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_history_seq`
--

LOCK TABLES `expenses_history_seq` WRITE;
/*!40000 ALTER TABLE `expenses_history_seq` DISABLE KEYS */;
INSERT INTO `expenses_history_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_person`
--

DROP TABLE IF EXISTS `expenses_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_person` (
  `expenses_person_id` bigint NOT NULL,
  `expenses_date` datetime DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expenses_person_id`),
  KEY `FKpdsa49x1g7eti8px3iiebefe5` (`expenses_id`),
  KEY `FK5p0ygau9n2f0r76j7e27asd62` (`person_id`),
  CONSTRAINT `FK5p0ygau9n2f0r76j7e27asd62` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKpdsa49x1g7eti8px3iiebefe5` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_person`
--

LOCK TABLES `expenses_person` WRITE;
/*!40000 ALTER TABLE `expenses_person` DISABLE KEYS */;
INSERT INTO `expenses_person` VALUES (1,'2023-06-07 21:46:16',1,1),(2,'2023-06-07 21:46:20',2,2),(3,'2023-06-07 21:46:23',3,3),(4,'2023-06-07 21:46:25',4,4),(5,'2023-06-07 21:47:52',4,5),(6,'2023-06-07 21:47:57',5,5);
/*!40000 ALTER TABLE `expenses_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_person_seq`
--

DROP TABLE IF EXISTS `expenses_person_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_person_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_person_seq`
--

LOCK TABLES `expenses_person_seq` WRITE;
/*!40000 ALTER TABLE `expenses_person_seq` DISABLE KEYS */;
INSERT INTO `expenses_person_seq` VALUES (7);
/*!40000 ALTER TABLE `expenses_person_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_reminder`
--

DROP TABLE IF EXISTS `expenses_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_reminder` (
  `expenses_reminder_id` bigint NOT NULL,
  `expenses_date` datetime DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expenses_reminder_id`),
  KEY `FK94ie89hyo409sqroj0o3xln2g` (`expenses_id`),
  KEY `FKi9uynegaxi1uppcwyvxwxyytv` (`reminder_id`),
  CONSTRAINT `FK94ie89hyo409sqroj0o3xln2g` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`),
  CONSTRAINT `FKi9uynegaxi1uppcwyvxwxyytv` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_reminder`
--

LOCK TABLES `expenses_reminder` WRITE;
/*!40000 ALTER TABLE `expenses_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_reminder_seq`
--

DROP TABLE IF EXISTS `expenses_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_reminder_seq`
--

LOCK TABLES `expenses_reminder_seq` WRITE;
/*!40000 ALTER TABLE `expenses_reminder_seq` DISABLE KEYS */;
INSERT INTO `expenses_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_seq`
--

DROP TABLE IF EXISTS `expenses_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_seq`
--

LOCK TABLES `expenses_seq` WRITE;
/*!40000 ALTER TABLE `expenses_seq` DISABLE KEYS */;
INSERT INTO `expenses_seq` VALUES (6);
/*!40000 ALTER TABLE `expenses_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_tag`
--

DROP TABLE IF EXISTS `expenses_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_tag` (
  `expenses_tag_id` bigint NOT NULL,
  `expenses_date` datetime DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expenses_tag_id`),
  KEY `FKrii45iyy9vha5oo0bcc62bfj0` (`expenses_id`),
  KEY `FKbyka2gndg4cbvssh87r942tb` (`tag_id`),
  CONSTRAINT `FKbyka2gndg4cbvssh87r942tb` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKrii45iyy9vha5oo0bcc62bfj0` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_tag`
--

LOCK TABLES `expenses_tag` WRITE;
/*!40000 ALTER TABLE `expenses_tag` DISABLE KEYS */;
INSERT INTO `expenses_tag` VALUES (1,'2023-06-07 21:25:14',1,1),(2,'2023-06-07 21:25:17',2,2),(3,'2023-06-07 21:25:20',3,3),(4,'2023-06-07 21:25:24',4,4),(5,'2023-06-07 21:25:26',4,5),(6,'2023-06-07 21:25:28',5,5);
/*!40000 ALTER TABLE `expenses_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_tag_seq`
--

DROP TABLE IF EXISTS `expenses_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_tag_seq`
--

LOCK TABLES `expenses_tag_seq` WRITE;
/*!40000 ALTER TABLE `expenses_tag_seq` DISABLE KEYS */;
INSERT INTO `expenses_tag_seq` VALUES (7);
/*!40000 ALTER TABLE `expenses_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_tasks`
--

DROP TABLE IF EXISTS `expenses_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_tasks` (
  `expenses_tasks_id` bigint NOT NULL,
  `expenses_date` datetime DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expenses_tasks_id`),
  KEY `FKrylbu3i83pe3ykmv5mi6ru6q9` (`expenses_id`),
  KEY `FK15eur5ehm2ne3yjmv55emof5l` (`tasks_id`),
  CONSTRAINT `FK15eur5ehm2ne3yjmv55emof5l` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKrylbu3i83pe3ykmv5mi6ru6q9` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_tasks`
--

LOCK TABLES `expenses_tasks` WRITE;
/*!40000 ALTER TABLE `expenses_tasks` DISABLE KEYS */;
INSERT INTO `expenses_tasks` VALUES (1,'2023-06-07 21:27:59',1,1),(2,'2023-06-07 21:28:02',2,2),(3,'2023-06-07 21:28:05',3,3),(4,'2023-06-07 21:28:07',4,4),(5,'2023-06-07 21:28:09',4,5),(6,'2023-06-07 21:28:13',5,5);
/*!40000 ALTER TABLE `expenses_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_tasks_seq`
--

DROP TABLE IF EXISTS `expenses_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_tasks_seq`
--

LOCK TABLES `expenses_tasks_seq` WRITE;
/*!40000 ALTER TABLE `expenses_tasks_seq` DISABLE KEYS */;
INSERT INTO `expenses_tasks_seq` VALUES (7);
/*!40000 ALTER TABLE `expenses_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_topic`
--

DROP TABLE IF EXISTS `expenses_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_topic` (
  `expenses_topic_id` bigint NOT NULL,
  `expenses_date` datetime DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expenses_topic_id`),
  KEY `FKput436053blpuejod98b6mvni` (`expenses_id`),
  KEY `FKduiyvgx7111i5mj8c6sdad8u3` (`topic_id`),
  CONSTRAINT `FKduiyvgx7111i5mj8c6sdad8u3` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKput436053blpuejod98b6mvni` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_topic`
--

LOCK TABLES `expenses_topic` WRITE;
/*!40000 ALTER TABLE `expenses_topic` DISABLE KEYS */;
INSERT INTO `expenses_topic` VALUES (1,'2023-06-07 21:27:15',1,1),(2,'2023-06-07 21:27:19',2,2),(3,'2023-06-07 21:27:24',3,3),(4,'2023-06-07 21:27:26',4,4),(5,'2023-06-07 21:27:28',4,5),(6,'2023-06-07 21:27:30',5,5);
/*!40000 ALTER TABLE `expenses_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_topic_seq`
--

DROP TABLE IF EXISTS `expenses_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_topic_seq`
--

LOCK TABLES `expenses_topic_seq` WRITE;
/*!40000 ALTER TABLE `expenses_topic_seq` DISABLE KEYS */;
INSERT INTO `expenses_topic_seq` VALUES (7);
/*!40000 ALTER TABLE `expenses_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_user`
--

DROP TABLE IF EXISTS `expenses_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_user` (
  `expenses_user_id` bigint NOT NULL,
  `expenses_date` datetime DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`expenses_user_id`),
  KEY `FK18uwr764t7fq6f7ityfkug95d` (`expenses_id`),
  KEY `FKdhwq4rn4eh3n51hfj7rjurv8c` (`user_id`),
  CONSTRAINT `FK18uwr764t7fq6f7ityfkug95d` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`),
  CONSTRAINT `FKdhwq4rn4eh3n51hfj7rjurv8c` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_user`
--

LOCK TABLES `expenses_user` WRITE;
/*!40000 ALTER TABLE `expenses_user` DISABLE KEYS */;
INSERT INTO `expenses_user` VALUES (1,'2023-06-04 22:20:08',1,1),(2,'2023-06-04 22:20:20',2,1),(3,'2023-06-04 22:20:26',3,1),(4,'2023-06-04 22:20:33',4,1),(5,'2023-06-04 22:20:38',5,1),(6,'2023-06-07 21:24:07',1,2),(7,'2023-06-07 21:24:35',2,2);
/*!40000 ALTER TABLE `expenses_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses_user_seq`
--

DROP TABLE IF EXISTS `expenses_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses_user_seq`
--

LOCK TABLES `expenses_user_seq` WRITE;
/*!40000 ALTER TABLE `expenses_user_seq` DISABLE KEYS */;
INSERT INTO `expenses_user_seq` VALUES (8);
/*!40000 ALTER TABLE `expenses_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link`
--

DROP TABLE IF EXISTS `link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link` (
  `link_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`link_id`),
  KEY `FKg1mwmfya7kqb7ddxw0fdkse8t` (`user_id`),
  CONSTRAINT `FKg1mwmfya7kqb7ddxw0fdkse8t` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link`
--

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
INSERT INTO `link` VALUES (1,'2023-06-14 21:38:35','Link1',1,'ref1'),(2,'2023-06-14 21:38:42','Link2',1,'ref2'),(3,'2023-06-14 21:38:46','Link3',1,'ref3'),(4,'2023-06-14 21:38:52','Link33',1,'ref33'),(5,'2023-06-14 21:38:59','Link333',1,'ref333');
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_history_seq`
--

DROP TABLE IF EXISTS `link_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_history_seq`
--

LOCK TABLES `link_history_seq` WRITE;
/*!40000 ALTER TABLE `link_history_seq` DISABLE KEYS */;
INSERT INTO `link_history_seq` VALUES (1);
/*!40000 ALTER TABLE `link_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_reminder`
--

DROP TABLE IF EXISTS `link_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_reminder` (
  `link_reminder_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `link_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`link_reminder_id`),
  KEY `FKk21opse20ndgcabjxve9lou1v` (`link_id`),
  KEY `FKj8fekkieeo9qr6y6c0yal797r` (`reminder_id`),
  CONSTRAINT `FKj8fekkieeo9qr6y6c0yal797r` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKk21opse20ndgcabjxve9lou1v` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_reminder`
--

LOCK TABLES `link_reminder` WRITE;
/*!40000 ALTER TABLE `link_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `link_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_reminder_seq`
--

DROP TABLE IF EXISTS `link_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_reminder_seq`
--

LOCK TABLES `link_reminder_seq` WRITE;
/*!40000 ALTER TABLE `link_reminder_seq` DISABLE KEYS */;
INSERT INTO `link_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `link_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_seq`
--

DROP TABLE IF EXISTS `link_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_seq`
--

LOCK TABLES `link_seq` WRITE;
/*!40000 ALTER TABLE `link_seq` DISABLE KEYS */;
INSERT INTO `link_seq` VALUES (6);
/*!40000 ALTER TABLE `link_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_tag`
--

DROP TABLE IF EXISTS `link_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_tag` (
  `link_tag_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `link_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`link_tag_id`),
  KEY `FKf2ve6jt9sgfd91og9k5kdbwpf` (`link_id`),
  KEY `FK3tmjo517hu3ojp2vs6upgatoi` (`tag_id`),
  CONSTRAINT `FK3tmjo517hu3ojp2vs6upgatoi` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKf2ve6jt9sgfd91og9k5kdbwpf` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_tag`
--

LOCK TABLES `link_tag` WRITE;
/*!40000 ALTER TABLE `link_tag` DISABLE KEYS */;
INSERT INTO `link_tag` VALUES (1,'2023-06-18 11:31:54',1,1),(2,'2023-06-18 11:31:57',2,2),(3,'2023-06-18 11:31:59',3,3),(4,'2023-06-18 11:32:02',4,4),(5,'2023-06-18 11:32:04',4,5),(6,'2023-06-18 11:32:06',5,5);
/*!40000 ALTER TABLE `link_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_tag_seq`
--

DROP TABLE IF EXISTS `link_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_tag_seq`
--

LOCK TABLES `link_tag_seq` WRITE;
/*!40000 ALTER TABLE `link_tag_seq` DISABLE KEYS */;
INSERT INTO `link_tag_seq` VALUES (7);
/*!40000 ALTER TABLE `link_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_tasks`
--

DROP TABLE IF EXISTS `link_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_tasks` (
  `link_tasks_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `link_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`link_tasks_id`),
  KEY `FK4y0y8yh3bgay54lekcmn6jvlf` (`link_id`),
  KEY `FK24945qawqf90exitj98b7taxa` (`tasks_id`),
  CONSTRAINT `FK24945qawqf90exitj98b7taxa` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FK4y0y8yh3bgay54lekcmn6jvlf` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_tasks`
--

LOCK TABLES `link_tasks` WRITE;
/*!40000 ALTER TABLE `link_tasks` DISABLE KEYS */;
INSERT INTO `link_tasks` VALUES (1,'2023-06-14 21:46:13',1,1),(2,'2023-06-14 21:46:15',2,2),(3,'2023-06-14 21:46:20',3,3),(4,'2023-06-14 21:46:23',4,4),(5,'2023-06-14 21:46:25',4,5),(6,'2023-06-14 21:46:27',5,5);
/*!40000 ALTER TABLE `link_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_tasks_seq`
--

DROP TABLE IF EXISTS `link_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_tasks_seq`
--

LOCK TABLES `link_tasks_seq` WRITE;
/*!40000 ALTER TABLE `link_tasks_seq` DISABLE KEYS */;
INSERT INTO `link_tasks_seq` VALUES (7);
/*!40000 ALTER TABLE `link_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_topic`
--

DROP TABLE IF EXISTS `link_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_topic` (
  `link_topic_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `link_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`link_topic_id`),
  KEY `FKepa9tddt08uea6b6or4a22cf5` (`link_id`),
  KEY `FKo9do36skuq1i9gqr3e1878v9v` (`topic_id`),
  CONSTRAINT `FKepa9tddt08uea6b6or4a22cf5` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`),
  CONSTRAINT `FKo9do36skuq1i9gqr3e1878v9v` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_topic`
--

LOCK TABLES `link_topic` WRITE;
/*!40000 ALTER TABLE `link_topic` DISABLE KEYS */;
INSERT INTO `link_topic` VALUES (1,'2023-06-14 21:45:24',1,1),(2,'2023-06-14 21:45:27',2,2),(3,'2023-06-14 21:45:29',3,3),(4,'2023-06-14 21:45:32',4,4),(5,'2023-06-14 21:45:33',4,5),(6,'2023-06-14 21:45:35',5,5);
/*!40000 ALTER TABLE `link_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_topic_seq`
--

DROP TABLE IF EXISTS `link_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_topic_seq`
--

LOCK TABLES `link_topic_seq` WRITE;
/*!40000 ALTER TABLE `link_topic_seq` DISABLE KEYS */;
INSERT INTO `link_topic_seq` VALUES (7);
/*!40000 ALTER TABLE `link_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_user`
--

DROP TABLE IF EXISTS `link_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_user` (
  `link_user_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `link_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`link_user_id`),
  KEY `FKgcm3r03p35te4l04rs6x5v4nq` (`link_id`),
  KEY `FKr1bxpeht2b54vp2q0n46nyl10` (`user_id`),
  CONSTRAINT `FKgcm3r03p35te4l04rs6x5v4nq` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`),
  CONSTRAINT `FKr1bxpeht2b54vp2q0n46nyl10` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_user`
--

LOCK TABLES `link_user` WRITE;
/*!40000 ALTER TABLE `link_user` DISABLE KEYS */;
INSERT INTO `link_user` VALUES (1,'2023-06-14 21:38:35',1,1),(2,'2023-06-14 21:38:42',2,1),(3,'2023-06-14 21:38:46',3,1),(4,'2023-06-14 21:38:52',4,1),(5,'2023-06-14 21:38:59',5,1),(6,'2023-06-14 21:42:52',1,2),(7,'2023-06-14 21:42:54',1,3),(8,'2023-06-14 21:43:08',2,3),(9,'2023-06-14 21:43:12',2,2),(10,'2023-06-14 21:43:21',3,2),(11,'2023-06-14 21:43:23',3,3);
/*!40000 ALTER TABLE `link_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_user_seq`
--

DROP TABLE IF EXISTS `link_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_user_seq`
--

LOCK TABLES `link_user_seq` WRITE;
/*!40000 ALTER TABLE `link_user_seq` DISABLE KEYS */;
INSERT INTO `link_user_seq` VALUES (12);
/*!40000 ALTER TABLE `link_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note` (
  `note_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`note_id`),
  KEY `FKmoddtnuw3yy6ct34xnw6u0boh` (`user_id`),
  CONSTRAINT `FKmoddtnuw3yy6ct34xnw6u0boh` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (1,'2023-06-18 02:50:07','note1','type1',1),(2,'2023-06-18 02:55:21','note2','type2',1),(3,'2023-06-18 02:55:24','note3','type3',1),(4,'2023-06-18 02:55:30','note33','type33',1),(5,'2023-06-18 02:55:33','note333','type333',1);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_history`
--

DROP TABLE IF EXISTS `note_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_history` (
  `note_history_id` bigint NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `note_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`note_history_id`),
  KEY `FKbo3561pvbo64le197ukumr03s` (`note_id`),
  KEY `FK58dterhyxq1rpph843jkur0ja` (`user_id`),
  CONSTRAINT `FK58dterhyxq1rpph843jkur0ja` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKbo3561pvbo64le197ukumr03s` FOREIGN KEY (`note_id`) REFERENCES `note` (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_history`
--

LOCK TABLES `note_history` WRITE;
/*!40000 ALTER TABLE `note_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `note_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_history_seq`
--

DROP TABLE IF EXISTS `note_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_history_seq`
--

LOCK TABLES `note_history_seq` WRITE;
/*!40000 ALTER TABLE `note_history_seq` DISABLE KEYS */;
INSERT INTO `note_history_seq` VALUES (1);
/*!40000 ALTER TABLE `note_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_reminder`
--

DROP TABLE IF EXISTS `note_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_reminder` (
  `note_reminder_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `note_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`note_reminder_id`),
  KEY `FKlbh3ecpfoj6g9c5gcjm9wdks0` (`note_id`),
  KEY `FKlb0jijmly7xv5u3yjta1qqtwh` (`reminder_id`),
  CONSTRAINT `FKlb0jijmly7xv5u3yjta1qqtwh` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKlbh3ecpfoj6g9c5gcjm9wdks0` FOREIGN KEY (`note_id`) REFERENCES `note` (`note_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_reminder`
--

LOCK TABLES `note_reminder` WRITE;
/*!40000 ALTER TABLE `note_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `note_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_reminder_seq`
--

DROP TABLE IF EXISTS `note_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_reminder_seq`
--

LOCK TABLES `note_reminder_seq` WRITE;
/*!40000 ALTER TABLE `note_reminder_seq` DISABLE KEYS */;
INSERT INTO `note_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `note_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_seq`
--

DROP TABLE IF EXISTS `note_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_seq`
--

LOCK TABLES `note_seq` WRITE;
/*!40000 ALTER TABLE `note_seq` DISABLE KEYS */;
INSERT INTO `note_seq` VALUES (7);
/*!40000 ALTER TABLE `note_seq` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `note_tag` VALUES (1,'2023-06-18 02:56:11',1,1),(2,'2023-06-18 02:56:17',2,2),(3,'2023-06-18 02:56:19',3,3),(4,'2023-06-18 02:56:21',4,4),(5,'2023-06-18 02:56:24',4,5),(6,'2023-06-18 02:56:26',5,5),(7,'2023-06-18 02:56:29',5,6);
/*!40000 ALTER TABLE `note_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_tag_seq`
--

DROP TABLE IF EXISTS `note_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_tag_seq`
--

LOCK TABLES `note_tag_seq` WRITE;
/*!40000 ALTER TABLE `note_tag_seq` DISABLE KEYS */;
INSERT INTO `note_tag_seq` VALUES (10);
/*!40000 ALTER TABLE `note_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_user`
--

DROP TABLE IF EXISTS `note_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_user` (
  `note_user_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `note_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`note_user_id`),
  KEY `FK9g6sg7dfjsrua1tum0sam9wu8` (`note_id`),
  KEY `FKf6g6i302yjqianvtmgylt7ut2` (`user_id`),
  CONSTRAINT `FK9g6sg7dfjsrua1tum0sam9wu8` FOREIGN KEY (`note_id`) REFERENCES `note` (`note_id`),
  CONSTRAINT `FKf6g6i302yjqianvtmgylt7ut2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_user`
--

LOCK TABLES `note_user` WRITE;
/*!40000 ALTER TABLE `note_user` DISABLE KEYS */;
INSERT INTO `note_user` VALUES (1,'2023-06-18 02:50:07',1,1),(2,'2023-06-18 02:55:21',2,1),(3,'2023-06-18 02:55:24',3,1),(4,'2023-06-18 02:55:30',4,1),(5,'2023-06-18 02:55:33',5,1),(6,'2023-06-18 02:58:09',1,2),(7,'2023-06-18 02:58:13',1,3),(8,'2023-06-18 02:58:14',1,4),(9,'2023-06-18 02:58:16',1,5),(10,'2023-06-18 02:58:20',2,5),(11,'2023-06-18 02:58:22',2,3),(12,'2023-06-18 02:58:30',2,2),(13,'2023-06-18 02:58:35',3,2),(14,'2023-06-18 02:58:44',3,3),(15,'2023-06-18 02:58:45',3,4),(16,'2023-06-18 02:58:47',3,5);
/*!40000 ALTER TABLE `note_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note_user_seq`
--

DROP TABLE IF EXISTS `note_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note_user_seq`
--

LOCK TABLES `note_user_seq` WRITE;
/*!40000 ALTER TABLE `note_user_seq` DISABLE KEYS */;
INSERT INTO `note_user_seq` VALUES (20);
/*!40000 ALTER TABLE `note_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `person_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `FK2is3ph79mqcwtkd724syhtjbi` (`user_id`),
  CONSTRAINT `FK2is3ph79mqcwtkd724syhtjbi` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'2023-06-07 21:35:22','NN1 description1',1,'description1','firstName1','firstName1 middleName1 lastName1','lastName1','middleName1','NN1'),(2,'2023-06-07 21:37:25','NN2 description2',1,'description2','firstName2','firstName2 middleName2 lastName2','lastName2','middleName2','NN2'),(3,'2023-06-07 21:38:00','NN3 description3',1,'description3','firstName3','firstName3 middleName3 lastName3','lastName3','middleName3','NN3'),(4,'2023-06-07 21:38:06','NN33 description33',1,'description33','firstName33','firstName33 middleName33 lastName33','lastName33','middleName33','NN33'),(5,'2023-06-07 21:45:37','NN333 description333',1,'description333','firstName333','firstName333 middleName333 lastName333','lastName333','middleName333','NN333');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_address`
--

DROP TABLE IF EXISTS `person_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_address` (
  `person_address_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_address_id`),
  KEY `FKcyc1krsxqelkm4uwh65avij23` (`address_id`),
  KEY `FKnndfs0btabect8upo03uwgfxt` (`person_id`),
  CONSTRAINT `FKcyc1krsxqelkm4uwh65avij23` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `FKnndfs0btabect8upo03uwgfxt` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_address`
--

LOCK TABLES `person_address` WRITE;
/*!40000 ALTER TABLE `person_address` DISABLE KEYS */;
INSERT INTO `person_address` VALUES (1,'2023-06-14 13:45:47',1,1),(2,'2023-06-14 13:45:50',2,2),(3,'2023-06-14 13:45:52',3,3),(4,'2023-06-14 13:45:54',4,4),(5,'2023-06-14 13:45:56',4,5),(6,'2023-06-14 13:45:58',5,5);
/*!40000 ALTER TABLE `person_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_address_seq`
--

DROP TABLE IF EXISTS `person_address_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_address_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_address_seq`
--

LOCK TABLES `person_address_seq` WRITE;
/*!40000 ALTER TABLE `person_address_seq` DISABLE KEYS */;
INSERT INTO `person_address_seq` VALUES (7);
/*!40000 ALTER TABLE `person_address_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_dates`
--

DROP TABLE IF EXISTS `person_dates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_dates` (
  `person_dates_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `dates_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_dates_id`),
  KEY `FKi2aks8htqc1tearwr1q9eg2qy` (`person_id`),
  KEY `FK8hxdpkwmh2ngb8g8xmsvf35rb` (`dates_id`),
  CONSTRAINT `FK8hxdpkwmh2ngb8g8xmsvf35rb` FOREIGN KEY (`dates_id`) REFERENCES `dates` (`dates_id`),
  CONSTRAINT `FKi2aks8htqc1tearwr1q9eg2qy` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_dates`
--

LOCK TABLES `person_dates` WRITE;
/*!40000 ALTER TABLE `person_dates` DISABLE KEYS */;
INSERT INTO `person_dates` VALUES (1,'2023-06-14 13:55:05',1,1),(2,'2023-06-14 13:56:06',2,2),(3,'2023-06-14 13:56:09',3,3),(4,'2023-06-14 13:56:11',4,4),(5,'2023-06-14 13:56:14',5,4),(6,'2023-06-14 13:56:15',5,5);
/*!40000 ALTER TABLE `person_dates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_dates_seq`
--

DROP TABLE IF EXISTS `person_dates_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_dates_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_dates_seq`
--

LOCK TABLES `person_dates_seq` WRITE;
/*!40000 ALTER TABLE `person_dates_seq` DISABLE KEYS */;
INSERT INTO `person_dates_seq` VALUES (7);
/*!40000 ALTER TABLE `person_dates_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_document`
--

DROP TABLE IF EXISTS `person_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_document` (
  `person_document_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `document_id` bigint DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_document_id`),
  KEY `FKptuapkry846gt9sk1393hho5u` (`document_id`),
  KEY `FKrh659u95lyf4kdjnwrg9fyrls` (`person_id`),
  CONSTRAINT `FKptuapkry846gt9sk1393hho5u` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`),
  CONSTRAINT `FKrh659u95lyf4kdjnwrg9fyrls` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_document`
--

LOCK TABLES `person_document` WRITE;
/*!40000 ALTER TABLE `person_document` DISABLE KEYS */;
INSERT INTO `person_document` VALUES (1,'2023-06-14 13:45:19',1,1),(2,'2023-06-14 13:45:24',2,2),(3,'2023-06-14 13:45:26',3,3),(4,'2023-06-14 13:45:28',4,4),(5,'2023-06-14 13:45:30',4,5),(6,'2023-06-14 13:45:32',5,5);
/*!40000 ALTER TABLE `person_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_document_seq`
--

DROP TABLE IF EXISTS `person_document_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_document_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_document_seq`
--

LOCK TABLES `person_document_seq` WRITE;
/*!40000 ALTER TABLE `person_document_seq` DISABLE KEYS */;
INSERT INTO `person_document_seq` VALUES (7);
/*!40000 ALTER TABLE `person_document_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_email`
--

DROP TABLE IF EXISTS `person_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_email` (
  `person_email_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `email_id` bigint DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_email_id`),
  KEY `FKjtp4rmfgwbcyfc1ty4wri8ux8` (`email_id`),
  KEY `FKbp00srtck9ij39xbxjpij47mu` (`person_id`),
  CONSTRAINT `FKbp00srtck9ij39xbxjpij47mu` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKjtp4rmfgwbcyfc1ty4wri8ux8` FOREIGN KEY (`email_id`) REFERENCES `email` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_email`
--

LOCK TABLES `person_email` WRITE;
/*!40000 ALTER TABLE `person_email` DISABLE KEYS */;
INSERT INTO `person_email` VALUES (1,'2023-06-14 13:49:29',1,1),(2,'2023-06-14 13:49:33',2,2),(3,'2023-06-14 13:49:36',3,3),(4,'2023-06-14 13:49:38',4,4),(5,'2023-06-14 13:49:40',4,5),(6,'2023-06-14 13:49:42',5,5);
/*!40000 ALTER TABLE `person_email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_email_seq`
--

DROP TABLE IF EXISTS `person_email_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_email_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_email_seq`
--

LOCK TABLES `person_email_seq` WRITE;
/*!40000 ALTER TABLE `person_email_seq` DISABLE KEYS */;
INSERT INTO `person_email_seq` VALUES (7);
/*!40000 ALTER TABLE `person_email_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_history_seq`
--

DROP TABLE IF EXISTS `person_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_history_seq`
--

LOCK TABLES `person_history_seq` WRITE;
/*!40000 ALTER TABLE `person_history_seq` DISABLE KEYS */;
INSERT INTO `person_history_seq` VALUES (1);
/*!40000 ALTER TABLE `person_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_person`
--

DROP TABLE IF EXISTS `person_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_person` (
  `person_person_id` bigint NOT NULL,
  `linked_date` datetime DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `related_person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_person_id`),
  KEY `FKb0usqkpsjgv42fmsu4e0h2gyl` (`person_id`),
  KEY `FKq20e12tshirdpusb6bt4dsqyj` (`related_person_id`),
  CONSTRAINT `FKb0usqkpsjgv42fmsu4e0h2gyl` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKq20e12tshirdpusb6bt4dsqyj` FOREIGN KEY (`related_person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_person`
--

LOCK TABLES `person_person` WRITE;
/*!40000 ALTER TABLE `person_person` DISABLE KEYS */;
INSERT INTO `person_person` VALUES (1,'2023-06-14 13:56:49',1,1),(2,'2023-06-14 13:56:50',1,2),(3,'2023-06-14 13:56:52',1,3),(4,'2023-06-14 13:56:54',1,4),(5,'2023-06-14 13:56:57',1,5),(6,'2023-06-14 13:56:58',2,5),(7,'2023-06-14 13:57:13',2,4),(8,'2023-06-14 13:57:15',2,3),(9,'2023-06-14 13:57:18',2,1),(10,'2023-06-14 13:57:20',3,1),(11,'2023-06-14 13:57:25',3,2),(12,'2023-06-14 13:57:27',3,4),(13,'2023-06-14 13:57:29',3,5),(14,'2023-06-14 13:57:34',4,5),(15,'2023-06-14 13:57:38',4,3),(16,'2023-06-14 13:57:39',4,2),(17,'2023-06-14 13:57:41',4,1),(18,'2023-06-14 13:57:45',5,1),(19,'2023-06-14 13:57:47',5,2),(20,'2023-06-14 13:57:49',5,3),(21,'2023-06-14 13:57:50',5,4);
/*!40000 ALTER TABLE `person_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_person_seq`
--

DROP TABLE IF EXISTS `person_person_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_person_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_person_seq`
--

LOCK TABLES `person_person_seq` WRITE;
/*!40000 ALTER TABLE `person_person_seq` DISABLE KEYS */;
INSERT INTO `person_person_seq` VALUES (22);
/*!40000 ALTER TABLE `person_person_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_phone_number`
--

DROP TABLE IF EXISTS `person_phone_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_phone_number` (
  `person_phone_number_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `phone_number_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_phone_number_id`),
  KEY `FKlcjjy0f1sqtoc39ssn8nsbxj2` (`person_id`),
  KEY `FK4ktqsro57aleiggns7xvprcux` (`phone_number_id`),
  CONSTRAINT `FK4ktqsro57aleiggns7xvprcux` FOREIGN KEY (`phone_number_id`) REFERENCES `phone_number` (`phone_number_id`),
  CONSTRAINT `FKlcjjy0f1sqtoc39ssn8nsbxj2` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_phone_number`
--

LOCK TABLES `person_phone_number` WRITE;
/*!40000 ALTER TABLE `person_phone_number` DISABLE KEYS */;
INSERT INTO `person_phone_number` VALUES (1,'2023-06-14 13:50:02',1,1),(2,'2023-06-14 13:50:06',2,2),(3,'2023-06-14 13:50:08',3,3),(4,'2023-06-14 13:50:11',4,4),(5,'2023-06-14 13:50:13',5,5);
/*!40000 ALTER TABLE `person_phone_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_phone_number_seq`
--

DROP TABLE IF EXISTS `person_phone_number_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_phone_number_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_phone_number_seq`
--

LOCK TABLES `person_phone_number_seq` WRITE;
/*!40000 ALTER TABLE `person_phone_number_seq` DISABLE KEYS */;
INSERT INTO `person_phone_number_seq` VALUES (6);
/*!40000 ALTER TABLE `person_phone_number_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_reminder`
--

DROP TABLE IF EXISTS `person_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_reminder` (
  `person_reminder_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_reminder_id`),
  KEY `FK603ocp48mivht0ni3u45yurs1` (`person_id`),
  KEY `FK3o02iem7ydvx296ntr9w024a4` (`reminder_id`),
  CONSTRAINT `FK3o02iem7ydvx296ntr9w024a4` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FK603ocp48mivht0ni3u45yurs1` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_reminder`
--

LOCK TABLES `person_reminder` WRITE;
/*!40000 ALTER TABLE `person_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_reminder_seq`
--

DROP TABLE IF EXISTS `person_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_reminder_seq`
--

LOCK TABLES `person_reminder_seq` WRITE;
/*!40000 ALTER TABLE `person_reminder_seq` DISABLE KEYS */;
INSERT INTO `person_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `person_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_seq`
--

DROP TABLE IF EXISTS `person_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_seq`
--

LOCK TABLES `person_seq` WRITE;
/*!40000 ALTER TABLE `person_seq` DISABLE KEYS */;
INSERT INTO `person_seq` VALUES (7);
/*!40000 ALTER TABLE `person_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_tag`
--

DROP TABLE IF EXISTS `person_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_tag` (
  `person_tag_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_tag_id`),
  KEY `FKe24gvn9xgxnj94kk7wpu90jm4` (`person_id`),
  KEY `FKnd43c8syaxn4vam4jm4y6o3xr` (`tag_id`),
  CONSTRAINT `FKe24gvn9xgxnj94kk7wpu90jm4` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKnd43c8syaxn4vam4jm4y6o3xr` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_tag`
--

LOCK TABLES `person_tag` WRITE;
/*!40000 ALTER TABLE `person_tag` DISABLE KEYS */;
INSERT INTO `person_tag` VALUES (1,'2023-06-14 14:41:59',1,1),(2,'2023-06-14 14:42:04',2,2),(3,'2023-06-14 14:42:07',3,3),(4,'2023-06-14 14:42:09',4,4),(5,'2023-06-14 14:42:13',4,5),(6,'2023-06-14 14:42:14',5,5);
/*!40000 ALTER TABLE `person_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_tag_seq`
--

DROP TABLE IF EXISTS `person_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_tag_seq`
--

LOCK TABLES `person_tag_seq` WRITE;
/*!40000 ALTER TABLE `person_tag_seq` DISABLE KEYS */;
INSERT INTO `person_tag_seq` VALUES (7);
/*!40000 ALTER TABLE `person_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_tasks`
--

DROP TABLE IF EXISTS `person_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_tasks` (
  `person_tasks_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_tasks_id`),
  KEY `FKc4lj1d53c5u3velg7ofh1ps89` (`person_id`),
  KEY `FKe3y3sgoa661qbwk2hmi9j5gsn` (`tasks_id`),
  CONSTRAINT `FKc4lj1d53c5u3velg7ofh1ps89` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKe3y3sgoa661qbwk2hmi9j5gsn` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_tasks`
--

LOCK TABLES `person_tasks` WRITE;
/*!40000 ALTER TABLE `person_tasks` DISABLE KEYS */;
INSERT INTO `person_tasks` VALUES (1,'2023-06-14 14:48:16',1,1),(2,'2023-06-14 14:48:18',2,2),(3,'2023-06-14 14:48:20',3,3),(4,'2023-06-14 14:48:27',4,4),(5,'2023-06-14 14:48:31',4,5),(6,'2023-06-14 14:48:33',5,5);
/*!40000 ALTER TABLE `person_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_tasks_seq`
--

DROP TABLE IF EXISTS `person_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_tasks_seq`
--

LOCK TABLES `person_tasks_seq` WRITE;
/*!40000 ALTER TABLE `person_tasks_seq` DISABLE KEYS */;
INSERT INTO `person_tasks_seq` VALUES (7);
/*!40000 ALTER TABLE `person_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_topic`
--

DROP TABLE IF EXISTS `person_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_topic` (
  `person_topic_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_topic_id`),
  KEY `FKochqjp6mt8kl6k1qe13v5l7wt` (`person_id`),
  KEY `FKsfw6o9fhmqyq8lnjfnatesaij` (`topic_id`),
  CONSTRAINT `FKochqjp6mt8kl6k1qe13v5l7wt` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKsfw6o9fhmqyq8lnjfnatesaij` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_topic`
--

LOCK TABLES `person_topic` WRITE;
/*!40000 ALTER TABLE `person_topic` DISABLE KEYS */;
INSERT INTO `person_topic` VALUES (1,'2023-06-14 14:47:34',1,1),(2,'2023-06-14 14:47:38',2,2),(3,'2023-06-14 14:47:40',3,3),(4,'2023-06-14 14:47:42',4,4),(5,'2023-06-14 14:47:44',4,5),(6,'2023-06-14 14:47:46',5,5);
/*!40000 ALTER TABLE `person_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_topic_seq`
--

DROP TABLE IF EXISTS `person_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_topic_seq`
--

LOCK TABLES `person_topic_seq` WRITE;
/*!40000 ALTER TABLE `person_topic_seq` DISABLE KEYS */;
INSERT INTO `person_topic_seq` VALUES (7);
/*!40000 ALTER TABLE `person_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_user`
--

DROP TABLE IF EXISTS `person_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_user` (
  `person_user_id` bigint NOT NULL,
  `person_date` datetime DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`person_user_id`),
  KEY `FK1v6tjhqqunb4nevhnpijuxtsk` (`person_id`),
  KEY `FK3tx7rnsdaw4ouf7fw9lor4wsb` (`user_id`),
  CONSTRAINT `FK1v6tjhqqunb4nevhnpijuxtsk` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FK3tx7rnsdaw4ouf7fw9lor4wsb` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_user`
--

LOCK TABLES `person_user` WRITE;
/*!40000 ALTER TABLE `person_user` DISABLE KEYS */;
INSERT INTO `person_user` VALUES (1,'2023-06-07 21:37:25',1,1),(2,'2023-06-07 21:38:00',2,1),(3,'2023-06-07 21:38:06',3,1),(4,'2023-06-07 21:38:10',4,1),(5,'2023-06-07 21:38:10',5,1);
/*!40000 ALTER TABLE `person_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_user_seq`
--

DROP TABLE IF EXISTS `person_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_user_seq`
--

LOCK TABLES `person_user_seq` WRITE;
/*!40000 ALTER TABLE `person_user_seq` DISABLE KEYS */;
INSERT INTO `person_user_seq` VALUES (6);
/*!40000 ALTER TABLE `person_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number`
--

DROP TABLE IF EXISTS `phone_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number` (
  `phone_number_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`phone_number_id`),
  KEY `FKb609grkur7fch5if2c0nrcujh` (`user_id`),
  CONSTRAINT `FKb609grkur7fch5if2c0nrcujh` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number`
--

LOCK TABLES `phone_number` WRITE;
/*!40000 ALTER TABLE `phone_number` DISABLE KEYS */;
INSERT INTO `phone_number` VALUES (1,'2023-06-14 13:27:55','1','pn1',1),(2,'2023-06-14 13:27:59','2','pn2',1),(3,'2023-06-14 13:28:02','3','pn3',1),(4,'2023-06-14 13:28:05','4','pn4',1),(5,'2023-06-14 13:28:08','5','pn5',1);
/*!40000 ALTER TABLE `phone_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_history_seq`
--

DROP TABLE IF EXISTS `phone_number_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_history_seq`
--

LOCK TABLES `phone_number_history_seq` WRITE;
/*!40000 ALTER TABLE `phone_number_history_seq` DISABLE KEYS */;
INSERT INTO `phone_number_history_seq` VALUES (1);
/*!40000 ALTER TABLE `phone_number_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_reminder`
--

DROP TABLE IF EXISTS `phone_number_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_reminder` (
  `phone_number_reminder_id` bigint NOT NULL,
  `phone_number_date` datetime DEFAULT NULL,
  `phone_number_id` bigint DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`phone_number_reminder_id`),
  KEY `FKmseu9ifiu3atf3085ycdyb9ae` (`phone_number_id`),
  KEY `FK6630ye44vi04fqycc2og0u4dr` (`reminder_id`),
  CONSTRAINT `FK6630ye44vi04fqycc2og0u4dr` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKmseu9ifiu3atf3085ycdyb9ae` FOREIGN KEY (`phone_number_id`) REFERENCES `phone_number` (`phone_number_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_reminder`
--

LOCK TABLES `phone_number_reminder` WRITE;
/*!40000 ALTER TABLE `phone_number_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone_number_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_reminder_seq`
--

DROP TABLE IF EXISTS `phone_number_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_reminder_seq`
--

LOCK TABLES `phone_number_reminder_seq` WRITE;
/*!40000 ALTER TABLE `phone_number_reminder_seq` DISABLE KEYS */;
INSERT INTO `phone_number_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `phone_number_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_seq`
--

DROP TABLE IF EXISTS `phone_number_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_seq`
--

LOCK TABLES `phone_number_seq` WRITE;
/*!40000 ALTER TABLE `phone_number_seq` DISABLE KEYS */;
INSERT INTO `phone_number_seq` VALUES (6);
/*!40000 ALTER TABLE `phone_number_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_tag`
--

DROP TABLE IF EXISTS `phone_number_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_tag` (
  `phone_number_tag_id` bigint NOT NULL,
  `phone_number_date` datetime DEFAULT NULL,
  `phone_number_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`phone_number_tag_id`),
  KEY `FKg2rittvb2bim0iqbi5ddmg9e1` (`phone_number_id`),
  KEY `FKr2loionvk0a950onhs4n62wub` (`tag_id`),
  CONSTRAINT `FKg2rittvb2bim0iqbi5ddmg9e1` FOREIGN KEY (`phone_number_id`) REFERENCES `phone_number` (`phone_number_id`),
  CONSTRAINT `FKr2loionvk0a950onhs4n62wub` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_tag`
--

LOCK TABLES `phone_number_tag` WRITE;
/*!40000 ALTER TABLE `phone_number_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone_number_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_tag_seq`
--

DROP TABLE IF EXISTS `phone_number_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_tag_seq`
--

LOCK TABLES `phone_number_tag_seq` WRITE;
/*!40000 ALTER TABLE `phone_number_tag_seq` DISABLE KEYS */;
INSERT INTO `phone_number_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `phone_number_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_tasks`
--

DROP TABLE IF EXISTS `phone_number_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_tasks` (
  `phone_number_tasks_id` bigint NOT NULL,
  `phone_number_date` datetime DEFAULT NULL,
  `phone_number_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`phone_number_tasks_id`),
  KEY `FK5wx5vpkfvoqil5k1gg2q3r11d` (`phone_number_id`),
  KEY `FK78xss3f2g696f8udlscjjrmge` (`tasks_id`),
  CONSTRAINT `FK5wx5vpkfvoqil5k1gg2q3r11d` FOREIGN KEY (`phone_number_id`) REFERENCES `phone_number` (`phone_number_id`),
  CONSTRAINT `FK78xss3f2g696f8udlscjjrmge` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_tasks`
--

LOCK TABLES `phone_number_tasks` WRITE;
/*!40000 ALTER TABLE `phone_number_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone_number_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_tasks_seq`
--

DROP TABLE IF EXISTS `phone_number_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_tasks_seq`
--

LOCK TABLES `phone_number_tasks_seq` WRITE;
/*!40000 ALTER TABLE `phone_number_tasks_seq` DISABLE KEYS */;
INSERT INTO `phone_number_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `phone_number_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_topic`
--

DROP TABLE IF EXISTS `phone_number_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_topic` (
  `phone_number_topic_id` bigint NOT NULL,
  `phone_number_date` datetime DEFAULT NULL,
  `phone_number_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`phone_number_topic_id`),
  KEY `FKjrv4we1e95hbyu84v4lbi5gk4` (`phone_number_id`),
  KEY `FKekdbck300qk73ldrvshkejx2a` (`topic_id`),
  CONSTRAINT `FKekdbck300qk73ldrvshkejx2a` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKjrv4we1e95hbyu84v4lbi5gk4` FOREIGN KEY (`phone_number_id`) REFERENCES `phone_number` (`phone_number_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_topic`
--

LOCK TABLES `phone_number_topic` WRITE;
/*!40000 ALTER TABLE `phone_number_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone_number_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_topic_seq`
--

DROP TABLE IF EXISTS `phone_number_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_topic_seq`
--

LOCK TABLES `phone_number_topic_seq` WRITE;
/*!40000 ALTER TABLE `phone_number_topic_seq` DISABLE KEYS */;
INSERT INTO `phone_number_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `phone_number_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_user`
--

DROP TABLE IF EXISTS `phone_number_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_user` (
  `phone_number_user_id` bigint NOT NULL,
  `phone_number_date` datetime DEFAULT NULL,
  `phone_number_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`phone_number_user_id`),
  KEY `FK8xoipfrodecpfvl7f3w029m4c` (`phone_number_id`),
  KEY `FKh3r5bqmu3faxit5b4c9vflnar` (`user_id`),
  CONSTRAINT `FK8xoipfrodecpfvl7f3w029m4c` FOREIGN KEY (`phone_number_id`) REFERENCES `phone_number` (`phone_number_id`),
  CONSTRAINT `FKh3r5bqmu3faxit5b4c9vflnar` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_user`
--

LOCK TABLES `phone_number_user` WRITE;
/*!40000 ALTER TABLE `phone_number_user` DISABLE KEYS */;
INSERT INTO `phone_number_user` VALUES (1,'2023-06-14 13:27:55',1,1),(2,'2023-06-14 13:27:59',2,1),(3,'2023-06-14 13:28:02',3,1),(4,'2023-06-14 13:28:05',4,1),(5,'2023-06-14 13:28:08',5,1);
/*!40000 ALTER TABLE `phone_number_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number_user_seq`
--

DROP TABLE IF EXISTS `phone_number_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone_number_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number_user_seq`
--

LOCK TABLES `phone_number_user_seq` WRITE;
/*!40000 ALTER TABLE `phone_number_user_seq` DISABLE KEYS */;
INSERT INTO `phone_number_user_seq` VALUES (6);
/*!40000 ALTER TABLE `phone_number_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder`
--

DROP TABLE IF EXISTS `reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder` (
  `reminder_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `reminder_date_time` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`reminder_id`),
  KEY `FKkv39lrjs52d15dqytgxl25bb1` (`user_id`),
  CONSTRAINT `FKkv39lrjs52d15dqytgxl25bb1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder`
--

LOCK TABLES `reminder` WRITE;
/*!40000 ALTER TABLE `reminder` DISABLE KEYS */;
INSERT INTO `reminder` VALUES (1,'2023-06-18 12:18:09','2023-06-18 12:20:21','reminder1',1),(2,'2023-06-18 12:20:00','2023-06-18 12:20:22','reminder2',1),(3,'2023-06-18 12:20:20','2023-06-18 12:20:23','reminder3',1),(4,'2023-06-18 12:20:45','2023-06-18 12:20:24','reminder33',1),(5,'2023-06-18 12:20:52','2023-06-18 12:20:25','reminder333',1),(6,'2023-06-18 13:06:41',NULL,'reminder6',1);
/*!40000 ALTER TABLE `reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_history`
--

DROP TABLE IF EXISTS `reminder_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_history` (
  `reminder_history_id` bigint NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`reminder_history_id`),
  KEY `FKqkdjq5phkseofstrk68ppyk0` (`reminder_id`),
  KEY `FKrsavg762uno38hgchob23g28y` (`user_id`),
  CONSTRAINT `FKqkdjq5phkseofstrk68ppyk0` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKrsavg762uno38hgchob23g28y` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_history`
--

LOCK TABLES `reminder_history` WRITE;
/*!40000 ALTER TABLE `reminder_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `reminder_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_history_seq`
--

DROP TABLE IF EXISTS `reminder_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_history_seq`
--

LOCK TABLES `reminder_history_seq` WRITE;
/*!40000 ALTER TABLE `reminder_history_seq` DISABLE KEYS */;
INSERT INTO `reminder_history_seq` VALUES (1);
/*!40000 ALTER TABLE `reminder_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_reminder`
--

DROP TABLE IF EXISTS `reminder_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_reminder` (
  `reminder_reminder_id` bigint NOT NULL,
  `linked_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `repeated_reminder_id` bigint DEFAULT NULL,
  PRIMARY KEY (`reminder_reminder_id`),
  KEY `FK2lxisns1svlmh4qvjcld8p1xv` (`reminder_id`),
  KEY `FKkhwrjjhrm8h5qnuvxdqdh976f` (`repeated_reminder_id`),
  CONSTRAINT `FK2lxisns1svlmh4qvjcld8p1xv` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKkhwrjjhrm8h5qnuvxdqdh976f` FOREIGN KEY (`repeated_reminder_id`) REFERENCES `reminder` (`reminder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_reminder`
--

LOCK TABLES `reminder_reminder` WRITE;
/*!40000 ALTER TABLE `reminder_reminder` DISABLE KEYS */;
INSERT INTO `reminder_reminder` VALUES (1,'2023-06-18 12:28:06',1,1),(2,'2023-06-18 12:28:11',2,2),(3,'2023-06-18 12:28:13',3,3),(4,'2023-06-18 12:28:15',4,4),(5,'2023-06-18 12:28:20',4,5),(6,'2023-06-18 12:28:22',5,5),(7,'2023-06-18 12:31:26',5,3),(8,'2023-06-18 13:07:59',6,5),(9,'2023-06-18 13:08:01',6,4),(10,'2023-06-18 13:18:41',6,3);
/*!40000 ALTER TABLE `reminder_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_reminder_seq`
--

DROP TABLE IF EXISTS `reminder_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_reminder_seq`
--

LOCK TABLES `reminder_reminder_seq` WRITE;
/*!40000 ALTER TABLE `reminder_reminder_seq` DISABLE KEYS */;
INSERT INTO `reminder_reminder_seq` VALUES (11);
/*!40000 ALTER TABLE `reminder_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_seq`
--

DROP TABLE IF EXISTS `reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_seq`
--

LOCK TABLES `reminder_seq` WRITE;
/*!40000 ALTER TABLE `reminder_seq` DISABLE KEYS */;
INSERT INTO `reminder_seq` VALUES (7);
/*!40000 ALTER TABLE `reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_snooze`
--

DROP TABLE IF EXISTS `reminder_snooze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_snooze` (
  `reminder_snooze_id` bigint NOT NULL,
  `reminder_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `snooze_id` bigint DEFAULT NULL,
  PRIMARY KEY (`reminder_snooze_id`),
  KEY `FK60xeae54dtqbojv0qdc3w58rh` (`reminder_id`),
  KEY `FKpicjausdrb1tld2inyewx0nhd` (`snooze_id`),
  CONSTRAINT `FK60xeae54dtqbojv0qdc3w58rh` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKpicjausdrb1tld2inyewx0nhd` FOREIGN KEY (`snooze_id`) REFERENCES `snooze` (`snooze_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_snooze`
--

LOCK TABLES `reminder_snooze` WRITE;
/*!40000 ALTER TABLE `reminder_snooze` DISABLE KEYS */;
INSERT INTO `reminder_snooze` VALUES (1,'2023-06-18 12:27:08',1,1),(2,'2023-06-18 12:27:20',2,2),(3,'2023-06-18 12:27:26',3,3),(4,'2023-06-18 12:27:32',4,4),(5,'2023-06-18 12:27:36',4,5),(6,'2023-06-18 12:27:40',5,5),(8,'2023-06-18 13:07:41',6,4);
/*!40000 ALTER TABLE `reminder_snooze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_snooze_seq`
--

DROP TABLE IF EXISTS `reminder_snooze_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_snooze_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_snooze_seq`
--

LOCK TABLES `reminder_snooze_seq` WRITE;
/*!40000 ALTER TABLE `reminder_snooze_seq` DISABLE KEYS */;
INSERT INTO `reminder_snooze_seq` VALUES (9);
/*!40000 ALTER TABLE `reminder_snooze_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_user`
--

DROP TABLE IF EXISTS `reminder_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_user` (
  `reminder_user_id` bigint NOT NULL,
  `reminder_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`reminder_user_id`),
  KEY `FK378qvf472rwgbt2uk3pu2obe` (`reminder_id`),
  KEY `FKeh9r7mmtaykhplr5b7sukutje` (`user_id`),
  CONSTRAINT `FK378qvf472rwgbt2uk3pu2obe` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKeh9r7mmtaykhplr5b7sukutje` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_user`
--

LOCK TABLES `reminder_user` WRITE;
/*!40000 ALTER TABLE `reminder_user` DISABLE KEYS */;
INSERT INTO `reminder_user` VALUES (1,'2023-06-18 12:20:00',2,1),(2,'2023-06-18 12:20:20',3,1),(3,'2023-06-18 12:20:45',4,1),(4,'2023-06-18 12:20:53',5,1),(5,'2023-06-18 12:20:55',1,1),(6,'2023-06-18 12:25:13',1,2),(7,'2023-06-18 12:25:16',1,3),(8,'2023-06-18 12:25:18',1,4),(9,'2023-06-18 12:25:20',1,5),(10,'2023-06-18 12:25:24',2,5),(11,'2023-06-18 12:25:27',2,4),(12,'2023-06-18 12:25:28',2,3),(13,'2023-06-18 12:25:29',2,2),(14,'2023-06-18 13:06:41',6,1),(16,'2023-06-18 13:07:34',6,4);
/*!40000 ALTER TABLE `reminder_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminder_user_seq`
--

DROP TABLE IF EXISTS `reminder_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder_user_seq`
--

LOCK TABLES `reminder_user_seq` WRITE;
/*!40000 ALTER TABLE `reminder_user_seq` DISABLE KEYS */;
INSERT INTO `reminder_user_seq` VALUES (17);
/*!40000 ALTER TABLE `reminder_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL,
  `role_type` int DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,0),(2,1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_seq`
--

DROP TABLE IF EXISTS `role_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_seq`
--

LOCK TABLES `role_seq` WRITE;
/*!40000 ALTER TABLE `role_seq` DISABLE KEYS */;
INSERT INTO `role_seq` VALUES (3);
/*!40000 ALTER TABLE `role_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `shop_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `FKj97brjwss3mlgdt7t213tkchl` (`user_id`),
  CONSTRAINT `FKj97brjwss3mlgdt7t213tkchl` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'2023-06-14 21:55:35','shop1','loc1',1),(2,'2023-06-14 21:55:40','shop2','loc2',1),(3,'2023-06-14 21:55:45','shop3','loc3',1),(4,'2023-06-14 21:55:54','shop33','loc33',1),(5,'2023-06-14 21:55:56','shop333','loc333',1);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_history_seq`
--

DROP TABLE IF EXISTS `shop_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_history_seq`
--

LOCK TABLES `shop_history_seq` WRITE;
/*!40000 ALTER TABLE `shop_history_seq` DISABLE KEYS */;
INSERT INTO `shop_history_seq` VALUES (1);
/*!40000 ALTER TABLE `shop_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_reminder`
--

DROP TABLE IF EXISTS `shop_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_reminder` (
  `shop_reminder_id` bigint NOT NULL,
  `shop_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `shop_id` bigint DEFAULT NULL,
  PRIMARY KEY (`shop_reminder_id`),
  KEY `FKbxlk13ey7rpu6woixcfxg3hc6` (`reminder_id`),
  KEY `FKi2w1ye0vdlc5m8it1sbufs3q5` (`shop_id`),
  CONSTRAINT `FKbxlk13ey7rpu6woixcfxg3hc6` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKi2w1ye0vdlc5m8it1sbufs3q5` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_reminder`
--

LOCK TABLES `shop_reminder` WRITE;
/*!40000 ALTER TABLE `shop_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_reminder_seq`
--

DROP TABLE IF EXISTS `shop_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_reminder_seq`
--

LOCK TABLES `shop_reminder_seq` WRITE;
/*!40000 ALTER TABLE `shop_reminder_seq` DISABLE KEYS */;
INSERT INTO `shop_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `shop_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_seq`
--

DROP TABLE IF EXISTS `shop_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_seq`
--

LOCK TABLES `shop_seq` WRITE;
/*!40000 ALTER TABLE `shop_seq` DISABLE KEYS */;
INSERT INTO `shop_seq` VALUES (6);
/*!40000 ALTER TABLE `shop_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_tag`
--

DROP TABLE IF EXISTS `shop_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_tag` (
  `shop_tag_id` bigint NOT NULL,
  `shop_date` datetime DEFAULT NULL,
  `shop_id` bigint DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  PRIMARY KEY (`shop_tag_id`),
  KEY `FK39xib3lpi6p5457jk8lifgtup` (`shop_id`),
  KEY `FK9udt1xiirniul20xyllvn02nu` (`tag_id`),
  CONSTRAINT `FK39xib3lpi6p5457jk8lifgtup` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`),
  CONSTRAINT `FK9udt1xiirniul20xyllvn02nu` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_tag`
--

LOCK TABLES `shop_tag` WRITE;
/*!40000 ALTER TABLE `shop_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_tag_seq`
--

DROP TABLE IF EXISTS `shop_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_tag_seq`
--

LOCK TABLES `shop_tag_seq` WRITE;
/*!40000 ALTER TABLE `shop_tag_seq` DISABLE KEYS */;
INSERT INTO `shop_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `shop_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_tasks`
--

DROP TABLE IF EXISTS `shop_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_tasks` (
  `shop_tasks_id` bigint NOT NULL,
  `shop_date` datetime DEFAULT NULL,
  `shop_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`shop_tasks_id`),
  KEY `FKe33vm9w0vh0v2u4w92pt54y47` (`shop_id`),
  KEY `FKd6r53krq1lkp483t0pc71bg76` (`tasks_id`),
  CONSTRAINT `FKd6r53krq1lkp483t0pc71bg76` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKe33vm9w0vh0v2u4w92pt54y47` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_tasks`
--

LOCK TABLES `shop_tasks` WRITE;
/*!40000 ALTER TABLE `shop_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_tasks_seq`
--

DROP TABLE IF EXISTS `shop_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_tasks_seq`
--

LOCK TABLES `shop_tasks_seq` WRITE;
/*!40000 ALTER TABLE `shop_tasks_seq` DISABLE KEYS */;
INSERT INTO `shop_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `shop_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_topic`
--

DROP TABLE IF EXISTS `shop_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_topic` (
  `shop_topic_id` bigint NOT NULL,
  `shop_date` datetime DEFAULT NULL,
  `shop_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`shop_topic_id`),
  KEY `FKtkthhljxicvymp0rulxd0usvn` (`shop_id`),
  KEY `FKe7y5ipmvvcdq5519t6ft97fw8` (`topic_id`),
  CONSTRAINT `FKe7y5ipmvvcdq5519t6ft97fw8` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKtkthhljxicvymp0rulxd0usvn` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_topic`
--

LOCK TABLES `shop_topic` WRITE;
/*!40000 ALTER TABLE `shop_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_topic_seq`
--

DROP TABLE IF EXISTS `shop_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_topic_seq`
--

LOCK TABLES `shop_topic_seq` WRITE;
/*!40000 ALTER TABLE `shop_topic_seq` DISABLE KEYS */;
INSERT INTO `shop_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `shop_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user`
--

DROP TABLE IF EXISTS `shop_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_user` (
  `shop_user_id` bigint NOT NULL,
  `shop_date` datetime DEFAULT NULL,
  `shop_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`shop_user_id`),
  KEY `FKb16wr519ua59yoo2fn6fu3fqs` (`shop_id`),
  KEY `FKp98akg88pxkkblanf1o8ce6iy` (`user_id`),
  CONSTRAINT `FKb16wr519ua59yoo2fn6fu3fqs` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`),
  CONSTRAINT `FKp98akg88pxkkblanf1o8ce6iy` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user`
--

LOCK TABLES `shop_user` WRITE;
/*!40000 ALTER TABLE `shop_user` DISABLE KEYS */;
INSERT INTO `shop_user` VALUES (1,'2023-06-14 21:55:35',1,1),(2,'2023-06-14 21:55:40',2,1),(3,'2023-06-14 21:55:45',3,1),(4,'2023-06-14 21:55:54',4,1),(5,'2023-06-14 21:55:56',5,1);
/*!40000 ALTER TABLE `shop_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop_user_seq`
--

DROP TABLE IF EXISTS `shop_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop_user_seq`
--

LOCK TABLES `shop_user_seq` WRITE;
/*!40000 ALTER TABLE `shop_user_seq` DISABLE KEYS */;
INSERT INTO `shop_user_seq` VALUES (6);
/*!40000 ALTER TABLE `shop_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snooze`
--

DROP TABLE IF EXISTS `snooze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `snooze` (
  `snooze_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `snooze_time` time DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`snooze_id`),
  KEY `FKdyx12efmijkhvwjjlt5i936rd` (`user_id`),
  CONSTRAINT `FKdyx12efmijkhvwjjlt5i936rd` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snooze`
--

LOCK TABLES `snooze` WRITE;
/*!40000 ALTER TABLE `snooze` DISABLE KEYS */;
INSERT INTO `snooze` VALUES (1,'2023-06-18 12:26:18',NULL,'snooze1',1),(2,'2023-06-18 12:26:29',NULL,'snooze2',1),(3,'2023-06-18 12:26:33',NULL,'snooze3',1),(4,'2023-06-18 12:26:38',NULL,'snooze4',1),(5,'2023-06-18 12:26:43',NULL,'snooze5',1);
/*!40000 ALTER TABLE `snooze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snooze_seq`
--

DROP TABLE IF EXISTS `snooze_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `snooze_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snooze_seq`
--

LOCK TABLES `snooze_seq` WRITE;
/*!40000 ALTER TABLE `snooze_seq` DISABLE KEYS */;
INSERT INTO `snooze_seq` VALUES (6);
/*!40000 ALTER TABLE `snooze_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snooze_user`
--

DROP TABLE IF EXISTS `snooze_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `snooze_user` (
  `snooze_user_id` bigint NOT NULL,
  `snooze_date` datetime DEFAULT NULL,
  `snooze_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`snooze_user_id`),
  KEY `FK17f8p387ak7b5sn1g79xgg3ex` (`snooze_id`),
  KEY `FK1oisu85l08ewenv6hvqydc8ag` (`user_id`),
  CONSTRAINT `FK17f8p387ak7b5sn1g79xgg3ex` FOREIGN KEY (`snooze_id`) REFERENCES `snooze` (`snooze_id`),
  CONSTRAINT `FK1oisu85l08ewenv6hvqydc8ag` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snooze_user`
--

LOCK TABLES `snooze_user` WRITE;
/*!40000 ALTER TABLE `snooze_user` DISABLE KEYS */;
INSERT INTO `snooze_user` VALUES (1,'2023-06-18 12:26:18',1,1),(2,'2023-06-18 12:26:29',2,1),(3,'2023-06-18 12:26:33',3,1),(4,'2023-06-18 12:26:38',4,1),(5,'2023-06-18 12:26:43',5,1);
/*!40000 ALTER TABLE `snooze_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snooze_user_seq`
--

DROP TABLE IF EXISTS `snooze_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `snooze_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snooze_user_seq`
--

LOCK TABLES `snooze_user_seq` WRITE;
/*!40000 ALTER TABLE `snooze_user_seq` DISABLE KEYS */;
INSERT INTO `snooze_user_seq` VALUES (6);
/*!40000 ALTER TABLE `snooze_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `tag_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `FKld85w5kr7ky5w4wda3nrdo0p8` (`user_id`),
  CONSTRAINT `FKld85w5kr7ky5w4wda3nrdo0p8` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'2023-06-04 15:51:35','tag1',1),(2,'2023-06-04 15:51:45','tag2',1),(3,'2023-06-04 15:51:48','tag3',1),(4,'2023-06-04 15:51:52','tag4',1),(5,'2023-06-04 15:58:25','tag5',1),(6,'2023-06-17 19:05:08','tag3333',1);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_history`
--

DROP TABLE IF EXISTS `tag_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_history` (
  `tag_history_id` bigint NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tag_history_id`),
  KEY `FK9hpkui20robrpkgsdtxmwk055` (`tag_id`),
  KEY `FK7f8m9il5uhomocxvuxs6ocvsk` (`user_id`),
  CONSTRAINT `FK7f8m9il5uhomocxvuxs6ocvsk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK9hpkui20robrpkgsdtxmwk055` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_history`
--

LOCK TABLES `tag_history` WRITE;
/*!40000 ALTER TABLE `tag_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_history_seq`
--

DROP TABLE IF EXISTS `tag_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_history_seq`
--

LOCK TABLES `tag_history_seq` WRITE;
/*!40000 ALTER TABLE `tag_history_seq` DISABLE KEYS */;
INSERT INTO `tag_history_seq` VALUES (1);
/*!40000 ALTER TABLE `tag_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_seq`
--

DROP TABLE IF EXISTS `tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_seq`
--

LOCK TABLES `tag_seq` WRITE;
/*!40000 ALTER TABLE `tag_seq` DISABLE KEYS */;
INSERT INTO `tag_seq` VALUES (7);
/*!40000 ALTER TABLE `tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_user`
--

DROP TABLE IF EXISTS `tag_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_user` (
  `tag_user_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tag_user_id`),
  KEY `FKe61rw5eenl0otv5chv809i7cm` (`tag_id`),
  KEY `FKie7nwka51a3y1d9rb8l0p2t21` (`user_id`),
  CONSTRAINT `FKe61rw5eenl0otv5chv809i7cm` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKie7nwka51a3y1d9rb8l0p2t21` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_user`
--

LOCK TABLES `tag_user` WRITE;
/*!40000 ALTER TABLE `tag_user` DISABLE KEYS */;
INSERT INTO `tag_user` VALUES (1,'2023-06-17 19:05:08',6,1),(3,'2023-06-17 19:12:24',6,3),(4,'2023-06-17 19:14:08',6,2),(5,'2023-06-17 19:14:08',1,1),(6,'2023-06-17 19:14:08',2,1),(7,'2023-06-17 19:14:08',3,1),(8,'2023-06-17 19:14:08',4,1),(9,'2023-06-17 19:14:08',5,1),(10,'2023-06-17 22:00:33',2,2),(11,'2023-06-17 22:00:43',3,3),(12,'2023-06-17 22:00:54',2,3),(13,'2023-06-17 22:00:58',3,2);
/*!40000 ALTER TABLE `tag_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_user_seq`
--

DROP TABLE IF EXISTS `tag_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_user_seq`
--

LOCK TABLES `tag_user_seq` WRITE;
/*!40000 ALTER TABLE `tag_user_seq` DISABLE KEYS */;
INSERT INTO `tag_user_seq` VALUES (14);
/*!40000 ALTER TABLE `tag_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `task_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `task_status` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `estimated_left_time` double DEFAULT NULL,
  `estimated_time` double DEFAULT NULL,
  `working_progress` double DEFAULT NULL,
  `working_time` double DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK2hsytmxysatfvt0p1992cw449` (`user_id`),
  CONSTRAINT `FK2hsytmxysatfvt0p1992cw449` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'2023-06-04 20:15:22','2023-06-04 20:15:31','2023-06-04 20:15:22','tasks1',NULL,1,1,1,1,1),(2,'2023-06-04 20:15:31','2023-06-04 20:15:32','2023-06-04 20:15:23','tasks2',NULL,1,2,2,2,2),(3,'2023-06-04 20:15:35','2023-06-04 20:15:33','2023-06-04 20:15:33','tasks3',NULL,1,3,3,3,3),(4,'2023-06-04 20:15:38','2023-06-04 20:15:34','2023-06-04 20:15:34','tasks4',NULL,1,NULL,NULL,NULL,NULL),(5,'2023-06-04 20:15:58','2023-06-04 20:15:35','2023-06-04 20:15:35','tasks5',NULL,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

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
  `address_history_id` bigint NOT NULL,
  `dates_history_id` bigint NOT NULL,
  `document_history_id` bigint NOT NULL,
  `email_history_id` bigint NOT NULL,
  `phone_number_history_id` bigint NOT NULL,
  `shop_history_id` bigint NOT NULL,
  `address_id` bigint DEFAULT NULL,
  `dates_id` bigint DEFAULT NULL,
  `document_id` bigint DEFAULT NULL,
  `email_id` bigint DEFAULT NULL,
  `phone_number_id` bigint DEFAULT NULL,
  `shop_id` bigint DEFAULT NULL,
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
  KEY `FK74xkgrqj6omi13w57umj6pgpf` (`address_id`),
  KEY `FK91y7v4ehcbkmdhsf277cbfwym` (`dates_id`),
  KEY `FKpe4dpruh1e5u59inha1d7b26s` (`document_id`),
  KEY `FKfv3mvvrw1lnh4eg9w9srklhqo` (`email_id`),
  KEY `FKim9b5hbr9pnb5fuurcd65s2w5` (`phone_number_id`),
  KEY `FKc651rt9s3dgpt67lb46lyhu9q` (`shop_id`),
  CONSTRAINT `FK47ur0p7wepwi1iam6jt2k2spp` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FK72gvgq5gsti5dg6qsvs4arhfx` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`),
  CONSTRAINT `FK74xkgrqj6omi13w57umj6pgpf` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `FK91y7v4ehcbkmdhsf277cbfwym` FOREIGN KEY (`dates_id`) REFERENCES `dates` (`dates_id`),
  CONSTRAINT `FKao94p07v5k5rli535suhxi8mm` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`),
  CONSTRAINT `FKbpl6dbhwxu5r873wunraktmve` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`),
  CONSTRAINT `FKc651rt9s3dgpt67lb46lyhu9q` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`),
  CONSTRAINT `FKer57q2libi1e9njpj6faoxd2i` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`),
  CONSTRAINT `FKewfv7belr4et9v218n5kexhwf` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FKf65kpecmxcya99d90r0y6cvft` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  CONSTRAINT `FKfv3mvvrw1lnh4eg9w9srklhqo` FOREIGN KEY (`email_id`) REFERENCES `email` (`email_id`),
  CONSTRAINT `FKfy9n8ry0l7ufhhqewby3o4pe` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FKim9b5hbr9pnb5fuurcd65s2w5` FOREIGN KEY (`phone_number_id`) REFERENCES `phone_number` (`phone_number_id`),
  CONSTRAINT `FKiw9nd8h62o8w6yclu7vhyev9r` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKks46yxxrgf7c76dcxg5q9m5oo` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`),
  CONSTRAINT `FKpe4dpruh1e5u59inha1d7b26s` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_history`
--

LOCK TABLES `task_history` WRITE;
/*!40000 ALTER TABLE `task_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_history_seq`
--

DROP TABLE IF EXISTS `task_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_history_seq`
--

LOCK TABLES `task_history_seq` WRITE;
/*!40000 ALTER TABLE `task_history_seq` DISABLE KEYS */;
INSERT INTO `task_history_seq` VALUES (1);
/*!40000 ALTER TABLE `task_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_reminder`
--

DROP TABLE IF EXISTS `task_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_reminder` (
  `task_reminder_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `task_id` bigint DEFAULT NULL,
  PRIMARY KEY (`task_reminder_id`),
  KEY `FKfwxmgboutglfp904nfe0ogc9w` (`reminder_id`),
  KEY `FK5l5hkramq406964uda1s7hsh3` (`task_id`),
  CONSTRAINT `FK5l5hkramq406964uda1s7hsh3` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`),
  CONSTRAINT `FKfwxmgboutglfp904nfe0ogc9w` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_reminder`
--

LOCK TABLES `task_reminder` WRITE;
/*!40000 ALTER TABLE `task_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_reminder_seq`
--

DROP TABLE IF EXISTS `task_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_reminder_seq`
--

LOCK TABLES `task_reminder_seq` WRITE;
/*!40000 ALTER TABLE `task_reminder_seq` DISABLE KEYS */;
INSERT INTO `task_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `task_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_seq`
--

DROP TABLE IF EXISTS `task_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_seq`
--

LOCK TABLES `task_seq` WRITE;
/*!40000 ALTER TABLE `task_seq` DISABLE KEYS */;
INSERT INTO `task_seq` VALUES (1);
/*!40000 ALTER TABLE `task_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_tag`
--

DROP TABLE IF EXISTS `task_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_tag` (
  `task_tag_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  `task_id` bigint DEFAULT NULL,
  PRIMARY KEY (`task_tag_id`),
  KEY `FK9mp6455j6w7duvlo9cwok7s6j` (`tag_id`),
  KEY `FKmnb6mkxwtvkg1utqig0ps56ne` (`task_id`),
  CONSTRAINT `FK9mp6455j6w7duvlo9cwok7s6j` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKmnb6mkxwtvkg1utqig0ps56ne` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_tag`
--

LOCK TABLES `task_tag` WRITE;
/*!40000 ALTER TABLE `task_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_tag_seq`
--

DROP TABLE IF EXISTS `task_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_tag_seq`
--

LOCK TABLES `task_tag_seq` WRITE;
/*!40000 ALTER TABLE `task_tag_seq` DISABLE KEYS */;
INSERT INTO `task_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `task_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_topic`
--

DROP TABLE IF EXISTS `task_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_topic` (
  `task_topic_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `task_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`task_topic_id`),
  KEY `FKaq8b23avwy2hcwf83rw7l9529` (`task_id`),
  KEY `FKdhfgtah6g5qullnshehv5fp02` (`topic_id`),
  CONSTRAINT `FKaq8b23avwy2hcwf83rw7l9529` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`),
  CONSTRAINT `FKdhfgtah6g5qullnshehv5fp02` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_topic`
--

LOCK TABLES `task_topic` WRITE;
/*!40000 ALTER TABLE `task_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_topic_seq`
--

DROP TABLE IF EXISTS `task_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_topic_seq`
--

LOCK TABLES `task_topic_seq` WRITE;
/*!40000 ALTER TABLE `task_topic_seq` DISABLE KEYS */;
INSERT INTO `task_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `task_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_user`
--

DROP TABLE IF EXISTS `task_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_user` (
  `task_user_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `task_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`task_user_id`),
  KEY `FKd1fn28rqhh1ku21jx7hcksvh9` (`task_id`),
  KEY `FKs46ejm4kitq56yd498a3fnr19` (`user_id`),
  CONSTRAINT `FKd1fn28rqhh1ku21jx7hcksvh9` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`),
  CONSTRAINT `FKs46ejm4kitq56yd498a3fnr19` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_user`
--

LOCK TABLES `task_user` WRITE;
/*!40000 ALTER TABLE `task_user` DISABLE KEYS */;
INSERT INTO `task_user` VALUES (1,'2023-06-04 20:15:22',1,1),(2,'2023-06-04 20:15:31',2,1),(3,'2023-06-04 20:15:35',3,1),(4,'2023-06-04 20:15:38',4,1),(5,'2023-06-04 20:15:58',5,1),(6,'2023-06-17 21:59:03',3,3);
/*!40000 ALTER TABLE `task_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_user_seq`
--

DROP TABLE IF EXISTS `task_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_user_seq`
--

LOCK TABLES `task_user_seq` WRITE;
/*!40000 ALTER TABLE `task_user_seq` DISABLE KEYS */;
INSERT INTO `task_user_seq` VALUES (7);
/*!40000 ALTER TABLE `task_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_work`
--

DROP TABLE IF EXISTS `task_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_work` (
  `task_work_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `task_id` bigint DEFAULT NULL,
  `work_id` bigint DEFAULT NULL,
  PRIMARY KEY (`task_work_id`),
  KEY `FKkfjl24vmlsr8asplmytsai4nb` (`task_id`),
  KEY `FKhyvkf23e1n05mpry11ig5ynfe` (`work_id`),
  CONSTRAINT `FKhyvkf23e1n05mpry11ig5ynfe` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`),
  CONSTRAINT `FKkfjl24vmlsr8asplmytsai4nb` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_work`
--

LOCK TABLES `task_work` WRITE;
/*!40000 ALTER TABLE `task_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_work_seq`
--

DROP TABLE IF EXISTS `task_work_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_work_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_work_seq`
--

LOCK TABLES `task_work_seq` WRITE;
/*!40000 ALTER TABLE `task_work_seq` DISABLE KEYS */;
INSERT INTO `task_work_seq` VALUES (1);
/*!40000 ALTER TABLE `task_work_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `tasks_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `tasks_status` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tasks_id`),
  KEY `FKqjk25pcieac7t8833ddos0cdu` (`user_id`),
  CONSTRAINT `FKqjk25pcieac7t8833ddos0cdu` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'2023-06-04 20:20:34',NULL,NULL,'tasks1',NULL,1),(2,'2023-06-04 20:20:40',NULL,NULL,'tasks2',NULL,1),(3,'2023-06-04 20:20:48',NULL,NULL,'tasks3',NULL,1),(4,'2023-06-04 20:20:54',NULL,NULL,'tasks4',NULL,1),(5,'2023-06-04 20:20:58',NULL,NULL,'tasks5',NULL,1);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_history_seq`
--

DROP TABLE IF EXISTS `tasks_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_history_seq`
--

LOCK TABLES `tasks_history_seq` WRITE;
/*!40000 ALTER TABLE `tasks_history_seq` DISABLE KEYS */;
INSERT INTO `tasks_history_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_reminder`
--

DROP TABLE IF EXISTS `tasks_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_reminder` (
  `tasks_reminder_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tasks_reminder_id`),
  KEY `FKcugql4tquthwhgkruv1ti7y0r` (`reminder_id`),
  KEY `FKqa48tq7it4yuor5adkco5aq6p` (`tasks_id`),
  CONSTRAINT `FKcugql4tquthwhgkruv1ti7y0r` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKqa48tq7it4yuor5adkco5aq6p` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_reminder`
--

LOCK TABLES `tasks_reminder` WRITE;
/*!40000 ALTER TABLE `tasks_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_reminder_seq`
--

DROP TABLE IF EXISTS `tasks_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_reminder_seq`
--

LOCK TABLES `tasks_reminder_seq` WRITE;
/*!40000 ALTER TABLE `tasks_reminder_seq` DISABLE KEYS */;
INSERT INTO `tasks_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_seq`
--

DROP TABLE IF EXISTS `tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_seq`
--

LOCK TABLES `tasks_seq` WRITE;
/*!40000 ALTER TABLE `tasks_seq` DISABLE KEYS */;
INSERT INTO `tasks_seq` VALUES (6);
/*!40000 ALTER TABLE `tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_tag`
--

DROP TABLE IF EXISTS `tasks_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_tag` (
  `tasks_tag_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tasks_tag_id`),
  KEY `FKlb8f8d21t2ynrhl8wfkdh2075` (`tag_id`),
  KEY `FKk5jkyix5g26i3swcwc9e0rk1b` (`tasks_id`),
  CONSTRAINT `FKk5jkyix5g26i3swcwc9e0rk1b` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKlb8f8d21t2ynrhl8wfkdh2075` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_tag`
--

LOCK TABLES `tasks_tag` WRITE;
/*!40000 ALTER TABLE `tasks_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_tag_seq`
--

DROP TABLE IF EXISTS `tasks_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_tag_seq`
--

LOCK TABLES `tasks_tag_seq` WRITE;
/*!40000 ALTER TABLE `tasks_tag_seq` DISABLE KEYS */;
INSERT INTO `tasks_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_task`
--

DROP TABLE IF EXISTS `tasks_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_task` (
  `tasks_task_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `task_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tasks_task_id`),
  KEY `FKt0659vvbkxjqg73whtedhkl5x` (`task_id`),
  KEY `FKpuhwhiu4lop75isy4vmnhsl2r` (`tasks_id`),
  CONSTRAINT `FKpuhwhiu4lop75isy4vmnhsl2r` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKt0659vvbkxjqg73whtedhkl5x` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_task`
--

LOCK TABLES `tasks_task` WRITE;
/*!40000 ALTER TABLE `tasks_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_task_seq`
--

DROP TABLE IF EXISTS `tasks_task_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_task_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_task_seq`
--

LOCK TABLES `tasks_task_seq` WRITE;
/*!40000 ALTER TABLE `tasks_task_seq` DISABLE KEYS */;
INSERT INTO `tasks_task_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_task_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_topic`
--

DROP TABLE IF EXISTS `tasks_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_topic` (
  `tasks_topic_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tasks_topic_id`),
  KEY `FKkp8e2nx8qesy6b09p48jgraqm` (`tasks_id`),
  KEY `FK3fg6ahx98uds28d3fmrevf0k4` (`topic_id`),
  CONSTRAINT `FK3fg6ahx98uds28d3fmrevf0k4` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKkp8e2nx8qesy6b09p48jgraqm` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_topic`
--

LOCK TABLES `tasks_topic` WRITE;
/*!40000 ALTER TABLE `tasks_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_topic_seq`
--

DROP TABLE IF EXISTS `tasks_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_topic_seq`
--

LOCK TABLES `tasks_topic_seq` WRITE;
/*!40000 ALTER TABLE `tasks_topic_seq` DISABLE KEYS */;
INSERT INTO `tasks_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_user`
--

DROP TABLE IF EXISTS `tasks_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_user` (
  `tasks_user_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`tasks_user_id`),
  KEY `FKir0vkmnk14tl6s8s1recgn146` (`tasks_id`),
  KEY `FKlb8u32ed68mfihjl5xp2no4da` (`user_id`),
  CONSTRAINT `FKir0vkmnk14tl6s8s1recgn146` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKlb8u32ed68mfihjl5xp2no4da` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_user`
--

LOCK TABLES `tasks_user` WRITE;
/*!40000 ALTER TABLE `tasks_user` DISABLE KEYS */;
INSERT INTO `tasks_user` VALUES (1,'2023-06-04 20:20:34',1,1),(2,'2023-06-04 20:20:40',2,1),(3,'2023-06-04 20:20:48',3,1),(4,'2023-06-04 20:20:54',4,1),(5,'2023-06-04 20:20:59',5,1);
/*!40000 ALTER TABLE `tasks_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks_user_seq`
--

DROP TABLE IF EXISTS `tasks_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks_user_seq`
--

LOCK TABLES `tasks_user_seq` WRITE;
/*!40000 ALTER TABLE `tasks_user_seq` DISABLE KEYS */;
INSERT INTO `tasks_user_seq` VALUES (6);
/*!40000 ALTER TABLE `tasks_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `topic_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `FK38wu074adxipuj6a9ifd7jv5f` (`user_id`),
  CONSTRAINT `FK38wu074adxipuj6a9ifd7jv5f` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'2023-06-04 20:11:24','topic1',1),(2,'2023-06-04 20:11:32','topic2',1),(3,'2023-06-04 20:11:39','topic3',1),(4,'2023-06-04 20:11:45','topic33',1),(5,'2023-06-04 20:11:52','topic333',1);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_history`
--

DROP TABLE IF EXISTS `topic_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_history` (
  `topic_history_id` bigint NOT NULL,
  `modifed_date` datetime DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`topic_history_id`),
  KEY `FK5ug8vani7x5mscq875qq770le` (`topic_id`),
  KEY `FKq8d0fshp6ci52a4uvs30jdvwr` (`user_id`),
  CONSTRAINT `FK5ug8vani7x5mscq875qq770le` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKq8d0fshp6ci52a4uvs30jdvwr` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_history`
--

LOCK TABLES `topic_history` WRITE;
/*!40000 ALTER TABLE `topic_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_history_seq`
--

DROP TABLE IF EXISTS `topic_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_history_seq`
--

LOCK TABLES `topic_history_seq` WRITE;
/*!40000 ALTER TABLE `topic_history_seq` DISABLE KEYS */;
INSERT INTO `topic_history_seq` VALUES (1);
/*!40000 ALTER TABLE `topic_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_link`
--

DROP TABLE IF EXISTS `topic_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_link` (
  `topic_link_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `link_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`topic_link_id`),
  KEY `FKrsbduop2wdvqb8f126ehh4sof` (`link_id`),
  KEY `FK8sc1499helc249lis4s3hedpf` (`topic_id`),
  CONSTRAINT `FK8sc1499helc249lis4s3hedpf` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKrsbduop2wdvqb8f126ehh4sof` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_link`
--

LOCK TABLES `topic_link` WRITE;
/*!40000 ALTER TABLE `topic_link` DISABLE KEYS */;
INSERT INTO `topic_link` VALUES (1,'2023-06-18 14:19:14',1,1),(2,'2023-06-18 14:19:19',2,2),(3,'2023-06-18 14:19:22',3,3),(4,'2023-06-18 14:19:25',4,4),(5,'2023-06-18 14:19:27',5,4),(6,'2023-06-18 14:19:30',5,5);
/*!40000 ALTER TABLE `topic_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_link_seq`
--

DROP TABLE IF EXISTS `topic_link_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_link_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_link_seq`
--

LOCK TABLES `topic_link_seq` WRITE;
/*!40000 ALTER TABLE `topic_link_seq` DISABLE KEYS */;
INSERT INTO `topic_link_seq` VALUES (9);
/*!40000 ALTER TABLE `topic_link_seq` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `topic_note` VALUES (1,'2023-06-18 14:16:48',1,1),(2,'2023-06-18 14:16:50',2,2),(3,'2023-06-18 14:16:55',3,3),(4,'2023-06-18 14:16:58',4,4),(5,'2023-06-18 14:17:00',4,5),(6,'2023-06-18 14:17:01',5,5);
/*!40000 ALTER TABLE `topic_note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_note_seq`
--

DROP TABLE IF EXISTS `topic_note_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_note_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_note_seq`
--

LOCK TABLES `topic_note_seq` WRITE;
/*!40000 ALTER TABLE `topic_note_seq` DISABLE KEYS */;
INSERT INTO `topic_note_seq` VALUES (9);
/*!40000 ALTER TABLE `topic_note_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_reminder`
--

DROP TABLE IF EXISTS `topic_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_reminder` (
  `topic_reminder_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`topic_reminder_id`),
  KEY `FK3lg0h9sfav3x08kwmstri7kfh` (`reminder_id`),
  KEY `FK12uuqc1uhui943apbv0a9ndg8` (`topic_id`),
  CONSTRAINT `FK12uuqc1uhui943apbv0a9ndg8` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FK3lg0h9sfav3x08kwmstri7kfh` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_reminder`
--

LOCK TABLES `topic_reminder` WRITE;
/*!40000 ALTER TABLE `topic_reminder` DISABLE KEYS */;
INSERT INTO `topic_reminder` VALUES (1,'2023-06-18 14:18:48',1,1),(2,'2023-06-18 14:18:52',2,2),(3,'2023-06-18 14:18:54',3,3),(4,'2023-06-18 14:18:56',4,4),(5,'2023-06-18 14:18:57',4,5),(6,'2023-06-18 14:18:59',5,5);
/*!40000 ALTER TABLE `topic_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_reminder_seq`
--

DROP TABLE IF EXISTS `topic_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_reminder_seq`
--

LOCK TABLES `topic_reminder_seq` WRITE;
/*!40000 ALTER TABLE `topic_reminder_seq` DISABLE KEYS */;
INSERT INTO `topic_reminder_seq` VALUES (9);
/*!40000 ALTER TABLE `topic_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_seq`
--

DROP TABLE IF EXISTS `topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_seq`
--

LOCK TABLES `topic_seq` WRITE;
/*!40000 ALTER TABLE `topic_seq` DISABLE KEYS */;
INSERT INTO `topic_seq` VALUES (7);
/*!40000 ALTER TABLE `topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_tag`
--

DROP TABLE IF EXISTS `topic_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_tag` (
  `topic_tag_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  PRIMARY KEY (`topic_tag_id`),
  KEY `FKghqd3bga4hj3pklcwmgw36f9l` (`tag_id`),
  KEY `FKqvqmd2eomy749a9uei56n71rd` (`topic_id`),
  CONSTRAINT `FKghqd3bga4hj3pklcwmgw36f9l` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`),
  CONSTRAINT `FKqvqmd2eomy749a9uei56n71rd` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_tag`
--

LOCK TABLES `topic_tag` WRITE;
/*!40000 ALTER TABLE `topic_tag` DISABLE KEYS */;
INSERT INTO `topic_tag` VALUES (1,'2023-06-18 14:18:12',1,1),(2,'2023-06-18 14:18:16',2,2),(3,'2023-06-18 14:18:18',3,3),(4,'2023-06-18 14:18:20',4,4),(5,'2023-06-18 14:18:21',4,5),(6,'2023-06-18 14:18:23',5,5);
/*!40000 ALTER TABLE `topic_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_tag_seq`
--

DROP TABLE IF EXISTS `topic_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_tag_seq`
--

LOCK TABLES `topic_tag_seq` WRITE;
/*!40000 ALTER TABLE `topic_tag_seq` DISABLE KEYS */;
INSERT INTO `topic_tag_seq` VALUES (9);
/*!40000 ALTER TABLE `topic_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_user`
--

DROP TABLE IF EXISTS `topic_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_user` (
  `topic_user_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`topic_user_id`),
  KEY `FKdd1vsk5b3sb9i9j7kwhpomhyc` (`topic_id`),
  KEY `FKga75s0q7bp80rcqx7lqvjcm8k` (`user_id`),
  CONSTRAINT `FKdd1vsk5b3sb9i9j7kwhpomhyc` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKga75s0q7bp80rcqx7lqvjcm8k` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_user`
--

LOCK TABLES `topic_user` WRITE;
/*!40000 ALTER TABLE `topic_user` DISABLE KEYS */;
INSERT INTO `topic_user` VALUES (1,'2023-06-04 20:11:24',1,1),(2,'2023-06-04 20:11:32',2,1),(3,'2023-06-04 20:11:39',3,1),(4,'2023-06-04 20:11:45',4,1),(5,'2023-06-04 20:11:52',5,1),(6,'2023-06-18 14:40:13',2,2),(7,'2023-06-18 14:40:14',2,3),(8,'2023-06-18 14:40:15',2,4),(9,'2023-06-18 14:40:17',2,5),(10,'2023-06-18 14:40:20',3,5),(11,'2023-06-18 14:40:24',3,4),(12,'2023-06-18 14:40:25',3,3),(13,'2023-06-18 14:40:27',3,2);
/*!40000 ALTER TABLE `topic_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_user_seq`
--

DROP TABLE IF EXISTS `topic_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_user_seq`
--

LOCK TABLES `topic_user_seq` WRITE;
/*!40000 ALTER TABLE `topic_user_seq` DISABLE KEYS */;
INSERT INTO `topic_user_seq` VALUES (17);
/*!40000 ALTER TABLE `topic_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `sum` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FKsg7jp0aj6qipr50856wf6vbw1` (`user_id`),
  CONSTRAINT `FKsg7jp0aj6qipr50856wf6vbw1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'2023-06-04 22:26:17','transaction1',1,1,'type1'),(2,'2023-06-04 22:26:27','transaction2',1,2,'type2'),(3,'2023-06-04 22:26:34','transaction3',1,3,'type3'),(4,'2023-06-04 22:26:39','transaction4',1,4,'type33'),(5,'2023-06-04 22:26:47','transaction5',1,5,'type333');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_history_seq`
--

DROP TABLE IF EXISTS `transaction_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_history_seq`
--

LOCK TABLES `transaction_history_seq` WRITE;
/*!40000 ALTER TABLE `transaction_history_seq` DISABLE KEYS */;
INSERT INTO `transaction_history_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_reminder`
--

DROP TABLE IF EXISTS `transaction_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_reminder` (
  `transaction_reminder_id` bigint NOT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_reminder_id`),
  KEY `FK26odbcxpxw4h1c6isxa2pro5f` (`reminder_id`),
  KEY `FKo7uwj13sfl9sy7stghhfxwyru` (`transaction_id`),
  CONSTRAINT `FK26odbcxpxw4h1c6isxa2pro5f` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FKo7uwj13sfl9sy7stghhfxwyru` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_reminder`
--

LOCK TABLES `transaction_reminder` WRITE;
/*!40000 ALTER TABLE `transaction_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_reminder_seq`
--

DROP TABLE IF EXISTS `transaction_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_reminder_seq`
--

LOCK TABLES `transaction_reminder_seq` WRITE;
/*!40000 ALTER TABLE `transaction_reminder_seq` DISABLE KEYS */;
INSERT INTO `transaction_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_seq`
--

DROP TABLE IF EXISTS `transaction_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_seq`
--

LOCK TABLES `transaction_seq` WRITE;
/*!40000 ALTER TABLE `transaction_seq` DISABLE KEYS */;
INSERT INTO `transaction_seq` VALUES (11);
/*!40000 ALTER TABLE `transaction_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_tag`
--

DROP TABLE IF EXISTS `transaction_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_tag` (
  `transaction_tag_id` bigint NOT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_tag_id`),
  KEY `FKl823jm48pl3r8n5or978p4sup` (`tag_id`),
  KEY `FK7d8lvqkvukcf4gvfmtg4wfig6` (`transaction_id`),
  CONSTRAINT `FK7d8lvqkvukcf4gvfmtg4wfig6` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  CONSTRAINT `FKl823jm48pl3r8n5or978p4sup` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_tag`
--

LOCK TABLES `transaction_tag` WRITE;
/*!40000 ALTER TABLE `transaction_tag` DISABLE KEYS */;
INSERT INTO `transaction_tag` VALUES (1,'2023-06-08 23:18:01',1,1),(2,'2023-06-08 23:18:04',2,2),(3,'2023-06-08 23:18:08',3,3),(4,'2023-06-08 23:18:12',4,3),(5,'2023-06-08 23:19:24',4,4),(6,'2023-06-08 23:19:31',5,4),(7,'2023-06-08 23:19:33',5,5);
/*!40000 ALTER TABLE `transaction_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_tag_seq`
--

DROP TABLE IF EXISTS `transaction_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_tag_seq`
--

LOCK TABLES `transaction_tag_seq` WRITE;
/*!40000 ALTER TABLE `transaction_tag_seq` DISABLE KEYS */;
INSERT INTO `transaction_tag_seq` VALUES (8);
/*!40000 ALTER TABLE `transaction_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_tasks`
--

DROP TABLE IF EXISTS `transaction_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_tasks` (
  `transaction_tasks_id` bigint NOT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_tasks_id`),
  KEY `FKf8uctj6mvx50jkbijt7jtbbm` (`tasks_id`),
  KEY `FKae396es0y7458s2h1sij45gpg` (`transaction_id`),
  CONSTRAINT `FKae396es0y7458s2h1sij45gpg` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  CONSTRAINT `FKf8uctj6mvx50jkbijt7jtbbm` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_tasks`
--

LOCK TABLES `transaction_tasks` WRITE;
/*!40000 ALTER TABLE `transaction_tasks` DISABLE KEYS */;
INSERT INTO `transaction_tasks` VALUES (1,'2023-06-08 23:21:26',1,1),(2,'2023-06-08 23:21:29',2,2),(3,'2023-06-08 23:21:32',3,3),(4,'2023-06-08 23:21:34',4,4),(5,'2023-06-08 23:21:36',4,5),(6,'2023-06-08 23:21:38',5,5);
/*!40000 ALTER TABLE `transaction_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_tasks_seq`
--

DROP TABLE IF EXISTS `transaction_tasks_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_tasks_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_tasks_seq`
--

LOCK TABLES `transaction_tasks_seq` WRITE;
/*!40000 ALTER TABLE `transaction_tasks_seq` DISABLE KEYS */;
INSERT INTO `transaction_tasks_seq` VALUES (7);
/*!40000 ALTER TABLE `transaction_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_topic`
--

DROP TABLE IF EXISTS `transaction_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_topic` (
  `transaction_topic_id` bigint NOT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_topic_id`),
  KEY `FKpoh6epj94af8lj7g8humpup7y` (`topic_id`),
  KEY `FKsc2a14urv8jcj5vu52723emjr` (`transaction_id`),
  CONSTRAINT `FKpoh6epj94af8lj7g8humpup7y` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKsc2a14urv8jcj5vu52723emjr` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_topic`
--

LOCK TABLES `transaction_topic` WRITE;
/*!40000 ALTER TABLE `transaction_topic` DISABLE KEYS */;
INSERT INTO `transaction_topic` VALUES (1,'2023-06-08 23:20:37',1,1),(2,'2023-06-08 23:20:41',2,2),(3,'2023-06-08 23:20:44',3,3),(4,'2023-06-08 23:20:46',4,4),(5,'2023-06-08 23:20:49',4,5),(6,'2023-06-08 23:20:51',5,5);
/*!40000 ALTER TABLE `transaction_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_topic_seq`
--

DROP TABLE IF EXISTS `transaction_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_topic_seq`
--

LOCK TABLES `transaction_topic_seq` WRITE;
/*!40000 ALTER TABLE `transaction_topic_seq` DISABLE KEYS */;
INSERT INTO `transaction_topic_seq` VALUES (7);
/*!40000 ALTER TABLE `transaction_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_user`
--

DROP TABLE IF EXISTS `transaction_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_user` (
  `transaction_user_id` bigint NOT NULL,
  `transaction_date` datetime DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`transaction_user_id`),
  KEY `FKpf7dcfrk522wb56f4m0dxvq8o` (`transaction_id`),
  KEY `FKmmqjt6v5od7y6abjq0uwdqeyj` (`user_id`),
  CONSTRAINT `FKmmqjt6v5od7y6abjq0uwdqeyj` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKpf7dcfrk522wb56f4m0dxvq8o` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_user`
--

LOCK TABLES `transaction_user` WRITE;
/*!40000 ALTER TABLE `transaction_user` DISABLE KEYS */;
INSERT INTO `transaction_user` VALUES (1,'2023-06-04 22:26:17',1,1),(2,'2023-06-04 22:26:27',2,1),(3,'2023-06-04 22:26:34',3,1),(4,'2023-06-04 22:26:39',4,1),(5,'2023-06-04 22:26:47',5,1);
/*!40000 ALTER TABLE `transaction_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_user_seq`
--

DROP TABLE IF EXISTS `transaction_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_user_seq`
--

LOCK TABLES `transaction_user_seq` WRITE;
/*!40000 ALTER TABLE `transaction_user_seq` DISABLE KEYS */;
INSERT INTO `transaction_user_seq` VALUES (6);
/*!40000 ALTER TABLE `transaction_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `main_email` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `email_id` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKqdcjp0ysjegpu2jb76u3f3nx` (`email_id`),
  CONSTRAINT `FKqdcjp0ysjegpu2jb76u3f3nx` FOREIGN KEY (`email_id`) REFERENCES `email` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'User1','$2a$12$sJZ7/SZpCOTSeMg1jos87ulm.OcN31uQKnYisY/5r5XlNXSoQKPRi','E@1','2023-06-17 16:11:14',1),(2,'1','$2a$12$gaUsXx4r4JlzHYXomu/XguBgQZbj2XXOWq5h683u7KCOPUozoRy56',NULL,'2023-06-17 16:13:14',2),(3,'User3','$2a$12$b/jcMc9LC8sTk.8mV6Mzv.0GFCqgD7O/oK6m96nojFVKuGj8LlJv2',NULL,'2023-06-17 16:14:04',3),(4,'user4','$2a$10$m0tyrKkl6Vz2mB6hnjQFdOdETv5o4SQTqVBEdoDVNNyY11ZwthSUa',NULL,'2023-06-17 16:14:14',2),(5,'user5','$2a$10$0XhxLZ0Ktpww0GIDivuvL.N88vrzNnwTvjMGzeUJI4tDOj7h027zi',NULL,'2023-06-17 16:19:00',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_role_id` bigint NOT NULL,
  `date` datetime DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'2023-06-04 15:43:59',1,1),(2,'2023-06-04 15:43:59',2,1),(3,'2023-06-04 15:43:59',2,2),(4,'2023-06-04 15:43:59',1,3),(5,'2023-06-17 16:14:14',1,4),(6,'2023-06-17 16:19:00',2,5),(9,'2023-06-17 16:46:03',1,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role_seq`
--

DROP TABLE IF EXISTS `user_role_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_seq`
--

LOCK TABLES `user_role_seq` WRITE;
/*!40000 ALTER TABLE `user_role_seq` DISABLE KEYS */;
INSERT INTO `user_role_seq` VALUES (10);
/*!40000 ALTER TABLE `user_role_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (8);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_user`
--

DROP TABLE IF EXISTS `user_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_user` (
  `user_user_id` bigint NOT NULL,
  `date` datetime DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `user_linked_id` bigint DEFAULT NULL,
  PRIMARY KEY (`user_user_id`),
  KEY `FKewu8a78thkqv37l3ww3e94oqv` (`user_id`),
  KEY `FKjh8cf0sxyfsc9qrsvappsssq2` (`user_linked_id`),
  CONSTRAINT `FKewu8a78thkqv37l3ww3e94oqv` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKjh8cf0sxyfsc9qrsvappsssq2` FOREIGN KEY (`user_linked_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_user`
--

LOCK TABLES `user_user` WRITE;
/*!40000 ALTER TABLE `user_user` DISABLE KEYS */;
INSERT INTO `user_user` VALUES (1,'2023-06-17 16:14:14',1,4),(2,'2023-06-17 16:19:00',1,5),(5,'2023-06-17 16:44:55',1,2),(6,'2023-06-17 16:45:07',1,3),(7,'2023-06-18 08:39:44',3,1),(8,'2023-06-18 08:39:48',3,2),(9,'2023-06-18 08:39:51',3,4),(10,'2023-06-18 08:39:53',3,5);
/*!40000 ALTER TABLE `user_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_user_seq`
--

DROP TABLE IF EXISTS `user_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_user_seq`
--

LOCK TABLES `user_user_seq` WRITE;
/*!40000 ALTER TABLE `user_user_seq` DISABLE KEYS */;
INSERT INTO `user_user_seq` VALUES (11);
/*!40000 ALTER TABLE `user_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work` (
  `work_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `working_date` datetime DEFAULT NULL,
  `working_efort` time DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `working_effort` time DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `estimated_time` double DEFAULT NULL,
  `task_status` int DEFAULT NULL,
  `working_progress` double DEFAULT NULL,
  PRIMARY KEY (`work_id`),
  KEY `FKcjdv2ub5hdscnv52kyg4hnwb9` (`user_id`),
  CONSTRAINT `FKcjdv2ub5hdscnv52kyg4hnwb9` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_history`
--

DROP TABLE IF EXISTS `work_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_history` (
  `work_history_id` bigint NOT NULL,
  `modified_date` datetime DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `work_id` bigint DEFAULT NULL,
  PRIMARY KEY (`work_history_id`),
  KEY `FK18upifqq5xkgvc148q99mtpeu` (`user_id`),
  KEY `FKqr028frjsfldcgfk5ppsdnlkl` (`work_id`),
  CONSTRAINT `FK18upifqq5xkgvc148q99mtpeu` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKqr028frjsfldcgfk5ppsdnlkl` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_history`
--

LOCK TABLES `work_history` WRITE;
/*!40000 ALTER TABLE `work_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_history_seq`
--

DROP TABLE IF EXISTS `work_history_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_history_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_history_seq`
--

LOCK TABLES `work_history_seq` WRITE;
/*!40000 ALTER TABLE `work_history_seq` DISABLE KEYS */;
INSERT INTO `work_history_seq` VALUES (1);
/*!40000 ALTER TABLE `work_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_reminder`
--

DROP TABLE IF EXISTS `work_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_reminder` (
  `work_reminder_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `reminder_id` bigint DEFAULT NULL,
  `work_id` bigint DEFAULT NULL,
  PRIMARY KEY (`work_reminder_id`),
  KEY `FKns9l36n6dfko6m14ubvf3kt5x` (`reminder_id`),
  KEY `FKah1jmcmvouj48kfie8bshsp33` (`work_id`),
  CONSTRAINT `FKah1jmcmvouj48kfie8bshsp33` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`),
  CONSTRAINT `FKns9l36n6dfko6m14ubvf3kt5x` FOREIGN KEY (`reminder_id`) REFERENCES `reminder` (`reminder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_reminder`
--

LOCK TABLES `work_reminder` WRITE;
/*!40000 ALTER TABLE `work_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_reminder_seq`
--

DROP TABLE IF EXISTS `work_reminder_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_reminder_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_reminder_seq`
--

LOCK TABLES `work_reminder_seq` WRITE;
/*!40000 ALTER TABLE `work_reminder_seq` DISABLE KEYS */;
INSERT INTO `work_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `work_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_seq`
--

DROP TABLE IF EXISTS `work_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_seq`
--

LOCK TABLES `work_seq` WRITE;
/*!40000 ALTER TABLE `work_seq` DISABLE KEYS */;
INSERT INTO `work_seq` VALUES (1);
/*!40000 ALTER TABLE `work_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_tag`
--

DROP TABLE IF EXISTS `work_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_tag` (
  `work_tag_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `tag_id` bigint DEFAULT NULL,
  `work_id` bigint DEFAULT NULL,
  PRIMARY KEY (`work_tag_id`),
  KEY `FKqrhno4bemgng5i4p36cojki5x` (`tag_id`),
  KEY `FKliybd2bkgphrdsa0wosy5mguh` (`work_id`),
  CONSTRAINT `FKliybd2bkgphrdsa0wosy5mguh` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`),
  CONSTRAINT `FKqrhno4bemgng5i4p36cojki5x` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_tag`
--

LOCK TABLES `work_tag` WRITE;
/*!40000 ALTER TABLE `work_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_tag_seq`
--

DROP TABLE IF EXISTS `work_tag_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_tag_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_tag_seq`
--

LOCK TABLES `work_tag_seq` WRITE;
/*!40000 ALTER TABLE `work_tag_seq` DISABLE KEYS */;
INSERT INTO `work_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `work_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_topic`
--

DROP TABLE IF EXISTS `work_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_topic` (
  `work_topic_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  `work_id` bigint DEFAULT NULL,
  PRIMARY KEY (`work_topic_id`),
  KEY `FKkmvqgrenp8jn81s34p95ujtiv` (`topic_id`),
  KEY `FK90wunu6ry9sxs153vk8f00nxt` (`work_id`),
  CONSTRAINT `FK90wunu6ry9sxs153vk8f00nxt` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`),
  CONSTRAINT `FKkmvqgrenp8jn81s34p95ujtiv` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_topic`
--

LOCK TABLES `work_topic` WRITE;
/*!40000 ALTER TABLE `work_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_topic_seq`
--

DROP TABLE IF EXISTS `work_topic_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_topic_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_topic_seq`
--

LOCK TABLES `work_topic_seq` WRITE;
/*!40000 ALTER TABLE `work_topic_seq` DISABLE KEYS */;
INSERT INTO `work_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `work_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_user`
--

DROP TABLE IF EXISTS `work_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_user` (
  `work_user_id` bigint NOT NULL,
  `link_date` datetime DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `work_id` bigint DEFAULT NULL,
  PRIMARY KEY (`work_user_id`),
  KEY `FKlfl1cmd5tyrm4wi47dt3q4obx` (`user_id`),
  KEY `FKsk19ns4qftq6r1yfjw0j3a4uo` (`work_id`),
  CONSTRAINT `FKlfl1cmd5tyrm4wi47dt3q4obx` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKsk19ns4qftq6r1yfjw0j3a4uo` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_user`
--

LOCK TABLES `work_user` WRITE;
/*!40000 ALTER TABLE `work_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_user_seq`
--

DROP TABLE IF EXISTS `work_user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_user_seq`
--

LOCK TABLES `work_user_seq` WRITE;
/*!40000 ALTER TABLE `work_user_seq` DISABLE KEYS */;
INSERT INTO `work_user_seq` VALUES (1);
/*!40000 ALTER TABLE `work_user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-18 19:11:12
