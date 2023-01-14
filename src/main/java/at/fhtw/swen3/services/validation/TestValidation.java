package at.fhtw.swen3.services.validation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.*;
import java.util.Set;

import static org.aspectj.bridge.MessageUtil.fail;

@Slf4j
public class TestValidation<T> {
    public static <T> boolean entityValidated(T t){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(t);

        if(!violations.isEmpty()){
            for (ConstraintViolation<T> violation : violations)
            {
                log.error(violation.getMessage());
            }
            return false;
        }
        else {
            return true;
            //throw new ConstraintViolationException(violations);
        }
    }
}
