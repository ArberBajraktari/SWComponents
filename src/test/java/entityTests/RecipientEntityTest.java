package entityTests;

import at.fhtw.swen3.persistence.entityForEach.RecipientEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipientEntityTest {
    private static final Logger log = LoggerFactory.getLogger(RecipientEntityTest.class);

    @Test
    public void validationTest_Ok(){
        log.info("Test validationTest");

        final RecipientEntity recipientEntity = new RecipientEntity("Mreti", "Dobrac 12/12",
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

        final RecipientEntity recipientEntity = new RecipientEntity("Mreti", "Dobrac",
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