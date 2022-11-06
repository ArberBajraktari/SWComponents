package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ParcelRepository.class)
class ParcelRepositoryTest {

    @Autowired
    private ParcelService repo;
}