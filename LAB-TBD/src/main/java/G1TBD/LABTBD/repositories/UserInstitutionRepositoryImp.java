package G1TBD.LABTBD.repositories;
/*
 * import G1TBD.LABTBD.entities.UserInstitutionEntity;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Repository;
 * import org.sql2o.Connection;
 * import org.sql2o.Sql2o;
 * 
 * import java.util.List;
 * import java.util.logging.Logger;
 * 
 * @Repository
 * public class UserInstitutionRepositoryImp implements
 * UserInstitutionRepository{
 * 
 * private final Sql2o sql2o;
 * private final Logger logger =
 * Logger.getLogger(UserInstitutionRepositoryImp.class.getName());
 * 
 * @Autowired
 * public UserInstitutionRepositoryImp(Sql2o sql2o) {
 * this.sql2o = sql2o;
 * }
 * 
 * @Override
 * public UserInstitutionEntity create(UserInstitutionEntity userInstitution) {
 * String sql = "INSERT INTO User_Institution (rut, idInstitution) " +
 * "VALUES (:rut, :idInstitution)";
 * 
 * try (Connection conn = sql2o.open()) {
 * conn.createQuery(sql)
 * .addParameter("rut", userInstitution.getRut())
 * .addParameter("idInstitution", userInstitution.getIdInstitution())
 * .executeUpdate();
 * return userInstitution;
 * 
 * } catch (Exception e) {
 * logger.severe("Error al crear institucion de usuario: " + e.getMessage());
 * return null;
 * }
 * }
 * 
 * @Override
 * public List<UserInstitutionEntity> getAll() {
 * String sql = "SELECT * FROM User_Institution";
 * 
 * try (Connection conn = sql2o.open()) {
 * return conn.createQuery(sql)
 * .executeAndFetch(UserInstitutionEntity.class);
 * 
 * } catch (Exception e) {
 * logger.severe("Error al obtener todas las instituciones de usuario: " +
 * e.getMessage());
 * return List.of();
 * }
 * }
 * 
 * @Override
 * public UserInstitutionEntity getById(long id) {
 * String sql =
 * "SELECT * FROM User_Institution WHERE idUserInstitution = :idUserInstitution"
 * ;
 * 
 * try (Connection conn = sql2o.open()) {
 * return conn.createQuery(sql)
 * .addParameter("idUserInstitution", id)
 * .executeAndFetchFirst(UserInstitutionEntity.class);
 * 
 * } catch (Exception e) {
 * logger.severe("Error al obtener institucion de usuario por id: " +
 * e.getMessage());
 * return null;
 * }
 * }
 * 
 * @Override
 * public boolean update(UserInstitutionEntity userInstitution) {
 * String sql =
 * "UPDATE User_Institution SET rut = :rut, idInstitution = :idInstitution " +
 * "WHERE idUserInstitution = :idUserInstitution";
 * 
 * try (Connection conn = sql2o.open()) {
 * conn.createQuery(sql)
 * .addParameter("rut", userInstitution.getRut())
 * .addParameter("idInstitution", userInstitution.getIdInstitution())
 * .addParameter("idUserInstitution", userInstitution.getIdUserInstitution())
 * .executeUpdate();
 * return true;
 * 
 * } catch (Exception e) {
 * logger.severe("Error al actualizar institucion de usuario: " +
 * e.getMessage());
 * return false;
 * }
 * }
 * 
 * @Override
 * public boolean delete(long id) {
 * String sql =
 * "DELETE FROM User_Institution WHERE idUserInstitution = :idUserInstitution";
 * 
 * try (Connection conn = sql2o.open()) {
 * conn.createQuery(sql)
 * .addParameter("idUserInstitution", id)
 * .executeUpdate();
 * return true;
 * 
 * } catch (Exception e) {
 * logger.severe("Error al eliminar institucion de usuario: " + e.getMessage());
 * return false;
 * }
 * }
 * 
 * @Override
 * public UserInstitutionEntity getByRut(String rut) {
 * String sql = "SELECT * FROM User_Institution WHERE rut = :rut";
 * try (Connection conn = sql2o.open()) {
 * return conn.createQuery(sql)
 * .addParameter("rut", rut)
 * .executeAndFetchFirst(UserInstitutionEntity.class);
 * 
 * } catch (Exception e) {
 * logger.severe("Error al obtener institucion de usuario por rut: " +
 * e.getMessage());
 * return null;
 * }
 * }
 * 
 * @Override
 * public List<UserInstitutionEntity> getByinstitution_id(long institution_id) {
 * String sql =
 * "SELECT * FROM User_Institution WHERE idInstitution = :idInstitution";
 * 
 * try (Connection conn = sql2o.open()) {
 * return conn.createQuery(sql)
 * .addParameter("idInstitution", institution_id)
 * .executeAndFetch(UserInstitutionEntity.class);
 * 
 * } catch (Exception e) {
 * logger.
 * severe("Error al obtener institucion de usuario por id de institucion: " +
 * e.getMessage());
 * return List.of();
 * }
 * }
 * }
 */