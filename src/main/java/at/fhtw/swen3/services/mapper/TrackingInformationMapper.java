package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class TrackingInformationMapper {
    public static TrackingInformationMapper INSTANCE = Mappers.getMapper(TrackingInformationMapper.class);

    public TrackingInformation entityToDto(ParcelEntity parcelEntity){
        return null;
    }

    public ParcelEntity dtoToEntity(TrackingInformation trackingInformation){
        return ParcelEntity
                .builder()
                .value(trackingInformation.getState().getValue())
                .build();
    }

}
