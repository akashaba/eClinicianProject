package com.sweproject.eclinicianproject.service;

import com.sweproject.eclinicianproject.model.Doctor;
import com.sweproject.eclinicianproject.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor findById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        return doctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
