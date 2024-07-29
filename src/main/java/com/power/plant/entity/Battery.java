package com.power.plant.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String postcode;

    @Column(nullable = false)
    private Integer wattCapacity;
}
