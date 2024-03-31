package com.pattrie.weatherlocation.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String city;
    private String country;
}
