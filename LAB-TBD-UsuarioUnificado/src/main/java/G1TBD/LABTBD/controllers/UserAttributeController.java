package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.UserAttributeEntity;
import G1TBD.LABTBD.services.UserAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user-attribute")
@CrossOrigin(origins = "http://localhost:8090/api/user-attribute")
public class UserAttributeController {

    private final UserAttributeService userAttributeService;
    private static final Logger logger = Logger.getLogger(UserAttributeController.class.getName());

    @Autowired
    public UserAttributeController(UserAttributeService userAttributeService) {
        this.userAttributeService = userAttributeService;
    }

    @PostMapping("/create")
    public String create(@RequestBody UserAttributeEntity userAttribute) {
        logger.info("Creating user attribute: " + userAttribute.toString());
        userAttributeService.create(userAttribute);
        return "redirect:/api/user-attribute";
    }

    @GetMapping("/all")
    public List<UserAttributeEntity> getAll() {
        return userAttributeService.getAll();
    }

    @GetMapping("/rut/{rut}")
    public List<UserAttributeEntity> getByRut(@PathVariable String rut) {
        return userAttributeService.getByRut(rut);
    }

    @GetMapping("/attribute-id/{attributeId}")
    public List<UserAttributeEntity> getByAttributeId(@PathVariable long attributeId) {
        return userAttributeService.getByAttributeId(attributeId);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody UserAttributeEntity userAttribute) {
        return userAttributeService.update(userAttribute);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return userAttributeService.delete(id);
    }

}
