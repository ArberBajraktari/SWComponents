package at.fhtw.swen3.persistence.entityForEach;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TruckEntity {
    private String regionGeoJson;
    private String numberPlate;
}
