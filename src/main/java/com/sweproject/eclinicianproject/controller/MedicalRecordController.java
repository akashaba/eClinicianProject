package com.sweproject.eclinicianproject.controller;

import com.sweproject.eclinicianproject.model.Doctor;
import com.sweproject.eclinicianproject.model.MedicalRecord;
import com.sweproject.eclinicianproject.model.Patient;
import com.sweproject.eclinicianproject.service.DoctorService;
import com.sweproject.eclinicianproject.service.MedicalRecordService;
import com.sweproject.eclinicianproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/medicalrecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/add/{patientId}")
    public String showMedicalRecordForm(@PathVariable Long patientId, Model model) {
        Patient patient = patientService.findById(patientId);
        Doctor doctor = patient.getDoctor();
        model.addAttribute("patient", patient);
        model.addAttribute("doctor", doctor);
        model.addAttribute("medicalRecord", new MedicalRecord());
        return "addMedicalRecord";
    }

//    @PostMapping("/add/{patientId}")
//    public String addMedicalRecord(
//            @PathVariable Long patientId,
//            @ModelAttribute MedicalRecord medicalRecord) {
//        Patient patient = patientService.findById(patientId);
//        Doctor doctor = patient.getDoctor();
//
//        medicalRecord.setPatient(patient);
//        medicalRecord.setDoctor(doctor);
//        medicalRecord.setDiagnosisDate(new Date());
//
//        medicalRecordService.save(medicalRecord);
//        return "redirect:/doctor/patients/" + doctor.getDoctorId();
//    }
}
