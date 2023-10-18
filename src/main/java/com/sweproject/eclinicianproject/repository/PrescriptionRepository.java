package com.sweproject.eclinicianproject.repository;

import com.sweproject.eclinicianproject.model.Patient;
import com.sweproject.eclinicianproject.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByPatient(Patient patient);
}
