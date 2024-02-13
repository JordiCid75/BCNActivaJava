DROP DATABASE IF EXISTS `culampolla`;
CREATE DATABASE IF NOT EXISTS `culampolla`;
USE `culampolla`;

DROP TABLE IF EXISTS `Proveidor`;
CREATE TABLE `culampolla`.`Proveidor` (
  `IdProveidor` INT NOT NULL AUTO_INCREMENT,
  `IdAddress` INT NULL,
  `Nom` VARCHAR(255) NOT NULL,
  `Telefon` VARCHAR(40) NULL,
  `Fax` VARCHAR(40) NULL,
  `NIF` VARCHAR(10) NULL,
  PRIMARY KEY (`IdProveidor`),
  UNIQUE INDEX `IdProveidor_UNIQUE` (`IdProveidor` ASC) VISIBLE);

  DROP TABLE IF EXISTS `Ciutats`;
  CREATE TABLE `culampolla`.`Ciutats` (
  `IdCiutat` INT NOT NULL AUTO_INCREMENT,
  `IdPais` INT NOT NULL,
  `NomCiutat` VARCHAR(255) NULL,
  PRIMARY KEY (`IdCiutat`),
  UNIQUE INDEX `IdCiutat_UNIQUE` (`IdCiutat` ASC) VISIBLE);
  
  DROP TABLE IF EXISTS `Paisos`;
  CREATE TABLE `culampolla`.`Paisos` (
  `IdPais` INT NOT NULL AUTO_INCREMENT,
  `NomPais` VARCHAR(255) NULL,
  PRIMARY KEY (`IdPais`),
  UNIQUE INDEX `IdPais_UNIQUE` (`IdPais` ASC) VISIBLE);

  DROP TABLE IF EXISTS `Address`;
  CREATE TABLE `culampolla`.`Address` (
  `IdAddress` INT NOT NULL AUTO_INCREMENT,
  `Carrer` VARCHAR(100) NULL,
  `Numero` INT NULL,
  `Pis` VARCHAR(45) NULL,
  `Porta` VARCHAR(45) NULL,
  `IdCiutat` INT NOT NULL,
  `CodiPostal` VARCHAR(5) NULL,
  PRIMARY KEY (`IdAddress`),
  UNIQUE INDEX `IdAddress_UNIQUE` (`IdAddress` ASC) VISIBLE);

  DROP TABLE IF EXISTS `Ulleres`;
  CREATE TABLE `culampolla`.`Ulleres` (
  `IdUlleres` INT NOT NULL AUTO_INCREMENT,
  `IdMarca` INT NOT NULL,
  `IdTipusMontura` INT NOT NULL,
  `ColorMontura` VARCHAR(100) NULL,
  `Preu` DECIMAL(7,2) NULL,
  PRIMARY KEY (`IdUlleres`),
  UNIQUE INDEX `IdUlleres_UNIQUE` (`IdUlleres` ASC) VISIBLE);
 
  DROP TABLE IF EXISTS `Marca`;
  CREATE TABLE `culampolla`.`Marca` (
  `IdMarca` INT NOT NULL AUTO_INCREMENT,
  `NomMarca` VARCHAR(255) NULL,
  `IdProveidor` INT NOT NULL,
  PRIMARY KEY (`IdMarca`),
  UNIQUE INDEX `IdMarca_UNIQUE` (`IdMarca` ASC) VISIBLE);

  DROP TABLE IF EXISTS `Venedors`;
  CREATE TABLE `culampolla`.`Venedors` (
  `IdVenedor` INT NOT NULL AUTO_INCREMENT,
  `NomVenedor` VARCHAR(255) NULL,
  PRIMARY KEY (`IdVenedor`),
  UNIQUE INDEX `IdVenedor_UNIQUE` (`IdVenedor` ASC) VISIBLE);

  DROP TABLE IF EXISTS `Venda`;
  CREATE TABLE `culampolla`.`Venda` (
  `IdVenda` INT NOT NULL AUTO_INCREMENT,
  `IdVenedor` INT NOT NULL,
  `IdClient` INT NULL,
  `DataVenda` DATETIME NULL,
  `PreuTotal` DECIMAL(10,2) NULL,
  PRIMARY KEY (`IdVenda`),
  UNIQUE INDEX `IdVenda_UNIQUE` (`IdVenda` ASC) VISIBLE);

  DROP TABLE IF EXISTS `VendaDetall`;
  CREATE TABLE `culampolla`.`VendaDetall` (
  `IdDetall` INT NOT NULL AUTO_INCREMENT,
  `IdVenda` INT NOT NULL,
  `IdUlleres` INT NOT NULL,
  `Preu` DECIMAL(7,2) NULL,
  `GradVE` DECIMAL(4,2) NULL,
  `GradVD` DECIMAL(4,2) NULL,
  `ColorVE` VARCHAR(100) NULL,
  `ColorVD` VARCHAR(100) NULL,
  PRIMARY KEY (`IdDetall`),
  UNIQUE INDEX `IdDetall_UNIQUE` (`IdDetall` ASC) VISIBLE);


  DROP TABLE IF EXISTS `Clients`;
  CREATE TABLE `culampolla`.`Clients` (
  `IdClient` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(255) NULL,
  `IdAddress` INT NULL,
  `Telefon` VARCHAR(30) NULL,
  `email` VARCHAR(150) NULL,
  `DataRegistre` DATETIME NULL,
  `IdClientRecomanat` INT NULL,
  PRIMARY KEY (`IdClient`),
  UNIQUE INDEX `IdClient_UNIQUE` (`IdClient` ASC) VISIBLE);


