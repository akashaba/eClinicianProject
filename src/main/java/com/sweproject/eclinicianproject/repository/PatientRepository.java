package com.sweproject.eclinicianproject.repository;

import com.sweproject.eclinicianproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
