DROP TABLE IF EXISTS Cotizacion;
DROP TABLE IF EXISTS Indicador;
DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Empresa;

CREATE TABLE Cuenta (
    codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NULL
);

CREATE TABLE Empresa (
    id BIGINT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL 
);

CREATE TABLE Cotizacion (
    cuenta VARCHAR(50) NOT NULL,
    empresa BIGINT NOT NULL,
    periodo INTEGER NOT NULL,
    valor DECIMAL NOT NULL,
    PRIMARY KEY (cuenta, empresa, periodo),
    FOREIGN KEY (cuenta) REFERENCES Cuenta(codigo),
    FOREIGN KEY (empresa) REFERENCES Empresa(id)
);

CREATE TABLE Indicador (
    codigo VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NULL,
    tipo VARCHAR(50) NOT NULL,
    formula VARCHAR(255) NOT NULL
);


/* Pensar si realmente vale la pensa implementar una clase periodo ?? mientras se maneja como Integer
CREATE TABLE Periodo (
    periodo INT NOT NULL PRIMARY KEY
);
*/

INSERT INTO Empresa (id, nombre) VALUES (1,'Facebook');
INSERT INTO Empresa (id, nombre) VALUES (2,'Twitter');

INSERT INTO Cuenta (codigo, nombre) VALUES ('EBITDA',null);
INSERT INTO Cuenta (codigo, nombre) VALUES ('INOC','Ingreso Neto En Operaciones Continuas');
INSERT INTO Cuenta (codigo, nombre) VALUES ('INOD','Ingreso Neto En Operaciones Discontinuadas');

INSERT INTO Cotizacion(cuenta, empresa, periodo, valor) VALUES ('EBITDA',1,2015,8162);
INSERT INTO Cotizacion(cuenta, empresa, periodo, valor) VALUES ('EBITDA',1,2016,14870);
INSERT INTO Cotizacion(cuenta, empresa, periodo, valor) VALUES ('INOC',1,2016,4273000000);
INSERT INTO Cotizacion(cuenta, empresa, periodo, valor) VALUES ('INOD',1,2016,0);

INSERT INTO Indicador(codigo, nombre, tipo, formula) VALUES ('INETO','Ingreso neto','predefinido','INOC+INOD');
