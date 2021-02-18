DROP TABLE IF EXISTS `agent1`;

CREATE TABLE agent1 (
	`agent_code` CHAR(6) NOT NULL,
	`agent_name` CHAR(40) NOT NULL,
	`working_area` CHAR(35) NOT NULL,
	`commission` DECIMAL(10,2) UNSIGNED NOT NULL,
	`phone_no` CHAR(15),
	`country` CHAR(30)
);

INSERT INTO `agent1` (`agent_code`, `agent_name`, `working_area`, `commission`, `phone_no`) VALUES 
	('A007', 'Ramasundar', 'Bangalore', 0.15, 7725814763),
	('A003', 'Alex', 'London', 0.13, 7512458969),
	('A008', 'Alford', 'NewYork', 0.12, 4425874365),
	('A011', 'RaviKumar', 'Bangalore', 0.15, 7745625874),
	('A010', 'Santakumar', 'Chennai', 0.14, 722388644),
	('A012', 'Lucida', 'SanJose', 0.12, 4452981425),
	('A005', 'Anderson', 'Brisban', 0.13, 4521447739),
	('A001', 'Subbarao', 'Bangalore', 0.14, 7712346674),
	('A002', 'Mukesh', 'Mumbai', 0.11, 2912358964),
	('A006', 'cDen', 'London', 0.15, 7822255588),
	('A004', 'Ivan', 'Torento', 0.15, 822544166),
	('A009', 'Benjamin', 'Hampshair', 0.11, 822536178);

-- 1. Új oszloppal való bővítés

ALTER TABLE `agent1` ADD `e-mail` CHAR(25) NOT NULL;

-- 2. Dobjunk el egy meglévő oszlopot

ALTER TABLE `agent1` DROP `country`;

-- 3. Módosítsunk alapértelmezett értéket

ALTER TABLE `agent1` CHANGE `commission` `commission` DECIMAL(10,2) UNSIGNED NOT NULL DEFAULT '.05';
INSERT INTO `agent1` (`agent_code`, `agent_name`, `working_area`, `phone_no`, `e-mail`) VALUES 
	('A015', 'Alex', 'Bangalore', 77777777, '@');
	
-- 4. Töröljük az alapértelmezett értékét egy oszlopnak

ALTER TABLE `agent1` CHANGE `commission` `commission` DECIMAL(10,2) UNSIGNED NOT NULL;

-- 5. Adjunk hozzá egy oszlophoz egy egyidi érték kényszert

ALTER TABLE `agent1` ADD UNIQUE(`agent_code`);

-- 6. Töröljük egyedi érték kényszert

ALTER TABLE `agent1` DROP INDEX `agent_code`;

-- 7. Mi van ha a kényszer már sértené a meglévő adat?

-- 8. Próbáljuk meg növelni egy meglévő oszlopnak a ”szélességét”

ALTER TABLE `agent1` MODIFY `agent_code` CHAR(20) NOT NULL;

-- 9. Próbáljuk meg csökkenteni egy meglévő oszlopnak a ”szélességét”

ALTER TABLE `agent1` MODIFY `agent_code` CHAR(4) NOT NULL;
-- adatvesztéssel járhat, ha az adat hossz nagyobb, mint amire módosítunk
ALTER TABLE `agent1` MODIFY `agent_code` CHAR(2) NOT NULL;
-- warningok, aatvesztés, de megcsinálja

-- 10. Próbáljuk meg változtatni az oszlop típusát.

ALTER TABLE `agent1` MODIFY `phone_no` BIGINT(17);

-- 11. Egyszerre változtassunk typust és nevezzük át az oszlopot

ALTER TABLE `agent1` CHANGE `phone_no` `phone_no_char` CHAR(17);

-- 12. Hogyan tudunk egy másik oszlopba másolni értékeket?

ALTER TABLE `agent1` ADD `phone_no` BIGINT(17);
UPDATE `agent1` SET `phone_no`=`phone_no_char` WHERE 1;
UPDATE `agent1` SET `phone_no`=SUBSTR(`phone_no_char`, 5) WHERE 1;