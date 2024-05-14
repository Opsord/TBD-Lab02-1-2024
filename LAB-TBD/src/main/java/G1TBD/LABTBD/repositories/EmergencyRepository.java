package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.EmergencyEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyRepository extends CrudRepository<EmergencyEntity, Long> {

        @Query(value = "INSERT INTO emergencies (title, description, status, coordinator, location) " +
                        "VALUES (:title, :description, :status, :coordinator, :location)", nativeQuery = true)
        @Modifying
        @Transactional
        void create(@Param("title") String title, @Param("description") String description,
                        @Param("status") boolean status, @Param("coordinator") String coordinator, @Param("location") Long location);

        @Query(value = "SELECT * FROM emergencies", nativeQuery = true)
        List<EmergencyEntity> getAll();

        @Query(value = "SELECT * FROM emergencies WHERE emergency_id = :emergency_id ", nativeQuery = true)
        EmergencyEntity getById(@Param("emergency_id") long id );

        @Query(value = "SELECT * FROM emergencies WHERE status = true", nativeQuery = true)
        List<EmergencyEntity> getAllActive();

        @Query(value = "SELECT * FROM emergencies WHERE status = false", nativeQuery = true)
        List<EmergencyEntity> getAllClosed();

        @Query(value = "UPDATE emergencies SET title = :title, description = :description, " +
                        "status = :status, coordinator = :coordinator WHERE emergency_id = :emergency_id ", nativeQuery = true)
        @Modifying
        @Transactional
        void update(@Param("emergency_id ") long emergency_id , @Param("title") String title, @Param("description") String description,
                        @Param("status") boolean status, @Param("coordinator") String coordinator);

        @Query(value = "DELETE FROM emergencies WHERE emergency_id = :emergency_id ", nativeQuery = true)
        @Modifying
        @Transactional
        void delete(@Param("emergency_id") long emergency_id);

        // Get emergency by location
        @Query(value = "SELECT * FROM emergencies " +
                "WHERE location = " +
                "(SELECT point_id FROM points WHERE latitude = :latitude AND longitude = :longitude)", nativeQuery = true)
        EmergencyEntity getByLocation(@Param("latitude") double latitude, @Param("longitude") double longitude);

}