package com.sweproject.eclinicianproject.controller;

import com.sweproject.eclinicianproject.model.Doctor;
import com.sweproject.eclinicianproject.model.Patient;
import com.sweproject.eclinicianproject.service.DoctorService;
import com.sweproject.eclinicianproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

//    @GetMapping("/add")
//    public String showDoctorForm(Model model) {
//        model.addAttribute("doctor", new Doctor());
//        return "addDoctor";
//    }

//    @PostMapping("/add")
//    public String addDoctor(@ModelAttribute Doctor doctor) {
//        doctorService.saveDoctor(doctor);
//        return "redirect:/doctor/add";
//    }

//    @GetMapping("/patients/{id}")
//    public String viewPatients(@PathVariable Long id, Model model) {
//        Doctor doctor = doctorService.findById(id);
//        model.addAttribute("doctor", doctor);
//        return "viewPatients";
//    }

//    @GetMapping("/patients/add/{id}")
//    public String showPatientForm(@PathVariable Long id, Model model) {
//        Doctor doctor = doctorService.findById(id);
//        model.addAttribute("doctor", doctor);
//        model.addAttribute("patient", new Patient());
//        return "addPatient";
//    }

//    @PostMapping("/patients/add/{id}")
//    public String addPatient(@PathVariable Long id, @ModelAttribute Patient patient) {
//        Doctor doctor = doctorService.findById(id);
//        patient.setDoctor(doctor);
//        patientService.save(patient);
//        return "redirect:/doctor/patients/" + id;
//    }
    @GetMapping("/patients/{id}")
    public String viewPatients(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.findById(id);
        List<Patient> patients = doctor.getPatients();
        model.addAttribute("doctor", doctor);
        model.addAttribute("patients", patients);
        return "viewPatients";
    }
    @GetMapping
    public String getAllDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctors";
    }
    @GetMapping("/{doctorId}/patients")
    public String getDoctorPatients(@PathVariable Long doctorId, Model model) {
        Doctor doctor = doctorService.findById(doctorId);
        List<Patient> patients = patientService.getPatientsByDoctor(doctor);
        model.addAttribute("doctor", doctor);
        model.addAttribute("patients", patients);
        return "patients";
    }
    @GetMapping("/add")
    public String showAddDoctorForm(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "add_doctor";
    }

    @PostMapping("/add")
    public String addDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }
    @GetMapping("/{doctorId}/addPatient")
    public String showAddPatientForm(@PathVariable Long doctorId, Model model) {
        Doctor doctor = doctorService.findById(doctorId);
        Patient patient = new Patient();
        model.addAttribute("doctor", doctor);
        model.addAttribute("patient", patient);
        return "add_patient";
    }

    @PostMapping("/{doctorId}/addPatient")
    public String addPatient(@PathVariable Long doctorId, @ModelAttribute Patient patient) {
        Doctor doctor = doctorService.findById(doctorId);
        patient.setDoctor(doctor);
        patientService.savePatient(patient);
        return "redirect:/doctors/" + doctorId + "/patients";
    }


}
