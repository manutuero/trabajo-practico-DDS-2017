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

/* agregar campo "codigo" a la tabla Cuenta e Indicador */
INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('EBITDA','Facebook',2016,14870);
INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('EFG','Facebook',2016,100);
INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('EBITDA','Facebook',2015,8162);
INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('Ingreso Neto En Operaciones Continuas','Facebook',2016,4273000000);
INSERT INTO Cuenta (nombre, empresa, periodo, valor) VALUES ('Ingreso Neto En Operaciones Discontinuadas','Facebook',2016,0);
insert into Cuenta (nombre, empresa, periodo, valor) VALUES ('INOC','Facebook',2016,4273000000);
insert into Cuenta (nombre, empresa, periodo, valor) VALUES ('INOD','Facebook',2016,0);


INSERT INTO Indicador(nombre, tipo, formula) VALUES ('Ingreso neto','predefinido','INOC+INOD');
INSERT INTO Indicador(nombre, tipo, formula) VALUES ('I_J1','predefinido','EBITDA');

INSERT INTO Indicador(nombre, tipo, formula) VALUES ('I_TestSoloCuenta','predefinido','EBITDA*EFG');
INSERT INTO Indicador(nombre, tipo, formula) VALUES ('I_TestSoloIndicador','predefinido','I_J1');

