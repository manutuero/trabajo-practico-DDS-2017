DROP TABLE IF EXISTS Cotizacion;
DROP TABLE IF EXISTS Indicador;
DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Empresa;
DROP TABLE IF EXISTS Metodologia_Condicion;
DROP TABLE IF EXISTS Condicion;
DROP TABLE IF EXISTS Metodologia;


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

CREATE TABLE Indicador (
    codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NULL,
    tipo VARCHAR(50) NOT NULL,
    formula VARCHAR(255) NOT NULL
);

CREATE TABLE Condicion (
    cond_Codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    formula VARCHAR(255) NOT NULL
);

CREATE TABLE Metodologia (
    met_Codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE Metodologia_Condicion (
    condicion VARCHAR(50) NOT NULL,
    metodologia  VARCHAR(50) NOT NULL,
    PRIMARY KEY (condicion, metodologia),
    FOREIGN KEY (condicion) REFERENCES Condicion(cond_Codigo),
    FOREIGN KEY (metodologia) REFERENCES Metodologia(met_Codigo)
);
/* Pensar si realmente vale la pensa implementar una clase periodo ?? mientras se maneja como Integer
CREATE TABLE Periodo (
    periodo INT NOT NULL PRIMARY KEY
);*/

INSERT INTO Metodologia (met_Codigo, descripcion) VALUES ('test', 'asd');
INSERT INTO Metodologia (met_Codigo, descripcion) VALUES ('METOD1', 'una metodologia de prueba');

INSERT INTO Condicion (cond_Codigo, nombre, tipo, formula) VALUES ('Mayor5','Mayor a 5','Taxativa','>5');
INSERT INTO Condicion (cond_Codigo, nombre, tipo, formula) VALUES ('Menor5','Menor a 5','Prioritaria','<5');
INSERT INTO Condicion (cond_Codigo, nombre, tipo, formula) VALUES ('C1','cond 1','Prioritaria','IN<5');

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

INSERT INTO Indicador(codigo, nombre, tipo, formula) VALUES ('INETO','Ingreso neto','predefinido','INOC+INOD');




