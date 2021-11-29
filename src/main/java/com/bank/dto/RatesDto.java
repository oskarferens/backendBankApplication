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
    @JsonProperty("currency")
    String currency;
    @JsonProperty("code")
    String code;
    @JsonProperty("bid")
    Double bid;
    @JsonProperty("ask")
    Double ask;
}
