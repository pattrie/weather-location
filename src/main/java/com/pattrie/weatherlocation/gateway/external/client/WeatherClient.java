package com.pattrie.weatherlocation.gateway.external.client;

import com.pattrie.weatherlocation.gateway.json.WeatherJsonResponse;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "${feign.collectionapi.weather.name:weatherClient}",
    url = "${feign.collectionapi.weather.url:weatherClient}")
public interface WeatherClient {
  @GetMapping("/getWeather?data.lang={languageTag}&data.city={city}")
  Optional<WeatherJsonResponse> getPrediction(
      @RequestHeader("Authorization") String authorization,
      @RequestParam("data.lang") final String languageTag,
      @RequestParam("data.city") final String city);
}
