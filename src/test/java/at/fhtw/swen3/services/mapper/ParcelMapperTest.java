package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParcelMapperTest {

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
        Parcel parcelDto = ParcelMapper.INSTANCE.entityToDto(parcelEntity);

        //Assert Equals
        assertEquals(10.0f, parcelDto.getWeight());

    }

    @Test
    void dtoToEntity() {
        Parcel parcel = new Parcel();
        parcel.setWeight(10.0f);

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);

        assertEquals(10.0f, parcelEntity.getWeight());
    }
}