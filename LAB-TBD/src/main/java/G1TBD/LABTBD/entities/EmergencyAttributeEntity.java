package G1TBD.LABTBD.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "emergency_attribute")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyAttributeEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long emergency_attribute_id;

    @ManyToOne
    @JoinColumn(name = "emergency_id")
    private EmergencyEntity emergency;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private AttributeEntity attribute;

    private boolean compatibility;

}
