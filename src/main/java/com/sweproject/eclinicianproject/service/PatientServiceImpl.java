package com.sweproject.eclinicianproject.service;

import com.sweproject.eclinicianproject.model.Doctor;
import com.sweproject.eclinicianproject.model.Patient;
import com.sweproject.eclinicianproject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient findById(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        return patient;
    }

    @Override
    public List<Patient> getPatientsByDoctor(Doctor doctor) {
        return patientRepository.findByDoctor(doctor);
    }


}
