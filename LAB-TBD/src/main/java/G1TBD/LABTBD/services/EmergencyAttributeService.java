package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import G1TBD.LABTBD.repositories.EmergencyAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmergencyAttributeService {
    
    private final EmergencyAttributeRepository emergencyAttributeRepository;

    @Autowired
    public EmergencyAttributeService(EmergencyAttributeRepository emergencyAttributeRepository) {
        this.emergencyAttributeRepository = emergencyAttributeRepository;
    }

    public EmergencyAttributeEntity create(EmergencyAttributeEntity emergencyAttribute) {
        return emergencyAttributeRepository.create(emergencyAttribute);
    }

    public List<EmergencyAttributeEntity> createVarious(List<EmergencyAttributeEntity> emergencyAttributeEntityList) {
        List<EmergencyAttributeEntity> createdEmergencies = new ArrayList<>();
        for (EmergencyAttributeEntity emergencyAttribute : emergencyAttributeEntityList) {
            EmergencyAttributeEntity createdEmergency = create(emergencyAttribute);
            createdEmergencies.add(createdEmergency);
        }
        return createdEmergencies;
    }

    public List<EmergencyAttributeEntity> getAll() {
        return emergencyAttributeRepository.getAll();
    }

    public EmergencyAttributeEntity getById(long id) {
        return emergencyAttributeRepository.getById(id);
    }

    public boolean update(EmergencyAttributeEntity emergencyAttribute) {
        return emergencyAttributeRepository.update(emergencyAttribute);
    }

    public boolean delete(long id) {
        return emergencyAttributeRepository.delete(id);
    }
}
