package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.AttributeEntity;
import G1TBD.LABTBD.entities.EmergencyAttributeEntity;
import G1TBD.LABTBD.entities.EmergencyEntity;
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
    //--------------------------CREATE--------------------------
    public void create(EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeRepository.create(
                emergencyAttribute.getEmergency().getEmergency_id(),
                emergencyAttribute.getAttribute().getAttribute_id(),
                emergencyAttribute.isCompatibility()
        );
        logger.info("EmergencyAttribute created successfully");
    }

    public List<EmergencyAttributeEntity> linkAttributesToEmergency(Long emergency_id, List<AttributeEntity> attributes) {
        List<EmergencyAttributeEntity> emergencyAttributeList = new ArrayList<>();
        EmergencyEntity emergency = new EmergencyEntity();
        emergency.setEmergency_id(emergency_id);
        for (AttributeEntity attribute : attributes) {
            EmergencyAttributeEntity emergencyAttribute = new EmergencyAttributeEntity();
            emergencyAttribute.setEmergency(emergency);
            emergencyAttribute.setAttribute(attribute);
            emergencyAttribute.setCompatibility(true);
            create(emergencyAttribute);
            emergencyAttributeList.add(emergencyAttribute);
        }
        return emergencyAttributeList;
    }


    //--------------------------UPDATE--------------------------
    public void update(EmergencyAttributeEntity emergencyAttribute) {
        emergencyAttributeRepository.update(
                emergencyAttribute.getEmergency_attribute_id(),
                emergencyAttribute.getEmergency().getEmergency_id(),
                emergencyAttribute.getAttribute().getAttribute_id(),
                emergencyAttribute.isCompatibility()
        );
        logger.info("EmergencyAttribute updated successfully");
    }


    //---------------------------READ---------------------------
    public List<EmergencyAttributeEntity> getAll() {
        return emergencyAttributeRepository.getAll();
    }

    public EmergencyAttributeEntity getById(long id) {
        return emergencyAttributeRepository.getById(id);
    }


    //--------------------------DELETE--------------------------
    public void delete(long id) {
        emergencyAttributeRepository.delete(id);
        logger.info("EmergencyAttribute deleted successfully");
    }
}
