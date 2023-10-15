-- Crear la tabla de Clientes
CREATE TABLE Clientes (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255),
    Direccion VARCHAR(255)
);

-- Crear la tabla de Productos
CREATE TABLE Productos (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255),
    Descripcion TEXT
);

-- Crear la tabla de TipoEnvio
CREATE TABLE TipoEnvio (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL
);

-- Crear la tabla de TipoBodega
CREATE TABLE TipoBodega (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL
);

-- Crear la tabla de Bodegas
CREATE TABLE Bodegas (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255),
    Ubicacion VARCHAR(255),
    Capacidad INT,
    TipoBodega INT,
    FOREIGN KEY (TipoBodega) REFERENCES TipoBodega(ID)
);

-- Crear la tabla de Envios
CREATE TABLE Envios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Cliente INT,
    Producto INT,
    TipoProducto VARCHAR(50),
    Cantidad INT,
    FechaRegistro DATE,
    FechaEntrega DATE,
    PrecioEnvio DECIMAL(10, 2),
    Descuento DECIMAL(5, 2),
    TipoEnvio INT,
    Bodega INT(100),
    FOREIGN KEY (Cliente) REFERENCES Clientes(ID),
    FOREIGN KEY (Producto) REFERENCES Productos(ID),
    FOREIGN KEY (Bodega) REFERENCES Bodegas(ID),
    FOREIGN KEY (TipoEnvio) REFERENCES TipoEnvio(ID)
);

-- Crear la tabla de Usuarios
CREATE TABLE Usuarios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NombreUsuario VARCHAR(50) NOT NULL,
    Contraseña VARCHAR(255) NOT NULL
);

-- Crear la tabla de Roles
CREATE TABLE Roles (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NombreRol VARCHAR(50) NOT NULL
);

-- Crear la tabla de UsuariosRoles (relación muchos a muchos)
CREATE TABLE UsuariosRoles (
    UsuarioID INT,
    RolID INT,
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(ID),
    FOREIGN KEY (RolID) REFERENCES Roles(ID)
);
