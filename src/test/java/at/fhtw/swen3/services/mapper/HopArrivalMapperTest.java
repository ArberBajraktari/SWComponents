package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HopArrivalMapperTest {

    OffsetDateTime offsetDateTime;
    @Test
    void entityToDto() {
        //Create Hop Entity
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity(1, "abcd12345", "Description1", offsetDateTime);
        //Turn Entity into DTO
        HopArrival hopArrival = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);

        //Assert Equals
        assertEquals("abcd12345", hopArrival.getCode());
        assertEquals("Description1", hopArrival.getDescription());
        assertEquals(offsetDateTime, hopArrival.getDateTime());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        HopArrival hopArrival = new HopArrival();
        hopArrival.setCode("abcd12345");
        hopArrival.setDescription("Description1");
        hopArrival.setDateTime(offsetDateTime);

        //Turn DTO to entity
        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrival);

        //Assert values
        assertEquals("abcd12345", hopArrivalEntity.getCode());
        assertNotEquals("Description2", hopArrivalEntity.getDescription());
        assertEquals(offsetDateTime, hopArrivalEntity.getDateTime());
    }
}
