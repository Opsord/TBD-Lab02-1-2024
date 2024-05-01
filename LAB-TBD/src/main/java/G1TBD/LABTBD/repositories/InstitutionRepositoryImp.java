package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.InstitutionEntity;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class InstitutionRepositoryImp implements InstitutionRepository {

    private final Sql2o sql2o;
    private static final Logger logger = Logger.getLogger(InstitutionRepositoryImp.class.getName());

    @Autowired
    public InstitutionRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public InstitutionEntity create(InstitutionEntity institution) {
        String sql = "INSERT INTO institutions (name)" +
                "VALUES (:name)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("name", institution.getName())
                    .executeUpdate()
                    .getKey();
            return institution;

        } catch (Exception e) {
            logger.severe("Error al crear institucion: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<InstitutionEntity> getAll() {
        String sql = "SELECT * FROM institutions ORDER BY idinstitution ";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(InstitutionEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener todas las instituciones: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public InstitutionEntity getById(long id) {
        String sql = "SELECT * FROM institutions WHERE idinstitution = :idInstitution";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idInstitution", id)
                    .executeAndFetchFirst(InstitutionEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener institucion por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(InstitutionEntity institution) {
        String sql = "UPDATE institutions SET name = :name WHERE idinstitution = :idInstitution";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idInstitution", institution.getIdInstitution())
                    .addParameter("name", institution.getName())
                    .executeUpdate()
                    .getKey();
            conn.commit();
            return true;

        } catch (Exception e) {
            logger.severe("Error al actualizar institucion: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id){
        String sql = "DELETE FROM institutions WHERE idinstitution = :idInstitution";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idInstitution", id)
                    .executeUpdate();
            conn.commit();
            return true;

        } catch (Exception e) {
            logger.severe("Error al eliminar institucion: " + e.getMessage());
            return false;
        }
    }
}
