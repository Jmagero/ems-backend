package jm.ems.emsbackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jm.ems.emsbackend.exception.ResourceNotFoundException;
import jm.ems.emsbackend.model.Employee;
import jm.ems.emsbackend.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();	
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public ResponseEntity<?> getEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee == null) {
			return new ResponseEntity<RuntimeException>(new ResourceNotFoundException("Employee doesn't exist with: " + id),HttpStatus.NOT_FOUND);
		}
        return new ResponseEntity<Optional<Employee>>(employee, HttpStatus.OK);
	}
	public ResponseEntity<Employee> updateEmployee(Long id,Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Employee doesn't exist with: " + id));
//		if(employee == null) {
//			return new ResponseEntity<RuntimeException>(new ResourceNotFoundException("Employee doesn't exist with: " + id),HttpStatus.NOT_FOUND);
//		}
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
	    Employee updatedEmployee = employeeRepository.save(employee);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}
	
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Employee doesn't exist with: " + id));
		employeeRepository.delete(employee);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return  ResponseEntity.ok(response);
	}
	
}
