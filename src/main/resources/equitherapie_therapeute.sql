-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: equitherapie
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `therapeute`
--

DROP TABLE IF EXISTS `therapeute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `therapeute` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(800) NOT NULL,
  `nom` varchar(10) NOT NULL,
  `photo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmnjwb65e1agtppg92ws1hpmtq` (`photo_id`),
  CONSTRAINT `FKmnjwb65e1agtppg92ws1hpmtq` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `therapeute`
--

LOCK TABLES `therapeute` WRITE;
/*!40000 ALTER TABLE `therapeute` DISABLE KEYS */;
INSERT INTO `therapeute` VALUES (3,'Isatis est une jument qui  partage ma vie depuis 25 ans. Elle est très à l’écoute des émotions \r\ndes enfants. Sensible, extrêmement câline, joueuse et attachante, c’est une très bonne thérapeute','Isatis',3),(7,'\r\nJe suis réfléxologue et intervenante en méditaion équine. Passionnée par les chevaux, qui font partie de ma vie depuis mon enfance, je sais à quel point ils peuvent nous apporter du bien-être, du soutien, du lâcher-prise mais aussi de l’humilité, de la rigueur et de la persévérance. Les chevaux, leur contact, leur ancrage, leur compréhension de nos émotions m’ont sans aucun doute aidée à traverser différentes épreuves de ma vie. \r\nPassionnée également par le domaine de la santé et du soin, la méditation équine me permet de lier ces deux aspects en proposant aux enfants des activités thérapeutiques incluant le cheval. ','Godeline',10),(8,'\nNouvelle venue dans l’aventure... Moon est une ponette de 12 ans, elle est calme, posée et très patiente. Pour les plus petits, c’est une médiatrice extraordinaire.','Moon',11);
/*!40000 ALTER TABLE `therapeute` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-22 15:56:42
