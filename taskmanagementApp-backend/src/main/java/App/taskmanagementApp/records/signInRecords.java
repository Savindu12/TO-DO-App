package App.taskmanagementApp.records;

public class signInRecords {

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String email;
	private String password;
	
	public signInRecords () {
		
	}

	public signInRecords(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
