package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.AttributeEntity;
import G1TBD.LABTBD.repositories.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;

    @Autowired
    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public AttributeEntity create(AttributeEntity attribute) {
        return attributeRepository.create(attribute);
    }

    public List<AttributeEntity> getAll() {
        return attributeRepository.getAll();
    }

    public AttributeEntity getById(long id) {
        return attributeRepository.getById(id);
    }

    public boolean update(AttributeEntity attribute) {
        return attributeRepository.update(attribute);
    }

    public boolean delete(long id) {
        return attributeRepository.delete(id);
    }
}
