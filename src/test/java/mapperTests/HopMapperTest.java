package mapperTests;

import at.fhtw.swen3.persistence.entity.HopEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.mapper.HopMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HopMapperTest {
    GeoCoordinate locationCoordinates = new GeoCoordinate();

    @Test
    void entityToDto() {
        //Create Hop Entity
        HopEntity hopEntity = new HopEntity("type1", "abcd12345",
                "Description", 15, "Vienna", locationCoordinates);
        //Turn Entity into DTO
        Hop hop = HopMapper.INSTANCE.entityToDto(hopEntity);

        //Assert Equals
        assertEquals("type1", hop.getHopType());
        assertEquals("abcd12345", hop.getCode());
        assertEquals("Description", hop.getDescription());
        assertEquals(15, hop.getProcessingDelayMins());
        assertEquals("Vienna", hop.getLocationName());
        assertEquals(locationCoordinates, hop.getLocationCoordinates());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        Hop hop = new Hop();
        hop.setHopType("type1");
        hop.setCode("abcd12345");
        hop.setDescription("Description");
        hop.setLocationName("Shkoder");
        hop.setProcessingDelayMins(10);
        hop.setLocationCoordinates(locationCoordinates);

        //Turn DTO to entity
        HopEntity hopEntity = HopMapper.INSTANCE.dtoToEntity(hop);

        //Assert values
        assertEquals("type1", hopEntity.getHopType());
        assertEquals("abcd12345", hopEntity.getCode());
        assertEquals("Description", hopEntity.getDescription());
        assertNotEquals("Koplik", hopEntity.getLocationName());
        assertEquals(10, hopEntity.getProcessingDelayMins());
        assertEquals(locationCoordinates, hopEntity.getLocationCoordinates());
    }
}
