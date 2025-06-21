package com.patient.medapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AppointmentDTO {

    @NotBlank(message = "Doctor name is required")
    private String doctorName;

    @NotBlank(message = "Department is required")
    private String department;

    @NotNull(message = "Appointment date and time is required")
    private String appointmentDateTime; // Format: yyyy-MM-ddTHH:mm (like 2025-06-22T10:00)

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    public AppointmentDTO() {}

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
