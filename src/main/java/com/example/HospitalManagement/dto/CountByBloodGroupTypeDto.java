package com.example.HospitalManagement.dto;

import com.example.HospitalManagement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountByBloodGroupTypeDto {
    private BloodGroupType bloodGroupType;
    private Long count;
}
