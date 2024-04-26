package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import G1TBD.LABTBD.services.EmergencyAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencyAttribute")
@CrossOrigin(origins = "http://localhost:8090/emergencyAttribute")
public class EmergencyAttributeController {

    @Autowired
    private EmergencyAttributeService emergencyAttributeService;

    String homeLinkRedirect = "redirect:/emergencyAttribute";

    @PostMapping("/create")
    public String create(@RequestBody EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeService.create(emergencyAttribute);
        return homeLinkRedirect;
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
    public boolean update(@RequestBody EmergencyAttributeEntity emergencyAttribute) {
        return emergencyAttributeService.update(emergencyAttribute);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return emergencyAttributeService.delete(id);
    }

}
