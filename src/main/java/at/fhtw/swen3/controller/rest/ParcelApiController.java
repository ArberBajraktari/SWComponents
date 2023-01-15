package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ApiUtil;
import at.fhtw.swen3.controller.ParcelApi;
import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.mapper.ErrorMapperImpl;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.validation.DtoToJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-05T17:11:31.855527Z[Etc/UTC]")
@Controller
@Slf4j
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


    @ResponseBody
    public ResponseEntity<NewParcelInfo> submitParcel (
            @Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel)
    {
        AtomicInteger status = new AtomicInteger();
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ParcelEntity parcelEntity = ParcelMapper.INSTANCE.dtoToEntity(parcel);
                    try {
                        parcelServiceImpl.submitNewParcel(parcelEntity);
                        ApiUtil.setExampleResponse(request, "application/json", "Success");
                        status.set(1);
                    } catch (BLException e) {
                        status.set(2);
                        ErrorEntity errorEntity = e.getErrorEntity();
                        Error error = ErrorMapperImpl.INSTANCE.entityToDto(errorEntity);

                        String jsonString = DtoToJson.toJson(error);

                        ApiUtil.setExampleResponse(request, "application/json", jsonString);
                    }
//                    String exampleString = "{ \"trackingId\" : \"ABC\" }";
//                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        if(status.get() == 1){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    public ResponseEntity<TrackingInformation> trackParcel(
            @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    try {
                        parcelServiceImpl.getParcelByTrackingId(trackingId);
                    } catch (BLException e) {
                        e.printStackTrace();
                    }
                    String exampleString = "{ \"visitedHops\" : [ { \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"code\" : \"code\", \"description\" : \"description\" }, { \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"code\" : \"code\", \"description\" : \"description\" } ], \"futureHops\" : [ { \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"code\" : \"code\", \"description\" : \"description\" }, { \"dateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"code\" : \"code\", \"description\" : \"description\" } ], \"state\" : \"Pickup\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ResponseBody
    public ResponseEntity<NewParcelInfo> transitionParcel(
            @Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId,
            @Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"trackingId\" : \"PYJRB4HZ6\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
