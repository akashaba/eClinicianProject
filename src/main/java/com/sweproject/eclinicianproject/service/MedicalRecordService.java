package com.sweproject.eclinicianproject.service;

import com.sweproject.eclinicianproject.model.MedicalRecord;
import com.sweproject.eclinicianproject.model.Patient;

import java.util.List;

public interface MedicalRecordService {
    void saveMedicalRecord(MedicalRecord medicalRecord);

    MedicalRecord findById(Long medicalRecordId);
    List<MedicalRecord> getMedicalRecordsByPatient(Patient patient);
}
