-- database: ../Database/BDLibreria.sqlite

INSERT INTO EntidadTipo
 (Nombre) VALUES
 ('Cajero')
,('Cliente')
,('Proveedor');

INSERT INTO Persona
 (ID_EntidadTipo,Nombre,Apellido,Direccion,Telefono,Email) VALUES
 (1,'Juan','Perez','Calle 1 # 1-1','1234567','algo@gmail.com')
,(2,'ClienteX',null,null,null,null);

INSERT INTO Proveedor
(ID_EntidadTipo,Nombre) VALUES
(3,'ProveedorX');

INSERT INTO Libro
(ID_Proveedor,titulo,autor,genero,editorial,anioPublicacion,precioVenta,precioCompra,codigoBarra,nroUnidades,FechaEntrega) VALUES
(1,'LibroX','AutorX','GeneroX','EditorialX','2020',100.32,53.12,'125172231',10,'2020-01-12');