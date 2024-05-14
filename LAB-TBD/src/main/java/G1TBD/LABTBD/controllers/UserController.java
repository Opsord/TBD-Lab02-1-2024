package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.data.point.PointEntity;
import G1TBD.LABTBD.data.point.PointService;
import G1TBD.LABTBD.entities.UserEntity;
import G1TBD.LABTBD.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8090/api/users")
public class UserController {

    private final UserService userService;

    private final PointService pointService;
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    public UserController(UserService userService, PointService pointService) {
        this.userService = userService;
        this.pointService = pointService;
    }

    String homeLinkRedirect = "redirect:/api/users";

    @PostMapping("/create")
    public String create(@RequestBody UserEntity user) {
        logger.info("Creating user: " + user.toString());
        userService.create(user);
        return homeLinkRedirect;
    }

    @GetMapping("/all")
    public List<UserEntity> getAll() {
        System.out.println("aaaaaaa");
        return userService.getAll();
    }

    @GetMapping("/rut/{rut}")
    public Optional<UserEntity> getByRut(@PathVariable String rut) {
        return userService.getByRut(rut);
    }

    @GetMapping("/email/{email}")
    public Optional<UserEntity> getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PutMapping("/update")
    public String update(@RequestBody UserEntity user) {
        userService.update(user);
        logger.info("User updated: " + user.toString());
        return homeLinkRedirect;
    }

    @DeleteMapping("/delete/{rut}")
    public String delete(@PathVariable String rut) {
        userService.delete(rut);
        logger.info("User deleted: " + rut);
        return homeLinkRedirect;
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


    @PutMapping("/updateLocation/{rut}")
    public void updateLocationByRut(@PathVariable String rut, @RequestBody PointEntity location) {
        userService.updateLocationByRut(location, rut);
    }

    //Actualizar punto
    @PutMapping("/point/update")
    public void updatePoint(@RequestBody PointEntity point) {
        pointService.update(point);
        logger.info("Point updated: " + point.getPoint());
    }

}


