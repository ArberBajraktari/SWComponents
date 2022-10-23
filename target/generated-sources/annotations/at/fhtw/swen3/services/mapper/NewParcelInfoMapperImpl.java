package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entityForThree.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-23T12:09:45+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class NewParcelInfoMapperImpl implements NewParcelInfoMapper {

    @Override
    public NewParcelInfo entityToDto(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo();

        newParcelInfo.setTrackingId( parcelEntity.getTrackingId() );

        return newParcelInfo;
    }

    @Override
    public ParcelEntity dtoToEntity(NewParcelInfo newParcelInfo) {
        if ( newParcelInfo == null ) {
            return null;
        }

        String trackingId = null;

        trackingId = newParcelInfo.getTrackingId();

        Float weight = null;
        Recipient recipient = null;
        Recipient sender = null;
        String value = null;

        ParcelEntity parcelEntity = new ParcelEntity( weight, recipient, sender, value, trackingId );

        return parcelEntity;
    }
}
