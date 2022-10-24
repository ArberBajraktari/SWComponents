package at.fhtw.swen3.persistence.entity;


import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class ParcelEntity {
    //This entity unites 3 DTOs (Parcel, TrackingInformation and NewParcelInfo)

    //Parcel
    @Min(value = 0, message = "Weight should be bigger than 0,0")
    private Float weight;
    @NotNull
    private Recipient recipient;
    @NotNull
    private Recipient sender;

    //TrackingInformation
    private String value;

    //NewParcelInfo
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;

}
