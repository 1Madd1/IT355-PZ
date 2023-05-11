package com.metropolitan.it355pz.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "card_number", nullable = false, length = 19)
    private String cardNumber;

    @Column(name = "card_date", nullable = false, length = 5)
    private String cardDate;

    @Column(name = "cvv2", nullable = false, length = 3)
    private String cvv2;

    @Column(name = "money", nullable = false)
    private Double money;

}