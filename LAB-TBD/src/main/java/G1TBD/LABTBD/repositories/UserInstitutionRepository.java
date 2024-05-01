package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.UserInstitutionEntity;

import java.util.List;

public interface UserInstitutionRepository {

    UserInstitutionEntity create(UserInstitutionEntity userInstitution);

    List<UserInstitutionEntity> getAll();

    UserInstitutionEntity getById(long id);

    boolean update(UserInstitutionEntity userInstitution);

    boolean delete(long id);

    UserInstitutionEntity getByRut(String rut);

    List<UserInstitutionEntity> getByInstitutionId(long institutionId);

}
