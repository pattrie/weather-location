package com.pattrie.weatherlocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WeatherLocationApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatherLocationApplication.class, args);
  }
}
