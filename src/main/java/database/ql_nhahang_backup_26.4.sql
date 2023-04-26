-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2023 at 10:51 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ql_nhahang`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `phoneNumber`, `name`, `address`, `birthday`) VALUES
(1, '0911175581', 'Cường', 'Nghệ An', '2000-04-09 10:00:00'),
(2, '0911175581', 'Linh', 'Hà Nội', '2000-09-16 10:00:00'),
(9, '0928465821', 'Hóa', 'Việt Nam', '2000-03-10 05:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `startDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `permission` varchar(50) NOT NULL COMMENT 'manager-quản lý\r\nstaff-nhân viên\r\ninactive-nghỉ việc',
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `username`, `password`, `name`, `phoneNumber`, `startDate`, `permission`, `salary`) VALUES
(1, 'admin', '1', 'Admin', '0911175581', '2023-11-23 17:00:00', 'manager', 0),
(2, 'khoa', '1', 'Nguyễn Nhật Khoa', '0911175581', '2023-11-24 05:15:00', 'manager', 0),
(3, 'nv', '1', 'Nguyễn Văn A', '0978247122', '2023-12-23 16:52:39', 'staff', 0);

-- --------------------------------------------------------

--
-- Table structure for table `food_category`
--

CREATE TABLE `food_category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `slug` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `food_category`
--

INSERT INTO `food_category` (`id`, `name`, `slug`) VALUES
(1, 'Đồ Ăn', 'do-an'),
(2, 'Trà Sữa', 'tra-sua'),
(3, 'Cà Phê', 'ca-phe'),
(4, 'Topping', 'topping');

-- --------------------------------------------------------

--
-- Table structure for table `food_item`
--

CREATE TABLE `food_item` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `urlImage` varchar(50) DEFAULT NULL,
  `unitName` varchar(20) NOT NULL,
  `unitPrice` bigint(20) NOT NULL,
  `idCategory` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `food_item`
--

INSERT INTO `food_item` (`id`, `name`, `description`, `urlImage`, `unitName`, `unitPrice`, `idCategory`) VALUES
(1, 'No Topping', '', '', 'Phần', 0, 4),
(2, 'Trân Châu Tuyết Sợi', NULL, NULL, 'Phần', 10000, 4),
(3, 'Trân Châu Đen', NULL, NULL, 'Phần', 10000, 4),
(4, 'Trân Châu Trắng', NULL, NULL, 'Phần', 10000, 4),
(5, 'Trà Sữa Trân Châu', '', 'tra-sua-tran-chau-2020-12-23-08-54-16.png', 'Ly', 50000, 2),
(6, 'Trà Sữa Sương Sáo', NULL, NULL, 'Ly', 45000, 2),
(7, 'Trà Sữa Matcha(L)', '', '', 'Ly', 50000, 2),
(8, 'Sữa Tươi Trân Châu Đường Đen', NULL, NULL, 'Ly', 45000, 2),
(9, 'Bánh Flan', '', '', 'Cái', 10000, 1),
(10, 'Hướng dương', NULL, NULL, 'Túi', 10000, 1),
(11, 'Cafe truyền thống', NULL, NULL, 'Cốc', 35000, 3),
(12, 'Espresso', NULL, NULL, 'Cốc', 45000, 3),
(13, 'Trà Sữa Matcha(XL)', NULL, NULL, 'Ly', 25000, 2),
(14, 'Trà Sữa Ô Long', '', '', 'Ly', 20000, 2),
(15, 'Trà Đào', '', 'tra-ao-2020-12-23-08-54-25.png', 'Ly', 40000, 2),
(16, 'Trà Đào(L)', '', 'tra-ao-l-2020-12-23-08-54-33.png', 'Ly', 50000, 2),
(18, 'Trà Nhãn - Sen', '', 'tra-nhan---sen-2020-12-23-08-53-58.png', 'Ly', 45000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `id` int(11) NOT NULL,
  `idEmployee` int(11) NOT NULL,
  `nameEmployee` varchar(50) NOT NULL,
  `startTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `endTime` timestamp NULL DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`id`, `idEmployee`, `nameEmployee`, `startTime`, `endTime`, `message`) VALUES
