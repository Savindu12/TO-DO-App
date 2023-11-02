package App.taskmanagementApp.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class messagesController {

	@GetMapping("/messages")
	public ResponseEntity<List<String>> messages(){
		return ResponseEntity.ok(Arrays.asList("First", "second"));
	}
}
