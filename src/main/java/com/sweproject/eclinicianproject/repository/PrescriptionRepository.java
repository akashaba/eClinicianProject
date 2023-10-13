package com.sweproject.eclinicianproject.repository;

import com.sweproject.eclinicianproject.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
}
