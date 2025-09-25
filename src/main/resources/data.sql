/*
INSERT INTO patient (name, email, birth_date, gender, blood_group)
VALUES
('Radha Pawar', 'radha@gmail.com', '2001-09-12', 'FEMALE', 'B_POSITIVE'),
('Ramesh Kale', 'ramesh@gmail.com', '2004-02-09', 'MALE', 'AB_POSITIVE'),
('Sam Altman', 'sam@gmail.com', '1999-04-07', 'MALE', 'B_NEGATIVE'),
('Jack Kalis', 'jack@gmail.com', '1996-09-06', 'MALE', 'O_POSITIVE'),
('Priya Sharma', 'priya.sharma@gmail.com', '1998-07-14', 'FEMALE', 'A_POSITIVE'),
('Amit Verma', 'amit.verma@gmail.com', '2000-03-22', 'MALE', 'O_NEGATIVE'),
('Sneha Patil', 'sneha.patil@gmail.com', '2002-05-18', 'FEMALE', 'AB_NEGATIVE'),
('David Miller', 'david.miller@gmail.com', '1995-11-29', 'MALE', 'A_NEGATIVE');


INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Arjun Mehta', 'Cardiologist', 'arjun.mehta@hospital.com');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Priya Sharma', 'Neurologist', 'priya.sharma@hospital.com');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Rakesh Kumar', 'Orthopedic', 'rakesh.kumar@hospital.com');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Sneha Patil', 'Pediatrician', 'sneha.patil@hospital.com');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Amit Desai', 'Dermatologist', 'amit.desai@hospital.com');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Kavita Joshi', 'Gynecologist', 'kavita.joshi@hospital.com');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Rajesh Nair', 'General Surgeon', 'rajesh.nair@hospital.com');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Manish Verma', 'ENT Specialist', 'manish.verma@hospital.com');



-- Appointments for Patient 1 with Doctor 1
INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-09-21 10:30:00', 'Routine Checkup', 1, 1);

INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-09-22 14:00:00', 'Follow-up on Blood Report', 1, 2);

-- Appointments for Patient 2 with Doctor 2
INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-09-23 09:00:00', 'Neurology Consultation', 2, 2);

-- Appointments for Patient 3 with Doctor 3
INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-09-24 11:15:00', 'Knee Pain', 3, 3);

-- Another appointment for Patient 2 with Doctor 1
INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-09-25 16:00:00', 'General Checkup', 2, 1);

-- Appointment for Patient 4 with Doctor 4
INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-09-26 12:00:00', 'Child Fever', 4, 4);

-- Appointment for Patient 5 with Doctor 5
INSERT INTO appointment (appointment_time, reason, patient_id, doctor_id)
VALUES ('2025-09-27 10:45:00', 'Skin Rash Consultation', 5, 5);



*/
