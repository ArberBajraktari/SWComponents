package at.fhtw.swen3.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class TruckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "truck_id")
    private Integer id;

    private String regionGeoJson;
    private String numberPlate;
}
