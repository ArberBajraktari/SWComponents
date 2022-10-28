package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import java.time.OffsetDateTime;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-28T20:39:32+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class HopArrivalMapperImpl implements HopArrivalMapper {

    @Override
    public HopArrival entityToDto(HopArrivalEntity hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        HopArrival hopArrival = new HopArrival();

        hopArrival.setCode( hopArrivalEntity.getCode() );
        hopArrival.setDescription( hopArrivalEntity.getDescription() );
        hopArrival.setDateTime( hopArrivalEntity.getDateTime() );

        return hopArrival;
    }

    @Override
    public HopArrivalEntity dtoToEntity(HopArrival hopArrival) {
        if ( hopArrival == null ) {
            return null;
        }

        String code = null;
        String description = null;
        OffsetDateTime dateTime = null;

        code = hopArrival.getCode();
        description = hopArrival.getDescription();
        dateTime = hopArrival.getDateTime();

        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity( code, description, dateTime );

        return hopArrivalEntity;
    }
}
