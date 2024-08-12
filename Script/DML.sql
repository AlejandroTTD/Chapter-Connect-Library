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

INSERT INTO Libro
(ID_Proveedor, titulo, autor, genero, editorial, anioPublicacion, precioVenta, precioCompra, codigoBarra, nroUnidades) VALUES
(1, 'LibroA', 'AutorA', 'GeneroA', 'EditorialA', 2018, 18.75, 95.30, '98765432', 8);

INSERT INTO Libro
(ID_Proveedor, titulo, autor, genero, editorial, anioPublicacion, precioVenta, precioCompra, codigoBarra, nroUnidades) VALUES
(1, 'LibroB', 'AutorB', 'GeneroB', 'EditorialB', 2022, 22.99, 110.75, '23456789', 6);

INSERT INTO Libro
(ID_Proveedor, titulo, autor, genero, editorial, anioPublicacion, precioVenta, precioCompra, codigoBarra, nroUnidades) VALUES
(1, 'LibroC', 'AutorC', 'GeneroC', 'EditorialC', 2017, 14.50, 85.20, '34567890', 12);
