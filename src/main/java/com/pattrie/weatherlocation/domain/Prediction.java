package com.pattrie.weatherlocation.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Prediction {
  private final String date;
  private final String day;
  private final String icon;
  private final String status;
  private final double degree;
  private final double min;
  private final double max;
  private final double night;
  private final long humidity;
}
