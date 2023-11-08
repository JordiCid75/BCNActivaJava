
DROP DATABASE IF EXISTS `Pizzeria`;
CREATE DATABASE IF NOT EXISTS `Pizzeria`;
USE `Pizzeria`;

DROP TABLE IF EXISTS `Comanda`;
CREATE TABLE `Pizzeria`.`Comanda` (
  `IdComanda` INT NOT NULL AUTO_INCREMENT,
  `IdClient` INT NOT NULL,
  `DataHora` DATETIME NOT NULL,
  `IdTipusComanda` INT NOT NULL,
  `NumeroProductes` INT NULL,
  `PreuTotal` DECIMAL(10,2) NULL,
  `IdBotiga` INT NOT NULL,
  `IdEmpleat` INT NOT NULL,
  `DataHoraEntrega` DATETIME NULL,
  PRIMARY KEY (`IdComanda`),
  UNIQUE INDEX `IdComanda_UNIQUE` (`IdComanda` ASC) VISIBLE);

DROP TABLE IF EXISTS `TipusComanda`;
CREATE TABLE `Pizzeria`.`TipusComanda` (
  `IdTipusComanda` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(45) NULL,
  PRIMARY KEY (`IdTipusComanda`),
  UNIQUE INDEX `IdTipusComanda_UNIQUE` (`IdTipusComanda` ASC) VISIBLE);
  
DROP TABLE IF EXISTS `Client`;
CREATE TABLE `Pizzeria`.`Client` (
  `IdClient` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(100) NULL,
  `Cognoms` VARCHAR(100) NULL,
  `Adressa` VARCHAR(255) NULL,
  `IdLocalitat` INT NOT NULL,
  `IdProvincia` INT NOT NULL,
  `NumeroTelefon` VARCHAR(15) NULL,
  PRIMARY KEY (`IdClient`),
  UNIQUE INDEX `IdClient_UNIQUE` (`IdClient` ASC) VISIBLE);
  
