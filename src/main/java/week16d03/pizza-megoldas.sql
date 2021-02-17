-- Listázd ki az összes vásárlót név szerint csökkenő sorrendben!

SELECT * FROM `customers` ORDER BY `customer_name` DESC;

-- Listázd ki az összes vásárlót, de csak a nevüket, az azonosítójuk nem kell.

SELECT `customer_name` FROM `customers`;

-- Listázd ki a pizzákat áruk szerint emelkedő sorrendben!

SELECT * FROM `pizza` ORDER BY `pizza_price`;

-- Listázd ki a legdrágább pizzát!

SELECT * FROM `pizza` WHERE `pizza_price`=(SELECT MAX(`pizza_price`) FROM `pizza`);

-- Átlagosan mekkora értékben rendeltek az emberek?



-- Számold meg, mennyi vásárló van, akinek a nevében van ’a’ betű!

SELECT COUNT(*) FROM `customers` WHERE `customer_name` LIKE '%a%';

-- Listázd ki azokat a pizzákat, amik 1000 forintnál drágábbak vagy van a nevükben ’a’ betű.

SELECT * FROM `pizza` WHERE `pizza_price` > 1000 OR `pizza_name` LIKE '%a%';

-- Listázd ki az emberek neveit, akik pizzát rendeltek, és azt, hogy mikor rendelték a pizzát.

SELECT c.customer_name, o.order_date FROM `customers` c, `order` o WHERE o.customer_id=c.`customer_id`;

-- Listázd ki a pizzarendelések dátumát és azt, hogy melyik dátumon milyen nevű pizzát rendeltek!

SELECT p.`pizza_name`, o.`order_date` FROM `order` o, `pizza` p WHERE p.`pizza_id`=o.`pizza_id`;