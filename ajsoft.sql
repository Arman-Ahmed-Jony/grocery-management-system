-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2018 at 03:37 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ajsoft`
--

-- --------------------------------------------------------

--
-- Table structure for table `cust_sale`
--

CREATE TABLE `cust_sale` (
  `recipt_id` int(12) NOT NULL,
  `sale_prod_id` int(4) DEFAULT NULL,
  `sale_prod_name` varchar(20) DEFAULT NULL,
  `sale_prod_description` text,
  `sale_prod_quantity` int(8) DEFAULT NULL,
  `sale_prod_price` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `emp_info`
--

CREATE TABLE `emp_info` (
  `emp_id` int(8) NOT NULL,
  `emp_name` varchar(20) NOT NULL,
  `emp_address` text NOT NULL,
  `emp_bdate` date DEFAULT NULL,
  `emp_contact` int(15) DEFAULT NULL,
  `emp_join_date` date DEFAULT NULL,
  `emp_img` varchar(150) DEFAULT NULL,
  `emp_gender` varchar(10) DEFAULT NULL,
  `emp_email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emp_info`
--

INSERT INTO `emp_info` (`emp_id`, `emp_name`, `emp_address`, `emp_bdate`, `emp_contact`, `emp_join_date`, `emp_img`, `emp_gender`, `emp_email`) VALUES
(1, 'noman', '145,ashkona,dhaka,1230', '2011-01-16', 198413254, '2011-01-19', '20160912_021705.jpg', 'Male', 'noman@gmail.com'),
(2, 'laboni', '175,mirpur,dhaka-1230', '2011-01-12', 198546323, '2011-01-14', 'C:UsersMMCDocumentsCapture.PNG', 'Female', 'lab@gmail.com'),
(3, 'sadia saej', '8/A, shenanibash,savar,dhaka-1230', '1995-11-15', 1554208817, '2011-01-02', 'C:UsersMMCPicturesHydrangeas.jpg', 'Female', 'sadiasaej@gmail.com'),
(4, 'arman ahmed jony', '188,ashkona,dakkhinkhan,dhaka-1230', '1996-01-10', 1521209985, '2011-01-04', '2016-06-07-11-41-25-845.png', 'Male', 'armanahmedjony123@gmail.com'),
(5, 'shamim', '18845,eaf coloni,dhaka-1230', '2011-01-11', 195461234, '2011-01-02', 'C:UsersMMCDocumentsCapture.PNG', 'Male', 'shamim@gmail.com'),
(6, 'labonno', '456,jamalpur', '2011-01-18', 198456123, '2011-01-11', 'C:UsersMMCDocumentsCapture.PNG', 'Female', 'labu@gmail.com'),
(8, 'sultana', '18845,eaf coloni,dhaka-1230', '2011-01-03', 1954564015, '2011-01-10', '2016-10-29-14-39-39-588_1.jpg', 'Female', 'sultana@gmail.com'),
(9, 'mithu', '78,ashkona,dhaka-1320', '2011-01-17', 19845361, '2011-01-11', 'C:UsersMMCDocumentsCapture.PNG', 'Male', 'mithu@gmail.com'),
(10, 'alomgir', '789,rt road,dhaka-1230', '2011-01-12', 1685824241, '2011-01-10', 'key_small.png', 'Male', 'alomgir@gmail.com'),
(11, 'faesaew', 'eswfawe', '2011-01-05', 135486, '2011-01-04', 'Fasticon-Essential-Toolbar-Add.png', 'Male', 'arewg@gamil.com'),
(12, 'faesaew', 'eswfawe', '2011-01-05', 135486, '2011-01-04', 'lock-512.png', 'Male', 'arewg@gamil.com'),
(13, 'tahmeena aktar', '154,ashkona,dhaka-1230', '2011-01-12', 1916563416, '2011-01-11', 'key-rot.png', 'Female', 'tahmenna@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `prod_id` int(4) NOT NULL,
  `prod_name` varchar(20) NOT NULL,
  `prod_description` text NOT NULL,
  `prod_quantity` int(8) NOT NULL,
  `prod_price` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`prod_id`, `prod_name`, `prod_description`, `prod_quantity`, `prod_price`) VALUES
(3400, 'BIOMIL 1', 'BIOMIL 1 400g - prepared with fresh milk and based on mothers milk formula.', 500, 200),
(3401, 'HORLIKS', 'horliks 500g has made for baby care', 500, 600),
(3402, 'Lactogen 2', 'Lectogen 2 400g-is only for the babies of age 6 mounths.it contains zink, iodin, manganiz, cloried that is good for baby health', 1000, 590),
(3403, 'Lactogen 3', 'Lectogen 3 400g-is only for the babies of age 12 mounths.it contains zink, iodin, manganiz, cloried that is good for baby health', 500, 600);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `prod_id` varchar(8) NOT NULL,
  `prod_name` varchar(50) NOT NULL,
  `quantity` varchar(8) NOT NULL,
  `price` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`prod_id`, `prod_name`, `quantity`, `price`) VALUES
('3400', 'BIOMIL 1', '22', '4400');

-- --------------------------------------------------------

--
-- Table structure for table `temp_cust_sale`
--

CREATE TABLE `temp_cust_sale` (
  `serial` int(3) NOT NULL,
  `recipt_id` int(8) DEFAULT NULL,
  `sale_prod_id` int(4) DEFAULT NULL,
  `sale_prod_name` varchar(20) DEFAULT NULL,
  `sale_prod_description` text,
  `sale_prod_quantity` int(8) DEFAULT NULL,
  `sale_prod_price` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_login`
--

CREATE TABLE `user_login` (
  `user_id` int(8) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_type` varchar(15) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_login`
--

INSERT INTO `user_login` (`user_id`, `user_name`, `user_type`, `user_password`) VALUES
(15103103, 'Arman ahmed', 'Admin', 'sadia143'),
(15103104, '1', 'User', '1'),
(15103105, 'Sadia Saej', 'User', 'samsung');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cust_sale`
--
ALTER TABLE `cust_sale`
  ADD PRIMARY KEY (`recipt_id`);

--
-- Indexes for table `emp_info`
--
ALTER TABLE `emp_info`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`prod_id`);

--
-- Indexes for table `temp_cust_sale`
--
ALTER TABLE `temp_cust_sale`
  ADD PRIMARY KEY (`serial`);

--
-- Indexes for table `user_login`
--
ALTER TABLE `user_login`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emp_info`
--
ALTER TABLE `emp_info`
  MODIFY `emp_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `prod_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3404;

--
-- AUTO_INCREMENT for table `user_login`
--
ALTER TABLE `user_login`
  MODIFY `user_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15103106;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
