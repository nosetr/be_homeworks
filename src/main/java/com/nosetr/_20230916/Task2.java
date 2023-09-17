package com.nosetr._20230916;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Уровень сложности 6 из 10:
 * 
 * Перебрать ArrayList<Integer> и найти наименьший элемент.
 * 
 * Перебрать LinkedList<Integer> и найти наибольший элемент.
 * 
 * Перебрать ArrayList<String> и найти количество элементов, начинающихся с
 * определенной буквы.
 * 
 * Перебрать LinkedList<String> и найти первое вхождение определенной строки.
 * 
 * Создать LinkedList с объектами вашего собственного класса и удалить все
 * элементы, удовлетворяющие определенному условию.
 */
public class Task2 {

	public static void main(String[] args) {
		/*
		 * Перебрать ArrayList<Integer> и найти наименьший элемент.
		 */
		List<Integer> list1 = new ArrayList<>();
		list1.add(5);
		list1.add(25);
		list1.add(53);
		list1.add(54);
		list1.add(555);
		task21(list1);

		/*
		 * Перебрать LinkedList<Integer> и найти наибольший элемент.
		 */
		List<Integer> list2 = new LinkedList<>();
		list2.addAll(list1);
		task22(list2);

		/*
		 * Перебрать ArrayList<String> и найти количество элементов, начинающихся с
		 * определенной буквы.
		 */
		List<String> listStrings1 = new ArrayList<String>();
		listStrings1.add("proba");
		listStrings1.add("proba2");
		listStrings1.add("proba225");
		listStrings1.add("notaproba8");
		task23(listStrings1, 'p');

		/*
		 * Перебрать LinkedList<String> и найти первое вхождение определенной строки.
		 */
		List<String> listStrings2 = new LinkedList<String>(listStrings1);
		task24(listStrings2, "not");

		/*
		 * Создать LinkedList с объектами вашего собственного класса и удалить все
		 * элементы, удовлетворяющие определенному условию.
		 */
		task25();
	}

	/**
	 * Создать LinkedList с объектами вашего собственного класса и удалить все
	 * элементы, удовлетворяющие определенному условию.
	 */
	static void task25() {
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

		// Method # 1
//		departments.removeIf((Departments dep) -> dep.country() == "DE");

		// Method # 2
		ListIterator<Departments> listIterator = departments.listIterator();

		while (listIterator.hasNext()) {
			Departments dep = listIterator.next();
			if (dep.country() == "DE")
				listIterator.remove();
		}

		System.out.println("New LinkedList:" + departments);
	}

	/**
	 * Перебрать LinkedList<String> и найти первое вхождение определенной строки.
	 * 
	 * @param list
	 */
	static void task24(List<String> list, String subString) {
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).indexOf(subString) != -1) {
				index = i;
				break;
			}
		}
		System.out.println(index);
	}

	/**
	 * Перебрать ArrayList<String> и найти количество элементов, начинающихся с
	 * определенной буквы.
	 * 
	 * @param list
	 * @param c
	 */
	static void task23(List<String> list, char c) {
		int count = 0;
		for (String string : list) {
			if (string.toLowerCase().charAt(0) == c)
				count++;
		}
		System.out.println(count);
	}

	/**
	 * Перебрать LinkedList<Integer> и найти наибольший элемент.
	 * 
	 * @param list
	 */
	static void task22(List<Integer> list) {
		int i = Integer.MIN_VALUE;
		for (Integer integer : list) {
			i = Integer.max(integer, i);
		}
		System.out.println(i);
	}

	/**
	 * Перебрать ArrayList<Integer> и найти наименьший элемент.
	 * 
	 * @param list
	 */
	static void task21(List<Integer> list) {
		int i = Integer.MAX_VALUE;
		for (Integer integer : list) {
			i = Integer.min(integer, i);
		}
		System.out.println(i);
	}
}

record Departments(String name, String country) {}
