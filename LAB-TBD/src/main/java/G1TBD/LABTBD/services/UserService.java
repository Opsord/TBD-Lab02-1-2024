package G1TBD.LABTBD.services;

import G1TBD.LABTBD.data.point.PointRepository;
import G1TBD.LABTBD.data.point.PointService;
import G1TBD.LABTBD.entities.UserEntity;
import G1TBD.LABTBD.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PointService pointService;
    private static final Logger logger = Logger.getLogger(UserService.class.getName());
    private final PointRepository pointRepository;

    @Autowired
    public UserService(UserRepository userRepository, PointService pointService, PointRepository pointRepository) {
        this.userRepository = userRepository;
        this.pointService = pointService;
        this.pointRepository = pointRepository;
    }

    public void create(UserEntity user) {
        userRepository.create(
                user.getRut(), user.getEmail(), user.getName(),
                user.getLastname(), user.getBirthdate(), user.getSex(),
                user.getPassword(), user.getRole(), user.isAvailability());
        logger.info("Usuario creado: " + user.getRut());
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

    public void update(UserEntity user) {
        userRepository.update(
                user.getRut(), user.getEmail(), user.getName(),
                user.getLastname(), user.getBirthdate(), user.getSex(),
                user.getPassword(), user.getRole(), user.isAvailability());
        logger.info("Usuario actualizado: " + user.getRut());
    }

    public void delete(String rut) {
        userRepository.delete(rut);
        logger.info("Usuario eliminado: " + rut);
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

    public List<UserEntity> getXNearbyVolunteers(double latitude, double longitude,
                                                 double radius, int quantity, String role, boolean availability) {
        return userRepository.getXNearbyUsers(latitude, longitude, radius, quantity, role, availability);
    }

}
