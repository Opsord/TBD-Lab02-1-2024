package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.UserEntity;
import G1TBD.LABTBD.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8090/api/users")
public class UserController {

    private final UserService userService;
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String create(@RequestBody UserEntity user) {
        logger.info("Creating user: " + user.toString());
        userService.create(user);
        return "redirect:/api/users";
    }

    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return userService.getAll();
    }

    @GetMapping("/rut/{rut}")
    public UserEntity getByRut(@PathVariable String rut) {
        return userService.getByRut(rut);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody UserEntity user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete/{rut}")
    public boolean delete(@PathVariable String rut) {
        return userService.delete(rut);
    }

    @GetMapping("/role/{role}")
    public List<UserEntity> getByRole(@PathVariable String role) {
        return userService.getByRole(role);
    }

    @GetMapping("/availability/{availability}")
    public List<UserEntity> getByAvailability(@PathVariable boolean availability) {
        return userService.getByAvailability(availability);
    }

    @GetMapping("/volunteers")
    public List<UserEntity> getVolunteers() {
        return userService.getVolunteers();
    }

    @GetMapping("/coordinators")
    public List<UserEntity> getCoordinators() {
        return userService.getCoordinators();
    }

}
