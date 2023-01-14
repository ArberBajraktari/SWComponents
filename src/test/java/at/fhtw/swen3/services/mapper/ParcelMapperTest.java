package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelMapperTest {

    RecipientEntity recipientEntity = new RecipientEntity(1, "Mreti", "Dobrac",
            "1010", "Vienna", "Austria");
    Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);
    RecipientEntity senderEntity = new RecipientEntity(1, "Mreti", "Koplik",
            "1010", "Graz", "Austria");
    Recipient sender = RecipientMapper.INSTANCE.entityToDto(senderEntity);

//    @Test
//    void entityToDto() {
//        //Create Parcel Entity
//        ParcelEntity parcelEntity = new ParcelEntity(1, 10.0f, recipientEntity, senderEntity, "10", "abcd12345");
//        //Turn Entity into DTO
//        Parcel parcelDto = ParcelMapper.INSTANCE.entityToDto(parcelEntity);
//
//        //Assert Equals
//        assertEquals(10.0f, parcelDto.getWeight());
//        assertEquals(recipient, parcelDto.getRecipient());
//        assertNotEquals(recipient,parcelDto.getSender());
//
//    }

    @Test
    void dtoToEntity() {
        Parcel parcel = new Parcel();
        parcel.setWeight(10.0f);
        parcel.setRecipient(recipient);
        parcel.setSender(sender);

        ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);

        assertEquals(10.0f, parcelEntity.getWeight());
        //assertEquals(sender, parcelEntity.getSender());
    }
}