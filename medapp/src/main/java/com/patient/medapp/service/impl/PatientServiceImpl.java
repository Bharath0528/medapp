package com.patient.medapp.service.impl;

import com.patient.medapp.dto.PatientDTO;
import com.patient.medapp.model.Patient;
import com.patient.medapp.repository.PatientRepository;
import com.patient.medapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient registerPatient(PatientDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setAge(dto.getAge());
        patient.setContactNumber(dto.getContactNumber());
        patient.setMedicalInfo(dto.getMedicalInfo());
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }
}
