package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

public interface ParcelService {

    String submitNewParcel(ParcelEntity newParcel) throws BLException;

    void getEntityWithId(int id);

    ParcelEntity getParcelByTrackingId(String id) throws BLException;

    public ParcelEntity getTrackingInformation(String trackingId);

    ParcelEntity getEntityByTrackingId(String trackingId);

}
