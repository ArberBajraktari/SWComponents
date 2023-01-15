package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.*;
import at.fhtw.swen3.services.mapper.RecipientMapper;
import at.fhtw.swen3.services.mapper.TrackingInformationMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TrackingInformationMapperTest {

    final RecipientEntity recipientEntity = new RecipientEntity(1, "Mreti", "Dobrac 12/12",
            "1010", "Vienna", "Austria");
    final RecipientEntity senderEntity = new RecipientEntity(1, "Mreti", "Dobrac 12/12",
            "1010", "Vienna", "Austria");
    final List<HopArrivalEntity> visitedHops = new ArrayList<>();
    final ParcelEntity parcelEntity = new ParcelEntity(1, 10.0f, recipientEntity,
            senderEntity, "Pickup", visitedHops, visitedHops, "ABCK12345");




    @Test
    void entityToDto() {
        //Create TrackingInfo Entity
        //Turn Entity into DTO
        TrackingInformation trackingInformation = TrackingInformationMapper.INSTANCE.entityToDto(parcelEntity);
        assertEquals(TrackingInformation.StateEnum.PICKUP, trackingInformation.getState());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setState(TrackingInformation.StateEnum.PICKUP);

        //Turn DTO into entity
        ParcelEntity parcelEntity = TrackingInformationMapper.INSTANCE.dtoToEntity(trackingInformation);

        assertEquals("Pickup", parcelEntity.getValue());
    }
}
