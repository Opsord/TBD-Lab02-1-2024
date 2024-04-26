CREATE TABLE Users (
    rut VARCHAR(20) PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    birthDate DATE NOT NULL,
    sex VARCHAR(1) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    availability BOOLEAN NOT NULL
);

CREATE TABLE Attributes (
    idAttribute BIGSERIAL PRIMARY KEY,
    Attribute VARCHAR(255) NOT NULL
);

CREATE TABLE User_Attribute (
    idUserAttribute BIGSERIAL PRIMARY KEY,
    rut VARCHAR(20),
    idAttribute BIGINT,
    FOREIGN KEY (rut) REFERENCES Users(rut),
    FOREIGN KEY (idAttribute) REFERENCES Attributes(idAttribute)
);

CREATE TABLE Institutions (
    idInstitution BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE User_Institution (
    idUserInstitution BIGSERIAL PRIMARY KEY,
    rut VARCHAR(20),
    idInstitution BIGINT,
    FOREIGN KEY (rut) REFERENCES Users(rut),
    FOREIGN KEY (idInstitution) REFERENCES Institutions(idInstitution)
);

CREATE TABLE Emergencies (
    idEmergency BIGSERIAL PRIMARY KEY,
    state BOOLEAN NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    coordinator VARCHAR(20),
    FOREIGN KEY (coordinator) REFERENCES Users(rut)
);

CREATE TABLE Emergency_Attribute (
    idEmergencyAttribute BIGSERIAL PRIMARY KEY,
    idEmergency BIGINT,
    idAttribute BIGINT,
    compatibility BOOLEAN NOT NULL,
    FOREIGN KEY (idEmergency) REFERENCES Emergencies(idEmergency),
    FOREIGN KEY (idAttribute) REFERENCES Attributes(idAttribute)
);

CREATE TABLE Tasks (
    idTask BIGSERIAL PRIMARY KEY,
    idEmergency BIGINT,
    type VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    state BOOLEAN NOT NULL,
    FOREIGN KEY (idEmergency) REFERENCES Emergencies(idEmergency)
);

CREATE TABLE Ranking (
    idRanking BIGSERIAL PRIMARY KEY,
    volunteer VARCHAR(20),
    idTask BIGINT,
    value INT,
    FOREIGN KEY (volunteer) REFERENCES Users(rut),
    FOREIGN KEY (idTask) REFERENCES Tasks(idTask)
);

--Indexes

-- User
CREATE INDEX idx_user_rut ON Users (rut);
CREATE INDEX idx_user_email ON Users (email);
CREATE INDEX idx_user_disponibilidad ON Users (availability);

-- Attribute
CREATE INDEX idx_attribute_id ON Attributes (idAttribute);

-- User_Attribute
CREATE INDEX idx_user_attribute_rut ON User_Attribute (rut);
CREATE INDEX idx_user_attribute_idAttribute ON User_Attribute (idAttribute);

-- Institution
CREATE INDEX idx_institution_id ON Institutions (idInstitution);

-- User_Institution
CREATE INDEX idx_user_institution_rut ON User_Institution (rut);
CREATE INDEX idx_user_institution_idInstitution ON User_Institution (idInstitution);

-- Emergency
CREATE INDEX idx_emergency_rut ON Emergencies (coordinator);

-- Emergency_Attribute
CREATE INDEX idx_emergency_attribute_idEmergency ON Emergency_Attribute (idEmergency);
CREATE INDEX idx_emergency_attribute_idAttribute ON Emergency_Attribute (idAttribute);

-- Task
CREATE INDEX idx_task_idEmergency ON Tasks (idEmergency);

-- Ranking
CREATE INDEX idx_ranking_rut ON Ranking (volunteer);
CREATE INDEX idx_ranking_idTask ON Ranking (idTask);




