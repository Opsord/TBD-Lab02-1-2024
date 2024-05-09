package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

    @Query(value = "INSERT INTO users (rut, email, name, lastname, birthdate, sex, password, role, availability) " +
            "VALUES (:rut, :email, :name, :lastname, :birthdate, :sex, :password, :role, :availability)", nativeQuery = true)
    @Modifying
    @Transactional
    void create(@Param("rut") String rut, @Param("email") String email, @Param("name") String name,
                @Param("lastname") String lastname, @Param("birthdate") Date birthdate, @Param("sex") String sex,
                @Param("password") String password, @Param("role") String role,
                @Param("availability") boolean availability);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserEntity> getAll();

    @Query(value = "SELECT * FROM users WHERE rut = :rut", nativeQuery = true)
    Optional<UserEntity> getByRut(@Param("rut") String rut);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> getByEmail(@Param("email") String email);

    @Query(value = "UPDATE users SET email = :email, name = :name, lastname = :lastname, birthdate = :birthdate, " +
            "sex = :sex, password = :password, role = :role, availability = :availability " +
            "WHERE rut = :rut", nativeQuery = true)
    @Modifying
    @Transactional
    void update(@Param("rut") String rut, @Param("email") String email, @Param("name") String name,
                   @Param("lastname") String lastname, @Param("birthdate") Date birthdate, @Param("sex") String sex,
                   @Param("password") String password, @Param("role") String role,
                   @Param("availability") boolean availability);

    @Query(value = "DELETE FROM users WHERE rut = :rut", nativeQuery = true)
    @Modifying
    @Transactional
    void delete(@Param("rut") String rut);

    @Query(value = "SELECT * FROM users WHERE role = :role", nativeQuery = true)
    List<UserEntity> getByRole(@Param("role") String role);

    @Query(value = "SELECT * FROM users WHERE availability = :availability", nativeQuery = true)
    List<UserEntity> getByAvailability(@Param("availability") boolean availability);

    @Query(value = "SELECT * FROM users WHERE role = 'VOLUNTEER'", nativeQuery = true)
    List<UserEntity> getVolunteers();

    @Query(value = "SELECT * FROM users WHERE role = 'COORDINATOR'", nativeQuery = true)
    List<UserEntity> getCoordinators();

    @Query(value = "SELECT * FROM users " +
            "WHERE location = " +
            "(SELECT point_id FROM points WHERE latitude = :latitude AND longitude = :longitude)", nativeQuery = true)
    UserEntity getByLocation(@Param("latitude") double latitude, @Param("longitude") double longitude);

    @Query(value = "SELECT * FROM users " +
            "WHERE ST_DWithin (location, 'POINT(:latitude :longitude)', :radius) " +
            "AND role = :role " +
            "AND availability = :availability " +
            "LIMIT :limit", nativeQuery = true)
    List<UserEntity> getXNearbyUsers(@Param("latitude") double latitude, @Param("longitude") double longitude,
                                     @Param("radius") double radius, @Param("limit") int limit,
                                     @Param("role") String role, @Param("availability") boolean availability);

}