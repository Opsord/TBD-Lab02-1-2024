-- Poblacion de la tabla Voluntarios
-- Las contraseñas son el primer nombre en 'minuscula'+'primeros 3 digitos del rut'
INSERT INTO Users (rut, email, name, lastname, birthdate, sex, password, role, availability)
VALUES
    ('123271472-1', 'correo.ejemplo@gmail.com', 'Elsa', 'Capuntas', '1997-06-22', 'F', '$2a$10$JWCTjsZvnbhrh6Y99lSJuubMITj1ykX.0Rn6oysAApoteY20fbqC.', 'VOLUNTEER', True),
    ('176271472-1', 'correo.ejemplo@gmail.com', 'Elivs', 'Tec', '1997-12-22', 'M', '$2a$10$32.WMcUybLU1ykwDaGmJZ.dAR6pkafizvkbl0wSP/VZ7wEqPFUOGS', 'VOLUNTEER', True),
    ('182473567-4', 'correo.ejemplo@gmail.com', 'Pedro', 'Perez', '1999-10-31', 'M', '$2a$10$YsmKIfYGUgTmknrsEbJOz.5acNKnWmVM2NDbhuC7mizwANcmMUoLC', 'VOLUNTEER', True),
    ('2421283874-4', 'maria.ejemplo@gmail.com', 'Maria', 'Perez', '1978-11-30', 'F', '$2a$10$B0xQF1r1iCK0wnnlulKTI.q7qgBYYXABtJ8spQhACj2fehRLRJE76', 'VOLUNTEER', True),
    ('3641746726-4', 'correo.ejemplo@gmail.com', 'Juan', 'SuperApellido', '2000-12-22', 'M', '$2a$10$0XtHEGIFsrRvSz5YMQsi8ORaoBS4jVHprwNwOWNKeKeONeAQB7VG2', 'VOLUNTEER', True),
    ('4152351623-5', 'correo.ejemplo@gmail.com', 'Aitor', 'Tilla', '2000-03-14', 'M', '$2a$10$lUQZmfWqqMrMIvigmrUNhuumirqf7CC4VNNbSAI/rAT4QLjuXAchC', 'VOLUNTEER', True),
    ('42163612342-5', 'correo.ejemplo@gmail.com', 'Elena', 'Nito', '2001-06-11', 'F', '$2a$10$HWFPIWz0aAauCewQoIHxw.hXEXZLvxb60FTzp7qlIcaEc.AmWjiu6', 'VOLUNTEER', True),
    ('4412317123-k', 'correo.ejemplo@gmail.com', 'Armando', 'Casas', '2002-07-12', 'M', '$2a$10$cxY0Zed1Fwpoc3E/UDjtt.LP9QVIvcuPgt9L6j3Xnyd5BtJovwSMi', 'VOLUNTEER', True),
    ('5872873212-4', 'correo.ejemplo@gmail.com', 'Susana', 'Oria', '2000-11-26', 'F', '$2a$10$6n5aRdvxOl3HXAig7L6bBeYUVxkpjfBVRUCvmG55OjlCz3/0o/Ila', 'VOLUNTEER', True),
    ('61523512412-5', 'correo.ejemplo@gmail.com', 'Helen', 'Chufe', '2000-02-16', 'F', '$2a$10$Ak8qBb.FCXhfOE/7RMx.eeRJlDRjEuauwt2MldRoI2VpSHLeJ/jQG', 'VOLUNTEER', False),
    ('65265412312-k', 'correo.ejemplo@gmail.com', 'Elmer', 'Curio', '2001-10-12', 'M', '$2a$10$zIal5qkGG2U.Qx8Idaahwe4OC9lDdsOJ52J3Z3eOqFcyYzE5dTJBC', 'COORDINATOR', False),
    ('6527442312-k', 'correo.ejemplo@gmail.com', 'Elsa', 'Pallo', '2002-07-12', 'F', '$2a$10$1vqWoEX6ErVvBHW6.06eAOEjzvJP2GqLU3cfge1To/S5giNEyDYwy', 'COORDINATOR', False),
    ('6717263715312-k', 'correo.ejemplo@gmail.com', 'Alan', 'Brito Delgado', '2001-02-22', 'M', '$2a$10$ZT.iqWL.n6yfJPz1d/N4LO3I5KXfwZZoDTrc.9LCPS2qPENZY5T16', 'VOLUNTEER', False),
    ('7123674212-5', 'correo.ejemplo@gmail.com', 'Armando', 'Sillas', '2000-04-19', 'M', '$2a$10$5DEJ9nasG5MnUUlgPda6Uuy3hyg1vtD8XC/ytGzOkMrB7EvIcnbdi', 'VOLUNTEER', True),
    ('7126371263-k', 'correo.ejemplo@gmail.com', 'Mario', 'Neta', '2000-05-20', 'M', '$2a$10$zWYg2zgjSDE/zYkuWt35eOrSSyiAtCheIEREdkWt72T8JIHp4J9du', 'COORDINATOR', True),
    ('71264646674-4', 'correo.ejemplo@gmail.com', 'Aquiles', 'Baeza', '2001-11-13', 'M', '$2a$10$cVP6o0eDpTRhElUMTbJrKeR9AFAM3vtk.xogRrSn1BVHd0Wn/rf/C', 'VOLUNTEER', True),
    ('7126476122-4', 'correo.ejemplo@gmail.com', 'Eustacio', 'Perez', '2001-11-13', 'M', '$2a$10$mIkd1hzL4rGbfyoyByaVDuUYNYBPPxZzPrwlGT7EqPui8ZWA7WjZW', 'VOLUNTEER', True),
    ('7146176122-4', 'correo.ejemplo@gmail.com', 'Clementia', 'Del Rosario', '2000-11-16', 'F', '$2a$10$dUJK89Pao.vGR7hjPezggOapdLwaFqpxnvB8VGO3za3bu4mUIXcHG', 'VOLUNTEER', True),
    ('7723674212-5', 'correo.ejemplo@gmail.com', 'Lola', 'Mento', '2001-03-09', 'F', '$2a$10$0v1Rv1KQRZ4OHKSLSy4JUuYNfMA1/yAvtBndD4JlPBkwhseoKd/Ua', 'VOLUNTEER', True),
    ('81723817246-1', 'correo.ejemplo@gmail.com', 'Zacaria', 'Flores del Campo', '2002-11-26', 'F', '$2a$10$n47WKpnIBCC7zoYVAnDviOaO5MUQiUifwqoaXThAO3/F8a.sIFiFy', 'VOLUNTEER', True),
    ('876327463-4', 'correo.ejemplo@gmail.com', 'Diego', 'SuperApellido', '2000-12-22', 'M', '$2a$10$xYPusc0RS.yb56gjNZeLSOEKbisdFD4uoU8cuWemtFzk5iPHkyPha', 'VOLUNTEER', False),
    ('881263612-k', 'correo.ejemplo@gmail.com', 'Esteban', 'Dido', '1999-05-20', 'M', '$2a$10$2xuw5OvwVsQ3gaDihcsfyOivRa2X1dALtlKv6pi90mfMQwnSqHlb2', 'COORDINATOR', True),
    ('948128124-1', 'correo.ejemplo@gmail.com', 'Aquiles', 'Brinco', '2000-11-26', 'F', '$2a$10$oh4r.6xrChGbToX2B3yS6OwkYdSbAdP7IPnuo2PMmzfhlq0UYQ5cG', 'VOLUNTEER', True),
    ('98482714-4', 'correo.ejemplo@gmail.com', 'Elba', 'Calao', '1994-04-20', 'F', '$2a$10$Y0ntA2TXhIKuTIcrtTWOm.uyC7dvYjiNLL5cJsBkMWb1clYQnbVgS', 'COORDINATOR', True);

