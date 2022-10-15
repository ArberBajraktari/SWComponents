package at.fhtw.swen3.persistence.entityForEach;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
@AllArgsConstructor
public class HopArrivalEntity {
    private String code;
    private String description;
    private OffsetDateTime dateTime;
}
