package G1TBD.LABTBD.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private String rut;
    private String email;
    private String name;
    private String lastName;
    private Date birthDate;
    private String sex;
    private String password;
    private String role;
    private boolean availability;

}
