package at.fhtw.swen3.persistence.entityForEach;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class RecipientEntity {
    @Pattern(regexp =  "^[A-Z][a-zA-Z-/ ßäöü]*")
    private String name;
    @Pattern(regexp = "[a-zA-Z 0-9/ßäöü]")
    private String street;
    @Pattern(regexp = "^\\d{4}$")
    private String postalCode;
    @Pattern(regexp =  "^[A-Z][a-zA-Z-/ ßäöü]*")
    private String city;
    private String country;
}
