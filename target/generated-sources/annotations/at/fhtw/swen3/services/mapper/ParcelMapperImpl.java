package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-28T20:39:33+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public Parcel entityToDto(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        Parcel parcel = new Parcel();

        parcel.setWeight( parcelEntity.getWeight() );
        parcel.setRecipient( parcelEntity.getRecipient() );
        parcel.setSender( parcelEntity.getSender() );

        return parcel;
    }

    @Override
    public ParcelEntity dtoToEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        Float weight = null;
        Recipient recipient = null;
        Recipient sender = null;

        weight = parcel.getWeight();
        recipient = parcel.getRecipient();
        sender = parcel.getSender();

        String value = null;
        String trackingId = null;

        ParcelEntity parcelEntity = new ParcelEntity( weight, recipient, sender, value, trackingId );

        return parcelEntity;
    }
}
