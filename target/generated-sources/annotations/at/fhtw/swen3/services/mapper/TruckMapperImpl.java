package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entityForEach.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T17:34:32+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class TruckMapperImpl implements TruckMapper {

    @Override
    public Truck entityToDto(TruckEntity truckEntity) {
        if ( truckEntity == null ) {
            return null;
        }

        Truck truck = new Truck();

        truck.setRegionGeoJson( truckEntity.getRegionGeoJson() );
        truck.setNumberPlate( truckEntity.getNumberPlate() );

        return truck;
    }

    @Override
    public TruckEntity dtoToEntity(Truck truck) {
        if ( truck == null ) {
            return null;
        }

        String regionGeoJson = null;
        String numberPlate = null;

        regionGeoJson = truck.getRegionGeoJson();
        numberPlate = truck.getNumberPlate();

        TruckEntity truckEntity = new TruckEntity( regionGeoJson, numberPlate );

        return truckEntity;
    }
}
