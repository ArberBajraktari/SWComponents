package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;

public interface WarehouseService {
    WarehouseEntity getWarehouseByCode(String code) throws BLException;
    //WarehouseEntity getWarehouse() throws BLException;
}
