package za.co.digitalplatoon.invoiceservices.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EntityScan
@EnableAutoConfiguration
@SpringBootApplication
public class EohdigitalplatoonRecruitmentAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EohdigitalplatoonRecruitmentAssignmentApplication.class, args);
	}
}
