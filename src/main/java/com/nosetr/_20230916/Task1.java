package com.nosetr._20230916;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Уровень сложности 5 из 10:
 * 
 * Найти сумму всех элементов ArrayList<Integer>.
 * 
 * Найти среднее значение элементов LinkedList<Integer>.
 * 
 * Перебрать ArrayList<String> и вывести все элементы на экран.
 * 
 * Перебрать LinkedList<String> и найти самую длинную строку.
 * 
 * Создать ArrayList с объектами вашего собственного класса и вывести их на
 * экран.
 */
public class Task1 {

	public static void main(String[] args) {
		/*
		 * Найти сумму всех элементов ArrayList<Integer>.
		 */
		List<Integer> list1 = new ArrayList<>();
		list1.add(5);
		list1.add(25);
		list1.add(53);
		list1.add(54);
		list1.add(555);
		task11(list1);

		/*
		 * Найти среднее значение элементов LinkedList<Integer>.
		 */
		List<Integer> list2 = new LinkedList<>();
		list2.addAll(list1);
		task12(list2);

		/*
		 * Перебрать ArrayList<String> и вывести все элементы на экран.
		 */
		List<String> listStrings1 = new ArrayList<String>();
		listStrings1.add("proba");
		listStrings1.add("proba2");
		listStrings1.add("proba225");
		task13(listStrings1);

		/*
		 * Перебрать LinkedList<String> и найти самую длинную строку.
		 */
		List<String> listStrings2 = new LinkedList<String>(listStrings1);
		task14(listStrings2);

		/*
		 * Создать ArrayList с объектами вашего собственного класса и вывести их на
		 * экран.
		 */
		task15();
	}

	/**
	 * Создать ArrayList с объектами вашего собственного класса и вывести их на
	 * экран.
	 */
	static void task15() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("John"));
		persons.add(new Person("Bob"));
		persons.add(new Person("Anna"));
		persons.add(new Person("Nick"));

		for (Person person : persons) {
			System.out.println(person.name());
		}

	}

	/**
	 * Перебрать LinkedList<String> и найти самую длинную строку.
	 * 
	 * @param list
	 */
	static void task14(List<String> list) {
		String lString = "";
		for (String string : list) {
			lString = lString.length() < string.length() ? string : lString;
		}
		System.out.println(lString);
	}

	/**
	 * Перебрать ArrayList<String> и вывести все элементы на экран.
	 * 
	 * @param list
	 */
	static void task13(List<String> list) {
		for (String string : list) {
			System.out.println(string);
		}
	}

	/**
	 * Найти среднее значение элементов LinkedList<Integer>.
	 * 
	 * @param list
	 */
	static void task12(List<Integer> list) {
		double sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		System.out.println(sum / list.size());
	}

	/**
	 * Найти сумму всех элементов ArrayList<Integer>.
	 * 
	 * @param list
	 */
	static void task11(List<Integer> list) {
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		System.out.println(sum);
	}
}

record Person(String name) {}
