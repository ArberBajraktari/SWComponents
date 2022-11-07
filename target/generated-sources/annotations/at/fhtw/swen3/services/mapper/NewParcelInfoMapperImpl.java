package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity.ParcelEntityBuilder;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T12:42:51+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
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

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.trackingId( newParcelInfo.getTrackingId() );

        return parcelEntity.build();
    }
}
