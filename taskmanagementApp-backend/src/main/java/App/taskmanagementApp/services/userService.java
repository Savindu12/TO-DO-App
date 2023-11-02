package App.taskmanagementApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import App.taskmanagementApp.repository.userRepository;
import App.taskmanagementApp.model.user;
import App.taskmanagementApp.records.loginMessage;
import App.taskmanagementApp.records.userRecords;
import App.taskmanagementApp.records.signInRecords;
import App.taskmanagementApp.Interfaces.userInterfaces;
import java.util.Optional;

@Service
public class userService implements userInterfaces{

	@Autowired
	private userRepository UserRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addUser (userRecords UserRecords) {
		user User = new user (
				UserRecords.getId(),
				UserRecords.getFirst_name(),
				UserRecords.getLast_name(),
				UserRecords.getEmail(),
				this.passwordEncoder.encode(UserRecords.getPassword())
		);
		
		UserRepo.save(User);
		return User.getEmail();
	}
	
	userRecords UserRecords;
	
	
	public loginMessage  loginEmployee(signInRecords SignRecords) {
     
        user User = UserRepo.findByEmail(SignRecords.getEmail());
        if (User != null) {
            String password = SignRecords.getPassword();
            String encodedPassword = User.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<user> employee = UserRepo.findByEmailAndPassword(SignRecords.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new loginMessage("Login Success", true);
                } else {
                    return new loginMessage("Login Failed", false);
                }
            } else {
                return new loginMessage("password Not Match", false);
            }
        }else {
            return new loginMessage("Email not exits", false);
        }
    }


	@Override
	public loginMessage LogInUser(signInRecords SignRecords) {
		// TODO Auto-generated method stub
		return null;
	}


}
