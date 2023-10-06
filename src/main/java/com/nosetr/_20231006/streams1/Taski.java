package com.nosetr._20231006.streams1;

import java.util.Arrays;
import java.util.List;

/**
 * Задание 1: Фильтрация списка целых чисел на нечетные числа
 * 
 * Задание 2: Преобразование списка строк в список чисел
 * 
 * Задание 3: Суммирование списка чисел
 * 
 * Задание 4: Определение максимального значения в списке
 * 
 * Задание 5: Фильтрация списка строк на те, которые начинаются с определенной
 * буквы и преобразование их в верхний регистр
 * 
 * Задание 6: Получение списка уникальных слов из списка строк, длина которых
 * больше 4 символов
 * 
 * Задание 7:Преобразование списка объектов класса в список их имен,
 * отсортированных по возрасту ------
 * 
 * Задание 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел -------
 * 
 * Задание 9:Получение списка слов, содержащих только уникальные символы, из
 * списка строк
 */
public class Taski {

	public static void main(String[] args) {
		/*
		 * Задание 1: Фильтрация списка целых чисел на нечетные числа
		 */
		List<Integer> list = Arrays.asList(32, 1, 6, 5, 4, 9, 9, 9, 9, 87);

		List<Integer> list1 = list.stream().filter(digit -> digit % 2 != 0).toList();
		System.out.println(list1);

		/*
		 * Задание 2: Преобразование списка строк в список чисел
		 */
		// #1
		String[] listStrings = { "32", "1", "6", "5", "4", "9", "9", "9", "9", "87" };
		List<Integer> lst = Arrays.stream(listStrings).map(Integer::parseInt).toList();
		System.out.println(lst);
		// #2
		List<String> listStrings2 = Arrays.asList("32", "1", "6", "5", "4", "9", "9", "9", "9", "87");
		List<Integer> lst2 = listStrings2.stream().mapToInt(w -> Integer.parseInt(w)) // String to int
				.boxed() // int to Integer
				.toList();
		System.out.println(lst2);

		/*
		 * Задание 3: Суммирование списка чисел
		 */
		// #1
		System.out.println(lst.stream().reduce(0, Integer::sum));
		// #2
		System.out.println(lst.stream().mapToInt(Integer::intValue) // Interger to int
				.sum());

		/*
		 * Задание 4: Определение максимального значения в списке
		 */
		List<Integer> list2 = List.of(1, 12, 5, 2, 3, 6, 7, 8, 4, 9, 10);
		Integer max = list2.stream().max(Integer::compareTo).get();
		System.out.println(max);

		/*
		 * Задание 5: Фильтрация списка строк на те, которые начинаются с определенной
		 * буквы и преобразование их в верхний регистр
		 */
		List<String> strings = List.of("aDf", "ffRTz", "bfr", "ggDhx", "ffRTz", "okLdfcFw", "bhz");
		String find = "b";
		System.out.println(strings.stream().filter(w -> w.startsWith(find)).map(String::toUpperCase).toList());

		/*
		 * Задание 6: Получение списка уникальных слов из списка строк, длина которых
		 * больше 4 символов
		 */
		System.out.println(strings.stream().filter(w -> w.length() > 4).distinct().toList());

		/*
		 * Задание 7:Преобразование списка объектов класса в список их имен,
		 * отсортированных по возрасту ------
		 */
		List<Person> persons = List.of(new Person("John", 20), new Person("Marta", 25), new Person("Bob", 23));
		List<String> nameStrings = persons.stream().sorted((p1, p2) -> Integer.compare(p1.age(), p2.age()))
				.map(Person::nameString).toList();
		System.out.println(nameStrings);

		/*
		 * Задание 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел -------
		 */
		System.out.println(list2.stream().filter(i -> i % 3 == 0 || i % 5 == 0).mapToInt(Integer::intValue).sum());

		/*
		 * Задание 9:Получение списка слов, содержащих только уникальные символы, из
		 * списка строк
		 */
		System.out.println(strings.stream().filter(s -> s.chars().distinct().count() == s.length()).toList());
	}

}

record Person(String nameString, int age) {}
