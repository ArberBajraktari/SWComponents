package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public abstract class TrackingInformationMapper {
    public static TrackingInformationMapper INSTANCE = Mappers.getMapper(TrackingInformationMapper.class);

    public TrackingInformation entityToDto(ParcelEntity parcelEntity){
        TrackingInformation trackingInformation = new TrackingInformation();
        trackingInformation.setState(TrackingInformation.StateEnum.fromValue(parcelEntity.getValue()));
        List<HopArrival> future = new ArrayList<>();
        List<HopArrival> visited = new ArrayList<>();
        
        for(HopArrivalEntity hopArrivalEntity: parcelEntity.getFutureHops()){
            HopArrival hopArrival = HopArrivalMapperImpl.INSTANCE.entityToDto(hopArrivalEntity);
            future.add(hopArrival);
        }

        for(HopArrivalEntity hopArrivalEntity: parcelEntity.getVisitedHops()){
            HopArrival hopArrival = HopArrivalMapperImpl.INSTANCE.entityToDto(hopArrivalEntity);
            visited.add(hopArrival);
        }
        

        trackingInformation.setFutureHops(future);
        trackingInformation.setVisitedHops(visited);
        return trackingInformation;
    }

    public ParcelEntity dtoToEntity(TrackingInformation trackingInformation){

        List<HopArrivalEntity> future = new ArrayList<>();
        List<HopArrivalEntity> visited = new ArrayList<>();

        for(HopArrival hopArrival: trackingInformation.getFutureHops()){
            HopArrivalEntity hopArrivalEntity = HopArrivalMapperImpl.INSTANCE.dtoToEntity(hopArrival);
            future.add(hopArrivalEntity);
        }

        for(HopArrival hopArrival: trackingInformation.getVisitedHops()){
            HopArrivalEntity hopArrivalEntity = HopArrivalMapperImpl.INSTANCE.dtoToEntity(hopArrival);
            visited.add(hopArrivalEntity);
        }
        return ParcelEntity
                .builder()
                .value(trackingInformation.getState().getValue())
                .futureHops(future)
                .visitedHops(visited)
                .build();
    }

}
