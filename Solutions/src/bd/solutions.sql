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
  `cod_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(100) DEFAULT NULL,
  `cpf_cliente` varchar(100) DEFAULT NULL,
  `endereco_cliente` varchar(100) DEFAULT NULL,
  `telefone_cliente` varchar(100) DEFAULT NULL,
  `rg_cliente` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela solutions.equipamento
CREATE TABLE IF NOT EXISTS `equipamento` (
  `cod_equipamento` int(11) NOT NULL,
  `nome_equipamento` varchar(100) DEFAULT NULL,
  `modelo_equipamento` varchar(100) DEFAULT NULL,
  `observacoes_equipamentos` varchar(100) DEFAULT NULL,
  `cor_equipamento` varchar(100) DEFAULT NULL,
  `caracteristicas_equipametos` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_equipamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela solutions.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `cod_usuario` int(11) NOT NULL,
  `nome_usuario` varchar(100) DEFAULT NULL,
  `senha_usuario` varchar(100) DEFAULT NULL,
  `cpf_usuario` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
