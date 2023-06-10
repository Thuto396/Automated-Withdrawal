package com.momentum.automatedwithdrawal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
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
    private int id;
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
    private LocalDate date_of_birth;
    //These values can be mapped to the database



    @Override
    public String toString() {
        return "Investor{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", email='" + email + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
