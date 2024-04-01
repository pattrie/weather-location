package com.pattrie.weatherlocation.gateway.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.pattrie.weatherlocation.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReverseGeocodeJsonResponse {
  @JsonProperty("place_id")
  private long placeId;

  private String licence;

  @JsonProperty("osm_type")
  private String osmType;

  @JsonProperty("osm_id")
  private long osmId;

  private String lat;

  private String lon;

  @JsonProperty("class")
  private String locality;

  private String type;

  @JsonProperty("place_rank")
  private int placeRank;

  private float importance;

  @JsonProperty("addresstype")
  private String addressType;

  private String name;

  @JsonProperty("display_name")
  private String displayName;

  private AddressJsonResponse address;

  @JsonProperty("boundingbox")
  private List<String> boundingBox;

  @JsonIgnore
  public Address getAddressDomain() {
    return nonNull(address) ? address.toDomain() : null;
  }
}
