package com.fleming99.StylistSG.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
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
    private LocalDate customerBirthDate;

    @Column(name = "customer_age")
    private int customerAge;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "customer_email")
    private String customerEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_address_fk")
    private CustomerAddress customerAddressId;

    @OneToOne(mappedBy = "customerId")
    private Jobs jobs;
}
