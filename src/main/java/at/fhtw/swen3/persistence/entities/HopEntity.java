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
public class HopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hop_id")
    private Integer id;

    private String hopType;
    private String code;
    private String description;
    private Integer processingDelayMins;
    private String locationName;

    //@OneToMany(targetEntity=GeoCoordinateEntity.class, mappedBy="geo_co_id", fetch=FetchType.EAGER)
    //private GeoCoordinate locationCoordinates;
}
