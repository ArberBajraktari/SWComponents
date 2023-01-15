package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.DALException;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.validation.TestValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService{

    @Autowired
    final ParcelRepository parcelRepo;

    @Autowired
    final RecipientRepository recipientRepo;

    @Override
    public String submitNewParcel(ParcelEntity parcelEntity) throws BLException {
        try{
            TestValidation.entityValidated(parcelEntity);
            parcelRepo.saveAndFlush(parcelEntity);
        }
        catch(ConstraintViolationException e){
            throw new BLException(e, "Data not valid");
        }
            return "Saved";
    }

    @Override
    public void getEntityWithId(int id) throws BLException {
        try {
            parcelRepo.findById(id);
        } catch (Exception e) {
            throw new BLException(e, "Failed to submit New Parcel");
        }
        log.info("Finding Parcel via ID");
    }

    @Override
    public ParcelEntity getParcelByTrackingId(String id) throws BLException{
        try {
            return parcelRepo.findByTrackingId(id);
        } catch (Exception e) {
            throw new BLException(e, "Failed to submit New Parcel");
        }
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
