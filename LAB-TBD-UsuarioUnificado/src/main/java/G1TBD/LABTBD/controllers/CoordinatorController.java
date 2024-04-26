package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.CoordinatorEntity;
import G1TBD.LABTBD.services.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/coordinators")
@CrossOrigin(origins = "http://localhost:8090/coordinators")
public class CoordinatorController {

    private static final Logger logger = Logger.getLogger(CoordinatorController.class.getName());

    @Autowired
    private CoordinatorService coordinatorService;

    String homeLinkRedirect = "redirect:/coordinators";

    @PostMapping("/create")
    public String create(@RequestBody CoordinatorEntity coordinator) {
        logger.info("Creando coordinador: " + coordinator.toString());
        coordinatorService.create(coordinator);
        return homeLinkRedirect;
    }

    @GetMapping("/all")
    public List<CoordinatorEntity> getAll() {
        return coordinatorService.getAll();
    }

    @GetMapping("/rut/{rut}")
    public CoordinatorEntity getByRut(@PathVariable String rut) {
        return coordinatorService.getByRut(rut);
    }

    @GetMapping("/email/{email}")
    public CoordinatorEntity getByEmail(@PathVariable String email) {
        return coordinatorService.getByEmail(email);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody CoordinatorEntity coordinator) {
        return coordinatorService.update(coordinator);
    }

    @DeleteMapping("/delete/{rut}")
    public boolean delete(@PathVariable String rut) {
        return coordinatorService.delete(rut);
    }
}
