package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import G1TBD.LABTBD.services.EmergencyAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/emergencyAttribute")
@CrossOrigin(origins = "http://localhost:8090/emergencyAttribute")
public class EmergencyAttributeController {

    private final EmergencyAttributeService emergencyAttributeService;
    private static final Logger logger = Logger.getLogger(EmergencyAttributeController.class.getName());

    @Autowired
    public EmergencyAttributeController(EmergencyAttributeService emergencyAttributeService) {
        this.emergencyAttributeService = emergencyAttributeService;
    }

    @PostMapping("/create")
    public void create(@RequestBody EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeService.create(emergencyAttribute);
        logger.info("EmergencyAttribute created: ");
        logger.info(emergencyAttribute.toString());
    }

    @PostMapping("/createVarious")
    public ResponseEntity<List<EmergencyAttributeEntity>> createVarious(
            @RequestBody List<EmergencyAttributeEntity> emergencyAttributeListRequest) {
        List<EmergencyAttributeEntity> emergencyAttributeList = emergencyAttributeService
                .createVarious(emergencyAttributeListRequest);
        if (emergencyAttributeList != null && !emergencyAttributeList.isEmpty()) {
            return new ResponseEntity<>(emergencyAttributeList, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public List<EmergencyAttributeEntity> getAll() {
        return emergencyAttributeService.getAll();
    }

    @GetMapping("/id/{id}")
    public EmergencyAttributeEntity getById(@PathVariable long id) {
        return emergencyAttributeService.getById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeService.update(emergencyAttribute);
        logger.info("EmergencyAttribute updated: ");
        logger.info(emergencyAttribute.toString());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        emergencyAttributeService.delete(id);
        logger.info("EmergencyAttribute deleted: ");
        logger.info(String.valueOf(id));
    }

}
