package com.example.HospitalManagement.service;

import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.repo.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    @Autowired
    PatientRepo patientRepo;

    @Transactional
    public Patient getPatient(Long id){
        Patient patient1 = patientRepo.findById(id).orElseThrow();
        Patient patient2 = patientRepo.findById(id).orElseThrow();
        System.out.println(patient2==patient1);
        return patient1;
    }

}
