package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import at.fhtw.swen3.services.validation.TestValidation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ContextConfiguration(locations = "/application.properties")
class ParcelServiceImplTest {

    @Autowired
    public ParcelServiceImpl parcelServiceImpl;


    final RecipientEntity recipientEntity = new RecipientEntity(2, "Mreti", "Dobrac 12/12",
            "1010", "Vienna", "Austria");
    final RecipientEntity senderEntity = new RecipientEntity(1, "Mreti", "Dobrac 12/12",
            "1010", "Vienna", "Austria");
    final List<HopArrivalEntity> visitedHops = new ArrayList<>();
    final ParcelEntity parcelEntity = new ParcelEntity(1, 10.0f, recipientEntity,
            senderEntity, "Pickup", visitedHops, visitedHops, "ABCK12345");


    @Test
    void submitNewParcel() {
        try {
            if(TestValidation.entityValidated(parcelEntity)){
                parcelServiceImpl.submitNewParcel(parcelEntity);
            }
        } catch (BLException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    void getParcelByTrackingId() {
//        try {
//            ParcelEntity parcelEntityRes = parcelServiceImpl.getParcelByTrackingId("ABCK12345");
//            System.out.println(parcelEntityRes.getTrackingId());
////            Parcel parcel = ParcelMapperImpl.INSTANCE.entityToDto(parcelEntityRes);
////            System.out.println(parcel.toString());
//        } catch (BLException e) {
//            e.printStackTrace();
//        }
//    }
}