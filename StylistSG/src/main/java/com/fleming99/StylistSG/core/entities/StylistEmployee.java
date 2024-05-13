package com.fleming99.StylistSG.core.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_role_relationship",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name_id"))
    private Collection<StylistRole> userRoles;

    @OneToOne(mappedBy = "stylistId")
    private Jobs stylistJob;

    public StylistEmployee(String stylistEmail, String stylistPassword, Collection<StylistRole> userRoles, boolean activeProfile){
        this.stylistEmail = stylistEmail;
        this.stylistPassword = stylistPassword;
        this.activeProfile = activeProfile;
        this.userRoles = userRoles;
    }
}
