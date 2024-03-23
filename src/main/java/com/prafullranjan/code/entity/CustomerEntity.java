package com.prafullranjan.code.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * CustomerEntity
 *
 * @author Prafull
 */
@Data
@Entity
@Table(name="CUSTOMER")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CITY")
    private String city;

}
