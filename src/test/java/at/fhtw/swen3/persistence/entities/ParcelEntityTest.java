package at.fhtw.swen3.persistence.entities;


import at.fhtw.swen3.services.validation.TestValidation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@SpringBootTest
public class ParcelEntityTest {
    final RecipientEntity recipientEntity = new RecipientEntity(1, "Mreti", "Dobrac 12/12",
            "1010", "Vienna", "Austria");

    @Test
    public void parcelEntityTestValid(){
        log.info("Test ParcelEntity Validation should work");
        final ParcelEntity parcelEntity = new ParcelEntity(1, 10.0f, recipientEntity, recipientEntity, "Pickup", "ABCDE1234");

        // If it returns false, then Entity has wrong information
        if(!TestValidation.entityValidated(parcelEntity)){
            fail("Validations should work.");
        }
    }

    @Test
    public void parcelEntityTestNotValid(){
        log.info("Test ParcelEntity Validation should not work");
        final ParcelEntity parcelEntity = new ParcelEntity(1, -10.0f, recipientEntity, recipientEntity, "Pickup", "abcd1234");

        if(TestValidation.entityValidated(parcelEntity)){
            fail("Validations should not work.");
        }
    }
}
