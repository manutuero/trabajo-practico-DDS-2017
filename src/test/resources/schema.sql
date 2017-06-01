DROP TABLE IF EXISTS cuenta;

CREATE TABLE cuenta (
    id_cuenta BIGINT PRIMARY KEY IDENTITY,
    nombre VARCHAR(50),
    empresa VARCHAR(50),
    valor DECIMAL,
    periodo INTEGER
);
