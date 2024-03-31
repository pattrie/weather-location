package com.pattrie.weatherlocation.gateway.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pattrie.weatherlocation.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressJsonResponse {
  private String road;
  private String neighbourhood;
  private String suburb;

  @JsonProperty("city_district")
  private String cityDistrict;

  private String city;
  private String municipality;
  private String county;

  @JsonProperty("state_district")
  private String stateDistrict;

  private String state;

  @JsonProperty("iSO31662Lvl4")
  private String iso;

  private String region;

  @JsonProperty("postcode")
  private String zipCode;

  private String country;

  @JsonProperty("country_code")
  private String countryCode;

  @JsonIgnore
  public Address toDomain() {
    return Address.builder().city(city).country(country).build();
  }
}
