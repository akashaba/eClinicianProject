package com.sweproject.eclinicianproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int prescriptionId;
    private String medicine;
    private Instant prescriptionDate;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
}
