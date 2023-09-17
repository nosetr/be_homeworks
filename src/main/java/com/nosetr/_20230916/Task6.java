package com.nosetr._20230916;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Уровень сложности 10 из 10:
 * 
 * Перебрать ArrayList<Integer> и найти наибольшую возрастающую
 * последовательность элементов.
 * 
 * Перебрать LinkedList<Integer> и удалить все дубликаты элементов.
 * 
 * Перебрать ArrayList<String> и создать новый список, содержащий только
 * уникальные строки.
 * 
 * Перебрать LinkedList<String> и объединить все строки в одну с использованием
 * разделителя.
 * 
 * Создать LinkedList с объектами вашего собственного класса и отсортировать их
 * по нескольким критериям.
 * 
 */
public class Task6 {

	public static void main(String[] args) {
		/*
		 * Перебрать ArrayList<Integer> и найти наибольшую возрастающую
		 * последовательность элементов.
		 */
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(3);
		task61(list);

		/*
		 * Перебрать LinkedList<Integer> и удалить все дубликаты элементов.
		 */
		List<Integer> list2 = new LinkedList<Integer>(list);
		task62(list2);

		/*
		 * Перебрать ArrayList<String> и создать новый список, содержащий только
		 * уникальные строки.
		 */
		List<String> listStrings = new ArrayList<String>();
		listStrings.add("proba");
		listStrings.add("proba2");
		listStrings.add("proba225");
		listStrings.add("notaproba8");
		listStrings.add("proba2");
		listStrings.add("proba225");
		task63(listStrings);

		/*
		 * Перебрать LinkedList<String> и объединить все строки в одну с использованием
		 * разделителя.
		 */
		List<String> listStrings2 = new LinkedList<String>(listStrings);
		String delString = " + ";
		task64(listStrings2, delString);

		/*
		 * Создать LinkedList с объектами вашего собственного класса и отсортировать их
		 * по нескольким критериям.
		 */
		List<User> users = new LinkedList<User>();
		users.add(new User(1, "John", 25, 2022));
		users.add(new User(2, "Bob", 21, 2023));
		users.add(new User(3, "Marta", 32, 2019));
		users.add(new User(4, "Sven", 25, 2019));
		users.add(new User(5, "Igor", 28, 2020));
		task65(users);
	}

	/**
	 * Создать LinkedList с объектами вашего собственного класса и отсортировать их
	 * по нескольким критериям.
	 * 
	 * @param users
	 */
	static void task65(List<User> users) {
		System.out.println(users);
		Collections.sort(users); // compareTo
		System.out.println(users);
	}

	/**
	 * Перебрать LinkedList<String> и объединить все строки в одну с использованием
	 * разделителя.
	 * 
	 * @param listStrings2
	 * @param delString
	 */
	static void task64(List<String> listStrings, String delString) {
		ListIterator<String> listIterator = listStrings.listIterator();
		StringBuilder stringBuilder = new StringBuilder();
		while (listIterator.hasNext()) {
			String string = listIterator.next();
			stringBuilder.append(string);
			if (listIterator.hasNext())
				stringBuilder.append(delString);
		}

		System.out.println(stringBuilder.toString());
	}

	/**
	 * Перебрать ArrayList<String> и создать новый список, содержащий только
	 * уникальные строки.
	 * 
	 * @param listStrings
	 */
	static void task63(List<String> listStrings) {
		HashSet<String> uniSet = new HashSet<String>(listStrings);
		List<String> uniList = new ArrayList<String>(uniSet);

		System.out.println(uniList);
	}

	/**
	 * Перебрать LinkedList<Integer> и удалить все дубликаты элементов.
	 * 
	 * @param list2
	 */
	static void task62(List<Integer> list) {
		HashSet<Integer> uniSet = new HashSet<Integer>();

		ListIterator<Integer> iterator = list.listIterator();

		while (iterator.hasNext()) {
			Integer integer = iterator.next();
			if (uniSet.contains(integer)) {
				iterator.remove();
			} else {
				uniSet.add(integer);
			}
		}
		System.out.println(list);
	}

	/**
	 * Перебрать ArrayList<Integer> и найти наибольшую возрастающую
	 * последовательность элементов.
	 * 
	 * @param list
	 */
	static void task61(List<Integer> list) {
		List<Integer> maxList = new ArrayList<Integer>();
		List<Integer> curList = new ArrayList<Integer>();
		int size = list.size();

		for (int i = 0, k = 1; i < size; i++) {
			int current = list.get(i);

			curList.add(current);

			if (maxList.size() < curList.size())
				maxList = new ArrayList<Integer>(curList);

			if (current > list.get(k))
				curList.clear();

			if (k + 1 < size)
				k++;
		}

		System.out.println(maxList);

	}

}

record User(int id, String name, int age, int registerYear) implements Comparable<User> {

	@Override
	public int compareTo(User o) {
		// at first sort by REGISTERD SINCE:
		int regCompare = this.registerYear() - o.registerYear();
		if(regCompare != 0)
			return regCompare;
		
		// then by AGE:
		return Integer.compare(this.age(), o.age());
	}

	@Override
	public String toString() {
		return "ID: " + id + " NAME: " + name + " AGE: " + age + " REGISTERD SINCE: " + registerYear + "\n";
	}

}
