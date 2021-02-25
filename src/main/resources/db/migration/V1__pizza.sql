DROP TABLE IF EXISTS `pizza`;
CREATE TABLE `pizza` (
	`pizza_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`pizza_name` VARCHAR(100) NOT NULL,
	`pizza_price` FLOAT NOT NULL,
	PRIMARY KEY (`pizza_id`)
);

INSERT INTO `pizza` (`pizza_name`, `pizza_price`) VALUES ("Egyes", 600.0), ("Kettes", 850.0), ("Hármas", 910.0), ("Négyes", 990.9),  ("Ötös", 1100.5);
INSERT INTO `pizza` (`pizza_name`, `pizza_price`) VALUES ("Hatos", 1200.0), ("Hetes", 1449.9), ("Nyolcas", 1600.0), ("Kilences", 1666.6), ("Tizes", 1999.9);

