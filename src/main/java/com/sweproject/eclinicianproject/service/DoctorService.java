package com.sweproject.eclinicianproject.service;

import com.sweproject.eclinicianproject.model.Doctor;

import java.util.List;

public interface DoctorService {
    void saveDoctor(Doctor doctor);

    Doctor findById(Long id);

    List<Doctor> getAllDoctors();
}
