package com.nosetr._20231030;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	private Calculator calculator;
	
	@BeforeEach
	void setUp() throws Exception {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("1. Простое сложение двух чисел")
	void testAdd() {
		int a = 10;
		int b = 10;
		int expected = 20;
		Assertions.assertEquals(expected, calculator.add(a, b));
		
	}

	@Test
	@DisplayName("2. Вычитание")
	void testSubtract() {
		int a = 10;
		int b = 10;
		int expected = 0;
		Assertions.assertEquals(expected, calculator.subtract(a, b));
	}

	@Test
	@DisplayName("3. Умножение")
	void testMultiply() {
		int a = 10;
		int b = 10;
		int expected = 100;
		Assertions.assertEquals(expected, calculator.multiply(a, b));
	}

	@Test
	@DisplayName("4. Деление")
	void testDivide() {
		int a = 10;
		int b = 10;
		int expected = 1;
		Assertions.assertEquals(expected, calculator.divide(a, b));
	}

	@Test
	@DisplayName("4. Деление: Throw Exception By Zero")
	void testDivideByZero() {
		Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
	}

	@Test
	@DisplayName("5. Возведение в степень")
	void testPower() {
		double a = 10;
		double b = 2;
		double expected = 100;
		Assertions.assertEquals(expected, calculator.power(a, b));
	}

	@Test
	@DisplayName("6. Вычисление факториала")
	void testFactorial() {
		int n = 4;
		double expected = 24;
		Assertions.assertEquals(expected, calculator.factorial(n));
	}

	@Test
	@DisplayName("7. Определение четности числа")
	void testIsEven() {
		int n = 4;
		Assertions.assertTrue(calculator.isEven(n));
	}

	@Test
	@DisplayName("8. Поиск максимального числа в массиве")
	void testFindMax() {
		int[] array = { 9, 4, 5, 6, 1 };
		int expected = 9;
		Assertions.assertEquals(expected, calculator.findMax(array));
	}

	@Test
	@DisplayName("9. Определение простого числа: n <= 1")
	void testIsPrime1() {
		int n = 1;
		Assertions.assertFalse(calculator.isPrime(n));
	}

	@Test
	@DisplayName("9. Определение простого числа: n > 1 but not a prime")
	void testIsPrime2() {
		int n = 4;
		Assertions.assertFalse(calculator.isPrime(n));
	}

	@Test
	@DisplayName("9. Определение простого числа: is prime")
	void testIsPrime3() {
		int n = 11;
		Assertions.assertTrue(calculator.isPrime(n));
	}

	@Test
	@DisplayName("10. Перевод числа в строку с указанием системы счисления: throw IllegalArgumentException")
	void testToBaseStringThrowEx() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.toBaseString(5, 17));
	}

	@Test
	@DisplayName("10. Перевод числа в строку с указанием системы счисления: get string")
	void testToBaseString() {
		Assertions.assertInstanceOf(String.class, calculator.toBaseString(10, 4));
	}

	@Test
	@DisplayName("11. Вычисление корня числа: throw IllegalArgumentException")
	void testSqrtThrowEx() {
		double a = -1;
		Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(a));
	}

	@Test
	@DisplayName("11. Вычисление корня числа")
	void testSqrt() {
		double a = 4;
		double expected = 2;
		Assertions.assertEquals(expected, calculator.sqrt(a));
	}

	@Test
	@DisplayName("12. Инвертирование строки: throw NullPointerException")
	void testReverseStringThrowEx() {
		Assertions.assertThrows(NullPointerException.class, () -> calculator.reverseString(""));
	}

	@Test
	@DisplayName("12. Инвертирование строки")
	void testReverseString() {
		Assertions.assertEquals("aborp", calculator.reverseString("proba"));
	}

	@Test
	@DisplayName("13. Проверка, является ли строка палиндромом")
	void testIsPalindrome() {
		Assertions.assertTrue(calculator.isPalindrome("anna"));
	}

	@Test
	@DisplayName("14. Вычисление НОД двух чисел")
	void testGcd() {
		Assertions.assertEquals(3, calculator.gcd(12, 3));
	}

	@Test
	@DisplayName("15. Перемножение элементов массива")
	void testProductOfArray() {
		int[] array = {1,2,3,4,5};
		Assertions.assertEquals(120, calculator.productOfArray(array));
	}

	@Test
	@DisplayName("16. Определение длины самого длинного слова в строке")
	void testLengthOfLongestWord() {
		String string = "Mama milaa ramu";
		Assertions.assertEquals(5, calculator.lengthOfLongestWord(string));
	}

	@Test
	@DisplayName("17. Конвертация температуры из Цельсия в Фаренгейт")
	void testCelsiusToFahrenheit() {
		Assertions.assertEquals(68, calculator.celsiusToFahrenheit(20));
	}

	@Test
	@DisplayName("18. Проверка на вхождение подстроки в строку (без использования стандартных методов Java)")
	void testContainsSubstring() {
		Assertions.assertTrue(calculator.containsSubstring("proba string", "str"));
		Assertions.assertFalse(calculator.containsSubstring("proba string", "ono"));
		Assertions.assertFalse(calculator.containsSubstring("str","proba string"));
	}

	@Test
	@DisplayName("18. Проверка на вхождение подстроки в строку (без использования стандартных методов Java): throw NullPointerException")
	void testContainsSubstringThrowEx() {
		Assertions.assertThrows(NullPointerException.class, () -> calculator.containsSubstring(null, null));
		Assertions.assertThrows(NullPointerException.class, () -> calculator.containsSubstring("proba", null));
		Assertions.assertThrows(NullPointerException.class, () -> calculator.containsSubstring(null, "proba"));
	}

	@Test
	@DisplayName("19. Сумма цифр числа")
	void testSumOfDigits() {
		Assertions.assertEquals(13, calculator.sumOfDigits(-256));
		Assertions.assertEquals(13, calculator.sumOfDigits(256));
	}

	@Test
	@DisplayName("20. Проверка, является ли год високосным")
	void testIsLeapYear() {
		Assertions.assertTrue(calculator.isLeapYear(2024));
		Assertions.assertFalse(calculator.isLeapYear(2023));
	}

}


















