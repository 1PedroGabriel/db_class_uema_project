-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: project
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.27-MariaDB

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
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` varchar(100) NOT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `active` tinyint(1) DEFAULT 1,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `institutional_email` varchar(100) NOT NULL,
  `position` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Bibliotecária Maria','maria@biblioteca.com','','$2y$10$hash1',1,'2025-05-29 21:16:59','2025-05-29 21:16:59','',''),(2,'João Admin','joao@admin.com','','$2y$10$hash2',1,'2025-05-29 21:16:59','2025-05-29 21:16:59','',''),(3,'Pedro','Ledro@gmail.com','','$2a$10$fU/Fyk6.jUyIVe6T0j21EOz9i9fxQmbAgRmq/DUddUG72XJMPGgK6',1,'2025-06-10 21:26:40','2025-06-10 21:26:40','',''),(4,'Jorge','Jorge@gmail.com','Cataloger','$2a$10$pi10ofzkXZYjfDG8E1OMPubB0vqaicQPyWkRySveg.rVfaDNhUmdu',1,'2025-06-11 01:58:15','2025-07-12 00:40:40','',''),(5,'Pedro','Pedro@gmail.com','Librarian','$2a$10$HNXev876HEFh4mRSjQ7epeywtNMuybBh7LAeC7WFz6yEueeRn/Fwi',1,'2025-06-11 02:41:52','2025-07-12 00:40:40','','');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  `active` tinyint(1) DEFAULT 1,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Ana Silva','ana.silva@email.com','123.456.789-00','11999990001','Rua das Flores, 100','1995-03-12','2024-05-01',1,'2025-05-29 21:16:59','2025-05-29 21:16:59'),(2,'Carlos Lima','carlos.lima@email.com','987.654.321-00','11999990002','Av. Central, 200','1988-07-22','2024-05-02',1,'2025-05-29 21:16:59','2025-05-29 21:16:59');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (4,'Tecnologia','Categoria relacionada a inovações tecnológicas.','2025-07-11 16:12:18','2025-07-11 16:12:18'),(5,'Literatura','Livros e obras literárias clássicas e contemporâneas.','2025-07-11 16:12:18','2025-07-11 16:12:18'),(6,'Ciência','Assuntos relacionados às ciências exatas e naturais.','2025-07-11 16:12:18','2025-07-11 16:12:18'),(7,'História','Tópicos históricos e civilizações antigas.','2025-07-11 16:12:18','2025-07-11 16:12:18'),(8,'Artes','Expressões artísticas como pintura, escultura e música.','2025-07-11 16:12:18','2025-07-11 16:12:18');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fines`
--


