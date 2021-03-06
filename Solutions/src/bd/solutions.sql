-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.26-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para solutions
CREATE DATABASE IF NOT EXISTS `solutions` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `solutions`;


-- Copiando estrutura para tabela solutions.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
    `cod_cliente` int auto_increment,
  `nome_cliente` varchar(100) DEFAULT NULL ,
  `endereco_cliente` varchar(100) DEFAULT NULL,
  `telefone_cliente` varchar(100) DEFAULT NULL,
  `email_cliente` varchar(50) DEFAULT NULL UNIQUE,
  PRIMARY KEY (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela solutions.equipamento
CREATE TABLE IF NOT EXISTS `os` (
  `os_os` int(11) auto_increment NOT NULL,
  `data_os` timestamp default CURRENT_TIMESTAMP,
  `tipo_os` varchar(15) NOT NULL,
  `situcao_os` varchar(20) NOT NULL,
  `equipamento_os` varchar(100) NOT NULL,
  `defeito_os` varchar(100) NOT NULL,
  `servico_os` varchar(100) DEFAULT NULL,
  `tecnico_os` varchar(50) DEFAULT NULL,
  `valor_os` decimal(10,2) NOT NULL,
  `cod_cliente` int not null,
  foreign key(cod_cliente) references cliente(cod_cliente),
  PRIMARY KEY (`os_os`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela solutions.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `cod_usuario`  int(11) NOT NULL,
  `nome_usuario` varchar(100) DEFAULT NULL,
  `fone_usuario` varchar(20) DEFAULT NULL,
  `login_usuario` varchar(50) DEFAULT NULL UNIQUE,
  `senha_usuario` varchar(20) DEFAULT NULL,
  `perfil_usuario` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SELECT * FROM `usuario`;
INSERT INTO `usuario` (`cod_usuario`, `nome_usuario`, `fone_usuario`, `login_usuario`, `senha_usuario`, `perfil_usuario`  ) VALUES (0, "Lucas Amorim", "9999999", "lucasamorim", "lucasamorim", "admin");
