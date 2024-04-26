--Poblacion de la tabla Voluntarios
INSERT INTO User (rut, email, name, lastName, birthDate, sex, password, role, availability)
VALUES
-- Voluntarios
    ('12345678-9', 'juan@example.com', 'Juan', 'Pérez', '1999-03-12', 'M', 'contraseña123', 'VOLUNTARIO', true),
    ('98765432-1', 'maria@example.com', 'María', 'González', '1994-05-18', 'F', 'clave456', 'VOLUNTARIO', false),
    ('11223344-5', 'carlos@example.com', 'Carlos', 'López', '1984-02-06', 'M', 'pass1234', 'VOLUNTARIO', true),
    ('55443322-1', 'ana@example.com', 'Ana', 'Martínez', '1996-07-24', 'F', '123456', 'VOLUNTARIO', true),
    ('87654321-0', 'pedro@example.com', 'Pedro', 'Sánchez', '1989-09-15', 'M', 'p@$$w0rd', 'VOLUNTARIO', false),
    ('33221100-K', 'laura@example.com', 'Laura', 'Rodríguez', '2002-04-01', 'F', 'laura123', 'VOLUNTARIO', true),
    ('45678901-2', 'diego@example.com', 'Diego', 'Hernández', '1997-02-22', 'M', 'd1ego789', 'VOLUNTARIO', false),
    ('99887766-3', 'sofia@example.com', 'Sofía', 'Gómez', '1991-08-10', 'F', 'sofia321', 'VOLUNTARIO', true),
    ('12454633-4', 'miguel@example.com', 'Miguel', 'Díaz', '1995-06-14', 'M', 'diazmiguel', 'VOLUNTARIO', true),
    ('44556677-5', 'paula@example.com', 'Paula', 'Fernández', '1998-11-29', 'F', 'fernandez', 'VOLUNTARIO', false),
-- Coordinadores
    ('1234678-9', 'maria_coordinador@example.com', 'María', 'García', '1999-12-11', 'F', 'pass1234', 'COORDINATOR'),
    ('9871432-1', 'carlos_coordinador@example.com', 'Carlos', 'Rodríguez', '1949-11-03', 'M', 'contrdawa1', 'COORDINATOR'),
    ('1353344-5', 'ana_coordinador@example.com', 'Ana', 'López', '123454321', '1992-06-12', 'F', 'COORDINATOR');

--Poblacion de la tabla Atributo
INSERT INTO Attribute (idAttribute, attribute)
VALUES 
    (1, 'Fuerza fisica'),
    (2, 'Rescate en Terreno'),
    (3, 'Apoyo psicologico'),
    (4, 'Manejo de herramientas de rescate'),
    (5, 'Conocimientos en primeros auxilios'),
    (6, 'Manejo de equipos de comunicacion'),
    (7, 'Capacidad para la búsqueda y localización de personas perdidas');

--Poblacion de la tabla Voluntario_Atributo
INSERT INTO User_Attribute (idUserAttribute, rut, idAttribute)
VALUES 
    (1, '12345678-9', 1),
    (2, '12345678-9', 2),
    (3, '98765432-1', 3),
    (4, '98765432-1', 4), 
    (5, '11223344-5', 5),
    (6, '11223344-5', 6),
    (7, '55443322-1', 7), 
    (8, '55443322-1', 1), 
    (9, '87654321-0', 4), 
    (10, '87654321-0', 1), 
    (11, '33221100-K', 6), 
    (12, '33221100-K', 7), 
    (13, '45678901-2', 1),
    (14, '45678901-2', 2), 
    (15, '99887766-3', 7), 
    (16, '99887766-3', 3),
    (17, '12454633-4', 1),
    (18, '12454633-4', 2), 
    (19, '44556677-5', 7), 
    (20, '44556677-5', 3);

--Poblacion de la tabla Institucion
INSERT INTO Institution (idInstitution, name) 
VALUES 
    (1, 'Cruz Roja de Chile'),
    (2, 'Bomberos Municipales'),
    (3, 'Equipo de rescate de desastres naturales');

-- Poblacion de la tabla User_Institution
INSERT INTO User_Institution (idUserInstitution, rut, idInstitution)
VALUES 
    (1, '1234678-9', 1),
    (2, '9871432-1', 2),
    (3, '1353344-5', 3),

--Poblacion de la tabla Emergencia
INSERT INTO Emergency (idEmergency, state, title, description, coordinator)
VALUES 
    (1, true, 'Incendio forestal en zona rural', 'Se ha reportado un incendio forestal en la zona de la Reserva Nacional. Se necesita asistencia inmediata.', '9871432-1'),
    (2, false, 'Evacuación por fuga de gas', 'Se ha detectado una fuga de gas en un edificio residencial. Se requiere evacuación de los residentes.', '1234678-9'),
    (3, true, 'Inundación en área urbana', 'Las fuertes lluvias han provocado inundaciones en varios sectores de la ciudad. Se necesitan equipos de rescate.', '1353344-5'),
    (4, true, 'Accidente de tráfico múltiple', 'Se ha producido un accidente de tráfico en la autopista principal. Varios vehículos están involucrados.', '1234678-9'),
    (5, false, 'Deslizamiento de tierra en carretera', 'Un deslizamiento de tierra ha bloqueado una carretera importante. Se necesita ayuda para despejar la vía.', '1353344-5');

