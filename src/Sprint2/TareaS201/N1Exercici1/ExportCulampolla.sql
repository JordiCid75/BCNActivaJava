CREATE DATABASE  IF NOT EXISTS `culampolla` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `culampolla`;
-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: culampolla
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Address` (
  `IdAddress` int NOT NULL AUTO_INCREMENT,
  `Carrer` varchar(100) DEFAULT NULL,
  `Numero` int DEFAULT NULL,
  `Pis` varchar(45) DEFAULT NULL,
  `Porta` varchar(45) DEFAULT NULL,
  `IdCiutat` int NOT NULL,
  `CodiPostal` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`IdAddress`),
  UNIQUE KEY `IdAddress_UNIQUE` (`IdAddress`),
  KEY `FK_Address_Ciutats_idx` (`IdCiutat`),
  CONSTRAINT `FK_Address_Ciutats` FOREIGN KEY (`IdCiutat`) REFERENCES `Ciutats` (`IdCiutat`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES (1,'Calle uno',1,'1º','2ª',2,'08005'),(2,'Calle dos',1,'2º','3ª',1,'08005');
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ciutats`
--

DROP TABLE IF EXISTS `Ciutats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ciutats` (
  `IdCiutat` int NOT NULL AUTO_INCREMENT,
  `IdPais` int NOT NULL,
  `NomCiutat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdCiutat`),
  UNIQUE KEY `IdCiutat_UNIQUE` (`IdCiutat`),
  KEY `FK_Ciutat_Pais_idx` (`IdPais`),
  CONSTRAINT `FK_Ciutat_Pais` FOREIGN KEY (`IdPais`) REFERENCES `Paisos` (`IdPais`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ciutats`
--

LOCK TABLES `Ciutats` WRITE;
/*!40000 ALTER TABLE `Ciutats` DISABLE KEYS */;
INSERT INTO `Ciutats` VALUES (1,1,'Barcelona'),(2,1,'Tarragona'),(3,2,'Zurich'),(4,3,'Roma');
/*!40000 ALTER TABLE `Ciutats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clients`
--

DROP TABLE IF EXISTS `Clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clients` (
  `IdClient` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) DEFAULT NULL,
  `IdAddress` int DEFAULT NULL,
  `Telefon` varchar(30) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `DataRegistre` datetime DEFAULT NULL,
  `IdClientRecomanat` int DEFAULT NULL,
  PRIMARY KEY (`IdClient`),
  UNIQUE KEY `IdClient_UNIQUE` (`IdClient`),
  KEY `FK_Clients_ClientRecomanat_idx` (`IdClientRecomanat`),
  KEY `FK_Clients_Address_idx` (`IdAddress`),
  CONSTRAINT `FK_Clients_Address` FOREIGN KEY (`IdAddress`) REFERENCES `Address` (`IdAddress`),
  CONSTRAINT `FK_Clients_ClientRecomanat` FOREIGN KEY (`IdClientRecomanat`) REFERENCES `Clients` (`IdClient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clients`
--

LOCK TABLES `Clients` WRITE;
/*!40000 ALTER TABLE `Clients` DISABLE KEYS */;
INSERT INTO `Clients` VALUES (1,'Client1',2,'3333333','emailclient1@client1.com','2023-11-06 11:12:04',NULL),(2,'Client2',1,'444444','emailclient2@client2.com','2023-11-06 11:12:04',NULL);
/*!40000 ALTER TABLE `Clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paisos`
--

DROP TABLE IF EXISTS `Paisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Paisos` (
  `IdPais` int NOT NULL AUTO_INCREMENT,
  `NomPais` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdPais`),
  UNIQUE KEY `IdPais_UNIQUE` (`IdPais`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paisos`
--

LOCK TABLES `Paisos` WRITE;
/*!40000 ALTER TABLE `Paisos` DISABLE KEYS */;
INSERT INTO `Paisos` VALUES (1,'Espanya'),(2,'Suissa'),(3,'Italia');
/*!40000 ALTER TABLE `Paisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveidor`
--

DROP TABLE IF EXISTS `Proveidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Proveidor` (
  `IdProveidor` int NOT NULL AUTO_INCREMENT,
  `IdAddress` int DEFAULT NULL,
  `Nom` varchar(255) NOT NULL,
  `Telefon` varchar(40) DEFAULT NULL,
  `Fax` varchar(40) DEFAULT NULL,
  `NIF` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IdProveidor`),
  UNIQUE KEY `IdProveidor_UNIQUE` (`IdProveidor`),
  KEY `FK_Proveidor_address_idx` (`IdAddress`),
  CONSTRAINT `FK_Proveidor_address` FOREIGN KEY (`IdAddress`) REFERENCES `Address` (`IdAddress`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveidor`
--

LOCK TABLES `Proveidor` WRITE;
/*!40000 ALTER TABLE `Proveidor` DISABLE KEYS */;
INSERT INTO `Proveidor` VALUES (1,1,'Proveidor1','555666777',NULL,'R45555555'),(2,2,'Proveidor2','888888888',NULL,'A465321345');
/*!40000 ALTER TABLE `Proveidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipusMontura`
--

DROP TABLE IF EXISTS `TipusMontura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipusMontura` (
  `IdTipusMontura` int NOT NULL AUTO_INCREMENT,
  `NomTipus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdTipusMontura`),
  UNIQUE KEY `IdTipusMontura_UNIQUE` (`IdTipusMontura`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipusMontura`
--

LOCK TABLES `TipusMontura` WRITE;
/*!40000 ALTER TABLE `TipusMontura` DISABLE KEYS */;
INSERT INTO `TipusMontura` VALUES (1,'Montura1'),(2,'Montura2');
/*!40000 ALTER TABLE `TipusMontura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ulleres`
--

DROP TABLE IF EXISTS `ulleres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ulleres` (
  `IdUlleres` int NOT NULL AUTO_INCREMENT,
  `Marca` varchar(150) DEFAULT NULL,
  `IdTipusMontura` int NOT NULL,
  `ColorMontura` varchar(100) DEFAULT NULL,
  `Preu` decimal(7,2) DEFAULT NULL,
  `IdProveidor` int NOT NULL,
  PRIMARY KEY (`IdUlleres`),
  UNIQUE KEY `IdUlleres_UNIQUE` (`IdUlleres`),
  KEY `FK_Ulleres_TipusMontura_idx` (`IdTipusMontura`),
  KEY `FK_Ulleres_Proveidor_idx` (`IdProveidor`),
  CONSTRAINT `FK_Ulleres_Proveidor` FOREIGN KEY (`IdProveidor`) REFERENCES `Proveidor` (`IdProveidor`),
  CONSTRAINT `FK_Ulleres_TipusMontura` FOREIGN KEY (`IdTipusMontura`) REFERENCES `TipusMontura` (`IdTipusMontura`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ulleres`
--

LOCK TABLES `ulleres` WRITE;
/*!40000 ALTER TABLE `ulleres` DISABLE KEYS */;
INSERT INTO `ulleres` VALUES (1,'Marca1',1,'Blau',150.65,1),(2,'Marca2',1,'Negre',100.65,1),(3,'Marca3',2,'Vermella',56.65,2);
/*!40000 ALTER TABLE `ulleres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Venda`
--

DROP TABLE IF EXISTS `Venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Venda` (
  `IdVenda` int NOT NULL AUTO_INCREMENT,
  `IdVenedor` int NOT NULL,
  `IdClient` int DEFAULT NULL,
  `DataVenda` datetime DEFAULT NULL,
  `PreuTotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`IdVenda`),
  UNIQUE KEY `IdVenda_UNIQUE` (`IdVenda`),
  KEY `FK_Venda_Venedor_idx` (`IdVenedor`),
  KEY `FK_Venda_Client_idx` (`IdClient`),
  CONSTRAINT `FK_Venda_Client` FOREIGN KEY (`IdClient`) REFERENCES `Clients` (`IdClient`),
  CONSTRAINT `FK_Venda_Venedor` FOREIGN KEY (`IdVenedor`) REFERENCES `Venedors` (`IdVenedor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Venda`
--

LOCK TABLES `Venda` WRITE;
/*!40000 ALTER TABLE `Venda` DISABLE KEYS */;
INSERT INTO `Venda` VALUES (1,1,1,'2023-05-06 11:12:04',150.65),(2,1,2,'2023-09-06 11:12:04',301.95),(3,2,1,'2023-10-06 11:12:04',502.60),(4,2,1,'2023-08-06 11:12:04',351.95),(5,2,1,'2023-07-06 11:12:04',100.65);
/*!40000 ALTER TABLE `Venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VendaDetall`
--

DROP TABLE IF EXISTS `VendaDetall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `VendaDetall` (
  `IdDetall` int NOT NULL AUTO_INCREMENT,
  `IdVenda` int NOT NULL,
  `IdUlleres` int NOT NULL,
  `Preu` decimal(7,2) DEFAULT NULL,
  `GradVE` decimal(4,2) DEFAULT NULL,
  `GradVD` decimal(4,2) DEFAULT NULL,
  `ColorVE` varchar(100) DEFAULT NULL,
  `ColorVD` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdDetall`),
  UNIQUE KEY `IdDetall_UNIQUE` (`IdDetall`),
  KEY `FK_VendaDetall_Venda_idx` (`IdVenda`),
  KEY `FK_VendaDetall_Ulleres_idx` (`IdUlleres`),
  CONSTRAINT `FK_VendaDetall_Ulleres` FOREIGN KEY (`IdUlleres`) REFERENCES `Ulleres` (`IdUlleres`),
  CONSTRAINT `FK_VendaDetall_Venda` FOREIGN KEY (`IdVenda`) REFERENCES `Venda` (`IdVenda`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VendaDetall`
--

LOCK TABLES `VendaDetall` WRITE;
/*!40000 ALTER TABLE `VendaDetall` DISABLE KEYS */;
INSERT INTO `VendaDetall` VALUES (1,1,1,150.65,1.00,1.00,NULL,NULL),(2,2,2,100.65,2.10,1.10,NULL,NULL),(3,2,2,100.65,2.40,2.10,NULL,NULL),(4,2,2,100.65,2.10,1.10,NULL,NULL),(5,3,1,150.65,2.10,1.10,NULL,NULL),(6,3,2,100.65,2.10,1.10,NULL,NULL),(7,3,2,100.65,2.10,1.10,NULL,NULL),(8,3,1,150.65,2.10,1.10,NULL,NULL),(9,4,1,150.65,2.10,1.10,NULL,NULL),(10,4,2,100.65,2.10,1.10,NULL,NULL),(11,4,2,100.65,2.10,1.10,NULL,NULL),(12,5,2,100.65,2.10,1.10,NULL,NULL);
/*!40000 ALTER TABLE `VendaDetall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Venedors`
--

DROP TABLE IF EXISTS `Venedors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Venedors` (
  `IdVenedor` int NOT NULL AUTO_INCREMENT,
  `NomVenedor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdVenedor`),
  UNIQUE KEY `IdVenedor_UNIQUE` (`IdVenedor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Venedors`
--

LOCK TABLES `Venedors` WRITE;
/*!40000 ALTER TABLE `Venedors` DISABLE KEYS */;
INSERT INTO `Venedors` VALUES (1,'Venedor1'),(2,'Venedor2');
/*!40000 ALTER TABLE `Venedors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-06 12:54:42
