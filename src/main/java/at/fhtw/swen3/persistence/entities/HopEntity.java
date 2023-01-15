package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.GeoCoordinate;
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


    @OneToOne
    private GeoCoordinateEntity locationCoordinates;
}
