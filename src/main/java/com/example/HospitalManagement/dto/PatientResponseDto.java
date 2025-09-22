package com.example.HospitalManagement.dto;

import com.example.HospitalManagement.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private BloodGroupType bloodGroupType;
}
