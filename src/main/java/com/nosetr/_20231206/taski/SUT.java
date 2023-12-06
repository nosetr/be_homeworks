package com.nosetr._20231206.taski;

public class SUT {

	public static String toUpperCase1(String input) {
		return input.toUpperCase();
	}

	public static String toLowerCase2(String input) {
		return input.toLowerCase();
	}

	public static char[] toCharArray2(String input) {
		char[] result = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			result[i] = input.charAt(i);
		}
		return result;
	}
}

/**
 * My solution:
 */
class SUTMy {

	/**
	 * To delete
	 * 
	 * @param input
	 * @return
	 */
	@Deprecated
	public static String toUpperCase1(String input) {
		return input.toUpperCase();
	}

	/**
	 * To delete
	 * 
	 * @param input
	 * @return
	 */
	@Deprecated
	public static String toLowerCase2(String input) {
		return input.toLowerCase();
	}

	public static char[] toCharArray2(String input) {
		char[] result = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			result[i] = input.charAt(i);
		}
		return result;
	}
}