package App.taskmanagementApp.Interfaces;


import App.taskmanagementApp.records.userRecords;
import App.taskmanagementApp.records.loginMessage;
import App.taskmanagementApp.records.signInRecords;

public interface userInterfaces {

	String addUser(userRecords UserRecords);

	loginMessage LogInUser(signInRecords SignRecords);
}
