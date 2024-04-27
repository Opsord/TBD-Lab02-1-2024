package G1TBD.LABTBD.repositories;

import G1TBD.LABTBD.entities.UserAttributeEntity;

import java.util.List;

public interface UserAttributeRepository {

    UserAttributeEntity create(UserAttributeEntity userAttribute);

    List<UserAttributeEntity> getAll();

    UserAttributeEntity getById(long id);

    boolean update(UserAttributeEntity userAttribute);

    boolean delete(long id);

    List<UserAttributeEntity> getByRut(String rut);

    List<UserAttributeEntity> getByAttributeId(long attributeId);

}
