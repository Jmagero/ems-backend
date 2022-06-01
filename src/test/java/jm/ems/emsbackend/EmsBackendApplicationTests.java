package jm.ems.emsbackend;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmsBackendApplicationTests {
    
	Calculator underTest = new Calculator();
	@Test
	void itShouldAdd() {
		int x = 20;
		int y = 30;
		int result = underTest.add(x, y);
		
		assertThat(result).isEqualTo(50);
		
	}
	
	class Calculator{
		int add(int a, int b) {
			return a + b;
		}
	}

}
