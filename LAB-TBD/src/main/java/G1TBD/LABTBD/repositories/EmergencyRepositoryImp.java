package G1TBD.LABTBD.repositories;
/*
 * import G1TBD.LABTBD.entities.EmergencyEntity;
 * import java.util.Collections;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Repository;
 * import org.sql2o.Connection;
 * import org.sql2o.Sql2o;
 * 
 * import java.util.List;
 * import java.util.logging.Logger;
 * 
 * @Repository
 * public class EmergencyRepositoryImp implements EmergencyRepository {
 * 
 * private final Sql2o sql2o;
 * private static final Logger logger =
 * Logger.getLogger(EmergencyRepositoryImp.class.getName());
 * 
 * @Autowired
 * public EmergencyRepositoryImp(Sql2o sql2o) {
 * this.sql2o = sql2o;
 * }
 * 
 * @Override
 * public EmergencyEntity create(EmergencyEntity emergency){
 * String sql = "INSERT INTO emergencies (status, title, description) " +
 * "VALUES (:status, :title, :description)";
 * 
 * try (Connection conn = sql2o.open()) {
 * conn.createQuery(sql, true)
 * .addParameter("status", emergency.isStatus())
 * .addParameter("title", emergency.getTitle())
 * .addParameter("description", emergency.getDescription())
 * .executeUpdate()
 * .getKey();
 * conn.commit();
 * return emergency;
 * 
 * } catch (Exception e) {
 * logger.severe("Error al crear emergencia: " + e.getMessage());
 * return null;
 * }
 * }
 * 
 * 
 * @Override
 * public List<EmergencyEntity> getAll(){
 * String sql = "SELECT * FROM emergencies";
 * 
 * try (Connection conn = sql2o.open()) {
 * return conn.createQuery(sql)
 * .executeAndFetch(EmergencyEntity.class);
 * 
 * } catch (Exception e) {
 * logger.severe("Error al obtener todas las emergencias: " + e.getMessage());
 * return Collections.emptyList();
 * }
 * }
 * public List<EmergencyEntity> getAllActive(){
 * String sql = "SELECT * FROM emergencies WHERE status = true";
 * 
 * try (Connection conn = sql2o.open()) {
 * return conn.createQuery(sql)
 * .executeAndFetch(EmergencyEntity.class);
 * 
 * } catch (Exception e) {
 * logger.severe("Error al obtener todas las emergencias: " + e.getMessage());
 * return Collections.emptyList();
 * }
 * }
 * 
 * @Override
 * public EmergencyEntity getById(long id){
 * String sql = "SELECT * FROM emergencies WHERE emergency_id = :emergency_id";
 * 
 * try (Connection conn = sql2o.open()) {
 * return conn.createQuery(sql)
 * .addParameter("emergency_id", id)
 * .executeAndFetchFirst(EmergencyEntity.class);
 * 
 * } catch (Exception e) {
 * logger.severe("Error al obtener emergencia por id: " + e.getMessage());
 * return null;
 * }
 * 
 * }
 * 
 * @Override
 * public boolean update(EmergencyEntity emergency){
 * String sql =
 * "UPDATE emergencies SET status = :status, title = :title, description = :description "
 * +
 * "WHERE emergency_id = :emergency_id";
 * 
 * try (Connection conn = sql2o.open()) {
 * conn.createQuery(sql)
 * .addParameter("state", emergency.isStatus())
 * .addParameter("title", emergency.getTitle())
 * .addParameter("description", emergency.getDescription())
 * .addParameter("emergency_id", emergency.getemergency_id())
 * .executeUpdate();
 * conn.commit();
 * return true;
 * 
 * } catch (Exception e) {
 * logger.severe("Error al actualizar emergencia: " + e.getMessage());
 * return false;
 * }
 * }
 * 
 * @Override
 * public boolean delete(long id){
 * String sql = "DELETE FROM emergencies WHERE emergency_id = :emergency_id";
 * 
 * try (Connection conn = sql2o.open()) {
 * conn.createQuery(sql)
 * .addParameter("emergency_id", id)
 * .executeUpdate();
 * conn.commit();
 * return true;
 * 
 * } catch (Exception e) {
 * logger.severe("Error al eliminar emergencia: " + e.getMessage());
 * return false;
 * }
 * }
 * 
 * @Override
 * public List<EmergencyEntity> getAllClosed(){
 * try (Connection connection = sql2o.open()) {
 * String sql = "SELECT e.* FROM emergencies e WHERE e.status = false";
 * 
 * return connection.createQuery(sql)
 * .executeAndFetch(EmergencyEntity.class);
 * 
 * } catch (Exception exception) {
 * logger.severe("Error al obtener emergencias finalizadas: " +
 * exception.getMessage());
 * return Collections.emptyList();
 * }
 * }
 * 
 * @Override
 * public List<EmergencyEntity> encontrarEmergenciasFinalizadas(){
 * try (Connection connection = sql2o.open()) {
 * String sql =
 * "SELECT e.idEmergencia, COUNT(DISTINCT t.idTarea) AS cantidadTareas, COUNT(DISTINCT va.rutVoluntario) AS cantidadVoluntarios "
 * +
 * "FROM Emergencia e " +
 * "LEFT JOIN Tarea t ON e.idEmergencia = t.idEmergencia " +
 * "LEFT JOIN VoluntarioAtributo va ON t.rutVoluntario = va.rutVoluntario " +
 * "WHERE e.estadoEmergencia = true " +
 * "GROUP BY e.idEmergencia";
 * 
 * return connection.createQuery(sql)
 * .executeAndFetch(EmergencyEntity.class);
 * } catch (Exception exception) {
 * logger.severe("Error al obtener emergencias finalizadas: " +
 * exception.getMessage());
 * return Collections.emptyList();
 * }
 * }
 * 
 * }
 */