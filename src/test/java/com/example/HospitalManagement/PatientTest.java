package com.example.HospitalManagement;

import com.example.HospitalManagement.dto.CountByBloodGroupTypeDto;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.entity.type.BloodGroupType;
import com.example.HospitalManagement.repo.PatientRepo;
import com.example.HospitalManagement.service.PatientService;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PatientTest {
    @Autowired
    PatientRepo patientRepo;

    @Autowired
    PatientService patientService;

    @Test
    public void testFindAllPatient(){
        /*List<Patient> patients = patientRepo.findAll();
        System.out.println(patients);*/

        List<Patient> patientsWithAppointments = patientRepo.patientWithAppointments();
        System.out.println(patientsWithAppointments);
    }

    @Test
    public void testTransactionalMethod(){
       /* Patient patient = patientService.getPatient(1L);
        System.out.println(patient);*/

        // Query methods
        /*List<Patient> patients = patientRepo.findByBirthDateOrEmail(LocalDate.of(2003,01,25), "michael.j@gmail.com");
        System.out.println(patients);*/

        //JPQL
        /*List<Patient> patientList = patientRepo.findPatientByBloodGroups(BloodGroupType.A_POSITIVE);
        System.out.println(patientList);*/

        /*List<Patient> patientsListOnDate = patientRepo.findByAfterDate(LocalDate.of(2000, 01, 01));
        System.out.println(patientsListOnDate);*/

      /*  List<Object[]> list = patientRepo.countByBloodGroup();
        for (Object[] param : list){
            System.out.println(Arrays.toString(param));
        }
        System.out.println(list);*/

        /*List<Patient> listOfPatient = patientRepo.listOfPatient();
        System.out.println(listOfPatient);*/

        /*int affectedRow = patientRepo.updateNameById("Radhika Shinde", 1L);
        System.out.println(affectedRow);*/

        //projection
//        List<CountByBloodGroupTypeDto> list = patientRepo.countByBloodGroupProjection();
//        for (CountByBloodGroupTypeDto param : list)
//            System.out.println(param.getBloodGroupType() + " -> " + param.getCount());

        //Pagination
        Page<Patient> patientPage = patientRepo.listOfPatientPage(PageRequest.of(0, 3, Sort.by( "name")));
        for (Patient patient : patientPage)
            System.out.println(patient);

    }
}
