package App.taskmanagementApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import App.taskmanagementApp.model.task;

public interface taskRepository extends JpaRepository <task, Long> {

}
