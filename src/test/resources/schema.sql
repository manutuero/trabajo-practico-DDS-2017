DROP TABLE IF EXISTS Cuenta;
DROP TABLE IF EXISTS Indicador;

CREATE TABLE Cuenta (
    nombre VARCHAR(50) NOT NULL,
    empresa VARCHAR(50) NOT NULL,
    periodo INTEGER NOT NULL,
    valor DECIMAL,
    PRIMARY KEY (nombre, empresa, periodo)
);

CREATE TABLE Indicador (
    nombre VARCHAR(50) NOT NULL PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    formula VARCHAR(255) NOT NULL
);

INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('EBITDA','Facebook',2016,14870);
INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('EBITDA','Facebook',2015,8162);
INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('Ingreso Neto En Operaciones Continuas','Facebook',2016,4273000000);
INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('Ingreso Neto En Operaciones Discontinuadas','Facebook',2016,0);

INSERT INTO Indicador(nombre, tipo, formula) VALUES ('Ingreso neto','predefinido','Ingreso Neto En Operaciones Continuas + Ingreso Neto En Operaciones Discontinuadas');
