package App.taskmanagementApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import App.taskmanagementApp.records.signInRecords;
import App.taskmanagementApp.records.userRecords;
import App.taskmanagementApp.Interfaces.userInterfaces;
import App.taskmanagementApp.records.loginMessage;

@RestController
@RequestMapping("/api/v1/")
public class userController {

	@Autowired
	private userInterfaces UserService;
	
	@PostMapping(path = "/save")
	public String saveUser(@RequestBody userRecords UserRecord) {
		String id = UserService.addUser(UserRecord);
		return id;
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<?>loginUser(@RequestBody signInRecords SignRecords){
		@SuppressWarnings("unused")
		loginMessage Loginresponse = UserService.LogInUser(SignRecords);
		return ResponseEntity.ok(SignRecords);
	}
	
}
