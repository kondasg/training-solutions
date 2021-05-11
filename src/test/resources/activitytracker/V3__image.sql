CREATE TABLE `image` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `activities_id` int(11) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `content` blob NOT NULL
);