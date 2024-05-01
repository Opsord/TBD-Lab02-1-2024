package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserEntity create(UserEntity user);

    List<UserEntity> getAll();

    Optional<UserEntity> getByRut(String rut);

    Optional<UserEntity> getByEmail(String email);

    boolean update(UserEntity user);

    boolean delete(String rut);

    List<UserEntity> getByRole(String role);

    List<UserEntity> getByAvailability(boolean availability);

    List<UserEntity> getVolunteers();

    List<UserEntity> getCoordinators();

}
