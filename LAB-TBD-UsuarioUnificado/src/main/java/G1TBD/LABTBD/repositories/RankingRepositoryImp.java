package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.RankingEntity;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class RankingRepositoryImp implements RankingRepository{

    private final Sql2o sql2o;
    private static final Logger logger = Logger.getLogger(RankingRepositoryImp.class.getName());

    @Autowired
    public RankingRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public RankingEntity create(RankingEntity ranking) {
        String sql = "INSERT INTO ranking (volunteer, idtask, value) " +
                "VALUES (:volunteer, :idtask, :value)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("volunteer", ranking.getRut())
                    .addParameter("idtask", ranking.getIdTask())
                    .addParameter("value", ranking.getValue())
                    .executeUpdate()
                    .getKey();
            conn.commit();
            return ranking;

        } catch (Exception e) {
            logger.severe("Error al crear ranking: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingEntity> getAll() {
        String sql = "SELECT * FROM Ranking";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todos los rankings: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public RankingEntity getById(long id) {
        String sql = "SELECT * FROM Ranking WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idRanking", id)
                    .executeAndFetchFirst(RankingEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener ranking por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(RankingEntity ranking) {
        String sql = "UPDATE Ranking SET volunteer = :volunteer, idtask = :idtask, value = :value " +
                "WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idRanking", ranking.getIdRanking())
                    .addParameter("volunteer", ranking.getRut())
                    .addParameter("idtask", ranking.getIdTask())
                    .addParameter("value", ranking.getValue())
                    .executeUpdate();
            conn.commit();
            return true;

        } catch (Exception e) {
            logger.severe("Error al actualizar ranking: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM Ranking WHERE idRanking = :idRanking";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idRanking", id)
                    .executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            logger.severe("Error al eliminar ranking: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<RankingEntity> getByTaskId(long idTask) {
        String sql = "SELECT * FROM Ranking WHERE idtask = :idtask";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idtask", idTask)
                    .executeAndFetch(RankingEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener ranking por id de emergencia: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
