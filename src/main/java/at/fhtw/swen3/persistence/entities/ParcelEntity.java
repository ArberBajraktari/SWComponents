package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.HopArrival;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "parcel_id")
    private Integer id;

    //Parcel
    @Min(value = 0, message = "Weight should be bigger than 0,0")
    private Float weight;

    @NotNull
    @JoinColumn(name = "recipient_id", referencedColumnName="recipient_id")
    @OneToOne(cascade=CascadeType.ALL)
    private RecipientEntity recipient;

    @NotNull
    @JoinColumn(name="sender_id", referencedColumnName="recipient_id")
    @OneToOne(cascade=CascadeType.ALL)
    private RecipientEntity sender;

    //TrackingInformation
    private String value;
//    private TrackingInformation.StateEnum state;
//    @NotNull
    @OneToMany(cascade = {CascadeType.ALL})
    private List<HopArrivalEntity> visitedHops = new ArrayList<>();

//    @NotNull
    @OneToMany(cascade = {CascadeType.ALL})
    private List<HopArrivalEntity> futureHops = new ArrayList<>();

    //NewParcelInfo
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;


}
