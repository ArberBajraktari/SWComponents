package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entityForEach.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T17:53:31+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class TransferwarehouseMapperImpl implements TransferwarehouseMapper {

    @Override
    public Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity) {
        if ( transferwarehouseEntity == null ) {
            return null;
        }

        Transferwarehouse transferwarehouse = new Transferwarehouse();

        transferwarehouse.setRegionGeoJson( transferwarehouseEntity.getRegionGeoJson() );
        transferwarehouse.setLogisticsPartner( transferwarehouseEntity.getLogisticsPartner() );
        transferwarehouse.setLogisticsPartnerUrl( transferwarehouseEntity.getLogisticsPartnerUrl() );

        return transferwarehouse;
    }

    @Override
    public TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse) {
        if ( transferwarehouse == null ) {
            return null;
        }

        String regionGeoJson = null;
        String logisticsPartner = null;
        String logisticsPartnerUrl = null;

        regionGeoJson = transferwarehouse.getRegionGeoJson();
        logisticsPartner = transferwarehouse.getLogisticsPartner();
        logisticsPartnerUrl = transferwarehouse.getLogisticsPartnerUrl();

        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity( regionGeoJson, logisticsPartner, logisticsPartnerUrl );

        return transferwarehouseEntity;
    }
}
