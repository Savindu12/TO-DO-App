package App.taskmanagementApp.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private long taskId; 

	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "task_status")
	private String taskStatus;
	
	@Column(name = "task_date")
	private Date dueDate;
	
	@Column(name = "task_description")
	private String Description;
	
	public task() {
		
	}
	
	public task(String taskName, String taskStatus, Date dueDate, String description) {
		super();
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		this.dueDate = dueDate;
		this.Description = description;
	}
	
	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
