package com.pattrie.weatherlocation.gateway.external.client;

import com.pattrie.weatherlocation.gateway.json.ReverseGeocodeJsonResponse;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nominatimClient", url = "${feign.nominatim.url:nominatimClient}")
public interface NominatimClient {
  @GetMapping(
      value = "/reverse?format=json&lat={latitude}&lon={longitude}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Optional<ReverseGeocodeJsonResponse> getReverseGeocode(
      @RequestParam("lat") final float latitude, @RequestParam("lon") final float longitude);
}
