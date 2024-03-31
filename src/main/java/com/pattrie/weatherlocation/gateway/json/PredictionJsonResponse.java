package com.pattrie.weatherlocation.gateway.json;

import com.pattrie.weatherlocation.domain.Prediction;
import lombok.Builder;

@Builder
public class PredictionJsonResponse {
  private final String date;
  private final String day;
  private final String icon;
  private final String status;
  private final double degree;
  private final double min;
  private final double max;
  private final double night;
  private final long humidity;

  public Prediction toDomain(){
    return Prediction.builder()
            .date(date)
            .day(day)
            .icon(icon)
            .status(status)
            .degree(degree)
            .min(min)
            .max(max)
            .night(night)
            .humidity(humidity)
            .build();
  }
}
