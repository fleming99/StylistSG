package com.fleming99.StylistSG.core.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_type")
public class JobType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_type_id")
    private int jobTypeId;

    @Column(name = "type_name")
    private String typeName;
}
