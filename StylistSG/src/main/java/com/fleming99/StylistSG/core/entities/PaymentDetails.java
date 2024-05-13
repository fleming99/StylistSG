package com.fleming99.StylistSG.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_details_id")
    private int paymentId;

    @Column(name = "bank_details")
    private String bankDetails;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "payment")
    private double payment;

    @OneToOne(mappedBy = "jobPaymentId")
    private Jobs jobPayment;
}
