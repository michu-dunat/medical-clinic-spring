package com.company.facades;

import com.company.handlers.AppointmentHandler;
import com.company.model.Employee;

import java.time.LocalDateTime;

public class AppointmentFacade implements IAppointmentFacade{

    AppointmentHandler appointmentHandler;

    @Override
    public boolean makeAppointmentByPatient(LocalDateTime date, Employee doctor) {
        return false;
    }

    @Override
    public boolean makeAppointmentByWorker(LocalDateTime date, Employee doctor) {
        return false;
    }

    @Override
    public boolean cancelAppointmentByPatient() {
        return false;
    }

    @Override
    public boolean cancelAppointmentByWorker() {
        return false;
    }
}
