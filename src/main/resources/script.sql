-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.5.12-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE SCHEMA `jdbc` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

USE jdbc;

-- Volcando estructura para tabla jdbc.person
CREATE TABLE IF NOT EXISTS person (
    person_id INT NOT NULL AUTO_INCREMENT,
    last_name VARCHAR(255),
    first_name VARCHAR(255),
    PRIMARY KEY (person_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla jdbc.person: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE person DISABLE KEYS */;
INSERT INTO person (person_id, last_name, first_name) VALUES
    (1, 'Garcia', 'Victor'),
    (2, 'Carrasco', 'Joshua'),
    (3, 'Garcia', 'Rodrigo');
/*!40000 ALTER TABLE person ENABLE KEYS */;