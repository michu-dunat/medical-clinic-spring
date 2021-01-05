package com.company.repositories;

import com.company.model.Appointment;
import com.company.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {



    List<Appointment> findAppointmentsByEmployeeId(String employeeId);
    List<Appointment> findAppointmentsByEmployeeIdAndDate(String employeeId, LocalDate date);
    int countAppointmentsByEmployeeIdAndAndDate(Employee employeeId, LocalDate date);

}