--Poblacion de tabla
-- Población de la tabla Emergencia_Atributo
INSERT INTO Emergency_Attribute (idEmergencyAttribute, idEmergency, idAttribute, compatibility)
VALUES 
    (1, 1, 1, true),   -- La emergencia 1 tiene compatibilidad con el atributo 1 (Fuerza física)
    (2, 1, 2, true),   -- La emergencia 1 tiene compatibilidad con el atributo 2 (Rescate en Terreno)
    (3, 1, 3, false),  -- La emergencia 1 no tiene compatibilidad con el atributo 3 (Apoyo psicológico)
    (4, 2, 4, false),  -- La emergencia 2 no tiene compatibilidad con el atributo 4 (Manejo de herramientas de rescate)
    (5, 2, 5, true),   -- La emergencia 2 tiene compatibilidad con el atributo 5 (Conocimientos en primeros auxilios)
    (6, 3, 6, true),   -- La emergencia 3 tiene compatibilidad con el atributo 6 (Manejo de equipos de comunicación)
    (7, 3, 7, true),   -- La emergencia 3 tiene compatibilidad con el atributo 7 (Capacidad para la búsqueda y localización de personas perdidas)
    (8, 4, 1, true),   -- La emergencia 4 tiene compatibilidad con el atributo 1 (Fuerza física)
    (9, 4, 2, false),  -- La emergencia 4 no tiene compatibilidad con el atributo 2 (Rescate en Terreno)
    (10, 5, 6, false), -- La emergencia 5 no tiene compatibilidad con el atributo 6 (Manejo de equipos de comunicación)
    (11, 5, 7, true);  -- La emergencia 5 tiene compatibilidad con el atributo 7 (Capacidad para la búsqueda y localización de personas perdidas)

-- Población de la tabla Tarea
INSERT INTO Task (idTask, idEmergency, type, description, state)
VALUES 
    (1, 1, 'Evacuación de residentes', 'Coordinar y ejecutar la evacuación de los residentes afectados por el incendio forestal.', true),
    (2, 2, 'Control de fuga de gas', 'Gestionar la contención y control de la fuga de gas en el edificio residencial.', false),
    (3, 3, 'Rescate de personas atrapadas', 'Realizar operaciones de rescate para ayudar a las personas atrapadas por la inundación.', true),
    (4, 4, 'Atención médica a heridos', 'Brindar atención médica a los heridos en el accidente de tráfico múltiple.', true),
    (5, 5, 'Despeje de la carretera', 'Organizar y llevar a cabo el despeje de la carretera bloqueada por el deslizamiento de tierra.', false),
    (6, 1, 'Suministro de alimentos', 'Distribuir alimentos y agua potable a los evacuados.', true),
    (7, 2, 'Apoyo psicológico a afectados', 'Brindar apoyo emocional y asistencia psicológica a las personas afectadas por la fuga de gas.', false);

-- Población de la tabla Ranking
INSERT INTO Ranking (idRanking, volunteer, idTask, value)
VALUES 
    (1, '12345678-9', 1, 4),   -- Juan participó en la evacuación de residentes del incendio forestal y recibió un valor de ranking de 4.
    (2, '98765432-1', 2, 3),   -- María estuvo a cargo del control de la fuga de gas y recibió un valor de ranking de 3.
    (3, '11223344-5', 3, 5),   -- Carlos participó en el rescate de personas atrapadas por la inundación y recibió un valor de ranking de 5.
    (4, '55443322-1', 4, 4),   -- Ana brindó atención médica a los heridos en el accidente de tráfico múltiple y recibió un valor de ranking de 4.
    (5, '87654321-0', 5, 2),   -- Pedro ayudó en el despeje de la carretera bloqueada por el deslizamiento de tierra y recibió un valor de ranking de 2.
    (6, '33221100-K', 1, 3),   -- Laura participó en la evacuación de residentes del incendio forestal y recibió un valor de ranking de 3.
    (7, '45678901-2', 2, 4),   -- Diego estuvo a cargo del control de la fuga de gas y recibió un valor de ranking de 4.
    (8, '99887766-3', 3, 5),   -- Sofía participó en el rescate de personas atrapadas por la inundación y recibió un valor de ranking de 5.
    (9, '12454633-4', 4, 4),   -- Miguel brindó atención médica a los heridos en el accidente de tráfico múltiple y recibió un valor de ranking de 4.
    (10, '44556677-5', 5, 3);-- Paula ayudó en el despeje de la carretera bloqueada por el deslizamiento de tierra y recibió un valor de ranking de 3.
    