DROP TABLE IF EXISTS `Localitat`;
CREATE TABLE `Localitat` (
  `IdLocalitat` int NOT NULL AUTO_INCREMENT,
  `IdProvincia` int NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdLocalitat`),
  UNIQUE KEY `IdLocalitat_UNIQUE` (`IdLocalitat`) VISIBLE,
  UNIQUE KEY `FK_LocalitatProvincia` (`IdLocalitat`,`IdProvincia`) VISIBLE 
);


DROP TABLE IF EXISTS `Provincia`;
CREATE TABLE `Pizzeria`.`Provincia` (
  `IdProvincia` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(255) NULL,
  PRIMARY KEY (`IdProvincia`),
  UNIQUE INDEX `IdProvincia_UNIQUE` (`IdProvincia` ASC) VISIBLE);
  
DROP TABLE IF EXISTS `ComandaDetall`;
CREATE TABLE `Pizzeria`.`ComandaDetall` (
  `IdComandaDetall` INT NOT NULL AUTO_INCREMENT,
  `IdComanda` INT NOT NULL,
  `IdProducte` INT NOT NULL,
  `PreuAplicat` DECIMAL(6,2) NULL,
  `Cantidad` DECIMAL(6,2) NULL,
  PRIMARY KEY (`IdComandaDetall`),
  UNIQUE INDEX `IdComandaDetall_UNIQUE` (`IdComandaDetall` ASC) VISIBLE);

DROP TABLE IF EXISTS `Producte`;
CREATE TABLE `Pizzeria`.`Producte` (
  `IdProducte` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(100) NULL,
  `Preu` DECIMAL(6,2) NULL,
  `Descripcio` VARCHAR(255) NULL,
  `IdCategoria` INT NULL,
  `IdSubCategoria` INT NULL,
  `ImatgeURL` VARCHAR(255) NULL,
  PRIMARY KEY (`IdProducte`),
  UNIQUE INDEX `IdProducte_UNIQUE` (`IdProducte` ASC) VISIBLE);
  
DROP TABLE IF EXISTS `Categoria`;
CREATE TABLE `Pizzeria`.`Categoria` (
  `IdCategoria` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(255) NULL,
  PRIMARY KEY (`IdCategoria`),
  UNIQUE INDEX `IdCategoria_UNIQUE` (`IdCategoria` ASC) VISIBLE);

DROP TABLE IF EXISTS `SubCategoria`;
CREATE TABLE `Pizzeria`.`SubCategoria` (
  `IdSubCategoria` INT NOT NULL AUTO_INCREMENT,
  `IdCategoria` INT NOT NULL,
  `Nom` VARCHAR(255) NULL,
  PRIMARY KEY (`IdSubCategoria`),
  UNIQUE KEY `IdSubCategoria_UNIQUE` (`IdSubCategoria` ASC) VISIBLE,
  UNIQUE KEY `FK_CategoriaSubCategoria` (`IdCategoria`, `IdSubCategoria`) VISIBLE)
;

DROP TABLE IF EXISTS `Botiga`;
CREATE TABLE `Pizzeria`.`Botiga` (
  `IdBotiga` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(100) NULL,
  `Adressa` VARCHAR(255) NULL,
  `IdLocalitat` INT NOT NULL,
  `IdProvincia` INT NOT NULL,
  PRIMARY KEY (`IdBotiga`),
  UNIQUE INDEX `IdBotiga_UNIQUE` (`IdBotiga` ASC) VISIBLE);
  
DROP TABLE IF EXISTS `Empleats`;
CREATE TABLE `Pizzeria`.`Empleats` (
  `IdEmpleat` INT NOT NULL AUTO_INCREMENT,
  `IdTipusEmpleat` INT NOT NULL,
  `Nom` VARCHAR(100) NULL,
  `IdBotiga` INT NOT NULL,
  PRIMARY KEY (`IdEmpleat`),
  UNIQUE INDEX `IdEmpleat_UNIQUE` (`IdEmpleat` ASC) VISIBLE);

DROP TABLE IF EXISTS `TipusEmpleat`;
CREATE TABLE `Pizzeria`.`TipusEmpleat` (
  `IdTipusEmpleat` INT NOT NULL AUTO_INCREMENT,
  `Nom` VARCHAR(100) NULL,
  PRIMARY KEY (`IdTipusEmpleat`),
  UNIQUE INDEX `IdTipusEmpleat_UNIQUE` (`IdTipusEmpleat` ASC) VISIBLE);
  
  /* Ahora añadimos las relaciones entre las tablas*/
ALTER TABLE `Pizzeria`.`Empleats` 
ADD INDEX `FK_Empleats_TipusEmpleat_idx` (`IdTipusEmpleat` ASC) VISIBLE,
ADD INDEX `FK_Empleats_Botiga_idx` (`IdBotiga` ASC) VISIBLE;
;
ALTER TABLE `Pizzeria`.`Empleats` 
ADD CONSTRAINT `FK_Empleats_TipusEmpleat`
  FOREIGN KEY (`IdTipusEmpleat`)
  REFERENCES `Pizzeria`.`TipusEmpleat` (`IdTipusEmpleat`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_Empleats_Botiga`
  FOREIGN KEY (`IdBotiga`)
  REFERENCES `Pizzeria`.`Botiga` (`IdBotiga`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `Pizzeria`.`Comanda` 
ADD INDEX `FK_Comanda_Client_idx` (`IdClient` ASC) VISIBLE,
ADD INDEX `FK_Comanda_TipusComanda_idx` (`IdTipusComanda` ASC) VISIBLE,
ADD INDEX `FK_Comanda_Botiga_idx` (`IdBotiga` ASC) VISIBLE,
ADD INDEX `FK_Comanda_Empleat_idx` (`IdEmpleat` ASC) VISIBLE;
;
ALTER TABLE `Pizzeria`.`Comanda` 
ADD CONSTRAINT `FK_Comanda_Client`
  FOREIGN KEY (`IdClient`)
  REFERENCES `Pizzeria`.`Client` (`IdClient`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_Comanda_TipusComanda`
  FOREIGN KEY (`IdTipusComanda`)
  REFERENCES `Pizzeria`.`TipusComanda` (`IdTipusComanda`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_Comanda_Botiga`
  FOREIGN KEY (`IdBotiga`)
  REFERENCES `Pizzeria`.`Botiga` (`IdBotiga`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_Comanda_Empleat`
  FOREIGN KEY (`IdEmpleat`)
  REFERENCES `Pizzeria`.`Empleats` (`IdEmpleat`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



ALTER TABLE `Pizzeria`.`Botiga` 
ADD INDEX `FK_Botiga_LocalitatProvincia_idx` (`IdLocalitat` ASC, `IdProvincia` ASC) VISIBLE
;
ALTER TABLE `Pizzeria`.`Botiga` 
ADD CONSTRAINT `FK_Botica_LocalitatProvincia`
  FOREIGN KEY (`IdLocalitat` , `IdProvincia`)
  REFERENCES `Pizzeria`.`Localitat` (`IdLocalitat` , `IdProvincia`);


ALTER TABLE `Pizzeria`.`Localitat` 
ADD INDEX `FK_Localitat_Provincia_idx` (`IdProvincia` ASC) VISIBLE;
;
ALTER TABLE `Pizzeria`.`Localitat` 
ADD CONSTRAINT `FK_Localitat_Provincia`
  FOREIGN KEY (`IdProvincia`)
  REFERENCES `Pizzeria`.`Provincia` (`IdProvincia`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `Pizzeria`.`Client` 
ADD INDEX `FK_Client_LocalitatProvincia_idx` (`IdLocalitat` ASC, `IdProvincia` ASC) VISIBLE;
;
ALTER TABLE `Pizzeria`.`Client` 
ADD CONSTRAINT `FK_Client_LocalitatProvincia`
  FOREIGN KEY (`IdLocalitat` , `IdProvincia`)
  REFERENCES `Pizzeria`.`Localitat` (`IdLocalitat` , `IdProvincia`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `Pizzeria`.`ComandaDetall` 
ADD INDEX `FK_ComandaDetall_Producte_idx` (`IdProducte` ASC) VISIBLE,
ADD INDEX `FK_ComandaDetall_Comanda_idx` (`IdComanda` ASC) VISIBLE;
;
ALTER TABLE `Pizzeria`.`ComandaDetall` 
ADD CONSTRAINT `FK_ComandaDetall_Producte`
  FOREIGN KEY (`IdProducte`)
  REFERENCES `Pizzeria`.`Producte` (`IdProducte`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_ComandaDetall_Comanda`
  FOREIGN KEY (`IdComanda`)
  REFERENCES `Pizzeria`.`Comanda` (`IdComanda`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `Pizzeria`.`Producte` 
ADD INDEX `FK_Producte_SubCategoria_idx` (`IdCategoria` ASC) VISIBLE;
;
ALTER TABLE `Pizzeria`.`Producte` 
ADD CONSTRAINT `FK_Producte_SubCategoria`
  FOREIGN KEY (`IdCategoria`, `IdSubCategoria`)
  REFERENCES `Pizzeria`.`SubCategoria` (`IdCategoria`, `IdSubCategoria`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `Pizzeria`.`SubCategoria` 
ADD INDEX `FK_SubCategoria_Categoria_idx` (`IdCategoria` ASC) VISIBLE;
;
ALTER TABLE `Pizzeria`.`SubCategoria` 
ADD CONSTRAINT `FK_SubCategoria_Categoria`
  FOREIGN KEY (`IdCategoria`)
  REFERENCES `Pizzeria`.`Categoria` (`IdCategoria`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



/* Ahora a rellenar datos*/

INSERT INTO `Pizzeria`.`Provincia`
(`Nom`)
VALUES
("Barcelona");
INSERT INTO `Pizzeria`.`Provincia`
(`Nom`)
VALUES
("Gerona");
INSERT INTO `Pizzeria`.`Provincia`
(`Nom`)
VALUES
("Lleida");
INSERT INTO `Pizzeria`.`Provincia`
(`Nom`)
VALUES
("Tarragona");

INSERT INTO `Pizzeria`.`Localitat`
(`IdProvincia`,`Nom`)
VALUES
(1,"Barcelona Ciutat");
INSERT INTO `Pizzeria`.`Localitat`
(`IdProvincia`,`Nom`)
VALUES
(1,"Badalona");
INSERT INTO `Pizzeria`.`Localitat`
(`IdProvincia`,`Nom`)
VALUES
(1,"Hospitalet");


INSERT INTO `Pizzeria`.`Localitat`
(`IdProvincia`,`Nom`)
VALUES
(2,"Gerona Ciutat");
INSERT INTO `Pizzeria`.`Localitat`
(`IdProvincia`,`Nom`)
VALUES
(3,"Lleida Ciutat");
INSERT INTO `Pizzeria`.`Localitat`
(`IdProvincia`,`Nom`)
VALUES
(4,"Tarragona CiutaT");

INSERT INTO `Pizzeria`.`TipusComanda`
(`Nom`)
VALUES
("A Domicili");

INSERT INTO `Pizzeria`.`TipusComanda`
(`Nom`)
VALUES
("Recollir en Botiga");

INSERT INTO `Pizzeria`.`Categoria`
(`Nom`)
VALUES
("Begudes");
INSERT INTO `Pizzeria`.`Categoria`
(`Nom`)
VALUES
("Hamburguesses");
INSERT INTO `Pizzeria`.`Categoria`
(`Nom`)
VALUES
("Pizzes");

INSERT INTO `Pizzeria`.`SubCategoria`
(`IdCategoria`, `Nom`)
VALUES
(1,"Begudes");
INSERT INTO `Pizzeria`.`SubCategoria`
(`IdCategoria`, `Nom`)
VALUES
(2,"Hamburguesses");
INSERT INTO `Pizzeria`.`SubCategoria`
(`IdCategoria`, `Nom`)
VALUES
(3,"Tipus Pizza 1");
INSERT INTO `Pizzeria`.`SubCategoria`
(`IdCategoria`, `Nom`)
VALUES
(3,"Tipus Pizza 2");
INSERT INTO `Pizzeria`.`SubCategoria`
(`IdCategoria`, `Nom`)
VALUES
(3,"Tipus Pizza 3");

INSERT INTO `Pizzeria`.`TipusEmpleat`
(`Nom`)
VALUES
("Cuiner");
INSERT INTO `Pizzeria`.`TipusEmpleat`
(`Nom`)
VALUES
("Repartidor");



INSERT INTO `Pizzeria`.`Botiga`
(`Nom`, `Adressa`, `IdLocalitat`, `IdProvincia`)
VALUES
("Botiga Barcelona 1", "Adreça Barcelona Ciutat", 1, 1);
INSERT INTO `Pizzeria`.`Botiga`
(`Nom`, `Adressa`, `IdLocalitat`, `IdProvincia`)
VALUES
("Botiga Barcelona 2", "Adreça Barcelona Hospitalet", 3, 1);
INSERT INTO `Pizzeria`.`Botiga`
(`Nom`, `Adressa`, `IdLocalitat`, `IdProvincia`)
VALUES
("Botiga Barcelona 3", "Adreça Barcelona Badalona", 2, 1);
INSERT INTO `Pizzeria`.`Botiga`
(`Nom`, `Adressa`, `IdLocalitat`, `IdProvincia`)
VALUES
("Botiga Gerona", "Adreça Gerona", 4, 2);
INSERT INTO `Pizzeria`.`Botiga`
(`Nom`, `Adressa`, `IdLocalitat`, `IdProvincia`)
VALUES
("Botiga Lleida", "Adreça Lleida", 5, 3);
INSERT INTO `Pizzeria`.`Botiga`
(`Nom`, `Adressa`, `IdLocalitat`, `IdProvincia`)
VALUES
("Botiga Tarragona", "Adreça Tarragona", 6, 4);


INSERT INTO `Pizzeria`.`Empleats`
(`IdTipusEmpleat`, `Nom`, `IdBotiga`)
VALUES
(1, "Cuiner 1", 1);
INSERT INTO `Pizzeria`.`Empleats`
(`IdTipusEmpleat`, `Nom`, `IdBotiga`)
VALUES
(1, "Cuiner 2", 1);
INSERT INTO `Pizzeria`.`Empleats`
(`IdTipusEmpleat`, `Nom`, `IdBotiga`)
VALUES
(2, "Repartidor 1", 1);
INSERT INTO `Pizzeria`.`Empleats`
(`IdTipusEmpleat`, `Nom`, `IdBotiga`)
VALUES
(2, "Repartidor 2", 1);
INSERT INTO `Pizzeria`.`Empleats`
(`IdTipusEmpleat`, `Nom`, `IdBotiga`)
VALUES
(2, "Repartidor 3", 1);
INSERT INTO `Pizzeria`.`Empleats`
(`IdTipusEmpleat`, `Nom`, `IdBotiga`)
VALUES
(2, "Repartidor 4", 1);
INSERT INTO `Pizzeria`.`Empleats`
(`IdTipusEmpleat`, `Nom`, `IdBotiga`)
VALUES
(2, "Repartidor 5", 1);


INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Beguda 1", 3, "Descripcio Beguda 1", 1, null, 1);
INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Beguda 2", 2, "Descripcio Beguda 2", 1, null, 1);
INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Beguda 3", 5, "Descripcio Beguda 3", 1, null, 1);
INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Hamburguessa 1", 7, "Descripcio Hamburguessa 1", 2, null, 2);
INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Hamburguessa 2", 10, "Descripcio Hamburguessa 2", 2, null, 2);
INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Hamburguessa 3", 15, "Descripcio Hamburguessa 3", 2, null, 2);
INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Pizza 1", 10, "Descripcio Pizza 1", 3, null, 3);
INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Pizza 2", 20, "Descripcio Pizza 2", 3, null, 4);
INSERT INTO `Pizzeria`.`Producte`
(`Nom`, `Preu`, `Descripcio`, `IdCategoria`, `ImatgeURL`, `IdSubcategoria`)
VALUES
("Pizza 3", 30, "Descripcio Pizza 3", 3, null, 5);


INSERT INTO `Pizzeria`.`Client`
(`Nom`, `Cognoms`, `Adressa`, `IdLocalitat`, `IdProvincia`, `NumeroTelefon`)
VALUES
("Nom Client 1", "Cognom Client 1", "Adreça Client 1", 1, 1, "111111111");
INSERT INTO `Pizzeria`.`Client`
(`Nom`, `Cognoms`, `Adressa`, `IdLocalitat`, `IdProvincia`, `NumeroTelefon`)
VALUES
("Nom Client 2", "Cognom Client 2", "Adreça Client 2", 2, 1, "222222222");
INSERT INTO `Pizzeria`.`Client`
(`Nom`, `Cognoms`, `Adressa`, `IdLocalitat`, `IdProvincia`, `NumeroTelefon`)
VALUES
("Nom Client 3", "Cognom Client 3", "Adreça Client 3", 3, 1, "333333333");
INSERT INTO `Pizzeria`.`Client`
(`Nom`, `Cognoms`, `Adressa`, `IdLocalitat`, `IdProvincia`, `NumeroTelefon`)
VALUES
("Nom Client 4", "Cognom Client 4", "Adreça Client 4", 4, 2, "444444444");
INSERT INTO `Pizzeria`.`Client`
(`Nom`, `Cognoms`, `Adressa`, `IdLocalitat`, `IdProvincia`, `NumeroTelefon`)
VALUES
("Nom Client 5", "Cognom Client 5", "Adreça Client 5", 5, 3, "555555555");
INSERT INTO `Pizzeria`.`Client`
(`Nom`, `Cognoms`, `Adressa`, `IdLocalitat`, `IdProvincia`, `NumeroTelefon`)
VALUES
("Nom Client 6", "Cognom Client 6", "Adreça Client 6", 6, 4, "666666666");



INSERT INTO `Pizzeria`.`Comanda`
(`IdClient`, `DataHora`, `IdTipusComanda`, `NumeroProductes`, `PreuTotal`, `IdBotiga`, `IdEmpleat`, `DataHoraEntrega`)
VALUES
(1, NOW(), 1, 0, 0, 1, 3, curdate());
INSERT INTO `Pizzeria`.`ComandaDetall`
(`IdComanda`, `IdProducte`, `PreuAplicat`, `Cantidad`)
VALUES
(1, 1, 0, 1),
(1, 2, 0, 2),
(1, 4, 0, 1),
(1, 7, 0, 1)
;



INSERT INTO `Pizzeria`.`Comanda`
(`IdClient`, `DataHora`, `IdTipusComanda`, `NumeroProductes`, `PreuTotal`, `IdBotiga`, `IdEmpleat`, `DataHoraEntrega`)
VALUES
(2, NOW(), 1, 0, 0, 1, 3, curdate());
INSERT INTO `Pizzeria`.`ComandaDetall`
(`IdComanda`, `IdProducte`, `PreuAplicat`, `Cantidad`)
VALUES
(2, 2, 0, 2),
(2, 3, 0, 1),
(2, 5, 0, 1),
(2, 8, 0, 1)
;



INSERT INTO `Pizzeria`.`Comanda`
(`IdClient`, `DataHora`, `IdTipusComanda`, `NumeroProductes`, `PreuTotal`, `IdBotiga`, `IdEmpleat`, `DataHoraEntrega`)
VALUES
(3, NOW(), 1, 0, 0, 1, 3, curdate());
INSERT INTO `Pizzeria`.`ComandaDetall`
(`IdComanda`, `IdProducte`, `PreuAplicat`, `Cantidad`)
VALUES
(3, 3, 0, 2),
(3, 3, 0, 1),
(3, 6, 0, 1),
(3, 9, 0, 1)
;



INSERT INTO `Pizzeria`.`Comanda`
(`IdClient`, `DataHora`, `IdTipusComanda`, `NumeroProductes`, `PreuTotal`, `IdBotiga`, `IdEmpleat`, `DataHoraEntrega`)
VALUES
(4, NOW(), 2, 0, 0, 1, 1, curdate());
INSERT INTO `Pizzeria`.`ComandaDetall`
(`IdComanda`, `IdProducte`, `PreuAplicat`, `Cantidad`)
VALUES
(4, 1, 0, 3),
(4, 2, 0, 2),
(4, 5, 0, 3),
(4, 6, 0, 4)
;



INSERT INTO `Pizzeria`.`Comanda`
(`IdClient`, `DataHora`, `IdTipusComanda`, `NumeroProductes`, `PreuTotal`, `IdBotiga`, `IdEmpleat`, `DataHoraEntrega`)
VALUES
(2, NOW(), 1, 0, 0, 1, 3, curdate());

INSERT INTO `Pizzeria`.`ComandaDetall`
(`IdComanda`, `IdProducte`, `PreuAplicat`, `Cantidad`)
VALUES
(5, 1, 0, 2),
(5, 1, 0, 4),
(5, 9, 0, 2),
(5, 7, 0, 4)
;

UPDATE `Pizzeria`.`ComandaDetall` cd 
inner join `Pizzeria`.`Producte` p on cd.`IdProducte` = p.`IdProducte`
SET cd.`PreuAplicat` = p.`Preu` * cd.`Cantidad`;

UPDATE `Pizzeria`.`Comanda` c, 
(SELECT `IdComanda`,SUM(`PreuAplicat`) as cdsumPreu, COUNT(`IdProducte`) as cdNumProd FROM `Pizzeria`.`ComandaDetall`
GROUP BY `IdComanda`) as cdt
SET
c.`PreuTotal` = cdt.`cdsumPreu`,
c.`NumeroProductes` = cdt.`cdNumProd`
WHERE c.`IdComanda` = cdt.`IdComanda`;



