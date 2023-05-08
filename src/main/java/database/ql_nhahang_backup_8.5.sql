-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2023 at 06:10 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

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
  `name` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `dateCreate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `phoneNumber`, `dateCreate`) VALUES
(1, 'Nguyên Hoàng', '0911175581', '2023-04-30 06:20:34'),
(2, 'Chi Linh', '0911175582', '2023-04-30 11:24:29'),
(3, 'Quốc Khánh', '0928471622', '2023-05-01 09:46:57'),
(4, 'Hoàng Vi', '0978264533', '2023-05-01 10:05:32'),
(5, 'Nguyễn Hưng', '092847122', '2023-05-01 10:08:08'),
(6, 'Khánh Hoàng', '0928471355', '2023-05-01 10:09:12'),
(7, 'Khoa Nguyễn', '0123456789', '2023-05-01 10:23:41'),
(8, 'Khánh Quốc', '0982746122', '2023-05-06 04:29:08'),
(9, 'Vương Quốc', '098476122', '2023-05-06 04:36:27'),
(10, 'Khánh Vy', '0948274211', '2023-05-06 04:45:30'),
(12, 'Hoàng Linh', '0972847129', '2023-05-07 08:48:26'),
(13, 'Hoàng Cẩm', '0982746123', '2023-05-07 08:51:44');

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
  `permission` varchar(50) NOT NULL COMMENT 'manager-quản lý,\r\nstaff-nhân viên',
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `username`, `password`, `name`, `phoneNumber`, `startDate`, `permission`, `salary`) VALUES
(1, 'admin', '1', 'Admin', '0911175581', '2023-05-01 17:00:00', 'manager', 10000000),
(2, 'khoa', '1', 'Nhật Khoa', '0911175581', '2023-05-01 05:15:08', 'staff', 5000000),
(3, 'khanh', '1', 'Tiến Khánh', '0978374217', '2023-05-01 06:06:24', 'staff', 5000000),
(4, 'giau', '1', 'Ngọc Giàu', '0984762311', '2023-05-03 09:15:43', 'staff', 5000000),
(5, 'anh', '1', 'Quốc Anh', '0984726311', '2023-05-03 09:19:38', 'staff', 5000000),
(7, 'nv', '1', 'Nhân Viên', '0978364122', '2023-05-04 04:22:24', 'staff', 0);

-- --------------------------------------------------------

--
-- Table structure for table `food_category`
--

CREATE TABLE `food_category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `food_category`
--

INSERT INTO `food_category` (`id`, `name`) VALUES
(1, 'Món gà'),
(2, 'Món heo'),
(3, 'Món bò'),
(4, 'Món cá'),
(6, 'Món xôi'),
(7, 'New');

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
(1, 'Gà hấp hành\n', NULL, '822261633-gahaphanh.jpg', 'Phần', 100000, 1),
(2, 'Gà hấp bia\n', NULL, '558096143-gahapbia.jpg', 'Phần', 120000, 1),
(3, 'Gà xào sả ớt\n', NULL, '250001296-gaxaoxaot.jpg', 'Phần', 130000, 1),
(4, 'Lẩu nấm gà\n', NULL, '29565537-launamga.jpg', 'Phần', 80000, 1),
(5, 'Heo nướng\n', NULL, '847391773-heonuong.jpg', 'Phần', 100000, 2),
(6, 'Heo xào sả ớt\n', NULL, '153305004-heoxaoxaot.jpg', 'Phần', 140000, 2),
(7, 'Heo hấp\n', NULL, '110155755-heohap.jpg', 'Phần', 100000, 2),
(8, 'Bò bóp thấu\n', NULL, '712789316-bobopthau.jpg', 'Phần', 100000, 3),
(11, 'Bò nướng lốt\n', NULL, '561557946-bonuonglalot.jpg', 'Phần', 150000, 3),
(12, 'Bò tái chanh\n', NULL, '913213623-botaichanh.jpg', 'Phần', 120000, 3),
(13, 'Bò lúc lắc\n', NULL, '531243836-boluclac.jpg', 'Phần', 100000, 3),
(14, 'Cá trê nướng\n', NULL, '808804197-catrenuong.jpg', 'Phần', 100000, 4),
(15, 'Cá trê kho tộ\n', NULL, '383619072-catrekhoto.jpg', 'Phần', 80000, 4),
(16, 'Cá trê nướng mật\n', NULL, '816120930-catrenuongmat.jpg', 'Phần', 100000, 4),
(18, 'Xôi nấm mối\n', NULL, '158611894-xoinammoi.jpg', 'Phần', 100000, 6),
(30, 'Xôi đậu phụng', NULL, '915206115-xoidauphung.jpg', 'Phần', 90000, 6),
(31, 'Xôi nấm thập cẩm', NULL, '461097126-xoinamthapcam.jpg', 'Phần', 100000, 6);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `idEmployee` int(11) NOT NULL,
  `idCustomer` int(11) DEFAULT NULL,
  `idTable` int(11) DEFAULT NULL,
  `type` varchar(45) NOT NULL DEFAULT 'here' COMMENT 'here- tại quán,\r\ntakeaway - mang về',
  `status` varchar(45) NOT NULL COMMENT 'cancel - bị hủy,\r\npaid - đã thanh toán',
  `orderDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `discount` int(11) NOT NULL DEFAULT 0,
  `totalAmount` bigint(20) NOT NULL DEFAULT 0,
  `cash` bigint(20) NOT NULL,
  `change` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id`, `idEmployee`, `idCustomer`, `idTable`, `type`, `status`, `orderDate`, `discount`, `totalAmount`, `cash`, `change`) VALUES
