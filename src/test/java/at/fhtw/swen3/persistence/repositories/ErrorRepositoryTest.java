package at.fhtw.swen3.persistence.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ErrorRepository.class)
class ErrorRepositoryTest {

    @Autowired
    private ErrorRepository repo;

}