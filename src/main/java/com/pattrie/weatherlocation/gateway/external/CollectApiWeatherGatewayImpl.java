package com.pattrie.weatherlocation.gateway.external;

import com.pattrie.weatherlocation.configuration.CollectionApiProperties;
import com.pattrie.weatherlocation.domain.Weather;
import com.pattrie.weatherlocation.gateway.CollectApiWeatherGateway;
import com.pattrie.weatherlocation.gateway.external.client.WeatherClient;
import com.pattrie.weatherlocation.gateway.json.WeatherJsonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(CollectionApiProperties.class)
public class CollectApiWeatherGatewayImpl implements CollectApiWeatherGateway {
  private final WeatherClient weatherClient;
  private final CollectionApiProperties collectionApiProperties;

  @Override
  public Weather getPrediction(final String languageTag, final String city) {
    return weatherClient
        .getPrediction(collectionApiProperties.getToken(), languageTag, city)
        .map(WeatherJsonResponse::toDomain)
        .orElse(null);
  }
}