--Poblacion de la tabla Atributo
INSERT INTO Attributes (attribute_id, attribute)
VALUES 
    (1, 'Fuerza fisica'),
    (2, 'Rescate en Terreno'),
    (3, 'Apoyo psicologico'),
    (4, 'Manejo de herramientas de rescate'),
    (5, 'Conocimientos en primeros auxilios'),
    (6, 'Manejo de equipos de comunicacion'),
    (7, 'Capacidad para la búsqueda y localización de personas perdidas');

--Poblacion de la tabla Voluntario_Atributo
INSERT INTO User_Attribute (user_attribute_id, rut, attribute)
VALUES 
    (1, '3641746726-4', '1'),
    (2, '3641746726-4', '2'),
    (3, '176271472-1', '3'),
    (4, '176271472-1', '4'),
    (5, '182473567-4', '5'),
    (6, '182473567-4', '6'),
    (7, '948128124-1', '7'),
    (8, '948128124-1', '1'),
    (9, '81723817246-1', '4'),
    (10, '81723817246-1', '1'),
    (11, '71264646674-4', '6'),
    (12, '71264646674-4', '7'),
    (13, '5872873212-4', '1'),
    (14, '5872873212-4', '2'),
    (15, '123271472-1', '7'),
    (16, '123271472-1', '3'),
    (17, '876327463-4', '1'),
    (18, '876327463-4', '2'),
    (19, '7126476122-4', '7'),
    (20, '7126476122-4', '3');

