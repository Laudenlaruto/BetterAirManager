-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2017 at 09:21 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `betterairmanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `assocpncequipage`
--

CREATE TABLE `assocpncequipage` (
  `refEquipage` varchar(50) NOT NULL,
  `nompnc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assocpncequipage`
--

INSERT INTO `assocpncequipage` (`refEquipage`, `nompnc`) VALUES
('IT02', 'Cola'),
('IT02', 'ihphpih'),
('JU90', 'Fleur'),
('JU90', 'Marguerite'),
('JU90', 'Jack'),
('Paris56', 'Fleur'),
('Paris56', 'Framboise'),
('Paris56', 'Jack'),
('Paris56', 'Marguerite'),
('Kali900', 'Fleur'),
('Kali900', 'Framboise'),
('Kali900', 'Jack'),
('Kali900', 'Marguerite'),
('June9865', 'aeaf'),
('June9865', 'dddd'),
('June9865', 'Yoanne'),
('IT02', 'Yoanne');

-- --------------------------------------------------------

--
-- Table structure for table `avion`
--

CREATE TABLE `avion` (
  `TypeAvion` varchar(50) NOT NULL,
  `Ref` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `avion`
--

INSERT INTO `avion` (`TypeAvion`, `Ref`) VALUES
('C980', 'EN89'),
('JU89', 'Le Concor'),
('A380', 'T560'),
('T560', 'TY78');

-- --------------------------------------------------------

--
-- Table structure for table `equipage`
--

CREATE TABLE `equipage` (
  `Pilot` varchar(50) DEFAULT NULL,
  `Copilot` varchar(50) DEFAULT NULL,
  `volRefNpc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipage`
--

INSERT INTO `equipage` (`Pilot`, `Copilot`, `volRefNpc`) VALUES
('jean', 'Marjorie', 'FR01'),
('jean', 'Marc', 'IT02'),
('Carotte', 'Lapin', 'JU90'),
('Carotte', 'Lapin', 'Paris56'),
('Carotte', 'Lapin', 'Kali900'),
('jean', 'Marjorie', 'June9865');

-- --------------------------------------------------------

--
-- Table structure for table `membreequipage`
--

CREATE TABLE `membreequipage` (
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Metier` varchar(50) NOT NULL,
  `qualif1` varchar(50) DEFAULT NULL,
  `qualif2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `membreequipage`
--

INSERT INTO `membreequipage` (`Nom`, `Prenom`, `Metier`, `qualif1`, `qualif2`) VALUES
('aeaf', 'fezf', 'PNC', 'A380', NULL),
('Carotte', 'Princesse', 'PILOTE', 'JU89', 'YU987'),
('Cola', 'pulin', 'PNC', 'T560', 'C980'),
('dddd', 'aaaa', 'PNC', NULL, 'A380'),
('Decembry', 'jouluuu', 'COPILOTE', NULL, 'TY800'),
('Fleur', 'Rose', 'PNC', 'JU89', 'YU987'),
('Framboise', 'Clair', 'PNC', 'JU89', NULL),
('ihphpih', 'gpzo', 'PNC', NULL, 'C980'),
('Jack', 'jeacques', 'PNC', 'JU89', 'TY800'),
('jean', 'bon', 'PILOTE', 'benjamin', 'C980'),
('jenny', 'fer', 'PILOTE', 'benjamin', NULL),
('Lapin', 'Mme', 'COPILOTE', 'JU89', 'YU987'),
('Marc', 'Ilo', 'COPILOTE', 'C980', NULL),
('Marguerite', 'Pyjama', 'PNC', 'JU89', 'YU987'),
('Marjorie', 'Mark', 'COPILOTE', 'C980', 'A380'),
('test', 'test', 'PNC', NULL, 'C980'),
('Yoanne', 'pouli', 'PNC', 'C980', 'A380');

-- --------------------------------------------------------

--
-- Table structure for table `typeavion`
--

CREATE TABLE `typeavion` (
  `Nom` varchar(20) NOT NULL,
  `nbPNCmin` int(11) NOT NULL,
  `nbPNCmax` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typeavion`
--

INSERT INTO `typeavion` (`Nom`, `nbPNCmin`, `nbPNCmax`) VALUES
('A380', 2, 5),
('benjamin', 1, 2),
('C980', 3, 3),
('JU89', 4, 6),
('T560', 2, 3),
('TY800', 3, 5),
('YU987', 5, 6);

-- --------------------------------------------------------

--
-- Table structure for table `vol`
--

CREATE TABLE `vol` (
  `numvol` varchar(20) NOT NULL,
  `site` varchar(20) NOT NULL,
  `dest` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `avion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vol`
--

INSERT INTO `vol` (`numvol`, `site`, `dest`, `date`, `avion`) VALUES
('FR01', 'Paris', 'Tokyo', '2017-08-05', 'EN89'),
('IT02', 'Paris', 'Tokyo', '2017-07-07', 'EN89'),
('JU90', 'Paris', 'USA', '2017-05-30', 'Le Concor'),
('June9865', 'Tokyo', 'USA', '2017-09-06', 'T560'),
('Kali900', 'Paris', 'Paris', '2017-01-03', 'Le Concor'),
('Paris56', 'Paris', 'Londres', '2017-01-01', 'Le Concor');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`Ref`);

--
-- Indexes for table `membreequipage`
--
ALTER TABLE `membreequipage`
  ADD PRIMARY KEY (`Nom`);

--
-- Indexes for table `typeavion`
--
ALTER TABLE `typeavion`
  ADD PRIMARY KEY (`Nom`),
  ADD UNIQUE KEY `Nom` (`Nom`);

--
-- Indexes for table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`numvol`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
