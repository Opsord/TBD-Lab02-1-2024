package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class EmergencyAttributeRepositoryImp implements EmergencyAttributeRepository {

    private static final Logger logger = Logger.getLogger(EmergencyAttributeRepositoryImp.class.getName());

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmergencyAttributeEntity create(EmergencyAttributeEntity emergencyAttribute) {
        String sql = "INSERT INTO emergency_attribute (idemergency,idattribute, compatibility) " +
                "VALUES (:idEmergency, :idAttribute, :compatibility)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergency", emergencyAttribute.getIdEmergency())
                    .addParameter("idAttribute", emergencyAttribute.getIdAttribute())
                    .addParameter("compatibility", emergencyAttribute.isCompatibility())
                    .executeUpdate()
                    .getKey();
            conn.commit();
            return emergencyAttribute;

        } catch (Exception e) {
            logger.severe("Error al crear emergenciaAtributo: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergencyAttributeEntity> getAll() {
        String sql = "SELECT * FROM emergency_attribute";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergencyAttributeEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener todos los emergenciaAtributo: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public EmergencyAttributeEntity getById(long id) {
        String sql = "SELECT * FROM emergency_attribute WHERE idattribute = :idAttribute";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idAttribute", id)
                    .executeAndFetchFirst(EmergencyAttributeEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener emergenciaAtributo por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(EmergencyAttributeEntity emergencyAttribute) {
        String sql = "UPDATE emergency_attribute SET idemergency = :idEmergency, compatibility = :compatibility " +
                "WHERE idattribute = :idAttribute";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEmergency", emergencyAttribute.getIdEmergency())
                    .addParameter("compatibility", emergencyAttribute.isCompatibility())
                    .addParameter("idAttribute", emergencyAttribute.getIdAttribute())
                    .executeUpdate();
            conn.commit();
            return true;

        } catch (Exception e) {
            logger.severe("Error al actualizar emergenciaAtributo: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM emergency_attribute WHERE idattribute = :idAttribute";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idAttribute", id)
                    .executeUpdate();
            conn.commit();
            return true;

        } catch (Exception e) {
            logger.severe("Error al eliminar emergenciaAtributo: " + e.getMessage());
            return false;
        }
    }

}
