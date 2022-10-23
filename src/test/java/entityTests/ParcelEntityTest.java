package entityTests;

import at.fhtw.swen3.persistence.entityForEach.RecipientEntity;
import at.fhtw.swen3.persistence.entityForThree.ParcelEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.fail;

public class ParcelEntityTest {
    private static final Logger log = LoggerFactory.getLogger(RecipientEntityTest.class);
    final RecipientEntity recipientEntity = new RecipientEntity("Mreti", "Dobrac 12/12",
            "1010", "Vienna", "Austria");
    Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);


    @Test
    public void validationTest_Ok(){
        log.info("Test ParcelEntity");
        final ParcelEntity parcelEntity = new ParcelEntity(10.0f, recipient, recipient, "Pickup", "ABCDE1234");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ParcelEntity>> violations = validator.validate(parcelEntity);
        for (ConstraintViolation<ParcelEntity> violation : violations)
        {
            log.error(violation.getMessage());
            fail(violation.getMessage());
        }
    }

    @Test
    public void validationTest_NotOk(){
        log.info("Test ParcelEntity");
        final ParcelEntity parcelEntity = new ParcelEntity(10.0f, recipient, recipient, "Pickup", "abcd1234");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<ParcelEntity>> violations = validator.validate(parcelEntity);
        for (ConstraintViolation<ParcelEntity> violation : violations)
        {
            log.info(violation.getMessage());
            return;
        }
        fail("Validation should fail!");
    }
}
