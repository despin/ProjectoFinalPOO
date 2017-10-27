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



