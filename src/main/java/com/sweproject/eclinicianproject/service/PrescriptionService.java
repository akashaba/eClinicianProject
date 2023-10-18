package com.sweproject.eclinicianproject.service;

import com.sweproject.eclinicianproject.model.Patient;
import com.sweproject.eclinicianproject.model.Prescription;

import java.util.List;

public interface PrescriptionService {
    void save(Prescription prescription);
    void savePrescription(Prescription prescription);
    List<Prescription> getPrescriptionsByPatient(Patient patient);
}
