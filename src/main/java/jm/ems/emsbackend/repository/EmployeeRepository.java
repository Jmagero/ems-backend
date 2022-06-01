package jm.ems.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jm.ems.emsbackend.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	@Query("" +
            "SELECT CASE WHEN COUNT(e) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Employee e " +
            "WHERE e.emailId = ?1"
    )
    Boolean selectExistsEmail(String emailId);

}

//public interface StudentRepository
//extends JpaRepository<Student, Long> {
//@Query("" +
//    "SELECT CASE WHEN COUNT(s) > 0 THEN " +
//    "TRUE ELSE FALSE END " +
//    "FROM Student s " +
//    "WHERE s.email = ?1"
//)
//Boolean selectExistsEmail(String email);