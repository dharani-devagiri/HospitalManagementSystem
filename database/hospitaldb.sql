DROP DATABASE IF EXISTS hospitaldb;

CREATE DATABASE hospitaldb;

USE hospitaldb;


-- =========================
-- ADMIN LOGIN TABLE
-- =========================

CREATE TABLE admin(

    username VARCHAR(50) PRIMARY KEY,

    password VARCHAR(50)

);


INSERT INTO admin VALUES
('admin','1234');



-- =========================
-- DOCTOR TABLE
-- =========================

CREATE TABLE doctor(

    doctor_id INT AUTO_INCREMENT PRIMARY KEY,

    doctor_name VARCHAR(100),

    specialization VARCHAR(100),

    phone VARCHAR(15),

    email VARCHAR(100)

);



-- =========================
-- PATIENT TABLE
-- =========================

CREATE TABLE patient(

    patient_id INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(100),

    age INT,

    gender VARCHAR(10),

    phone VARCHAR(15),

    disease VARCHAR(100)

);



-- =========================
-- APPOINTMENT TABLE
-- =========================

CREATE TABLE appointment(

    appointment_id INT AUTO_INCREMENT PRIMARY KEY,

    patient_id INT,

    doctor_id INT,

    appointment_date DATE,

    appointment_time TIME,

    status VARCHAR(20),


    FOREIGN KEY(patient_id)
    REFERENCES patient(patient_id)
    ON DELETE CASCADE,


    FOREIGN KEY(doctor_id)
    REFERENCES doctor(doctor_id)
    ON DELETE CASCADE

);



-- =========================
-- BILL TABLE
-- =========================

CREATE TABLE bill(

    bill_id INT AUTO_INCREMENT PRIMARY KEY,

    patient_id INT,

    doctor_fee DOUBLE,

    medicine_cost DOUBLE,

    total_amount DOUBLE,

    bill_date DATE,


    FOREIGN KEY(patient_id)
    REFERENCES patient(patient_id)
    ON DELETE CASCADE

);



-- =========================
-- SAMPLE DATA
-- =========================


INSERT INTO doctor
(doctor_name,specialization,phone,email)
VALUES
('Dharani','Cardiologist','1234512345','dharani@gmail.com');


INSERT INTO patient
(name,age,gender,phone,disease)
VALUES
('Ravi',35,'Male','1234512345','Fever');



INSERT INTO appointment
(patient_id,doctor_id,appointment_date,appointment_time,status)
VALUES
(1,1,'2026-07-25','11:00:00','Pending');



INSERT INTO bill
(patient_id,doctor_fee,medicine_cost,total_amount,bill_date)
VALUES
(1,500,800,1300,'2026-07-22');



-- Check tables

SHOW TABLES;


SELECT * FROM admin;

SELECT * FROM doctor;

SELECT * FROM patient;

SELECT * FROM appointment;

SELECT * FROM bill;