package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.NewParcelInfoMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewParcelInfoMapperTest {

    final RecipientEntity recipientEntity = new RecipientEntity(1, "Mreti", "Dobrac 12/12",
            "1010", "Vienna", "Austria");
    final RecipientEntity senderEntity = new RecipientEntity(1, "Mreti", "Dobrac 12/12",
            "1010", "Vienna", "Austria");
    final List<HopArrivalEntity> visitedHops = new ArrayList<>();
    final ParcelEntity parcelEntity = new ParcelEntity(1, 10.0f, recipientEntity,
            senderEntity, "Pickup", visitedHops, visitedHops, "ABCK12345");

    @Test
    void entityToDto() {
        //Turn Entity into DTO
        NewParcelInfo newParcelInfoDto = NewParcelInfoMapper.INSTANCE.entityToDto(parcelEntity);

        //Assert Equals
        assertEquals("ABCK12345", newParcelInfoDto.getTrackingId());
    }

    @Test
    void dtoToEntity() {
        NewParcelInfo newParcelInfo = new NewParcelInfo();
        newParcelInfo.setTrackingId("ABCK12345");

        ParcelEntity parcelEntity = NewParcelInfoMapper.INSTANCE.dtoToEntity(newParcelInfo);

        assertEquals("ABCK12345", parcelEntity.getTrackingId());
    }
}
