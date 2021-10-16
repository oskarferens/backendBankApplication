package com.bank.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties (ignoreUnknown = true)
public class RatesDto {

    @JsonProperty("PLN")
    private double PLN;

    @JsonProperty("EUR")
    private double EUR;

    @JsonProperty("USD")
    private double USD;

    @JsonProperty("all")
    private double all;

}
