package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import at.fhtw.swen3.services.mapper.WarehouseNextHopsMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseNextHopsMapperTest {
    HopEntity hopEntity = new HopEntity();
    Hop hop = new Hop();
    @Test
    void entityToDto() {
        hop.setCode("10");
        //Create Entity
        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity(1, 2, hopEntity);
        //Turn Entity into DTO
        WarehouseNextHops warehouseNextHops = WarehouseNextHopsMapper.INSTANCE.entityToDto(warehouseNextHopsEntity);

        //Assert Equals
        assertEquals(2, warehouseNextHops.getTraveltimeMins());
        //assertEquals(hop, warehouseNextHops.getHop());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();
        warehouseNextHops.setHop(hop);
        warehouseNextHops.setTraveltimeMins(10);

        //Turn DTO into entity
        WarehouseNextHopsEntity warehouseNextHopsEntity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(warehouseNextHops);

        //Assert
        assertEquals(10, warehouseNextHopsEntity.getTraveltimeMins());
        //assertEquals(hop, warehouseNextHopsEntity.getHop());
    }
}
