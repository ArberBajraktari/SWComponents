package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelService;

public class ParcelServiceImpl extends ParcelService {
    private ParcelRepository repo;
    public ParcelServiceImpl(ParcelRepository repo){
        this.repo = repo;
    }

    public void SubmitNewParcel(ParcelEntity newParcel){
        repo.addNewParcel();
    }


}
