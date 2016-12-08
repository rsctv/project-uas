-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08 Des 2016 pada 02.21
-- Versi Server: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventori`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota_master`
--

CREATE TABLE `anggota_master` (
  `id_anggota` int(11) NOT NULL,
  `kode_anggota` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `anggota_master`
--

INSERT INTO `anggota_master` (`id_anggota`, `kode_anggota`, `nama`, `alamat`, `telepon`, `email`) VALUES
(1, 'KA001', 'Alex', 'Jln Merdeka Raya No 117', '021-027-077', 'alex@gmail.com'),
(2, 'KA002', 'John', 'Jln Merdeka Barat No 15', '021-037-897', 'john@gmail.com'),
(3, 'KA003', 'Smith', 'Jln Tomang Raya No 20', '021-011-7711', 'Smith@gmail.com'),
(4, 'KA004', 'Clark', 'Jln Tanjung Gedong No 115', '021-031-9777', 'Clark@gmail.com'),
(5, 'KA005', 'Scott', 'Jln Empang Bahagia No 9', '021-033-3457', 'Scott@gmail.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku_master`
--

CREATE TABLE `buku_master` (
  `id_buku` int(11) NOT NULL,
  `kode_buku` varchar(50) NOT NULL,
  `judul_buku` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `tahun_terbit` varchar(50) NOT NULL,
  `nomor_rak` varchar(50) NOT NULL,
  `jumlah_buku` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `buku_master`
--

INSERT INTO `buku_master` (`id_buku`, `kode_buku`, `judul_buku`, `penulis`, `penerbit`, `tahun_terbit`, `nomor_rak`, `jumlah_buku`) VALUES
(1, 'KB001', 'Pengantar Hukum', 'Unknown', 'Gramedia', '2016', 'R07', 5),
(2, 'KB002', 'Metode Numerik', 'Gramedia', 'AlexGramedia', '2015', 'R05', 5),
(3, 'KB003', 'Pengantar Teknologi', 'MediaCom', 'Erlangga', '2013', 'R03', 5),
(4, 'KB004', 'Data Mining', 'Eibe Frank', 'Gramedia', '2005', 'R010', 3),
(5, 'KB005', 'NLP', 'C.D Manning', 'Gramedia', '1999', 'R09', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_pinjam` int(11) NOT NULL,
  `kode_pinjam` varchar(50) NOT NULL,
  `tanggal_pinjam` varchar(50) NOT NULL,
  `tanggal_batas_pinjam` varchar(50) NOT NULL,
  `tanggal_kembali` varchar(50) DEFAULT NULL,
  `status_pinjam` varchar(50) NOT NULL,
  `kode_anggota` varchar(50) NOT NULL,
  `kode_buku` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`id_pinjam`, `kode_pinjam`, `tanggal_pinjam`, `tanggal_batas_pinjam`, `tanggal_kembali`, `status_pinjam`, `kode_anggota`, `kode_buku`) VALUES
(1, 'KP001', '30-11-2016', '07-12-2016', '08-12-2016', 'kembali', 'KA001', 'KB005'),
(2, 'KP002', '23-11-2016', '30-11-2016', '-', 'pinjam', 'KA002', 'KB005'),
(3, 'KP003', '03-12-2016', '10-12-2016', '-', 'pinjam', 'KA003', 'KB004'),
(4, 'KP004', '02-12-2016', '09-12-2016', '-', 'pinjam', 'KA005', 'KB004'),
(5, 'KP005', '07-12-2016', '14-12-2016', '-', 'pinjam', 'KA001', 'KB005');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota_master`
--
ALTER TABLE `anggota_master`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indexes for table `buku_master`
--
ALTER TABLE `buku_master`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_pinjam`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggota_master`
--
ALTER TABLE `anggota_master`
  MODIFY `id_anggota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id_pinjam` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
