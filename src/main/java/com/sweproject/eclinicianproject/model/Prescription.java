package com.sweproject.eclinicianproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medication;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate date;

//    @ManyToOne
//    @JoinColumn(name = "medical_record_id")
//    private MedicalRecord medicalRecord;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
