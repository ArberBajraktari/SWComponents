package at.fhtw.swen3.persistence.entityForThree;


import at.fhtw.swen3.services.dto.Recipient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class ParcelEntity {
    //This entity unites 3 DTOs (Parcel, TrackingInformation and NewParcelInfo)

    //Parcel
    private Float weight;
    private Recipient recipient;
    private Recipient sender;

    //TrackingInformation
    private String value;

    //NewParcelInfo
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;
}
