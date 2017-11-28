DROP TABLE IF EXISTS Cotizacion;
DROP TABLE IF EXISTS Indicador;
DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Empresa;
DROP TABLE IF EXISTS Condicion;
DROP TABLE IF EXISTS Metodologia;
DROP TABLE IF EXISTS Usuario;


CREATE TABLE Cuenta (
    codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL
);

CREATE TABLE Empresa (
    nombre VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE Cotizacion (
    id BIGINT IDENTITY PRIMARY KEY,
    cuenta VARCHAR(50) NOT NULL,
    empresa VARCHAR(50) NOT NULL,
    periodo INTEGER NOT NULL,
    valor DECIMAL NOT NULL,
    FOREIGN KEY (cuenta) REFERENCES Cuenta(codigo),
    FOREIGN KEY (empresa) REFERENCES Empresa(nombre),
    UNIQUE(cuenta,empresa,periodo)
);

CREATE TABLE Usuario (
    usuario VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE Indicador (
    codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NULL,
    usuario VARCHAR(50) NOT NULL,
    formula VARCHAR(255) NOT NULL,
    FOREIGN KEY (usuario) REFERENCES Usuario(usuario)
);

CREATE TABLE Condicion (
    codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    formula VARCHAR(255) NOT NULL,
    usuario VARCHAR(50) NOT NULL,
    FOREIGN KEY (usuario) REFERENCES Usuario(usuario)
);

CREATE TABLE Metodologia (
    codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL,
    condiciones VARCHAR(255) NOT NULL,
    usuario VARCHAR(50) NOT NULL,
    FOREIGN KEY (usuario) REFERENCES Usuario(usuario)
);

/*Pensar si realmente vale la pensa implementar una clase periodo ?? mientras se maneja como Integer
CREATE TABLE Periodo (
    periodo INT NOT NULL PRIMARY KEY
);*/

INSERT INTO Usuario(usuario, password) VALUES ('admin', '1234');
INSERT INTO Usuario(usuario, password) VALUES ('system', '1234');
INSERT INTO Usuario(usuario, password) VALUES ('nacho', '1234');

INSERT INTO Metodologia( codigo, descripcion, condiciones, usuario) VALUES ('test', 'asd', 'IN', 'system');
INSERT INTO Metodologia (codigo, descripcion, condiciones, usuario) VALUES ('METOD1', 'una metodologia de prueba', 'Mayor5;Menor5', 'system');

INSERT INTO Condicion (codigo, nombre, tipo, formula, usuario) VALUES ('Mayor5','Mayor a 5','Taxativa','>5', 'system');
INSERT INTO Condicion (codigo, nombre, tipo, formula, usuario) VALUES ('Menor5','Menor a 5','Prioritaria','<5', 'system');

INSERT INTO Empresa (nombre) VALUES ('Facebook');
INSERT INTO Empresa (nombre) VALUES ('Twitter');

INSERT INTO Cuenta (codigo, nombre) VALUES ('EBITDA','Earnings Before Interest Taxes Depreciation and Amortization');
INSERT INTO Cuenta (codigo, nombre) VALUES ('EFG','Estimativo prueba');
INSERT INTO Cuenta (codigo, nombre) VALUES ('INOC','Ingreso Neto En Operaciones Continuas');
INSERT INTO Cuenta (codigo, nombre) VALUES ('INOD','Ingreso Neto En Operaciones Discontinuadas');

INSERT INTO Cotizacion(id, cuenta, empresa, periodo, valor) VALUES (1,'EBITDA','Facebook',2015,8162);
INSERT INTO Cotizacion(id, cuenta, empresa, periodo, valor) VALUES (2,'EBITDA','Facebook',2016,14870);
INSERT INTO Cotizacion(id, cuenta, empresa, periodo, valor) VALUES (3,'INOC','Facebook',2016,4273);
INSERT INTO Cotizacion(id, cuenta, empresa, periodo, valor) VALUES (4,'INOD','Facebook',2016,2);
INSERT INTO Cotizacion(id, cuenta, empresa, periodo, valor) VALUES (5,'EFG','Facebook',2016,1);

INSERT INTO Indicador(codigo, nombre, usuario, formula) VALUES ('INETO','Ingreso neto','system','INOC+INOD');
INSERT INTO Indicador(codigo, nombre, usuario, formula) VALUES ('test','unIndicadorDePRueba','nacho','INOC+INOD*20');