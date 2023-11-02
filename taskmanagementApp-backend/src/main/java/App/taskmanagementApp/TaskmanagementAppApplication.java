package App.taskmanagementApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("App.taskmanagementApp")
public class TaskmanagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagementAppApplication.class, args);
	}

}
