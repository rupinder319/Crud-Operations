-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Apr 11, 2023 at 04:11 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankaccounts`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `account_id` int(70) NOT NULL,
  `account_type` varchar(75) NOT NULL,
  `accountHolderName` varchar(75) NOT NULL,
  `accountHolderContact` varchar(75) NOT NULL,
  `accountBalance` varchar(75) NOT NULL,
  `accountSetupDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`account_id`, `account_type`, `accountHolderName`, `accountHolderContact`, `accountBalance`, `accountSetupDate`) VALUES
(111, 'Checking', 'William', '333-000-8989', '$50000', '2023-04-04'),
(222, 'Saving', 'Angella', '234-999-7878', '$40000', '2023-04-11'),
(333, 'Checking', 'Tom', '456-888-6767', '$30000', '2023-02-06'),
(444, 'Saving', 'Queen', '342-000-2332', '$5000', '2023-02-14'),
(555, 'Saving', 'Roseline', '456-987-5434', '$3000', '2023-03-04'),
(777, 'Saving', 'Mary', '456-987-5490', '$9000', '2023-02-11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
