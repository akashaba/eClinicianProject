package com.sweproject.eclinicianproject.controller;

import com.sweproject.eclinicianproject.model.MedicalRecord;
import com.sweproject.eclinicianproject.model.Patient;
import com.sweproject.eclinicianproject.model.Prescription;
import com.sweproject.eclinicianproject.service.MedicalRecordService;
import com.sweproject.eclinicianproject.service.PatientService;
import com.sweproject.eclinicianproject.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/add")
    public String showPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patient/add";
    }

    @GetMapping("/records/{id}")
    public String viewPatientRecords(@PathVariable Long id, Model model) {
        Patient patient = patientService.findById(id);
        List<MedicalRecord> medicalRecords = patient.getMedicalRecords();
        model.addAttribute("patient", patient);
        model.addAttribute("medicalRecords", medicalRecords);
        return "viewPatientRecords";
    }
    @GetMapping("/{patientId}/records")
    public String getPatientMedicalRecords(@PathVariable Long patientId, Model model) {
        Patient patient = patientService.findById(patientId);
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordsByPatient(patient);
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatient(patient);
        model.addAttribute("patient", patient);
        model.addAttribute("medicalRecords", medicalRecords);
        model.addAttribute("prescriptions", prescriptions);
        return "medical_records";
    }
    @GetMapping("/{patientId}/add/record")
    public String showAddMedicalRecordForm(@PathVariable Long patientId, Model model) {
        Patient patient = patientService.findById(patientId);
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatient(patient);
        model.addAttribute("medicalRecord", medicalRecord);
        return "add_medical_record";
    }

    @PostMapping("/{patientId}/add/record")
    public String addMedicalRecord(@PathVariable Long patientId, @ModelAttribute MedicalRecord medicalRecord) {
        Patient patient = patientService.findById(patientId);
        medicalRecord.setPatient(patient);
        medicalRecordService.saveMedicalRecord(medicalRecord);
        return "redirect:/patients/" + patientId + "/records";
    }

    @GetMapping("/{patientId}/add/prescription")
    public String showAddPrescriptionForm(@PathVariable Long patientId, Model model) {
        Patient patient = patientService.findById(patientId);
        Prescription prescription = new Prescription();
        prescription.setPatient(patient);
        model.addAttribute("prescription", prescription);
        return "add_prescription";
    }

    @PostMapping("/{patientId}/add/prescription")
    public String addPrescription(@PathVariable Long patientId, @ModelAttribute Prescription prescription) {
        Patient patient = patientService.findById(patientId);
        prescription.setPatient(patient);
        prescriptionService.savePrescription(prescription);
        return "redirect:/patients/" + patientId + "/records";
    }
}
