-- phpMyAdmin SQL Dump
-- version 4.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 13-02-2015 a las 20:31:46
-- Versión del servidor: 5.6.23
-- Versión de PHP: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de datos: `mcmarc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id_adm` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `n_usuario` varchar(50) NOT NULL,
  `pw` varchar(100) NOT NULL,
  `tipo` int(10) NOT NULL,
  `foto` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id_adm`, `nombre`, `n_usuario`, `pw`, `tipo`, `foto`) VALUES
(1, 'Desarrollador', 'Superusuario', 'misterio220194', 1, 'C:\\Users\\Jaasiel Malagon\\Desktop\\profilePictures\\root.png'),
(2, 'Carlos Roberto Rodriguez', 'ingcarlosrod', 'admin', 3, 'C:\\Users\\Jaasiel Malagon\\Desktop\\profilePictures\\carlos.jpg'),
(4, 'Ing. Carlos Rodriguez', 'ingcarlosrod', 'mcmarc', 3, ''),
(6, 'Miriam', 'miriam', 'miriam123', 5, ''),
(7, 'Fulanito de Tal', 'capturista1', 'cap1234', 4, ''),
(8, 'Yeimi', 'Almacen 2 McApparel', '123456789', 6, ''),
(9, 'Eduardo Mora Lima', 'Almacen Gral. McApparel', 'almacengeneral', 2, 'C:\\Users\\Jaasiel Malagon\\Desktop\\profilePictures\\eduardo.jpg');

--
-- Disparadores `administradores`
--
DELIMITER $$
CREATE TRIGGER `nuevo_almacen` AFTER INSERT ON `administradores`
 FOR EACH ROW INSERT INTO nombres_almacen(nombre_almacen,tipo) values (new.n_usuario,new.tipo)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen_reportes`
--

