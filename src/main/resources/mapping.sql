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

CREATE SCHEMA `test` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

USE test;

-- Volcando estructura para tabla test.table_1
CREATE TABLE IF NOT EXISTS table_1
(
    id    INT NOT NULL AUTO_INCREMENT,
    data1 VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (id)
)
    ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.table_1: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE table_1 DISABLE KEYS */;
INSERT INTO table_1 (id, data1) VALUES
	(1, 'cadena1'),
	(2, 'cadena2'),
	(3, 'cadena3');
/*!40000 ALTER TABLE table_1 ENABLE KEYS */;

-- Volcando estructura para tabla test.table_2
CREATE TABLE IF NOT EXISTS table_2
(
    id        INT NOT NULL AUTO_INCREMENT,
    data2     VARCHAR(50) DEFAULT NULL,
    id_table1 INT DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_tabla2_tabla_1 FOREIGN KEY (id_table1) references table_1 (id) ON DELETE NO ACTION ON UPDATE NO ACTION
)
    ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.table_2: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE table_2 DISABLE KEYS */;
INSERT INTO table_2 (id, data2, id_table1) VALUES
	(1, 'cadena11', 1),
	(2, 'cadena12', 1),
	(3, 'cadena13', 1),
	(4, 'cadena21', 2),
	(5, 'cadena22', 2),
	(6, 'cadena23', 2),
	(7, 'cadena31', 3),
	(8, 'cadena32', 3),
	(9, 'cadena33', 3);
/*!40000 ALTER TABLE table_2 ENABLE KEYS */;