package com.company.repositories;

import com.company.model.Appointment;
import com.company.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findAppointmentsByEmployeeId(Employee employeeId);
    //TODO date without time
    List<Appointment> findAppointmentsByEmployeeIdAndDate(Employee employeeId, LocalDateTime date);

}
