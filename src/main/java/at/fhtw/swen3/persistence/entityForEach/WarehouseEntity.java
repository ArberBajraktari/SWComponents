package at.fhtw.swen3.persistence.entityForEach;

import at.fhtw.swen3.services.dto.WarehouseNextHops;

import java.util.ArrayList;
import java.util.List;

public class WarehouseEntity {
    private Integer level;
    private List<WarehouseNextHops> nextHops = new ArrayList<>();
}
