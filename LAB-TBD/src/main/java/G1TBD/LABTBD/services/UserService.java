package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.UserEntity;
import G1TBD.LABTBD.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity user) {
        return userRepository.create(user);
    }

    public List<UserEntity> getAll() {
        return userRepository.getAll();
    }

    public Optional<UserEntity> getByRut(String rut) {
        return userRepository.getByRut(rut);
    }

    public Optional<UserEntity> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public boolean update(UserEntity user) {
        return userRepository.update(user);
    }

    public boolean delete(String rut) {
        return userRepository.delete(rut);
    }

    public List<UserEntity> getByRole(String role) {
        return userRepository.getByRole(role);
    }

    public List<UserEntity> getVolunteers() {
        return userRepository.getVolunteers();
    }

    public List<UserEntity> getCoordinators() {
        return userRepository.getCoordinators();
    }

    public List<UserEntity> getByAvailability(boolean availability) {
        return userRepository.getByAvailability(availability);
    }

}
