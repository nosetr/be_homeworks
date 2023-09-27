package com.nosetr._20230918;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Переберите все ключи и значения в HashMap и TreeMap и выведите их на экран.
 * 
 * Переберите только ключи в HashMap и TreeMap и найдите сумму их длин.
 * 
 * Переберите только значения в HashMap и TreeMap и найдите их среднее значение.
 * 
 * Переберите HashMap и найдите ключ с максимальным значением.
 * 
 * Переберите TreeMap и найдите ключ с минимальным значением.
 * 
 * Переберите HashMap и удалите все элементы с четными значениями.
 * 
 * Переберите TreeMap и удалите все элементы с ключами, начинающимися с буквы
 * 'A'.
 * 
 * Переберите TreeMap и найдите наибольший ключ, который меньше или равен
 * заданному ключу.
 ** 
 * Переберите HashMap и найдите ключ с максимальной суммой значений в его
 * вложенных HashMap: HashMap<String, HashMap<String, Integer>> nestedHashMap =
 * new HashMap<>();
 */
public class TaskiEx {
	public static void main(String[] args) {
		/*
		 * Переберите все ключи и значения в HashMap и TreeMap и выведите их на экран.
		 */
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(2, "Marta");
		hashMap.put(1, "John");
		hashMap.put(5, "Anna");
		hashMap.put(6, "John2");
		hashMap.put(4, "Ivan");
		hashMap.put(3, "Mick");
		TreeMap<Integer, String> treeMap = new TreeMap<>(hashMap);
		task1(hashMap, treeMap);

		/*
		 * Переберите только ключи в HashMap и TreeMap и найдите сумму их длин.
		 */
		task2(hashMap, treeMap);

		/*
		 * Переберите только значения в HashMap и TreeMap и найдите их среднее значение.
		 */
		task3(hashMap, treeMap);

		/*
		 * Переберите HashMap и найдите ключ с максимальным значением.
		 */
		task4(hashMap);

		/*
		 * Переберите TreeMap и найдите ключ с минимальным значением.
		 */
		task5(treeMap);

		/*
		 * Переберите HashMap и удалите все элементы с четными значениями.
		 */
		task6(hashMap);

		/*
		 * Переберите TreeMap и удалите все элементы с ключами, начинающимися с буквы
		 * 'A'.
		 */
		TreeMap<String, String> foodItemTypeMap = new TreeMap<>();
		foodItemTypeMap.put("Apple", "Fruit");
		foodItemTypeMap.put("Grape", "Fruit");
		foodItemTypeMap.put("Mango", "Fruit");
		foodItemTypeMap.put("Carrot", "Vegetable");
		foodItemTypeMap.put("Potato", "Vegetable");
		foodItemTypeMap.put("Spinach", "Vegetable");
		task7(foodItemTypeMap);

		/*
		 * Переберите TreeMap и найдите наибольший ключ, который меньше или равен
		 * заданному ключу.
		 */
		task8(foodItemTypeMap, 6);

		/*
		 * Переберите HashMap и найдите ключ с максимальной суммой значений в его
		 * вложенных HashMap: HashMap<String, HashMap<String, Integer>> nestedHashMap =
		 * new HashMap<>();
		 */
		Map<String, Integer> hashMap2 = new HashMap<>();
		hashMap2.put("one", 1);
		hashMap2.put("two", 2);
		hashMap2.put("three", 3);
		Map<String, Integer> hashMap3 = new HashMap<>();
		hashMap2.put("four", 4);
		hashMap2.put("five", 5);
		hashMap2.put("six", 6);
		Map<String, Map<String, Integer>> nestedHashMap = new HashMap<>();
		nestedHashMap.put("hashMap2", hashMap2);
		nestedHashMap.put("hashMap3", hashMap3);
		task9(nestedHashMap);
	}

