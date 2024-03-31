package com.pattrie.weatherlocation.gateway;

import com.pattrie.weatherlocation.domain.Weather;

public interface CollectApiWeatherGateway {
    Weather getPrediction(final String languageTag, final String city);
}
