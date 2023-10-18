package com.sweproject.eclinicianproject.repository;

import com.sweproject.eclinicianproject.model.Doctor;
import com.sweproject.eclinicianproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

//    List<Patient> findPatientsByDoctorId(Long doctorId);

}
