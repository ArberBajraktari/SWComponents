package at.fhtw.swen3.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class RecipientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipient_id")
    private Integer id;

    @Pattern(regexp =  "^[A-Z][a-zA-Z-\\/ ßäöü]*")
    private String name;
    @Pattern(regexp = "^[a-zA-Z 0-9\\/ ßäöü]*")
    private String street;
    @Pattern(regexp = "^\\d{4}$")
    private String postalCode;
    @Pattern(regexp =  "^[A-Z][a-zA-Z-\\/ ßäöü]*")
    private String city;
    private String country;
}
