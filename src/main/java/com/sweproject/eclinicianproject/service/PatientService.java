package com.sweproject.eclinicianproject.service;

import com.sweproject.eclinicianproject.model.Doctor;
import com.sweproject.eclinicianproject.model.Patient;

import java.util.List;

public interface PatientService {
    void savePatient(Patient patient);

    Patient findById(Long patientId);
    List<Patient> getPatientsByDoctor(Doctor doctor);
}
