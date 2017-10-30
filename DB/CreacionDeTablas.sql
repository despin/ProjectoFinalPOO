DROP DATABASE IF EXISTS supermercado;
CREATE DATABASE supermercado;
USE supermercado;

CREATE TABLE Empleado(
    codEmpleado 	VARCHAR(6) NOT NULL,
    nombre 			NVARCHAR(20),
    apellido 		NVARCHAR(20),
    fechaIngreso 	DATE,
    PRIMARY KEY (`codEmpleado`)
);

DROP TABLE Producto;
CREATE TABLE Producto(
    codigoBarras	VARCHAR(6) NOT NULL,
    nombre 			NVARCHAR(30),
    precio_Unitario INT,
    PRIMARY KEY (`codigoBarras`)
);

CREATE TABLE Descuento(
    id_descuento	INT AUTO_INCREMENT PRIMARY KEY,
    nombre 			NVARCHAR(20),
    porcentaje 		INT,
    PRIMARY KEY (`id_descuento`)
);

CREATE TABLE Venta(
    id_Venta 		INT AUTO_INCREMENT PRIMARY KEY,
    cajero 			VARCHAR(6) NOT NULL,
    fechaVenta 		DATETIME,
    precioTotal 	INT
    PRIMARY KEY (`id_Venta`),
    CONSTRAINT `fk_Venta_cajero`
        FOREIGN KEY (`cajero`)
        REFERENCES `supermercado`.`Empleado` (`codEmpleado`)
);

CREATE TABLE ItemProducto(
    id_Registro 	INT AUTO_INCREMENT PRIMARY KEY,
    id_Venta 		INT NOT NULL,
    codProducto 	INT NOT NULL,
    cantidad 		INT,
    precio 			INT,
    PRIMARY KEY (`id_Registro`),
    CONSTRAINT `fk_ItemProducto_venta`
        FOREIGN KEY (`id_Venta`)
        REFERENCES `supermercado`.`Venta` (`id_Venta`),
    CONSTRAINT `fk_ItemProducto_producto`
        FOREIGN KEY (`codProducto`)
        REFERENCES `supermercado`.`Producto` (`codigoBarras`)
);

CREATE TABLE ProductosConDescuento (
    id_producto 	INT NOT NULL,
    id_descuento 	INT NOT NULL,
    CONSTRAINT `fk_ProductosConDescuento_producto`
        FOREIGN KEY (`id_producto`)
        REFERENCES `supermercado`.`Producto` (`codigoBarras`),
    CONSTRAINT `fk_ProductosConDescuento_descuento`
        FOREIGN KEY (`id_descuento`)
        REFERENCES `supermercado`.`Descuento` (`id_descuento`)
);