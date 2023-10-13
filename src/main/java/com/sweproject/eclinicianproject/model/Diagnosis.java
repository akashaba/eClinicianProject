package com.sweproject.eclinicianproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int diagnosisId;
    private String diagnosis;
    private Instant diagnosisDate;
    @ManyToOne
    @JoinColumn
    private Doctor doctor;
    @ManyToOne
    @JoinColumn
    private Patient patient;
}
