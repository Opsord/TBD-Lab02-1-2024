package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.TaskEntity;
import G1TBD.LABTBD.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private static final Logger logger = Logger.getLogger(TaskService.class.getName());

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void create(TaskEntity task) {
        taskRepository.create(
                task.getEmergency().getEmergency_id(),
                task.getType(),
                task.getDescription(),
                task.isState());
        logger.info("Task created");
    }

    public List<TaskEntity> getAll() {
        return taskRepository.getAll();
    }

    public TaskEntity getById(long id) {
        return taskRepository.getById(id);
    }

    public List<TaskEntity> getByemergency_id(long id) {
        return taskRepository.getByEmergencyId(id);
    }

    public void update(TaskEntity task) {
        taskRepository.update(
                task.getTask_id(),
                task.getEmergency().getEmergency_id(),
                task.getType(),
                task.getDescription(),
                task.isState());
        logger.info("Task updated");
    }

    public void delete(long id) {
        taskRepository.delete(id);
        logger.info("Task deleted");
    }

}
