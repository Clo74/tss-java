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
-- Table structure for table `t_corsi`
--

DROP TABLE IF EXISTS `t_corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_corsi` (
  `id_corso` int(11) NOT NULL AUTO_INCREMENT,
  `nome_corso` varchar(100) NOT NULL,
  `id_sede` int(11) NOT NULL,
  `edizione` varchar(45) DEFAULT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date NOT NULL,
  `note_corso` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id_corso`),
  KEY `idx_corso` (`nome_corso`),
  KEY `idx_sede` (`id_sede`),
  CONSTRAINT `fk_t_corsi_1` FOREIGN KEY (`id_sede`) REFERENCES `t_sedi` (`id_sede`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_corsi`
--

LOCK TABLES `t_corsi` WRITE;
/*!40000 ALTER TABLE `t_corsi` DISABLE KEYS */;
INSERT INTO `t_corsi` VALUES (1,'TSS Programmatore Java javaEE',3,'2019','2018-12-01','2019-07-10','durante il corso verrà realizzato il progetto nostalciac'),(2,'Social media Marketing',2,'2019','2018-12-01','2019-07-10','cccc'),(3,'Cucina1',3,'2019','2018-07-05','2019-06-02','xxx'),(4,'Barman',3,'2019','2018-07-05','2019-06-02','specializzato in cocktails..'),(5,'Cucina1',3,'2019','2018-07-05','2019-06-02','xxx'),(6,'Barman',3,'2019','2018-07-05','2019-06-02','specializzato in cocktails..');
/*!40000 ALTER TABLE `t_corsi` ENABLE KEYS */;
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
