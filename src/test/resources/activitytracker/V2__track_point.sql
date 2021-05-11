CREATE TABLE `track_point` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `activities_id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `lat` double NOT NULL,
  `lon` double NOT NULL
) ENGINE=InnoDB;