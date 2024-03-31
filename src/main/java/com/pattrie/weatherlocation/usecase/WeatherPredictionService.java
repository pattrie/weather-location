package com.pattrie.weatherlocation.usecase;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNullElse;

import com.pattrie.weatherlocation.common.exception.UnexpectedResultException;
import com.pattrie.weatherlocation.domain.RegionInformation;
import com.pattrie.weatherlocation.domain.Weather;
import com.pattrie.weatherlocation.gateway.CollectApiWeatherGateway;
import com.pattrie.weatherlocation.gateway.StreetMapGateway;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherPredictionService {
  private final String languageTag = Locale.forLanguageTag("pt-Br").toLanguageTag();
  private final StreetMapGateway streetMapGateway;
  private final CollectApiWeatherGateway collectApiWeatherGateway;
  private String city = "São Paulo";

  public Weather execute(final RegionInformation regionInformation) {
    validateAddress(regionInformation);

    var weatherPrediction = collectApiWeatherGateway.getPrediction(languageTag, city);
    var isWeatherPredictionValid = nonNull(weatherPrediction) && weatherPrediction.isSuccess();
    if (isWeatherPredictionValid) return weatherPrediction;

    var message =
        requireNonNullElse(
            weatherPrediction.getMessage(),
            String.format("Unexpected result of %s", collectApiWeatherGateway.getClass().getName()));
    throw new UnexpectedResultException(message);
  }

  private void validateAddress(final RegionInformation regionInformation) {
    if (regionInformation.isTheRegionInformationPopulated()) {
      var address = streetMapGateway.getAddress(regionInformation);
      final boolean isTheCityFilled = nonNull(address) && nonNull(address.getCity());
      city = isTheCityFilled ? address.getCity() : city;
    }
  }
}
