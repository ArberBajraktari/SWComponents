package mapperTests;

import at.fhtw.swen3.persistence.entityForEach.HopArrivalEntity;
import at.fhtw.swen3.persistence.entityForEach.RecipientEntity;
import at.fhtw.swen3.persistence.entityForEach.TruckEntity;
import at.fhtw.swen3.persistence.entityForThree.ParcelEntity;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.mapper.TrackingInformationMapper;
import at.fhtw.swen3.services.mapper.TruckMapper;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TrackingInformationMapperTest {
    RecipientEntity recipientEntity = new RecipientEntity("Mreti", "Dobrac",
            "1010", "Vienna", "Austria");
    Recipient recipient = RecipientMapper.INSTANCE.entityToDto(recipientEntity);
    RecipientEntity senderEntity = new RecipientEntity("Mreti", "Koplik",
            "1010", "Graz", "Austria");
    Recipient sender = RecipientMapper.INSTANCE.entityToDto(senderEntity);

    List<HopArrival> nextHoop = new ArrayList<>();



    @Test
    void entityToDto() {
        //Create TrackingInfo Entity
        ParcelEntity parcelEntity = new ParcelEntity(10.0f, recipient, sender, "Pickup", "abcd12345");
        //Turn Entity into DTO
        TrackingInformation trackingInformation = TrackingInformationMapper.INSTANCE.entityToDto(parcelEntity);

        //System.out.println(trackingInformation.getState());
        //Assert Equals
        //assertEquals(TrackingInformation.StateEnum.PICKUP, trackingInformation.getState());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setState(TrackingInformation.StateEnum.PICKUP);
        trackingInformation.setFutureHops(nextHoop);

        //Turn DTO into entity
        ParcelEntity parcelEntity = TrackingInformationMapper.INSTANCE.dtoToEntity(trackingInformation);

        //Assert
        //assertEquals("Pickup", parcelEntity.getValue());
        //assertEquals("AA-123", parcelEntity.getNumberPlate());
    }
}
