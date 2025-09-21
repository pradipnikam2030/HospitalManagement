package com.example.HospitalManagement.service;

import com.example.HospitalManagement.entity.Appointment;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.repo.AppointmentRepository;
import com.example.HospitalManagement.repo.DoctorRepository;
import com.example.HospitalManagement.repo.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.HospitalManagement.entity.Doctor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepo patientRepo;


    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId) throws IllegalAccessException {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepo.findById(patientId).orElseThrow();

        if(appointment.getId()!=null)
            throw new IllegalAccessException("Appointment should not have ID");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);

        appointmentRepository.save(appointment);

        return appointment;

    }

    @Transactional
    public Appointment reassignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);

        return appointment;
    }
}
