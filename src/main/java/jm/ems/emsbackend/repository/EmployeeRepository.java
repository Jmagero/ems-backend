package jm.ems.emsbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jm.ems.emsbackend.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

 Optional<Employee> save(Optional<Employee> employee);

}
