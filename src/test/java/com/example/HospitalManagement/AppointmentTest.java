package com.example.HospitalManagement;

import com.example.HospitalManagement.dto.AppointmentResponseDto;
import com.example.HospitalManagement.dto.CreateAppointmentRequestDto;
import com.example.HospitalManagement.entity.Appointment;
import com.example.HospitalManagement.repo.AppointmentRepository;
import com.example.HospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentService appointmentService;

    private ModelMapper modelMapper;

    @Test
    public void testAppointment() throws IllegalAccessException {
        Appointment appointment = Appointment.builder()
                .reason("Stomach pain")
                .appointmentTime(LocalDateTime.of(LocalDate.of(2025, 9, 25), LocalTime.of(14, 00, 00)))
                .build();

        CreateAppointmentRequestDto createAppointmentRequestDto = modelMapper.map(appointment, CreateAppointmentRequestDto.class);

        AppointmentResponseDto appointment1 = appointmentService.createAppointment(createAppointmentRequestDto);
        //System.out.println(appointment1);

        AppointmentResponseDto appointment2 = appointmentService.reassignAppointmentToAnotherDoctor(appointment1.getId(), 2L);
        //System.out.println(appointment2);
    }
}
