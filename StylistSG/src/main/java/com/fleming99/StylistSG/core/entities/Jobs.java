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
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int job_id;

    @Column(name = "initial_date")
    private Date initialDate;

    @Column(name = "dress_description")
    private String dressDescription;

    @OneToOne
    @Column(name = "job_type_id")
    private JobType jobType;

    @Column(name = "job_price")
    private double job_price;

    @Column(name = "job_status")
    private boolean jobStatus;

    @Column(name = "finish_date")
    private Date finishDate;

    @Column(name = "customer_bust")
    private double customerBust;

    @Column(name = "customer_waist")
    private double customerWaist;

    @Column(name = "customer_hip")
    private double customerHip;

    @Column(name = "customer_front_body_height")
    private double customerFrontBodyHeight;

    @Column(name = "customer_back_body_height")
    private double customerBackBodyHeight;

    @Column(name = "customer_os")
    private double customerOs;

    @Column(name = "customer_ss")
    private double customerSs;

    @Column(name = "customer_aq")
    private double customerAq;

    @Column(name = "customer_front_cleavage")
    private double customerFrontCleavage;

    @Column(name = "customer_back_cleavage")
    private double customerBackCleavage;

    @Column(name = "customer_shoulder")
    private double customerShoulder;

    @Column(name = "customer_back")
    private double customerBack;

    @Column(name = "customer_cf")
    private double customerCf;

    @Column(name = "customer_cc")
    private double customerCc;

    @Column(name = "customer_arm_length")
    private double customerArmLength;

    @Column(name = "customer_arm_width")
    private double customerArmWidth;

    @Column(name = "customer_wrist")
    private double customerWrist;

    @Column(name = "customer_comp_blouse")
    private double customerCompBlouse;

    @Column(name = "customer_comp_skirt")
    private double customerCompSkirt;

    @Column(name = "customer_neck")
    private double customerNeck;

    @Column(name = "customer_armhole")
    private double customerArmhole;

    @Column(name = "customer_front_hook")
    private double customerFrontHook;

    @Column(name = "customer_knee")
    private double customerKnee;

    @Column(name = "job_notes")
    private String jobNotes;

    @OneToOne
    @Column(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @Column(name = "job_payment_id")
    private PaymentDetails jobPaymentId;

    @OneToOne
    @Column(name = "stylist_id")
    private StylistEmployee stylistId;
}
