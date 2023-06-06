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
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,10,'2023-06-01 13:14:15','account1','type1',1),(2,20,'2023-06-04 15:44:15','account2','type2',1),(3,30,'2023-06-04 15:44:18','account3','type3',1),(4,40,'2023-06-04 15:44:21','account33','type33',1),(5,50,'2023-06-04 15:44:26','account333','type333',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_expenses`
--

LOCK TABLES `account_expenses` WRITE;
/*!40000 ALTER TABLE `account_expenses` DISABLE KEYS */;
INSERT INTO `account_expenses` VALUES (1,'2023-06-04 22:20:59',1,1),(2,'2023-06-04 22:21:09',2,2),(3,'2023-06-04 22:21:16',3,3),(4,'2023-06-04 22:21:24',4,4),(5,'2023-06-04 22:21:30',4,5),(6,'2023-06-04 22:21:34',5,5);
/*!40000 ALTER TABLE `account_expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_expenses_seq`
--

LOCK TABLES `account_expenses_seq` WRITE;
/*!40000 ALTER TABLE `account_expenses_seq` DISABLE KEYS */;
INSERT INTO `account_expenses_seq` VALUES (7);
/*!40000 ALTER TABLE `account_expenses_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_history_seq`
--

LOCK TABLES `account_history_seq` WRITE;
/*!40000 ALTER TABLE `account_history_seq` DISABLE KEYS */;
INSERT INTO `account_history_seq` VALUES (1);
/*!40000 ALTER TABLE `account_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_reminder`
--

LOCK TABLES `account_reminder` WRITE;
/*!40000 ALTER TABLE `account_reminder` DISABLE KEYS */;
INSERT INTO `account_reminder` VALUES (1,'2023-06-04 16:13:43',1,1),(2,'2023-06-04 16:13:48',2,2),(3,'2023-06-04 16:13:51',3,3),(4,'2023-06-04 16:13:54',4,4),(5,'2023-06-04 16:13:57',4,5),(6,'2023-06-04 20:27:50',5,5);
/*!40000 ALTER TABLE `account_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_reminder_seq`
--

LOCK TABLES `account_reminder_seq` WRITE;
/*!40000 ALTER TABLE `account_reminder_seq` DISABLE KEYS */;
INSERT INTO `account_reminder_seq` VALUES (7);
/*!40000 ALTER TABLE `account_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_seq`
--

LOCK TABLES `account_seq` WRITE;
/*!40000 ALTER TABLE `account_seq` DISABLE KEYS */;
INSERT INTO `account_seq` VALUES (6);
/*!40000 ALTER TABLE `account_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_tag`
--

LOCK TABLES `account_tag` WRITE;
/*!40000 ALTER TABLE `account_tag` DISABLE KEYS */;
INSERT INTO `account_tag` VALUES (1,'2023-06-04 15:56:54',1,1),(2,'2023-06-04 15:57:04',2,2),(3,'2023-06-04 15:57:10',3,3),(4,'2023-06-04 15:57:35',4,4),(5,'2023-06-04 15:58:39',4,5),(6,'2023-06-04 20:27:35',5,5);
/*!40000 ALTER TABLE `account_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_tag_seq`
--

LOCK TABLES `account_tag_seq` WRITE;
/*!40000 ALTER TABLE `account_tag_seq` DISABLE KEYS */;
INSERT INTO `account_tag_seq` VALUES (7);
/*!40000 ALTER TABLE `account_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_tasks`
--

LOCK TABLES `account_tasks` WRITE;
/*!40000 ALTER TABLE `account_tasks` DISABLE KEYS */;
INSERT INTO `account_tasks` VALUES (1,'2023-06-04 20:26:41',1,1),(2,'2023-06-04 20:26:50',2,2),(3,'2023-06-04 20:26:59',3,3),(4,'2023-06-04 20:27:06',4,4),(5,'2023-06-04 20:27:11',4,5),(6,'2023-06-04 20:27:16',5,5);
/*!40000 ALTER TABLE `account_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_tasks_seq`
--

LOCK TABLES `account_tasks_seq` WRITE;
/*!40000 ALTER TABLE `account_tasks_seq` DISABLE KEYS */;
INSERT INTO `account_tasks_seq` VALUES (7);
/*!40000 ALTER TABLE `account_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_topic`
--

LOCK TABLES `account_topic` WRITE;
/*!40000 ALTER TABLE `account_topic` DISABLE KEYS */;
INSERT INTO `account_topic` VALUES (1,'2023-06-04 20:12:52',1,1),(2,'2023-06-04 20:12:57',2,2),(3,'2023-06-04 20:13:01',3,3),(4,'2023-06-04 20:13:04',4,4),(5,'2023-06-04 20:13:07',4,5),(6,'2023-06-04 20:28:08',5,5);
/*!40000 ALTER TABLE `account_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_topic_seq`
--

LOCK TABLES `account_topic_seq` WRITE;
/*!40000 ALTER TABLE `account_topic_seq` DISABLE KEYS */;
INSERT INTO `account_topic_seq` VALUES (7);
/*!40000 ALTER TABLE `account_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_transaction`
--

LOCK TABLES `account_transaction` WRITE;
/*!40000 ALTER TABLE `account_transaction` DISABLE KEYS */;
INSERT INTO `account_transaction` VALUES (1,'2023-06-04 22:30:59',1,1),(2,'2023-06-04 22:31:08',2,2),(3,'2023-06-04 22:31:16',3,3),(4,'2023-06-04 22:31:22',4,4),(5,'2023-06-04 22:32:28',5,5),(6,'2023-06-04 22:33:41',4,5);
/*!40000 ALTER TABLE `account_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_transaction_seq`
--

LOCK TABLES `account_transaction_seq` WRITE;
/*!40000 ALTER TABLE `account_transaction_seq` DISABLE KEYS */;
INSERT INTO `account_transaction_seq` VALUES (7);
/*!40000 ALTER TABLE `account_transaction_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_user`
--

LOCK TABLES `account_user` WRITE;
/*!40000 ALTER TABLE `account_user` DISABLE KEYS */;
INSERT INTO `account_user` VALUES (1,'2023-06-04 15:44:09',1,1),(2,'2023-06-04 15:44:15',2,1),(3,'2023-06-04 15:44:18',3,1),(4,'2023-06-04 15:44:21',4,1),(5,'2023-06-04 15:44:26',5,1),(6,'2023-06-04 19:33:28',1,2),(7,'2023-06-04 19:33:54',1,3),(8,'2023-06-04 19:34:05',2,2),(9,'2023-06-04 19:34:10',3,2);
/*!40000 ALTER TABLE `account_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_user_seq`
--

LOCK TABLES `account_user_seq` WRITE;
/*!40000 ALTER TABLE `account_user_seq` DISABLE KEYS */;
INSERT INTO `account_user_seq` VALUES (10);
/*!40000 ALTER TABLE `account_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_expense`
--

LOCK TABLES `event_expense` WRITE;
/*!40000 ALTER TABLE `event_expense` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_expense_seq`
--

LOCK TABLES `event_expense_seq` WRITE;
/*!40000 ALTER TABLE `event_expense_seq` DISABLE KEYS */;
INSERT INTO `event_expense_seq` VALUES (1);
/*!40000 ALTER TABLE `event_expense_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_history_seq`
--

LOCK TABLES `event_history_seq` WRITE;
/*!40000 ALTER TABLE `event_history_seq` DISABLE KEYS */;
INSERT INTO `event_history_seq` VALUES (1);
/*!40000 ALTER TABLE `event_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_reminder`
--

LOCK TABLES `event_reminder` WRITE;
/*!40000 ALTER TABLE `event_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_reminder_seq`
--

LOCK TABLES `event_reminder_seq` WRITE;
/*!40000 ALTER TABLE `event_reminder_seq` DISABLE KEYS */;
INSERT INTO `event_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `event_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_seq`
--

LOCK TABLES `event_seq` WRITE;
/*!40000 ALTER TABLE `event_seq` DISABLE KEYS */;
INSERT INTO `event_seq` VALUES (1);
/*!40000 ALTER TABLE `event_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_tag`
--

LOCK TABLES `event_tag` WRITE;
/*!40000 ALTER TABLE `event_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_tag_seq`
--

LOCK TABLES `event_tag_seq` WRITE;
/*!40000 ALTER TABLE `event_tag_seq` DISABLE KEYS */;
INSERT INTO `event_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `event_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_tasks`
--

LOCK TABLES `event_tasks` WRITE;
/*!40000 ALTER TABLE `event_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_tasks_seq`
--

LOCK TABLES `event_tasks_seq` WRITE;
/*!40000 ALTER TABLE `event_tasks_seq` DISABLE KEYS */;
INSERT INTO `event_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `event_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_topic`
--

LOCK TABLES `event_topic` WRITE;
/*!40000 ALTER TABLE `event_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_topic_seq`
--

LOCK TABLES `event_topic_seq` WRITE;
/*!40000 ALTER TABLE `event_topic_seq` DISABLE KEYS */;
INSERT INTO `event_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `event_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_user`
--

LOCK TABLES `event_user` WRITE;
/*!40000 ALTER TABLE `event_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `event_user_seq`
--

LOCK TABLES `event_user_seq` WRITE;
/*!40000 ALTER TABLE `event_user_seq` DISABLE KEYS */;
INSERT INTO `event_user_seq` VALUES (1);
/*!40000 ALTER TABLE `event_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense`
--

LOCK TABLES `expense` WRITE;
/*!40000 ALTER TABLE `expense` DISABLE KEYS */;
INSERT INTO `expense` VALUES (1,'2023-06-04 22:05:40','expense1',1),(2,'2023-06-04 22:05:51','expense2',1),(3,'2023-06-04 22:06:01','expense3',1),(4,'2023-06-04 22:06:09','expense4',1),(5,'2023-06-04 22:06:15','expense5',1);
/*!40000 ALTER TABLE `expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_history_seq`
--

LOCK TABLES `expense_history_seq` WRITE;
/*!40000 ALTER TABLE `expense_history_seq` DISABLE KEYS */;
INSERT INTO `expense_history_seq` VALUES (1);
/*!40000 ALTER TABLE `expense_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_reminder`
--

LOCK TABLES `expense_reminder` WRITE;
/*!40000 ALTER TABLE `expense_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `expense_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_reminder_seq`
--

LOCK TABLES `expense_reminder_seq` WRITE;
/*!40000 ALTER TABLE `expense_reminder_seq` DISABLE KEYS */;
INSERT INTO `expense_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `expense_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_seq`
--

LOCK TABLES `expense_seq` WRITE;
/*!40000 ALTER TABLE `expense_seq` DISABLE KEYS */;
INSERT INTO `expense_seq` VALUES (6);
/*!40000 ALTER TABLE `expense_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_tag`
--

LOCK TABLES `expense_tag` WRITE;
/*!40000 ALTER TABLE `expense_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `expense_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_tag_seq`
--

LOCK TABLES `expense_tag_seq` WRITE;
/*!40000 ALTER TABLE `expense_tag_seq` DISABLE KEYS */;
INSERT INTO `expense_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `expense_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_tasks`
--

LOCK TABLES `expense_tasks` WRITE;
/*!40000 ALTER TABLE `expense_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `expense_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_tasks_seq`
--

LOCK TABLES `expense_tasks_seq` WRITE;
/*!40000 ALTER TABLE `expense_tasks_seq` DISABLE KEYS */;
INSERT INTO `expense_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `expense_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_topic`
--

LOCK TABLES `expense_topic` WRITE;
/*!40000 ALTER TABLE `expense_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `expense_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_topic_seq`
--

LOCK TABLES `expense_topic_seq` WRITE;
/*!40000 ALTER TABLE `expense_topic_seq` DISABLE KEYS */;
INSERT INTO `expense_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `expense_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_user`
--

LOCK TABLES `expense_user` WRITE;
/*!40000 ALTER TABLE `expense_user` DISABLE KEYS */;
INSERT INTO `expense_user` VALUES (2,'2023-06-04 22:05:40',1,1),(3,'2023-06-04 22:05:51',2,1),(4,'2023-06-04 22:06:01',3,1),(5,'2023-06-04 22:06:09',4,1),(6,'2023-06-04 22:06:15',5,1);
/*!40000 ALTER TABLE `expense_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expense_user_seq`
--

LOCK TABLES `expense_user_seq` WRITE;
/*!40000 ALTER TABLE `expense_user_seq` DISABLE KEYS */;
INSERT INTO `expense_user_seq` VALUES (7);
/*!40000 ALTER TABLE `expense_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses`
--

LOCK TABLES `expenses` WRITE;
/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
INSERT INTO `expenses` VALUES (1,'2023-06-04 22:20:08','expenses1',1),(2,'2023-06-04 22:20:20','expenses2',1),(3,'2023-06-04 22:20:26','expenses3',1),(4,'2023-06-04 22:20:33','expenses4',1),(5,'2023-06-04 22:20:38','expenses5',1);
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_expense_seq`
--

LOCK TABLES `expenses_expense_seq` WRITE;
/*!40000 ALTER TABLE `expenses_expense_seq` DISABLE KEYS */;
INSERT INTO `expenses_expense_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_expense_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_history_seq`
--

LOCK TABLES `expenses_history_seq` WRITE;
/*!40000 ALTER TABLE `expenses_history_seq` DISABLE KEYS */;
INSERT INTO `expenses_history_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_person`
--

LOCK TABLES `expenses_person` WRITE;
/*!40000 ALTER TABLE `expenses_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_person_seq`
--

LOCK TABLES `expenses_person_seq` WRITE;
/*!40000 ALTER TABLE `expenses_person_seq` DISABLE KEYS */;
INSERT INTO `expenses_person_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_person_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_reminder`
--

LOCK TABLES `expenses_reminder` WRITE;
/*!40000 ALTER TABLE `expenses_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_reminder_seq`
--

LOCK TABLES `expenses_reminder_seq` WRITE;
/*!40000 ALTER TABLE `expenses_reminder_seq` DISABLE KEYS */;
INSERT INTO `expenses_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_seq`
--

LOCK TABLES `expenses_seq` WRITE;
/*!40000 ALTER TABLE `expenses_seq` DISABLE KEYS */;
INSERT INTO `expenses_seq` VALUES (6);
/*!40000 ALTER TABLE `expenses_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_tag`
--

LOCK TABLES `expenses_tag` WRITE;
/*!40000 ALTER TABLE `expenses_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_tag_seq`
--

LOCK TABLES `expenses_tag_seq` WRITE;
/*!40000 ALTER TABLE `expenses_tag_seq` DISABLE KEYS */;
INSERT INTO `expenses_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_tasks`
--

LOCK TABLES `expenses_tasks` WRITE;
/*!40000 ALTER TABLE `expenses_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_tasks_seq`
--

LOCK TABLES `expenses_tasks_seq` WRITE;
/*!40000 ALTER TABLE `expenses_tasks_seq` DISABLE KEYS */;
INSERT INTO `expenses_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_topic`
--

LOCK TABLES `expenses_topic` WRITE;
/*!40000 ALTER TABLE `expenses_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `expenses_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_topic_seq`
--

LOCK TABLES `expenses_topic_seq` WRITE;
/*!40000 ALTER TABLE `expenses_topic_seq` DISABLE KEYS */;
INSERT INTO `expenses_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `expenses_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_user`
--

LOCK TABLES `expenses_user` WRITE;
/*!40000 ALTER TABLE `expenses_user` DISABLE KEYS */;
INSERT INTO `expenses_user` VALUES (1,'2023-06-04 22:20:08',1,1),(2,'2023-06-04 22:20:20',2,1),(3,'2023-06-04 22:20:26',3,1),(4,'2023-06-04 22:20:33',4,1),(5,'2023-06-04 22:20:38',5,1);
/*!40000 ALTER TABLE `expenses_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `expenses_user_seq`
--

LOCK TABLES `expenses_user_seq` WRITE;
/*!40000 ALTER TABLE `expenses_user_seq` DISABLE KEYS */;
INSERT INTO `expenses_user_seq` VALUES (6);
/*!40000 ALTER TABLE `expenses_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link`
--

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_history_seq`
--

LOCK TABLES `link_history_seq` WRITE;
/*!40000 ALTER TABLE `link_history_seq` DISABLE KEYS */;
INSERT INTO `link_history_seq` VALUES (1);
/*!40000 ALTER TABLE `link_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_reminder`
--

LOCK TABLES `link_reminder` WRITE;
/*!40000 ALTER TABLE `link_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `link_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_reminder_seq`
--

LOCK TABLES `link_reminder_seq` WRITE;
/*!40000 ALTER TABLE `link_reminder_seq` DISABLE KEYS */;
INSERT INTO `link_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `link_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_seq`
--

LOCK TABLES `link_seq` WRITE;
/*!40000 ALTER TABLE `link_seq` DISABLE KEYS */;
INSERT INTO `link_seq` VALUES (1);
/*!40000 ALTER TABLE `link_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_tag`
--

LOCK TABLES `link_tag` WRITE;
/*!40000 ALTER TABLE `link_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `link_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_tag_seq`
--

LOCK TABLES `link_tag_seq` WRITE;
/*!40000 ALTER TABLE `link_tag_seq` DISABLE KEYS */;
INSERT INTO `link_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `link_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_tasks`
--

LOCK TABLES `link_tasks` WRITE;
/*!40000 ALTER TABLE `link_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `link_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_tasks_seq`
--

LOCK TABLES `link_tasks_seq` WRITE;
/*!40000 ALTER TABLE `link_tasks_seq` DISABLE KEYS */;
INSERT INTO `link_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `link_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_topic`
--

LOCK TABLES `link_topic` WRITE;
/*!40000 ALTER TABLE `link_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `link_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_topic_seq`
--

LOCK TABLES `link_topic_seq` WRITE;
/*!40000 ALTER TABLE `link_topic_seq` DISABLE KEYS */;
INSERT INTO `link_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `link_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_user`
--

LOCK TABLES `link_user` WRITE;
/*!40000 ALTER TABLE `link_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `link_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `link_user_seq`
--

LOCK TABLES `link_user_seq` WRITE;
/*!40000 ALTER TABLE `link_user_seq` DISABLE KEYS */;
INSERT INTO `link_user_seq` VALUES (1);
/*!40000 ALTER TABLE `link_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_history`
--

LOCK TABLES `note_history` WRITE;
/*!40000 ALTER TABLE `note_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `note_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_history_seq`
--

LOCK TABLES `note_history_seq` WRITE;
/*!40000 ALTER TABLE `note_history_seq` DISABLE KEYS */;
INSERT INTO `note_history_seq` VALUES (1);
/*!40000 ALTER TABLE `note_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_remainder`
--

LOCK TABLES `note_remainder` WRITE;
/*!40000 ALTER TABLE `note_remainder` DISABLE KEYS */;
/*!40000 ALTER TABLE `note_remainder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_remainder_seq`
--

LOCK TABLES `note_remainder_seq` WRITE;
/*!40000 ALTER TABLE `note_remainder_seq` DISABLE KEYS */;
INSERT INTO `note_remainder_seq` VALUES (1);
/*!40000 ALTER TABLE `note_remainder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_seq`
--

LOCK TABLES `note_seq` WRITE;
/*!40000 ALTER TABLE `note_seq` DISABLE KEYS */;
INSERT INTO `note_seq` VALUES (1);
/*!40000 ALTER TABLE `note_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_tag`
--

LOCK TABLES `note_tag` WRITE;
/*!40000 ALTER TABLE `note_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `note_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_tag_seq`
--

LOCK TABLES `note_tag_seq` WRITE;
/*!40000 ALTER TABLE `note_tag_seq` DISABLE KEYS */;
INSERT INTO `note_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `note_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_user`
--

LOCK TABLES `note_user` WRITE;
/*!40000 ALTER TABLE `note_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `note_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `note_user_seq`
--

LOCK TABLES `note_user_seq` WRITE;
/*!40000 ALTER TABLE `note_user_seq` DISABLE KEYS */;
INSERT INTO `note_user_seq` VALUES (1);
/*!40000 ALTER TABLE `note_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_history_seq`
--

LOCK TABLES `person_history_seq` WRITE;
/*!40000 ALTER TABLE `person_history_seq` DISABLE KEYS */;
INSERT INTO `person_history_seq` VALUES (1);
/*!40000 ALTER TABLE `person_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_reminder`
--

LOCK TABLES `person_reminder` WRITE;
/*!40000 ALTER TABLE `person_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_reminder_seq`
--

LOCK TABLES `person_reminder_seq` WRITE;
/*!40000 ALTER TABLE `person_reminder_seq` DISABLE KEYS */;
INSERT INTO `person_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `person_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_seq`
--

LOCK TABLES `person_seq` WRITE;
/*!40000 ALTER TABLE `person_seq` DISABLE KEYS */;
INSERT INTO `person_seq` VALUES (1);
/*!40000 ALTER TABLE `person_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_tag`
--

LOCK TABLES `person_tag` WRITE;
/*!40000 ALTER TABLE `person_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_tag_seq`
--

LOCK TABLES `person_tag_seq` WRITE;
/*!40000 ALTER TABLE `person_tag_seq` DISABLE KEYS */;
INSERT INTO `person_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `person_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_tasks`
--

LOCK TABLES `person_tasks` WRITE;
/*!40000 ALTER TABLE `person_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_tasks_seq`
--

LOCK TABLES `person_tasks_seq` WRITE;
/*!40000 ALTER TABLE `person_tasks_seq` DISABLE KEYS */;
INSERT INTO `person_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `person_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_topic`
--

LOCK TABLES `person_topic` WRITE;
/*!40000 ALTER TABLE `person_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_topic_seq`
--

LOCK TABLES `person_topic_seq` WRITE;
/*!40000 ALTER TABLE `person_topic_seq` DISABLE KEYS */;
INSERT INTO `person_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `person_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_user`
--

LOCK TABLES `person_user` WRITE;
/*!40000 ALTER TABLE `person_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `person_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_user_seq`
--

LOCK TABLES `person_user_seq` WRITE;
/*!40000 ALTER TABLE `person_user_seq` DISABLE KEYS */;
INSERT INTO `person_user_seq` VALUES (1);
/*!40000 ALTER TABLE `person_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reminder`
--

LOCK TABLES `reminder` WRITE;
/*!40000 ALTER TABLE `reminder` DISABLE KEYS */;
INSERT INTO `reminder` VALUES (1,'2023-06-04 16:02:50','reminder1',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'2023-06-04 16:03:00','reminder2',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'2023-06-04 16:03:04','reminder3',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'2023-06-04 16:03:07','reminder4',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'2023-06-04 16:03:09','reminder5',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reminder_history`
--

LOCK TABLES `reminder_history` WRITE;
/*!40000 ALTER TABLE `reminder_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `reminder_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reminder_history_seq`
--

LOCK TABLES `reminder_history_seq` WRITE;
/*!40000 ALTER TABLE `reminder_history_seq` DISABLE KEYS */;
INSERT INTO `reminder_history_seq` VALUES (1);
/*!40000 ALTER TABLE `reminder_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reminder_seq`
--

LOCK TABLES `reminder_seq` WRITE;
/*!40000 ALTER TABLE `reminder_seq` DISABLE KEYS */;
INSERT INTO `reminder_seq` VALUES (6);
/*!40000 ALTER TABLE `reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reminder_user`
--

LOCK TABLES `reminder_user` WRITE;
/*!40000 ALTER TABLE `reminder_user` DISABLE KEYS */;
INSERT INTO `reminder_user` VALUES (1,'2023-06-04 16:02:50',1,1),(2,'2023-06-04 16:02:50',2,1),(3,'2023-06-04 16:02:50',3,1),(4,'2023-06-04 16:02:50',4,1),(5,'2023-06-04 16:02:50',5,1);
/*!40000 ALTER TABLE `reminder_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `reminder_user_seq`
--

LOCK TABLES `reminder_user_seq` WRITE;
/*!40000 ALTER TABLE `reminder_user_seq` DISABLE KEYS */;
INSERT INTO `reminder_user_seq` VALUES (1);
/*!40000 ALTER TABLE `reminder_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,0),(2,1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role_seq`
--

LOCK TABLES `role_seq` WRITE;
/*!40000 ALTER TABLE `role_seq` DISABLE KEYS */;
INSERT INTO `role_seq` VALUES (3);
/*!40000 ALTER TABLE `role_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `snooze`
--

LOCK TABLES `snooze` WRITE;
/*!40000 ALTER TABLE `snooze` DISABLE KEYS */;
/*!40000 ALTER TABLE `snooze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `snooze_seq`
--

LOCK TABLES `snooze_seq` WRITE;
/*!40000 ALTER TABLE `snooze_seq` DISABLE KEYS */;
INSERT INTO `snooze_seq` VALUES (1);
/*!40000 ALTER TABLE `snooze_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'2023-06-04 15:51:35','tag1',1),(2,'2023-06-04 15:51:45','tag2',1),(3,'2023-06-04 15:51:48','tag3',1),(4,'2023-06-04 15:51:52','tag4',1),(5,'2023-06-04 15:58:25','tag5',1);
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag_history`
--

LOCK TABLES `tag_history` WRITE;
/*!40000 ALTER TABLE `tag_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag_history_seq`
--

LOCK TABLES `tag_history_seq` WRITE;
/*!40000 ALTER TABLE `tag_history_seq` DISABLE KEYS */;
INSERT INTO `tag_history_seq` VALUES (1);
/*!40000 ALTER TABLE `tag_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag_seq`
--

LOCK TABLES `tag_seq` WRITE;
/*!40000 ALTER TABLE `tag_seq` DISABLE KEYS */;
INSERT INTO `tag_seq` VALUES (6);
/*!40000 ALTER TABLE `tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag_user`
--

LOCK TABLES `tag_user` WRITE;
/*!40000 ALTER TABLE `tag_user` DISABLE KEYS */;
INSERT INTO `tag_user` VALUES (1,'2023-06-04 15:51:35',1,1),(2,'2023-06-04 15:51:45',2,1),(3,'2023-06-04 15:51:48',3,1),(4,'2023-06-04 15:51:52',4,1),(5,'2023-06-04 15:58:25',5,1);
/*!40000 ALTER TABLE `tag_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag_user_seq`
--

LOCK TABLES `tag_user_seq` WRITE;
/*!40000 ALTER TABLE `tag_user_seq` DISABLE KEYS */;
INSERT INTO `tag_user_seq` VALUES (6);
/*!40000 ALTER TABLE `tag_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'2023-06-04 20:15:22',NULL,NULL,'tasks1',NULL,1),(2,'2023-06-04 20:15:31',NULL,NULL,'tasks2',NULL,1),(3,'2023-06-04 20:15:35',NULL,NULL,'tasks3',NULL,1),(4,'2023-06-04 20:15:38',NULL,NULL,'tasks4',NULL,1),(5,'2023-06-04 20:15:58',NULL,NULL,'tasks5',NULL,1);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_history`
--

LOCK TABLES `task_history` WRITE;
/*!40000 ALTER TABLE `task_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_history_seq`
--

LOCK TABLES `task_history_seq` WRITE;
/*!40000 ALTER TABLE `task_history_seq` DISABLE KEYS */;
INSERT INTO `task_history_seq` VALUES (1);
/*!40000 ALTER TABLE `task_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_reminder`
--

LOCK TABLES `task_reminder` WRITE;
/*!40000 ALTER TABLE `task_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_reminder_seq`
--

LOCK TABLES `task_reminder_seq` WRITE;
/*!40000 ALTER TABLE `task_reminder_seq` DISABLE KEYS */;
INSERT INTO `task_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `task_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_seq`
--

LOCK TABLES `task_seq` WRITE;
/*!40000 ALTER TABLE `task_seq` DISABLE KEYS */;
INSERT INTO `task_seq` VALUES (1);
/*!40000 ALTER TABLE `task_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_tag`
--

LOCK TABLES `task_tag` WRITE;
/*!40000 ALTER TABLE `task_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_tag_seq`
--

LOCK TABLES `task_tag_seq` WRITE;
/*!40000 ALTER TABLE `task_tag_seq` DISABLE KEYS */;
INSERT INTO `task_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `task_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_topic`
--

LOCK TABLES `task_topic` WRITE;
/*!40000 ALTER TABLE `task_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_topic_seq`
--

LOCK TABLES `task_topic_seq` WRITE;
/*!40000 ALTER TABLE `task_topic_seq` DISABLE KEYS */;
INSERT INTO `task_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `task_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_user`
--

LOCK TABLES `task_user` WRITE;
/*!40000 ALTER TABLE `task_user` DISABLE KEYS */;
INSERT INTO `task_user` VALUES (1,'2023-06-04 20:15:22',1,1),(2,'2023-06-04 20:15:31',2,1),(3,'2023-06-04 20:15:35',3,1),(4,'2023-06-04 20:15:38',4,1),(5,'2023-06-04 20:15:58',5,1);
/*!40000 ALTER TABLE `task_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_user_seq`
--

LOCK TABLES `task_user_seq` WRITE;
/*!40000 ALTER TABLE `task_user_seq` DISABLE KEYS */;
INSERT INTO `task_user_seq` VALUES (6);
/*!40000 ALTER TABLE `task_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_work`
--

LOCK TABLES `task_work` WRITE;
/*!40000 ALTER TABLE `task_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_work_seq`
--

LOCK TABLES `task_work_seq` WRITE;
/*!40000 ALTER TABLE `task_work_seq` DISABLE KEYS */;
INSERT INTO `task_work_seq` VALUES (1);
/*!40000 ALTER TABLE `task_work_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'2023-06-04 20:20:34',NULL,NULL,'tasks1',NULL,1),(2,'2023-06-04 20:20:40',NULL,NULL,'tasks2',NULL,1),(3,'2023-06-04 20:20:48',NULL,NULL,'tasks3',NULL,1),(4,'2023-06-04 20:20:54',NULL,NULL,'tasks4',NULL,1),(5,'2023-06-04 20:20:58',NULL,NULL,'tasks5',NULL,1);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_history_seq`
--

LOCK TABLES `tasks_history_seq` WRITE;
/*!40000 ALTER TABLE `tasks_history_seq` DISABLE KEYS */;
INSERT INTO `tasks_history_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_reminder`
--

LOCK TABLES `tasks_reminder` WRITE;
/*!40000 ALTER TABLE `tasks_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_reminder_seq`
--

LOCK TABLES `tasks_reminder_seq` WRITE;
/*!40000 ALTER TABLE `tasks_reminder_seq` DISABLE KEYS */;
INSERT INTO `tasks_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_seq`
--

LOCK TABLES `tasks_seq` WRITE;
/*!40000 ALTER TABLE `tasks_seq` DISABLE KEYS */;
INSERT INTO `tasks_seq` VALUES (6);
/*!40000 ALTER TABLE `tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_tag`
--

LOCK TABLES `tasks_tag` WRITE;
/*!40000 ALTER TABLE `tasks_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_tag_seq`
--

LOCK TABLES `tasks_tag_seq` WRITE;
/*!40000 ALTER TABLE `tasks_tag_seq` DISABLE KEYS */;
INSERT INTO `tasks_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_task`
--

LOCK TABLES `tasks_task` WRITE;
/*!40000 ALTER TABLE `tasks_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_task_seq`
--

LOCK TABLES `tasks_task_seq` WRITE;
/*!40000 ALTER TABLE `tasks_task_seq` DISABLE KEYS */;
INSERT INTO `tasks_task_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_task_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_topic`
--

LOCK TABLES `tasks_topic` WRITE;
/*!40000 ALTER TABLE `tasks_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_topic_seq`
--

LOCK TABLES `tasks_topic_seq` WRITE;
/*!40000 ALTER TABLE `tasks_topic_seq` DISABLE KEYS */;
INSERT INTO `tasks_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `tasks_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_user`
--

LOCK TABLES `tasks_user` WRITE;
/*!40000 ALTER TABLE `tasks_user` DISABLE KEYS */;
INSERT INTO `tasks_user` VALUES (1,'2023-06-04 20:20:34',1,1),(2,'2023-06-04 20:20:40',2,1),(3,'2023-06-04 20:20:48',3,1),(4,'2023-06-04 20:20:54',4,1),(5,'2023-06-04 20:20:59',5,1);
/*!40000 ALTER TABLE `tasks_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks_user_seq`
--

LOCK TABLES `tasks_user_seq` WRITE;
/*!40000 ALTER TABLE `tasks_user_seq` DISABLE KEYS */;
INSERT INTO `tasks_user_seq` VALUES (6);
/*!40000 ALTER TABLE `tasks_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'2023-06-04 20:11:24','topic1',1),(2,'2023-06-04 20:11:32','topic2',1),(3,'2023-06-04 20:11:39','topic3',1),(4,'2023-06-04 20:11:45','topic33',1),(5,'2023-06-04 20:11:52','topic333',1);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_history`
--

LOCK TABLES `topic_history` WRITE;
/*!40000 ALTER TABLE `topic_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_history_seq`
--

LOCK TABLES `topic_history_seq` WRITE;
/*!40000 ALTER TABLE `topic_history_seq` DISABLE KEYS */;
INSERT INTO `topic_history_seq` VALUES (1);
/*!40000 ALTER TABLE `topic_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_note`
--

LOCK TABLES `topic_note` WRITE;
/*!40000 ALTER TABLE `topic_note` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic_note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_note_seq`
--

LOCK TABLES `topic_note_seq` WRITE;
/*!40000 ALTER TABLE `topic_note_seq` DISABLE KEYS */;
INSERT INTO `topic_note_seq` VALUES (1);
/*!40000 ALTER TABLE `topic_note_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_reminder`
--

LOCK TABLES `topic_reminder` WRITE;
/*!40000 ALTER TABLE `topic_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_reminder_seq`
--

LOCK TABLES `topic_reminder_seq` WRITE;
/*!40000 ALTER TABLE `topic_reminder_seq` DISABLE KEYS */;
INSERT INTO `topic_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `topic_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_seq`
--

LOCK TABLES `topic_seq` WRITE;
/*!40000 ALTER TABLE `topic_seq` DISABLE KEYS */;
INSERT INTO `topic_seq` VALUES (6);
/*!40000 ALTER TABLE `topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_tag`
--

LOCK TABLES `topic_tag` WRITE;
/*!40000 ALTER TABLE `topic_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_tag_seq`
--

LOCK TABLES `topic_tag_seq` WRITE;
/*!40000 ALTER TABLE `topic_tag_seq` DISABLE KEYS */;
INSERT INTO `topic_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `topic_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_user`
--

LOCK TABLES `topic_user` WRITE;
/*!40000 ALTER TABLE `topic_user` DISABLE KEYS */;
INSERT INTO `topic_user` VALUES (1,'2023-06-04 20:11:24',1,1),(2,'2023-06-04 20:11:32',2,1),(3,'2023-06-04 20:11:39',3,1),(4,'2023-06-04 20:11:45',4,1),(5,'2023-06-04 20:11:52',5,1);
/*!40000 ALTER TABLE `topic_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topic_user_seq`
--

LOCK TABLES `topic_user_seq` WRITE;
/*!40000 ALTER TABLE `topic_user_seq` DISABLE KEYS */;
INSERT INTO `topic_user_seq` VALUES (6);
/*!40000 ALTER TABLE `topic_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'2023-06-04 22:26:17','transaction1',1),(2,'2023-06-04 22:26:27','transaction2',1),(3,'2023-06-04 22:26:34','transaction3',1),(4,'2023-06-04 22:26:39','transaction4',1),(5,'2023-06-04 22:26:47','transaction5',1);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_history_seq`
--

LOCK TABLES `transaction_history_seq` WRITE;
/*!40000 ALTER TABLE `transaction_history_seq` DISABLE KEYS */;
INSERT INTO `transaction_history_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_reminder`
--

LOCK TABLES `transaction_reminder` WRITE;
/*!40000 ALTER TABLE `transaction_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_reminder_seq`
--

LOCK TABLES `transaction_reminder_seq` WRITE;
/*!40000 ALTER TABLE `transaction_reminder_seq` DISABLE KEYS */;
INSERT INTO `transaction_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_seq`
--

LOCK TABLES `transaction_seq` WRITE;
/*!40000 ALTER TABLE `transaction_seq` DISABLE KEYS */;
INSERT INTO `transaction_seq` VALUES (6);
/*!40000 ALTER TABLE `transaction_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_tag`
--

LOCK TABLES `transaction_tag` WRITE;
/*!40000 ALTER TABLE `transaction_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_tag_seq`
--

LOCK TABLES `transaction_tag_seq` WRITE;
/*!40000 ALTER TABLE `transaction_tag_seq` DISABLE KEYS */;
INSERT INTO `transaction_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_tasks`
--

LOCK TABLES `transaction_tasks` WRITE;
/*!40000 ALTER TABLE `transaction_tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_tasks_seq`
--

LOCK TABLES `transaction_tasks_seq` WRITE;
/*!40000 ALTER TABLE `transaction_tasks_seq` DISABLE KEYS */;
INSERT INTO `transaction_tasks_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_tasks_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_topic`
--

LOCK TABLES `transaction_topic` WRITE;
/*!40000 ALTER TABLE `transaction_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_topic_seq`
--

LOCK TABLES `transaction_topic_seq` WRITE;
/*!40000 ALTER TABLE `transaction_topic_seq` DISABLE KEYS */;
INSERT INTO `transaction_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_user`
--

LOCK TABLES `transaction_user` WRITE;
/*!40000 ALTER TABLE `transaction_user` DISABLE KEYS */;
INSERT INTO `transaction_user` VALUES (1,'2023-06-04 22:26:17',1,1),(2,'2023-06-04 22:26:27',2,1),(3,'2023-06-04 22:26:34',3,1),(4,'2023-06-04 22:26:39',4,1),(5,'2023-06-04 22:26:47',5,1);
/*!40000 ALTER TABLE `transaction_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_user_seq`
--

LOCK TABLES `transaction_user_seq` WRITE;
/*!40000 ALTER TABLE `transaction_user_seq` DISABLE KEYS */;
INSERT INTO `transaction_user_seq` VALUES (6);
/*!40000 ALTER TABLE `transaction_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'$2a$12$sJZ7/SZpCOTSeMg1jos87ulm.OcN31uQKnYisY/5r5XlNXSoQKPRi','User1'),(2,NULL,'$2a$12$gaUsXx4r4JlzHYXomu/XguBgQZbj2XXOWq5h683u7KCOPUozoRy56','User2'),(3,NULL,'$2a$12$b/jcMc9LC8sTk.8mV6Mzv.0GFCqgD7O/oK6m96nojFVKuGj8LlJv2','User3');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'2023-06-04 15:43:59',1,1),(2,'2023-06-04 15:43:59',2,1),(3,'2023-06-04 15:43:59',2,2),(4,'2023-06-04 15:43:59',1,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role_seq`
--

LOCK TABLES `user_role_seq` WRITE;
/*!40000 ALTER TABLE `user_role_seq` DISABLE KEYS */;
INSERT INTO `user_role_seq` VALUES (5);
/*!40000 ALTER TABLE `user_role_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (4);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_user`
--

LOCK TABLES `user_user` WRITE;
/*!40000 ALTER TABLE `user_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_user_seq`
--

LOCK TABLES `user_user_seq` WRITE;
/*!40000 ALTER TABLE `user_user_seq` DISABLE KEYS */;
INSERT INTO `user_user_seq` VALUES (1);
/*!40000 ALTER TABLE `user_user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_history`
--

LOCK TABLES `work_history` WRITE;
/*!40000 ALTER TABLE `work_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_history_seq`
--

LOCK TABLES `work_history_seq` WRITE;
/*!40000 ALTER TABLE `work_history_seq` DISABLE KEYS */;
INSERT INTO `work_history_seq` VALUES (1);
/*!40000 ALTER TABLE `work_history_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_reminder`
--

LOCK TABLES `work_reminder` WRITE;
/*!40000 ALTER TABLE `work_reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_reminder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_reminder_seq`
--

LOCK TABLES `work_reminder_seq` WRITE;
/*!40000 ALTER TABLE `work_reminder_seq` DISABLE KEYS */;
INSERT INTO `work_reminder_seq` VALUES (1);
/*!40000 ALTER TABLE `work_reminder_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_seq`
--

LOCK TABLES `work_seq` WRITE;
/*!40000 ALTER TABLE `work_seq` DISABLE KEYS */;
INSERT INTO `work_seq` VALUES (1);
/*!40000 ALTER TABLE `work_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_tag`
--

LOCK TABLES `work_tag` WRITE;
/*!40000 ALTER TABLE `work_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_tag_seq`
--

LOCK TABLES `work_tag_seq` WRITE;
/*!40000 ALTER TABLE `work_tag_seq` DISABLE KEYS */;
INSERT INTO `work_tag_seq` VALUES (1);
/*!40000 ALTER TABLE `work_tag_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_topic`
--

LOCK TABLES `work_topic` WRITE;
/*!40000 ALTER TABLE `work_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_topic_seq`
--

LOCK TABLES `work_topic_seq` WRITE;
/*!40000 ALTER TABLE `work_topic_seq` DISABLE KEYS */;
INSERT INTO `work_topic_seq` VALUES (1);
/*!40000 ALTER TABLE `work_topic_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `work_user`
--

LOCK TABLES `work_user` WRITE;
/*!40000 ALTER TABLE `work_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_user` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2023-06-05 10:52:48
