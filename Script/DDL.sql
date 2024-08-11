-- database: ../Database/BDLibreria.sqlite

DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Cajero;
DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Libro;
DROP TABLE IF EXISTS Venta;
DROP TABLE IF EXISTS Detalle_Venta;
DROP TABLE IF EXISTS Reembolso;

CREATE TABLE Persona (
     ID_Persona              INTEGER         NOT NULL PRIMARY KEY AUTOINCREMENT
    ,ID_EntidadTipo          INTEGER         NOT NULL REFERENCES EntidadTipo (ID_EntidadTipo)
    ,Nombre                  VARCHAR(50)     NOT NULL 
    ,Apellido                VARCHAR(50)     NOT NULL
    ,Direccion               VARCHAR(100)    
    ,Telefono                VARCHAR(15)     
    ,Email                   VARCHAR(50)

    ,Estado                  VARCHAR (1)     NOT NUll DEFAULT ('A')
    ,FechaCreacion           DATETIME        DEFAULT(datetime('now','localtime'))
    ,FechaModifica           DATETIME    
);
-- Tabla Cajero
CREATE TABLE Cajero (
     ID_Cajero               INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT
    ,ID_Persona              INTEGER      NOT NULL REFERENCES Persona (ID_Persona)
    ,Usuario                 VARCHAR(16)  NOT NULL
    ,Password                VARCHAR(16)  NOT NULL

    ,Estado                  VARCHAR (1)  NOT NUll DEFAULT ('A')
    ,FechaCreacion           DATETIME     DEFAULT(datetime('now','localtime'))
    ,FechaModifica           DATETIME
);

-- Tabla Cliente
CREATE TABLE Cliente (
     ID_Cliente               INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT
    ,ID_Persona               INTEGER      NOT NULL REFERENCES Persona (ID_Persona)
    ,Fecha_Registro           DATE
    
    ,Estado                   VARCHAR (1)  NOT NUll DEFAULT ('A')
    ,FechaCreacion            DATETIME     DEFAULT(datetime('now','localtime'))
    ,FechaModifica            DATETIME
);

CREATE TABLE Proveedor (
     ID_Proveedor            INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT
    ,ID_EntidadTipo          INTEGER      NOT NULL REFERENCES EntidadTipo (ID_EntidadTipo)
    ,Nombre                  VARCHAR(50)  NOT NULL 
    ,FechaEntrega            DATE         NOT NULL

    ,Estado                  VARCHAR (1)  NOT NUll DEFAULT ('A')
    ,FechaCreacion           DATETIME     DEFAULT(datetime('now','localtime'))
    ,FechaModifica           DATETIME
);

-- Tabla Libro
CREATE TABLE Libro (
     ID_Libro                 INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT
    ,titulo                   VARCHAR(100) NOT NULL
    ,autor                    VARCHAR(100) NOT NULL
    ,genero                   VARCHAR(50)  NOT NULL
    ,editorial                VARCHAR(50)  NOT NULL
    ,anioPublicacion          VARCHAR(4)   NOT NULL
    ,precioVenta              FLOAT
    ,precioCompra             FLOAT
    ,codigoBarra              VARCHAR(20)  UNIQUE NOT NULL
    ,nroUnidades              INTEGER

    ,Estado                   VARCHAR (1)  NOT NUll DEFAULT ('A')
    ,FechaCreacion            DATETIME     DEFAULT(datetime('now','localtime'))
    ,FechaModifica            DATETIME
);

-- Tabla Venta
CREATE TABLE Venta (
     ID_Venta               INTEGER       NOT NULL PRIMARY KEY AUTOINCREMENT
    ,ID_Cajero              INTEGER       NOT NULL REFERENCES Cajero  (ID_Cajero)
    ,ID_Cliente             INTEGER       NOT NULL REFERENCES Cliente (ID_Cliente)

    ,Estado                 VARCHAR (1)   NOT NUll DEFAULT ('A')
    ,FechaCreacion          DATETIME      DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME
);

-- Tabla Detalles de la Venta
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