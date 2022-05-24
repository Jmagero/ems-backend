package jm.ems.emsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


@SpringBootApplication
@EnableEncryptableProperties
public class EmsBackendApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
	}
	
}
