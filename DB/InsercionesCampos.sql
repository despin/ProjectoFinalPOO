
INSERT INTO `Empleado` (`ID_Empleado`,`Nombre`,`Apellido`,`Fecha_De_Ingreso_A_La_Empresa`) VALUES 
("00003D","Pedro","Calogero",'2013-12-24'),
("00004F","Cristian","Aquino",'2014-07-09'),
("00002A","Matias","Quimey",'2015-09-06'),
("000012","Tomas","Virgo",'2014-11-16'),
("00004E","Leandro","Tato",'2010-12-29'),
("00006D","Franco","Casco",'2012-12-11'),
("00002B","Nicolas","Ravier",'2011-04-25');

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


INSERT INTO `Venta` (`Cajero_Responsable`,`Fecha_Venta`,`Precio_Total`) VALUES 
("27109",'2017-09-20 09:16:14',65),
("21658",'2017-07-23 21:03:14',108),
("34381",'2017-09-24 08:11:29',51),
("21881",'2017-08-19 08:51:26',34),
("96191",'2017-07-25 20:34:03',149),
("53812",'2017-02-22 18:10:35',43),
("73852",'2017-03-30 23:34:12',84),
("20134",'2017-03-07 03:17:11',53),
("15381",'2017-02-09 13:49:08',48),
("05266",'2017-04-01 16:40:09',42);


INSERT INTO `Descuento` (`Nombre`,`Porcentaje`) VALUES 
("Navidad",20),
("Año nuevo",20),
("Pascuas",15),
("Dia de la Madre",25),
("Invierno",10),
("Dia de la Primavera",15),
("Cumpleaños",25),
("Dia del niño",15),
("Miercoles",20),
("Domingos",15);

