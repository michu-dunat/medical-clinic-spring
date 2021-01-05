package com.company.repositories;

import com.company.model.Employee;
import com.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(String id);
    List<Employee> findEmployeesBySpecialisation(String specialization);
    List<Employee> findEmployeesByFirstNameAndLastName(String firstName, String lastName);
    List<Employee> findEmployeeByUserId(User userId);

    @Query(value = "select * from employees e where e.id like 'D%' AND e.is_active = true", nativeQuery = true)
    List<Employee> findAllDoctors();

}
