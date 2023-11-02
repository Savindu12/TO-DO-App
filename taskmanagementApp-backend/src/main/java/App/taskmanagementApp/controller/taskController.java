package App.taskmanagementApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import App.taskmanagementApp.repository.taskRepository;
import App.taskmanagementApp.exception.ResourceNotFoundException;
import App.taskmanagementApp.model.task;

@RestController
@RequestMapping("/api/v1/")
public class taskController {

	@Autowired
	private taskRepository TaskRepository;
	
	//Get All Tasks
	@GetMapping("/tasks")
	public List<task>getAllTasks() {
		return TaskRepository.findAll();
	} 
	
	// Create tasks
	@PostMapping("/tasks")
	public task createTask(@RequestBody task task) {
		return TaskRepository.save(task);
	}
	
	//Get task by Id
	@GetMapping("/tasks/{id}")
	public ResponseEntity <task> getTaskById(@PathVariable Long id){
		task task = TaskRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Tasks not exist"));
		return ResponseEntity.ok(task);
	}
	
	//Update task by Id
	@PutMapping("/tasks/{id}")
	public ResponseEntity <task> updateTask(@PathVariable Long id, @RequestBody task taskDetails){
		task task = TaskRepository.findById(id)
				   .orElseThrow(() -> new ResourceNotFoundException("Task not exist"));
		task.setTaskName(taskDetails.getTaskName());
		task.setDescription(taskDetails.getDescription());
		task.setTaskStatus(taskDetails.getTaskStatus());
		task.setDueDate(taskDetails.getDueDate());
		
		task updatedTask = TaskRepository.save(task);
		return ResponseEntity.ok(updatedTask);
	}
	
	//Delete task Details
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id){
		task task = TaskRepository.findById(id)
				   .orElseThrow(() -> new ResourceNotFoundException("Task not exist"));
		TaskRepository.delete(task);;
		Map<String, Boolean> response = new HashMap<>();
		response.put("Task Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
