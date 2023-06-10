package com.momentum.automatedwithdrawal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(
        name = "investors",
        schema = "postgres"
)//This provides the name of the table and database used
@Getter
@Setter//Lombok dependency that
@NoArgsConstructor//
@AllArgsConstructor
//Lombok's dependency has annotations to create constructors,getters&setters to reduce boilerplate code


public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Creates PRIMARY KEY
    private Long id;
    @Column(nullable = false)//This ensures that the column is not null
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, length = 10)//specified length
    private String mobile_number;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date date_of_birth;
    //These values can be mapped to the database
}
