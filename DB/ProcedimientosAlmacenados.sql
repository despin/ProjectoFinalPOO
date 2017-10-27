/** PRODUCTO **/

DROP PROCEDURE IF EXISTS pa_producto;
DELIMITER $$
CREATE PROCEDURE pa_producto (IN _codigoBarras INT)
BEGIN
SELECT * FROM  Producto
WHERE codigoBarras = codigoBarras;
END $$
DELIMITER ;

/** VENTA **/

DROP PROCEDURE IF EXISTS pa_venta;
DELIMITER $$
CREATE PROCEDURE pa_venta (IN _id_venta INT)
BEGIN
SELECT * FROM  Venta
WHERE id_venta = id_venta;
END $$
DELIMITER ;
USE SuperMercado;
/** DESCUENTO **/

DROP PROCEDURE IF EXISTS pa_descuento;
DELIMITER $$
CREATE PROCEDURE pa_descuento (IN _id_descuento INT)
BEGIN
SELECT * FROM  Descuento
WHERE id_descuento = id_descuento;
END $$
DELIMITER ;

/** EMPLEADO **/

DROP PROCEDURE IF EXISTS pa_empleado;
DELIMITER $$
CREATE PROCEDURE pa_empleado (IN _codEmpleado varchar(6))
BEGIN
SELECT * FROM  Empleado
WHERE _codEmpleado = ID_Empleado;
END $$
DELIMITER ;

CALL pa_empleado("000012");
# devuelve un registro