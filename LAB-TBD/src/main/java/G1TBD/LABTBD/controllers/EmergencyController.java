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
@RequestMapping("/emergencias")
@CrossOrigin(origins = "http://localhost:8090/emergencias")
public class EmergencyController {

    @Autowired
    private EmergencyService emergencyService;


    @PostMapping("/crear")
    public ResponseEntity<EmergencyEntity> create(@RequestBody EmergencyEntity emergency) {
        EmergencyEntity newEmergency = emergencyService.create(emergency);
        return new ResponseEntity<>(newEmergency, HttpStatus.CREATED);
    }

    @GetMapping("/todo")
    public List<EmergencyEntity> getAll() {
        return emergencyService.getAll();
    }

    @GetMapping("/activas")
    public List<EmergencyEntity> getAllActive() {
        return emergencyService.getAllActive();
    }

    @GetMapping("/porId/{id}")
    public EmergencyEntity getById(@PathVariable long id) {
        return emergencyService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean update(@RequestBody EmergencyEntity emergencia) {
        return emergencyService.update(emergencia);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean delete(@PathVariable Long id) {
        return emergencyService.delete(id);
    }

    @GetMapping("/finalizadas")
    public List<EmergencyEntity> getClosedEmergencies() {
        return emergencyService.getClosedEmergencies();
    }

    @GetMapping("/datosEmergencias")
    public List<SingleEmergencyData> getEveryEmergencyData() {
        return emergencyService.getEveryEmergencyData();
    }

}
