package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
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

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RecipientEntityTest {

    @Test
    public void validationTest_Ok(){
        log.info("Test validationTest");

        final RecipientEntity recipientEntity = new RecipientEntity(1, "Mreti", "Dobrac 12/12",
                "1010", "Vienna", "Austria");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(recipientEntity);
        for (ConstraintViolation<RecipientEntity> violation : violations)
        {
            log.error(violation.getMessage());
            fail(violation.getMessage());
        }
    }

    @Test
    public void validationTest_NotOk(){
        log.info("Test validationTest");

        final RecipientEntity recipientEntity = new RecipientEntity(1, "Mreti", "Dobrac",
                "110", "vienna", "Austria");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<RecipientEntity>> violations = validator.validate(recipientEntity);
        for (ConstraintViolation<RecipientEntity> violation : violations)
        {
            log.info(violation.getMessage());
            return;
        }
        fail("Validation should fail!");
    }
}