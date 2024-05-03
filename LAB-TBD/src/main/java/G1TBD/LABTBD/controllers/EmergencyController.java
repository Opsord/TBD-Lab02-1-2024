package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.data.SingleEmergencyData;
import G1TBD.LABTBD.entities.EmergencyEntity;
import G1TBD.LABTBD.services.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/emergencies")
@CrossOrigin(origins = "http://localhost:8090/emergencies")
public class EmergencyController {

    private final EmergencyService emergencyService;
    private static final Logger logger = Logger.getLogger(EmergencyController.class.getName());

    @Autowired
    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    String homeLinkRedirect = "redirect:/emergencies";

    @PostMapping("/create")
    public String create(@RequestBody EmergencyEntity emergency) {
        emergencyService.create(emergency);
        logger.info("Emergency created: ");
        logger.info(emergency.toString());
        return homeLinkRedirect;
    }

    @GetMapping("/all")
    public List<EmergencyEntity> getAll() {
        return emergencyService.getAll();
    }

    @GetMapping("/active")
    public List<EmergencyEntity> getAllActive() {
        return emergencyService.getAllActive();
    }

    @GetMapping("/id/{id}")
    public EmergencyEntity getById(@PathVariable long id) {
        return emergencyService.getById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody EmergencyEntity emergency) {
        emergencyService.update(emergency);
        logger.info("Emergency updated: ");
        logger.info(emergency.toString());
        return homeLinkRedirect;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        emergencyService.delete(id);
        logger.info("Emergency deleted: ");
        logger.info(String.valueOf(id));
        return homeLinkRedirect;
    }

    @GetMapping("/closed")
    public List<EmergencyEntity> getClosedEmergencies() {
        return emergencyService.getAllClosed();
    }

    /*

    @GetMapping("/data")
    public List<SingleEmergencyData> getEveryEmergencyData() {
        return emergencyService.getEveryEmergencyData();
    }

    */

}
