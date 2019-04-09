package emailapp;

import java.util.Scanner;

public class Email {
	private String fName;
	private String lName;
	private String password;
	private String department;
	private String email;
	private int boxCapacity = 300;
	private int defaultPasswordLength = 10;
	private String altEmail;
	
	public Email(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
		
		//Call setDepartment method
		this.department = setDepartment();
		//System.out.println("Department: " + this.department);
		
		//Call randomPassword method
		this.password = randomPassword(defaultPasswordLength);
		//System.out.println("Password: "+ this.password);
		
		//Generate email
		email = fName.toLowerCase() + "." + lName.toLowerCase() + "." + "@" + department + "." + "test.com";
		//System.out.println("Email: "+ email);
	}
	
	private String setDepartment() {
		System.out.println("Enter department: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		switch(depChoice) {
			case 1:
				return "sales";
			case 2:
				return "development";
			case 3: 
				return "accounting";
			case 4:
				return "none";
			default:
				return "none";
		}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//setter for mail capacity
	public void setMailCapacity(int capacity) {
		this.boxCapacity = capacity;
	}
	
	//setter for altEmail
	public void setAltEmail(String email) {
		this.altEmail = email;
	}
	
	//to change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	//getter for mailbox capacity
	public int getMailboxCapacity() {
		return boxCapacity;
	}
	
	//getter for alternative email
	public String getAltEmail() {
		return altEmail;
	}
	
	//getter for password
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "Name: " + fName + " " + lName + 
				"\nPassword: " + password +
				"\nEmail: " + email + 
				"\nMailbox Capacity: " + boxCapacity + "mb";
	}
}