(58, 1, 'admin', '2023-04-20 05:30:15', '2023-04-20 05:32:57', 'logout'),
(59, 2, 'khoa', '2023-04-20 05:39:31', '2023-04-20 05:41:25', 'logout'),
(60, 1, 'admin', '2023-04-20 05:41:29', '2023-04-20 05:52:31', 'logout'),
(61, 1, 'admin', '2023-04-21 09:56:38', '2023-04-21 09:58:02', 'logout'),
(62, 1, 'E', '2023-04-21 09:58:00', '2023-04-21 09:58:15', 'logout'),
(63, 1, 'F', '2023-04-22 03:00:40', NULL, 'login'),
(64, 1, 'AA', '2023-04-22 03:07:40', '2023-04-22 05:17:30', 'logout'),
(65, 1, 'BC', '2023-04-22 05:17:50', '2023-04-22 07:53:46', 'logout'),
(66, 1, 'AAA', '2023-04-22 07:53:50', '2023-04-22 07:53:55', 'logout'),
(67, 2, 'AA', '2023-04-22 07:54:40', '2023-04-22 07:56:37', 'logout'),
(68, 1, 'TTT', '2023-04-22 07:56:40', '2023-04-22 07:57:41', 'logout'),
(69, 1, 'WW', '2023-04-22 07:59:52', '2023-04-22 08:02:48', 'logout'),
(70, 1, 'AAAg', '2023-04-23 06:27:40', '2023-04-23 06:27:47', 'logout'),
(71, 1, 'BBB', '2023-04-23 06:39:21', '2023-04-23 06:41:12', 'logout'),
(72, 1, 'hhh', '2023-04-23 08:11:04', '2023-04-23 10:33:00', 'logout'),
(73, 1, 'ggg', '2023-04-24 03:57:45', NULL, 'login'),
(75, 1, '', '2023-04-19 22:30:15', '2023-04-19 22:32:57', 'logout'),
(76, 2, '', '2023-04-19 22:39:31', '2023-04-19 22:41:25', 'logout'),
(77, 1, '', '2023-04-19 22:41:29', '2023-04-19 22:52:31', 'logout'),
(78, 1, '', '2023-04-21 02:56:38', '2023-04-21 02:58:02', 'logout'),
(79, 1, '', '2023-04-21 02:58:00', '2023-04-21 02:58:15', 'logout'),
(80, 1, '', '2023-04-21 20:00:40', NULL, 'login'),
(81, 1, '', '2023-04-21 20:07:40', '2023-04-21 22:17:30', 'logout'),
(82, 1, '', '2023-04-21 22:17:50', '2023-04-22 00:53:46', 'logout'),
(83, 1, '', '2023-04-22 00:53:50', '2023-04-22 00:53:55', 'logout'),
(84, 2, '', '2023-04-22 00:54:40', '2023-04-22 00:56:37', 'logout'),
(85, 1, '', '2023-04-22 00:56:40', '2023-04-22 00:57:41', 'logout'),
(86, 1, '', '2023-04-22 00:59:52', '2023-04-22 01:02:48', 'logout'),
(87, 1, '', '2023-04-22 23:27:40', '2023-04-22 23:27:47', 'logout'),
(88, 1, '', '2023-04-22 23:39:21', '2023-04-22 23:41:12', 'logout'),
(89, 1, '', '2023-04-23 01:11:04', '2023-04-23 03:33:00', 'logout'),
(90, 1, '', '2023-04-23 20:57:45', NULL, 'login');

-- --------------------------------------------------------

--
-- Table structure for table `table`
--

CREATE TABLE `table` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'free' COMMENT 'free-Trống\nserving-Đang phục vụ\nreserving-Đặt trước'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `table`
--

INSERT INTO `table` (`id`, `name`, `status`) VALUES
(1, 'Bàn 1', 'free'),
(2, 'Bàn 2', 'free'),
(3, 'Bàn 3', 'free'),
(4, 'Bàn 4', 'free'),
(5, 'Bàn 5', 'free'),
(6, 'Bàn 6', 'free'),
(7, 'Bàn 7', 'free'),
(8, 'Bàn 8', 'free'),
(9, 'Bàn 9', 'free'),
(10, 'Bàn 10', 'free'),
(11, 'Bàn 11', 'free');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `food_category`
--
ALTER TABLE `food_category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `food_item`
--
ALTER TABLE `food_item`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `fk_item_category` (`idCategory`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_session` (`idEmployee`);

--
-- Indexes for table `table`
--
ALTER TABLE `table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `food_category`
--
ALTER TABLE `food_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `food_item`
--
ALTER TABLE `food_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT for table `table`
--
ALTER TABLE `table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `food_item`
--
ALTER TABLE `food_item`
  ADD CONSTRAINT `fk_item_category` FOREIGN KEY (`idCategory`) REFERENCES `food_category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
