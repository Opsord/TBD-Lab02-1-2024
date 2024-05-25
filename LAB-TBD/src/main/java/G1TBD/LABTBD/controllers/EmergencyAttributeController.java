package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.AttributeEntity;
import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import G1TBD.LABTBD.entities.EmergencyEntity;
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
    //--------------------------CREATE--------------------------
    @PostMapping("/create")
    public void create(@RequestBody EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeService.create(emergencyAttribute);
        logger.info("EmergencyAttribute created: ");
        logger.info(emergencyAttribute.toString());
    }

    @PostMapping("/createVarious/{emergencyID}")
    public ResponseEntity<List<EmergencyAttributeEntity>> linkAttributesToEmergency(
            @PathVariable long emergencyID,
            @RequestBody List<AttributeEntity> attributes
    ) {
        List<EmergencyAttributeEntity> emergencyAttributeList = emergencyAttributeService.linkAttributesToEmergency(emergencyID, attributes);
        logger.info("EmergencyAttribute created: ");
        logger.info(emergencyAttributeList.toString());
        return new ResponseEntity<>(emergencyAttributeList, HttpStatus.CREATED);
    }


    //--------------------------UPDATE--------------------------
    @PutMapping("/update")
    public void update(@RequestBody EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeService.update(emergencyAttribute);
        logger.info("EmergencyAttribute updated: ");
        logger.info(emergencyAttribute.toString());
    }


    //---------------------------READ---------------------------
    @GetMapping("/all")
    public List<EmergencyAttributeEntity> getAll(){return emergencyAttributeService.getAll();}

    @GetMapping("/id/{id}")
    public EmergencyAttributeEntity getById(@PathVariable long id){return emergencyAttributeService.getById(id);}


    //--------------------------DELETE--------------------------
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        emergencyAttributeService.delete(id);
        logger.info("EmergencyAttribute deleted: ");
        logger.info(String.valueOf(id));
    }

}
