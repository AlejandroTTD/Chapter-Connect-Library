-- database: ../Database/BDLibreria.sqlite
-- Tabla Persona

DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Cajero;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Libro;
DROP TABLE IF EXISTS Venta;
DROP TABLE IF EXISTS Detalle_Venta;
DROP TABLE IF EXISTS Reembolso;

CREATE TABLE Persona (
     ID_Persona   INTEGER         NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre      VARCHAR(50)      NOT NULL 
    ,Apellido    VARCHAR(50)      NOT NULL
    ,Direccion   VARCHAR(100)    
    ,Telefono    VARCHAR(15)
    ,Email       VARCHAR(50)    
);
-- Tabla Cajero
CREATE TABLE Cajero (
     ID_Cajero      INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre         VARCHAR(10)  NOT NULL
    ,Apellido       VARCHAR(10)  NOT NULL
    ,Usuario        VARCHAR(16)  NOT NULL
    ,Password       VARCHAR(16)  NOT NULL
    ,FOREIGN KEY (ID_Cajero) REFERENCES Persona(ID_Persona)
);

-- Tabla Cliente
CREATE TABLE Cliente (
     ID_Cliente          INTEGER  PRIMARY KEY
    ,Fecha_Registro      DATE
    ,FOREIGN KEY (ID_Cliente) REFERENCES Persona(ID_Persona)
);

-- Tabla Libro
CREATE TABLE Libro (
     titulo              VARCHAR(100) NOT NULL
    ,autor               VARCHAR(100) NOT NULL
    ,genero              VARCHAR(50)  NOT NULL
    ,editorial           VARCHAR(50)  NOT NULL
    ,anioPublicacion     VARCHAR(4)   NOT NULL
    ,precioVenta         FLOAT
    ,precioCompra        FLOAT
    ,codigoBarra         VARCHAR(20) UNIQUE NOT NULL
    ,nroUnidades         INTEGER
);

-- Tabla Venta
CREATE TABLE Venta (
     ID_Venta       INTEGER PRIMARY KEY AUTOINCREMENT
    ,ID_Cajero      INTEGER
    ,ID_Cliente     INTEGER
    ,Fecha_Venta    DATETIME
    ,Total          FLOAT
    ,FOREIGN KEY (ID_Cajero) REFERENCES Cajero(ID_Cajero)
    ,FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente)
);

-- Tabla Detalle_Venta
CREATE TABLE Detalle_Venta (
     ID_Detalle_Venta INTEGER    PRIMARY KEY AUTOINCREMENT
    ,ID_Venta         INTEGER    UNIQUE NOT NULL
    ,Cantidad         INTEGER    NOT NULL
    ,Precio_Unitario  FLOAT      NOT NULL
    ,Subtotal         FLOAT
    ,FOREIGN KEY (ID_Venta) REFERENCES Venta(ID_Venta)
);

CREATE TABLE Reembolso (
    ID_Reembolso    INTEGER PRIMARY KEY AUTOINCREMENT,
    ID_Venta        INTEGER NOT NULL,
    Fecha_Reembolso DATETIME NOT NULL,
    Monto_Reembolso DECIMAL(10,2) NOT NULL,
    Motivo          TEXT,
    FOREIGN KEY (ID_Venta) REFERENCES Venta(ID_Venta)
);