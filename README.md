# MedApp - Hospital Appointment Booking System 🏥

A full-stack hospital appointment booking system built using **Java Spring Boot**, **MySQL**, and **HTML/CSS/JavaScript**. The application allows users to register patients, book appointments with doctors, and view available slots. It features RESTful APIs, Swagger documentation, unit testing with JUnit & Mockito, and is deployed using **Render**.

---

## 🚀 Features

- ✅ Patient Registration
- ✅ Appointment Booking
- ✅ View Available Time Slots
- ✅ View All Appointments
- ✅ Backend REST API with Spring Boot
- ✅ MySQL Database Integration
- ✅ Unit Tests with JUnit & Mockito
- ✅ Swagger API Documentation
- ✅ HTML/CSS/JavaScript Frontend
- ✅ Deployed on Render

---

## 🔧 Technologies Used

- **Java 17**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Swagger (Springdoc OpenAPI)**
- **JUnit 5 & Mockito**
- **HTML/CSS/JS**
- **Render for Deployment**

---

## 🧪 Running the Project Locally

### 🔁 Prerequisites
- Java 17+
- MySQL installed & running
- IDE (Eclipse/IntelliJ)
- Postman or browser for API testing

### 📦 Backend Setup

```bash
# Clone the repo
git clone https://github.com/Bharath0528/medapp.git
cd medapp

# Add MySQL details in src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/patient_system
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
