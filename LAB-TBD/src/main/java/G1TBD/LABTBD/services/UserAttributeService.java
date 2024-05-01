package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.UserAttributeEntity;
import G1TBD.LABTBD.repositories.UserAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAttributeService {

    private final UserAttributeRepository userAttributeRepository;

    @Autowired
    public UserAttributeService(UserAttributeRepository userAttributeRepository) {
        this.userAttributeRepository = userAttributeRepository;
    }

    public UserAttributeEntity create(UserAttributeEntity userAttribute) {
        return userAttributeRepository.create(userAttribute);
    }

    public List<UserAttributeEntity> getAll() {
        return userAttributeRepository.getAll();
    }

    public UserAttributeEntity getById(long id) {
        return userAttributeRepository.getById(id);
    }

    public boolean update(UserAttributeEntity userAttribute) {
        return userAttributeRepository.update(userAttribute);
    }

    public boolean delete(long id) {
        return userAttributeRepository.delete(id);
    }

    public List<UserAttributeEntity> getByRut(String rut) {
        return userAttributeRepository.getByRut(rut);
    }

    public List<UserAttributeEntity> getByAttributeId(long attributeId) {
        return userAttributeRepository.getByAttributeId(attributeId);
    }

}
