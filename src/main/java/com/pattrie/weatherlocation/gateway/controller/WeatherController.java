package com.pattrie.weatherlocation.gateway.controller;

import com.pattrie.weatherlocation.domain.RegionInformation;
import com.pattrie.weatherlocation.domain.Weather;
import com.pattrie.weatherlocation.usecase.WeatherPredictionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
@AllArgsConstructor
@Slf4j
public class WeatherController {

  private final WeatherPredictionService weatherPredictionService;

  @ApiOperation(value = "Get the weather report")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully obtained the weather report")
      })
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Weather getPrediction(
      @RequestHeader(name = "latitude", required = false) Float latitude,
      @RequestHeader(name = "longitude", required = false) Float longitude) {
    log.info("Request receive: {} {}", latitude, longitude);
    var regionInformation =
        RegionInformation.builder().latitude(latitude).longitude(longitude).build();
    return weatherPredictionService.execute(regionInformation);
  }
}
