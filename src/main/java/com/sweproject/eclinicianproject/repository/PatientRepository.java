package com.sweproject.eclinicianproject.repository;

import com.sweproject.eclinicianproject.model.Doctor;
import com.sweproject.eclinicianproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
//    @Query("SELECT d.doctor FROM Patient d WHERE d.doctor_id = :doctorId")
//    List<Patient> findPatientsByDoctorId(Long doctorId);
    List<Patient> findByDoctor(Doctor doctor);
}
