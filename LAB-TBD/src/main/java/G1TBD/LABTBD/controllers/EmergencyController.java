package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.data.SingleEmergencyData;
import G1TBD.LABTBD.entities.EmergencyEntity;
import G1TBD.LABTBD.services.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencies")
@CrossOrigin(origins = "http://localhost:8090/emergencies")
public class EmergencyController {

    private final EmergencyService emergencyService;

    @Autowired
    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmergencyEntity> create(@RequestBody EmergencyEntity emergency) {
        EmergencyEntity newEmergency = emergencyService.create(emergency);
        return new ResponseEntity<>(newEmergency, HttpStatus.CREATED);
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
    public boolean update(@RequestBody EmergencyEntity emergency) {
        return emergencyService.update(emergency);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return emergencyService.delete(id);
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
