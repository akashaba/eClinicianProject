package com.sweproject.eclinicianproject.repository;

import com.sweproject.eclinicianproject.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
}
