-- Script de integracion de PostGis en la base de datos

-- Crea la extension PostGis en la base de datos si no existe
CREATE EXTENSION IF NOT EXISTS postgis;

-- Users
-- Agrega las columnas de latitud y longitud a la tabla Users
ALTER TABLE Users ADD COLUMN latitude DOUBLE PRECISION;
ALTER TABLE Users ADD COLUMN longitude DOUBLE PRECISION;
-- Agrega la columna geom a la tabla Users
ALTER TABLE Users ADD COLUMN geom GEOMETRY(POINT, 4326);
-- Actualiza la columna geom de la tabla Users con la informacion de latitud y longitud
UPDATE Users SET geom = ST_SetSRID(ST_MakePoint(longitude, latitude), 4326);

-- Emergencies
-- Agrega las columnas de latitud y longitud a la tabla Emergencies
ALTER TABLE Emergencies ADD COLUMN latitude DOUBLE PRECISION;
ALTER TABLE Emergencies ADD COLUMN longitude DOUBLE PRECISION;
-- Agrega la columna geom a la tabla Emergencies
ALTER TABLE Emergencies ADD COLUMN geom GEOMETRY(POINT, 4326);
-- Actualiza la columna geom de la tabla Emergencies con la informacion de latitud y longitud
UPDATE Emergencies SET geom = ST_SetSRID(ST_MakePoint(longitude, latitude), 4326);