-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: sales1
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `sales1`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `sales1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `sales1`;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'음료수'),(2,'주류'),(3,'과자');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `salesmanId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_customer_salesman_idx` (`salesmanId`),
  CONSTRAINT `FK_customer_salesman` FOREIGN KEY (`salesmanId`) REFERENCES `salesman` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'홍길동','hong@skhu.net','남','017-888-9999',1),(2,'임꺽정','lim@skhu.net','남','017-111-2222',1),(3,'이몽룡','lee@skhu.net','남','017-222-3333',1),(4,'성춘향','seong@skhu.net','여','017-333-4444',2),(5,'연흥부','yeonghb@skhu.net','남','017-444-5555',2),(6,'연놀부','yeonnb@skhu.net','남','017-555-6666',2),(7,'전우치','jeon@skhu.net','남','017-666-7777',3),(8,'심청이','sim@skhu.net','여','017-777-8888',3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jumoon`
--

DROP TABLE IF EXISTS `jumoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jumoon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `productId` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_customer_idx` (`customerId`),
  KEY `FK_order_product_idx` (`productId`),
  CONSTRAINT `FK_jumoon_customer` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK_jumoon_product` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jumoon`
--

LOCK TABLES `jumoon` WRITE;
/*!40000 ALTER TABLE `jumoon` DISABLE KEYS */;
INSERT INTO `jumoon` VALUES (1,1,23,1),(2,1,24,3),(3,2,25,1),(4,2,4,2),(5,3,5,1),(6,3,6,3),(7,3,3,1),(8,4,11,3),(9,4,12,4),(10,5,13,3),(11,5,7,1),(12,6,8,3),(13,6,9,1),(14,6,10,1),(15,7,11,3),(16,7,12,1),(17,7,13,3),(18,8,14,1),(19,8,15,1),(20,1,16,1),(21,1,17,1),(22,2,18,1),(23,2,19,4),(24,3,20,1),(25,3,21,1),(26,3,22,1),(27,4,23,1),(28,4,24,1),(29,5,25,1),(30,5,26,1),(31,6,27,1),(32,6,28,2),(33,6,29,1),(34,7,30,1),(35,7,31,1),(36,7,3,3),(37,8,4,1),(38,8,5,1),(39,1,12,4),(40,1,21,3),(41,2,22,1),(42,2,17,1),(43,3,1,1);
/*!40000 ALTER TABLE `jumoon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `categoryId` int NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_category_idx` (`categoryId`),
  CONSTRAINT `FK_product_category` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'콜라',1,1800,150),(2,'환타',1,1500,10),(3,'사이다',1,1000,20),(4,'맥주',2,2500,100),(5,'소주',2,1300,150),(6,'막걸리',2,1100,80),(7,'우유',1,800,200),(8,'베지밀',1,900,20),(9,'바나나우유',1,1000,50),(10,'맥주',2,2500,50),(11,'꼬깔콘',3,1000,30),(12,'고래밥',3,500,80),(13,'새우깡',3,700,75),(14,'초코파이',3,300,15),(15,'양파링',3,400,59),(16,'죠리퐁',3,900,34),(17,'홈런볼',3,800,50),(18,'오징어땅콩',3,500,80),(19,'다이제스티브',3,700,50),(20,'포카칩',3,300,80),(21,'초코하임',3,1000,110),(22,'몽셀',3,1200,90),(23,'오예스',3,500,80),(24,'카스타드',3,1300,30),(25,'마라렛트',3,800,50),(26,'칸쵸',3,500,120),(27,'산도',3,700,90),(28,'칙촉',3,900,100),(29,'와인',2,15000,10),(30,'카스',2,2500,20),(31,'하이트',2,2500,25);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesman`
--

DROP TABLE IF EXISTS `salesman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesman` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employeeNo` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `office` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesman`
--

LOCK TABLES `salesman` WRITE;
/*!40000 ALTER TABLE `salesman` DISABLE KEYS */;
INSERT INTO `salesman` VALUES (1,'80012','장길산','017-121-3131','102'),(2,'80013','최콩쥐','017-211-1090','103'),(3,'91011','허준','017-988-3333','104');
/*!40000 ALTER TABLE `salesman` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-12  1:42:31
