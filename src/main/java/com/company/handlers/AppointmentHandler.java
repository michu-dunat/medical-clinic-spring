package com.company.handlers;

import com.company.factories.AppointmentFactory;
import com.company.model.Appointment;
import com.company.model.Employee;
import com.company.model.MyUserDetails;
import com.company.model.Patient;
import com.company.repositories.AppointmentRepository;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class AppointmentHandler {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PatientRepository patientRepository;

    private final int maxAmountOfAppointments = 1;
    private final List<String> roomNumbers = Arrays.asList("0.1", "0.2", "0.3", "1.1", "1.2", "1.3", "2.1", "2.2", "2.3");

    public List<Employee> browseDoctors() {

        List<Employee> doctors = employeeRepository.findAllDoctors();

        return doctors;
    }

    public List<Patient> browsePatients(String lastName) {

        List<Patient> patients = patientRepository.findPatientsByLastName(lastName);

        return patients;
    }

    public boolean isAbleToCreateAppointmentOnDate(LocalDate date, Employee doctor) {
        int amountOfAppointments = appointmentRepository.countAppointmentsByEmployeeIdAndAndDate(doctor, date);
        return amountOfAppointments < maxAmountOfAppointments;
    }

    public int deleteAppointment(String appointmentIdToBeDeleted) {
        return appointmentRepository.deleteAppointmentById(Integer.parseInt(appointmentIdToBeDeleted));
    }

    public Appointment saveAppointment(Patient patient, Employee doctor, LocalDate date) {
        Random rand = new Random();
        String randRoomNumber = roomNumbers.get(rand.nextInt(roomNumbers.size()));
        Appointment appointment = AppointmentFactory.createAppointment();
        appointment.setPatientId(patient);
        appointment.setEmployeeId(doctor);
        appointment.setDate(date);
        appointment.setRoomNumber(randRoomNumber);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> browseCalendar(Patient patient) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByPatientId(patient);
        appointments.removeIf(ap -> ap.getDate().isBefore(LocalDate.now()));
        return appointments;
    }

    public Patient getPatient(String patientId) {
        return patientRepository.findPatientById(Integer.parseInt(patientId));
    }

    public Employee getDoctor(String doctorId) {
        return employeeRepository.findEmployeeById(doctorId);
    }

    public Patient getPatientIfPatientLoggedIn() {
        Authentication getCurrentLoginContext = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails user = (MyUserDetails) getCurrentLoginContext.getPrincipal();
        Patient patient = patientRepository.findPatientByUserId(user.getUser());
        return patient;
    }

}
