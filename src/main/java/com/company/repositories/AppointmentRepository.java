package com.company.repositories;

import com.company.model.Appointment;
import com.company.model.Employee;
import com.company.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {



    List<Appointment> findAppointmentsByEmployeeId(String employeeId);
    List<Appointment> findAppointmentsByEmployeeIdAndDate(String employeeId, LocalDate date);
    List<Appointment> findAppointmentsByPatientId(Patient patientId);
    int countAppointmentsByEmployeeIdAndAndDate(Employee employeeId, LocalDate date);

    @Transactional
    int deleteAppointmentById(int id);
}
