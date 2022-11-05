package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
public class HopEntity {
    private String hopType;
    private String code;
    private String description;
    private Integer processingDelayMins;
    private String locationName;
    private GeoCoordinate locationCoordinates;
}
