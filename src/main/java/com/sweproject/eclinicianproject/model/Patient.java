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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long patientId;
    private String name;
    private int age;
    private String address;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(mappedBy = "patient")
    private List<MedicalRecord> medicalRecords;
    @OneToMany(mappedBy = "patient")
    private List<Prescription> prescriptions;

}
