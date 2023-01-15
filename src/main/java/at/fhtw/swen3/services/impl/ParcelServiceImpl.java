package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.gps.service.impl.BingEncodingProxy;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.validation.TestValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService{

    @Autowired
    final ParcelRepository parcelRepo;

    @Autowired
    final RecipientRepository recipientRepo;

    @Autowired
    final HopRepository hopRepository;

    @Override
    public String submitNewParcel(ParcelEntity parcelEntity) throws BLException {
        try{
            TestValidation.entityValidated(parcelEntity);
            //Create Tracking id
            parcelEntity.setTrackingId(getUniqueTrackingId());

            //Get Geo for Hop
            BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
            GeoCoordinateEntity geoCoordinateEntity = bingEncodingProxy.encodeAddress(parcelEntity.getSender());

            //Create Hop
            HopEntity hopEntity = new HopEntity();
            hopEntity.setLocationCoordinates(geoCoordinateEntity);
            hopRepository.saveAndFlush(hopEntity);

            geoCoordinateEntity = bingEncodingProxy.encodeAddress(parcelEntity.getRecipient());
            hopEntity.setLocationCoordinates(geoCoordinateEntity);
            hopRepository.saveAndFlush(hopEntity);

            parcelEntity.setValue("Pickup");

            parcelRepo.saveAndFlush(parcelEntity);
        }
        catch(ConstraintViolationException e){
            throw new BLException(e, "Data not valid");
        }
            return parcelEntity.getTrackingId();
    }

    @Override
    public String createUniqueTrackingId() {
        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(9);

        for (int i = 0; i < 9; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    @Override
    public String getUniqueTrackingId() {
        String trackingId = createUniqueTrackingId();
        if(parcelRepo.findByTrackingId(trackingId) != null) {
            ParcelEntity parcelEntity = parcelRepo.findByTrackingId(trackingId);
            return parcelEntity.getTrackingId();
        }else{
            return trackingId;
        }
    }


    @Override
    public boolean trackingIdExists(String trackingId){
        if(parcelRepo.findByTrackingId(trackingId) != null) {
            ParcelEntity parcelEntity = parcelRepo.findByTrackingId(trackingId);
            log.info(parcelEntity.getTrackingId());
            return true;
        }else{
            return false;
        }
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
            throw new BLException(e, "Failed to find Parcel by Tracking Id");
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
    @Override
    public String transferParcel(ParcelEntity parcelEntity, String trackingId) throws BLException {
        try{
            TestValidation.entityValidated(parcelEntity);

            if(trackingIdExists(trackingId)){
                return "Tracking Id already exists";
            }

            //Get Geo for Hop
            BingEncodingProxy bingEncodingProxy = new BingEncodingProxy();
            GeoCoordinateEntity geoCoordinateEntity = bingEncodingProxy.encodeAddress(parcelEntity.getSender());

            //Create Hop
            HopEntity hopEntity = new HopEntity();
            hopEntity.setLocationCoordinates(geoCoordinateEntity);
            hopRepository.saveAndFlush(hopEntity);

            geoCoordinateEntity = bingEncodingProxy.encodeAddress(parcelEntity.getRecipient());
            hopEntity.setLocationCoordinates(geoCoordinateEntity);
            hopRepository.saveAndFlush(hopEntity);

            parcelEntity.setValue("Pickup");

            parcelRepo.saveAndFlush(parcelEntity);
        }
        catch(ConstraintViolationException e){
            throw new BLException(e, "Data not valid");
        }
        return parcelEntity.getTrackingId();
    }
}
