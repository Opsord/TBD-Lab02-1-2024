package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.AttributeEntity;
import G1TBD.LABTBD.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attributes")
@CrossOrigin(origins = "http://localhost:8090/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    String homeLinkRedirect = "redirect:/attributes";

    @PostMapping("/create")
    public String create(@RequestBody AttributeEntity attribute) {
        attributeService.create(attribute);
        return homeLinkRedirect;
    }

    @GetMapping("/all")
    public List<AttributeEntity> getAll() {
        return attributeService.getAll();
    }

    @GetMapping("/id/{id}")
    public AttributeEntity getById(@PathVariable long id) {
        return attributeService.getById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody AttributeEntity attribute) {
        return attributeService.update(attribute);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return attributeService.delete(id);
    }

}
