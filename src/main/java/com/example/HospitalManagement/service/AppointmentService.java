package com.example.HospitalManagement.service;

import com.example.HospitalManagement.dto.AppointmentResponseDto;
import com.example.HospitalManagement.dto.CreateAppointmentRequestDto;
import com.example.HospitalManagement.entity.Appointment;
import com.example.HospitalManagement.entity.Patient;
import com.example.HospitalManagement.repo.AppointmentRepository;
import com.example.HospitalManagement.repo.DoctorRepository;
import com.example.HospitalManagement.repo.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.HospitalManagement.entity.Doctor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepo patientRepo;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResponseDto createAppointment(CreateAppointmentRequestDto createAppointmentRequestDto) throws IllegalAccessException {
        Doctor doctor = doctorRepository.findById(createAppointmentRequestDto.getDoctorId()).orElseThrow(()->  new EntityNotFoundException("Patient not found with ID :"+createAppointmentRequestDto.getDoctorId()));
        Patient patient = patientRepo.findById(createAppointmentRequestDto.getPatientId()).orElseThrow(()->  new EntityNotFoundException("Patient not found with ID :"+createAppointmentRequestDto.getPatientId()));


        Appointment appointment = Appointment.builder()
                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
                .reason(createAppointmentRequestDto.getReason())
                .build();


        if(appointment.getId()!=null)
            throw new IllegalAccessException("Appointment should not have ID");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);

        appointment = appointmentRepository.save(appointment);

        appointment = appointmentRepository.save(appointment);

        return modelMapper.map(appointment, AppointmentResponseDto.class);

    }

    @Transactional
    public AppointmentResponseDto reassignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new  EntityNotFoundException("Appointment not found with ID : "+appointmentId));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new  EntityNotFoundException("Doctor not found with ID : "+doctorId));

        appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty

        doctor.getAppointments().add(appointment);// just for bidirectional consistency

         return modelMapper.map(appointment, AppointmentResponseDto.class);
    }

    public List<AppointmentResponseDto> getAllAppointmentsOfDoctor(Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor not found with ID : "+ doctorId));
        List<Appointment> appointments = doctor.getAppointments();

        return appointments.stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDto.class))
                .collect(Collectors.toList());
    }
}
