package com.nosetr._20230916;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Уровень сложности 9 из 10:
 * 
 * Перебрать ArrayList<Integer> и найти второй по величине элемент.
 * 
 * Перебрать LinkedList<Integer> и вывести все элементы в обратном порядке.
 * 
 * Перебрать ArrayList<String> и вывести все строки, содержащие только буквы.
 * 
 * Перебрать LinkedList<String> и найти самую длинную строку, не содержащую
 * пробелов.
 * 
 * Создать ArrayList с объектами вашего собственного класса и отфильтровать
 * только уникальные элементы.
 * 
 */
public class Task5 {

	public static void main(String[] args) {
		/*
		 * Перебрать ArrayList<Integer> и найти второй по величине элемент.
		 */
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(6);
		list.add(9);
		list.add(2);
		list.add(12);
		task51(list);

		/*
		 * Перебрать LinkedList<Integer> и вывести все элементы в обратном порядке.
		 */
		List<Integer> list2 = new LinkedList<>(list);
		task52(list2);

		/*
		 * Перебрать ArrayList<String> и вывести все строки, содержащие только буквы.
		 */
		List<String> listStrings = new ArrayList<String>();
		listStrings.add("proba");
		listStrings.add("proba2");
		listStrings.add("proba225");
		listStrings.add("proba String");
		listStrings.add("notaproba8");
		task53(listStrings);

		/*
		 * Перебрать LinkedList<String> и найти самую длинную строку, не содержащую
		 * пробелов.
		 */
		List<String> listStrings2 = new LinkedList<String>(listStrings);
		task54(listStrings2);

		/*
		 * Создать ArrayList с объектами вашего собственного класса и отфильтровать
		 * только уникальные элементы.
		 */
		List<Auto> autos = new ArrayList<Auto>();
		autos.add(new Auto("BMW", 1989));
		autos.add(new Auto("MB", 1995));
		autos.add(new Auto("Opel", 1965));
		autos.add(new Auto("Toyota", 1995));
		autos.add(new Auto("Fiat", 1973));
		task55(autos);
	}

	/**
	 * Создать ArrayList с объектами вашего собственного класса и отфильтровать
	 * только уникальные элементы.
	 * 
	 * @param autos
	 */
	static void task55(List<Auto> autos) {
		List<Integer> vintageList = new ArrayList<>();
		List<Integer> toRemoveList = new ArrayList<>();
		
		for (Auto auto : autos) {
			if (!vintageList.contains(auto.vintage())) {
				vintageList.add(auto.vintage());
			} else {
				toRemoveList.add(auto.vintage());
			}
		}

		for (Integer integer : toRemoveList) {
			autos.removeIf((Auto auto) -> auto.vintage() == integer);
		}

		System.out.println(autos);
	}

	/**
	 * Перебрать LinkedList<String> и найти самую длинную строку, не содержащую
	 * пробелов.
	 * 
	 * @param list
	 */
	static void task54(List<String> list) {
		int max = Integer.MIN_VALUE;
		String result = "";
		for (String string : list) {
			if (!string.contains(" ") && string.length() > max) {
				max = string.length();
				result = string;
			}
		}
		System.out.println(result);
	}

	/**
	 * Перебрать ArrayList<String> и вывести все строки, содержащие только буквы.
	 * 
	 * @param listStrings
	 */
	static void task53(List<String> list) {
		for (String string : list) {
			char[] cArr = string.toCharArray();
			int digs = 0;
			for (char c : cArr) {
				if (Character.isDigit(c)) {
					digs++;
					break;
				}
			}
			if (digs == 0)
				System.out.println(string);
		}
	}

	/**
	 * Перебрать LinkedList<Integer> и вывести все элементы в обратном порядке.
	 * 
	 * @param list
	 */
	static void task52(List<Integer> list) {
		list.sort(new IntComparator(true));
		System.out.println(list);
	}

	/**
	 * Перебрать ArrayList<Integer> и найти второй по величине элемент.
	 * 
	 * @param list
	 */
	static void task51(List<Integer> list) {
		list.sort(new IntComparator());
		System.out.println(list.get(1));
	}

}

record Auto(String name, int vintage) {

	@Override
	public int hashCode() {
		return Objects.hash(vintage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		return vintage == other.vintage;
	}

}

class IntComparator implements Comparator<Integer> {
	boolean reverse;

	public IntComparator() {
		this.reverse = false;
	}

	public IntComparator(boolean reverse) {
		this.reverse = reverse;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		int result = (!reverse) ? o1 - o2 : o2 - o1;
		return result;
	}

}
