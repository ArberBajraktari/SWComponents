package at.fhtw.swen3.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class HopArrivalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hop_arrival_id")
    private Integer id;

    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;
    private String description;

    @Column(name = "date_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime dateTime;
}
