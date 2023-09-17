package com.nosetr._20230916;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Уровень сложности 7 из 10:
 * 
 * Перебрать ArrayList<Integer> и удалить все четные числа.
 * 
 * Перебрать LinkedList<Integer> и заменить все элементы, кратные 3, на нули.
 * 
 * Перебрать ArrayList<String> и объединить все элементы в одну строку.
 * 
 * Перебрать LinkedList<String> и удалить все элементы, содержащие определенную
 * подстроку.
 * 
 * Создать ArrayList с объектами вашего собственного класса и вывести только те,
 * которые удовлетворяют определенному условию.
 */
public class Task3 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(6);
		list.add(9);
		list.add(2);
		list.add(12);
		/*
		 * Перебрать ArrayList<Integer> и удалить все четные числа.
		 */
		List<Integer> list1 = new ArrayList<Integer>(list);
		task31(list1);

		/*
		 * Перебрать LinkedList<Integer> и заменить все элементы, кратные 3, на нули.
		 */
		List<Integer> list2 = new LinkedList<Integer>(list);
		task32(list2);

		/*
		 * Перебрать ArrayList<String> и объединить все элементы в одну строку.
		 */
		List<String> listStrings1 = new ArrayList<String>();
		listStrings1.add("proba");
		listStrings1.add("proba2");
		listStrings1.add("proba225");
		listStrings1.add("notaproba8");
		task33(listStrings1);

		/*
		 * Перебрать LinkedList<String> и удалить все элементы, содержащие определенную
		 * подстроку.
		 */
		List<String> listStrings2 = new LinkedList<String>(listStrings1);
		task34(listStrings2, "2");

		/*
		 * Создать ArrayList с объектами вашего собственного класса и вывести только те,
		 * которые удовлетворяют определенному условию.
		 */
		List<Departments> departments = new LinkedList<Departments>();
		departments.add(new Departments("Production1", "DE"));
		departments.add(new Departments("Production2", "IT"));
		departments.add(new Departments("Production3", "UK"));
		departments.add(new Departments("Production4", "BE"));
		departments.add(new Departments("Production5", "DE"));
		departments.add(new Departments("Management1", "IT"));
		departments.add(new Departments("Management2", "FR"));
		departments.add(new Departments("Management3", "DE"));
		departments.add(new Departments("Management4", "UK"));
		departments.add(new Departments("Management5", "DE"));
		task35(departments, "IT");
	}

	/**
	 * Создать ArrayList с объектами вашего собственного класса и вывести только те,
	 * которые удовлетворяют определенному условию.
	 * 
	 * @param departments
	 * @param country
	 */
	static void task35(List<Departments> departments, String country) {
		for (Departments dep : departments) {
			if(dep.country() == country)
				System.out.println(dep);
		}
	}

	/**
	 * Перебрать LinkedList<String> и удалить все элементы, содержащие определенную
	 * подстроку.
	 * 
	 * @param list
	 */
	static void task34(List<String> list, String subString) {
		list.removeIf((String s) -> s.indexOf(subString) != -1);
		System.out.println(list);
	}

	/**
	 * Перебрать ArrayList<String> и объединить все элементы в одну строку.
	 * 
	 * @param list
	 */
	static void task33(List<String> list) {
		StringBuilder sb = new StringBuilder();
		
		for (String string : list) {
			sb.append(string + " ");
		}
		System.out.println(sb.toString().trim());
	}

	/**
	 * Перебрать LinkedList<Integer> и заменить все элементы, кратные 3, на нули.
	 * 
	 * @param list
	 */
	static void task32(List<Integer> list) {
		ListIterator<Integer> listIterator = list.listIterator();
		System.out.println(list);
		while (listIterator.hasNext()) {
			Integer integer = listIterator.next();
			if (integer % 3 == 0)
				listIterator.set(0);
		}

		System.out.println(list);
	}

	/**
	 * Перебрать ArrayList<Integer> и удалить все четные числа.
	 * 
	 * @param list
	 */
	static void task31(List<Integer> list) {
		ListIterator<Integer> listIterator = list.listIterator();
		System.out.println(list);
		while (listIterator.hasNext()) {
			Integer integer = listIterator.next();
			if (integer % 2 == 0)
				listIterator.remove();
		}

		System.out.println(list);
	}
}
