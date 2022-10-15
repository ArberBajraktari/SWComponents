package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entityForEach.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T17:34:33+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class WarehouseMapperImpl implements WarehouseMapper {

    @Override
    public Warehouse entityToDto(WarehouseEntity warehouseEntity) {
        if ( warehouseEntity == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.setLevel( warehouseEntity.getLevel() );
        List<WarehouseNextHops> list = warehouseEntity.getNextHops();
        if ( list != null ) {
            warehouse.setNextHops( new ArrayList<WarehouseNextHops>( list ) );
        }

        return warehouse;
    }

    @Override
    public WarehouseEntity dtoToEntity(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        Integer level = null;
        List<WarehouseNextHops> nextHops = null;

        level = warehouse.getLevel();
        List<WarehouseNextHops> list = warehouse.getNextHops();
        if ( list != null ) {
            nextHops = new ArrayList<WarehouseNextHops>( list );
        }

        WarehouseEntity warehouseEntity = new WarehouseEntity( level, nextHops );

        return warehouseEntity;
    }
}
