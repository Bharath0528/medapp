package com.patient.medapp.service;

import com.patient.medapp.dto.AppointmentDTO;
import com.patient.medapp.model.Appointment;
import com.patient.medapp.model.Patient;
import com.patient.medapp.repository.AppointmentRepository;
import com.patient.medapp.repository.PatientRepository;
import com.patient.medapp.service.impl.AppointmentServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBookAppointment_Success() {
        // Arrange
        AppointmentDTO dto = new AppointmentDTO();
        dto.setDoctorName("Dr. Ravi");
        dto.setDepartment("Cardiology");
        dto.setAppointmentDateTime("2025-06-22T10:00");
        dto.setPatientId(1L);

        Patient mockPatient = new Patient(1L, "John", "john@example.com", 30, "9999999999", "Healthy");
        when(patientRepository.findById(1L)).thenReturn(Optional.of(mockPatient));
        when(appointmentRepository.save(any(Appointment.class))).thenReturn(new Appointment());

        // Act
        String result = appointmentService.bookAppointment(dto);

        // Assert
        assertEquals("Appointment booked successfully.", result);
        verify(appointmentRepository, times(1)).save(any(Appointment.class));
    }

    @Test
    public void testBookAppointment_InvalidPatientId() {
        // Arrange
        AppointmentDTO dto = new AppointmentDTO();
        dto.setDoctorName("Dr. Ravi");
        dto.setDepartment("Cardiology");
        dto.setAppointmentDateTime("2025-06-22T10:00");
        dto.setPatientId(999L); // invalid ID

        when(patientRepository.findById(999L)).thenReturn(Optional.empty());

        // Act
        String result = appointmentService.bookAppointment(dto);

        // Assert
        assertEquals("Invalid Patient ID.", result);
        verify(appointmentRepository, never()).save(any());
    }

    @Test
    public void testBookAppointment_InvalidDateTime() {
        // Arrange
        AppointmentDTO dto = new AppointmentDTO();
        dto.setDoctorName("Dr. Ravi");
        dto.setDepartment("Cardiology");
        dto.setAppointmentDateTime("invalid-date"); // incorrect format
        dto.setPatientId(1L);

        Patient mockPatient = new Patient(1L, "John", "john@example.com", 30, "9999999999", "Healthy");
        when(patientRepository.findById(1L)).thenReturn(Optional.of(mockPatient));

        // Act
        String result = appointmentService.bookAppointment(dto);

        // Assert
        assert(result.contains("Invalid date and time format")); // ✅ Fixed
        verify(appointmentRepository, never()).save(any());
    }

}
