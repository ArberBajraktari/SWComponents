package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ParcelApi;
import at.fhtw.swen3.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-05T17:11:31.855527Z[Etc/UTC]")
@Controller
public class ParcelApiController implements ParcelApi {
    private final NativeWebRequest request;

    //private ParcelService parcelService;


//    @Autowired
//    public ParcelApiController(NativeWebRequest request, ParcelService parcelService){
//        this.request = request;
//        this.parcelService = parcelService;
//    }

    @Autowired
    public ParcelApiController(NativeWebRequest request) {
        this.request = request;
    }
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
