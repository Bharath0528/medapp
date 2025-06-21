package com.patient.medapp.service;

import com.patient.medapp.dto.PatientDTO;
import com.patient.medapp.model.Patient;
import com.patient.medapp.repository.PatientRepository;
import com.patient.medapp.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks before each test
    }

    @Test
    public void testRegisterPatient() {
        // Arrange
        PatientDTO dto = new PatientDTO();
        dto.setName("John");
        dto.setEmail("john@example.com");
        dto.setAge(30);
        dto.setContactNumber("1234567890");
        dto.setMedicalInfo("Diabetic");

        Patient saved = new Patient(1L, "John", "john@example.com", 30, "1234567890", "Diabetic");

        when(patientRepository.save(any(Patient.class))).thenReturn(saved);

        // Act
        Patient result = patientService.registerPatient(dto);

        // Assert
        assertEquals("John", result.getName());
        assertEquals("john@example.com", result.getEmail());
        assertEquals(30, result.getAge());

        verify(patientRepository, times(1)).save(any(Patient.class));
    }
}
