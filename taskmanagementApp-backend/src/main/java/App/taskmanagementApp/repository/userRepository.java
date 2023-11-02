package App.taskmanagementApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import App.taskmanagementApp.model.user;

public interface userRepository extends JpaRepository<user, Long> {

	Optional<user> findByEmailAndPassword(String email, String password);
	
	user findByEmail(String email);

}
