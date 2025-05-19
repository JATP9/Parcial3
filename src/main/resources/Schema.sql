DROP TABLE IF EXISTS videojuegos;

CREATE TABLE videojuegos (
                             id CHAR(36) PRIMARY KEY,
                             titulo VARCHAR(100) NOT NULL,
                             anio_lanzamiento INT NOT NULL,
                             plataforma VARCHAR(50) NOT NULL,
                             duracion_horas INT NOT NULL
);
