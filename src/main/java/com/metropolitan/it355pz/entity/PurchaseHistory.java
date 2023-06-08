package com.metropolitan.it355pz.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {
    @Id
    @GeneratedValue
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