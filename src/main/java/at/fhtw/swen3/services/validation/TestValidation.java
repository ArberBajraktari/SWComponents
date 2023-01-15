package at.fhtw.swen3.services.validation;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import lombok.extern.slf4j.Slf4j;

import javax.validation.*;
import java.util.Set;

import static org.aspectj.bridge.MessageUtil.fail;

@Slf4j
public class TestValidation<T> {
    public static <T> void entityValidated(T t) throws ConstraintViolationException{
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(t);

        if(!violations.isEmpty()){
            for (ConstraintViolation<T> violation : violations)
            {
                log.error(violation.getPropertyPath().toString() + "---" + violation.getMessage());
            }
            throw new ConstraintViolationException(violations);
        }
    }

    public static <T> boolean entityValidatedForTests(T t) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(t);

        if(!violations.isEmpty()){
            for (ConstraintViolation<T> violation : violations)
            {
                log.error(violation.getPropertyPath().toString() + "---" + violation.getMessage());
            }
            return false;
        }

        return true;
    }
}
