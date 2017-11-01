USE supermercado;

INSERT Venta (cajero,fechaventa, precioTotal) VALUES ("00003D", '2017-10-10 10:00:32', null);

INSERT ItemProducto VALUES (default, 1, "08885", 2, 100);

INSERT INTO `Empleado` (`codEmpleado`,`nombre`,`apellido`,`fechaIngreso`) VALUES 
("00003D","Pedro","Calogero",'2013-12-24'),
("00004F","Cristian","Aquino",'2014-07-09'),
("00002A","Matias","Quimey",'2015-09-06'),
("000012","Tomas","Virgo",'2014-11-16'),
("00004E","Leandro","Tato",'2010-12-29'),
("00006D","Franco","Casco",'2012-12-11'),
("00002B","Nicolas","Ravier",'2011-04-25');

INSERT INTO `Producto` (`codigoBarras`,`Nombre`,`Precio_Unitario`) VALUES 
("18557","Cerveza Quilmes",50),
("18553","Cerveza Brahma",45),
("12456","CocaCola regular", 20),
("14743","CocaCola Light", 23),
("63567","CocaCola Zero", 25),
("39278","Galletitas",20),
("64529","Carne Asado",120),
("81235","Carne Pechito de Cerdo", 150),
("84521","Carne Pollo", 160),
("46722","Aceite de oliva",60),
("32573","Aceite de girasol", 40),
("56556","Aceite de sesamo", 80),
("03942","Jabon",30),
("36757","Pescado",150),
("18784","Verduras",40),
("08885","Papas Fritas",50),
("33619","Mayonesa",30),
("14817","Pochoclos",35);

INSERT INTO `Descuento` (`Nombre`,`Porcentaje`) VALUES 
("Carnes",10),
("CocaCola",15);

SELECT * FROM Descuento;

INSERT INTO ProductosConDescuento (id_producto, id_descuento) VALUES 
("12456",2),
("14743",2),
("63567",2),
("64529",1),
("81235",1),
("84521",1);

