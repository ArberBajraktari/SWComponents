package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

public interface ParcelService {

    String submitNewParcel(ParcelEntity newParcel) throws BLException;

    String createUniqueTrackingId();

    String getUniqueTrackingId();

    boolean trackingIdExists(String trackingId);

    void getEntityWithId(int id) throws BLException;

    ParcelEntity getParcelByTrackingId(String id) throws BLException;

    public ParcelEntity getTrackingInformation(String trackingId);

    ParcelEntity getEntityByTrackingId(String trackingId);

    String transferParcel(ParcelEntity parcelEntity, String trackingId) throws BLException;
}
