package com.company.facades;

import com.company.model.Employee;

import java.time.LocalDate;

public interface IAppointmentFacade {

    public boolean makeAppointmentByPatient(LocalDate date, Employee doctor);

    public boolean makeAppointmentByWorker(LocalDate date, Employee doctor);

    public boolean cancelAppointmentByPatient();

    public boolean cancelAppointmentByWorker();

}