--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(20) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `authors` text NOT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `publication_year` int(11) DEFAULT NULL,
  `edition` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `summary` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `quantity` int(3) DEFAULT NULL,
  `available_quantity` int(3) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_books_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (69,'9780172980884','Clean Code','A Handbook of Agile Software Craftsmanship','Robert C. Martin','Prentice Hall',2008,'1st','English',464,'Guia prático para escrever código limpo e sustentável.','2025-07-11 17:24:52','2025-07-12 00:39:58',1,1,4),(71,'9780134685991','Effective Java','Programming Language Guide','Joshua Bloch','Addison-Wesley',2018,'3rd','English',416,'Best practices for writing robust Java code.','2025-07-11 23:42:00','2025-07-12 00:39:58',6,6,4),(72,'9781492078005','Designing Data-Intensive Applications','The Big Ideas Behind Reliable, Scalable, and Maintainable Systems','Martin Kleppmann','O\'Reilly Media',2021,'1st','English',616,'Data modeling, storage engines, distributed systems.','2025-07-11 23:42:00','2025-07-12 00:39:58',5,4,4),(73,'9781449355739','Fluent Python','Clear, Concise, and Effective Programming','Luciano Ramalho','O\'Reilly Media',2015,'1st','English',792,'Deep dive into Python programming idioms and patterns.','2025-07-11 23:42:00','2025-07-12 00:39:58',4,3,4),(74,'9781491950357','Clean Architecture','A Craftsman\'s Guide to Software Structure and Design','Robert C. Martin','Pearson',2017,'1st','English',432,'Architectural patterns and principles for scalable systems.','2025-07-11 23:42:00','2025-07-12 00:39:58',7,6,4),(75,'9780596007126','Head First Design Patterns','A Brain-Friendly Guide','Eric Freeman, Elisabeth Robson','O\'Reilly Media',2004,'1st','English',694,'Engaging exploration of classic design patterns in Java.','2025-07-11 23:42:00','2025-07-12 00:39:58',5,5,4),(76,'9780132350884','Clean Code','A Handbook of Agile Software Craftsmanship','Robert C. Martin','Prentice Hall',2008,'1st','English',464,'Principles and practices of writing clean and maintainable code.','2025-07-11 23:42:00','2025-07-11 23:42:00',7,7,4),(77,'9780131103627','The C Programming Language','Classic Reference Guide','Brian W. Kernighan, Dennis M. Ritchie','Prentice Hall',1988,'2nd','English',274,'Foundational text on C language and systems programming.','2025-07-11 23:42:00','2025-07-11 23:42:00',5,5,4);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_copies`
--

DROP TABLE IF EXISTS `book_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_copies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `copy_code` varchar(255) NOT NULL,
  `shelf_location` varchar(255) DEFAULT NULL,
  `status` enum('available','borrowed','reserved','lost','maintenance') DEFAULT 'available',
  `acquisition_date` date DEFAULT NULL,
  `condition_notes` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `copy_code` (`copy_code`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `book_copies_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_copies`
--

LOCK TABLES `book_copies` WRITE;
/*!40000 ALTER TABLE `book_copies` DISABLE KEYS */;
INSERT INTO `book_copies` VALUES (47,69,'EJ-001','A1','available','2022-01-15','Good condition','2025-07-12 00:39:58','2025-07-12 00:39:58'),(48,71,'FP-001','C2','available','2023-03-01','Like new','2025-07-12 00:39:58','2025-07-12 00:39:58'),(49,72,'CA-001','A4','reserved','2020-06-12','Used but functional','2025-07-12 00:39:58','2025-07-12 00:39:58'),(50,73,'HFDP-001','D1','lost','2019-09-20','Lost in inventory','2025-07-12 00:39:58','2025-07-12 00:39:58'),(51,74,'CC-001','B1','maintenance','2021-01-01','Pages torn','2025-07-12 00:39:58','2025-07-12 00:39:58'),(52,75,'TCPL-001','A2','available','2018-10-05','Good shape','2025-07-12 00:39:58','2025-07-12 00:39:58');
/*!40000 ALTER TABLE `book_copies` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `requested_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `fulfilled_at` timestamp NULL DEFAULT NULL,
  `cancelled_at` timestamp NULL DEFAULT NULL,
  `status` enum('pending','fulfilled','cancelled') DEFAULT 'pending',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `end_date` datetime(6) NOT NULL,
  `start_date` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (16,69,1,'2024-06-01 13:00:00',NULL,NULL,'pending','2025-07-12 00:54:27','2025-07-12 00:54:27','0000-00-00 00:00:00.000000','0000-00-00 00:00:00.000000'),(17,71,2,'2024-05-15 17:30:00','2024-05-16 12:00:00',NULL,'fulfilled','2025-07-12 00:54:27','2025-07-12 00:54:27','2024-06-16 09:00:00.000000','2024-05-16 09:00:00.000000'),(18,72,1,'2024-05-10 14:45:00',NULL,'2024-05-11 16:00:00','cancelled','2025-07-12 00:54:27','2025-07-12 00:54:27','0000-00-00 00:00:00.000000','0000-00-00 00:00:00.000000'),(19,73,2,'2024-06-05 11:00:00',NULL,NULL,'pending','2025-07-12 00:54:27','2025-07-12 00:54:27','0000-00-00 00:00:00.000000','0000-00-00 00:00:00.000000'),(20,74,1,'2024-06-07 15:20:00','2024-06-08 13:00:00',NULL,'fulfilled','2025-07-12 00:54:27','2025-07-12 00:54:27','2024-07-08 10:00:00.000000','2024-06-08 10:00:00.000000'),(21,75,2,'2024-04-20 12:15:00',NULL,'2024-04-21 18:30:00','cancelled','2025-07-12 00:54:27','2025-07-12 00:54:27','0000-00-00 00:00:00.000000','0000-00-00 00:00:00.000000'),(22,76,1,'2024-06-10 19:45:00',NULL,NULL,'pending','2025-07-12 00:54:27','2025-07-12 00:54:27','0000-00-00 00:00:00.000000','0000-00-00 00:00:00.000000');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings`
--


DROP TABLE IF EXISTS `loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_copy_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `loan_date` date NOT NULL,
  `due_date` date NOT NULL,
  `return_date` date DEFAULT NULL,
  `returned_by` int(11) DEFAULT NULL,
  `status` enum('open','returned','overdue') DEFAULT 'open',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `book_copy_id` (`book_copy_id`),
  KEY `user_id` (`user_id`),
  KEY `staff_id` (`staff_id`),
  KEY `returned_by` (`returned_by`),
  CONSTRAINT `loans_ibfk_1` FOREIGN KEY (`book_copy_id`) REFERENCES `book_copies` (`id`),
  CONSTRAINT `loans_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `loans_ibfk_3` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `loans_ibfk_4` FOREIGN KEY (`returned_by`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` VALUES (17,47,1,4,'2024-06-01','2024-06-10',NULL,NULL,'open','2025-07-12 01:01:25','2025-07-12 01:01:25'),(18,48,2,4,'2024-05-01','2024-05-10','2024-05-09',4,'returned','2025-07-12 01:01:25','2025-07-12 01:01:25'),(19,49,1,4,'2024-04-20','2024-05-01',NULL,NULL,'overdue','2025-07-12 01:01:25','2025-07-12 01:01:25'),(20,50,2,4,'2024-06-05','2024-06-12',NULL,NULL,'open','2025-07-12 01:01:25','2025-07-12 01:01:25'),(21,51,1,4,'2024-03-10','2024-03-20','2024-03-19',4,'returned','2025-07-12 01:01:25','2025-07-12 01:01:25'),(22,52,2,4,'2024-04-01','2024-04-10',NULL,NULL,'overdue','2025-07-12 01:01:25','2025-07-12 01:01:25');
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;



DROP TABLE IF EXISTS `fines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loan_id` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `issued_at` date NOT NULL,
  `paid_at` date DEFAULT NULL,
  `status` enum('unpaid','paid') DEFAULT 'unpaid',
  `notes` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `loan_id` (`loan_id`),
  CONSTRAINT `fines_ibfk_1` FOREIGN KEY (`loan_id`) REFERENCES `loans` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fines`
--


LOCK TABLES `fines` WRITE;
/*!40000 ALTER TABLE `fines` DISABLE KEYS */;
INSERT INTO `fines` VALUES (9,17,10.00,'2024-06-11',NULL,'unpaid','Multa por atraso na devolução','2025-07-12 01:03:36','2025-07-12 01:03:36'),(10,18,5.00,'2024-05-11','2024-05-15','paid','Multa quitada pelo usuário','2025-07-12 01:03:36','2025-07-12 01:03:36'),(11,19,15.50,'2024-05-02',NULL,'unpaid','Atraso superior a 3 dias','2025-07-12 01:03:36','2025-07-12 01:03:36'),(12,20,8.75,'2024-06-13',NULL,'unpaid','Livro não devolvido até a data prevista','2025-07-12 01:03:36','2025-07-12 01:03:36'),(13,21,6.00,'2024-03-21','2024-03-25','paid','Pagamento realizado presencialmente','2025-07-12 01:03:36','2025-07-12 01:03:36'),(14,22,20.00,'2024-04-11',NULL,'unpaid','Multa acumulada','2025-07-12 01:03:36','2025-07-12 01:03:36');
/*!40000 ALTER TABLE `fines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loans`
--

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `max_loans_per_user` int(11) DEFAULT 5,
  `loan_period_days` int(11) DEFAULT 14,
  `fine_per_day` decimal(10,2) DEFAULT 0.50,
  `reservation_limit` int(11) DEFAULT 3,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` VALUES (1,3,7,1.50,2,'2025-05-29 21:16:59','2025-05-29 21:16:59');
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-11 22:25:38
