package G1TBD.LABTBD.data.point;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.io.Serializable;

@Data
@Entity
@Table(name = "points")
@NoArgsConstructor
@AllArgsConstructor
public class PointEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long point_id;

    private Double latitude;
    private Double longitude;

    @Column(name = "geom", columnDefinition = "geometry(Point, 4326)")
    private Point point;



}