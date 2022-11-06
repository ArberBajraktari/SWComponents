package at.fhtw.swen3.persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = WarehouseNextHopsRepository.class)
class WarehouseNextHopsRepositoryTest {

    @Autowired
    private WarehouseNextHopsRepository repo;
}