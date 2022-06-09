-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: mensalidade_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `id_cargo` bigint NOT NULL,
  `nome_cargo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (131,'docente'),(132,'director'),(133,'prof_assistente'),(134,'funcionario');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `curso_codigo` bigint NOT NULL AUTO_INCREMENT,
  `nome_curso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`curso_codigo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'ETSI'),(2,'AP'),(3,'RI');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_departamentos`
--

DROP TABLE IF EXISTS `curso_departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso_departamentos` (
  `curso_curso_codigo` bigint NOT NULL,
  `departamentos_cod_departamento` bigint NOT NULL,
  KEY `FKq6103wnkn65nltdfphugmihec` (`departamentos_cod_departamento`),
  KEY `FK3bdn0yh8rur2tuojaswwx8pbm` (`curso_curso_codigo`),
  CONSTRAINT `FK3bdn0yh8rur2tuojaswwx8pbm` FOREIGN KEY (`curso_curso_codigo`) REFERENCES `curso` (`curso_codigo`),
  CONSTRAINT `FKq6103wnkn65nltdfphugmihec` FOREIGN KEY (`departamentos_cod_departamento`) REFERENCES `departamento` (`cod_departamento`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_departamentos`
--

LOCK TABLES `curso_departamentos` WRITE;
/*!40000 ALTER TABLE `curso_departamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso_departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_disciplinas`
--

DROP TABLE IF EXISTS `curso_disciplinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso_disciplinas` (
  `curso_curso_codigo` bigint NOT NULL,
  `disciplinas_id_disciplina` bigint NOT NULL,
  KEY `FKeh0e3icav6gyndh2smcqluna2` (`disciplinas_id_disciplina`),
  KEY `FKn5evfr1wbg8asao7j2fifrsnk` (`curso_curso_codigo`),
  CONSTRAINT `FKeh0e3icav6gyndh2smcqluna2` FOREIGN KEY (`disciplinas_id_disciplina`) REFERENCES `disciplina` (`id_disciplina`),
  CONSTRAINT `FKn5evfr1wbg8asao7j2fifrsnk` FOREIGN KEY (`curso_curso_codigo`) REFERENCES `curso` (`curso_codigo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_disciplinas`
--

LOCK TABLES `curso_disciplinas` WRITE;
/*!40000 ALTER TABLE `curso_disciplinas` DISABLE KEYS */;
INSERT INTO `curso_disciplinas` VALUES (1,801),(1,802),(1,803),(1,804),(1,805),(1,806),(1,807),(1,808),(1,809),(1,810);
/*!40000 ALTER TABLE `curso_disciplinas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_estudantes`
--

DROP TABLE IF EXISTS `curso_estudantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso_estudantes` (
  `curso_curso_codigo` bigint NOT NULL,
  `estudantes_id` bigint NOT NULL,
  UNIQUE KEY `UK_h280xi1kg1l0gn0rxb6vn84pi` (`estudantes_id`),
  KEY `FK88gdrjmdfw9x05vlig5m819rb` (`curso_curso_codigo`),
  CONSTRAINT `FK88gdrjmdfw9x05vlig5m819rb` FOREIGN KEY (`curso_curso_codigo`) REFERENCES `curso` (`curso_codigo`),
  CONSTRAINT `FKoh20dwrskca2556suvnnaidxq` FOREIGN KEY (`estudantes_id`) REFERENCES `estudante` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_estudantes`
--

LOCK TABLES `curso_estudantes` WRITE;
/*!40000 ALTER TABLE `curso_estudantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso_estudantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_estudantes2`
--

DROP TABLE IF EXISTS `curso_estudantes2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso_estudantes2` (
  `curso_curso_codigo` bigint NOT NULL,
  `estudantes2_id` bigint NOT NULL,
  KEY `FKbckpyjht6cdexm0hbu81p9406` (`estudantes2_id`),
  KEY `FK1hpf3mrauecdjjitpovrksw81` (`curso_curso_codigo`),
  CONSTRAINT `FK1hpf3mrauecdjjitpovrksw81` FOREIGN KEY (`curso_curso_codigo`) REFERENCES `curso` (`curso_codigo`),
  CONSTRAINT `FKbckpyjht6cdexm0hbu81p9406` FOREIGN KEY (`estudantes2_id`) REFERENCES `estudante` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_estudantes2`
--

LOCK TABLES `curso_estudantes2` WRITE;
/*!40000 ALTER TABLE `curso_estudantes2` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso_estudantes2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `cod_departamento` bigint NOT NULL AUTO_INCREMENT,
  `nome_departamento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_departamento`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'FCT'),(2,'Faculdade de engenharia'),(3,'Faculdade de ciencias sociais'),(4,'Faculdade de contabilidade'),(5,'Faculdade de estudos Nauticos'),(6,'Faculdade de relacoes internacionais'),(7,'Faculdade de letras');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento_curso`
--

DROP TABLE IF EXISTS `departamento_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento_curso` (
  `departamento_id` bigint NOT NULL,
  `curso_id` bigint NOT NULL,
  KEY `FKkg0s97jtjujrgug8lhdnangnq` (`curso_id`),
  KEY `FK3e7yg3gqlpp9b73s88a1anp6w` (`departamento_id`),
  CONSTRAINT `FK3e7yg3gqlpp9b73s88a1anp6w` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`cod_departamento`),
  CONSTRAINT `FKkg0s97jtjujrgug8lhdnangnq` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_codigo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento_curso`
--

LOCK TABLES `departamento_curso` WRITE;
/*!40000 ALTER TABLE `departamento_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina` (
  `id_disciplina` bigint NOT NULL AUTO_INCREMENT,
  `disc_credito` int DEFAULT NULL,
  `disc_nome` varchar(255) DEFAULT NULL,
  `estatuto` varchar(255) DEFAULT NULL,
  `ano` bigint DEFAULT NULL,
  PRIMARY KEY (`id_disciplina`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES (801,3,'introducao a informatica','nuclear',1),(802,4,'Fundamentos de informatica','nuclear',1),(803,4,'redes de computadores','nuclear',2),(804,4,'analise matematica I','complementar',1),(805,3,'gestao de empresas','complementar',1),(806,4,'Engenharia de software','nuclear',3),(807,4,'Sistemas distribuidos','nuclear',3),(808,4,'analise e desenho orientado a objectos','nuclear',3),(809,4,'Gestao de sistemas de informacao','nuclear',3),(810,4,'programacao web','nuclear',2);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina_cursos`
--

DROP TABLE IF EXISTS `disciplina_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina_cursos` (
  `disciplina_id_disciplina` bigint NOT NULL,
  `cursos_curso_codigo` bigint NOT NULL,
  KEY `FKpi251oy4bi5u500r1pt6jan2c` (`cursos_curso_codigo`),
  KEY `FKdfquexo7up9ad2a810gdkuosj` (`disciplina_id_disciplina`),
  CONSTRAINT `FKdfquexo7up9ad2a810gdkuosj` FOREIGN KEY (`disciplina_id_disciplina`) REFERENCES `disciplina` (`id_disciplina`),
  CONSTRAINT `FKpi251oy4bi5u500r1pt6jan2c` FOREIGN KEY (`cursos_curso_codigo`) REFERENCES `curso` (`curso_codigo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina_cursos`
--

LOCK TABLES `disciplina_cursos` WRITE;
/*!40000 ALTER TABLE `disciplina_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `disciplina_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina_estudantes`
--

DROP TABLE IF EXISTS `disciplina_estudantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disciplina_estudantes` (
  `disciplina_id_disciplina` bigint NOT NULL,
  `estudantes_id` bigint NOT NULL,
  KEY `FKl5q8gbf7lro06f5pxb4fafi26` (`estudantes_id`),
  KEY `FKt7hh7jdvwup5niafjpiwgein2` (`disciplina_id_disciplina`),
  CONSTRAINT `FKl5q8gbf7lro06f5pxb4fafi26` FOREIGN KEY (`estudantes_id`) REFERENCES `estudante` (`id`),
  CONSTRAINT `FKt7hh7jdvwup5niafjpiwgein2` FOREIGN KEY (`disciplina_id_disciplina`) REFERENCES `disciplina` (`id_disciplina`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina_estudantes`
--

LOCK TABLES `disciplina_estudantes` WRITE;
/*!40000 ALTER TABLE `disciplina_estudantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `disciplina_estudantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudante`
--

DROP TABLE IF EXISTS `estudante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `cod_estudante` bigint DEFAULT NULL,
  `data_ingresso` date DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `curso_curso_codigo` bigint DEFAULT NULL,
  `ui_utilizador_id` bigint DEFAULT NULL,
  `utilizador_id` bigint DEFAULT NULL,
  `contacto` bigint DEFAULT NULL,
  `data_nascimento` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nacionalidade` varchar(255) DEFAULT NULL,
  `data_igresso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8opmoiunfraj39xxk33lnm5v6` (`curso_curso_codigo`),
  KEY `FK4tjkvtiibbnq9kw0332jgyvh0` (`ui_utilizador_id`),
  KEY `FK306vnhgvwixmjl7s5s8cv7of5` (`utilizador_id`),
  CONSTRAINT `FK306vnhgvwixmjl7s5s8cv7of5` FOREIGN KEY (`utilizador_id`) REFERENCES `utilizador` (`id`),
  CONSTRAINT `FK4tjkvtiibbnq9kw0332jgyvh0` FOREIGN KEY (`ui_utilizador_id`) REFERENCES `utilizador` (`id`),
  CONSTRAINT `FK8opmoiunfraj39xxk33lnm5v6` FOREIGN KEY (`curso_curso_codigo`) REFERENCES `curso` (`curso_codigo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante`
--

LOCK TABLES `estudante` WRITE;
/*!40000 ALTER TABLE `estudante` DISABLE KEYS */;
INSERT INTO `estudante` VALUES (1,NULL,NULL,100,NULL,'Edwina',1,NULL,1,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,101,NULL,'Teofilo',1,NULL,3,NULL,NULL,NULL,NULL,NULL),(3,NULL,NULL,102,NULL,'Israel',1,NULL,4,NULL,NULL,NULL,NULL,NULL),(4,NULL,NULL,103,NULL,'Jose Antonio',2,NULL,5,NULL,NULL,NULL,NULL,NULL),(5,NULL,NULL,104,NULL,'Pedro Salvador',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,NULL,105,NULL,'Claudia',2,NULL,6,NULL,NULL,NULL,NULL,NULL),(7,NULL,NULL,106,NULL,'Meek Mill',3,NULL,7,NULL,NULL,NULL,NULL,NULL),(8,NULL,NULL,107,NULL,'John Due',3,NULL,9,821234567,'1997-11-27',NULL,'','6/7/2022'),(9,NULL,NULL,108,NULL,'Tiago',2,NULL,10,2558741471,'1989-11-16','tiago@coder.com','Estrangeira','6/7/2022'),(10,NULL,NULL,109,NULL,'Maria Isabel',2,NULL,13,821345628,'1990-02-03','mary@coder.com','Mocambicana','6/9/2022');
/*!40000 ALTER TABLE `estudante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudante_cursos`
--

DROP TABLE IF EXISTS `estudante_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante_cursos` (
  `estudante_id` bigint NOT NULL,
  `cursos_curso_codigo` bigint NOT NULL,
  KEY `FKsvvnhyby58kotyddmt0nol5fl` (`cursos_curso_codigo`),
  KEY `FKt99igkv46gwm4r5qtqefre39f` (`estudante_id`),
  CONSTRAINT `FKsvvnhyby58kotyddmt0nol5fl` FOREIGN KEY (`cursos_curso_codigo`) REFERENCES `curso` (`curso_codigo`),
  CONSTRAINT `FKt99igkv46gwm4r5qtqefre39f` FOREIGN KEY (`estudante_id`) REFERENCES `estudante` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante_cursos`
--

LOCK TABLES `estudante_cursos` WRITE;
/*!40000 ALTER TABLE `estudante_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudante_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudante_mensalidades`
--

DROP TABLE IF EXISTS `estudante_mensalidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante_mensalidades` (
  `estudante_id` bigint NOT NULL,
  `mensalidades_id` bigint NOT NULL,
  KEY `FK5vd9cpyf8dv8v1f1dgpexl8mr` (`mensalidades_id`),
  KEY `FKrmni7tg0x23lwp4m5x1g187t2` (`estudante_id`),
  CONSTRAINT `FK5vd9cpyf8dv8v1f1dgpexl8mr` FOREIGN KEY (`mensalidades_id`) REFERENCES `mensalidade` (`id`),
  CONSTRAINT `FKrmni7tg0x23lwp4m5x1g187t2` FOREIGN KEY (`estudante_id`) REFERENCES `estudante` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante_mensalidades`
--

LOCK TABLES `estudante_mensalidades` WRITE;
/*!40000 ALTER TABLE `estudante_mensalidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudante_mensalidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `data_ingresso_funcionario` date DEFAULT NULL,
  `cargo_id_fk` bigint DEFAULT NULL,
  `cod_estudante` bigint DEFAULT NULL,
  `contacto` bigint DEFAULT NULL,
  `data_nascimento` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nacionalidade` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `utilizador_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlxfbfx8w9nn3t4rurn74k66r0` (`cargo_id_fk`),
  KEY `FKc5hkrkb4vbmub5c40x0uq2ry3` (`utilizador_id`),
  CONSTRAINT `FKc5hkrkb4vbmub5c40x0uq2ry3` FOREIGN KEY (`utilizador_id`) REFERENCES `utilizador` (`id`),
  CONSTRAINT `FKlxfbfx8w9nn3t4rurn74k66r0` FOREIGN KEY (`cargo_id_fk`) REFERENCES `cargo` (`id_cargo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (2,NULL,NULL,NULL,NULL,NULL,844763195,'1994-10-27','mariza@coder.com','Mocambicana','Mariza Santos',12),(3,NULL,NULL,NULL,NULL,NULL,821234567,'1993-06-16','joao@coder.com','Mocambicana','Joao Pelembe',14);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscricao`
--

DROP TABLE IF EXISTS `inscricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscricao` (
  `cod_inscricao` bigint NOT NULL,
  `faltas` bigint DEFAULT NULL,
  `data_inscricao` date DEFAULT NULL,
  `nota1` bigint DEFAULT NULL,
  `nota2` bigint DEFAULT NULL,
  `estudante_id` bigint NOT NULL,
  `disciplina_id` bigint NOT NULL,
  PRIMARY KEY (`cod_inscricao`),
  KEY `FKh7lwti0g08ecpgaiwa1h9w5e5` (`disciplina_id`),
  KEY `FKhmsobcl54dm5k0jhx0xkkoc76` (`estudante_id`),
  CONSTRAINT `FKh7lwti0g08ecpgaiwa1h9w5e5` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplina` (`id_disciplina`),
  CONSTRAINT `FKhmsobcl54dm5k0jhx0xkkoc76` FOREIGN KEY (`estudante_id`) REFERENCES `estudante` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscricao`
--

LOCK TABLES `inscricao` WRITE;
/*!40000 ALTER TABLE `inscricao` DISABLE KEYS */;
INSERT INTO `inscricao` VALUES (1,3,'2020-09-02',12,13,1,801),(2,2,'2019-03-02',11,15,3,805),(3,1,'2021-01-12',15,10,2,802),(4,2,'2019-10-12',12,14,4,803),(5,2,'2018-11-12',10,11,1,802);
/*!40000 ALTER TABLE `inscricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensalidade`
--

DROP TABLE IF EXISTS `mensalidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensalidade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `multa` bigint DEFAULT NULL,
  `valor_pago` bigint DEFAULT NULL,
  `pagamento_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmbpl7vpw6p89y0xbtbo53wbr5` (`pagamento_id`),
  CONSTRAINT `FKmbpl7vpw6p89y0xbtbo53wbr5` FOREIGN KEY (`pagamento_id`) REFERENCES `pagamento` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensalidade`
--

LOCK TABLES `mensalidade` WRITE;
/*!40000 ALTER TABLE `mensalidade` DISABLE KEYS */;
INSERT INTO `mensalidade` VALUES (1,NULL,NULL,NULL,100,1),(2,NULL,NULL,NULL,3500,2),(3,NULL,NULL,NULL,4500,3),(4,NULL,NULL,NULL,1500,4),(5,NULL,NULL,NULL,4500,5),(6,NULL,NULL,NULL,1500,6),(7,NULL,NULL,NULL,3500,7),(8,NULL,NULL,NULL,3500,8),(9,NULL,NULL,NULL,3500,9),(10,NULL,NULL,NULL,3500,10),(11,NULL,NULL,NULL,3500,11),(12,NULL,NULL,NULL,3500,12),(13,NULL,NULL,NULL,35000,13),(14,NULL,NULL,NULL,844763195,2),(15,NULL,NULL,NULL,3500,10),(16,NULL,NULL,NULL,3500,10),(17,NULL,NULL,NULL,3500,14);
/*!40000 ALTER TABLE `mensalidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `data_pagamento` varchar(255) DEFAULT NULL,
  `status` bigint DEFAULT NULL,
  `estudante_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnkuhw89co1r62eht0n0n0gl98` (`estudante_id`),
  CONSTRAINT `FKnkuhw89co1r62eht0n0n0gl98` FOREIGN KEY (`estudante_id`) REFERENCES `estudante` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,NULL,NULL,'5/15/2022',0,1),(2,NULL,NULL,'6/8/2022',0,1),(3,NULL,NULL,'5/21/2022',1,1),(4,NULL,NULL,'5/22/2022',0,6),(5,NULL,NULL,'5/22/2022',1,6),(6,NULL,NULL,'6/7/2022',0,1),(7,NULL,NULL,'6/7/2022',1,9),(8,NULL,NULL,'6/7/2022',0,9),(9,NULL,NULL,'6/8/2022',0,7),(10,NULL,NULL,'6/9/2022',1,7),(11,NULL,NULL,'6/8/2022',0,7),(12,NULL,NULL,'6/8/2022',0,1),(13,NULL,NULL,'6/8/2022',0,1),(14,NULL,NULL,'6/9/2022',0,10),(15,NULL,NULL,NULL,1,10),(16,NULL,NULL,NULL,1,10),(17,NULL,NULL,NULL,1,10),(18,NULL,NULL,NULL,1,10);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento_mensalidade`
--

DROP TABLE IF EXISTS `pagamento_mensalidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento_mensalidade` (
  `cod_pagamento` bigint NOT NULL,
  `data_pagamento` date DEFAULT NULL,
  `mensalidade_id` bigint NOT NULL,
  `estudante_id` bigint NOT NULL,
  PRIMARY KEY (`cod_pagamento`),
  KEY `FKco9hxyuwdw5bnb4rqsjtjjwr8` (`estudante_id`),
  KEY `FKlaofvvwsr62a5lp9lkccky9qc` (`mensalidade_id`),
  CONSTRAINT `FKco9hxyuwdw5bnb4rqsjtjjwr8` FOREIGN KEY (`estudante_id`) REFERENCES `estudante` (`id`),
  CONSTRAINT `FKlaofvvwsr62a5lp9lkccky9qc` FOREIGN KEY (`mensalidade_id`) REFERENCES `mensalidade` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento_mensalidade`
--

LOCK TABLES `pagamento_mensalidade` WRITE;
/*!40000 ALTER TABLE `pagamento_mensalidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento_mensalidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil_utilizador`
--

DROP TABLE IF EXISTS `perfil_utilizador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil_utilizador` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL,
  `utilizador_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5akcucrqvjm78ub36v49ule7h` (`utilizador_id`),
  CONSTRAINT `FK5akcucrqvjm78ub36v49ule7h` FOREIGN KEY (`utilizador_id`) REFERENCES `utilizador` (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil_utilizador`
--

LOCK TABLES `perfil_utilizador` WRITE;
/*!40000 ALTER TABLE `perfil_utilizador` DISABLE KEYS */;
INSERT INTO `perfil_utilizador` VALUES (1,NULL,NULL,'ADMIN',1),(3,NULL,NULL,'ADMIN',3),(4,NULL,NULL,'ESTUDANTE',4),(5,NULL,NULL,'ESTUDANTE',5),(6,NULL,NULL,'ESTUDANTE',6),(7,NULL,NULL,'ESTUDANTE',7),(9,NULL,NULL,'ESTUDANTE',9),(10,NULL,NULL,'ESTUDANTE',10),(12,NULL,NULL,'FUNCIONARIO',12),(13,NULL,NULL,'ESTUDANTE',13),(14,NULL,NULL,'FUNCIONARIO',14);
/*!40000 ALTER TABLE `perfil_utilizador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `nivel_academico` varchar(255) DEFAULT NULL,
  `id_cargo_fk` bigint DEFAULT NULL,
  `nome_professor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpdv2inyd9x17tbdsu9t9m97eo` (`id_cargo_fk`),
  CONSTRAINT `FKpdv2inyd9x17tbdsu9t9m97eo` FOREIGN KEY (`id_cargo_fk`) REFERENCES `cargo` (`id_cargo`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `renovacao_estudante`
--

DROP TABLE IF EXISTS `renovacao_estudante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `renovacao_estudante` (
  `cod_renovacao` bigint NOT NULL,
  `ano` bigint DEFAULT NULL,
  `semestre` bigint DEFAULT NULL,
  PRIMARY KEY (`cod_renovacao`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renovacao_estudante`
--

LOCK TABLES `renovacao_estudante` WRITE;
/*!40000 ALTER TABLE `renovacao_estudante` DISABLE KEYS */;
/*!40000 ALTER TABLE `renovacao_estudante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilizador`
--

DROP TABLE IF EXISTS `utilizador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizador` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `account_non_expired` bit(1) DEFAULT NULL,
  `account_non_locked` bit(1) DEFAULT NULL,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `credentials_non_expired` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `text_password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizador`
--

LOCK TABLES `utilizador` WRITE;
/*!40000 ALTER TABLE `utilizador` DISABLE KEYS */;
INSERT INTO `utilizador` VALUES (1,NULL,NULL,_binary '',_binary '','1ca6ebfa-c706-4d6b-a061-09290d7c8289',_binary '','admin@coder.com',_binary '','admin','$2a$10$GYH9LUInZew446DNGhitV.feqesw6chhQg8wTAKGfpI.IqeVPG1xG','admin','admin'),(3,NULL,NULL,_binary '',_binary '','56b0a66f-43ff-4469-b805-28e68c37cae9',_binary '','apj@coder.com',_binary '','apj','$2a$10$StvSpp.lgQg/9iTDhFj9tOCMTPe/4HRpgbJpSRF.0rXDV8lPDgxwK','apj123','apj'),(4,NULL,NULL,_binary '',_binary '','a2c11730-dfff-4cdf-accc-594d42bc1ccf',_binary '','jose@coder.com',_binary '','Jose Antonio','$2a$10$0ar.lnxe8dnXjg4lCNWOzOI78WB5yfjhBVbwkwr43S2HRYlUgxn7e','jose123','Jose Antonio'),(5,NULL,NULL,_binary '',_binary '','990e6098-54a3-44ab-959d-4643a632c9be',_binary '','pedro@coder.com',_binary '','Pedro Salvador','$2a$10$h3qn1z1a83M/bOQJ6wHY8OVEEsPsu0HYe4l6h6cfPg9T0uAkWip2q','pedro123','Pedro Salvador'),(6,NULL,NULL,_binary '',_binary '','9527df1c-56da-4cd4-bc7d-2e21a94fb022',_binary '','claudia@coder.com',_binary '','Claudia','$2a$10$ESfbDnn7s28kVpFh9sYHde01ZFgn1hYyUpOzCrF3tAPa2j7NAL2O6','claudia123','Claudia'),(7,NULL,NULL,_binary '',_binary '','f60d2bbe-5d40-4105-a1d5-42f98da277ca',_binary '','meek@coder.com',_binary '','Meek Mill','$2a$10$fCscMvdF0ww2cMjWJ60Q0O0oZw4zemnz2TLrwa2joVL9JgIttXHia','meek123','Meek Mill'),(9,NULL,NULL,_binary '',_binary '','9b78b476-29c5-4252-aac9-05053a479155',_binary '','john@coder.com',_binary '','John Due','$2a$10$KGboGYMrijiBMcHVpmvaYuHpFGfFd40cAzQVW1/JXxmwLWXBOSfM.','john123','John Due'),(10,NULL,NULL,_binary '',_binary '','46402ad3-0882-4227-8ecb-b78dcb634312',_binary '','tiago@coder.com',_binary '','Tiago','$2a$10$ySW/qu2BIYSTvLPHBxrFnePk2f2KnUjoWhR.dy8L7D65h7yuT6IlG','tiago123','Tiago'),(12,NULL,NULL,_binary '',_binary '','33b99bd3-8f7d-40d8-8776-af3caa15a0ed',_binary '','mariza@coder.com',_binary '','Mariza Santos','$2a$10$vE8deqv.hchyQTr.grQNX.TTk6LvX1XVsdKz36s4PXMb6s2PF.fWG','mariza123','Mariza Santos'),(13,NULL,NULL,_binary '',_binary '','8a3c3fde-05a6-43fc-a8d6-4a08509adae3',_binary '','mary@coder.com',_binary '','Maria Isabel','$2a$10$jF1vQuAWWxhwQJj3soD3gODYPmkXeoHgKbgITF5hGeHToR51OcI46','mary123','Maria Isabel'),(14,NULL,NULL,_binary '',_binary '','e3905253-3ec3-452e-a86c-f974faaa1e09',_binary '','joao@coder.com',_binary '','Joao Pelembe','$2a$10$dHKqBoWMHW4SomTDUlXZIe1yEQhNsQKBTwbzRliYjKBIpJxvu7cxO','joao123','Joao Pelembe');
/*!40000 ALTER TABLE `utilizador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-09 23:46:41
