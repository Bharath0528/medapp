// ✅ FILE: AppointmentService.java
package com.patient.medapp.service;

import com.patient.medapp.dto.AppointmentDTO;
import com.patient.medapp.model.Appointment;

import java.util.List;

public interface AppointmentService {
    String bookAppointment(AppointmentDTO appointmentDto);
    List<Appointment> getAllAppointments();
    List<String> getAvailableSlots();
}
