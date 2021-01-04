package com.company.handlers;

import com.company.model.Appointment;
import com.company.model.Employee;
import com.company.model.Patient;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentHandler {

    public Patient initializePatientSelection() {
        return null;
    }

    /*public List<Term> browseCalendar(LocalDateTime date, Employee doctor) {
        return null;
    }*/

    public List<Appointment> browseCalencar(Patient patient) {
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
