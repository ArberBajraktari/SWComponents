package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity.GeoCoordinateEntityBuilder;
import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.HopEntity.HopEntityBuilder;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T16:52:16+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class WarehouseNextHopsMapperImpl implements WarehouseNextHopsMapper {

    @Override
    public WarehouseNextHops entityToDto(WarehouseNextHopsEntity warehouseNextHopsEntity) {
        if ( warehouseNextHopsEntity == null ) {
            return null;
        }

        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setTraveltimeMins( warehouseNextHopsEntity.getTraveltimeMins() );
        warehouseNextHops.setHop( hopEntityToHop( warehouseNextHopsEntity.getHop() ) );

        return warehouseNextHops;
    }

    @Override
    public WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops warehouseNextHops) {
        if ( warehouseNextHops == null ) {
            return null;
        }

        WarehouseNextHopsEntity warehouseNextHopsEntity = new WarehouseNextHopsEntity();

        warehouseNextHopsEntity.setTraveltimeMins( warehouseNextHops.getTraveltimeMins() );
        warehouseNextHopsEntity.setHop( hopToHopEntity( warehouseNextHops.getHop() ) );

        return warehouseNextHopsEntity;
    }

    protected GeoCoordinate geoCoordinateEntityToGeoCoordinate(GeoCoordinateEntity geoCoordinateEntity) {
        if ( geoCoordinateEntity == null ) {
            return null;
        }

        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat( geoCoordinateEntity.getLat() );
        geoCoordinate.setLon( geoCoordinateEntity.getLon() );

        return geoCoordinate;
    }

    protected Hop hopEntityToHop(HopEntity hopEntity) {
        if ( hopEntity == null ) {
            return null;
        }

        Hop hop = new Hop();

        hop.setHopType( hopEntity.getHopType() );
        hop.setCode( hopEntity.getCode() );
        hop.setDescription( hopEntity.getDescription() );
        hop.setProcessingDelayMins( hopEntity.getProcessingDelayMins() );
        hop.setLocationName( hopEntity.getLocationName() );
        hop.setLocationCoordinates( geoCoordinateEntityToGeoCoordinate( hopEntity.getLocationCoordinates() ) );

        return hop;
    }

    protected GeoCoordinateEntity geoCoordinateToGeoCoordinateEntity(GeoCoordinate geoCoordinate) {
        if ( geoCoordinate == null ) {
            return null;
        }

        GeoCoordinateEntityBuilder geoCoordinateEntity = GeoCoordinateEntity.builder();

        geoCoordinateEntity.lat( geoCoordinate.getLat() );
        geoCoordinateEntity.lon( geoCoordinate.getLon() );

        return geoCoordinateEntity.build();
    }

    protected HopEntity hopToHopEntity(Hop hop) {
        if ( hop == null ) {
            return null;
        }

        HopEntityBuilder hopEntity = HopEntity.builder();

        hopEntity.hopType( hop.getHopType() );
        hopEntity.code( hop.getCode() );
        hopEntity.description( hop.getDescription() );
        hopEntity.processingDelayMins( hop.getProcessingDelayMins() );
        hopEntity.locationName( hop.getLocationName() );
        hopEntity.locationCoordinates( geoCoordinateToGeoCoordinateEntity( hop.getLocationCoordinates() ) );

        return hopEntity.build();
    }
}
