package teste.piProject;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PiProjectApplication  implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(PiProjectApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
