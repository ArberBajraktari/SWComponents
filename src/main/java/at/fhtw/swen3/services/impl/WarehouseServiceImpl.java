package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    final WarehouseRepository warehouseRepo;

    @Override
    public WarehouseEntity getWarehouseByCode(String code) throws BLException{
        try {
            return new WarehouseEntity();
            //return warehouseRepo.findWarehouseEntityByCode(code);
        }catch (Exception e){
            throw new BLException(e, "Error finding warehouse by code");
        }
    }

//    @Override
//    public WarehouseEntity getWarehouse() throws BLException {
//
//    }
}
