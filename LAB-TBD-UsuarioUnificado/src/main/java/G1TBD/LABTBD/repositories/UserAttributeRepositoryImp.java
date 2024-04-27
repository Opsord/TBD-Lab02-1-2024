package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.UserAttributeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserAttributeRepositoryImp implements UserAttributeRepository{

    private final Sql2o sql2o;
    private final Logger logger = Logger.getLogger(UserAttributeRepositoryImp.class.getName());

    @Autowired
    public UserAttributeRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public UserAttributeEntity create(UserAttributeEntity userAttribute) {
        String sql = "INSERT INTO User_Attribute (rut, idAttribute) " +
                "VALUES (:rut, :idAttribute)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", userAttribute.getRut())
                    .addParameter("idAttribute", userAttribute.getIdAttribute())
                    .executeUpdate();
            return userAttribute;
        } catch (Exception e) {
            logger.severe("Error al crear atributo de usuario: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserAttributeEntity> getAll() {
        String sql = "SELECT * FROM User_Attribute";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(UserAttributeEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los atributos de usuario: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public UserAttributeEntity getById(long id) {
        String sql = "SELECT * FROM User_Attribute WHERE idUserAttribute = :idUserAttribute";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idUserAttribute", id)
                    .executeAndFetchFirst(UserAttributeEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener atributo de usuario por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(UserAttributeEntity userAttribute) {
        String sql = "UPDATE User_Attribute SET rut = :rut, idAttribute = :idAttribute WHERE idUserAttribute = :idUserAttribute";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", userAttribute.getRut())
                    .addParameter("idAttribute", userAttribute.getIdAttribute())
                    .addParameter("idUserAttribute", userAttribute.getIdUserAttribute())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            logger.severe("Error al actualizar atributo de usuario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM User_Attribute WHERE idUserAttribute = :idUserAttribute";

        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("idUserAttribute", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar atributo de usuario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<UserAttributeEntity> getByRut(String rut) {
        String sql = "SELECT * FROM User_Attribute WHERE rut = :rut";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeAndFetch(UserAttributeEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener atributos de usuario por rut: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public List<UserAttributeEntity> getByAttributeId(long attributeId) {
        String sql = "SELECT * FROM User_Attribute WHERE idAttribute = :idAttribute";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idAttribute", attributeId)
                    .executeAndFetch(UserAttributeEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener atributos de usuario por id de atributo: " + e.getMessage());
            return List.of();
        }
    }

}
