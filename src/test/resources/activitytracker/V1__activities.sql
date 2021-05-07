CREATE TABLE `activities` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `start_time` datetime NOT NULL,
  `activity_desc` varchar(255) NOT NULL,
  `activity_type` varchar(20) NOT NULL
);