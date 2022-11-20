package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.mapper.GeoCoordinateMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GeoCoordinateMapperTest {
    @Test
    void entityToDto() {
        //Create Entity
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity(1, 10.0,20.0);
        //Turn Entity into DTO
        GeoCoordinate geoCoordinate = GeoCoordinateMapper.INSTANCE.entityToDto(geoCoordinateEntity);

        //Assert Equals
        assertEquals(10.0, geoCoordinate.getLat());
        assertEquals(20.0, geoCoordinate.getLon());
    }

    @Test
    void dtoToEntity() {
        //Create DTO
        GeoCoordinate geoCoordinate = new GeoCoordinate();
        geoCoordinate.setLat(10.0);
        geoCoordinate.setLon(15.0);

        //Turn DTO into entity
        GeoCoordinateEntity geoCoordinateEntity = GeoCoordinateMapper.INSTANCE.dtoToEntity(geoCoordinate);

        //Assert
        assertEquals(10.0, geoCoordinateEntity.getLat());
        assertNotEquals(20.0, geoCoordinateEntity.getLon());
    }

}
