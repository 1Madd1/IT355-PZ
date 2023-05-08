package com.metropolitan.it355pz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "componentId", nullable = false)
    private Integer componentId;

    @Column(name = "computerId", nullable = false)
    private Integer computerId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "totalPrice", nullable = false)
    private Double totalPrice;

    @Column(name = "purchaseDate", nullable = false)
    private LocalDate purchaseDate;

}