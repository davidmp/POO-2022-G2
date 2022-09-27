
CREATE TABLE usuario (
                id_usuario INTEGER NOT NULL,
                user VARCHAR(20) NOT NULL,
                clave VARCHAR(60) NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (id_usuario AUTOINCREMENT)  
);


CREATE TABLE cliente (
                dniruc VARCHAR(12) NOT NULL,
                nombrers VARCHAR(60) NOT NULL,
                tipo VARCHAR(12) NOT NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (dniruc)
);


CREATE TABLE venta (
                id_venta INTEGER NOT NULL,
                preciobase DOUBLE NOT NULL,
                igv DOUBLE NOT NULL,
                preciototal DOUBLE NOT NULL,
                dniruc VARCHAR(12) NOT NULL,
                CONSTRAINT venta_pk PRIMARY KEY (id_venta AUTOINCREMENT),
				FOREIGN KEY("dniruc") REFERENCES "cliente"("dniruc") ON UPDATE RESTRICT ON DELETE RESTRICT
);


CREATE TABLE marca (
                id_marca INTEGER NOT NULL,
                nombre VARCHAR(20) NOT NULL,
                CONSTRAINT marca_pk PRIMARY KEY (id_marca AUTOINCREMENT)  
);


CREATE TABLE categoria (
                id_categoria INTEGER NOT NULL,
                nombre VARCHAR(20) NOT NULL,
                CONSTRAINT categoria_pk PRIMARY KEY (id_categoria AUTOINCREMENT) 
);


CREATE TABLE producto (
                id_producto INTEGER NOT NULL,
                nombre VARCHAR(20) NOT NULL,
                pu DOUBLE NOT NULL,
                utilidad DOUBLE NOT NULL,
                stock DOUBLE NOT NULL,
                id_categoria INTEGER NOT NULL,
                id_marca INTEGER NOT NULL,
                CONSTRAINT producto_pk PRIMARY KEY (id_producto AUTOINCREMENT),
				FOREIGN KEY (id_marca) REFERENCES marca (id_marca) ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE,
				FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria) ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE
);


CREATE TABLE venta_detalle (
                id_venta_detalle INTEGER NOT NULL,
                pu DOUBLE NOT NULL,
                cantidad DOUBLE NOT NULL,
                descuento DOUBLE NOT NULL,
                subtotal DOUBLE NOT NULL,
                id_venta INTEGER NOT NULL,
                id_producto INTEGER NOT NULL,
                CONSTRAINT venta_detalle_pk PRIMARY KEY (id_venta_detalle AUTOINCREMENT),
				FOREIGN KEY (id_venta) REFERENCES venta (id_venta) ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE,
				FOREIGN KEY (id_producto) REFERENCES producto (id_producto) ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE
);
