-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: nostalciac
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_sedi`
--

DROP TABLE IF EXISTS `t_sedi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sedi` (
  `id_sede` int(11) NOT NULL AUTO_INCREMENT,
  `sede` varchar(100) NOT NULL,
  `indirizzo_sede` varchar(100) NOT NULL,
  `tel_sede` varchar(45) NOT NULL,
  `mail_sede` varchar(60) DEFAULT NULL,
  `note_sede` varchar(2000) DEFAULT NULL,
  `citta` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_sede`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sedi`
--

LOCK TABLES `t_sedi` WRITE;
/*!40000 ALTER TABLE `t_sedi` DISABLE KEYS */;
INSERT INTO `t_sedi` VALUES (1,'Carlo Ghiglieno - digital','Via Sant’Arborio Varmondo, 3 ','+39 0125 642934 ',NULL,NULL,'Ivrea'),(2,'Ferdinando Prat','Via Sant’Arborio Varmondo, 3 ','+39 0125 642934',NULL,NULL,'Ivrea'),(3,'Davide Negro','Via Battitore 82 ','+39 011 9214534',NULL,NULL,'Cirie'),(4,'nuova sede','test..','test..','test..','test..','test..');
/*!40000 ALTER TABLE `t_sedi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-05 16:19:25
