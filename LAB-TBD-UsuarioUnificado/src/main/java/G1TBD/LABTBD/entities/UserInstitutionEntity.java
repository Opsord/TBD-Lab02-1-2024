package G1TBD.LABTBD.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInstitutionEntity {

    private long idUserInstitution;
    private long rut;
    private long idInstitution;

}
