-- 1.  Mi MADAGASZKÁR fővárosa?

SELECT `forvaros` FROM `orszagok` WHERE `orszag`='MADAGASZKÁR';

-- 2.  Melyik ország fővárosa OUAGADOUGOU?

SELECT `orszag` FROM `orszagok` WHERE `forvaros`='OUAGADOUGOU';

-- 3.  Melyik ország autójele a TT?

SELECT `orszag` FROM `orszagok` WHERE `autojel`='TT';

-- 4.  Melyik ország pénzének jele az SGD?

SELECT `orszag` FROM `orszagok` WHERE `penzjel`='SGD';

-- 5.  Melyik ország nemzetközi telefon-hívószáma a 61?

SELECT `orszag` FROM `orszagok` WHERE `telefon`=61;

-- 6.  Mekkora területű Monaco?

SELECT `terulet` FROM `orszagok` WHERE `orszag`='Monaco';

-- 7.  Hányan laknak Máltán?

SELECT `nepesseg` FROM `orszagok` WHERE `orszag`='Málta';

-- 8.  Mennyi Japán népsűrűsége?

SELECT (`nepesseg`)*1000/`terulet` AS `nepsuruseg`  FROM `orszagok` WHERE `orszag`='Japán';

-- 9.  Mely országok népsűrűsége nagyobb 500 fő/km2-nél?

SELECT `orszag` FROM `orszagok` WHERE (`nepesseg`)*1000/`terulet` > 500;

-- 10.  Melyek a szigetországok?

SELECT `orszag` FROM `orszagok` WHERE `foldr_hely` LIKE '%szigetország%';

-- 11.  Melyik a első hat legnagyobb területű ország?

SELECT `orszag` FROM `orszagok` ORDER BY `terulet` DESC LIMIT 0, 6;

-- 12.  Melyik három ország területe a legkisebb?

SELECT `orszag` FROM `orszagok` ORDER BY `terulet` LIMIT 0, 3;


-- Összegző lekérdezések - SUM, AVG, COUNT, MIN, MAX:
-- 1.  Hány lakosa van a Földnek?

SELECT CONCAT(FORMAT(SUM(`nepesseg`), 0), ' ezer fo') AS 'Föld lakossága' FROM `orszagok`;

-- 2.  Mennyi a Föld népsűrűsége?

SELECT CONCAT(FORMAT((SUM(`nepesseg`)*1000) / SUM(`terulet`), 2), '  fo/km2') AS 'Föld népsűrűsége' FROM `orszagok`;

-- 3.  Hány 1.000.000 km2-nél nagyobb területű ország van?

SELECT COUNT(*) AS '1.000.000 km2-nél nagyobb ország' FROM `orszagok` WHERE `terulet` > 1000000;

-- 4.  Hány ország területe esik 50.000 és 150.000 km2 közé?

SELECT COUNT(*) AS 'terület 50.000 - 150.000 km2' FROM `orszagok` WHERE `terulet` BETWEEN 50000 AND 150000;

-- 5.  Hány 1.000.000-nál kevesebb lakosú ország van?

SELECT COUNT(*) AS '1.000.000-nál kevesebb lakos' FROM `orszagok` WHERE `nepesseg`*1000 < 1000000;

-- 6.  Hány olyan ország van, aminek a területe kisebb, mint 10.000 km2, 
--    vagy a lakossága kevesebb 1.000.000-nál?

SELECT COUNT(*) FROM `orszagok` WHERE `nepesseg`*1000 < 1000000 OR `terulet` < 10000;

-- 7.  Hány ország pénzneme a kelet-karib dollár?

SELECT COUNT(*) FROM `orszagok` WHERE `penznem` LIKE '%kelet-karib dollár%';

-- 8.  Hány ország nevében van benne, hogy "ORSZÁG"?

SELECT COUNT(*) FROM `orszagok` WHERE `orszag` LIKE '%ORSZÁG%';

-- 9.  Hány ország van Afrikában?

