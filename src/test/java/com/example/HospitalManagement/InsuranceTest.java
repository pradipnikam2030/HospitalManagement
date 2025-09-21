package com.example.HospitalManagement;

import com.example.HospitalManagement.entity.Insurance;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .validUntil(LocalDate.of(2045, 12,12))
                .provider("HDFC")
                .build();

       Patient patient = insuranceService.addInsurance(insurance, 1L);

        Patient patient1 = insuranceService.desAssociateInsuranceFromPatient(patient.getId());
        System.out.println(patient1);
    }


}
