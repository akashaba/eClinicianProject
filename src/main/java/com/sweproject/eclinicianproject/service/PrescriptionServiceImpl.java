package com.sweproject.eclinicianproject.service;

import com.sweproject.eclinicianproject.model.Patient;
import com.sweproject.eclinicianproject.model.Prescription;
import com.sweproject.eclinicianproject.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public void save(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    @Override
    public void savePrescription(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    @Override
    public List<Prescription> getPrescriptionsByPatient(Patient patient) {
        return prescriptionRepository.findByPatient(patient);
    }
}
