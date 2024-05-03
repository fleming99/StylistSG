package com.fleming99.StylistSG.core.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stylist_employee")
public class StylistEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stylist_employee_id")
    private int stylistId;

    @Column(name = "stylist_first_name")
    private String stylistFirstName;

    @Column(name = "stylist_last_name")
    private String stylistLastName;

    @Column(name = "stylist_cpf")
    private String stylistCpf;

    @Column(name = "stylist_rg")
    private String stylistRg;

    @Column(name = "stylist_email")
    private String stylistEmail;

    @Column(name = "stylist_password")
    private String stylistPassword;

    @Column(name = "active_profile")
    private boolean activeProfile;

    @JoinColumn(name = "users_role_relationship")
    private Collection<StylistRole> roles;
}
