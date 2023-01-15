package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.TestValidation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@SpringBootTest
class HopEntityTest {

    @Test
    public void hopEntityTestValid(){
        log.info("Test HopEntity Validation should work");

        HopEntity hopEntity = new HopEntity(1, "type", "ABCD1234", "desc",
                15, "name");

        if(!TestValidation.entityValidated(hopEntity)){
            fail("Validations should work.");
        }
    }

    @Test
    public void hopEntityTestNotValid() {
        log.info("Test HopEntity Validation should not work");

        HopEntity hopEntity = new HopEntity(1, "type", "ABC1234", "desc",
                15, "name");

        if(TestValidation.entityValidated(hopEntity)){
            fail("Validations should not work.");
        }
    }
}