package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TrackingInformationMapper {
    TrackingInformationMapper INSTANCE = Mappers.getMapper(TrackingInformationMapper.class);

    default TrackingInformation entityToDto(ParcelEntity parcelEntity){
        return null;
    }

    default ParcelEntity dtoToEntity(TrackingInformation trackingInformation){
        return ParcelEntity
                .builder()
                .value(trackingInformation.getState().getValue())
                .build();
    }

}
