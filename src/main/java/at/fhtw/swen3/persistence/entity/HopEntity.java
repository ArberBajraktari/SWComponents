package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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
