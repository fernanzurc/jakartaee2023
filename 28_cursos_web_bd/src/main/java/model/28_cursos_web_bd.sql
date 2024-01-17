DROP DATABASE IF EXISTS `escuela`;
CREATE DATABASE `escuela`;
CREATE TABLE `escuela`.`usuarios` (
  `usuario` varchar(70) NOT NULL,
  `password` varchar(70) NOT NULL, 
  PRIMARY KEY (`usuario`),
  KEY `usuario_key` (`usuario`)
  );
CREATE TABLE `escuela`.`cursos` (
  `idCurso` int NOT NULL AUTO_INCREMENT,
  `denominacion` varchar(70) NOT NULL,
  `duracion` int NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `idCurso_key` (`idCurso`)
  );
