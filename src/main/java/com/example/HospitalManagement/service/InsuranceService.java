package com.example.HospitalManagement.service;

import com.example.HospitalManagement.entity.Insurance;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.repo.InsuranceRepository;
import com.example.HospitalManagement.repo.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final PatientRepo patientRepository;
    private final InsuranceRepository insuranceRepository;


    @Transactional
    public Patient addInsurance(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);

        insurance.setPatient(patient);

        return  patient;

    }
    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bidirectional consistency maintainence

        return patient;
    }

    @Transactional
    public Patient desAssociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository .findById(patientId).orElseThrow();

        patient.setInsurance(null);

        return patient;
    }
}
