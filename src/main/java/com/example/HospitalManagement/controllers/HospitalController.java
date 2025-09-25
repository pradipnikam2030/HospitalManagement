package com.example.HospitalManagement.controllers;

import com.example.HospitalManagement.dto.DoctorResponseDto;
import com.example.HospitalManagement.repo.DoctorRepository;
import com.example.HospitalManagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class HospitalController {

    private final DoctorService doctorService;


    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors(){
        List<DoctorResponseDto> doctors = doctorService.getAllDoctors();

        return ResponseEntity.ok(doctors);
    }
}
