package com.pattrie.weatherlocation.gateway;

import com.pattrie.weatherlocation.domain.Address;
import com.pattrie.weatherlocation.domain.RegionInformation;

import java.io.IOException;

public interface StreetMapGateway {
  Address getAddress(final RegionInformation regionInformation);
}
