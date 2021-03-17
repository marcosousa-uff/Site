-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 08-Fev-2021 às 17:35
-- Versão do servidor: 5.7.31
-- versão do PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `estoque`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categorias`
--

INSERT INTO `categorias` (`id`, `nome_categoria`) VALUES
(1, 'Eletrodoméstico'),
(2, 'Tv e Áudio');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `cpf`, `endereco`, `bairro`, `cidade`, `uf`, `cep`, `telefone`, `email`) VALUES
(1, 'Maria José', '515.831.890-50', 'Rua Nilo Pecanha 13', 'Ingá', 'Niterói', 'RJ', '24210480', '(21)654321789', 'maria@gmail.com'),
(2, 'Malu', '069.057.300-68', 'Rua Passos da partia', 'Boa Viagem', 'Niterói', 'RJ', '24210240', '(21)988617661', 'malu@yahoo.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `compras`
--

DROP TABLE IF EXISTS `compras`;
CREATE TABLE IF NOT EXISTS `compras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade_compra` int(11) NOT NULL,
  `data_compra` date NOT NULL,
  `valor_compra` int(11) NOT NULL,
  `id_fornecedor` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `id_comprador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fornecedor` (`id_fornecedor`),
  KEY `id_produto` (`id_produto`),
  KEY `id_comprador` (`id_comprador`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `compras`
--

INSERT INTO `compras` (`id`, `quantidade_compra`, `data_compra`, `valor_compra`, `id_fornecedor`, `id_produto`, `id_comprador`) VALUES
(1, 5, '2021-02-01', 8200, 1, 1, 3),
(2, 5, '2021-02-01', 3040, 2, 2, 3),
(3, 3, '2021-02-01', 1891, 2, 3, 3),
(4, 3, '2021-02-01', 14901, 2, 4, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
CREATE TABLE IF NOT EXISTS `fornecedores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razao_social` varchar(50) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`id`, `razao_social`, `cnpj`, `endereco`, `bairro`, `cidade`, `uf`, `cep`, `telefone`, `email`) VALUES
(1, 'LG', '34.051.454/0001-03', 'Rua Antonio Carlos 10', 'Vila Maria', 'São Paulo', 'RJ', '37511-000', '(11)123456789', 'lg@lg.com.br'),
(2, 'SANSUNG', '59.672.481/0001-24', 'Rua Alceu Wamosy', 'Vila Mariana', 'São Paulo', 'SP', '04105-040', '(11)987654321', 'sansung@sansung.com.br');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

DROP TABLE IF EXISTS `produtos`;
CREATE TABLE IF NOT EXISTS `produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(100) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `preco_compra` decimal(10,2) NOT NULL,
  `preco_venda` decimal(10,2) NOT NULL,
  `quantidade_disponível` int(11) NOT NULL,
  `liberado_venda` varchar(1) NOT NULL DEFAULT 'S',
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_categoria` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id`, `nome_produto`, `descricao`, `preco_compra`, `preco_venda`, `quantidade_disponível`, `liberado_venda`, `id_categoria`) VALUES
(1, 'Refrigerador Side by Side LG de 02 Portas Frost Free com 601 Litros', 'Refrigerador Side by Side LG de 02 Portas Frost Free com 601 Litros, Moist Balance Crisper™, Aço Escovado - GC-L247S', '8200.32', '11655.01', 5, 'S', 1),
(2, 'Refrigerador Bottom Freezer Samsung Barosa de 02 Portas Frost Free', 'Refrigerador Bottom Freezer Samsung Barosa de 02 Portas Frost Free com 435 L e Painel Eletrônico Inox Look - RL4353RBASL', '3040.31', '5600.99', 4, 'S', 1),
(3, 'Samsung Smart TV Crystal UHD TU8000 4K 50', 'Samsung Smart TV Crystal UHD TU8000 4K 50\", Borda Infinita, Alexa built in, Controle Único, Visual Livre de Cabos', '1890.90', '2690.99', 3, 'S', 2),
(4, 'Samsung Smart TV QLED 4K Q70T 85\"', 'Samsung Smart TV QLED 4K Q70T 85\", Pontos Quânticos, HDR, Borda Infinita, Alexa built in, Modo Ambiente 3.0', '14900.90', '17999.99', 3, 'S', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `cpf`, `senha`, `tipo`) VALUES
(1, 'Leo', '249.252.810-38', '111', '0'),
(2, 'Carlos', '081.599.500-80', '111', '1'),
(3, 'Pedro', '167.740.300-41', '111', '2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

DROP TABLE IF EXISTS `vendas`;
CREATE TABLE IF NOT EXISTS `vendas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade_venda` int(11) NOT NULL,
  `data_venda` date NOT NULL,
  `valor_venda` float NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_produto` (`id_produto`),
  KEY `id_vendedor` (`id_vendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `vendas`
--

INSERT INTO `vendas` (`id`, `quantidade_venda`, `data_venda`, `valor_venda`, `id_cliente`, `id_produto`, `id_vendedor`) VALUES
(1, 1, '2021-02-02', 5600.99, 1, 2, 2);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedores` (`id`),
  ADD CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`),
  ADD CONSTRAINT `compras_ibfk_3` FOREIGN KEY (`id_comprador`) REFERENCES `usuarios` (`id`);

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `produtos_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`);

--
-- Limitadores para a tabela `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `vendas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  ADD CONSTRAINT `vendas_ibfk_2` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`),
  ADD CONSTRAINT `vendas_ibfk_3` FOREIGN KEY (`id_vendedor`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
