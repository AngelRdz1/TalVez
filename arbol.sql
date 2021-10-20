CREATE database arbol;

USE arbol;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


--
-- Database: `arbol`
--

-- --------------------------------------------------------

--
-- Table structure for table `personasc`
--

CREATE TABLE `personasc` (
  `id` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `personasg`
--

CREATE TABLE `personasg` (
  `id` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `personasg`
--

INSERT INTO `personasg` (`id`, `nombre`) VALUES
(1, 'Oscar Madrid'),
(2, 'Isabel Hayde'),
(3, 'Oscar Fernando'),
(4, 'Raul Garcia'),
(5, 'Paula Quijano'),
(6, 'Esmeralda Cortez'),
(7, 'Allison Garcia'),
(8, 'Sara Amaya'),
(9, 'Nathaly Ademaris'),
(10, 'Renata Sanchez'),
(11, 'Olga Tañon'),
(12, 'Paulina Rubio'),
(13, 'Sandra Ramirez'),
(14, 'Jorge Gomez'),
(15, 'Erick Palma'),
(16, 'Cesar Hernandez'),
(17, 'Mauricio Granados'),
(18, 'Ivette Alvarado'),
(19, 'Maria Alfaro'),
(20, 'Alejandro Granados'),
(21, 'Sergio Ramirez'),
(22, 'Carolina Navarro'),
(23, 'Alex Cornejo'),
(24, 'Carlos Javier'),
(25, 'Erick Oviedo'),
(26, 'Fernando Palma'),
(27, 'Carlos Alvarado'),
(28, 'Antonio Solorzano'),
(29, 'Jonathan Tobar'),
(30, 'Bryan Tobar'),
(31, 'Nestor Tobar'),
(32, 'David Figueroa'),
(33, 'Samuel Vazques'),
(34, 'Stanley Novoa'),
(35, 'Karla Cedillos'),
(36, 'Priscilla Portillo'),
(37, 'Daniel Zelaya'),
(38, 'Ulises Mulato'),
(39, 'Salvador Enriquez'),
(40, 'Fabricio Morales'),
(41, 'Luis Serrano'),
(42, 'Diana Serrano'),
(43, 'Alexis Figueroa'),(44,'Juan Bautista'),
(45,'OLIVIA'),(46,'Franco'),
(47,'Bianca'),(48,'Bruno'),
(49,'Pedro'),(50,'Lautaro Benjamin'),
(51,'Lucas'),(52,'Simon'),
(53,'Julia'),(54,'Juan Pablo'),
(55,'Manuel'),(56,'Maria Victoria'),
(57,'Milagros'),(58,'Lorenzo'),
(59,'Lar'),(60,'Benicio'),
(61,'Mora'),(62,'Ramio'),
(63,'Tiziano'),(64,'Candela'),
(65,'Juan Manuel'),(66,'Uma'),
(67,'Mateo Benjamin'),(68,'Agostina'),
(69,'Clara'),(70,'Dante'),
(71,'Abril'),(72,'Guillermina'),
(73,'Julian'),(74,'Mia Valentina'),
(75,'Luciano'),(76,'Sebastian'),
(77,'Ana Paula'),(78,'Gonzalo'),
(79,'Paloma'),(80,'Luca'),
(81,'Antonella'),(82,'Thiago Agustin'),
(83,'Paulina'),(84,'Ciro'),
(85,'Lautaro Ezequiel'),(86,'Maria Emilia'),
(87,'Thiago Ezequiel'),(88,'Salvador'),
(89,'Morena Jazmin'),(90,'Francesca'),
(91,'Micaela'),(92,'Jeremias'),
(93,'Federico'),(94,'Juliana'),
(95,'Zoe'),(96,'Santiago Nicolas'),
(97,'Sofia Belen'),(98,'Thiago Nicolas'),
(99,'Ana Concepcion'),(100,'Jose Luis'),
(101, 'Oscar Madrid'),(102, 'Isabel Hayde'),
(103, 'Oscar Fernando'),(104, 'Raul Garcia'),
(105, 'Paula Quijano'),(106, 'Esmeralda Cortez'),
(107, 'Allison Garcia'),(108, 'Sara Amaya'),
(109, 'Nathaly Ademaris'),(110, 'Renata Sanchez'),
(111, 'Olga Tañon'),(112, 'Paulina Rubio'),
(113, 'Sandra Ramirez'),(114, 'Jorge Gomez'),
(115, 'Erick Palma'),(116, 'Cesar Hernandez'),
(117, 'Mauricio Granados'),(118, 'Ivette Alvarado'),
(119, 'Maria Alfaro'),(120, 'Alejandro Granados'),
(121, 'Sergio Ramirez'),(122, 'Carolina Navarro'),
(123, 'Alex Cornejo'),(124, 'Carlos Javier'),
(125, 'Erick Oviedo'),(126, 'Fernando Palma'),
(127, 'Carlos Alvarado'),(128, 'Antonio Solorzano'),
(129, 'Jonathan Tobar'),(130, 'Bryan Tobar'),
(131, 'Nestor Tobar'),(132, 'David Figueroa'),
(133, 'Samuel Vazques'),(134, 'Stanley Novoa'),
(135, 'Karla Cedillos'),(136, 'Priscilla Portillo'),
(137, 'Daniel Zelaya'),(138, 'Ulises Mulato'),
(139, 'Salvador Enriquez'),(140, 'Fabricio Morales'),
(141, 'Luis Serrano'),(142, 'Diana Serrano'),
(143, 'Alexis Figueroa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `personasc`
--
ALTER TABLE `personasc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `personasg`
--
ALTER TABLE `personasg`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `personasc`
--
ALTER TABLE `personasc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `personasg`
--
ALTER TABLE `personasg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO `personasc` (`id`, `nombre`) VALUES(1,'Benjamin'),
(2,'Sofia'),(3,'Bautista'),(4,'Juan'),(5,'Ignacio',(6,'Martina'),
(7,'Santiago'),(8,'Valentina'),(9,'Catalina'),(10,'Santino'),
(11,'Valentino'),(12,'Delfina'),
(13,'Mateo'),(14,'Francisco'),
(15,'Isabella'),(16,'Felipe'),
(17,'Julieta'),(18,'Victria'),
(19,'Lautaro'),(20,'Josefina'),
(21,'Morena'),(22,'Juana'),
(23,'Juan Cruz'),(24,'Thiago Benjamin'),
(25,'Camila'),(26,'Ignacio'),
(27,'Guadalupe'),(28,'Mia'),
(29,'Emma'),(30,'Jazmin'),
(31,'Facundo'),(32,'Maximo'),
(33,'Nicolas'),(34,'Thiago'),
(35,'Lola'),(36,'Valentin'),
(37,'Agustina'),(38,'Pilar'),
(39,'Alma'),(40,'Emilia'),
(41,'Matias'),(42,'Juan Martin'),
(43,'Renata Bonilla'),(44,'Juan Bautista'),
(45,'OLIVIA'),(46,'Franco'),
(47,'Bianca'),(48,'Bruno'),
(49,'Pedro'),(50,'Lautaro Benjamin'),
(51),'Lucas'),(52,'Simon'),
(53,'Julia'),(54,'Juan Pablo'),
(55,'Manuel'),(56,'Maria Victoria'),
(57,'Milagros'),(58,'Lorenzo'),
(59,'Lar'),(60,'Benicio'),
(61,'Mora'),(62,'Ramio'),
(63,'Tiziano'),(64,'Candela'),
(65,'Juan Manuel'),(66,'Uma'),
(67,'Mateo Benjamin'),(68,'Agostina'),
(69,'Clara'),(70,'Dante'),
(71,'Abril'),(72,'Guillermina'),
(73,'Julian'),(74,'Mia Valentina'),
(75,'Luciano'),(76,'Sebastian'),
(77,'Ana Paula'),(78,'Gonzalo'),
(79,'Paloma'),(80,'Luca'),
(81,'Antonella'),(82,'Thiago Agustin'),
(83,'Paulina'),(84,'Ciro'),
(85,'Lautaro Ezequiel'),(86,'Maria Emilia'),
(87,'Thiago Ezequiel'),(88,'Salvador'),
(89,'Morena Jazmin'),(90,'Francesca'),
(91,'Micaela'),
(92,'Jeremias'),
(93,'Federico'),
(94,'Juliana'),
(95,'Zoe'),
(96,'Santiago Nicolas'),
(97,'Sofia Belen'),
(98,'Thiago Nicolas'),
(99,'Ana Concepcion'),
(100,'Jose Luis'),
(101, 'Oscar Madrid'),
(102, 'Isabel Hayde'),
(103, 'Oscar Fernando'),
(104, 'Raul Garcia'),
(105, 'Paula Quijano'),
(106, 'Esmeralda Cortez'),
(107, 'Allison Garcia'),
(108, 'Sara Amaya'),
(109, 'Nathaly Ademaris'),
(110, 'Renata Sanchez'),
(111, 'Olga Tañon'),
(112, 'Paulina Rubio'),
(113, 'Sandra Ramirez'),
(114, 'Jorge Gomez'),
(115, 'Erick Palma'),
(116, 'Cesar Hernandez'),
(117, 'Mauricio Granados'),
(118, 'Ivette Alvarado'),
(119, 'Maria Alfaro'),
(120, 'Alejandro Granados'),
(121, 'Sergio Ramirez'),
(122, 'Carolina Navarro'),
(123, 'Alex Cornejo'),
(124, 'Carlos Javier'),
(125, 'Erick Oviedo'),
(126, 'Fernando Palma'),
(127, 'Carlos Alvarado'),
(128, 'Antonio Solorzano'),
(129, 'Jonathan Tobar'),
(130, 'Bryan Tobar'),
(131, 'Nestor Tobar'),
(132, 'David Figueroa'),
(133, 'Samuel Vazques'),
(134, 'Stanley Novoa'),
(135, 'Karla Cedillos'),
(136, 'Priscilla Portillo'),
(137, 'Daniel Zelaya'),
(138, 'Ulises Mulato'),
(139, 'Salvador Enriquez'),
(140, 'Fabricio Morales'),
(141, 'Luis Serrano'),
(142, 'Diana Serrano'),
(143, 'Alexis Figueroa');