	/**
	 * Переберите HashMap и найдите ключ с максимальной суммой значений в его
	 * вложенных HashMap: HashMap<String, HashMap<String, Integer>> nestedHashMap =
	 * new HashMap<>();
	 * 
	 * @param nestedHashMap
	 */
	private static void task9(Map<String, Map<String, Integer>> nestedHashMap) {
		String keyString = null;
		int sum = 0;
		for (Entry<String, Map<String, Integer>> entry : nestedHashMap.entrySet()) {
			int sum2 = 0;
			
			for (int val : entry.getValue().values()) {
				sum2 += val;
			}
			
			if(sum2 > sum) {
				sum = sum2;
				keyString = entry.getKey();
			}
		}
		System.out.println(keyString);
	}

	/**
	 * Переберите TreeMap и найдите наибольший ключ, который меньше или равен
	 * заданному ключу.
	 * 
	 * @param foodItemTypeMap
	 * @param i
	 */
	private static void task8(TreeMap<String, String> foodItemTypeMap, int i) {
		String maxString = "";
		int lng = 0;
		for (String string : foodItemTypeMap.keySet()) {
			int newLng = string.length();
			if (newLng <= i && newLng > lng) {
				maxString = string;
				lng = newLng;
			}
		}
		System.out.println(maxString);
	}

	/**
	 * Переберите TreeMap и удалите все элементы с ключами, начинающимися с буквы
	 * 'A'.
	 * 
	 * @param foodItemTypeMap
	 */
	private static void task7(TreeMap<String, String> foodItemTypeMap) {
		Iterator<Entry<String, String>> iterator = foodItemTypeMap.entrySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getKey().toLowerCase().charAt(0) == 'a')
				iterator.remove();
		}
		System.out.println(foodItemTypeMap);
	}

	/**
	 * Переберите HashMap и удалите все элементы с четными значениями.
	 * 
	 * @param hashMap
	 */
	private static void task6(HashMap<Integer, String> hashMap) {
		Iterator<Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getKey() % 2 == 0)
				iterator.remove();
		}
		System.out.println(hashMap);
	}

	/**
	 * Переберите TreeMap и найдите ключ с минимальным значением.
	 * 
	 * @param treeMap
	 */
	private static void task5(TreeMap<Integer, String> treeMap) {
		int min = Integer.MAX_VALUE;
		for (int key : treeMap.keySet()) {
			min = Math.min(min, key);
		}
		System.out.println("Task5: " + min);
	}

	/**
	 * Переберите HashMap и найдите ключ с максимальным значением.
	 * 
	 * @param hashMap
	 */
	private static void task4(HashMap<Integer, String> hashMap) {
		int max = Integer.MIN_VALUE;
		for (int key : hashMap.keySet()) {
			max = Math.max(max, key);
		}
		System.out.println("Task4: " + max);
	}

	/**
	 * Переберите только значения в HashMap и TreeMap и найдите их среднее значение.
	 * 
	 * @param hashMap
	 * @param treeMap
	 */
	private static void task3(HashMap<Integer, String> hashMap, TreeMap<Integer, String> treeMap) {
		double size = 0;
		for (String valString : hashMap.values()) {
			size += valString.length();
		}
		System.out.println("Task3/1: " + size / hashMap.size());
		size = 0;
		for (String valString : treeMap.values()) {
			size += valString.length();
		}
		System.out.println("Task3/2: " + size / hashMap.size());
	}

	/**
	 * Переберите только ключи в HashMap и TreeMap и найдите сумму их длин.
	 * 
	 * @param hashMap
	 * @param treeMap
	 */
	private static void task2(HashMap<Integer, String> hashMap, TreeMap<Integer, String> treeMap) {
		int result = 0;
		for (int key : hashMap.keySet()) {
			result += key;
		}
		for (int key : treeMap.keySet()) {
			result += key;
		}
		System.out.println("Task2: " + result);
		System.out.println(" ");
	}

	/**
	 * Переберите все ключи и значения в HashMap и TreeMap и выведите их на экран.
	 * 
	 * @param hashMap
	 * @param treeMap
	 */
	private static void task1(HashMap<Integer, String> hashMap, TreeMap<Integer, String> treeMap) {
		for (Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}

		for (Entry<Integer, String> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}
		System.out.println("End Task 1.");
		System.out.println(" ");
	}
}
