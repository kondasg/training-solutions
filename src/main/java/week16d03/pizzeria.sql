CREATE DATABASE `pizzeria`;
USE `pizzeria`;

DROP TABLE IF EXISTS `pizza`;
CREATE TABLE `pizza` (
	`pizza_id` INT(10) UNSIGNED NOT NULL,
	`pizza_name` VARCHAR(100) NOT NULL,
	`pizza_price` FLOAT NOT NULL,
	PRIMARY KEY (`pizza_id`)
);

INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (1, "Egyes", 600.0);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (2, "Kettes", 850.0);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (3, "Hármas", 910.0);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (4, "Négyes", 990.9);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (5, "Ötös", 1100.5);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (6, "Hatos", 1200.0);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (7, "Hetes", 1449.9);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (8, "Nyolcas", 1600.0);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (9, "Kilences", 1666.6);
INSERT INTO `pizza` (`pizza_id`, `pizza_name`, `pizza_price`) VALUES (10, "Tizes", 1999.9);

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
	`order_id` INT(10) UNSIGNED NOT NULL,
	`customer_id` INT(10) UNSIGNED NOT NULL,
	`pizza_id` INT(10) UNSIGNED NOT NULL,
	`order_date` DATE NOT NULL,
	PRIMARY KEY (`order_id`)
);

INSERT INTO `order` VALUES (1, 1, 1, '2021-01-01');
INSERT INTO `order` VALUES (2, 1, 5, '2021-01-01');
INSERT INTO `order` VALUES (3, 2, 7, '2021-01-02');
INSERT INTO `order` VALUES (4, 4, 3, '2021-01-10');
INSERT INTO `order` VALUES (5, 8, 7, '2021-02-01');
INSERT INTO `order` VALUES (6, 2, 4, '2021-02-11');
INSERT INTO `order` VALUES (7, 4, 9, '2021-02-11');
INSERT INTO `order` VALUES (8, 6, 1, '2021-02-12');
INSERT INTO `order` VALUES (9, 10, 5, '2021-02-12');
INSERT INTO `order` VALUES (10, 1, 8, '2021-02-13');

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
	`customer_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`customer_name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`customer_id`)
);

INSERT INTO `customers` VALUES
	(NULL, 'Béla'),
	(NULL, 'Aranka'),
	(NULL, 'Árpád'),
	(NULL, 'Józsi'),
	(NULL, 'Kati'),
	(NULL, 'Frigyes'),
	(NULL, 'Vera'),
	(NULL, 'Kázmér'),
	(NULL, 'Pista'),
	(NULL, 'Klotild');
