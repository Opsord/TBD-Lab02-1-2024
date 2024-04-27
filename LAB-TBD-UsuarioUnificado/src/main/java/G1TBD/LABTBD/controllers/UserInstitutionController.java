package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.UserInstitutionEntity;
import G1TBD.LABTBD.services.UserInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user-institution")
@CrossOrigin(origins = "http://localhost:8090/api/user-institution")
public class UserInstitutionController {

    private final UserInstitutionService userInstitutionService;
    private static final Logger logger = Logger.getLogger(UserInstitutionController.class.getName());

    @Autowired
    public UserInstitutionController(UserInstitutionService userInstitutionService) {
        this.userInstitutionService = userInstitutionService;
    }

    @PostMapping("/create")
    public String create(@RequestBody UserInstitutionEntity userInstitution) {
        logger.info("Creating user institution: " + userInstitution.toString());
        userInstitutionService.create(userInstitution);
        return "redirect:/api/user-institution";
    }

    @RequestMapping("/all")
    public List<UserInstitutionEntity> getAll() {
        return userInstitutionService.getAll();
    }

    @RequestMapping("/rut/{rut}")
    public UserInstitutionEntity getByRut(@PathVariable String rut) {
        return userInstitutionService.getByRut(rut);
    }

    @RequestMapping("/institution-id/{institutionId}")
    public List<UserInstitutionEntity> getByInstitutionId(@PathVariable long institutionId) {
        return userInstitutionService.getByInstitutionId(institutionId);
    }

    @RequestMapping("/update")
    public boolean update(@RequestBody UserInstitutionEntity userInstitution) {
        return userInstitutionService.update(userInstitution);
    }

    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return userInstitutionService.delete(id);
    }

}