/* Creamos las relaciones aqui */  
ALTER TABLE `culampolla`.`Proveidor` 
ADD INDEX `FK_Proveidor_address_idx` (`IdAddress` ASC) VISIBLE;
;
ALTER TABLE `culampolla`.`Proveidor` 
ADD CONSTRAINT `FK_Proveidor_address`
  FOREIGN KEY (`IdAddress`)
  REFERENCES `culampolla`.`Address` (`idAddress`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `culampolla`.`Address` 
ADD INDEX `FK_Address_Ciutats_idx` (`IdCiutat` ASC) VISIBLE;
;
ALTER TABLE `culampolla`.`Address` 
ADD CONSTRAINT `FK_Address_Ciutats`
  FOREIGN KEY (`IdCiutat`)
  REFERENCES `culampolla`.`Ciutats` (`IdCiutat`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `culampolla`.`Ciutats` 
ADD INDEX `FK_Ciutat_Pais_idx` (`IdPais` ASC) VISIBLE;
;
ALTER TABLE `culampolla`.`Ciutats` 
ADD CONSTRAINT `FK_Ciutat_Pais`
  FOREIGN KEY (`IdPais`)
  REFERENCES `culampolla`.`Paisos` (`IdPais`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  CREATE TABLE `culampolla`.`TipusMontura` (
  `IdTipusMontura` INT NOT NULL AUTO_INCREMENT,
  `NomTipus` VARCHAR(255) NULL,
  PRIMARY KEY (`IdTipusMontura`),
  UNIQUE INDEX `IdTipusMontura_UNIQUE` (`IdTipusMontura` ASC) VISIBLE);

ALTER TABLE `culampolla`.`Clients` 
ADD INDEX `FK_Clients_ClientRecomanat_idx` (`IdClientRecomanat` ASC) VISIBLE,
ADD INDEX `FK_Clients_Address_idx` (`IdAddress` ASC) VISIBLE
;
ALTER TABLE `culampolla`.`Clients` 
ADD CONSTRAINT `FK_Clients_ClientRecomanat`
  FOREIGN KEY (`IdClientRecomanat`)
  REFERENCES `culampolla`.`Clients` (`IdClient`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_Clients_Address`
  FOREIGN KEY (`IdAddress`)
  REFERENCES `culampolla`.`Address` (`idAddress`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `culampolla`.`ulleres` 
ADD INDEX `FK_Ulleres_TipusMontura_idx` (`idTipusMontura` ASC) VISIBLE
;
ALTER TABLE `culampolla`.`Marca` 
ADD INDEX `FK_Marca_Proveidor_idx` (`IdProveidor` ASC) VISIBLE,
ADD CONSTRAINT `FK_Ulleres_Proveidor`
  FOREIGN KEY (`IdProveidor`)
  REFERENCES `culampolla`.`Proveidor` (`IdProveidor`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
;
ALTER TABLE `culampolla`.`ulleres` 
ADD CONSTRAINT `FK_Ulleres_TipusMontura`
  FOREIGN KEY (`idTipusMontura`)
  REFERENCES `culampolla`.`TipusMontura` (`IdTipusMontura`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `culampolla`.`VendaDetall` 
ADD INDEX `FK_VendaDetall_Venda_idx` (`IdVenda` ASC) VISIBLE,
ADD INDEX `FK_VendaDetall_Ulleres_idx` (`IdUlleres` ASC) VISIBLE;
;
ALTER TABLE `culampolla`.`VendaDetall` 
ADD CONSTRAINT `FK_VendaDetall_Venda`
  FOREIGN KEY (`IdVenda`)
  REFERENCES `culampolla`.`Venda` (`IdVenda`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_VendaDetall_Ulleres`
  FOREIGN KEY (`IdUlleres`)
  REFERENCES `culampolla`.`Ulleres` (`IdUlleres`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `culampolla`.`Venda` 
ADD INDEX `FK_Venda_Venedor_idx` (`IdVenedor` ASC) VISIBLE,
ADD INDEX `FK_Venda_Client_idx` (`IdClient` ASC) VISIBLE;
;
ALTER TABLE `culampolla`.`Venda` 
ADD CONSTRAINT `FK_Venda_Venedor`
  FOREIGN KEY (`IdVenedor`)
  REFERENCES `culampolla`.`Venedors` (`IdVenedor`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_Venda_Client`
  FOREIGN KEY (`IdClient`)
  REFERENCES `culampolla`.`Clients` (`IdClient`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

/* Insertamos algunos datos en las tablas*/
INSERT INTO `culampolla`.`Paisos`
(`NomPais`)
VALUES
("Espanya");
INSERT INTO `culampolla`.`Paisos`
(`NomPais`)
VALUES
("Suissa");
INSERT INTO `culampolla`.`Paisos`
(`NomPais`)
VALUES
("Italia");
INSERT INTO `culampolla`.`Ciutats`
(`IdPais`,`NomCiutat`)
VALUES
(1,"Barcelona");
INSERT INTO `culampolla`.`Ciutats`
(`IdPais`,`NomCiutat`)
VALUES
(1,"Tarragona");
INSERT INTO `culampolla`.`Ciutats`
(`IdPais`,`NomCiutat`)
VALUES
(2,"Zurich");
INSERT INTO `culampolla`.`Ciutats`
(`IdPais`,`NomCiutat`)
VALUES
(3,"Roma");

INSERT INTO `culampolla`.`Address`
(`carrer`,`numero`,`pis`,`porta`,`IdCiutat`,`codiPostal`)
VALUES
("Calle uno",1,"1º","2ª",2,"08005");
INSERT INTO `culampolla`.`Address`
(`carrer`,`numero`,`pis`,`porta`,`IdCiutat`,`codiPostal`)
VALUES
("Calle dos",1,"2º","3ª",1,"08005");
INSERT INTO `culampolla`.`Venedors`
(`NomVenedor`)
VALUES
("Venedor1");
INSERT INTO `culampolla`.`Venedors`
(`NomVenedor`)
VALUES
("Venedor2");
INSERT INTO `culampolla`.`Proveidor`
(`IdAddress`, `Nom`, `Telefon`, `Fax`, `NIF`)
VALUES
(1,"Proveidor1","555666777",null,"R45555555");
INSERT INTO `culampolla`.`Proveidor`
(`IdAddress`, `Nom`, `Telefon`, `Fax`, `NIF`)
VALUES
(2,"Proveidor2","888888888",null,"A465321345");
INSERT INTO `culampolla`.`TipusMontura`
(`NomTipus`)
VALUES
("Montura1");
INSERT INTO `culampolla`.`TipusMontura`
(`NomTipus`)
VALUES
("Montura2");
INSERT INTO `culampolla`.`Clients`
(`Nom`, `IdAddress`, `Telefon`, `email`, `DataRegistre`, `IdClientRecomanat`)
VALUES
("Client1", 2, "3333333", "emailclient1@client1.com", sysdate(),null);
INSERT INTO `culampolla`.`Clients`
(`Nom`, `IdAddress`, `Telefon`, `email`, `DataRegistre`, `IdClientRecomanat`)
VALUES
("Client2", 1, "444444", "emailclient2@client2.com", sysdate(),null);

INSERT INTO `culampolla`.`Marca`
(`NomMarca`, `IdProveidor`)
VALUES
("Marca1", 1);

INSERT INTO `culampolla`.`Marca`
(`NomMarca`, `IdProveidor`)
VALUES
("Marca2", 1);

INSERT INTO `culampolla`.`Marca`
(`NomMarca`, `IdProveidor`)
VALUES
("Marca3", 2);

INSERT INTO `culampolla`.`ulleres`
(`IdMarca`, `IdTipusMontura`, `ColorMontura`, `Preu`)
VALUES
(1, 1, "Blau", 150.65);
INSERT INTO `culampolla`.`ulleres`
(`IdMarca`, `IdTipusMontura`, `ColorMontura`, `Preu`)
VALUES
(2, 1, "Negre", 100.65);
INSERT INTO `culampolla`.`ulleres`
(`IdMarca`, `IdTipusMontura`, `ColorMontura`, `Preu`)
VALUES
(3, 2, "Vermella", 56.65);

INSERT INTO `culampolla`.`Venda`
(`IdVenedor`, `IdClient`, `DataVenda`, `PreuTotal`)
VALUES
(1, 1, DATE_ADD(NOW(),INTERVAL -6 MONTH), 0);
INSERT INTO `culampolla`.`Venda`
(`IdVenedor`, `IdClient`, `DataVenda`, `PreuTotal`)
VALUES
(1, 2, DATE_ADD(NOW(),INTERVAL -2 MONTH), 0);
INSERT INTO `culampolla`.`Venda`
(`IdVenedor`, `IdClient`, `DataVenda`, `PreuTotal`)
VALUES
(2, 1, DATE_ADD(NOW(),INTERVAL -1 MONTH), 0);
INSERT INTO `culampolla`.`Venda`
(`IdVenedor`, `IdClient`, `DataVenda`, `PreuTotal`)
VALUES
(2, 1, DATE_ADD(NOW(),INTERVAL -3 MONTH), 0);
INSERT INTO `culampolla`.`Venda`
(`IdVenedor`, `IdClient`, `DataVenda`, `PreuTotal`)
VALUES
(2, 1, DATE_ADD(NOW(),INTERVAL -4 MONTH), 0);



INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(1, 1, 0, 1, 1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(2, 2, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(2, 2, 0, 2.4,2.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(2, 2, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(3, 1, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(3, 2, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(3, 2, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(3, 1, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(4, 1, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(4, 2, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(4, 2, 0, 2.1, 1.1, null,null);
INSERT INTO `culampolla`.`VendaDetall`
(`IdVenda`, `IdUlleres`, `Preu`, `GradVE`, `GradVD`, `ColorVE`, `ColorVD`)
VALUES
(5, 2, 0, 2.1, 1.1, null,null);




UPDATE `culampolla`.`VendaDetall` vd 
inner join `culampolla`.`Ulleres` u on vd.`IdUlleres` = u.`IdUlleres`
SET vd.`Preu` = u.`Preu`;

UPDATE `culampolla`.`Venda` v, 
(SELECT `IdVenda`,SUM(`Preu`) as vdsumPreu FROM `culampolla`.`VendaDetall`
GROUP BY `IdVenda`) as vdt
SET
v.`PreuTotal` = vdt.`vdsumPreu`
WHERE v.`IdVenda` = vdt.`IdVenda`;

