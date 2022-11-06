package at.fhtw.swen3.persistence.entity;


import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table
public class ParcelEntity {
    //This entity unites 3 DTOs (Parcel, TrackingInformation and NewParcelInfo)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parcel_id")
    private Integer id;

    //Parcel
    @Min(value = 0, message = "Weight should be bigger than 0,0")
    private Float weight;

    @NotNull
    @JoinColumn(name = "recipient_id", referencedColumnName="recipient_id")
    @ManyToOne
    private RecipientEntity recipient;

    @NotNull
    @JoinColumn(name="sender_id", referencedColumnName="recipient_id")
    @ManyToOne
    private RecipientEntity sender;

    //TrackingInformation
    private String value;

    //NewParcelInfo
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;

}
