package com.patient.medapp.service;

import com.patient.medapp.dto.PatientDTO;
import com.patient.medapp.model.Patient;

import java.util.List;

public interface PatientService {
    Patient registerPatient(PatientDTO patientDto);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
}
