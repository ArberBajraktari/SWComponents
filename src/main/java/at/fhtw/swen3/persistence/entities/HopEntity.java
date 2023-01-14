package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class HopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hop_id")
    private Integer id;
    private String hopType;
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;
    @Pattern(regexp = "^[a-zA-Z0-9-\\\\/ ßäöü]*")
    private String description;
    private Integer processingDelayMins;
    private String locationName;


    //@OneToMany(targetEntity=GeoCoordinateEntity.class, mappedBy="geo_co_id", fetch=FetchType.EAGER)
    //private GeoCoordinate locationCoordinates;
}
