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
    attribute_id BIGSERIAL PRIMARY KEY,
    Attribute VARCHAR(255) NOT NULL
);

CREATE TABLE User_Attribute (
    user_attribute_id BIGSERIAL PRIMARY KEY,
    rut VARCHAR(20),
    attribute BIGINT,
    FOREIGN KEY (rut) REFERENCES Users(rut),
    FOREIGN KEY (attribute) REFERENCES Attributes(attribute_id)
);

CREATE TABLE Institutions (
    institution_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE User_Institution (
    user_institution_id BIGSERIAL PRIMARY KEY,
    rut VARCHAR(20),
    institution BIGINT,
    FOREIGN KEY (rut) REFERENCES Users(rut),
    FOREIGN KEY (institution) REFERENCES Institutions(institution_id)
);

CREATE TABLE Emergencies (
    emergency_id BIGSERIAL PRIMARY KEY,
    status BOOLEAN NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    coordinator VARCHAR(20),
    FOREIGN KEY (coordinator) REFERENCES Users(rut)
);

CREATE TABLE Emergency_Attribute (
    emergency_attribute_id BIGSERIAL PRIMARY KEY,
    emergency BIGINT,
    attribute BIGINT,
    compatibility BOOLEAN NOT NULL,
    FOREIGN KEY (emergency) REFERENCES Emergencies(emergency_id),
    FOREIGN KEY (attribute) REFERENCES Attributes(attribute_id)
);

CREATE TABLE Tasks (
    task_id BIGSERIAL PRIMARY KEY,
    emergency BIGINT,
    type VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    state BOOLEAN NOT NULL,
    FOREIGN KEY (emergency) REFERENCES Emergencies(emergency_id)
);

CREATE TABLE Rankings (
    ranking_id BIGSERIAL PRIMARY KEY,
    volunteer VARCHAR(20),
    task BIGINT,
    value INT,
    FOREIGN KEY (volunteer) REFERENCES Users(rut),
    FOREIGN KEY (task) REFERENCES Tasks(task_id)
);

--Indexes

-- User
CREATE INDEX idx_user_rut ON Users (rut);
CREATE INDEX idx_user_email ON Users (email);
CREATE INDEX idx_user_disponibilidad ON Users (availability);

-- Attribute
CREATE INDEX idx_attribute_id ON Attributes (attribute_id);

-- User_Attribute
CREATE INDEX idx_user_attribute_rut ON User_Attribute (rut);
CREATE INDEX idx_user_attribute_idAttribute ON User_Attribute (attribute);

-- Institution
CREATE INDEX idx_institution_id ON Institutions (institution_id);

-- User_Institution
CREATE INDEX idx_user_institution_rut ON User_Institution (rut);
CREATE INDEX idx_user_institution_idInstitution ON User_Institution (institution);

-- Emergency
CREATE INDEX idx_emergency_rut ON Emergencies (coordinator);

-- Emergency_Attribute
CREATE INDEX idx_emergency_attribute_emergency_id ON Emergency_Attribute (emergency);
CREATE INDEX idx_emergency_attribute_idAttribute ON Emergency_Attribute (attribute);

-- Task
CREATE INDEX idx_task_emergency_id ON Tasks (emergency);

-- Ranking
CREATE INDEX idx_ranking_rut ON Rankings (volunteer);
CREATE INDEX idx_ranking_idTask ON Rankings (task);




