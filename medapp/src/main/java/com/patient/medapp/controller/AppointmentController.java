// ✅ FILE: AppointmentController.java
package com.patient.medapp.controller;

import com.patient.medapp.dto.AppointmentDTO;
import com.patient.medapp.model.Appointment;
import com.patient.medapp.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@Valid @RequestBody AppointmentDTO appointmentDto) {
        String result = appointmentService.bookAppointment(appointmentDto);
        if (result.equals("Appointment booked successfully.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/available-slots")
    public List<String> getAvailableSlots() {
        return appointmentService.getAvailableSlots();
    }
}
