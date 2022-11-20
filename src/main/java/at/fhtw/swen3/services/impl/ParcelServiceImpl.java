package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    ParcelRepository parcelRepo;
    RecipientRepository recipientRepo;

    @Autowired
    ParcelServiceImpl (ParcelRepository parcelRepo, RecipientRepository recipientRepo){
        this.parcelRepo = parcelRepo;
        this.recipientRepo = recipientRepo;
    }

    @Override
    public void submitNewParcel(ParcelEntity newParcel) {
        parcelRepo.save(newParcel);
        log.info("New Parcel Entry");
    }

    @Override
    public ParcelEntity getTrackingInformation(String trackingId) {
        return null;
    }


}
