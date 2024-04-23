package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.InstitutionEntity;
import G1TBD.LABTBD.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institucion")
@CrossOrigin
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    String homeLinkRedirect = "redirect:/instituciones";

    @PostMapping("/crear")
    public String create(@RequestBody InstitutionEntity institution) {
        institutionService.create(institution);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<InstitutionEntity> getAll() {
        return institutionService.getAll();
    }

    @GetMapping("/porId/{id}")
    public InstitutionEntity getById(@PathVariable long id) {
        return institutionService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean update(@RequestBody InstitutionEntity institution) {
        return institutionService.update(institution);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean delete(@PathVariable long id) {
        return institutionService.delete(id);
    }
}
