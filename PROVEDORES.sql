/*DROP DATABASE proveedores;*/
create database proveedores;
use proveedores;

CREATE TABLE PERSONAS (
    idPersona BIGINT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fechaNacimiento DATE,
    tipoDocumento VARCHAR(2),
    numeroDocumento VARCHAR(15)
);
insert into PERSONAS values(1,'s','d',null,'33','33');

CREATE TABLE FACTURAS (
    idFactura BIGINT PRIMARY KEY,
    fecha DATE,
    idCliente BIGINT, -- FK  CLIENTE_FACTURA
    idVendedor BIGINT, -- FK VENDEDOR_FACTURA
    FOREIGN KEY (idCliente) REFERENCES PERSONAS(idPersona),
    FOREIGN KEY (idVendedor) REFERENCES PERSONAS(idPersona)
);
insert into FACTURAS values(1,null,1,1);

CREATE TABLE PRODUCTOS(
	idProductos BIGINT PRIMARY KEY,
    nombre VARCHAR(100),
    precioUnitario DECIMAL(6,3)
);
insert into PRODUCTOS values(1,null,1);
CREATE TABLE DETALLES(
	idDetalles BIGINT PRIMARY KEY,
    cantidad INT,
    precioVenta DECIMAL(6,3),#EQUIVALENTE A ORACLE DE Number(6,3)
     idFactura BIGINT,
     idProductos BIGINT,
	FOREIGN KEY (idFactura) REFERENCES FACTURAS(idFactura),
    FOREIGN KEY (idProductos) REFERENCES PRODUCTOS(idProductos)
);
insert into DETALLES values(1,1,1,1,1);

CREATE TABLE PROVEEDOR_PRODUCTO(
	idPersona BIGINT,
    idProductos BIGINT,
    PRIMARY KEY(idPersona,idProductos),
    FOREIGN KEY (idPersona) REFERENCES PERSONAS(idPersona),
    FOREIGN KEY (idProductos) REFERENCES PRODUCTOS(idProductos)
);
insert into PROVEEDOR_PRODUCTO values(1,1);
select * from PERSONAS;
select * from FACTURAS;
SET FOREIGN_KEY_CHECKS = 0;

delete from PERSONAS where idPersona > 0;
delete from FACTURAS where idFactura >0;
delete from DETALLES where idDetalles > 0;
delete from PROVEEDOR_PRODUCTO where idPersona > 0;
delete from PRODUCTOS where idProductos > 0;