-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2024 at 03:55 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oopn7`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `remembered_usernames`
--

CREATE TABLE `remembered_usernames` (
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `ID` varchar(255) NOT NULL,
  `Tên khách hàng` varchar(255) NOT NULL,
  `Số điện thoại` varchar(225) NOT NULL,
  `Địa chỉ` varchar(255) NOT NULL,
  `Ngày thuê` date NOT NULL,
  `Ngày trả dự kiến` date NOT NULL,
  `Phương thức thanh toán` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`ID`, `Tên khách hàng`, `Số điện thoại`, `Địa chỉ`, `Ngày thuê`, `Ngày trả dự kiến`, `Phương thức thanh toán`) VALUES
('001', 'Đỗ Hồng Hà', '0369052332', 'Hà Đông, Hà Nội', '2024-05-12', '2024-05-16', 'Tiền mặt');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Confirm_Password` varchar(255) NOT NULL,
  `Reset_Password_Code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`Username`, `Password`, `Confirm_Password`, `Reset_Password_Code`) VALUES
('oopn7', '12345', '12345', 1111),
('hado', '12345', '12345', 1111),
('az', '12345', '12345', 111);

-- --------------------------------------------------------

--
-- Table structure for table `thongtinxe`
--

CREATE TABLE `thongtinxe` (
  `ID` varchar(255) NOT NULL,
  `Tên xe` varchar(255) NOT NULL,
  `Hãng xe` varchar(255) NOT NULL,
  `Loại xe` varchar(255) NOT NULL,
  `Sức chứa` int(11) NOT NULL,
  `Số lượng` int(11) NOT NULL,
  `Khu vực` varchar(255) NOT NULL,
  `Giá thuê/ngày` varchar(255) DEFAULT NULL,
  `Trạng thái` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thongtinxe`
--

INSERT INTO `thongtinxe` (`ID`, `Tên xe`, `Hãng xe`, `Loại xe`, `Sức chứa`, `Số lượng`, `Khu vực`, `Giá thuê/ngày`, `Trạng thái`) VALUES
('001', 'Chevrolet Corvette', 'Corvette', 'Sport', 2, 54, 'Hà Nội', '$75.000', 'Còn'),
('002', 'Avanza Premio', 'Toyota', 'MPV', 7, 100, 'Hà Nội', '$7500', 'Còn'),
('003', 'Peugeot 3008', 'Peugeot', 'SUV', 5, 124, 'TP Hồ Chí Minh', '$250', 'Còn'),
('004', 'Porsche Panamera', 'Porsche', ' Luxury Sports', 5, 32, 'TP Hồ Chí Minh', '$10000', 'Hết');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
