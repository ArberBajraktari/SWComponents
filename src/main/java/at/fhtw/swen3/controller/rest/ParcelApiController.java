package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ParcelApi;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-05T17:11:31.855527Z[Etc/UTC]")
@Controller
public class ParcelApiController implements ParcelApi {
    private final NativeWebRequest request;

    private ParcelServiceImpl parcelServiceImpl;


    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelServiceImpl parcelServiceImpl){
        this.request = request;
        this.parcelServiceImpl = parcelServiceImpl;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

//    @Override
//    public String addParcel(Parcel parcel) throws BLException {
//        ParcelEntity parcelEntity = ParcelMapperImpl.INSTANCE.dtoToEntity(parcel);
//        return this.parcelServiceImpl.submitNewParcel(parcelEntity);
//    }
//
//    @Override
//    public String getParcel(String trackingId) {
//        ParcelEntity parcelEntity = this.parcelServiceImpl.getEntityByTrackingId(trackingId);
//        return parcelEntity.getValue();
//    }

}
