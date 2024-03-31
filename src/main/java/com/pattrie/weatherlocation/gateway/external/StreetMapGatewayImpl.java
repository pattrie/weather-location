package com.pattrie.weatherlocation.gateway.external;

import com.pattrie.weatherlocation.domain.Address;
import com.pattrie.weatherlocation.domain.RegionInformation;
import com.pattrie.weatherlocation.gateway.StreetMapGateway;
import com.pattrie.weatherlocation.gateway.external.client.NominatimClient;
import com.pattrie.weatherlocation.gateway.json.ReverseGeocodeJsonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StreetMapGatewayImpl implements StreetMapGateway {
  private final NominatimClient nominatimClient;

  @Override
  public Address getAddress(
      final RegionInformation regionInformation) {
    var latitude = regionInformation.getLatitude();
    var longitude = regionInformation.getLongitude();
    return nominatimClient.getReverseGeocode(latitude, longitude)
            .map(ReverseGeocodeJsonResponse::getAddressDomain)
            .orElse(null);
  }
}
