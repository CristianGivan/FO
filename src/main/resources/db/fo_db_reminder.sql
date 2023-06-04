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
-- Table structure for table `reminder`
--

DROP TABLE IF EXISTS `reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminder` (
  `reminder_id` bigint NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `reminder` varchar(255) DEFAULT NULL,
  `data_time` datetime DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `note_id` bigint DEFAULT NULL,
  `repeated_reminders` bigint DEFAULT NULL,
  `task_id` bigint DEFAULT NULL,
  `topic_id` bigint DEFAULT NULL,
  `tasks_id` bigint DEFAULT NULL,
  `work_id` bigint DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `expense_id` bigint DEFAULT NULL,
  `expenses_id` bigint DEFAULT NULL,
  `link_id` bigint DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  `transaction_id` bigint DEFAULT NULL,
  PRIMARY KEY (`reminder_id`),
  KEY `FKkv39lrjs52d15dqytgxl25bb1` (`user_id`),
  KEY `FK9g2h2g6oityvhhjb4bsrqi4rq` (`note_id`),
  KEY `FK4ycb9lmxnn1xyykovyxpf9eb0` (`repeated_reminders`),
  KEY `FKrme9n2jhm4lxi11qcn8u5mcgb` (`task_id`),
  KEY `FKsfcianxuhrqwj835cc2smpqgx` (`topic_id`),
  KEY `FKrrve4xsqodf3473cr0ot9r7u3` (`tasks_id`),
  KEY `FKm56oif64i6lt89dkjdsg6oc45` (`work_id`),
  KEY `FKt2sib5pb0by6i4uvwria99wus` (`account_id`),
  KEY `FK7g7uuajr7ub2e7krt44j7i1ai` (`event_id`),
  KEY `FKn672e74u5yg76qguxamu26igd` (`expense_id`),
  KEY `FK8crdrhqoxuipvw19kg2rvhmf4` (`expenses_id`),
  KEY `FKqfqrov7j3nyssi6193t1kxigq` (`link_id`),
  KEY `FK15pf8wf1i0chw5j61m2jxt2k` (`person_id`),
  KEY `FKdbayhmotm3gkqaiah5ix3l562` (`transaction_id`),
  CONSTRAINT `FK15pf8wf1i0chw5j61m2jxt2k` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FK4ycb9lmxnn1xyykovyxpf9eb0` FOREIGN KEY (`repeated_reminders`) REFERENCES `reminder` (`reminder_id`),
  CONSTRAINT `FK7g7uuajr7ub2e7krt44j7i1ai` FOREIGN KEY (`event_id`) REFERENCES `event` (`event_id`),
  CONSTRAINT `FK8crdrhqoxuipvw19kg2rvhmf4` FOREIGN KEY (`expenses_id`) REFERENCES `expenses` (`expenses_id`),
  CONSTRAINT `FK9g2h2g6oityvhhjb4bsrqi4rq` FOREIGN KEY (`note_id`) REFERENCES `note` (`note_id`),
  CONSTRAINT `FKdbayhmotm3gkqaiah5ix3l562` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  CONSTRAINT `FKkv39lrjs52d15dqytgxl25bb1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKm56oif64i6lt89dkjdsg6oc45` FOREIGN KEY (`work_id`) REFERENCES `work` (`work_id`),
  CONSTRAINT `FKn672e74u5yg76qguxamu26igd` FOREIGN KEY (`expense_id`) REFERENCES `expense` (`expense_id`),
  CONSTRAINT `FKqfqrov7j3nyssi6193t1kxigq` FOREIGN KEY (`link_id`) REFERENCES `link` (`link_id`),
  CONSTRAINT `FKrme9n2jhm4lxi11qcn8u5mcgb` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`),
  CONSTRAINT `FKrrve4xsqodf3473cr0ot9r7u3` FOREIGN KEY (`tasks_id`) REFERENCES `tasks` (`tasks_id`),
  CONSTRAINT `FKsfcianxuhrqwj835cc2smpqgx` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`),
  CONSTRAINT `FKt2sib5pb0by6i4uvwria99wus` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminder`
--

LOCK TABLES `reminder` WRITE;
/*!40000 ALTER TABLE `reminder` DISABLE KEYS */;
/*!40000 ALTER TABLE `reminder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 13:46:16
