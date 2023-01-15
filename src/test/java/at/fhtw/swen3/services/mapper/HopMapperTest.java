package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.mapper.HopMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HopMapperTest {
    GeoCoordinateEntity locationCoordinatesEntity = new GeoCoordinateEntity(1, 10.0, 20.0);

    @Test
    void entityToDto() {
        //Create Hop Entity
        HopEntity hopEntity = new HopEntity(1, "type1", "ABCD1234",
                "Description", 15, "Vienna", locationCoordinatesEntity);
        //Turn Entity into DTO
        Hop hop = HopMapper.INSTANCE.entityToDto(hopEntity);

        //Assert Equals
        assertEquals("type1", hop.getHopType());
        assertEquals("ABCD1234", hop.getCode());
        assertEquals("Description", hop.getDescription());
        assertEquals(15, hop.getProcessingDelayMins());
        assertEquals("Vienna", hop.getLocationName());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        Hop hop = new Hop();
        hop.setHopType("type1");
        hop.setCode("ABCD1234");
        hop.setDescription("Description");
        hop.setLocationName("Shkoder");
        hop.setProcessingDelayMins(10);

        //Turn DTO to entity
        HopEntity hopEntity = HopMapper.INSTANCE.dtoToEntity(hop);

        //Assert values
        assertEquals("type1", hopEntity.getHopType());
        assertEquals("ABCD1234", hopEntity.getCode());
        assertEquals("Description", hopEntity.getDescription());
        assertNotEquals("Koplik", hopEntity.getLocationName());
        assertEquals(10, hopEntity.getProcessingDelayMins());
    }
}
