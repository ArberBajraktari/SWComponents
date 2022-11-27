package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.springframework.stereotype.Service;

@Service
public class BingEncodingProxy implements GeoEncodingService{
    @Override
    public GeoCoordinateEntity encodeAddress() {
        // ose kena me dhan return objektin qe rujm ktu ose kena me ba set ne database not sure
        int id = 0;
        double lat = 2.2;
        double lon = 2.1;
        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity(id,lat,lon);
        return geoCoordinateEntity;
    }
}