--Poblacion de la tabla Institucion
INSERT INTO Institutions (institution_id, name) 
VALUES 
    (1, 'Cruz Roja de Chile'),
    (2, 'Bomberos Municipales'),
    (3, 'Equipo de rescate de desastres naturales');

-- Poblacion de la tabla User_Institution
INSERT INTO User_Institution (user_institution_id, rut, institution)
VALUES 
    (1, '7126371263-k', '1'),
    (2, '65265412312-k', '2'),
    (3, '6527442312-k', '3');


--Poblacion de la tabla Emergencia
INSERT INTO Emergencies (emergency_id, status, title, description, coordinator)
VALUES 
    (1, true, 'Incendio forestal en zona rural', 'Se ha reportado un incendio forestal en la zona de la Reserva Nacional. Se necesita asistencia inmediata.', '7126371263-k'),
    (2, false, 'Evacuación por fuga de gas', 'Se ha detectado una fuga de gas en un edificio residencial. Se requiere evacuación de los residentes.', '7126371263-k'),
    (3, true, 'Inundación en área urbana', 'Las fuertes lluvias han provocado inundaciones en varios sectores de la ciudad. Se necesitan equipos de rescate.', '65265412312-k'),
    (4, true, 'Accidente de tráfico múltiple', 'Se ha producido un accidente de tráfico en la autopista principal. Varios vehículos están involucrados.', '6527442312-k'),
    (5, false, 'Deslizamiento de tierra en carretera', 'Un deslizamiento de tierra ha bloqueado una carretera importante. Se necesita ayuda para despejar la vía.', '6527442312-k');

--Poblacion de tabla
-- Población de la tabla Emergencia_Atributo
INSERT INTO Emergency_Attribute (emergency_attribute_id, emergency, attribute, compatibility)
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
INSERT INTO Tasks (task_id, emergency, type, description, state)
VALUES 
    (1, 1, 'Evacuación de residentes', 'Coordinar y ejecutar la evacuación de los residentes afectados por el incendio forestal.', true),
    (2, 2, 'Control de fuga de gas', 'Gestionar la contención y control de la fuga de gas en el edificio residencial.', false),
    (3, 3, 'Rescate de personas atrapadas', 'Realizar operaciones de rescate para ayudar a las personas atrapadas por la inundación.', true),
    (4, 4, 'Atención médica a heridos', 'Brindar atención médica a los heridos en el accidente de tráfico múltiple.', true),
    (5, 5, 'Despeje de la carretera', 'Organizar y llevar a cabo el despeje de la carretera bloqueada por el deslizamiento de tierra.', false),
    (6, 1, 'Suministro de alimentos', 'Distribuir alimentos y agua potable a los evacuados.', true),
    (7, 2, 'Apoyo psicológico a afectados', 'Brindar apoyo emocional y asistencia psicológica a las personas afectadas por la fuga de gas.', false);

-- Población de la tabla Ranking
INSERT INTO Rankings (ranking_id, volunteer, task, value)
VALUES 
    (1, '123271472-1', 1, 4),   -- Juan participó en la evacuación de residentes del incendio forestal y recibió un valor de ranking de 4.
    (2, '176271472-1', 2, 3),   -- María estuvo a cargo del control de la fuga de gas y recibió un valor de ranking de 3.
    (3, '182473567-4', 3, 5),   -- Carlos participó en el rescate de personas atrapadas por la inundación y recibió un valor de ranking de 5.
    (4, '2421283874-4', 4, 4),   -- Ana brindó atención médica a los heridos en el accidente de tráfico múltiple y recibió un valor de ranking de 4.
    (5, '3641746726-4', 5, 2),   -- Pedro ayudó en el despeje de la carretera bloqueada por el deslizamiento de tierra y recibió un valor de ranking de 2.
    (6, '4152351623-5', 1, 3),   -- Laura participó en la evacuación de residentes del incendio forestal y recibió un valor de ranking de 3.
    (7, '42163612342-5', 2, 4),   -- Diego estuvo a cargo del control de la fuga de gas y recibió un valor de ranking de 4.
    (8, '4412317123-k', 3, 5),   -- Sofía participó en el rescate de personas atrapadas por la inundación y recibió un valor de ranking de 5.
    (9, '5872873212-4', 4, 4),   -- Miguel brindó atención médica a los heridos en el accidente de tráfico múltiple y recibió un valor de ranking de 4.
    (10, '61523512412-5', 5, 3);-- Paula ayudó en el despeje de la carretera bloqueada por el deslizamiento de tierra y recibió un valor de ranking de 3.
    