package com.pattrie.weatherlocation.gateway.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pattrie.weatherlocation.domain.Weather;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class WeatherJsonResponse {
  private final boolean success;
  private final String city;

  @JsonProperty("result")
  private final List<PredictionJsonResponse> prediction;

  public Weather toDomain() {
    var weatherPredictionForTheWeek =
        prediction.stream().map(PredictionJsonResponse::toDomain).collect(Collectors.toList());

    return Weather.builder()
        .success(success)
        .city(city)
        .prediction(weatherPredictionForTheWeek)
        .build();
  }
}
