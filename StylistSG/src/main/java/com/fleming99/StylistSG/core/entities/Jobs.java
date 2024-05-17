package com.fleming99.StylistSG.core.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    @Column(name = "job_id")
    private int jobId;

    @Column(name = "initial_date")
    private LocalDate initialDate;

    @Column(name = "dress_description")
    private String dressDescription;

    @OneToOne
    @JoinColumn(name = "job_type_id")
    private JobType jobType;

    @Column(name = "job_price")
    private String jobPrice;

    @Column(name = "job_status")
    private boolean jobStatus;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @Column(name = "customer_bust")
    private String customerBust;

    @Column(name = "customer_waist")
    private String customerWaist;

    @Column(name = "customer_hip")
    private String customerHip;

    @Column(name = "customer_front_body_height")
    private String customerFrontBodyHeight;

    @Column(name = "customer_back_body_height")
    private String customerBackBodyHeight;

    @Column(name = "customer_os")
    private String customerOs;

    @Column(name = "customer_ss")
    private String customerSs;

    @Column(name = "customer_aq")
    private String customerAq;

    @Column(name = "customer_front_cleavage")
    private String customerFrontCleavage;

    @Column(name = "customer_back_cleavage")
    private String customerBackCleavage;

    @Column(name = "customer_shoulder")
    private String customerShoulder;

    @Column(name = "customer_back")
    private String customerBack;

    @Column(name = "customer_cf")
    private String customerCf;

    @Column(name = "customer_cc")
    private String customerCc;

    @Column(name = "customer_arm_width")
    private String customerArmWidth;

    @Column(name = "customer_arm_length")
    private String customerArmLength;

    @Column(name = "customer_wrist")
    private String customerWrist;

    @Column(name = "customer_comp_blouse")
    private String customerCompBlouse;

    @Column(name = "customer_comp_skirt")
    private String customerCompSkirt;

    @Column(name = "customer_neck")
    private String customerNeck;

    @Column(name = "customer_armhole")
    private String customerArmhole;

    @Column(name = "customer_front_hook")
    private String customerFrontHook;

    @Column(name = "customer_back_hook")
    private String customerBackHook;

    @Column(name = "customer_knee")
    private String customerKnee;

    @Column(name = "job_notes")
    private String jobNotes;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @OneToMany(mappedBy = "jobPayment", cascade = CascadeType.ALL)
    private List<PaymentDetails> jobPaymentId;
}