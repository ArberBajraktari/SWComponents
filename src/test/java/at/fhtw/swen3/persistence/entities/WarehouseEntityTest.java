package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.validation.TestValidation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class WarehouseEntityTest {
    @Test
    public void warehouseEntityTestValid(){
        log.info("Test WarehouseEntity Validation should work");

        List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
        final WarehouseEntity warehouseEntity = new WarehouseEntity(1, 2, nextHops);

        if(!TestValidation.entityValidated(warehouseEntity)){
            fail("Validations should work.");
        }
    }

    @Test
    public void warehouseEntityTestNotValid() {
        log.info("Test WarehouseEntity Validation should not work");
        List<WarehouseNextHopsEntity> nextHops = null;
        final WarehouseEntity warehouseEntity = new WarehouseEntity(1, 2, nextHops);

        if(TestValidation.entityValidated(warehouseEntity)){
            fail("Validations should not work.");
        }
    }
}