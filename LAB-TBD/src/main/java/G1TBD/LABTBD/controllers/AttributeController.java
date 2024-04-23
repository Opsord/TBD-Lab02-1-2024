package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.AttributeEntity;
import G1TBD.LABTBD.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atributos")
@CrossOrigin

public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    String homeLinkRedirect = "redirect:/atributos";

    @PostMapping("/crear")
    public String create(@RequestBody AttributeEntity attribute) {
        attributeService.create(attribute);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<AttributeEntity> getAll() {
        return attributeService.getAll();
    }

    @GetMapping("/porId/{id}")
    public AttributeEntity getById(@PathVariable long id) {
        return attributeService.getById(id);
    }

    @PutMapping("/actualizar")
    public boolean update(@RequestBody AttributeEntity attribute) {
        return attributeService.update(attribute);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean delete(@PathVariable long id) {
        return attributeService.delete(id);
    }

}
