package com.nosetr._20231206.taski;

public class Employee {
	private String firstName;
	private String lastName;

	public String getFullName() { return firstName + " " + lastName; }

	public String getInitials() { return firstName.charAt(0) + "." + lastName.charAt(0) + "."; }

	// Дублирование кода формирования email
	public String getEmail() { return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@company.com"; }
}

/**
 * My solution:
 */
class EmployeeMy {
	private String firstName;
	private String lastName;

	public String getFullName() { return firstName + " " + lastName; }

	public String getInitials() { return firstName.charAt(0) + "." + lastName.charAt(0) + "."; }

	// Дублирование кода формирования email
	public String getEmail() { return generateEmail("@company.com"); }

	private String generateEmail(String string) {
		return firstName.toLowerCase() + "." + lastName.toLowerCase() + string;
	}
}