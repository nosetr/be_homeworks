package com.nosetr._20231030;

import java.util.Arrays;

public class Calculator {

	// 1. Простое сложение двух чисел
	public int add(int a, int b) {
		return a + b;
	}

	// 2. Вычитание
	public int subtract(int a, int b) {
		return a - b;
	}

	// 3. Умножение
	public int multiply(int a, int b) {
		return a * b;
	}

	// 4. Деление
	public int divide(int a, int b) {
		if (b == 0) { throw new ArithmeticException("Division by zero"); }
		return a / b;
	}

	// 5. Возведение в степень
	public double power(double base, double exponent) {
		return Math.pow(base, exponent);
	}

	// 6. Вычисление факториала
	public long factorial(int n) {
		return (n <= 1) ? 1 : n * factorial(n - 1);
	}

	// 7. Определение четности числа
	public boolean isEven(int n) {
		return n % 2 == 0;
	}

	// 8. Поиск максимального числа в массиве
	public int findMax(int[] array) {
		return Arrays.stream(array).max().getAsInt();
	}

	// 9. Определение простого числа
	public boolean isPrime(int n) {
		if (n <= 1) { return false; }
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) { return false; }
		}
		return true;
	}

	// 10. Перевод числа в строку с указанием системы счисления
	public String toBaseString(int n, int base) {
		if (base < 2 || base > 16) { throw new IllegalArgumentException("Base should be between 2 and 16"); }
		return Integer.toString(n, base);
	}

	// 11. Вычисление корня числа
	public double sqrt(double a) {
		if (a < 0) { throw new IllegalArgumentException("Negative numbers are not supported"); }
		return Math.sqrt(a);
	}

	// 12. Инвертирование строки
	public String reverseString(String input) {
		if (input == null || input.equals("")) throw new NullPointerException();
		return new StringBuilder(input).reverse().toString();
	}

	// 13. Проверка, является ли строка палиндромом
	public boolean isPalindrome(String input) {
		String reversed = reverseString(input);
		return input.equals(reversed);
	}

	// 14. Вычисление НОД двух чисел
	public int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	// 15. Перемножение элементов массива
	public long productOfArray(int[] array) {
		return Arrays.stream(array).reduce(1, (a, b) -> a * b);
	}

	// 16. Определение длины самого длинного слова в строке
	public int lengthOfLongestWord(String sentence) {
		String[] words = sentence.split("\\s+");
		int maxLength = 0;
		for (String word : words) {
			if (word.length() > maxLength) {
				maxLength = word.length();
			}
		}
		return maxLength;
	}

	// 17. Конвертация температуры из Цельсия в Фаренгейт
	public double celsiusToFahrenheit(double celsius) {
		// °F = (°C * 9/5) + 32
		return (celsius * 9 / 5) + 32;
	}

	// 18. Проверка на вхождение подстроки в строку (без использования стандартных
	// методов Java)
	public boolean containsSubstring(String main, String sub) {
		if (main == null || sub == null) throw new NullPointerException();
		int mainLength = main.length();
		int subLength = sub.length();

		if (mainLength < subLength) return false; // Not found

		for (int i = 0; i <= mainLength - subLength; i++) {
			int j;
			for (j = 0; j < subLength; j++) {
				if (main.charAt(i + j) != sub.charAt(j)) break;
			}
			if (j == subLength) return true; // Found
		}
		return false; // Not found
	}

	// 19. Сумма цифр числа
	// 256 --- 2 + 5 + 6
	public int sumOfDigits(int number) {
		int sum = 0;
		if (number < 0) number *= -1;
		while (number > 0) {
			int dig = number % 10;
			sum += dig;
			number /= 10;
		}
		return sum;
	}

	// 20. Проверка, является ли год високосным
	public boolean isLeapYear(int year) {
		return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ? true : false;
	}
}
