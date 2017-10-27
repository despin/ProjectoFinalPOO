DROP DATABASE IF EXISTS supermercado;
CREATE DATABASE supermercado;
USE supermercado;

CREATE TABLE Empleado(
codEmpleado 	VARCHAR(6) NOT NULL PRIMARY KEY,
nombre 			NVARCHAR(20),
apellido 		NVARCHAR(20),
fechaIngreso 	DATE);

CREATE TABLE Producto(
codigoBarras	INT NOT NULL PRIMARY KEY,
nombre 			NVARCHAR(30),
precio_Unitario INT);

CREATE TABLE Descuento(
id_descuento	INT AUTO_INCREMENT PRIMARY KEY,
nombre 			NVARCHAR(20),
porcentaje 		INT);

CREATE TABLE Venta(
id_Venta 		INT AUTO_INCREMENT PRIMARY KEY,
cajero 			VARCHAR(6) NOT NULL,
fechaVenta 		DATETIME,
precioTotal 	INT);

CREATE TABLE ItemProducto(
id_Registro 	INT AUTO_INCREMENT PRIMARY KEY,
id_Venta 		INT NOT NULL,
codProducto 	INT NOT NULL,
cantidad 		INT,
precio 			INT);

CREATE TABLE ProductosConDescuento (
id_producto 	INT NOT NULL,
id_descuento 	INT NOT NULL
);

/* VALUES !! */