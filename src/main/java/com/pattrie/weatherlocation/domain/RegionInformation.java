package com.pattrie.weatherlocation.domain;

import java.util.Objects;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegionInformation {
  private final Float latitude;
  private final Float longitude;

  public boolean isTheRegionInformationPopulated() {
    return Objects.nonNull(latitude) && Objects.nonNull(longitude);
  }
}
