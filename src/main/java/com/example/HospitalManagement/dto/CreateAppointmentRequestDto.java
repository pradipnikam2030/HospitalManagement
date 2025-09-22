package com.example.HospitalManagement.dto;

import com.example.HospitalManagement.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentRequestDto {
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentTime;
    private String reason;
}
