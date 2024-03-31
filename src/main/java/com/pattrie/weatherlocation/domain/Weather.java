package com.pattrie.weatherlocation.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Weather {
  private final boolean success;
  private final String city;
  private final List<Prediction> prediction;
  private final String message;
}
