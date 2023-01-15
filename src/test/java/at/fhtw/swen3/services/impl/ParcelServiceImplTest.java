package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import at.fhtw.swen3.services.validation.TestValidation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ContextConfiguration(locations = "/application.properties")
class ParcelServiceImplTest {

    @Autowired
    public ParcelServiceImpl parcelServiceImpl;


    final RecipientEntity recipientEntity = new RecipientEntity(2, "Mreti", "Leystrasse 131/12",
            "1200", "Vienna", "Austria");
    final RecipientEntity senderEntity = new RecipientEntity(1, "Mretja", "Leystrasse 129/12",
            "1200", "Vienna", "Austria");
    final List<HopArrivalEntity> visitedHops = new ArrayList<>();
    final ParcelEntity parcelEntity = new ParcelEntity(1, 10.0f, recipientEntity,
            senderEntity, "Pickup", visitedHops, visitedHops, "ABCK12345");

    @Test
    void submitNewParcel() {
        try {
            if(TestValidation.entityValidatedForTests(parcelEntity)){
                parcelServiceImpl.submitNewParcel(parcelEntity);
            }
        } catch (BLException e) {
            e.printStackTrace();
        }
    }
}