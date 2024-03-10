-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: booklikes
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `idBook` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `creationDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `imageSource` varchar(255) DEFAULT NULL,
  `idUser` int NOT NULL,
  PRIMARY KEY (`idBook`),
  UNIQUE KEY `titulo_UNIQUE` (`title`),
  KEY `fk_Libros_Usuarios1_idx` (`idUser`),
  CONSTRAINT `fk_Libros_Usuarios1` FOREIGN KEY (`idUser`) REFERENCES `users` (`idUser`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Dune','Frank Herbert','Un tipo se va a marte y hace cosas','2024-03-05 17:39:39','dunePortada.jpg',1),(3,'Valeria','Elisabet Benavent','Un dia la echan del trabajo y encuentra al chongo','2024-03-05 17:39:39','valeriaPortada.jpg',3),(4,'Metro 2033','Dimitry Glukhovsky','Un ruso que no puede respirar y vive en un tunel con mas rusos','2024-03-08 13:11:17','metroPortada.jpg',1),(15,'Seis de cuervos','Leigh Bardugo','Seis tios robando cosas chulas','2024-03-09 22:14:29','seisCuervosPortada.jpg',2),(21,'Mis memorias','la vecinita tiene antojo','Una vecinita con mucho antojo','2024-03-09 23:45:24','misMemoriasPortada.jpg',8),(28,'Harry Potter y la Piedra Filosofal','J.K. Rowling','Unos magos dramaticos tienen aventuras sobrenaturales','2024-03-10 00:39:42','harryPotter.jpg',2),(29,'The Lord of the Rings','J.R.R. Tolkien','There is a guy who likes round metals very too much. LOL','2024-03-10 00:41:07','señorAnillosPortada.jpg',2),(34,'Mein Kampf','Adolf Hitler','Ein genialer Stratege enthüllt seine brillantesten Geheimnisse','2024-03-10 03:37:14','meinKampf.jpg',9),(40,'El retrato de Dorian Grey','Oscar Wilde','Homosexuales en celo pero en el 1800','2024-03-10 18:26:59','dorianGreyPortada.jpg',10);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `idComment` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) NOT NULL,
  `idUser` int NOT NULL,
  `idBook` int NOT NULL,
  `creationDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idComment`),
  KEY `fk_books_comments_idx` (`idBook`),
  KEY `fk_users_comments_idx` (`idUser`),
  CONSTRAINT `fk_books_comments` FOREIGN KEY (`idBook`) REFERENCES `books` (`idBook`) ON DELETE CASCADE,
  CONSTRAINT `fk_users_comments` FOREIGN KEY (`idUser`) REFERENCES `users` (`idUser`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'Good book',1,1,'2024-03-10 16:54:14'),(2,'Bad book',2,1,'2024-03-10 16:54:14');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `idUser` int NOT NULL,
  `idBook` int NOT NULL,
  `creationDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idUser`,`idBook`),
  KEY `fk_Usuarios_has_Libros_Libros1_idx` (`idBook`),
  KEY `fk_Usuarios_has_Libros_Usuarios_idx` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,1,'2024-03-06 19:26:44'),(1,2,'2024-03-06 19:26:44'),(1,3,'2024-03-06 19:26:44'),(1,4,'2024-03-10 14:36:50'),(1,15,'2024-03-10 14:36:54'),(1,28,'2024-03-10 14:36:55'),(1,29,'2024-03-10 14:37:02'),(1,34,'2024-03-10 03:38:31'),(2,2,'2024-03-06 19:26:44'),(2,4,'2024-03-10 03:35:16'),(2,15,'2024-03-10 03:32:48'),(2,28,'2024-03-10 14:26:52'),(2,29,'2024-03-10 14:32:52'),(2,30,'2024-03-10 02:05:27'),(2,33,'2024-03-10 03:32:43'),(2,34,'2024-03-10 03:37:37'),(2,35,'2024-03-10 15:29:39'),(2,38,'2024-03-10 15:55:01'),(3,2,'2024-03-06 19:52:10'),(3,3,'2024-03-06 19:26:44'),(3,34,'2024-03-10 03:38:31'),(4,34,'2024-03-10 03:38:31'),(5,34,'2024-03-10 03:38:31'),(6,34,'2024-03-10 03:38:31'),(7,34,'2024-03-10 03:38:31'),(8,34,'2024-03-10 03:38:31'),(9,34,'2024-03-10 03:37:19'),(10,4,'2024-03-10 17:53:32'),(10,34,'2024-03-10 17:53:11'),(10,39,'2024-03-10 17:55:23'),(10,40,'2024-03-10 18:27:11');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `creationDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user1','1234','user1@gmail.com','2024-03-05 17:39:03'),(2,'user2','1234','user2@gmail.com','2024-03-05 17:39:03'),(3,'user3','1234','user3@gmail.com','2024-03-05 17:39:03'),(4,'user4','1234','user4@gmail.com','2024-03-05 18:51:32'),(5,'user5','1234','user5@gmail.com','2024-03-05 19:34:26'),(6,'user6','1234','user6@gmail.com','2024-03-05 19:35:03'),(7,'user7','1234','user7@gmail.com','2024-03-09 18:19:37'),(8,'la vecinita tiene antojo','1234','a.rodriguez@hotmail.com','2024-03-09 23:43:18'),(9,'Adolf_Hitler','1234','aldolf@fuhrer.de','2024-03-10 03:36:19'),(10,'sofica','1234','sofica@hotmail.com','2024-03-10 17:52:35');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-10 19:12:53
