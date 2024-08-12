-- database: ../Database/BDLibreria.sqlite

INSERT INTO EntidadTipo
 (Nombre) VALUES
 ('Cajero')
,('Cliente')
,('Proveedor');

INSERT INTO Proveedor
(ID_EntidadTipo,Nombre) VALUES
(3,'ProveedorX');

INSERT INTO Cajero
(ID_EntidadTipo, Usuario, Contrasena) VALUES
(1,'UserX','PasswordX');

INSERT INTO Libro
(ID_Proveedor,titulo,autor,genero,editorial,anioPublicacion,precioVenta,precioCompra,codigoBarra,nroUnidades) VALUES
(1,'LibroX','AutorX','GeneroX','EditorialX','2020',100.32,53.12,'125172231',10);


INSERT INTO Libro
(ID_Proveedor,titulo,autor,genero,editorial,anioPublicacion,precioVenta,precioCompra,codigoBarra,nroUnidades) VALUES
(1,'LibroY','AutorY','GeneroY','EditorialY','2020',12.253,123.12,'12514121',5);