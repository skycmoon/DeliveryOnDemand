-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 06, 2014 at 10:24 AM
-- Server version: 5.5.34
-- PHP Version: 5.3.10-1ubuntu3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dod`
--

-- --------------------------------------------------------

--
-- Table structure for table `Buildings`
--

CREATE TABLE IF NOT EXISTS `Buildings` (
  `building_id` varchar(11) NOT NULL,
  `building_name` varchar(50) NOT NULL,
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='This table has a building information (id, name, number of f';

--
-- Dumping data for table `Buildings`
--

INSERT INTO `Buildings` (`building_id`, `building_name`) VALUES
('BB', 'Birmingham Block'),
('BHS', 'Birmingham Hay & Seed'),
('CAR', 'Carlton Center '),
('CP', 'Cherry Parkes'),
('DOU', 'Dougan'),
('GWP', 'Garretson Woodruff & Pratt'),
('JOY', 'Russell T. Joy'),
('KEY', 'Keystone'),
('LBH', 'Laborers Hall'),
('LSH', 'Longshoremen''s Hall'),
('MAT', 'Mattress Factory'),
('MDS', 'McDonald Smith'),
('New', 'New Building'),
('PNK', 'Pinkerton'),
('SCI', 'Science'),
('SNO', 'Snoqualmie Building'),
('TLB', 'Tioga Library Building'),
('WCG', 'West Coast Grocery'),
('WG', 'Walsh Gardner'),
('WPH', 'William W. Philip Hall ');

-- --------------------------------------------------------

--
-- Table structure for table `DeliveryStatus`
--

CREATE TABLE IF NOT EXISTS `DeliveryStatus` (
  `demand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `veracity` int(11) DEFAULT '0',
  `delivery_status` int(11) DEFAULT '0',
  PRIMARY KEY (`demand_id`),
  KEY `fk_id_in_DemandHistory` (`demand_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='This table for tracking demand veracity and delivery_status ' AUTO_INCREMENT=25 ;

-- --------------------------------------------------------

--
-- Table structure for table `DemandHistory`
--

CREATE TABLE IF NOT EXISTS `DemandHistory` (
  `demand_id` int(11) NOT NULL AUTO_INCREMENT,
  `demand_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `room_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `demand_quantity` int(11) NOT NULL,
  `demand_reason` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`demand_id`),
  UNIQUE KEY `demand_timestamp` (`demand_timestamp`),
  KEY `fk_room_id_in_DemandHistory` (`room_id`),
  KEY `fk_item_id_in_DemandHistory` (`item_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

-- --------------------------------------------------------

--
-- Table structure for table `ItemMaxAllotmentForRoom`
--

CREATE TABLE IF NOT EXISTS `ItemMaxAllotmentForRoom` (
  `room_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `item_max_allotment` int(11) DEFAULT NULL,
  PRIMARY KEY (`room_id`,`item_id`),
  KEY `fk_room_id_in_ItemMaxAllotmentForRoom` (`room_id`),
  KEY `fk_item_id_in_ItemMaxAllotmentForRoom` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ItemMaxAllotmentForRoom`
--

INSERT INTO `ItemMaxAllotmentForRoom` (`room_id`, `item_id`, `item_max_allotment`) VALUES
(1, 1, 5),
(1, 2, 3),
(1, 3, 3),
(2, 1, 3),
(2, 2, 4),
(2, 3, 3),
(2, 4, 3),
(2, 5, 3),
(2, 6, 3),
(3, 7, 3),
(4, 8, 3),
(5, 9, 4),
(5, 10, 11),
(5, 11, 13),
(5, 12, 16),
(5, 13, 15),
(5, 14, 17),
(6, 15, 13),
(6, 16, 14),
(7, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Items`
--

CREATE TABLE IF NOT EXISTS `Items` (
  `item_id` int(11) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `item_type` int(11) NOT NULL,
  `total_quantity_on_hand` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_ItemsType_in_items` (`item_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Items`
--

INSERT INTO `Items` (`item_id`, `item_name`, `item_type`, `total_quantity_on_hand`) VALUES
(1, 'Black Marker', 1, '98'),
(2, 'Red Marker', 1, '100'),
(3, 'White Marker', 1, '200'),
(4, 'Blue Marker', 1, '370'),
(5, 'Sexy Marker', 1, '10'),
(6, 'Oil Marker', 1, '24'),
(7, 'Lord of Markers', 1, '1'),
(8, 'Whiteboard Eraser', 1, '50'),
(9, 'Normal Student Chair', 4, '100'),
(10, 'Normal Instructor Chair', 4, '10'),
(11, 'Lord of Chairs', 4, '1'),
(12, 'Orange Light', 2, '55'),
(13, 'Fluorescent Light', 2, '100'),
(14, 'Cute Light', 2, '10'),
(15, 'Normal Desktop', 6, '30'),
(16, 'Sever Computer', 6, '14'),
(17, 'Normal Student Desk', 5, '30'),
(18, 'Normal Instructor Desk', 5, '20'),
(19, 'Recreation Desk', 5, '10'),
(20, 'Speakers', 3, '20'),
(21, 'Projector', 3, '5'),
(22, 'Conference Table', 5, '10'),
(23, 'Conference Table', 5, '10'),
(24, 'Conference Table', 5, '10'),
(25, 'Conference Table', 5, '10');

-- --------------------------------------------------------

--
-- Table structure for table `ItemTypes`
--

CREATE TABLE IF NOT EXISTS `ItemTypes` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ItemTypes`
--

INSERT INTO `ItemTypes` (`type_id`, `type_name`) VALUES
(1, 'Office Supplies'),
(2, 'Lights'),
(3, 'Electronics'),
(4, 'Chairs'),
(5, 'Desks'),
(6, 'Computers'),
(7, 'Etc.');

-- --------------------------------------------------------

--
-- Table structure for table `Rooms`
--

CREATE TABLE IF NOT EXISTS `Rooms` (
  `room_id` int(11) NOT NULL,
  `room_name` varchar(20) NOT NULL,
  `building_id` varchar(11) NOT NULL,
  PRIMARY KEY (`room_id`),
  KEY `fk_Rooms_building_id` (`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Rooms`
--

INSERT INTO `Rooms` (`room_id`, `room_name`, `building_id`) VALUES
(1, 'BB 104', 'BB'),
(2, 'BB 106', 'BB'),
(3, 'BB 107', 'BB'),
(4, 'BHS 103', 'BHS'),
(5, 'BHS 104', 'BHS'),
(6, 'BHS 106', 'BHS'),
(7, 'BHS 107', 'BHS'),
(8, 'CAR 400', 'CAR'),
(9, 'CAR 200', 'CAR'),
(10, 'CAR 501', 'CAR'),
(11, 'CAR 219', 'CAR'),
(12, 'CP 311', 'CP'),
(13, 'CP 326', 'CP'),
(14, 'CP 206', 'CP'),
(15, 'CP 005', 'CP'),
(16, 'CP 134', 'CP'),
(17, 'CP 105', 'CP'),
(18, 'CP 106', 'CP'),
(19, 'CP 108', 'CP'),
(20, 'CP 109', 'CP'),
(21, 'CP 324', 'CP'),
(22, 'CP 325A', 'CP'),
(23, 'CP 325B', 'CP'),
(24, 'CP 325C', 'CP'),
(25, 'CP 334', 'CP'),
(26, 'CP 338', 'CP'),
(27, 'CP 103', 'CP'),
(28, 'CP 331', 'CP'),
(29, 'CP 206C', 'CP');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `DeliveryStatus`
--
ALTER TABLE `DeliveryStatus`
  ADD CONSTRAINT `fk_id_in_DemandHistory` FOREIGN KEY (`demand_id`) REFERENCES `DemandHistory` (`demand_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `DemandHistory`
--
ALTER TABLE `DemandHistory`
  ADD CONSTRAINT `fk_item_id_in_DemandHistory` FOREIGN KEY (`item_id`) REFERENCES `Items` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_room_id_in_DemandHistory` FOREIGN KEY (`room_id`) REFERENCES `Rooms` (`room_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ItemMaxAllotmentForRoom`
--
ALTER TABLE `ItemMaxAllotmentForRoom`
  ADD CONSTRAINT `fk_item_id_in_ItemMaxAllotmentForRoom` FOREIGN KEY (`item_id`) REFERENCES `Items` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_room_id_in_ItemMaxAllotmentForRoom` FOREIGN KEY (`room_id`) REFERENCES `Rooms` (`room_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Items`
--
ALTER TABLE `Items`
  ADD CONSTRAINT `fk_ItemsType_in_items` FOREIGN KEY (`item_type`) REFERENCES `ItemTypes` (`type_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Rooms`
--
ALTER TABLE `Rooms`
  ADD CONSTRAINT `fk_Rooms_building_id` FOREIGN KEY (`building_id`) REFERENCES `Buildings` (`building_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
