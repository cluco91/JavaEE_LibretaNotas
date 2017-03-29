-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.25-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla agenda.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agenda.categoria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`codigo`, `nombre`, `estado`) VALUES
	(1, 'Software', b'1'),
	(2, 'Red', b'1');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla agenda.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `codigo` tinyint(4) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `tipo` enum('S','I') NOT NULL,
  `tipoUsuario` enum('A','O') NOT NULL,
  `codigo_submenu` tinyint(4) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_menu_item` (`codigo_submenu`),
  CONSTRAINT `FK_menu_item` FOREIGN KEY (`codigo_submenu`) REFERENCES `menu` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agenda.menu: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`codigo`, `nombre`, `url`, `tipo`, `tipoUsuario`, `codigo_submenu`, `estado`) VALUES
	(1, 'NOTAS', NULL, 'S', 'O', NULL, b'1'),
	(2, 'NUEVO', '/protegido/operario/nuevo.lucodeveloper', 'I', 'O', 1, b'1'),
	(3, 'BUSCAR', '/protegido/operario/buscar.lucodeveloper', 'I', 'O', 1, b'1'),
	(4, 'COMENTAR', '/protegido/administrador/comentar.lucodeveloper', 'I', 'A', NULL, b'1'),
	(5, 'TELEFONOS', '/protegido/operario/telefono.lucodeveloper', 'I', 'O', NULL, b'1'),
	(6, 'CONSULTAR', '/protegido/administrador/consultar.lucodeveloper', 'I', 'A', NULL, b'1');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Volcando estructura para tabla agenda.nota
CREATE TABLE IF NOT EXISTS `nota` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_persona` int(11) NOT NULL,
  `codigo_categoria` int(11) NOT NULL,
  `encabezado` varchar(50) NOT NULL,
  `cuerpo` varchar(500) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `comentarioAdmin` varchar(50) DEFAULT NULL,
  `valorizacion` enum('1','2','3','4','5') DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_nota_categoria` (`codigo_categoria`),
  KEY `FK_nota_persona` (`codigo_persona`),
  CONSTRAINT `FK_nota_categoria` FOREIGN KEY (`codigo_categoria`) REFERENCES `categoria` (`codigo`),
  CONSTRAINT `FK_nota_persona` FOREIGN KEY (`codigo_persona`) REFERENCES `persona` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agenda.nota: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` (`codigo`, `codigo_persona`, `codigo_categoria`, `encabezado`, `cuerpo`, `fecha`, `comentarioAdmin`, `valorizacion`) VALUES
	(1, 1, 1, 'lorem ipsum', 'lorem ipsum', '2017-03-29 14:12:21', NULL, NULL);
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;

-- Volcando estructura para tabla agenda.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `fechaNacimiento` datetime NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agenda.persona: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`codigo`, `nombres`, `apellidos`, `sexo`, `fechaNacimiento`) VALUES
	(1, 'lucodev', 'lucodev', 'M', '2017-03-23 01:50:36');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla agenda.telefono
CREATE TABLE IF NOT EXISTS `telefono` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_persona` int(11) NOT NULL,
  `numero` char(9) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_telefono_persona` (`codigo_persona`),
  CONSTRAINT `FK_telefono_persona` FOREIGN KEY (`codigo_persona`) REFERENCES `persona` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agenda.telefono: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
INSERT INTO `telefono` (`codigo`, `codigo_persona`, `numero`) VALUES
	(1, 1, '1234567');
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;

-- Volcando estructura para tabla agenda.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `clave` varchar(40) NOT NULL,
  `tipo` enum('A','O') NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`),
  CONSTRAINT `FK_usuario_persona` FOREIGN KEY (`codigo`) REFERENCES `persona` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agenda.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`codigo`, `usuario`, `clave`, `tipo`, `estado`) VALUES
	(1, 'lucodev', 'pass', 'A', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
