package mapperTests;

import at.fhtw.swen3.persistence.entityForEach.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipientMapperTest {

    @Test
    void entityToDto() {
        RecipientEntity recipientEntity = new RecipientEntity("Mreti", "Dobrac",
                "1010", "Vienna", "Austria");
        System.out.println(recipientEntity);

        Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);

        assertEquals("Mreti", recipient.getName());
        assertEquals("Dobrac", recipient.getStreet());
        assertNotEquals("1234", recipient.getPostalCode());

        System.out.println(recipient);
    }

    @Test
    void dtoToEntity() {
        Recipient recipient = new Recipient();
        recipient.setName("Kingu");
        recipient.setStreet("Perash");

        System.out.println(recipient);

        RecipientEntity recipientEntity = RecipientMapper.INSTANCE.dtoToEntity(recipient);

        assertEquals("Kingu", recipientEntity.getName());
        assertNotEquals("Kiras", recipientEntity.getStreet());

        System.out.println(recipientEntity);
    }
}