    package com.example.HospitalManagement.entity;
    
    import com.example.HospitalManagement.entity.type.BloodGroupType;
    import jakarta.persistence.*;
    import lombok.Data;
    import lombok.ToString;
    import org.hibernate.annotations.CreationTimestamp;
    
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.List;
    
    @Entity
    @Data
    public class Patient {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false, length = 40)
        private String name;
        @Column(unique = true)
        private String email;
        private LocalDate birthDate;
        private String gender;
        @Enumerated(EnumType.STRING)
        private BloodGroupType bloodGroup;
        @CreationTimestamp
        @Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        LocalDateTime createdAt;
    
        @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
        @JoinColumn(name = "patient_insurance_id") //owning side
        private Insurance insurance;
    
        @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    //    @ToString.Exclude
        private List<Appointment> appointments;
    
    }
