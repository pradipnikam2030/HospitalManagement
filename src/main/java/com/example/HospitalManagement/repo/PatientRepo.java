package com.example.HospitalManagement.repo;

import com.example.HospitalManagement.dto.CountByBloodGroupTypeDto;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

    // Query Methods
    List<Patient>  findByBirthDateOrEmail(LocalDate birthDate, String email);

    //JPQL
    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> findPatientByBloodGroups(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient p  where p.birthDate > :birthDate ")
    List<Patient> findByAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("SELECT p.bloodGroup, COUNT(p) FROM Patient p GROUP BY p.bloodGroup ")
    List<Object[]> countByBloodGroup();

    //above Query using projection
    @Query("SELECT new com.example.HospitalManagement.dto.CountByBloodGroupTypeDto(p.bloodGroup, COUNT(p)) FROM Patient p GROUP BY p.bloodGroup ")
    List<CountByBloodGroupTypeDto> countByBloodGroupProjection();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameById(@Param("name") String name, @Param("id") Long id);

    // Native Query
    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient>  listOfPatient();

    //Pagination
    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> listOfPatientPage(Pageable pageable);

    @Query("select p from Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> patientWithAppointments();
}
