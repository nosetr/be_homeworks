package com.nosetr._20231122;

/**
 * Задание 1: Многопоточная Сортировка Массива
 * Цель задания: Написать многопоточное приложение на Java для сортировки
 * массива целых чисел.
 * Описание задания:
 * Создайте класс MultithreadedArraySorter с массивом целых чисел.
 * Реализуйте метод sort(), который будет разделять массив
 * на подмассивы и сортировать их в отдельных потоках с помощью пула потоков
 * newFixedThreadPool.
 */
public class Task1 {
	
	public static void main(String[] args) {
		int[] array = { 64, 34, 25, 12, 22, 11, 90 };

		System.out.println("Исходный массив:");
		printArray(array);

		bubbleSort(array);

		System.out.println("\nОтсортированный массив:");
		printArray(array);
	}

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// меняем элементы местами
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}
