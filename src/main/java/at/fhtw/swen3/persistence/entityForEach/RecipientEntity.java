package at.fhtw.swen3.persistence.entityForEach;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class RecipientEntity {
    private String name;
    private String street;
    @Pattern(regexp = "^\\d{4}$")
    private String postalCode;
    private String city;
    private String country;
}
