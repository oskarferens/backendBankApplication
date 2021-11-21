package com.bank.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Rates {
    @JsonProperty("currency")
    String currency;
    @JsonProperty("code")
    String code;
    @JsonProperty("bid")
    Double bid;
    @JsonProperty("ask")
    Double ask;
}
