ALTER TABLE usuarios ALTER COLUMN id DROP DEFAULT;
ALTER TABLE usuarios ALTER COLUMN id DROP NOT NULL;
ALTER TABLE usuarios ALTER COLUMN id TYPE SERIAL;

CREATE SEQUENCE usuarios_id_seq;
ALTER TABLE usuarios ALTER COLUMN id SET DEFAULT nextval('usuarios_id_seq');
SELECT setval('usuarios_id_seq', (SELECT MAX(id) FROM usuarios));

SELECT setval('usuarios_id_seq', 1, false);

SELECT * FROM usuarios

-- 1. Eliminar el registro con id = 0 (si ya no lo necesitas)
DELETE FROM usuarios WHERE id = 0;

-- 2. Actualizar el valor de la secuencia (usuarios_id_seq) al último ID + 1
SELECT setval('usuarios_id_seq', (SELECT MAX(id) FROM usuarios));

SELECT * FROM tickets

-- Renombrar columna titulo a nombre_estado
ALTER TABLE tickets RENAME COLUMN titulo TO nombre_estado;

-- Renombrar columna descripcion a descripcion_estado
ALTER TABLE tickets RENAME COLUMN descripcion TO descripcion_estado;

-- Renombrar columna estado a estado_final
ALTER TABLE tickets RENAME COLUMN estado TO estado_final;

-- Agregar columna estados_permitidos
ALTER TABLE tickets ADD COLUMN estados_permitidos VARCHAR(255);

-- (opcional) Si fecha_creacion no tiene el tipo correcto:
ALTER TABLE tickets ALTER COLUMN fecha_creacion TYPE VARCHAR(50);

-- Verifica si usuario_id ya es clave foránea, si no:
ALTER TABLE tickets ADD CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id);

-- Verificar columnas y algunos registros
SELECT 
    id,
    nombre_estado,
    descripcion_estado,
    estado_final,
    estados_permitidos,
    fecha_creacion,
    usuario_id
FROM tickets
LIMIT 10;

-- Muestra estructura de la tabla
SELECT 
    column_name, 
    data_type, 
    character_maximum_length 
FROM 
    information_schema.columns 
WHERE 
    table_name = 'tickets';

INSERT INTO usuarios (id, nombres, apellidos, email, nombre_usuario, contraseña, rol_asignado, departamento)
VALUES (2, 'Usuario', 'Prueba', 'usuario2@example.com', 'usuario2', '123456', 'usuario', 'soporte');

INSERT INTO usuarios (id, nombres, apellidos, email, nombre_usuario, contraseña, rol_asignado)
VALUES (1, 'Carlos', 'Pirir', 'estuardo@gmail.com', 'carlospirir', '87965', 'usuario');

SELECT * FROM tickets