(1, 2, 1, 1, 'here', 'paid', '2023-04-30 07:28:41', 0, 450000, 500000, 50000),
(2, 2, 2, 2, 'here', 'paid', '2023-04-30 11:25:14', 0, 20000, 20000, 0),
(3, 2, 7, 3, 'here', 'paid', '2023-05-01 11:59:21', 0, 50000, 50000, 0),
(4, 1, 4, 6, 'here', 'cancel', '2023-05-01 12:01:06', 0, 50000, 100000, 50000),
(5, 1, NULL, 2, 'takeaway', 'paid', '2023-05-02 02:37:11', 0, 60000, 100000, 40000),
(6, 2, NULL, 3, 'here', 'paid', '2023-05-02 04:04:41', 0, 220000, 250000, 30000),
(7, 2, NULL, 7, 'takeaway', 'cancel', '2023-05-02 06:53:34', 1, 49500, 50000, 500),
(12, 1, 7, 5, 'here', 'cancel', '2023-05-03 02:20:45', 1, 99000, 100000, 1000),
(13, 2, NULL, 3, 'takeaway', 'cancel', '2023-05-03 02:27:23', 0, 0, 0, 0),
(14, 1, NULL, 2, 'here', 'paid', '2023-05-03 03:00:56', 0, 100000, 100000, 0),
(15, 1, NULL, 3, 'here', 'cancel', '2023-05-04 04:20:56', 0, 0, 0, 0),
(16, 1, 8, 3, 'here', 'cancel', '2023-05-06 04:29:21', 0, 10000, 10000, 0),
(17, 1, 9, 8, 'takeaway', 'paid', '2023-05-06 04:36:44', 0, 50000, 100000, 50000),
(18, 1, NULL, 4, 'takeaway', 'paid', '2023-05-06 06:22:11', 10, 216000, 250000, 34000),
(19, 1, NULL, 4, 'here', 'paid', '2023-05-06 09:31:48', 0, 380000, 500000, 120000),
(20, 4, NULL, 4, 'here', 'cancel', '2023-05-07 08:17:38', 0, 0, 0, 0),
(21, 4, NULL, 4, 'here', 'paid', '2023-05-07 08:18:33', 0, 200000, 500000, 300000),
(22, 1, 13, 5, 'here', 'cancel', '2023-05-07 08:51:53', 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE `order_item` (
  `idOrder` int(11) NOT NULL,
  `idFoodItem` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_item`
--

INSERT INTO `order_item` (`idOrder`, `idFoodItem`, `quantity`) VALUES
(6, 1, 2),
(6, 2, 2),
(7, 5, 1),
(13, 1, 2),
(14, 1, 2),
(16, 3, 1),
(17, 1, 1),
(18, 6, 1),
(18, 18, 1),
(19, 1, 1),
(19, 2, 1),
(19, 4, 2),
(21, 1, 1),
(21, 5, 1);

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
(1, 1, 'Admin', '2023-04-30 04:49:45', '2023-04-30 04:49:46', 'logout'),
(2, 1, 'Admin', '2023-04-30 04:50:42', NULL, 'login'),
(3, 1, 'Admin', '2023-04-30 04:52:55', NULL, 'login'),
(4, 1, 'Admin', '2023-04-30 05:03:25', NULL, 'login'),
(5, 1, 'Admin', '2023-04-30 05:08:33', NULL, 'login'),
(6, 1, 'Admin', '2023-04-30 05:08:56', NULL, 'login'),
(7, 1, 'Admin', '2023-04-30 05:10:38', NULL, 'login'),
(8, 1, 'Admin', '2023-04-30 09:57:19', NULL, 'login'),
(9, 1, 'Admin', '2023-04-30 11:05:37', NULL, 'login'),
(10, 2, 'Nhật Khoa', '2023-04-30 11:07:46', '2023-04-30 11:07:50', 'logout'),
(11, 1, 'Admin', '2023-04-30 11:07:52', NULL, 'login'),
(12, 1, 'Admin', '2023-04-30 11:08:20', NULL, 'login'),
(13, 1, 'Admin', '2023-04-30 11:09:32', NULL, 'login'),
(14, 2, 'Nhật Khoa', '2023-04-30 11:11:57', NULL, 'login'),
(15, 2, 'Nhật Khoa', '2023-04-30 11:13:37', NULL, 'login'),
(16, 2, 'Nhật Khoa', '2023-04-30 11:16:06', NULL, 'login'),
(17, 1, 'Admin', '2023-04-30 11:17:25', NULL, 'login'),
(18, 1, 'Admin', '2023-04-30 11:18:13', '2023-04-30 11:18:27', 'logout'),
(19, 2, 'Nhật Khoa', '2023-04-30 11:18:29', NULL, 'login'),
(20, 1, 'Admin', '2023-04-30 11:49:16', '2023-04-30 11:49:26', 'logout'),
(21, 1, 'Admin', '2023-04-30 11:49:28', NULL, 'login'),
(22, 2, 'Nhật Khoa', '2023-04-30 11:50:47', NULL, 'login'),
(23, 1, 'Admin', '2023-05-01 04:01:24', NULL, 'login'),
(24, 1, 'Admin', '2023-05-01 04:16:17', NULL, 'login'),
(25, 1, 'Admin', '2023-05-01 05:38:04', NULL, 'login'),
(26, 2, 'Nhật Khoa', '2023-05-01 07:39:08', '2023-05-01 09:20:29', 'logout'),
(27, 1, 'Admin', '2023-05-01 09:20:31', NULL, 'login'),
(28, 2, 'Nhật Khoa', '2023-05-01 11:30:47', NULL, 'login'),
(29, 2, 'Nhật Khoa', '2023-05-01 11:34:10', NULL, 'login'),
(30, 2, 'Nhật Khoa', '2023-05-01 11:40:19', NULL, 'login'),
(31, 2, 'Nhật Khoa', '2023-05-01 11:58:59', NULL, 'login'),
(32, 1, 'Admin', '2023-05-01 12:00:25', NULL, 'login'),
(33, 1, 'Admin', '2023-05-02 02:35:31', '2023-05-02 02:39:24', 'logout'),
(34, 1, 'Admin', '2023-05-02 02:39:27', NULL, 'login'),
(35, 3, 'Tiến Khánh', '2023-05-02 02:50:00', NULL, 'login'),
(36, 2, 'Nhật Khoa', '2023-05-02 02:59:21', NULL, 'login'),
(37, 2, 'Nhật Khoa', '2023-05-02 03:58:36', '2023-05-02 04:06:09', 'logout'),
(38, 1, 'Admin', '2023-05-02 04:06:12', NULL, 'login'),
(39, 2, 'Nhật Khoa', '2023-05-02 06:53:08', NULL, 'login'),
(40, 1, 'Admin', '2023-05-03 01:56:35', NULL, 'login'),
(41, 1, 'Admin', '2023-05-03 02:16:00', NULL, 'login'),
(42, 1, 'Admin', '2023-05-03 02:19:38', NULL, 'login'),
(43, 2, 'Nhật Khoa', '2023-05-03 02:27:04', NULL, 'login'),
(44, 1, 'Admin', '2023-05-03 02:36:36', NULL, 'login'),
(45, 1, 'Admin', '2023-05-03 02:50:26', NULL, 'login'),
(46, 1, 'Admin', '2023-05-03 03:00:36', NULL, 'login'),
(47, 1, 'Admin', '2023-05-03 03:03:23', NULL, 'login'),
(48, 2, 'Nhật Khoa', '2023-05-03 03:28:47', '2023-05-03 03:29:47', 'logout'),
(49, 1, 'Admin', '2023-05-03 03:29:48', NULL, 'login'),
(50, 1, 'Admin', '2023-05-03 08:40:55', '2023-05-03 08:49:45', 'logout'),
(51, 1, 'Admin', '2023-05-03 08:50:00', NULL, 'login'),
(52, 1, 'Admin', '2023-05-03 09:24:49', NULL, 'login'),
(53, 1, 'Admin', '2023-05-03 09:50:49', NULL, 'login'),
(54, 1, 'Admin', '2023-05-03 10:03:03', NULL, 'login'),
(55, 1, 'Admin', '2023-05-03 10:05:16', NULL, 'login'),
(56, 1, 'Admin', '2023-05-03 10:07:14', NULL, 'login'),
(57, 1, 'Admin', '2023-05-03 10:08:52', NULL, 'login'),
(58, 1, 'Admin', '2023-05-04 04:08:54', NULL, 'login'),
(59, 1, 'Admin', '2023-05-04 04:19:16', NULL, 'login'),
(60, 1, 'Admin', '2023-05-04 04:32:34', NULL, 'login'),
(61, 1, 'Admin', '2023-05-04 04:34:21', NULL, 'login'),
(62, 1, 'Admin', '2023-05-04 04:46:46', NULL, 'login'),
(63, 1, 'Admin', '2023-05-04 04:52:52', NULL, 'login'),
(64, 1, 'Admin', '2023-05-04 05:12:27', '2023-05-04 05:13:01', 'logout'),
(65, 1, 'Admin', '2023-05-04 05:13:13', NULL, 'login'),
(66, 1, 'Admin', '2023-05-04 05:13:32', NULL, 'login'),
(67, 1, 'Admin', '2023-05-04 05:13:47', NULL, 'login'),
(68, 1, 'Admin', '2023-05-04 08:28:58', NULL, 'login'),
(69, 2, 'Nhật Khoa', '2023-05-04 08:56:44', NULL, 'login'),
(70, 2, 'Nhật Khoa', '2023-05-04 08:58:32', NULL, 'login'),
(71, 2, 'Nhật Khoa', '2023-05-04 09:02:19', '2023-05-04 09:03:36', 'logout'),
(72, 1, 'Admin', '2023-05-04 09:03:38', NULL, 'login'),
(73, 1, 'Admin', '2023-05-04 09:10:39', '2023-05-04 09:14:43', 'logout'),
(74, 1, 'Admin', '2023-05-05 01:29:24', NULL, 'login'),
(75, 1, 'Admin', '2023-05-06 04:27:06', NULL, 'login'),
(76, 1, 'Admin', '2023-05-06 04:30:42', NULL, 'login'),
(77, 1, 'Admin', '2023-05-06 04:35:51', NULL, 'login'),
(78, 1, 'Admin', '2023-05-06 04:45:15', NULL, 'login'),
(79, 1, 'Admin', '2023-05-06 04:58:22', NULL, 'login'),
(80, 1, 'Admin', '2023-05-06 04:59:46', NULL, 'login'),
(81, 1, 'Admin', '2023-05-06 06:20:08', NULL, 'login'),
(82, 1, 'Admin', '2023-05-06 08:13:07', NULL, 'login'),
(83, 1, 'Admin', '2023-05-06 09:12:59', NULL, 'login'),
(84, 1, 'Admin', '2023-05-06 09:14:09', NULL, 'login'),
(85, 1, 'Admin', '2023-05-06 09:16:12', NULL, 'login'),
(86, 1, 'Admin', '2023-05-06 09:18:55', NULL, 'login'),
(87, 1, 'Admin', '2023-05-06 09:22:27', NULL, 'login'),
(88, 1, 'Admin', '2023-05-06 09:26:43', NULL, 'login'),
(89, 2, 'Nhật Khoa', '2023-05-06 09:41:19', '2023-05-06 09:43:03', 'logout'),
(90, 1, 'Admin', '2023-05-07 04:11:58', NULL, 'login'),
(91, 1, 'Admin', '2023-05-07 04:56:19', NULL, 'login'),
(92, 1, 'Admin', '2023-05-07 05:12:02', '2023-05-07 05:12:23', 'logout'),
(93, 1, 'Admin', '2023-05-07 05:35:51', NULL, 'login'),
(94, 2, 'Nhật Khoa', '2023-05-07 05:40:51', '2023-05-07 05:40:53', 'logout'),
(95, 1, 'Admin', '2023-05-07 05:40:55', NULL, 'login'),
(96, 1, 'Admin', '2023-05-07 06:11:42', '2023-05-07 06:12:34', 'logout'),
(97, 1, 'Admin', '2023-05-07 06:12:42', NULL, 'login'),
(98, 4, 'Ngọc Giàu', '2023-05-07 08:17:24', '2023-05-07 08:18:43', 'logout'),
(99, 1, 'Admin', '2023-05-07 08:18:45', NULL, 'login'),
(100, 1, 'Admin', '2023-05-07 08:41:24', NULL, 'login'),
(101, 1, 'Admin', '2023-05-07 08:50:48', '2023-05-07 08:53:12', 'logout'),
(102, 1, 'Admin', '2023-05-08 01:19:13', NULL, 'login'),
(103, 1, 'Admin', '2023-05-08 02:14:14', NULL, 'login'),
(104, 1, 'Admin', '2023-05-08 02:30:13', NULL, 'login'),
(105, 1, 'Admin', '2023-05-08 03:07:07', '2023-05-08 03:08:30', 'logout'),
(106, 1, 'Admin', '2023-05-08 03:57:35', NULL, 'login');

-- --------------------------------------------------------

--
-- Table structure for table `table`
--

CREATE TABLE `table` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'free' COMMENT 'free-Trống, \r\nserving-Đang phục vụ\r\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `table`
--

INSERT INTO `table` (`id`, `name`, `status`) VALUES
(1, 'Bàn 1', 'serving'),
(2, 'Bàn 2', 'serving'),
(3, 'Bàn 3', 'serving'),
(4, 'Bàn 4', 'serving'),
(5, 'Bàn 5', 'free'),
(6, 'Bàn 6', 'free'),
(7, 'Bàn 7', 'free'),
(8, 'Bàn 8', 'free'),
(9, 'Bàn 9', 'serving');

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
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food_item`
--
ALTER TABLE `food_item`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_employee_order` (`idEmployee`),
  ADD KEY `fk_order_table` (`idTable`),
  ADD KEY `fk_order_customer` (`idCustomer`);

--
-- Indexes for table `order_item`
--
ALTER TABLE `order_item`
  ADD PRIMARY KEY (`idOrder`,`idFoodItem`),
  ADD KEY `fk_orderItem_foodItem` (`idFoodItem`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `food_category`
--
ALTER TABLE `food_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `food_item`
--
ALTER TABLE `food_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;

--
-- AUTO_INCREMENT for table `table`
--
ALTER TABLE `table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `food_item`
--
ALTER TABLE `food_item`
  ADD CONSTRAINT `fk_item_category` FOREIGN KEY (`idCategory`) REFERENCES `food_category` (`id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_employee_order` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `fk_order_customer` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `fk_order_table` FOREIGN KEY (`idTable`) REFERENCES `table` (`id`);

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `fk_orderItem_foodItem` FOREIGN KEY (`idFoodItem`) REFERENCES `food_item` (`id`),
  ADD CONSTRAINT `fk_orderItem_order` FOREIGN KEY (`idOrder`) REFERENCES `order` (`id`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `fk_session` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
