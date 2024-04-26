package G1TBD.LABTBD.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RankingEntity {

    private long idRanking;
    private String idVolunteer;
    private long idTask;
    private Integer valorRanking;

}
