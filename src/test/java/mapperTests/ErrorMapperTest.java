package mapperTests;

import at.fhtw.swen3.persistence.entity.ErrorEntity;
import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.mapper.ErrorMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorMapperTest {
    @Test
    void entityToDto() {
        //Create Entity
        ErrorEntity errorEntity = new ErrorEntity("Error djali");
        //Turn Entity into DTO
        Error error = ErrorMapper.INSTANCE.entityToDto(errorEntity);

        //Assert Equals
        assertEquals("Error djali", error.getErrorMessage());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        Error error = new Error();
        error.setErrorMessage("Error 404");

        //Turn DTO into entity
        ErrorEntity errorEntity = ErrorMapper.INSTANCE.dtoToEntity(error);

        //Assert
        assertEquals("Error 404", errorEntity.getErrorMessage());
    }
}
