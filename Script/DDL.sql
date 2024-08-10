-- database: :memory:
-- Tabla Persona
CREATE TABLE Persona (
    ID_Persona INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Direccion VARCHAR(100),
    Telefono VARCHAR(15),
    Email VARCHAR(50)
);

-- Tabla Cajero
CREATE TABLE Cajero (
    ID_Cajero INT PRIMARY KEY,
    Turno VARCHAR(20),
    Fecha_Contratacion DATE,
    FOREIGN KEY (ID_Cajero) REFERENCES Persona(ID_Persona)
);

-- Tabla Cliente
CREATE TABLE Cliente (
    ID_Cliente INT PRIMARY KEY,
    Fecha_Registro DATE,
    Puntos_Fidelidad INT DEFAULT 0,
    FOREIGN KEY (ID_Cliente) REFERENCES Persona(ID_Persona)
);

-- Tabla Libro
CREATE TABLE Libro (
    ISBN VARCHAR(13) PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    editorial VARCHAR(50),
    anioPublicacion INT,
    precioVenta DECIMAL(10, 2),
    precioCompra DECIMAL(10, 2),
    codigoBarra VARCHAR(20) UNIQUE,
    nroUnidades INT
);

-- Tabla Venta
CREATE TABLE Venta (
    ID_Venta INT PRIMARY KEY AUTO_INCREMENT,
    ID_Cajero INT,
    ID_Cliente INT,
    Fecha_Venta DATETIME,
    Total DECIMAL(10, 2),
    FOREIGN KEY (ID_Cajero) REFERENCES Cajero(ID_Cajero),
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente)
);

-- Tabla Detalle_Venta
CREATE TABLE Detalle_Venta (
    ID_Detalle_Venta INT PRIMARY KEY AUTO_INCREMENT,
    ID_Venta INT,
    ISBN VARCHAR(13),
    Cantidad INT,
    Precio_Unitario DECIMAL(10, 2),
    Subtotal DECIMAL(10, 2),
    FOREIGN KEY (ID_Venta) REFERENCES Venta(ID_Venta),
    FOREIGN KEY (ISBN) REFERENCES Libro(ISBN)
);

-- Tabla Sistema
CREATE TABLE Sistema (
    ID_Sistema INT PRIMARY KEY AUTO_INCREMENT,
    Version VARCHAR(20),
    Fecha_Ultima_Actualizacion DATE
);