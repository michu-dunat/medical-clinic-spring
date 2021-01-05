package com.company.handlers;

import com.company.model.Appointment;
import com.company.model.DataReader;
import com.company.model.Employee;
import com.company.model.Patient;
import com.company.repositories.AppointmentRepository;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentHandler {

    DataReader dataReader;
    Appointment appointment;
    private int maxAmountOfAppointments = 1;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PatientRepository patientRepository;

    public List<Employee> browseDoctors() {

        List<Employee> doctors = employeeRepository.findAllDoctors();

        return doctors;
    }

    public List<Patient> browsePatients(String lastName) {

        List<Patient> patients = patientRepository.findPatientsByLastName(lastName);

        return patients;
    }

    //old List<Term> browseCalendar(LocalDate date, Employee doctor)
    public boolean isAbleToCreateAppointmentOnDate(LocalDate date, Employee doctor) {
        int amountOfAppointments = appointmentRepository.countAppointmentsByEmployeeIdAndAndDate(doctor, date);
        if (amountOfAppointments >= maxAmountOfAppointments)
            return false;
        else
            return true;
    }

    public List<Appointment> isAbleToCreateAppointmentOnDate(Patient patient) {
        return null;
    }

    /*public Term initializeTermSelection(List<Term> termsList, Employee doctor, Patient patient) {
        return null;
    }*/

    public Appointment initializeAppointmentSelection(List<Appointment> patientAppointments) {
        return null;
    }

    public boolean approveAppointment() {
        return false;
    }

    public boolean deleteAppointment(Appointment appointment) {
        return false;
    }

    /*public List<Term> makeListOfAvailableTerms(List<Appointment> employeeAppointmentsOnDate) {
        return null;
    }

    public Appointment createAppointment(Patient patient, Employee doctor, Term term) {
        return null;
    }*/

}
