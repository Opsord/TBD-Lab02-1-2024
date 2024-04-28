package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.TaskEntity;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class TaskRepositoryImp implements TaskRepository {

    private final Sql2o sql2o;
    private static final Logger logger = Logger.getLogger(TaskRepositoryImp.class.getName());

    @Autowired
    public TaskRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public TaskEntity create(TaskEntity task) {
        String sql = "INSERT INTO tasks (idemergency, type, description, state) " +
                "VALUES (:idemergency, :type, :description, :state)";

        try(Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idemergency", task.getIdEmergency())
                    .addParameter("type", task.getType())
                    .addParameter("description", task.getDescription())
                    .addParameter("state", task.isState())
                    .executeUpdate()
                    .getKey();
            conn.commit();
            return task;

        } catch (Exception e) {
            logger.severe("Error al crear tarea: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskEntity> getAll() {
        String sql = "SELECT * FROM tasks";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(TaskEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener todas las tareas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public TaskEntity getById(long id) {
        String sql = "SELECT * FROM tasks WHERE idtask = :id";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idtask", id)
                    .executeAndFetchFirst(TaskEntity.class);
        } catch (Exception e) {
            logger.severe("Error al obtener tarea por id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(TaskEntity task) {
        String sql = "UPDATE tasks SET idemergency = :idemergency, type = :type, " +
                "description = :description, state = :state WHERE idtask = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idemergency", task.getIdEmergency())
                    .addParameter("type", task.getType())
                    .addParameter("description", task.getDescription())
                    .addParameter("state", task.isState())
                    .addParameter("idtask", task.getIdTask())
                    .executeUpdate();
            conn.commit();
            return true;

        } catch (Exception e) {
            logger.severe("Error al actualizar tarea: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM tasks WHERE idtask = :id";

        try(Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idtask", id)
                    .executeUpdate();
            conn.commit();
            return true;

        } catch (Exception e) {
            logger.severe("Error al eliminar tarea: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<TaskEntity> getByEmergencyId(long idEmergency) {
        String sql = "SELECT * FROM tasks WHERE idemergency = :idemergency";

        try(Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("idemergency", idEmergency)
                    .executeAndFetch(TaskEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener tareas por id de emergencia: " + e.getMessage());
            return Collections.emptyList();
        }
    }

}
