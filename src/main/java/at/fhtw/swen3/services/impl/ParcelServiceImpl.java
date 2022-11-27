package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    final ParcelRepository parcelRepo;

    @Autowired
    final RecipientRepository recipientRepo;

    @Override
    public String submitNewParcel(ParcelEntity parcelEntity) {

        ParcelEntity parcelEntity1 = parcelRepo.findById(1);
        return parcelEntity1.getTrackingId();
    }

    @Override
    public void getEntityWithId(int id) {
        parcelRepo.findById(id);
        log.info("Finding PArcel via ID");
    }

    @Override
    public ParcelEntity getTrackingInformation(String trackingId) {
        return null;
    }

    @Override
    public ParcelEntity getEntityByTrackingId(String trackingId) {
        return this.parcelRepo.findByTrackingId(trackingId);
    }

}
