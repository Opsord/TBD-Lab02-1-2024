package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VolunteerAttributeEntity;
import G1TBD.LABTBD.services.VolunteerAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/voluntarioatributo")
@CrossOrigin(origins = "http://localhost:8090/voluntarioatributos")
public class VolunteerAttributeController {

    @Autowired
    private VolunteerAttributeService volunteerAttributeService;

    String homeLinkRedirect = "redirect:/voluntarioatributos";

    @PostMapping("/crear")
    public String create(@RequestBody VolunteerAttributeEntity volunteerAttribute) {
        volunteerAttributeService.create(volunteerAttribute);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VolunteerAttributeEntity> getAll() {
        return volunteerAttributeService.getAll();
    }

    @GetMapping("/porId/{id}")
    public VolunteerAttributeEntity getById(@PathVariable long id) {
        return volunteerAttributeService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean update(@RequestBody VolunteerAttributeEntity volunteerAttribute) {
        return volunteerAttributeService.update(volunteerAttribute);
    }

    @DeleteMapping("/eliminar{id}")
    public boolean delete(@PathVariable long id) {
        return volunteerAttributeService.delete(id);
    }
}
