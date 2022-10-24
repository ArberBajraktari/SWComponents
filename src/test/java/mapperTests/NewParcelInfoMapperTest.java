package mapperTests;

import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.NewParcelInfoMapper;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewParcelInfoMapperTest {

    RecipientEntity recipientEntity = new RecipientEntity("Mreti", "Dobrac",
            "1010", "Vienna", "Austria");
    Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);
    RecipientEntity senderEntity = new RecipientEntity("Mreti", "Koplik",
            "1010", "Graz", "Austria");
    Recipient sender = RecipientMapper.INSTANCE.entityToDto(senderEntity);

    @Test
    void entityToDto() {
        //Create Parcel Entity
        ParcelEntity parcelEntity = new ParcelEntity(10.0f, recipient, sender, "10", "abcd12345");
        //Turn Entity into DTO
        NewParcelInfo newParcelInfoDto = NewParcelInfoMapper.INSTANCE.entityToDto(parcelEntity);

        //Assert Equals
        assertEquals("abcd12345", newParcelInfoDto.getTrackingId());
    }

    @Test
    void dtoToEntity() {
        NewParcelInfo newParcelInfo = new NewParcelInfo();
        newParcelInfo.setTrackingId("abcd12345");

        ParcelEntity parcelEntity = NewParcelInfoMapper.INSTANCE.dtoToEntity(newParcelInfo);

        assertEquals("abcd12345", parcelEntity.getTrackingId());
    }
}
