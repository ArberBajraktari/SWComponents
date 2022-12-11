package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class BingEncodingProxy implements GeoEncodingService{
    @Override
    public GeoCoordinateEntity encodeAddress(RecipientEntity recipientEntity) {
        HttpRequest request;
        try {
            URI uri = UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("nominatim.openstreetmap.org")
                    .path("/search")
                    .queryParam("street", recipientEntity.getStreet())
                    .queryParam("city", recipientEntity.getCity())
                    .queryParam("postalcode", recipientEntity.getPostalCode())
                    .queryParam("country", recipientEntity.getCountry())
                    .queryParam("format", "geojson")
                    .build()
                    .encode()
                    .toUri();
            log.info(uri.toString());

            request = HttpRequest.newBuilder()
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .uri(uri)
                    .build();
        } catch (Exception e){
            log.error(e.toString());
            return null;
        }

        HttpResponse<String> response;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e){
            log.error(e.toString());
            return null;
        }

        log.info("HTTP " + response.statusCode() + ": " + response.body());

        try {
            var root = new ObjectMapper().readTree(response.body());
            var coordinates = root.get("features").get(0).get("geometry").get("coordinates");
            GeoCoordinateEntity result = GeoCoordinateEntity.builder()
                    .lat(coordinates.get(0).asDouble())
                    .lon(coordinates.get(1).asDouble()).build();
            return result;
        } catch (JsonProcessingException e) {
            log.error(e.toString());
            return null;
        }
    }
}
