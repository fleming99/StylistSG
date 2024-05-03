package com.fleming99.StylistSG.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_details")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_first_name")
    private String customerFirstName;

    @Column(name = "customer_last_name")
    private String customerLastName;

    @Column(name = "customer_birth_date")
    private Date customerBirthDate;

    @Column(name = "customer_age")
    private int customerAge;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "customer_email")
    private String customerEmail;
}
