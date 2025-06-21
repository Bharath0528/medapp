package com.patient.medapp.controller;

import com.patient.medapp.dto.PatientDTO;
import com.patient.medapp.model.Patient;
import com.patient.medapp.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public Patient registerPatient(@RequestBody PatientDTO patientDto) {
        return patientService.registerPatient(patientDto);
    }


    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }
}
