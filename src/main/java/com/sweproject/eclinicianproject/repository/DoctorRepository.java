package com.sweproject.eclinicianproject.repository;

import com.sweproject.eclinicianproject.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}