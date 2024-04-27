package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.EmergencyEntity;
import G1TBD.LABTBD.repositories.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmergencyService {

    @Autowired
    private EmergencyRepository emergencyRepository;
    @Autowired
    private TaskService taskService;

    public EmergencyEntity create(EmergencyEntity emergency) {
        return emergencyRepository.create(emergency);
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

    public boolean update(EmergencyEntity emergency) {
        return emergencyRepository.update(emergency);
    }

    public boolean delete(long id) {
        return emergencyRepository.delete(id);
    }

    public List<EmergencyEntity> getAllClosed() {
        return emergencyRepository.getAllClosed();
    }

    /*

    // Funcionalidad SQL 48
    public List<SingleEmergencyData> getEveryEmergencyData() {
        List<EmergencyEntity> closedEmergencies = getAllClosed();
        List<SingleEmergencyData> singleEmergencyDataList = new ArrayList<>();

        for (EmergencyEntity emergency : closedEmergencies) {
            long idEmergency = emergency.getIdEmergency();
            List<TaskEntity> taskList = taskService.getByEmergencyId(idEmergency);
            List<VolunteerEntity> volunteerList = volunteerService.getByEmergencyId(idEmergency);

            SingleEmergencyData singleEmergencyData = new SingleEmergencyData(emergency.getTitle(), volunteerList.size(), taskList.size());
            singleEmergencyDataList.add(singleEmergencyData);
        }

        return singleEmergencyDataList;
    }

     */

}