CREATE TABLE `almacen_reportes` (
  `corte` varchar(10) NOT NULL,
  `origen` varchar(50) NOT NULL,
  `destino` int(11) NOT NULL,
  `cierre` int(11) NOT NULL,
  `deslizador` int(11) NOT NULL,
  `et_marca` int(11) NOT NULL,
  `et_monach` int(11) NOT NULL,
  `et_talla` int(11) NOT NULL,
  `cinta_fus` int(11) NOT NULL,
  `hilo` int(11) NOT NULL,
  `resorte` int(11) NOT NULL,
  `et_piel` int(11) NOT NULL,
  `et_tabtam` int(11) NOT NULL,
  `et_tabtalla` int(11) NOT NULL,
  `fecha_envio` date NOT NULL,
  `hora_envio` time NOT NULL,
  `comentario` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen_stock`
--

CREATE TABLE `almacen_stock` (
  `almacen` int(10) NOT NULL,
  `fecha_registro` date NOT NULL,
  `hora_registro` time NOT NULL,
  `corte` varchar(10) NOT NULL,
  `cierre` int(11) NOT NULL,
  `deslizador` int(11) NOT NULL,
  `et_marca` int(11) NOT NULL,
  `et_monach` int(11) NOT NULL,
  `et_talla` int(11) NOT NULL,
  `cinta_fus` int(11) NOT NULL,
  `hilo` int(11) NOT NULL,
  `resorte` int(11) NOT NULL,
  `et_piel` int(11) NOT NULL,
  `et_tabtam` int(11) NOT NULL,
  `et_tabtalla` int(11) NOT NULL,
  `comentarios` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE `area` (
  `id_area` int(3) NOT NULL,
  `nombre_area` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`id_area`, `nombre_area`) VALUES
(1, 'Delantero'),
(2, 'Trasero'),
(3, 'Ensamble'),
(4, 'Especial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cortes`
--

CREATE TABLE `cortes` (
  `id_corte` varchar(10) NOT NULL,
  `fecha_recibo` varchar(15) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_entrega` varchar(15) NOT NULL,
  `planta` int(1) NOT NULL,
  `linea` int(1) NOT NULL,
  `precio` int(10) NOT NULL,
  `imagen` varchar(300) DEFAULT NULL,
  `parcialuno` date DEFAULT NULL,
  `parcialdos` date DEFAULT NULL,
  `parcialtres` date DEFAULT NULL,
  `parcialcuatro` date DEFAULT NULL,
  `parcialcinco` date DEFAULT NULL,
  `enviouno` int(11) DEFAULT NULL,
  `enviodos` int(11) DEFAULT NULL,
  `enviotres` int(11) DEFAULT NULL,
  `enviocuatro` int(11) DEFAULT NULL,
  `enviocinco` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` int(10) NOT NULL,
  `n_nomina` int(10) NOT NULL,
  `nombre_empleado` varchar(100) NOT NULL,
  `area` varchar(50) NOT NULL,
  `operacion` varchar(100) NOT NULL,
  `estado` smallint(2) NOT NULL,
  `fecha_contrato` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  `sueldo_base` int(10) DEFAULT NULL,
  `tarea` int(11) NOT NULL,
  `Miercoles` int(10) DEFAULT NULL,
  `Jueves` int(10) DEFAULT NULL,
  `Viernes` int(10) DEFAULT NULL,
  `Sabado` int(11) DEFAULT NULL,
  `Lunes` int(10) DEFAULT NULL,
  `Martes` int(10) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `n_nomina`, `nombre_empleado`, `area`, `operacion`, `estado`, `fecha_contrato`, `fecha_baja`, `sueldo_base`, `tarea`, `Miercoles`, `Jueves`, `Viernes`, `Sabado`, `Lunes`, `Martes`) VALUES
(2, 103, 'Erika Aguilar Flores', 'Ensamble', 'Revisado final', 1, '2015-01-05', NULL, 900, 600, 575, 566, 376, 466, 215, 655),
(6, 187, 'Josefina Ramirez Martinez', 'Ensamble', 'Revisado final', 1, '2015-01-06', NULL, 900, 600, 775, 655, 667, 490, 727, 630),
(7, 309, 'Rufina Martinez Miranda', 'Ensamble', 'Hacer valenciana', 1, '2015-01-06', NULL, 1300, 1000, 900, 1000, 1000, 553, 962, 926),
(8, 161, 'Angelica Figueroa Martinez', 'Ensamble', 'Revisado final', 1, '2015-01-06', NULL, 900, 600, 0, 1000, 770, 550, 1000, 1484),
(9, 165, 'Jesus Gonzalez Hernandez', 'Ensamble', 'Hacer valenciana', 1, '2015-01-06', NULL, 1200, 1000, 940, 1000, 1000, 510, 1000, 91),
(10, 174, 'Maria de los Santos', 'Ensamble', 'Pegar traba', 1, '2015-01-06', NULL, 1100, 750, 797, 830, 795, 430, 823, 783),
(11, 159, 'Andrea Martinez Santiago', 'Especial', 'Manual', 1, '2015-01-06', NULL, 750, 3000, 2495, 3199, 4687, 3080, 0, 3716),
(13, 332, 'Rita Jimenez Garcia', 'Ensamble', 'Revisado final', 1, '2015-01-06', NULL, 900, 600, 0, 0, 0, 0, 0, 0),
(14, 330, 'Maribel Ramos Lopez', 'Ensamble', 'Revisado final', 1, '2015-01-06', NULL, 900, 600, 0, 0, 0, 0, 0, 0),
(15, 194, 'Sergio Baltazar Guzman', 'Ensamble', 'Pegar traba', 1, '2015-01-06', NULL, 1100, 750, 715, 725, 806, 438, 753, 730),
(16, 154, 'Guadalupe Torres', 'Ensamble', 'Pegar traba', 1, '2015-01-06', NULL, 1100, 750, 654, 667, 776, 423, 730, 762),
(17, 306, 'Karina Nabor Bravo', 'Ensamble', 'Hacer valenciana', 1, '2015-01-06', NULL, 1200, 1000, 0, 0, 0, 0, 0, 0),
(18, 171, 'Yuliana Olivares Bringas', 'Ensamble', 'Pegar etiqueta pretina', 1, '2015-01-06', NULL, 1100, 1500, 1700, 1704, 1700, 850, 1700, 1606),
(19, 144, 'Brenda Michel Cordova', 'Especial', 'Manual', 1, '2015-01-06', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(20, 132, 'Liliana Gonzalez Hernandez', 'Ensamble', 'Pegar pretina/pretinar', 1, '2015-01-06', NULL, 1600, 750, 750, 808, 900, 437, 750, 455),
(21, 133, 'Lucia Lopez Moran', 'Ensamble', 'Pegar pretina/pretinar', 1, '2015-01-06', NULL, 1600, 750, 1000, 900, 950, 500, 1000, 910),
(22, 500, 'Josafath Castillo Ordino', 'Ensamble', 'Voltear pantalon', 1, '2015-01-06', NULL, 600, 3000, 0, 0, 0, 0, 0, 0),
(23, 100, 'David Cruz S', 'Ensamble', 'Cerrar Bolsa', 1, '2015-01-06', NULL, 1100, 1800, 1592, 1175, 1540, 770, 1210, 0),
(24, 123, 'Erick Ulises Vazquez Jimenez', 'Delantero', 'Pegar vista (SN)', 1, '2015-01-06', NULL, 1000, 1500, 1560, 1688, 2750, 1100, 0, 2204),
(25, 143, 'Dulce Alejandra Cruz Montalvo', 'Delantero', 'Marcar vistas (8 marcas)', 1, '2015-01-06', NULL, 700, 10, 10, 10, 10, 5, 10, 10),
(26, 191, 'Erick Fernando Arangute Cortes', 'Especial', 'Manual', 1, '2015-01-06', NULL, 750, 3000, 0, 0, 0, 0, 0, 3000),
(27, 344, 'Candelaria Cordova', 'Trasero', 'Pegar bolsa trasera(2 agujas)', 1, '2015-01-06', NULL, 1200, 650, 650, 562, 650, 325, 670, 536),
(29, 183, 'Floricel Luna Ortega', 'Trasero', 'Bloquear pza. altura', 1, '2015-01-06', NULL, 800, 3000, 1800, 1742, 1800, 1000, 880, 1236),
(30, 169, 'Elizabeth Bravo Rosales', 'Trasero', 'Planchar bolsa', 1, '2015-01-06', NULL, 900, 1000, 1000, 1000, 1000, 540, 1000, 1000),
(31, 200, 'Paz Barbosa Jimenez', 'Ensamble', 'Revisado final', 1, '2015-01-07', NULL, 900, 600, 550, 630, 685, 462, 680, 558),
(32, 361, 'Fernando Altamirano Mont', 'Ensamble', 'Refilar encuartes', 1, '2015-01-07', NULL, 1000, 1700, 0, 0, 0, 0, 0, 0),
(33, 204, 'Raul Duarte Perez', 'Ensamble', 'Engargolar entrepierna', 1, '2015-01-08', NULL, 1600, 1100, 1190, 1300, 1600, 740, 1125, 1370),
(34, 101, 'Ricardo Cristobal Cuaquetzale', 'Ensamble', 'Pegar traba', 1, '2015-01-08', NULL, 1100, 750, 1119, 1299, 1672, 2583, 1227, 1070),
(39, 110, 'Rosario Javier Garcia', 'Ensamble', 'Encuarte delantero', 1, '2015-01-12', NULL, 1200, 1500, 1680, 1800, 1835, 900, 1380, 1560),
(40, 184, 'Luis Alberto Gonzalez', 'Delantero', 'Cerrar falso', 1, '2015-01-12', NULL, 950, 6000, 6000, 4038, 5723, 2040, 5069, 5768),
(41, 358, 'Anahy Baltazar Linares', 'Especial', 'Manual', 1, '2015-01-12', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(43, 363, 'Maribel Gonzalez', 'Delantero', 'Pegar vista (cover stich)', 1, '2015-01-12', NULL, 1200, 2200, 0, 0, 1540, 0, 0, 0),
(44, 140, 'Benito Daza Enriquez', 'Delantero', 'Dise?o de ojalera', 1, '2015-01-12', NULL, 1200, 2000, 2400, 2553, 2306, 1100, 2430, 2374),
(45, 163, 'Lidia Damian Baltazar', 'Ensamble', 'Pegar talla', 1, '2015-01-12', NULL, 850, 2000, 0, 0, 0, 0, 0, 0),
(46, 130, 'Guillermina Carrera Palestino', 'Delantero', 'Pegar secreta', 1, '2015-01-12', NULL, 1200, 1350, 360, 432, 1320, 695, 1350, 1100),
(47, 352, 'Victoria Alvarado Ramos', 'Delantero', 'Pegar ojalera (boquilla)', 1, '2015-01-12', NULL, 1200, 2000, 0, 0, 0, 0, 0, 0),
(48, 325, 'Victoria Alvarado Ramos', 'Delantero', 'Pegar ojalera (boquilla)', 1, '2015-01-12', NULL, 1200, 2000, 2070, 2406, 2048, 1000, 2000, 2122),
(49, 334, 'Bibiana Esparragoza Alvarado', 'Especial', 'Manual', 1, '2015-01-12', NULL, 750, 10, 10, 10, 10, 0, 0, 0),
(50, 167, 'Lucero Gonzalez Hernandez', 'Delantero', 'Pegar manta/bolsa', 1, '2015-01-12', NULL, 1100, 1300, 1100, 1100, 1100, 0, 970, 1100),
(51, 157, 'Yareli Oyuki Gaspar Vargas', 'Especial', 'Manual', 1, '2015-01-12', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(52, 122, 'Christopher Castaneda', 'Ensamble', 'Cerrar costados', 1, '2015-01-12', NULL, 1300, 1200, 1320, 960, 1500, 720, 740, 460),
(53, 206, 'Israel Dominguez Marcial', 'Especial', 'Manual', 1, '2015-01-12', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(54, 111, 'Alejandra Oropeza R', 'Ensamble', 'Sobrecoser falso', 1, '2015-01-12', NULL, 1100, 1500, 0, 0, 0, 0, 0, 0),
(58, 188, 'Pablo Francisco Martinez', 'Delantero', 'Sobrecoser delantero', 1, '2015-01-12', NULL, 1200, 1300, 1320, 1320, 1300, 650, 1300, 1300),
(59, 335, 'Ronaldo Baltazar Hernandez', 'Especial', 'Manual', 1, '2015-01-12', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(60, 152, 'Virgilio Gaspar', 'Delantero', 'Pegar falso', 1, '2015-01-12', NULL, 1100, 1650, 0, 0, 0, 0, 0, 0),
(61, 311, 'Omar Alfredo Sanchez S', 'Delantero', 'Pegar manta/bolsa', 1, '2015-01-12', NULL, 1100, 1300, 800, 800, 800, 0, 800, 740),
(62, 327, 'Heriberto Cabrera', 'Delantero', 'Sobrehilar ojalera ', 1, '2015-01-12', NULL, 950, 6000, 0, 0, 0, 3100, 0, 0),
(63, 326, 'Brenda Jazmin Hernandez', 'Delantero', 'Pegar vista (SN)', 1, '2015-01-12', NULL, 1000, 1500, 1320, 993, 834, 110, 1120, 678),
(64, 322, 'Monica Ortiz Arguellez', 'Especial', 'Manual', 1, '2015-01-12', NULL, 750, 100, 1300, 1303, 1303, 990, 1583, 1977),
(65, 126, 'Valentina Morales Manuel', 'Delantero', 'Fijar delantero', 1, '2015-01-12', NULL, 1000, 1000, 850, 400, 901, 450, 820, 710),
(66, 219, 'Pedro Garcia Venegas', 'Delantero', 'Pegar manta/bolsa', 1, '2015-01-12', NULL, 1100, 1100, 0, 0, 0, 0, 0, 0),
(68, 149, 'Raquel Rodriguez Ramos', 'Delantero', 'Sobrecoser delantero', 1, '2015-01-12', NULL, 1200, 1300, 1303, 1300, 1300, 650, 1300, 1300),
(69, 207, 'Luis Nunez Sanchez', 'Especial', 'Bultero', 1, '2015-01-12', NULL, 700, 10, 0, 10, 10, 5, 10, 10),
(70, 342, 'Leonardo Delgado Hernandez', 'Delantero', 'Pegar manta/bolsa', 1, '2015-01-12', NULL, 1100, 1800, 0, 0, 0, 0, 0, 0),
(71, 195, 'Mar Angeles Cruz', 'Delantero', 'Fijar delantero', 1, '2015-01-12', NULL, 1000, 1000, 960, 960, 960, 494, 760, 570),
(72, 316, 'Esther Zamora Olvera', 'Delantero', 'Pegar secreta', 1, '2015-01-12', NULL, 1200, 1350, 520, 310, 1320, 695, 865, 1012),
(73, 343, 'Leticia Cabanzo A', 'Ensamble', 'Fijar bolsa', 1, '2015-01-12', NULL, 1000, 1000, 1800, 1800, 1082, 993, 1870, 1930),
(74, 208, 'Anayeli Rosas Castillo', 'Ensamble', 'Pegar talla', 1, '2015-01-12', NULL, 850, 1000, 960, 1080, 1000, 440, 880, 480),
(75, 396, 'Ines Garcia Venegas', 'Ensamble', 'Encuarte delantero', 1, '2015-01-13', NULL, 1200, 1500, 1320, 480, 1207, 770, 1400, 1090),
(76, 134, 'Agustin Romero Hernandez', 'Delantero', 'Pegar falso', 1, '2015-01-13', NULL, 1100, 1650, 1200, 1500, 1554, 780, 1200, 1328),
(77, 324, 'Graciela Hernandez Morales', 'Delantero', 'Pegar manta/bolsa', 1, '2015-01-13', NULL, 1100, 1300, 820, 872, 770, 500, 1131, 908),
(78, 166, 'Briseida Vazquez Jimenez', 'Especial', 'Comodin', 1, '2015-01-13', NULL, 800, 1500, 1362, 1362, 1800, 900, 0, 895),
(79, 190, 'Diego Francisco Conde Fuentes', 'Delantero', 'Presillar ojalera', 1, '2015-01-13', NULL, 950, 4500, 3240, 2640, 3152, 1540, 3320, 2650),
(80, 364, 'Agustin Sarabia R', 'Especial', 'Bultero', 1, '2015-01-13', NULL, 700, 10, 10, 10, 10, 5, 10, 10),
(81, 321, 'Francisco Baltazar Flores', 'Especial', 'Comodin', 1, '2015-01-13', NULL, 1200, 3000, 1680, 1895, 2002, 1000, 2750, 526),
(83, 359, 'Karina Espindola Gamez', 'Ensamble', 'Deshebrado', 1, '2015-01-13', NULL, 500, 500, 620, 655, 623, 467, 649, 795),
(84, 357, 'Ana Rosa Mora Pacheco', 'Ensamble', 'Deshebrado', 1, '2015-01-13', NULL, 600, 400, 592, 620, 419, 600, 600, 693),
(85, 209, 'Jose Mario de la Vega P', 'Especial', 'Bultero', 1, '2015-01-13', NULL, 700, 100, 0, 0, 0, 0, 0, 0),
(86, 199, 'Alan Eduardo Hernandez', 'Especial', 'Bultero', 1, '2015-01-13', NULL, 700, 100, 0, 0, 0, 0, 0, 0),
(87, 331, 'Maria de la Luz Rodriguez Ramirez', 'Ensamble', 'Revisado final', 1, '2015-01-13', NULL, 900, 600, 510, 555, 541, 390, 615, 700),
(88, 179, 'Ana Soledad Martinez Hernandez', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 0, 0, 0, 0, 10, 10),
(89, 300, 'Veronica Atanacio Trujillo', 'Ensamble', 'Revisado final', 1, '2015-01-13', NULL, 900, 600, 420, 530, 466, 450, 600, 657),
(90, 391, 'Idelfonso Hernandez Delfin', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 3000, 0, 0, 0, 0, 0, 0),
(91, 225, 'Carmela Ojeda Flores', 'Ensamble', 'Refilar valencianas/bajos', 1, '2015-01-13', NULL, 800, 2200, 0, 0, 0, 0, 0, 0),
(92, 226, 'Yoana Rosete Baltazar', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(93, 192, 'Raul Espinoza Medina', 'Especial', 'Bultero', 1, '2015-01-13', NULL, 700, 100, 100, 0, 0, 0, 0, 0),
(94, 102, 'Julian Nava C', 'Ensamble', 'Hacer ojal', 1, '2015-01-13', NULL, 1000, 4000, 3575, 3231, 3604, 1779, 2633, 2981),
(95, 348, 'Tereso Osorio Merino', 'Ensamble', 'Pegar traba', 1, '2015-01-13', NULL, 1100, 750, 0, 0, 320, 480, 480, 340),
(96, 107, 'Hermenegildo Nava Castillo', 'Ensamble', 'Hacer valenciana', 1, '2015-01-13', NULL, 1200, 1000, 763, 929, 958, 472, 759, 713),
(97, 308, 'Martin Sandoval Lima', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 3000, 1600, 1600, 1300, 1600, 1500, 1500),
(98, 155, 'Marco Antonio Suarez Romero', 'Ensamble', 'Pegar traba', 1, '2015-01-13', NULL, 1100, 750, 710, 743, 899, 456, 920, 765),
(99, 386, 'Ivan Luna Ortega', 'Especial', 'Comodin', 1, '2015-01-13', NULL, 700, 10, 10, 10, 10, 5, 10, 10),
(100, 367, 'Silvia Reyes Muoz', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 100, 10, 10, 10, 5, 10, 10),
(101, 218, 'Maximiliano Castillo Valentin', 'Especial', 'Bultero', 1, '2015-01-13', NULL, 700, 100, 0, 0, 0, 0, 0, 0),
(102, 354, 'Lucia Castillo Garcia', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(103, 319, 'Jose Romero', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 0, 0, 0, 0, 0, 0),
(104, 162, 'Rigoberto Orozco Alvarez', 'Trasero', 'Pegar pza. altura', 1, '2015-01-13', NULL, 1500, 1800, 2410, 2105, 2516, 1430, 1520, 530),
(105, 380, 'Leticia Nieves Garcia', 'Ensamble', 'Engargolar entrepierna', 1, '2015-01-13', NULL, 1600, 1100, 1240, 1260, 1480, 850, 1550, 1500),
(106, 230, 'Karina Espindola Gamez', 'Ensamble', 'Deshebrado', 1, '2015-01-13', NULL, 600, 400, 0, 0, 0, 0, 0, 0),
(107, 227, 'Rosaura Espindola Lopez', 'Ensamble', 'Deshebrado', 1, '2015-01-13', NULL, 600, 400, 0, 0, 0, 0, 0, 0),
(108, 228, 'Alejandra Melchor Vitoria', 'Ensamble', 'Deshebrado', 1, '2015-01-13', NULL, 600, 400, 0, 0, 0, 0, 0, 0),
(109, 229, 'Griselda Gomez Rojas', 'Ensamble', 'Deshebrado', 1, '2015-01-13', NULL, 600, 400, 0, 0, 0, 0, 0, 0),
(110, 120, 'Columba Cristobal', 'Ensamble', 'Hacer cuadro', 1, '2015-01-13', NULL, 1200, 1600, 2208, 2280, 2510, 920, 2403, 1722),
(111, 224, 'Emma Eloisa valerio Hernandez', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(112, 185, 'Veronica Arguellez eugenio', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(113, 129, 'Martin Villalobos Villagomez', 'Ensamble', 'Cerrar costados', 1, '2015-01-13', NULL, 1300, 1200, 0, 0, 0, 0, 1540, 1500),
(114, 365, 'Armando Vidal Alfaro', 'Especial', 'Bultero', 1, '2015-01-13', NULL, 700, 10, 10, 10, 10, 5, 10, 10),
(115, 314, 'Ana Isabel Vargas Trujillo', 'Ensamble', 'Hacer pares', 1, '2015-01-13', NULL, 750, 1500, 1500, 1500, 1500, 750, 1500, 1500),
(116, 160, 'Gerardo Gonzalez Hernandez', 'Ensamble', 'Pespunte de costado', 1, '2015-01-13', NULL, 1100, 1200, 1150, 1150, 1150, 575, 1150, 1150),
(117, 305, 'Reyna Hernandez Olmos', 'Especial', 'Comodin', 1, '2015-01-13', NULL, 1, 1, 0, 0, 0, 0, 0, 0),
(118, 313, 'Teresa Ascencion Escobar', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(119, 317, 'Emanuel Castaneda de Jesus', 'Especial', 'Comodin', 1, '2015-01-13', NULL, 1, 1500, 0, 0, 0, 0, 0, 0),
(120, 223, 'Cesar Omar Jimenez Martinez', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 3000, 3440, 2900, 3600, 1980, 3160, 0),
(121, 310, 'Ericka Guadalupe Martinez Garcia', 'Ensamble', 'Pegar etiqueta pretina', 1, '2015-01-13', NULL, 1100, 1500, 0, 0, 0, 0, 0, 0),
(122, 115, 'Juana Ortolan Colin', 'Ensamble', 'Sobrecoser costados', 1, '2015-01-13', NULL, 1100, 1200, 1560, 600, 1486, 750, 1540, 1275),
(123, 341, 'Maria de los Angeles Martinez Garcia', 'Ensamble', 'Revisar pretina', 1, '2015-01-13', NULL, 700, 10, 10, 10, 10, 5, 10, 10),
(124, 139, 'Karina Vazquez', 'Ensamble', 'Revisar pretina', 1, '2015-01-13', NULL, 700, 750, 0, 0, 0, 0, 0, 0),
(125, 168, 'Benito Carrera Gonzalez', 'Ensamble', 'Refilar delantero x trasero', 1, '2015-01-13', NULL, 1100, 10, 10, 10, 10, 5, 10, 10),
(126, 150, 'Jose Luis Castaneda Hernandez', 'Ensamble', 'Cerrar costados', 1, '2015-01-13', NULL, 1300, 1200, 1200, 1200, 1200, 600, 1200, 1200),
(127, 128, 'Erasmo Valiente Barragan', 'Especial', 'Comodin', 1, '2015-01-13', NULL, 1, 10, 0, 0, 0, 0, 0, 0),
(128, 153, 'Estrada Rivera Gerardo', 'Ensamble', 'Cerrar costados', 1, '2015-01-13', NULL, 1300, 1200, 1000, 480, 1246, 660, 1200, 1200),
(129, 181, 'Cesar Dolores Morales', 'Ensamble', 'Pegar pretina/pretinar', 1, '2015-01-13', NULL, 1600, 750, 840, 810, 950, 500, 825, 900),
(130, 301, 'Edith Santana Merino', 'Ensamble', 'Piquete trasero', 1, '2015-01-13', NULL, 750, 3000, 0, 0, 0, 0, 0, 0),
(131, 346, 'Joel Perez Amayo', 'Ensamble', 'Deshebrado', 1, '2015-01-13', NULL, 600, 1500, 0, 0, 0, 0, 0, 0),
(132, 34, 'Jorge Luis Antonio Maldonado Martinez', 'Ensamble', 'Deshebrado', 1, '2015-01-13', NULL, 600, 1500, 0, 0, 0, 0, 0, 0),
(133, 304, 'Alma Delia de la Cruz', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(134, 205, 'Laura Rosas Castillo', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(135, 104, 'Maria de Lourdes Morales Mendoza', 'Especial', 'Manual', 1, '2015-01-13', NULL, 750, 3000, 0, 0, 0, 0, 0, 0),
(136, 553, 'Victor Santos de Jesus', 'Trasero', 'Pegar bolsa trasera(2 agujas)', 1, '2015-01-14', NULL, 1200, 650, 640, 650, 650, 325, 658, 526),
(137, 362, 'Aristeo Valencia S', 'Especial', 'Bultero', 1, '2015-01-14', NULL, 700, 100, 0, 0, 0, 0, 0, 0),
(138, 356, 'Cenobia Cristobal', 'Trasero', 'Pegar bolsa trasera(2 agujas)', 1, '2015-01-14', NULL, 1200, 650, 714, 600, 486, 315, 710, 711),
(139, 302, 'Maricela Damian Baltazar', 'Trasero', 'Encuarte trasero', 1, '2015-01-14', NULL, 1500, 1800, 2731, 1928, 2750, 1430, 1310, 0),
(140, 211, 'Ixel Reyes Orozco', 'Trasero', 'Marcar a plomos', 1, '2015-01-14', NULL, 700, 1500, 0, 0, 0, 0, 0, 0),
(141, 201, 'Adriana Rosas', 'Ensamble', 'Pegar etiqueta patch(SN)', 1, '2015-01-14', NULL, 1050, 1200, 1040, 1006, 800, 550, 1270, 950),
(142, 193, 'Vanessa Franco V', 'Trasero', 'Planchar bolsa', 1, '2015-01-14', NULL, 900, 1000, 1000, 694, 1000, 500, 110, 1000),
(143, 189, 'Karina Trujillo Monterrosa', 'Especial', 'Manual', 1, '2015-01-14', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(144, 108, 'Patricia Garcia', 'Trasero', 'Pegar bolsa trasera(2 agujas)', 1, '2015-01-14', NULL, 1200, 650, 650, 650, 650, 325, 650, 528),
(145, 109, 'Osvaldo Nava', 'Trasero', 'Presillar bolsa trasera', 1, '2015-01-14', NULL, 950, 2000, 2000, 1761, 2000, 1008, 2000, 2000),
(146, 114, 'Jaime Perdomo', 'Trasero', 'Pegar bolsa trasera(2 agujas)', 1, '2015-01-14', NULL, 1200, 650, 650, 650, 650, 320, 650, 485),
(147, 121, 'Lucio Limon Hernandez', 'Trasero', 'Bloquear pza. altura', 1, '2015-01-14', NULL, 800, 3000, 960, 865, 933, 307, 858, 780),
(148, 124, 'Ana Laura Abascal Torres', 'Trasero', 'Bloquear pza. altura', 1, '2015-01-14', NULL, 800, 3000, 2495, 0, 2000, 1320, 1220, 1266),
(149, 136, 'Teodora Gomez Bolanos', 'Trasero', 'Planchar bolsa', 1, '2015-01-14', NULL, 900, 1000, 160, 1000, 1000, 500, 1000, 500),
(150, 137, 'Maria Luisa Apolinar Espinoza', 'Trasero', 'Marcar a plomos', 1, '2015-01-14', NULL, 700, 1500, 1150, 1121, 1130, 620, 0, 0),
(151, 141, 'Genoveva Rodriguez Montalvo', 'Trasero', 'Marcar a plomos', 1, '2015-01-14', NULL, 700, 1800, 1490, 1709, 1760, 840, 1210, 1580),
(152, 158, 'Adriana Linares Lezama', 'Trasero', 'Bloquear pza. altura', 1, '2015-01-14', NULL, 800, 3000, 0, 0, 0, 0, 0, 0),
(153, 164, 'Nazario de Jesus', 'Trasero', 'Revisar encuarte trasero', 1, '2015-01-14', NULL, 750, 2500, 0, 0, 0, 0, 0, 0),
(154, 172, 'Alfredo Dominguez Morelos', 'Trasero', 'Presillar bolsa trasera', 1, '2015-01-14', NULL, 950, 2000, 2520, 3720, 600, 1000, 2560, 630),
(155, 173, 'Omar Gomez Flores', 'Trasero', 'Bastillar bolsa trasera', 1, '2015-01-14', NULL, 1200, 4000, 3240, 3319, 4687, 3080, 0, 3716),
(156, 375, 'Tatiana Cristobal Cuaqueztles', 'Ensamble', 'Pegar etiqueta patch(SN)', 1, '2015-01-14', NULL, 1050, 1200, 0, 0, 0, 0, 0, 0),
(157, 360, 'Fernando Altamirano Mont', 'Ensamble', 'Refilar entrepierna', 1, '2015-01-14', NULL, 1100, 3000, 0, 0, 0, 0, 0, 0),
(158, 318, 'Emmanuel Castaneda de Jesus', 'Ensamble', 'Hacer cuadro', 1, '2015-01-14', NULL, 1200, 1500, 2500, 1700, 0, 1100, 1760, 0),
(159, 555, 'Gabriel Ponce R', 'Especial', 'Bultero', 1, '2015-01-14', NULL, 700, 100, 100, 100, 100, 50, 100, 100),
(160, 148, 'Angel Daniel Ramirez Vilafan', 'Especial', 'Comodin', 1, '2015-01-14', NULL, 1000, 1000, 187, 187462, 463, 278, 476, 0),
(161, 112, 'Alexis Noe Onofre Zarate', 'Ensamble', 'Empaque', 1, '2015-01-14', NULL, 1100, 10, 10, 10, 10, 5, 10, 10),
(162, 74, 'Jaasiel Mendez Malagon', 'Especial', 'Confianza/Secretaria', 1, '2015-01-15', NULL, 900, 10, 10, 10, 10, 5, 10, 10),
(163, 562, 'Leonardo Lopez Montiel', 'Ensamble', 'Empaque', 1, '2015-01-15', NULL, 1100, 10, 10, 10, 10, 5, 10, 10),
(164, 517, 'Emanuel Alvarado Ramos', 'Ensamble', 'Deslizador y grapa', 1, '2015-01-15', NULL, 950, 1500, 100, 100, 0, 0, 0, 0),
(165, 177, 'Luis Angel Garcia Jimenez', 'Delantero', 'Pegar falso', 1, '2015-01-15', NULL, 1100, 10, 230, 10, 10, 5, 10, 10),
(166, 131, 'Pablo Villa Cruz', 'Trasero', 'Encuarte trasero', 1, '2015-01-15', NULL, 1500, 1800, 2731, 1928, 2750, 1430, 2064, 848),
(167, 557, 'Cirilo Garcia Lopez', 'Ensamble', 'Pegar pretina/pretinar', 1, '2015-01-16', NULL, 1600, 600, 0, 0, 0, 0, 0, 0),
(168, 554, 'Michel Rojas Perez', 'Trasero', 'Bloquear pza. altura', 1, '2015-01-16', NULL, 800, 3000, 2410, 2105, 0, 1430, 0, 0),
(169, 329, 'Elizabeth', 'Especial', 'Confianza/Secretaria', 1, '2015-01-16', NULL, 1100, 10, 0, 0, 0, 0, 0, 0),
(170, 146, 'Saturnino de Jesus', 'Ensamble', 'Presillar delantero', 1, '2015-01-21', NULL, 950, 4000, 960, 1269, 0, 0, 0, 0),
(171, 75, 'Francisco Javier Ramirez Villafan', 'Ensamble', 'Pegar etiqueta patch(BASS)', 1, '2015-01-21', NULL, 1200, 2500, 1800, 2000, 2500, 900, 2965, 0),
(172, 503, 'Nayeli Flores Rosete', 'Especial', 'Manual', 1, '2015-01-21', NULL, 750, 3000, 270, 495, 600, 1500, 3000, 3000),
(173, 138, 'Sofia Irene Cortes Morales', 'Especial', 'Manual', 1, '2015-01-21', NULL, 750, 10, 10, 10, 10, 5, 10, 10),
(174, 135, 'Jorge Carrera Merino', 'Ensamble', 'Empaque', 1, '2015-01-22', NULL, 1100, 10, 10, 10, 10, 5, 10, 10),
(175, 125, 'Miguel Antonio Martinez Olmos', 'Ensamble', 'Refilar valencianas/bajos', 1, '2015-01-22', NULL, 800, 2200, 1440, 1519, 880, 770, 1980, 1900),
(176, 127, 'Julio Cesar Guerra Gomez', 'Ensamble', 'Pegar traba', 1, '2015-01-22', NULL, 1100, 750, 0, 0, 0, 0, 0, 0),
(177, 105, 'Trinidad Garcia Costo', 'Delantero', 'Pegar cierre', 1, '2015-01-22', NULL, 1000, 3500, 3360, 2595, 3740, 1650, 3000, 2250),
(178, 113, 'Adriana Rodriguez', 'Delantero', 'Pegar manta/bolsa', 1, '2015-01-22', NULL, 1100, 1300, 960, 964, 760, 550, 1100, 820),
(179, 142, 'Miguel Angel Garcia Lopez', 'Delantero', 'Pegar vista (SN)', 1, '2015-01-22', NULL, 1000, 1500, 720, 725, 908, 350, 779, 767),
(180, 323, 'Arturo Martinez Barbosa', 'Delantero', 'Deslizador y grapa', 1, '2015-01-22', NULL, 950, 1500, 2640, 1800, 2000, 1100, 1760, 1510),
(181, 175, 'Agustin Olivares Galvez', 'Especial', 'Bultero', 1, '2015-01-28', NULL, 700, 10, 0, 0, 0, 0, 10, 0),
(182, 147, 'Daniel Luna', 'Trasero', 'Presillar bolsa trasera', 1, '2015-01-28', NULL, 950, 2000, 836, 1036, 1519, 763, 1329, 1724),
(183, 178, 'Miguel A Dorantes Cortez', 'Delantero', 'Pegar secreta', 1, '2015-01-28', NULL, 1200, 1350, 0, 0, 0, 0, 780, 0),
(184, 176, 'Israel Rosete Morales', 'Delantero', 'Cerrar falso', 1, '2015-01-28', NULL, 950, 6000, 0, 0, 0, 0, 1980, 9270),
(185, 156, 'Joaquin Cuenca Bernabe', 'Delantero', 'Pegar falso', 1, '2015-01-28', NULL, 1100, 1650, 1450, 1560, 1500, 880, 1760, 1020),
(186, 151, 'Alberto Montez Olvera', 'Ensamble', 'Sobrecoser costados', 1, '2015-01-28', NULL, 1100, 1200, 1004, 1025, 986, 510, 445, 1069);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas_maq`
--

CREATE TABLE `marcas_maq` (
  `id_marca` int(10) NOT NULL,
  `nombre_marca` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nombres_almacen`
--

CREATE TABLE `nombres_almacen` (
  `id_almacen` int(10) NOT NULL,
  `nombre_almacen` varchar(200) NOT NULL,
  `tipo` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `nombres_almacen`
--

INSERT INTO `nombres_almacen` (`id_almacen`, `nombre_almacen`, `tipo`) VALUES
(2, 'Almacen Gral. McApparel', '2'),
(3, 'Almacen 2 McApparel', '7'),
(4, 'Administrador', '2'),
(5, 'Superusuario', '2'),
(6, 'Almacen Gral. McApparel', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `op_delantero`
--

CREATE TABLE `op_delantero` (
  `id_opDel` int(5) NOT NULL,
  `nombre_op` varchar(100) NOT NULL,
  `tarea` smallint(10) NOT NULL,
  `sueldo_base` smallint(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `op_delantero`
--

INSERT INTO `op_delantero` (`id_opDel`, `nombre_op`, `tarea`, `sueldo_base`) VALUES
(1, 'Pegar cierre', 3500, 1000),
(2, 'Sobrehilar ojalera ', 6000, 950),
(3, 'Cerrar falso', 6000, 950),
(4, 'Pegar ojalera (boquilla)', 2000, 1200),
(5, 'Dise?o de ojalera', 2000, 1200),
(6, 'Pegar falso', 1650, 1100),
(7, 'Sobrecoser delantero', 1300, 1200),
(8, 'Marcar vistas (8 marcas)', 1600, 700),
(9, 'Bastillar secreta', 6000, 1200),
(10, 'Pegar secreta', 1350, 1200),
(11, 'Refilar vista', 6000, 950),
(12, 'Pegar vista (cover stich)', 2200, 1200),
(13, 'Pegar vista (SN)', 1500, 1000),
(14, 'Pegar manta/bolsa', 1300, 1100),
(15, 'Fijar delantero', 1000, 1000),
(16, 'Presillar ojalera', 4500, 950),
(18, 'Deslizador y grapa', 1500, 950),
(22, 'Presillar secreta', 4000, 950);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `op_ensamble`
--

CREATE TABLE `op_ensamble` (
  `id_opEns` int(5) NOT NULL,
  `nombre_op` varchar(100) NOT NULL,
  `tarea` int(10) NOT NULL,
  `sueldo_base` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `op_ensamble`
--

INSERT INTO `op_ensamble` (`id_opEns`, `nombre_op`, `tarea`, `sueldo_base`) VALUES
(33, 'Hacer pares', 1500, 750),
(34, 'Cerrar costados', 1200, 1300),
(35, 'Sobrecoser costados', 1200, 1100),
(36, 'Pegar etiqueta pretina', 1500, 1100),
(37, 'Voltear pantalon', 3000, 600),
(38, 'Pegar pretina/pretinar', 750, 1600),
(39, 'Hacer cuadro', 1600, 1200),
(40, 'Refilar encuartes', 1700, 1000),
(41, 'Engargolar entrepierna', 1100, 1600),
(42, 'Hacer valenciana', 1000, 1200),
(43, 'Pegar traba', 750, 1100),
(44, 'Hacer ojal', 4000, 1000),
(45, 'Revisado final', 600, 900),
(46, 'Pegar etiqueta patch(SN)', 1200, 1050),
(47, 'Pegar etiqueta patch(BASS)', 2500, 1200),
(48, 'Cerrar Bolsa', 1800, 1100),
(49, 'Fijar bolsa', 1000, 1000),
(50, 'Deslizador y grapa', 1500, 950),
(51, 'Encuarte delantero', 1500, 1200),
(52, 'Pegar talla', 2000, 850),
(53, 'Presillar delantero', 4000, 950),
(54, 'Presillar secreta', 4000, 950),
(55, 'Refilar valencianas/bajos', 2200, 800),
(57, 'Sobrecoser bolsa', 1300, 1200),
(59, 'Revisar pretina', 750, 700),
(60, 'Meter pretina', 3000, 700),
(61, 'Refilar delantero x trasero', 3000, 1100),
(62, 'Piquete trasero', 3000, 750),
(63, 'Revisar entrepierna', 1100, 700),
(64, 'Pespunte de costado', 1200, 1100),
(65, 'Deshebrado', 400, 600),
(66, 'Sobrecoser falso', 1500, 1100),
(67, 'Empaque', 100, 1100),
(68, 'Refilar entrepierna', 3000, 1100),
(70, 'Hacer traba', 2000, 1100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `op_especial`
--

CREATE TABLE `op_especial` (
  `id_opEsp` int(11) NOT NULL,
  `nombre_op` varchar(100) NOT NULL,
  `tarea` int(10) NOT NULL,
  `sueldo_base` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `op_especial`
--

INSERT INTO `op_especial` (`id_opEsp`, `nombre_op`, `tarea`, `sueldo_base`) VALUES
(1, 'Comodin', 0, 0),
(2, 'Manual', 3000, 750),
(3, 'Confianza/Secretaria', 0, 0),
(4, 'Bultero', 100, 700);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `op_trasero`
--

CREATE TABLE `op_trasero` (
  `id_opTra` int(5) NOT NULL,
  `nombre_op` varchar(100) NOT NULL,
  `tarea` int(10) NOT NULL,
  `sueldo_base` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `op_trasero`
--

INSERT INTO `op_trasero` (`id_opTra`, `nombre_op`, `tarea`, `sueldo_base`) VALUES
(21, 'Revisar encuarte trasero', 2500, 750),
(23, 'Bastillar bolsa trasera', 4000, 1200),
(24, 'Planchar bolsa', 1000, 900),
(25, 'Bloquear pza. altura', 3000, 800),
(26, 'Pegar pza. altura', 1800, 1500),
(27, 'Encuarte trasero', 1800, 1500),
(28, 'Pegar bolsa trasera(1 aguja)', 750, 1200),
(29, 'Pegar bolsa trasera(2 agujas)', 650, 1200),
(30, 'Segunda bolsa trasera', 800, 950),
(31, 'Marcar a plomos', 1500, 700),
(32, 'Presillar bolsa trasera', 2000, 950),
(69, 'Recoger pieza altura', 2000, 600);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores_maq`
--

CREATE TABLE `proveedores_maq` (
  `id_prov` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre_prov` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_admin`
--

CREATE TABLE `tipos_admin` (
  `id_tipo` int(11) NOT NULL,
  `tipo_admin` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipos_admin`
--

INSERT INTO `tipos_admin` (`id_tipo`, `tipo_admin`) VALUES
(1, 'Superusuario'),
(2, 'Almacen General'),
(3, 'Administrador'),
(4, 'Capturista'),
(5, 'Inventarios'),
(6, 'Almacenista');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_maquina`
--

CREATE TABLE `tipos_maquina` (
  `id_tipo` int(10) NOT NULL,
  `nombre_tipo` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id_adm`);

--
-- Indices de la tabla `almacen_reportes`
--
ALTER TABLE `almacen_reportes`
  ADD KEY `corte` (`corte`) COMMENT 'indice';

--
-- Indices de la tabla `almacen_stock`
--
ALTER TABLE `almacen_stock`
  ADD KEY `indice` (`corte`);

--
-- Indices de la tabla `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id_area`);

--
-- Indices de la tabla `cortes`
--
ALTER TABLE `cortes`
  ADD PRIMARY KEY (`id_corte`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `marcas_maq`
--
ALTER TABLE `marcas_maq`
  ADD PRIMARY KEY (`id_marca`);

--
-- Indices de la tabla `nombres_almacen`
--
ALTER TABLE `nombres_almacen`
  ADD PRIMARY KEY (`id_almacen`);

--
-- Indices de la tabla `op_delantero`
--
ALTER TABLE `op_delantero`
  ADD PRIMARY KEY (`id_opDel`);

--
-- Indices de la tabla `op_ensamble`
--
ALTER TABLE `op_ensamble`
  ADD PRIMARY KEY (`id_opEns`);

--
-- Indices de la tabla `op_especial`
--
ALTER TABLE `op_especial`
  ADD PRIMARY KEY (`id_opEsp`);

--
-- Indices de la tabla `op_trasero`
--
ALTER TABLE `op_trasero`
  ADD PRIMARY KEY (`id_opTra`);

--
-- Indices de la tabla `proveedores_maq`
--
ALTER TABLE `proveedores_maq`
  ADD PRIMARY KEY (`id_prov`);

--
-- Indices de la tabla `tipos_admin`
--
ALTER TABLE `tipos_admin`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indices de la tabla `tipos_maquina`
--
ALTER TABLE `tipos_maquina`
  ADD PRIMARY KEY (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id_adm` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `area`
--
ALTER TABLE `area`
  MODIFY `id_area` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleado` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=187;
--
-- AUTO_INCREMENT de la tabla `marcas_maq`
--
ALTER TABLE `marcas_maq`
  MODIFY `id_marca` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `nombres_almacen`
--
ALTER TABLE `nombres_almacen`
  MODIFY `id_almacen` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `op_delantero`
--
ALTER TABLE `op_delantero`
  MODIFY `id_opDel` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT de la tabla `op_ensamble`
--
ALTER TABLE `op_ensamble`
  MODIFY `id_opEns` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=71;
--
-- AUTO_INCREMENT de la tabla `op_especial`
--
ALTER TABLE `op_especial`
  MODIFY `id_opEsp` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `op_trasero`
--
ALTER TABLE `op_trasero`
  MODIFY `id_opTra` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=70;
--
-- AUTO_INCREMENT de la tabla `tipos_admin`
--
ALTER TABLE `tipos_admin`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `tipos_maquina`
--
ALTER TABLE `tipos_maquina`
  MODIFY `id_tipo` int(10) NOT NULL AUTO_INCREMENT;