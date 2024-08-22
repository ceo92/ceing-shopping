package ceing.ceing;

import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class CeingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeingApplication.class, args);
	}

}
