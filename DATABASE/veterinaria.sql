-- -----------------------------------------------------
-- Schema VETERINARIA
-- -----------------------------------------------------
CREATE DATABASE VETERINARIA;
USE VETERINARIA;

-- -----------------------------------------------------
-- Table DUEÑO
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS DUEÑO (
  `idpropietario` INT(11) NOT NULL,
  `tipoid` VARCHAR(45),
  `nombre` VARCHAR(45),
  `ciudad` VARCHAR(45),
  `direccion` VARCHAR(45),
  `telefono` VARCHAR(45),
  PRIMARY KEY (`idpropietario`));

-- -----------------------------------------------------
-- Table MASCOTA
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS MASCOTA (
  `idmascota` INT(11) NOT NULL,
  `nombre` VARCHAR(45),
  `especie` VARCHAR(45),
  `raza` VARCHAR(45),
  `fechanacimiento` DATE,
  `id_propietario` INT(11),
  `fecharegistro` DATE,
  PRIMARY KEY (`idmascota`),
  CONSTRAINT `id_propietario` FOREIGN KEY (`id_propietario`) REFERENCES `veterinaria`.`dueño` (`idpropietario`));

-- -----------------------------------------------------
-- INSERCION DE DATOS 
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table DUEÑO
-- -----------------------------------------------------
INSERT INTO DUEÑO (idpropietario, tipoid, nombre, ciudad, direccion, telefono)
VALUES
(1002542221, "C.C", "CARLOS RUIZ", "Zipaquirá", "Carrera 8A 33-65", "3167106030"),
(1002543541, "C.C", "LUIS DIAZ", "Bogotá", "Carrera 11 40-55", "3208106037"),
(1002547372, "C.C", "ALEJANDRO SERRANO", "Soacha", "Carrera 20B 10-5", "3139107037"),
(1002547648, "C.C", "MIGUEL HERNANDEZ", "Girardot", "Carrera 10 20-15", "3167106033"),
(1002567058, "C.C", "JAVIER MUÑOZ", "Guaduas", "Carrera 11 40-12", "3167106034"),
(123456, "C.E", "CRISTINA SAEZ", "Anapoima", "Carrera 33 23-14", "3158756031"),
(289663, "C.E", "LAURA ROMERO", "Anolaima", "Carrera 11B 13-14", "3165108017"),
(490583, "C.E", "JOSE RUBIO", "Chocontá", "Carrera 11A 3-5", "3165109077"),
(874569, "C.E", "JUANA ALFARO", "Villapinzón", "Carrera 7C 9-65", "3138100030"),
(369852, "C.E", "TERESA MOLINA", "La Calera", "Carrera 1 21-7", "3157106000"),
(12345678, "PASAPORTE", "ROSARIO LOZANO", "Cáqueza", "Carrera 2A 7-65", "3157100080"),
(78945612, "PASAPORTE", "ELENA CASTILLO", "Fusagasugá", "Carrera 6 8-5", "3178100007"),
(96325874, "PASAPORTE", "MANUELA ORTEGA", "Pacho", "Carrera 9-65", "3138103033"),
(35789519, "PASAPORTE", "RAQUEL TORRES", "Villeta", "Carrera 10 23-10", "3177106637"),
(13497856, "PASAPORTE", "ANTONIO GARCIA", "Sesquilé", "Calle 10 # 5-51", "3200045011");

-- -----------------------------------------------------
-- Table MASCOTA
-- -----------------------------------------------------
INSERT INTO MASCOTA (idmascota, nombre, especie, raza, fechanacimiento, id_propietario, fecharegistro)
VALUES
(1, "Luna", "Perro", "Labrador ", '2013-5-14', 1002542221, '2020-1-1'),
(2, "Maya", "Perro", "Bulldog ", '2014-2-20', 1002543541, '2020-2-2'),
(3, "Bruno", "Perro", "Golden ", '2015-3-3', 1002547372, '2020-3-2'),
(4, "Max", "Perro", "Caniche", '2013-2-12', 1002547648, '2020-4-4'),
(5, "Jack", "Perro", "Pastor alemán", '2013-3-13', 1002567058, '2020-5-5'),
(6, "Lucas", "Perro", "Rottweiler", '2014-3-15', 123456, '2020-6-6'),
(7, "Toby", "Perro", "Beagle", '2015-10-17', 289663, '2021-7-7'),
(8, "Rocky", "Perro", "Dachshund", '2016-8-8', 490583, '2021-8-8'),
(9, "Zeus", "Gato", "Persa", '2016-12-4', 874569, '2021-9-9'),
(10, "Charlie", "Gato", "Azul ruso", '2018-11-13', 369852, '2021-10-10'),
(11, "Leo", "Gato", "Siamés", '2019-9-11', 12345678, '2021-11-11'),
(12, "Sam", "Gato", "Angora", '2020-4-5', 78945612, '2021-12-12'),
(13, "Frank", "Gato", "Siberiano", '2019-7-6', 96325874, '2022-1-11'),
(14, "Romeo", "Gato", "Maine Coon", '2021-10-19', 35789519, '2022-2-22'),
(15, "Tom", "Gato", "Bengalí", '2022-1-7', 13497856, '2022-3-29');




