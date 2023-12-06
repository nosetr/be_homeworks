package com.nosetr._20231206.taski;

public class UserValidation {
	public boolean validateUsername(String username) {
		// Проверка на длину имени
		if (username.length() < 6 || username.length() > 20) { return false; }

		// Проверка на наличие специальных символов
		if (!username.matches("^[a-zA-Z0-9]+$")) { return false; }

		return true;
	}

	public boolean validateEmail(String email) {
		// Проверка на длину email
		if (email.length() < 6 || email.length() > 50) { return false; }

		// Проверка на наличие символа '@'
		if (!email.contains("@")) { return false; }

		return true;
	}
}

/**
 * My solution:
 */
class UserValidationMy {
	public boolean validateUsername(String username) {
		if (!checkLength(username, 6, 20) || !username.matches("^[a-zA-Z0-9]+$")) { return false; }
		return true;
	}

	public boolean validateEmail(String email) {
		// Проверка на длину email
		boolean result = checkLength(email, 6, 50);

		// Проверка на наличие символа '@'
		if (!checkLength(email, 6, 50) || !email.contains("@")) { return false; }

		return true;
	}

	private boolean checkLength(String string, int min, int max) {
		return (string.length() < min || string.length() > max) ? false : true;
	}
}