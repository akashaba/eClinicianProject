package com.sweproject.eclinicianproject.controller;

import com.sweproject.eclinicianproject.model.MedicalRecord;
import com.sweproject.eclinicianproject.model.Prescription;
import com.sweproject.eclinicianproject.service.MedicalRecordService;
import com.sweproject.eclinicianproject.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/add/{medicalRecordId}")
    public String showPrescriptionForm(@PathVariable Long medicalRecordId, Model model) {
        MedicalRecord medicalRecord = medicalRecordService.findById(medicalRecordId);
        model.addAttribute("medicalRecord", medicalRecord);
        model.addAttribute("prescription", new Prescription());
        return "addPrescription";
    }

//    @PostMapping("/add/{medicalRecordId}")
//    public String addPrescription(
//            @PathVariable Long medicalRecordId,
//            @ModelAttribute Prescription prescription) {
//        MedicalRecord medicalRecord = medicalRecordService.findById(medicalRecordId);
//        prescription.setMedicalRecord(medicalRecord);
//        prescription.setPrescriptionDate(new Date());
//        prescriptionService.save(prescription);
//        return "redirect:/doctor/patients/" + medicalRecord.getDoctor().getDoctorId();
//    }
}
