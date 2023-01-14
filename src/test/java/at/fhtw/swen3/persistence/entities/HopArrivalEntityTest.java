package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.validation.TestValidation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
@SpringBootTest
public class HopArrivalEntityTest {

    @Test
    public void hopArrivalEntityValid(){
        log.info("Test HopArrivalEntity");
        final HopArrivalEntity hopArrivalEntity = new HopArrivalEntity(1, "ABCD123", "Description", null);

        // If it returns false, then Entity has wrong information
        if(!TestValidation.entityValidated(hopArrivalEntity)){
            fail("Validations should work.");
        }
    }

    @Test
    public void hopArrivalEntityNotValid() {
        log.info("Test HopArrivalEntity");
        final HopArrivalEntity hopArrivalEntity = new HopArrivalEntity(1, "Abcd123", "Description", null);
        // If it returns false, then Entity has wrong information
        if(TestValidation.entityValidated(hopArrivalEntity)){
            fail("Validations should not work.");
        }
    }
}
