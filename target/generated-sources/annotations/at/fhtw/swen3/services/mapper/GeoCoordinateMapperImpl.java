package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entityForEach.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T17:34:32+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class GeoCoordinateMapperImpl implements GeoCoordinateMapper {

    @Override
    public GeoCoordinate entityToDto(GeoCoordinateEntity geoCoordinateEntity) {
        if ( geoCoordinateEntity == null ) {
            return null;
        }

        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat( geoCoordinateEntity.getLat() );
        geoCoordinate.setLon( geoCoordinateEntity.getLon() );

        return geoCoordinate;
    }

    @Override
    public GeoCoordinateEntity dtoToEntity(GeoCoordinate geoCoordinate) {
        if ( geoCoordinate == null ) {
            return null;
        }

        Double lat = null;
        Double lon = null;

        lat = geoCoordinate.getLat();
        lon = geoCoordinate.getLon();

        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity( lat, lon );

        return geoCoordinateEntity;
    }
}