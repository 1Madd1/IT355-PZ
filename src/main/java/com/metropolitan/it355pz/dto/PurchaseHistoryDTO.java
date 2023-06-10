package com.metropolitan.it355pz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PurchaseHistoryDTO {
    @JsonProperty("userId")
    private Integer userId = null;

    @JsonProperty("componentId")
    private Integer componentId = null;

    @JsonProperty("computerId")
    private Integer computerId = null;

    @JsonProperty("quantity")
    private Integer quantity = null;

    @JsonProperty("totalPrice")
    private Double totalPrice = null;

    @JsonProperty("purchaseDate")
    private String purchaseDate = null;
}
