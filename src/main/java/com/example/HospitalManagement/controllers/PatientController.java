package com.example.HospitalManagement.controllers;

import com.example.HospitalManagement.dto.AppointmentResponseDto;
import com.example.HospitalManagement.dto.CreateAppointmentRequestDto;
import com.example.HospitalManagement.dto.PatientResponseDto;
import com.example.HospitalManagement.service.AppointmentService;
import com.example.HospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentResponseDto> createAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto) throws IllegalAccessException {

        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile{id}")
    private ResponseEntity<PatientResponseDto> getPatientProfile(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatientById(id));
    }


}
