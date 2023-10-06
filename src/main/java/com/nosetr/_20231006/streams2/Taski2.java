package com.nosetr._20231006.streams2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Задача 1: Фильтрация четных чисел и умножение на 2.
 * Задача 2: Удаление дубликатов из списка строк.
 * Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех
 * элементов.
 * Задача 4: Фильтрация строк, начинающихся на "A" и преобразование в верхний
 * регистр.
 * Задача 5: Пропуск первых двух элементов и вывод оставшихся.
 * Задача 6: Фильтрация чисел больше 50 и вывод их квадратов.
 * Задача 7: Оставить только слова, содержащие букву "o" и вывести их в обратном
 * порядке.
 * Задача 8: Фильтрация чисел, оставить только нечетные и вывести их в порядке
 * возрастания.
 * Задача 9: Получить среднее значение чисел в списке.
 * Задача 10: Получить строку, объединяющую элементы списка через запятую.
 * Задача 11: Получить список квадратов чисел из другого списка.
 * Задача 12: Получить список букв из списка слов и вывести их в алфавитном
 * порядке.
 * Задача 13: Получить первые 3 строки из списка и вывести их в обратном
 * порядке.
 * Задача 14: Пропустить первые 2 элемента и оставить только уникальные.
 * Задача 15: Фильтрация и сортировка пользователей по возрасту.
 * class User { private String name; private int age;
 * public User(String name, int age) { this.name = name; this.age = age; }
 * public String getName() { return name; }
 * public int getAge() { return age; } }
 */
public class Taski2 {

	public static void main(String[] args) {
		/*
		 * Задача 1: Фильтрация четных чисел и умножение на 2.
		 */
		List<Integer> list = List.of(5, 4, 7, 9, 3, 6, 8);
		System.out.println(list.stream().filter(i -> i % 2 == 0).map(i -> i * 2).toList());

		/*
		 * Задача 2: Удаление дубликатов из списка строк.
		 */
		List<String> strings = List
				.of("aoDf", "qPr", "ffRTz", "bfr", "AaFgrt", "ggDhx", "ffRTz", "AsdErf", "okLdfcFw", "bho");
		System.out.println(strings.stream().distinct().toList());

		/*
		 * Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех
		 * элементов.
		 */
		System.out.println(list.stream().sorted((i1, i2) -> i2.compareTo(i1)).limit(3).toList());

		/*
		 * Задача 4: Фильтрация строк, начинающихся на "A" и преобразование в верхний
		 * регистр.
		 */
		String toFindString = "A";
		System.out.println(strings.stream().filter(s -> s.startsWith(toFindString)).map(String::toUpperCase).toList());

		/*
		 * Задача 5: Пропуск первых двух элементов и вывод оставшихся.
		 */
		System.out.println(list.stream().skip(2).toList());

		/*
		 * Задача 6: Фильтрация чисел больше 50 и вывод их квадратов.
		 */
		List<Integer> list2 = List.of(25, 56, 87, 90);
		System.out.println(list2.stream().filter(i -> i > 50).map(i -> i * i).toList());

		/*
		 * Задача 7: Оставить только слова, содержащие букву "o" и вывести их в обратном
		 * порядке.
		 */
		char findIt = 'o';
		System.out.println(strings.stream().filter(s -> s.contains(String.valueOf(findIt))).toList());

		/*
		 * Задача 8: Фильтрация чисел, оставить только нечетные и вывести их в порядке
		 * возрастания.
		 */
		System.out.println(list.stream().filter(i -> i % 2 != 0).sorted().toList());

		/*
		 * Задача 9: Получить среднее значение чисел в списке.
		 */
		System.out.println(list.stream().mapToDouble(Integer::doubleValue).average().getAsDouble());

		/*
		 * Задача 10: Получить строку, объединяющую элементы списка через запятую.
		 */
		System.out.println(strings.stream().collect(Collectors.joining(", ")));

		/*
		 * Задача 11: Получить список квадратов чисел из другого списка.
		 */
		System.out.println(list.stream().map(i -> i * i).toList());

		/*
		 * Задача 12: Получить список букв из списка слов и вывести их в алфавитном
		 * порядке.
		 */
		System.out.println(
				strings.stream().map(String::toLowerCase).flatMap(s -> s.chars().mapToObj(c -> (char) c)).distinct().sorted()
						.toList()
		);

		/*
		 * Задача 13: Получить первые 3 строки из списка и вывести их в обратном
		 * порядке.
		 */
		List<String> strings2 = strings.stream().limit(3).collect(Collectors.toList());
		Collections.reverse(strings2);
		System.out.println(strings2);

		/*
		 * Задача 14: Пропустить первые 2 элемента и оставить только уникальные.
		 */
		System.out.println(strings.stream().skip(2).distinct().toList());

		/*
		 * Задача 15: Фильтрация и сортировка пользователей по возрасту.
		 */
		List<User> users = List.of(new User("Bob", 24), new User("John", 33), new User("Masha", 15), new User("Chan", 42));
		System.out.println(users.stream().sorted((u1, u2) -> Integer.compare(u1.getAge(), u2.getAge())).toList());
	}

}

class User {
	private String name;
	private int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() { return name; }

	public int getAge() { return age; }

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
}
