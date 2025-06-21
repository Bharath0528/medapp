// ✅ FILE: AppointmentServiceImpl.java
package com.patient.medapp.service.impl;

import com.patient.medapp.dto.AppointmentDTO;
import com.patient.medapp.model.Appointment;
import com.patient.medapp.model.Patient;
import com.patient.medapp.repository.AppointmentRepository;
import com.patient.medapp.repository.PatientRepository;
import com.patient.medapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    private static final List<String> allSlots = List.of(
            "10:00", "11:00", "12:00", "13:00", "14:00",
            "15:00", "16:00", "17:00", "18:00"
    );

    @Override
    public String bookAppointment(AppointmentDTO dto) {
        Long patientId = dto.getPatientId();
        if (patientId == null) {
            return "Patient ID is required.";
        }

        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (patientOpt.isEmpty()) {
            return "Invalid Patient ID.";
        }

        LocalDateTime dateTime;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            dateTime = LocalDateTime.parse(dto.getAppointmentDateTime(), formatter);
        } catch (Exception e) {
            return "Invalid date and time format. Use 'yyyy-MM-ddTHH:mm', e.g., '2025-06-22T10:00'";
        }

        Appointment appointment = new Appointment();
        appointment.setDoctorName(dto.getDoctorName());
        appointment.setDepartment(dto.getDepartment());
        appointment.setAppointmentDateTime(dateTime);
        appointment.setPatient(patientOpt.get());

        appointmentRepository.save(appointment);
        return "Appointment booked successfully.";
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    @Override
    public List<String> getAvailableSlots() {
        List<Appointment> booked = appointmentRepository.findAll();

        List<String> takenSlots = booked.stream()
            .filter(a -> a.getAppointmentDateTime() != null) // ✅ Prevent null pointer error
            .map(a -> {
                try {
                    return a.getAppointmentDateTime().toLocalTime().toString().substring(0, 5);
                } catch (Exception e) {
                    return ""; // return empty if something goes wrong
                }
            })
            .filter(slot -> !slot.isEmpty()) // remove blanks from list
            .toList();

        return allSlots.stream()
            .filter(slot -> !takenSlots.contains(slot))
            .toList();
    }
}
