package at.fhtw.swen3.persistence.entityForEach;

import at.fhtw.swen3.services.dto.WarehouseNextHops;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class WarehouseEntity {
    private Integer level;
    @NotNull
    private List<WarehouseNextHops> nextHops = new ArrayList<>();
}
