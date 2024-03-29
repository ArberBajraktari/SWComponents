package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.HopRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.persistence.repositories.WarehouseRepository;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public ParcelServiceImpl parcelService(ParcelRepository parcelRepository, RecipientRepository recipientRepository, HopRepository hopRepository) {
        return new ParcelServiceImpl(parcelRepository, recipientRepository, hopRepository);
    }

    @Bean
    public WarehouseServiceImpl warehouseService(WarehouseRepository warehouseRepository){
        return new WarehouseServiceImpl(warehouseRepository);
    }

}
