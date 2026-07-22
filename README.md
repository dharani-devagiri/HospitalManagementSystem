# Hospital Management System

## Project Overview

Hospital Management System is a Java Swing based desktop application developed to manage hospital operations efficiently.

The system provides modules for managing patients, doctors, appointments, billing, and statistics using a MySQL database.

## Features

### Admin Login
- Secure login system for admin access.
- Authentication using MySQL database.

### Patient Management
- Add new patient records.
- View patient details.
- Update patient information.
- Delete patient records.

### Doctor Management
- Add doctor details.
- View doctor information.
- Update doctor details.
- Delete doctor records.

### Appointment Management
- Create appointments.
- View appointments.
- Update appointment details.
- Delete appointments.

### Billing Management
- Generate patient bills.
- View billing records.
- Update bill details.
- Delete billing records.

### Statistics
- Display hospital-related statistics.

## Technologies Used

- Java
- Java Swing (GUI)
- MySQL Database
- JDBC
- VS Code
- Git & GitHub

## Project Structure


HospitalManagementSystem
│
├── database
│ └── hospitaldb.sql
│
├── images
│
├── lib
│ └── mysql-connector-j.jar
│
└── src
└── hospital
├── Main.java
├── Login.java
├── Dashboard.java
├── Patient Modules
├── Doctor Modules
├── Appointment Modules
└── Billing Modules


## Database Setup

1. Install MySQL Server.

2. Open MySQL Workbench or MySQL Command Line.

3. Run the SQL file:
database/hospitaldb.sql


4. The database will be created:


hospitaldb


## Configuration

Open:


src/hospital/DBConnection.java


Update your MySQL username and password:

```java
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/hospitaldb",
"username",
"password"
);
-----------------------------
Required Software
Java JDK 17 or above
MySQL Server
MySQL Connector/J JDBC Driver
------------------------------
How to Run
Clone the repository:
git clone https://github.com/dharani-devagiri/HospitalManagementSystem.git
Open the project in VS Code or any Java IDE.
Add MySQL Connector JAR file.
Run:
src/hospital/Main.java
Login using admin credentials:
Username: admin
Password: 1234
-------------------------------
Future Enhancements
Role-based login for doctors and staff.
Online appointment booking.
Email/SMS notifications.
Patient medical history.
Cloud database integration.
----------------------------------
Author

Dharani Devagiri

GitHub:
https://github.com/dharani-devagiri


After adding this:

Run these commands in VS Code terminal:

```bash
git add README.md

then:

git commit -m "Added project README"

then:

git push

