DROP TABLE IF EXISTS cuenta;
CREATE TABLE cuenta (
    idCuenta BIGINT PRIMARY KEY IDENTITY ,
    nombre VARCHAR(20), 
    empresa VARCHAR(20), 
    periodo VARCHAR(5), 
    valor DOUBLE
);