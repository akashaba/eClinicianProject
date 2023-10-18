package com.sweproject.eclinicianproject.service;

import com.sweproject.eclinicianproject.model.MedicalRecord;
import com.sweproject.eclinicianproject.model.Patient;
import com.sweproject.eclinicianproject.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public void saveMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public MedicalRecord findById(Long medicalRecordId) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
        return medicalRecord;
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsByPatient(Patient patient) {
        return medicalRecordRepository.findByPatient(patient);
    }
}
