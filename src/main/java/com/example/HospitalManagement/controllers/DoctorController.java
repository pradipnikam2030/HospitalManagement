package com.example.HospitalManagement.controllers;

import com.example.HospitalManagement.dto.AppointmentResponseDto;
import com.example.HospitalManagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final AppointmentService appointmentService;


}
