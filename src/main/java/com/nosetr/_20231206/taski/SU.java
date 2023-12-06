package com.nosetr._20231206.taski;

public class SU {
	public static String formatName(String firstName, String lastName) {
		return firstName + " " + lastName;
	}

	public static String formatAddress(String street, String city, String zipCode) {
		return street + ", " + city + ", " + zipCode;
	}

	// Дублирование кода форматирования строки
	public static String formatString(String... parts) {
		StringBuilder builder = new StringBuilder();
		for (String part : parts) {
			builder.append(part).append(", ");
		}
		return builder.toString().trim();
	}
}

/**
 * My solution:
 */
class SUMy {
	public static String formatName(String firstName, String lastName) {
		return firstName + " " + lastName;
	}

	public static String formatAddress(String street, String city, String zipCode) {
		return formatString(street, city, zipCode);
	}

	public static String formatString(String... parts) {
		StringBuilder builder = new StringBuilder(parts[0]);
		for (int i = 1; i < parts.length; i++) {
			builder.append(", ").append(parts[i]);
		}
		return builder.toString();
	}
}