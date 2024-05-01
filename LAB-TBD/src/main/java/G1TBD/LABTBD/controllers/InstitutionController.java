package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.InstitutionEntity;
import G1TBD.LABTBD.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institutions")
@CrossOrigin(origins = "http://localhost:8090/institutions")
public class InstitutionController {

    private final InstitutionService institutionService;

    @Autowired
    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    String homeLinkRedirect = "redirect:/institutions";

    @PostMapping("/create")
    public String create(@RequestBody InstitutionEntity institution) {
        institutionService.create(institution);
        return homeLinkRedirect;
    }

    @GetMapping("/all")
    public List<InstitutionEntity> getAll() {
        return institutionService.getAll();
    }

    @GetMapping("/id/{id}")
    public InstitutionEntity getById(@PathVariable long id) {
        return institutionService.getById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody InstitutionEntity institution) {
        return institutionService.update(institution);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return institutionService.delete(id);
    }
}
