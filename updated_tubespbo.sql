-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2019 at 08:16 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `idRestoran` varchar(10) NOT NULL,
  `namaMenu` varchar(200) NOT NULL,
  `hargaMenu` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`idRestoran`, `namaMenu`, `hargaMenu`) VALUES
('R-1', 'Ramen Miso', 25000),
('R-1', 'Ramen Cah', 15000),
('R-1', 'Ramen Euy', 13000),
('R-1', 'Ramen Spesial', 20500),
('R-2', 'Crispy Chicken', 23000),
('R-2', 'Big Size Katsu', 27000);

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `idPelanggan` varchar(10) NOT NULL,
  `namaPelanggan` varchar(200) NOT NULL,
  `passPelanggan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`idPelanggan`, `namaPelanggan`, `passPelanggan`) VALUES
('C-1', 'Ivan', 'ivan');

-- --------------------------------------------------------

--
-- Table structure for table `pengemudi`
--

CREATE TABLE `pengemudi` (
  `idPengemudi` varchar(20) NOT NULL,
  `namaPengemudi` varchar(200) NOT NULL,
  `passPengemudi` varchar(20) NOT NULL,
  `platNomor` varchar(12) NOT NULL,
  `statusPengemudi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengemudi`
--

INSERT INTO `pengemudi` (`idPengemudi`, `namaPengemudi`, `passPengemudi`, `platNomor`, `statusPengemudi`) VALUES
('D-1', 'Ivan', 'ilham', 'AE 4242 VI', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `idOrder` varchar(10) NOT NULL,
  `idPelanggan` varchar(10) NOT NULL,
  `idPengemudi` varchar(10) NOT NULL,
  `idRestoran` varchar(10) NOT NULL,
  `totalHarga` int(11) NOT NULL,
  `statusOrder` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`idOrder`, `idPelanggan`, `idPengemudi`, `idRestoran`, `totalHarga`, `statusOrder`) VALUES
('O-1', 'C-1', 'D-1', 'R-1', 60500, 'Pesanan selesai'),
('O-2', 'C-1', 'D-1', 'R-2', 27000, 'Pesanan selesai');

-- --------------------------------------------------------

--
-- Table structure for table `relasi_pesanan_menu`
--

CREATE TABLE `relasi_pesanan_menu` (
  `id_order` varchar(5) NOT NULL,
  `namaMenu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relasi_pesanan_menu`
--

INSERT INTO `relasi_pesanan_menu` (`id_order`, `namaMenu`) VALUES
('O-1', 'Ramen Miso'),
('O-1', 'Ramen Cah'),
('O-1', 'Ramen Spesial'),
('O-2', 'Big Size Katsu');

-- --------------------------------------------------------

--
-- Table structure for table `restoran`
--

CREATE TABLE `restoran` (
  `idRestoran` varchar(20) NOT NULL,
  `namaRestoran` varchar(100) NOT NULL,
  `passRestoran` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restoran`
--

INSERT INTO `restoran` (`idRestoran`, `namaRestoran`, `passRestoran`) VALUES
('R-1', 'Ramen Barokah', 'ramen'),
('R-2', 'Rice Bowl', 'r2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`idPelanggan`);

--
-- Indexes for table `pengemudi`
--
ALTER TABLE `pengemudi`
  ADD PRIMARY KEY (`idPengemudi`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`idOrder`);

--
-- Indexes for table `restoran`
--
ALTER TABLE `restoran`
  ADD PRIMARY KEY (`idRestoran`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
