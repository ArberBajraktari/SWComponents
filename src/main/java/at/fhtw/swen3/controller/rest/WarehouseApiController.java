package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ApiUtil;
import at.fhtw.swen3.controller.WarehouseApi;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.BLException;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.impl.WarehouseServiceImpl;
import at.fhtw.swen3.services.mapper.WarehouseMapper;
import io.swagger.v3.oas.annotations.Parameter;
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
import javax.annotation.Generated;
import javax.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-05T17:11:31.855527Z[Etc/UTC]")
@Controller
public class WarehouseApiController implements WarehouseApi {

    private final NativeWebRequest request;
    private final WarehouseServiceImpl warehouseServiceImpl;

    @Autowired
    public WarehouseApiController(NativeWebRequest request, WarehouseServiceImpl warehouseService) {
        this.request = request;
        this.warehouseServiceImpl = warehouseService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @ResponseBody
    public ResponseEntity<Hop> getWarehouse(
            @Parameter(name = "code", description = "", required = true) @PathVariable("code") String code
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    try {
                        warehouseServiceImpl.getWarehouseByCode(code);
                    } catch (BLException e) {
                        e.printStackTrace();
                    }
                    String exampleString = "{ \"code\" : \"code\", \"locationName\" : \"locationName\", \"processingDelayMins\" : 0, \"hopType\" : \"hopType\", \"description\" : \"description\", \"locationCoordinates\" : { \"lon\" : 1.4658129805029452, \"lat\" : 6.027456183070403 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ResponseBody
    public ResponseEntity<Warehouse> exportWarehouses(

    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ResponseBody
    public ResponseEntity<Void> importWarehouses(
            @Parameter(name = "Warehouse", description = "", required = true) @Valid @RequestBody Warehouse warehouse
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
