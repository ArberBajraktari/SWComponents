package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.TestValidation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class WarehouseNextHopsEntityTest {
    @Test
    public void xEntityTestValid(){
        log.info("Test validationTest");

        // Entity attributes are entered correctly
        // Validation should work and return True (after validating attributes)
        final RecipientEntity recipientEntity = new RecipientEntity(1, "Mreti", "Dobrac 12/12",
                "1010", "Vienna", "Austria");

        // If it returns false, then Entity has wrong information
        if(!TestValidation.entityValidated(recipientEntity)){
            fail("Validations should work.");
        }
    }

    @Test
    public void xEntityTestNotValid() {
        log.info("Test validationTest");

        final RecipientEntity recipientEntity = new RecipientEntity(1, "Mreti", "Dobrac",
                "110", "vienna", "Austria");

        if(TestValidation.entityValidated(recipientEntity)){
            fail("Validations should not work.");
        }
    }
}