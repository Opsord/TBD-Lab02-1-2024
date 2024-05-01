package G1TBD.LABTBD.services;

import G1TBD.LABTBD.entities.UserInstitutionEntity;
import G1TBD.LABTBD.repositories.UserInstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInstitutionService {

    private final UserInstitutionRepository userInstitutionRepository;

    @Autowired
    public UserInstitutionService(UserInstitutionRepository userInstitutionRepository) {
        this.userInstitutionRepository = userInstitutionRepository;
    }

    public UserInstitutionEntity create(UserInstitutionEntity userInstitution) {
        return userInstitutionRepository.create(userInstitution);
    }

    public List<UserInstitutionEntity> getAll() {
        return userInstitutionRepository.getAll();
    }

    public UserInstitutionEntity getById(long id) {
        return userInstitutionRepository.getById(id);
    }

    public boolean update(UserInstitutionEntity userInstitution) {
        return userInstitutionRepository.update(userInstitution);
    }

    public boolean delete(long id) {
        return userInstitutionRepository.delete(id);
    }

    public UserInstitutionEntity getByRut(String rut) {
        return userInstitutionRepository.getByRut(rut);
    }

    public List<UserInstitutionEntity> getByInstitutionId(long institutionId) {
        return userInstitutionRepository.getByInstitutionId(institutionId);
    }

}
