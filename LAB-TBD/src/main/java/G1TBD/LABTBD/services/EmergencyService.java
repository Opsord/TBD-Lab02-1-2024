package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.EmergencyEntity;
import G1TBD.LABTBD.repositories.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class EmergencyService {

    private final EmergencyRepository emergencyRepository;
    private final TaskService taskService;
    private static final Logger logger = Logger.getLogger(EmergencyService.class.getName());

    @Autowired
    public EmergencyService(EmergencyRepository emergencyRepository, TaskService taskService) {
        this.emergencyRepository = emergencyRepository;
        this.taskService = taskService;
    }

    public void create(EmergencyEntity emergency) {
        emergencyRepository.create(
                emergency.getTitle(),
                emergency.getDescription(),
                emergency.isStatus(),
                emergency.getCoordinator().getRut());
        logger.info("Emergency created: " + emergency.getTitle());
    }

    public List<EmergencyEntity> getAll() {
        return emergencyRepository.getAll();
    }

    public List<EmergencyEntity> getAllActive() {
        return emergencyRepository.getAllActive();
    }

    public EmergencyEntity getById(long id) {
        return emergencyRepository.getById(id);
    }

    public void update(EmergencyEntity emergency) {
        emergencyRepository.update(
                emergency.getEmergency_id(),
                emergency.getTitle(),
                emergency.getDescription(),
                emergency.isStatus(),
                emergency.getCoordinator().getRut());
        logger.info("Emergency updated: " + emergency.getTitle());
    }

    public void delete(long id) {
        emergencyRepository.delete(id);
        logger.info("Emergency deleted: " + id);
    }

    public List<EmergencyEntity> getAllClosed() {
        return emergencyRepository.getAllClosed();
    }

    /*
     * 
     * // Funcionalidad SQL 48
     * public List<SingleEmergencyData> getEveryEmergencyData() {
     * List<EmergencyEntity> closedEmergencies = getAllClosed();
     * List<SingleEmergencyData> singleEmergencyDataList = new ArrayList<>();
     * 
     * for (EmergencyEntity emergency : closedEmergencies) {
     * long emergency_id = emergency.getemergency_id();
     * List<TaskEntity> taskList = taskService.getByemergency_id(emergency_id);
     * List<VolunteerEntity> volunteerList =
     * volunteerService.getByemergency_id(emergency_id);
     * 
     * SingleEmergencyData singleEmergencyData = new
     * SingleEmergencyData(emergency.getTitle(), volunteerList.size(),
     * taskList.size());
     * singleEmergencyDataList.add(singleEmergencyData);
     * }
     * 
     * return singleEmergencyDataList;
     * }
     * 
     */

}
