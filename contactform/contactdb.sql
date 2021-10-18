-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 18, 2021 at 07:05 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `contactdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbladmin`
--

CREATE TABLE `tbladmin` (
  `id` int(11) NOT NULL,
  `UserName` varchar(150) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `UpdationDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbladmin`
--

INSERT INTO `tbladmin` (`id`, `UserName`, `Password`, `UpdationDate`) VALUES
(1, 'admin', '$2y$12$eraBX7Yydnsa8oEqpBV8aeXyNc8HcoKOQzM7NS/IJ/AzuP8I8FGY2', '2021-10-18 04:46:34');

-- --------------------------------------------------------

--
-- Table structure for table `tbladminremarks`
--

CREATE TABLE `tbladminremarks` (
  `id` int(11) NOT NULL,
  `contactFormId` int(11) DEFAULT NULL,
  `adminRemark` mediumtext DEFAULT NULL,
  `remarkDate` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbladminremarks`
--

INSERT INTO `tbladminremarks` (`id`, `contactFormId`, `adminRemark`, `remarkDate`) VALUES
(4, 6, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', '2018-08-19 07:06:45'),
(5, 1, 'vvsdvsd sg sgd s', '2018-08-22 04:31:31'),
(6, 9, 'Thanks you ', '2021-10-17 05:01:22'),
(7, 9, 'Thanks for conatacting', '2021-10-17 05:05:33'),
(8, 47, 'Thanks for Contacting', '2021-10-17 12:45:57'),
(9, 1, 'Thanks For Conatacting', '2021-10-17 12:51:55'),
(10, 1, 'Thanks For Conatacting', '2021-10-17 12:55:42'),
(11, 49, 'Thanks For Conatacting', '2021-10-17 13:01:27'),
(12, 49, 'Thanks For Conatacting', '2021-10-17 13:10:32'),
(13, 50, 'ada', '2021-10-18 04:44:17'),
(14, 50, 'Thanks For Conatacting', '2021-10-18 04:46:27'),
(15, 49, 'Thanks For Conatacting', '2021-10-18 04:46:44');

-- --------------------------------------------------------

--
-- Table structure for table `tblcontactdata`
--

CREATE TABLE `tblcontactdata` (
  `id` int(11) NOT NULL,
  `FullName` varchar(200) DEFAULT NULL,
  `PhoneNumber` char(12) DEFAULT NULL,
  `EmailId` varchar(200) DEFAULT NULL,
  `Subject` varchar(255) DEFAULT NULL,
  `Message` mediumtext DEFAULT NULL,
  `UserIp` varbinary(16) DEFAULT NULL,
  `PostingDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `Is_Read` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblcontactdata`
--

INSERT INTO `tblcontactdata` (`id`, `FullName`, `PhoneNumber`, `EmailId`, `Subject`, `Message`, `UserIp`, `PostingDate`, `Is_Read`) VALUES
(49, 'Shivraj', '9552641051', 'Dhayatadaks@gmail.com', 'Query on To determine the connection', 'connection is established\r\n', 0x3a3a31, '2021-10-17 12:58:26', 1),
(50, 'selenium test case', '1234567890', 'SeleNium@Test.co', 'Test', 'This was Test case ', 0x3a3a31, '2021-10-17 13:00:42', 1),
(51, 'selenium test case', '1234567890', 'SeleNium@Test.co', 'Test', 'This was Test case ', 0x3a3a31, '2021-10-17 13:07:50', 0),
(52, 'selenium test case', '1234567890', 'SeleNium@Test.co', 'Test', 'This was Test case ', 0x3a3a31, '2021-10-17 13:09:59', 0),
(53, 'selenium test case', '1234567890', 'SeleNium@Test.co', 'Test', 'This was Test case ', 0x3a3a31, '2021-10-18 04:46:17', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tblemail`
--

CREATE TABLE `tblemail` (
  `id` int(11) NOT NULL,
  `emailId` varchar(250) DEFAULT NULL,
  `UpdationDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblemail`
--

INSERT INTO `tblemail` (`id`, `emailId`, `UpdationDate`) VALUES
(1, 'admin1@gmail.com', '2021-10-14 09:45:45');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbladmin`
--
ALTER TABLE `tbladmin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbladminremarks`
--
ALTER TABLE `tbladminremarks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tblcontactdata`
--
ALTER TABLE `tblcontactdata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tblemail`
--
ALTER TABLE `tblemail`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbladmin`
--
ALTER TABLE `tbladmin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbladminremarks`
--
ALTER TABLE `tbladminremarks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tblcontactdata`
--
ALTER TABLE `tblcontactdata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `tblemail`
--
ALTER TABLE `tblemail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
