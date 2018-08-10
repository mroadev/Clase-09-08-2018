-- ***********************************************************************************
-- Ejemplo Mysql con Java
-- ***********************************************************************************

-- Crear la base de datos
DROP DATABASE `ventas`;
CREATE SCHEMA `ventas` DEFAULT CHARACTER SET utf8 ;
USE ventas;

-- Crear usuario base de datos
DROP USER 'usuventas'@'localhost';
CREATE USER 'usuventas'@'localhost' IDENTIFIED BY 'passventas';

-- Dar privilegios
grant usage on *.* to usuventas@localhost identified by 'passventas';
grant all privileges on ventas.* to usuventas@localhost;

-- Crear tabla usuario
DROP TABLE usuario;
CREATE TABLE usuario(
	idusuario INT NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(50),
    clave VARCHAR(50),
    nombre VARCHAR(100),
    tipousuario VARCHAR(50),
    estado VARCHAR(1),
    PRIMARY KEY (idusuario)
);

-- insertar datos
INSERT INTO usuario (usuario, clave, nombre, tipousuario, estado) values
('admin','1234','Administrador','Alvaro Fuentes','V');

-- Permitir mysql operaciones update
SET SQL_SAFE_UPDATES = 0;
-- ***********************************************************************************
create table cliente(
	codcliente int NOT NULL AUTO_INCREMENT,
    nombrecliente varchar(100),
    tipocliente varchar(10),
    primary key(codcliente)
);
insert into cliente (nombrecliente, tipocliente)
values ('Alvaro Fuentes','vip');
insert into cliente (nombrecliente, tipocliente)
values ('Carla Gonzalez','normal');

create table producto(
	codproducto int NOT NULL AUTO_INCREMENT,
    producto varchar(100),
    precio int(9),
    stock int,
    primary key (codproducto)
);
insert into producto (producto, precio, stock)
values ('Escritorio',150000, 100);
insert into producto (producto, precio, stock)
values ('Silla',55000, 50);

create table venta(
	numdocumento int NOT NULL AUTO_INCREMENT,
    fechadocumento date,
    cantidad int,
    codproducto int,
    codcliente int,
	totalventa int(9),
    primary key (numdocumento)
);

-- Establecer relaciones entre las tablas

alter table venta add foreign key(codproducto) references producto(codproducto);
alter table venta add foreign key(codcliente) references cliente(codcliente);













