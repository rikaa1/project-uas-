-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2024 at 06:31 AM
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
-- Database: `klinik`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `id_pegawai`, `nama`, `telepon`, `email`, `alamat`, `status`) VALUES
(1, 1221, 'Dina Aulia', '081262419151', 'dinaaulia@gmail.com', 'Jl. Beringin Gg. Mangga', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `aktivitas_dokter`
--

CREATE TABLE `aktivitas_dokter` (
  `no_registp` varchar(6) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `resep_obat` varchar(20) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `aktivitas_dokter`
--

INSERT INTO `aktivitas_dokter` (`no_registp`, `nama`, `tanggal`, `resep_obat`, `keterangan`) VALUES
('P001', 'Putri Salsabila', '2024-01-01', 'Ada', 'Luka pada jahitan 70% membaik'),
('P002', 'Alya Puspita', '2024-01-06', 'Ada', 'Demam berkurang dalam jangka waktu 2 hari'),
('P003', 'Dea Afrillia', '2024-01-01', 'Ada', 'Keluhan pusing pada kepala bagian kanan'),
('P004', 'Nabila Rana', '2024-01-02', 'Ada', 'Sembuh dari batuk'),
('P005', 'Andini Olivia', '2024-01-08', 'Ada', 'Flu berkurang 50%');

-- --------------------------------------------------------

--
-- Table structure for table `apoteker`
--

CREATE TABLE `apoteker` (
  `id` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `shift` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `apoteker`
--

INSERT INTO `apoteker` (`id`, `id_pegawai`, `nama`, `telepon`, `alamat`, `email`, `shift`) VALUES
(1, 1222, 'Dwi Shintya', '081236661121', 'Jl. Marelan medan', 'shintya@gmail.com', 'Malam ( 17:00 sore - 08:00 pagi)'),
(2, 1224, 'Rika', '08665543412', 'Jl. Sei Buluh Medan', 'rika@gmail.com', 'Pagi ( 08:00 pagi - 17:00 sore)');

-- --------------------------------------------------------

--
-- Table structure for table `data_obat`
--

CREATE TABLE `data_obat` (
  `nomor` int(11) NOT NULL,
  `id_obat` varchar(10) NOT NULL,
  `nama_obat` varchar(50) NOT NULL,
  `stok` varchar(10) NOT NULL,
  `harga` varchar(30) NOT NULL,
  `satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_obat`
--

INSERT INTO `data_obat` (`nomor`, `id_obat`, `nama_obat`, `stok`, `harga`, `satuan`) VALUES
(1, 'OB_001', 'Paracetamol', '30', '25.000', 'tablet'),
(2, 'OB_002', 'Sanmol', '100', '10.000', 'tablet'),
(3, 'OB_003', 'Antibiotik', '100', '12.000', 'Tablet');

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `id` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `spesialis` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id`, `id_pegawai`, `nama`, `telepon`, `alamat`, `email`, `spesialis`) VALUES
(3, 1223, 'Nabila Yusra', '081262419165', 'Jl. Martubung Medan', 'yusra@gmail.com', 'Telinga Hidung Tenggorokan');

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_dokter`
--

CREATE TABLE `jadwal_dokter` (
  `nomor` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jadwal_dokter`
--

INSERT INTO `jadwal_dokter` (`nomor`, `tanggal`, `keterangan`) VALUES
(1, '2024-01-01', 'Praktek 5 Pasien'),
(2, '2024-01-02', 'Pemeriksaan jadwal temu pasien'),
(3, '2024-01-03', 'Review obat '),
(4, '2024-01-04', 'Check up 6 pasien'),
(7, '2024-01-09', 'Laporan Mingguan');

-- --------------------------------------------------------

--
-- Table structure for table `klinik_user`
--

CREATE TABLE `klinik_user` (
  `id` int(5) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `klinik_user`
--

INSERT INTO `klinik_user` (`id`, `id_pegawai`, `nama`, `telepon`, `email`, `alamat`, `status`, `username`, `password`) VALUES
(1, 1221, 'Dina Aulia', '081262419151', 'dinaaulia@gmail.com', 'Jl. Beringin Gg. Mangga', 'Admin', 'dina', '3011'),
(2, 1222, 'Dwi Shintya', '081236661121', 'shintya@gmail.com', 'Jl. Marelan medan', 'Apoteker', 'shintya', 'shin'),
(3, 1223, 'Nabila Yusra', '081262419165', 'yusra@gmail.com', 'Jl. Martubung Medan', 'Dokter', 'nabila', 'yusra'),
(4, 1224, 'Rika', '08665543412', 'rika@gmail.com', 'Jl. Sei Buluh Medan', 'Apoteker', 'rika', 'tok12');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `nomor` int(11) NOT NULL,
  `no_registp` varchar(6) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(30) NOT NULL,
  `resep_obat` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nama` (`nama`),
  ADD KEY `telepon` (`telepon`),
  ADD KEY `email` (`email`),
  ADD KEY `alamat` (`alamat`),
  ADD KEY `status` (`status`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indexes for table `aktivitas_dokter`
--
ALTER TABLE `aktivitas_dokter`
  ADD PRIMARY KEY (`no_registp`);

--
-- Indexes for table `apoteker`
--
ALTER TABLE `apoteker`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_pegawai` (`id_pegawai`),
  ADD UNIQUE KEY `nama` (`nama`),
  ADD UNIQUE KEY `telepon` (`telepon`),
  ADD UNIQUE KEY `alamat` (`alamat`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `data_obat`
--
ALTER TABLE `data_obat`
  ADD PRIMARY KEY (`nomor`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_pegawai` (`id_pegawai`),
  ADD UNIQUE KEY `nama` (`nama`),
  ADD UNIQUE KEY `telepon` (`telepon`),
  ADD UNIQUE KEY `alamat` (`alamat`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `jadwal_dokter`
--
ALTER TABLE `jadwal_dokter`
  ADD PRIMARY KEY (`nomor`);

--
-- Indexes for table `klinik_user`
--
ALTER TABLE `klinik_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pegawai` (`id_pegawai`),
  ADD KEY `nama` (`nama`),
  ADD KEY `telepon` (`telepon`),
  ADD KEY `email` (`email`),
  ADD KEY `alamat` (`alamat`),
  ADD KEY `status` (`status`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`nomor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `apoteker`
--
ALTER TABLE `apoteker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `data_obat`
--
ALTER TABLE `data_obat`
  MODIFY `nomor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `dokter`
--
ALTER TABLE `dokter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `jadwal_dokter`
--
ALTER TABLE `jadwal_dokter`
  MODIFY `nomor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `klinik_user`
--
ALTER TABLE `klinik_user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `pasien`
--
ALTER TABLE `pasien`
  MODIFY `nomor` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
