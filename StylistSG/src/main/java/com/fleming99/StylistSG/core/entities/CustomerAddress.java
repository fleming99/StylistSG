package com.fleming99.StylistSG.core.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_address")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_address_id")
    private int customerAddressId;

    @Column(name = "customer_street_name")
    private String customerStreetName;

    @Column(name = "customer_neighborhood")
    private String customerNeighborhood;

    @Column(name = "customer_house_number")
    private String customerHouseNumber;

    @Column(name = "customer_city")
    private String customerCity;

    @Column(name = "customer_state")
    private String customerState;

    @Column(name = "customer_country")
    private String customerCountry;

    @ManyToOne
    @Column(name = "customer_id")
    private Customer customerId;
}
