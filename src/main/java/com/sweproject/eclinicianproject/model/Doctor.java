package com.sweproject.eclinicianproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long doctorId;
    private String name;
    private String specialization;
    private String contactPhone;
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

//    @OneToMany(mappedBy = "doctor"
}
