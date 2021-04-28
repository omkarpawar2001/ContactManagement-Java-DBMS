-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 24, 2021 at 02:53 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phone_book`
--

-- --------------------------------------------------------

--
-- Table structure for table `contacts`
--

CREATE TABLE `contacts` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `phone_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`id`, `name`, `phone_id`) VALUES
(10, 'Jescie Castillo', 52),
(12, 'Maris Thornton', 17),
(13, 'Kiara Haynes', 31),
(14, 'Tasha Fulton', 94),
(15, 'Daria Lindsey', 31),
(18, 'Zachery Bush', 22),
(23, 'Adam Duran', 80),
(26, 'Keiko Mcleod', 86),
(27, 'Kirby House', 24),
(30, 'Joshua Hendricks', 71),
(31, 'Haley Blair', 99),
(34, 'Liberty Hartman', 32),
(37, 'Conan Calderon', 28),
(38, 'Howard Lewis', 92),
(39, 'Wilma Malone', 92),
(41, 'Ora Rasmussen', 86),
(42, 'Iola Vang', 77),
(43, 'Irene Stanley', 80),
(46, 'Cedric Wyatt', 29),
(49, 'Rhiannon Shepard', 85),
(51, 'Adele Bush', 62),
(52, 'Amal Zimmerman', 49),
(55, 'Riley Mitchell', 77),
(56, 'Dieter Wolfe', 52),
(58, 'Conan Mueller', 14),
(59, 'Miranda Robertson', 68),
(60, 'Kylynn Harper', 24),
(64, 'Zachary Hurst', 78),
(65, 'Ingrid Abbott', 47),
(66, 'Hoyt Mccoy', 52),
(68, 'Keegan Gibbs', 85),
(70, 'Cameron Newman', 49),
(71, 'Hedley Barnes', 78),
(72, 'Quemby Meyer', 33),
(73, 'Chastity Zamora', 71),
(74, 'Martha Curry', 31),
(75, 'Ray Frank', 77),
(76, 'Kai Nguyen', 91),
(78, 'Merrill Stout', 60),
(79, 'Aileen Kinney', 82),
(80, 'Denton Stone', 49),
(82, 'Hilel Parsons', 82),
(83, 'Leigh Oneil', 46),
(85, 'Josiah Joyce', 60),
(86, 'Ruby Cabrera', 47),
(88, 'Orson Blankenship', 65),
(91, 'Lani Mclaughlin', 61),
(97, 'Nolan Chandler', 22),
(98, 'Martha Conway', 31),
(100, 'Berk Nelson', 42),
(102, 'Ram ', 105),
(103, 'Hritik', 106),
(104, 'Dinesh', 107),
(105, 'Tanishq', 108);

-- --------------------------------------------------------

--
-- Table structure for table `phone`
--

CREATE TABLE `phone` (
  `id` int(11) NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `phone`
--

INSERT INTO `phone` (`id`, `phone`) VALUES
(74, '0869 672 0541'),
(25, '055 7530 2231'),
(88, '0375 135 8868'),
(45, '(016977) 8638'),
(78, '0833 054 4918'),
(74, '(01542) 141750'),
(88, '(0191) 778 9743'),
(24, '(014008) 82813'),
(44, '0306 632 9913'),
(91, '056 6522 6152'),
(61, '056 4173 8096'),
(86, '(0141) 518 5711'),
(51, '(01954) 88965'),
(28, '0845 46 43'),
(92, '0845 46 49'),
(71, '0500 501439'),
(68, '0800 780 2341'),
(77, '07624 417840'),
(85, '076 8870 1375'),
(72, '055 7021 4020'),
(42, '0930 712 8043'),
(83, '0932 350 0001'),
(25, '0845 46 43'),
(72, '0812 113 1687'),
(47, '055 8323 5378'),
(82, '07624 626684'),
(46, '07624 269408'),
(50, '0891 932 7794'),
(22, '(029) 9688 9680'),
(21, '(0181) 086 5459'),
(32, '0315 128 3425'),
(17, '(0113) 260 7205'),
(90, '(017879) 80918'),
(14, '055 2022 1923'),
(75, '0968 382 4231'),
(68, '(0161) 742 5633'),
(83, '055 9409 1213'),
(90, '(01041) 933116'),
(71, '(0101) 285 3425'),
(99, '07561 817074'),
(28, '056 5230 5518'),
(21, '076 2412 6543'),
(8, '(0161) 839 7439'),
(62, '(013205) 40050'),
(87, '0928 045 0441'),
(94, '0500 309463'),
(80, '(01990) 78370'),
(52, '8178684599'),
(42, '0926 285 3372'),
(87, '055 1522 3288'),
(45, '0800 1111'),
(50, '(0181) 609 9583'),
(33, '(0101) 981 7422'),
(61, '070 2085 4028'),
(60, '07518 436935'),
(43, '07592 384366'),
(58, '0500 764709'),
(31, '(0161) 199 5788'),
(24, '(01316) 41837'),
(31, '07624 308826'),
(29, '(011111) 98991'),
(38, '0823 304 1303'),
(40, '0992 939 1693'),
(38, '0800 918 7860'),
(49, '0800 629 7169'),
(17, '055 5901 4297'),
(96, '0800 1111'),
(32, '(0191) 986 3270'),
(94, '(01974) 97744'),
(29, '(0113) 848 6736'),
(19, '0500 231698'),
(78, '0845 46 43'),
(8, '056 4292 6152'),
(65, '(01763) 350699'),
(92, '0818 002 7445'),
(101, '1432456432'),
(102, '2435656754'),
(102, '4574754754'),
(103, '1243245454'),
(103, '4343434334'),
(105, '8939429030'),
(105, '4389302109'),
(106, '5785488358'),
(106, '3289753893'),
(107, '3424354657'),
(107, '2354658768'),
(108, '8575775777'),
(108, '7464662222'),
(52, '7774666626');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
