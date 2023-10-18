package com.sweproject.eclinicianproject.repository;


import com.sweproject.eclinicianproject.model.MedicalRecord;
import com.sweproject.eclinicianproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPatient(Patient patient);
}
