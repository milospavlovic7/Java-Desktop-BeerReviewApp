/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.24-MariaDB : Database - beerreview
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`beerreview` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `beerreview`;

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `korisnikID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) NOT NULL,
  `prezime` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lozinka` varchar(255) NOT NULL,
  `telefon` varchar(30) DEFAULT NULL,
  `datumKreiranja` date NOT NULL,
  PRIMARY KEY (`korisnikID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `korisnik` */

/*Table structure for table `omiljenopivo` */

DROP TABLE IF EXISTS `omiljenopivo`;

CREATE TABLE `omiljenopivo` (
  `korisnikID` bigint(20) NOT NULL,
  `pivoID` bigint(20) NOT NULL,
  `datumDodavanja` date NOT NULL,
  PRIMARY KEY (`korisnikID`,`pivoID`),
  KEY `pivoID` (`pivoID`),
  CONSTRAINT `omiljenopivo_ibfk_1` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`korisnikID`) ON DELETE CASCADE,
  CONSTRAINT `omiljenopivo_ibfk_2` FOREIGN KEY (`pivoID`) REFERENCES `pivo` (`pivoID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `omiljenopivo` */

/*Table structure for table `pivara` */

DROP TABLE IF EXISTS `pivara`;

CREATE TABLE `pivara` (
  `pivaraID` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lozinka` varchar(255) NOT NULL,
  `telefon` varchar(30) DEFAULT NULL,
  `datumKreiranja` date NOT NULL,
  PRIMARY KEY (`pivaraID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `pivara` */

/*Table structure for table `pivo` */

DROP TABLE IF EXISTS `pivo`;

CREATE TABLE `pivo` (
  `pivoID` bigint(20) NOT NULL AUTO_INCREMENT,
  `pivaraID` bigint(20) NOT NULL,
  `naziv` varchar(100) NOT NULL,
  `opis` text DEFAULT NULL,
  `cena` decimal(10,2) DEFAULT NULL,
  `datumDodavanja` date NOT NULL,
  PRIMARY KEY (`pivoID`),
  KEY `pivaraID` (`pivaraID`),
  CONSTRAINT `pivo_ibfk_1` FOREIGN KEY (`pivaraID`) REFERENCES `pivara` (`pivaraID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `pivo` */

/*Table structure for table `recenzija` */

DROP TABLE IF EXISTS `recenzija`;

CREATE TABLE `recenzija` (
  `recenzijaID` bigint(20) NOT NULL AUTO_INCREMENT,
  `korisnikID` bigint(20) NOT NULL,
  `pivoID` bigint(20) NOT NULL,
  `sadrzaj` text DEFAULT NULL,
  `ocena` int(11) DEFAULT NULL CHECK (`ocena` >= 1 and `ocena` <= 5),
  `datumKreiranja` date NOT NULL,
  PRIMARY KEY (`recenzijaID`),
  KEY `korisnikID` (`korisnikID`),
  KEY `pivoID` (`pivoID`),
  CONSTRAINT `recenzija_ibfk_1` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`korisnikID`) ON DELETE CASCADE,
  CONSTRAINT `recenzija_ibfk_2` FOREIGN KEY (`pivoID`) REFERENCES `pivo` (`pivoID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `recenzija` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
