package at.fhtw.swen3.persistence.entityForEach;

import at.fhtw.swen3.services.dto.WarehouseNextHops;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class WarehouseEntity {
    private Integer level;
    private List<WarehouseNextHops> nextHops = new ArrayList<>();
}
