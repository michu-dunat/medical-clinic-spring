package com.company.facades;

import com.company.model.Employee;

import java.time.LocalDateTime;

public interface IAppointmentFacade {

    public boolean makeAppointmentByPatient(LocalDateTime date, Employee doctor);

    public boolean makeAppointmentByWorker(LocalDateTime date, Employee doctor);

    public boolean cancelAppointmentByPatient();

    public boolean cancelAppointmentByWorker();

}
