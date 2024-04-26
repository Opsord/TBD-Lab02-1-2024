package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.VolunteerEntity;
import G1TBD.LABTBD.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
@CrossOrigin(origins = "http://localhost:8090/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    String homeLinkRedirect = "redirect:/volunteers";

    @PostMapping("/create")
    public String create(@RequestBody VolunteerEntity volunteer) {
        volunteerService.create(volunteer);
        return homeLinkRedirect;
    }

    @GetMapping("/all")
    public List<VolunteerEntity> getAll() {
        return volunteerService.getAll();
    }

    @GetMapping("/rut/{rut}")
    public VolunteerEntity getByRut(@PathVariable String rut) {
        return volunteerService.getByRut(rut);
    }

    @GetMapping("/email/{email}")
    public VolunteerEntity getByEmail(@PathVariable String email) {
        return volunteerService.getByEmail(email);
    }

    @GetMapping("/id/{id}")
    public VolunteerEntity getById(@PathVariable long id) {
        return volunteerService.getById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody VolunteerEntity volunteer) {
        return volunteerService.update(volunteer);
    }

    @DeleteMapping("/delete/{rut}")
    public boolean delete(@PathVariable String rut) {
        return volunteerService.delete(rut);
    }

}