SELECT COUNT(*) FROM `orszagok` WHERE `foldr_hely` LIKE '%Afrika%';

-- 10.  Mennyi Afrika lakossága?

SELECT CONCAT(FORMAT(SUM(`nepesseg`)*1000, 0), ' fo') AS 'Afrika lakossága' FROM `orszagok` WHERE `foldr_hely` LIKE '%Afrika%';

-- 11.  Mennyi Európa területe?

SELECT CONCAT(FORMAT(SUM(`terulet`), 0), ' km2') AS 'Európa területe' FROM `orszagok` WHERE `foldr_hely` LIKE '%Európa%';

-- 12.  Mennyi Európa népsűrűsége?

SELECT CONCAT(FORMAT((SUM(`nepesseg`)*1000) / SUM(`terulet`), 2), ' fo/km2') AS 'Európa népsűrűsége' 
FROM `orszagok` WHERE `foldr_hely` LIKE '%Európa%';

-- 13.  Hány országnak nincs autójelzése?

SELECT COUNT(*) FROM `orszagok` WHERE `autojel` LIKE '' OR `autojel` IS NULL;

-- 14.  Hány országban nem 100 a váltószáma az aprópénznek?

SELECT COUNT(*) FROM `orszagok` WHERE `valtopenz` NOT LIKE '100 %';

-- 15.  Hány országnak nagyobb a népessége, mint Romániának?

SELECT COUNT(*) FROM `orszagok`
WHERE `nepesseg` > (SELECT `nepesseg` FROM `orszagok` WHERE `orszag` = 'ROMÁNIA');

-- 16.  Mennyi Európa népessége és mennyi ország van Európában?

SELECT CONCAT(FORMAT(SUM(`nepesseg`)*1000, 0), ' fo') AS 'Európa népessége',
COUNT(*) AS 'Európa országai (db)'
FROM `orszagok` WHERE `foldr_hely` LIKE '%Európa%';

-- 17.  Mennyi olyan ország van, aminek a területe kisebb, mint Törökország

SELECT COUNT(*) FROM `orszagok`
WHERE `terulet` < (SELECT `terulet` FROM `orszagok` WHERE `orszag` = 'TÖRÖKORSZÁG');


-- Beágyazott lekérdezések:
-- 1.  Hány ország területe kisebb Magyarországénál?

SELECT COUNT(`orszag`) FROM `orszagok` WHERE `terulet` < (SELECT `terulet` FROM `orszagok` WHERE `orszag` = 'MAGYARORSZÁG');
​
-- 2.  Melyik a legnagyobb területű ország, és mennyi a területe?

SELECT `orszag`, `terulet` FROM `orszagok` WHERE `terulet` = (SELECT MAX(`terulet`) FROM `orszagok`);

-- 3.  Melyik a legkisebb  területű ország, és mennyi a területe?

SELECT `orszag`, `terulet` FROM `orszagok` WHERE `terulet` = (SELECT MIN(`terulet`) FROM `orszagok`);

-- 4.  Melyik a legnépesebb ország, és hány lakosa van?

SELECT `orszag`, `nepesseg`*1000 FROM `orszagok` WHERE `nepesseg` = (SELECT MAX(`nepesseg`) FROM `orszagok`);

-- 5.  Melyik a legkisebb népességű ország, és hány lakosa van?

SELECT `orszag`, `nepesseg`*1000 FROM `orszagok` WHERE `nepesseg` = (SELECT MIN(`nepesseg`) FROM `orszagok`);

-- 6.  Melyik a legsűrűbben lakott ország, és mennyi a népsűrűsége?
-- 7.  Melyik a legritkábban lakott ország, és mennyi a népsűrűsége?
-- 8.  Melyik a legritkábban lakott európai ország, és mennyi a népsűrűsége?
-- 9.  Melyik a legnagyobb afrikai ország és mekkora?

SELECT `orszag`, `terulet` FROM `orszagok` WHERE `terulet` = (SELECT MAX(`terulet`) FROM `orszagok` WHERE `foldr_hely` LIKE '%Afrika%');

