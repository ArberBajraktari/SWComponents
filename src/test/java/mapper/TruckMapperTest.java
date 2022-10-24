package mapper;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import at.fhtw.swen3.services.mapper.TruckMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TruckMapperTest {
    @Test
    void entityToDto() {
        //Create Entity
        TruckEntity truckEntity = new TruckEntity("string 1", "AA-123");
        //Turn Entity into DTO
        Truck truck = TruckMapper.INSTANCE.entityToDto(truckEntity);

        //Assert Equals
        assertEquals("string 1", truck.getRegionGeoJson());
        assertNotEquals("AA-1234", truck.getNumberPlate());
        assertEquals("AA-123", truck.getNumberPlate());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        Truck truck = new Truck();
        truck.setRegionGeoJson("string1");
        truck.setNumberPlate("AA-123");

        //Turn DTO into entity
        TruckEntity truckEntity = TruckMapper.INSTANCE.dtoToEntity(truck);

        //Assert
        assertEquals("string1", truckEntity.getRegionGeoJson());
        assertEquals("AA-123", truckEntity.getNumberPlate());
    }
}
