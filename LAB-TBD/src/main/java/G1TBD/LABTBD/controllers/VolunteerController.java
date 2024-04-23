package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VolunteerEntity;
import G1TBD.LABTBD.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
@CrossOrigin(origins = "http://localhost:8090/voluntarios")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    String homeLinkRedirect = "redirect:/voluntarios";

    @PostMapping("/crear")
    public String create(@RequestBody VolunteerEntity volunteer) {
        volunteerService.create(volunteer);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<VolunteerEntity> getAll() {
        return volunteerService.getAll();
    }

    @GetMapping("/porRut/{rut}")
    public VolunteerEntity getByRut(@PathVariable String rut) {
        return volunteerService.getByRut(rut);
    }

    @GetMapping("/porEmail/{email}")
    public VolunteerEntity getByEmail(@PathVariable String email) {
        return volunteerService.getByEmail(email);
    }

    @GetMapping("/porId/{id}")
    public VolunteerEntity getById(@PathVariable long id) {
        return volunteerService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean update(@RequestBody VolunteerEntity volunteer) {
        return volunteerService.update(volunteer);
    }

    @DeleteMapping("/eliminar/{rut}")
    public boolean delete(@PathVariable String rut) {
        return volunteerService.delete(rut);
    }

}
