package at.fhtw.swen3.persistence.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class GeoCoordinateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "geo_co_id")
    private Integer id;

    private Double lat;
    private Double lon;
}
