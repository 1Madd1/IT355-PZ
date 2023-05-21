package com.metropolitan.it355pz.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "component")
public class Component {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Lob
    @Column(name = "image", nullable = false)
    private String image;

    @Lob
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

}