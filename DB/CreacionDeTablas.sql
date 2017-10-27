DROP DATABASE IF EXISTS SuperMercado;
CREATE DATABASE SuperMercado;
USE SuperMercado;

CREATE TABLE Empleado(
ID_Empleado INT AUTO_INCREMENT PRIMARY KEY,
Nombre NVARCHAR(15),
Apellido NVARCHAR(15),
Fecha_De_Ingreso_A_La_Empresa DATE);

CREATE TABLE Producto(
Codigo_De_Barras INT NOT NULL PRIMARY KEY,
Nombre NVARCHAR(15),
Precio_Unitario INT);

CREATE TABLE Descuento(
ID_Producto INT AUTO_INCREMENT PRIMARY KEY,
Porcentaje INT,
ID_Descuento INT);

CREATE TABLE Venta(
ID_Venta INT AUTO_INCREMENT PRIMARY KEY,
Cajero_Responsable INT NOT NULL,
Fecha_Venta DATE,
Precio_Total INT);

CREATE TABLE ItemProducto(
ID_Registro INT AUTO_INCREMENT PRIMARY KEY,
CodProducto INT NOT NULL,
Precio INT,
Cantidad INT);

/* VALUES !! */
INSERT INTO `Empleado` (`ID_Empleado`,`Nombre`,`Apellido`,`Fecha_De_Ingreso_A_La_Empresa`) VALUES 
("25849","Pedro","Calogero","2013-12-24 22:50:52"),
("09724","Cristian","Aquino","2014-07-09 09:39:18"),
("21966","Matias","Quimey","2015-09-06 15:52:13"),
("34197","Tomas","Virgo","2014-11-16 20:07:26"),
("28353","Leandro","Tato","2010-12-29 21:41:13"),
("23851","Franco","Casco","2012-12-11 05:05:00"),
("23362","Nicolas","Ravier","2011-04-25 20:40:14"),
("41234","Tomas","Montaño","2009-03-01 14:57:33"),
("70226","Fabricio","Toscano","2005-09-07 17:25:19"),
("85212","Daniel","Alfonso","2016-04-10 19:51:10");


INSERT INTO `Producto` (`Codigo_De_Barras`,`Nombre`,`Precio_Unitario`) VALUES 
("18557","Cerveza",50),
("39278","Galletitas",20),
("64529","Carne",120),
("46722","Aceite",60),
("03942","Jabon",30),
("36757","Pescado",150),
("18784","Verduras",40),
("08885","Papas Fritas",50),
("33619","Mayonesa",30),
("14817","Pochoclos",35);


INSERT INTO `Venta` (`ID_Venta`,`Cajero_Responsable`,`Fecha_Venta`,`Precio_Total`) VALUES 
("93197","27109","2017-09-20 09:16:34",65),
("16282","21658","2017-07-23 21:03:14",108),
("07354","34381","2017-09-24 08:11:29",51),
("36964","21881","2017-08-19 08:51:26",34),
("15500","96191","2017-07-25 20:34:03",149),
("91559","53812","2017-02-22 18:10:35",43),
("40232","73852","2017-03-30 23:34:12",84),
("56613","20134","2017-03-07 03:17:11",53),
("88599","15381","2017-02-09 13:49:08",48),
("52805","05266","2017-04-01 16:40:09",42);


INSERT INTO `Venta` (`ID_Descuento`,`Nombre`,`Porcentaje`) VALUES 
("19623","Navidad",20),
("87888","Año nuevo",20),
("34303","Pascuas",15),
("26597","Dia de la Madre",25),
("44492","Invierno",10),
("20378","Dia de la Primavera",15),
("73637","Cumpleaños del supermercado",25),
("88666","Dia del niño",15),
("08506","Miercoles",20),
("28727","Domingos",15);

