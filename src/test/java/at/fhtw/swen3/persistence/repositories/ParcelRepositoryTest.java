package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ParcelRepository.class)
class ParcelRepositoryTest {


    @Autowired
    private ParcelRepository repo;

//    @Autowired
//    private ParcelServiceImpl parcelServiceImpl;

    @Test
    public void validationTest_Ok() {
        ParcelEntity parcel = new ParcelEntity();
        parcel.setWeight(10.0f);
        repo.save(parcel);
        //parcelServiceImpl.submitNewParcel(parcel);
    }
}