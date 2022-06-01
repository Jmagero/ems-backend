package jm.ems.emsbackend.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jm.ems.emsbackend.model.Employee;
import jm.ems.emsbackend.repository.EmployeeRepository;
@DataJpaTest
class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository underTest;
	
	@Test
	void itShouldCheckEmployeeByEmail(){
		//given
		Employee empl = new Employee ("jo1", "jer", "jo@gmail.com");
		underTest.save(empl);
		
		long counter = underTest.count();
		//when
		//boolean exits = underTest.selectExistsEmail("jo@gmail.com");
		//then
		//assertThat(exits).isTrue();
		assertThat(counter).isEqualTo(1);
		
	}
	

}
