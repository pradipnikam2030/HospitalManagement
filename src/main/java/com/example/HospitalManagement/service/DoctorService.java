package com.example.HospitalManagement.service;

import com.example.HospitalManagement.dto.DoctorResponseDto;
import com.example.HospitalManagement.dto.OnBoardNewDoctorDto;
import com.example.HospitalManagement.entity.Doctor;
import com.example.HospitalManagement.repo.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public List<DoctorResponseDto> getAllDoctors(){
        return doctorRepository.findAll().stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDto.class))
                .toList();
    }

    @Transactional
    public DoctorResponseDto onBoardNewDoctor(OnBoardNewDoctorDto onBoardNewDoctorDto){
        if(doctorRepository.existsById(onBoardNewDoctorDto.getId())) {
            throw new IllegalArgumentException("Already a doctor");
        }
        Doctor doctor = Doctor.builder()
                .name(onBoardNewDoctorDto.getName())
                .specialization(onBoardNewDoctorDto.getSpecialization())
                .build();
        doctor = doctorRepository.save(doctor);

        return modelMapper.map(doctor, DoctorResponseDto.class);
    }
}
