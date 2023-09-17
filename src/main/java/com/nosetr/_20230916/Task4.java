package com.nosetr._20230916;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Уровень сложности 8 из 10:
 * 
 * Перебрать ArrayList<Integer> и найти сумму квадратов всех элементов.
 * 
 * Перебрать LinkedList<Integer> и вычислить произведение всех элементов.
 * 
 * Перебрать ArrayList<String> и найти самую короткую строку.
 * 
 * Перебрать LinkedList<String> и заменить все гласные буквы в каждой строке на
 * символ '*'.
 * 
 * Создать LinkedList с объектами вашего собственного класса и отсортировать их
 * в порядке убывания.
 * 
 */
public class Task4 {

	public static void main(String[] args) {
		/*
		 * Перебрать ArrayList<Integer> и найти сумму квадратов всех элементов.
		 */
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(6);
		list.add(9);
		list.add(2);
		list.add(12);
		task41(list);

		/*
		 * Перебрать LinkedList<Integer> и вычислить произведение всех элементов.
		 */
		List<Integer> list2 = new LinkedList<Integer>(list);
		task42(list2);

		/*
		 * Перебрать ArrayList<String> и найти самую короткую строку.
		 */
		List<String> listStrings = new ArrayList<String>();
		listStrings.add("proba");
		listStrings.add("proba2");
		listStrings.add("proba225");
		listStrings.add("notaproba8");
		task43(listStrings);

		/*
		 * Перебрать LinkedList<String> и заменить все гласные буквы в каждой строке на
		 * символ '*'.
		 */
		List<String> listStrings2 = new LinkedList<String>(listStrings);
		char[] abcList = { 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' };
		task44(abcList, listStrings2);

		/*
		 * Создать LinkedList с объектами вашего собственного класса и отсортировать их
		 * в порядке убывания.
		 */
		task45();
	}

	/**
	 * Создать LinkedList с объектами вашего собственного класса и отсортировать их
	 * в порядке убывания.
	 */
	static void task45() {
		List<Cat> cats = new LinkedList<Cat>();
		cats.add(new Cat("Tom", 5));
		cats.add(new Cat("Masja", 2));
		cats.add(new Cat("Shustrik", 7));
		cats.add(new Cat("Pushok", 1));
		cats.add(new Cat("Belka", 4));
		
		Collections.sort(cats, new AgeComparator());
		System.out.println(cats);
	}

	/**
	 * Перебрать LinkedList<String> и заменить все гласные буквы в каждой строке на
	 * символ '*'.
	 * 
	 * @param abcList
	 * @param list
	 */
	static void task44(char[] abcList, List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			for (char abc : abcList) {
				String newString = list.get(i).replace(abc, '*');
				list.set(i, newString);
			}
		}
		System.out.println(list);
	}

	/**
	 * Перебрать ArrayList<String> и найти самую короткую строку.
	 * 
	 * @param list
	 */
	static void task43(List<String> list) {
		int min = Integer.MAX_VALUE;
		String result = "";
		for (String string : list) {
			if (string.length() < min) {
				min = string.length();
				result = string;
			}
		}
		System.out.println(result);
	}

	/**
	 * Перебрать LinkedList<Integer> и вычислить произведение всех элементов.
	 * 
	 * @param list
	 */
	static void task42(List<Integer> list) {
		int result = 1;
		for (Integer integer : list) {
			result *= integer;
		}
		System.out.println(result);
	}

	/**
	 * Перебрать ArrayList<Integer> и найти сумму квадратов всех элементов.
	 * 
	 * @param list
	 */
	static void task41(List<Integer> list) {
		int result = 0;
		for (Integer integer : list) {
			result += Math.pow(integer, 2);
		}

		System.out.println(result);
	}

}

record Cat(String name, int age) {}

class AgeComparator implements Comparator<Cat> {
	@Override
	public int compare(Cat o1, Cat o2) {
		return o2.age() - o1.age();
	}
}
