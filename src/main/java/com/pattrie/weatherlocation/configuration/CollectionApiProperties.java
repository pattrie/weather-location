package com.pattrie.weatherlocation.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(value = "collectionapi")
public class CollectionApiProperties {
  private String token;
}
