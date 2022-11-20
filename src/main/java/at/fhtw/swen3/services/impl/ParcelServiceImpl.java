package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    final ParcelRepository parcelRepo;

    final RecipientRepository recipientRepo;

    @Override
    public void submitNewParcel(ParcelEntity newParcel) {
//        parcelRepo.save(newParcel);
        log.info("New Parcel Entry");
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

}
