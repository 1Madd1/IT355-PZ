package com.metropolitan.it355pz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreditCardDTO implements Serializable {

    @JsonProperty("userId")
    private Integer userId = null;

    @JsonProperty("number")
    private String number = null;

    @JsonProperty("date")
    private String date = null;

    @JsonProperty("cvv2")
    private String cvv2 = null;

    @JsonProperty("money")
    private Double money = null;

}
