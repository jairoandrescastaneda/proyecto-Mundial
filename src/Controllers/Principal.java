package Controllers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"model"})
@SpringBootApplication


public class Principal {

	
	 public static void main(String[] args) {
	        SpringApplication.run(Principal.class, args);
	    }
}
