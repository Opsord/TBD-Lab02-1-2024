package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import G1TBD.LABTBD.services.EmergencyAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergenciaAtributo")
@CrossOrigin
public class EmergencyAttributeController {

    @Autowired
    private EmergencyAttributeService emergencyAttributeService;

    String homeLinkRedirect = "redirect:/emergenciaAtributo";

    @PostMapping("/crear")
    public String create(@RequestBody EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeService.create(emergencyAttribute);
        return homeLinkRedirect;
    }

    @PostMapping("/crearVarios")
    public ResponseEntity<List<EmergencyAttributeEntity>> createVarious(@RequestBody List<EmergencyAttributeEntity> emergencyAttributeListRequest) {
        List<EmergencyAttributeEntity> emergencyAttributeList = emergencyAttributeService.createVarious(emergencyAttributeListRequest);
        if (emergencyAttributeList != null && !emergencyAttributeList.isEmpty()) {
            return new ResponseEntity<>(emergencyAttributeList, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todo")
    public List<EmergencyAttributeEntity> getAll() {
        return emergencyAttributeService.getAll();
    }

    @GetMapping("/porId/{id}")
    public EmergencyAttributeEntity getById(@PathVariable long id) {
        return emergencyAttributeService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean update(@RequestBody EmergencyAttributeEntity emergenciaAtributo) {
        return emergencyAttributeService.update(emergenciaAtributo);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean delete(@PathVariable long id) {
        return emergencyAttributeService.delete(id);
    }

}
