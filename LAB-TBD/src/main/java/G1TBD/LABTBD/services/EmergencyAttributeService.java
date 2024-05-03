package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import G1TBD.LABTBD.repositories.EmergencyAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class EmergencyAttributeService {
    
    private final EmergencyAttributeRepository emergencyAttributeRepository;
    private static final Logger logger = Logger.getLogger(EmergencyAttributeService.class.getName());

    @Autowired
    public EmergencyAttributeService(EmergencyAttributeRepository emergencyAttributeRepository) {
        this.emergencyAttributeRepository = emergencyAttributeRepository;
    }

    public void create(EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeRepository.create(
                emergencyAttribute.getEmergency().getEmergency_id(),
                emergencyAttribute.getAttribute().getAttribute_id(),
                emergencyAttribute.isCompatibility()
        );
        logger.info("EmergencyAttribute created successfully");
    }

    public List<EmergencyAttributeEntity> createVarious(List<EmergencyAttributeEntity> emergencyAttributeEntityList) {
        List<EmergencyAttributeEntity> createdEmergencies = new ArrayList<>();
        for (EmergencyAttributeEntity emergencyAttribute : emergencyAttributeEntityList) {
            create(emergencyAttribute);
            createdEmergencies.add(emergencyAttribute);
        }
        return createdEmergencies;
    }

    public List<EmergencyAttributeEntity> getAll() {
        return emergencyAttributeRepository.getAll();
    }

    public EmergencyAttributeEntity getById(long id) {
        return emergencyAttributeRepository.getById(id);
    }

    public void update(EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeRepository.update(
                emergencyAttribute.getEmergency_attribute_id(),
                emergencyAttribute.getEmergency().getEmergency_id(),
                emergencyAttribute.getAttribute().getAttribute_id(),
                emergencyAttribute.isCompatibility()
        );
        logger.info("EmergencyAttribute updated successfully");
    }

    public void delete(long id) {
        emergencyAttributeRepository.delete(id);
        logger.info("EmergencyAttribute deleted successfully");
    }
}
