package mapper;

import at.fhtw.swen3.persistence.entity.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import at.fhtw.swen3.services.mapper.TransferwarehouseMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TransferwarehouseMapperTest {
    @Test
    void entityToDto() {
        //Create TransferWarehouse Entity
        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity("string1", "string2", "string3");
        //Turn Entity into DTO
        Transferwarehouse transferwarehouse = TransferwarehouseMapper.INSTANCE.entityToDto(transferwarehouseEntity);

        //Assert Equals
        assertEquals("string1", transferwarehouse.getRegionGeoJson());
        assertEquals("string2", transferwarehouse.getLogisticsPartner());
        assertNotEquals("stringX", transferwarehouse.getLogisticsPartnerUrl());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        Transferwarehouse transferwarehouse = new Transferwarehouse();
        transferwarehouse.setRegionGeoJson("string1");
        transferwarehouse.setLogisticsPartner("partner filani");
        transferwarehouse.setLogisticsPartnerUrl("partnerfilani.com");

        //Turn DTO into entity
        TransferwarehouseEntity transferwarehouseEntity = TransferwarehouseMapper.INSTANCE.dtoToEntity(transferwarehouse);

        //Assert
        assertEquals("string1", transferwarehouseEntity.getRegionGeoJson());
        assertEquals("partner filani", transferwarehouseEntity.getLogisticsPartner());
        assertNotEquals("xxx.com", transferwarehouseEntity.getLogisticsPartnerUrl());

    }
}
