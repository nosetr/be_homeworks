package com.nosetr._20231206.taski;

public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		if (b != 0) {
			return a / b;
		} else {
			throw new ArithmeticException("Division by zero");
		}
	}
}

/**
 * My solution:
 */
class CalculatorMy {
	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) throws ArithmeticException {
		return a / b;
	}
}