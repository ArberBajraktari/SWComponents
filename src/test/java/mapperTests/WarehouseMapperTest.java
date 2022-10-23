package mapperTests;

import at.fhtw.swen3.persistence.entityForEach.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseMapperTest {

    List<WarehouseNextHops> nextHoop = new ArrayList<>();
    @Test
    void entityToDto() {
        //Create Entity
        WarehouseEntity warehouseEntity = new WarehouseEntity(2, nextHoop);
        //Turn Entity into DTO
        Warehouse warehouse = WarehouseMapper.INSTANCE.entityToDto(warehouseEntity);

        //Assert Equals
        assertEquals(2, warehouse.getLevel());
        assertEquals(nextHoop, warehouse.getNextHops());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        Warehouse warehouse = new Warehouse();
        warehouse.setLevel(10);
        warehouse.setNextHops(nextHoop);

        //Turn DTO into entity
        WarehouseEntity warehouseEntity = WarehouseMapper.INSTANCE.dtoToEntity(warehouse);

        //Assert
        assertEquals(10, warehouseEntity.getLevel());
        assertEquals(nextHoop, warehouseEntity.getNextHops());
    }
}
