package G1TBD.LABTBD.repositories;
/*
import G1TBD.LABTBD.entities.UserEntity;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class UserRepositoryImp implements UserRepository {

    private final Sql2o sql2o;
    private final Logger logger = Logger.getLogger(UserRepositoryImp.class.getName());

    @Autowired
    public UserRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public UserEntity create(UserEntity user) {
        String sql = "INSERT INTO Users (rut, email, name, lastName, birthDate, sex, password, role, availability) " +
                "VALUES (:rut, :email, :name, :lastName, :birthDate, :sex, :password, :role, :availability)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", user.getRut())
                    .addParameter("email", user.getEmail())
                    .addParameter("name", user.getName())
                    .addParameter("lastName", user.getLastName())
                    .addParameter("birthDate", user.getBirthDate())
                    .addParameter("sex", user.getSex())
                    .addParameter("password", user.getPassword())
                    .addParameter("role", user.getRole())
                    .addParameter("availability", user.isAvailability())
                    .executeUpdate();
            return user;

        } catch (Exception e) {
            logger.severe("Error al crear usuario: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserEntity> getAll() {
        String sql = "SELECT * FROM Users";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(UserEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener todos los usuarios: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<UserEntity> getByRut(String rut) {
        String sql = "SELECT * FROM Users WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            List<UserEntity> users = conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeAndFetch(UserEntity.class);
            return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));

        } catch (Exception e) {
            logger.severe("Error al obtener usuario por rut: " + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        String sql = "SELECT * FROM Users WHERE email = :email";

        try (Connection conn = sql2o.open()) {
            List<UserEntity> users = conn.createQuery(sql)
                    .addParameter("email", email)
                    .executeAndFetch(UserEntity.class);
            return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));

        } catch (Exception e) {
            logger.severe("Error al obtener usuario por email: " + e.getMessage());
            return Optional.empty();
        }
    }

    public List<UserEntity> getVolunteers() {
        String sql = "SELECT * FROM Users WHERE role = 'VOLUNTEER'";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(UserEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener voluntarios: " + e.getMessage());
            return List.of();
        }
    }

    public List<UserEntity> getCoordinators() {
        String sql = "SELECT * FROM Users WHERE role = 'COORDINATOR'";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(UserEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener coordinadores: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public boolean update(UserEntity user) {
        String sql = "UPDATE Users SET email = :email, name = :name, lastName = :lastName, birthDate = :birthDate, " +
                "sex = :sex, password = :password, role = :role, availability = :availability " +
                "WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("email", user.getEmail())
                    .addParameter("name", user.getName())
                    .addParameter("lastName", user.getLastName())
                    .addParameter("birthDate", user.getBirthDate())
                    .addParameter("sex", user.getSex())
                    .addParameter("password", user.getPassword())
                    .addParameter("role", user.getRole())
                    .addParameter("availability", user.isAvailability())
                    .addParameter("rut", user.getRut())
                    .executeUpdate();
            return true;

        } catch (Exception e) {
            logger.severe("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String rut) {
        String sql = "DELETE FROM Users WHERE rut = :rut";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("rut", rut)
                    .executeUpdate();
            return true;

        } catch (Exception e) {
            logger.severe("Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<UserEntity> getByRole(String role) {
        String sql = "SELECT * FROM Users WHERE role = :role";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("role", role)
                    .executeAndFetch(UserEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener usuario por rol: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public List<UserEntity> getByAvailability(boolean availability) {
        String sql = "SELECT * FROM Users WHERE availability = :availability";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("availability", availability)
                    .executeAndFetch(UserEntity.class);

        } catch (Exception e) {
            logger.severe("Error al obtener usuario por disponibilidad: " + e.getMessage());
            return List.of();
        }
    }

}
*/