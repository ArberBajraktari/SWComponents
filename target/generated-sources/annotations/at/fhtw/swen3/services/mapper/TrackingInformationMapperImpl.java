package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entityForThree.ParcelEntity;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-23T12:09:45+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class TrackingInformationMapperImpl implements TrackingInformationMapper {

    @Override
    public TrackingInformation entityToDto(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        TrackingInformation trackingInformation = new TrackingInformation();

        return trackingInformation;
    }

    @Override
    public ParcelEntity dtoToEntity(TrackingInformation trackingInformation) {
        if ( trackingInformation == null ) {
            return null;
        }

        Float weight = null;
        Recipient recipient = null;
        Recipient sender = null;
        String value = null;
        String trackingId = null;

        ParcelEntity parcelEntity = new ParcelEntity( weight, recipient, sender, value, trackingId );

        return parcelEntity;
    }
}
