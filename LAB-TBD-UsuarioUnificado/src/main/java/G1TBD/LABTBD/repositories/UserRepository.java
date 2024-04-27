package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.UserEntity;

import java.util.List;

public interface UserRepository {

    UserEntity create(UserEntity user);

    List<UserEntity> getAll();

    UserEntity getByRut(String rut);

    boolean update(UserEntity user);

    boolean delete(String rut);

    List<UserEntity> getByRole(String role);

    List<UserEntity> getByAvailability(boolean availability);

    List<UserEntity> getVolunteers();

    List<UserEntity> getCoordinators();
}
