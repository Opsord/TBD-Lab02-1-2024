-- Uer triggers

-- Audit trigger
CREATE TABLE User_auditTrigger (
    idTrigger SERIAL PRIMARY KEY,
    rut VARCHAR(20),
    name VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    role VARCHAR(255),
    operation TEXT
);

-- Modify user_audit_trigger_function
CREATE OR REPLACE FUNCTION user_audit_trigger_function()
RETURNS TRIGGER AS $$
DECLARE
    user_role VARCHAR(255);
BEGIN
    -- Get role from Role table
    SELECT role INTO user_role FROM Role WHERE rut = NEW.rut;

    -- Insert into User_auditTrigger
    INSERT INTO User_auditTrigger (rut, name, email, password, role, date, operation)
    VALUES (NEW.rut, NEW.name, NEW.lastName, NEW.email, NEW.password, user_role, CURRENT_TIMESTAMP, TG_OP);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER user_audit_trigger
BEFORE INSERT OR UPDATE OR DELETE ON User
FOR EACH ROW
EXECUTE FUNCTION user_audit_trigger_function();

-- Trigger to prevent users from having duplicated roles
CREATE OR REPLACE FUNCTION prevent_user_duplicate_roles_func()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT COUNT(*) FROM Role WHERE rut = NEW.rut AND role = NEW.role) > 0 THEN
        RAISE EXCEPTION 'Un usuario no puede tener roles duplicados.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER prevent_user_duplicate_roles
BEFORE INSERT ON Role
FOR EACH ROW
EXECUTE FUNCTION prevent_user_duplicate_roles_func();

-- Trigger to prevent users from having duplicated attributes
CREATE OR REPLACE FUNCTION prevent_user_duplicate_attributes_func()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT COUNT(*) FROM User_Attribute WHERE rut = NEW.rut AND idAttribute = NEW.idAttribute) > 0 THEN
        RAISE EXCEPTION 'Un usuario no puede tener atributos duplicados.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER prevent_user_duplicate_attributes
BEFORE INSERT ON User_Attribute
FOR EACH ROW
EXECUTE FUNCTION prevent_user_duplicate_attributes_func();

-- Trigger to prevent users from having duplicated institutions
CREATE OR REPLACE FUNCTION prevent_user_duplicate_institutions_func()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT COUNT(*) FROM User_Institution WHERE rut = NEW.rut AND idInstitution = NEW.idInstitution) > 0 THEN
        RAISE EXCEPTION 'Un usuario no puede tener instituciones duplicadas.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER prevent_user_duplicate_institutions
BEFORE INSERT ON User_Institution
FOR EACH ROW
EXECUTE FUNCTION prevent_user_duplicate_institutions_func();


-- Emergency triggers

-- Audit trigger
CREATE TABLE Emergency_auditTrigger (
    idTrigger SERIAL PRIMARY KEY,
    idEmergency BIGINT,
    title VARCHAR(255),
    description TEXT,
    coordinator VARCHAR(20),
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    operation TEXT
);

CREATE OR REPLACE FUNCTION emergency_audit_trigger_function()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO Emergency_auditTrigger (idEmergency, title, description, coordinator, date, operation)
    VALUES (NEW.idEmergency, NEW.title, NEW.description, NEW.coordinator, CURRENT_TIMESTAMP, TG_OP);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER emergency_audit_trigger
BEFORE INSERT OR UPDATE OR DELETE ON Emergency
FOR EACH ROW
EXECUTE FUNCTION emergency_audit_trigger_function();

-- Trigger to prevent emergencies from having duplicated attributes
CREATE OR REPLACE FUNCTION prevent_emergency_duplicate_attributes_func()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT COUNT(*) FROM Emergency_Attribute WHERE idEmergency = NEW.idEmergency AND idAttribute = NEW.idAttribute) > 0 THEN
        RAISE EXCEPTION 'Una emergencia no puede tener atributos duplicados.';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER prevent_emergency_duplicate_attributes
BEFORE INSERT ON Emergency_Attribute
FOR EACH ROW
EXECUTE FUNCTION prevent_emergency_duplicate_attributes_func();