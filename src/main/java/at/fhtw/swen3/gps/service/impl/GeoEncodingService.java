package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;

public interface GeoEncodingService {
    GeoCoordinateEntity encodeAddress(RecipientEntity recipientEntity);
}
