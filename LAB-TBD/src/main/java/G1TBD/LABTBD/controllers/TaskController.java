package G1TBD.LABTBD.controllers;

import G1TBD.LABTBD.entities.TaskEntity;
import G1TBD.LABTBD.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    String homeLinkRedirect = "redirect:/tareas";

    @PostMapping("/crear")
    public String create(@RequestBody TaskEntity task) {
        taskService.create(task);
        return homeLinkRedirect;
    }

    @GetMapping("/todo")
    public List<TaskEntity> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/porId/{id}")
    public TaskEntity getById(@PathVariable long id) {
        return taskService.getById(id);
    }


    @GetMapping("/porIdEmergencia/{id}")
    public List<TaskEntity> getByEmergencyId(@PathVariable long id) {
        return taskService.getByEmergencyId(id);
    }

    @PutMapping("/actualizar")
    public boolean update(@RequestBody TaskEntity task) {
        return taskService.update(task);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean delete(@PathVariable long id) {
        return taskService.delete(id);
    }

}
