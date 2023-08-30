package com.nosetr.hw_1;

public class Main {

	public static void main(String[] args) {
		Main thisMain = new Main();

		int[] arr = { -6, 15, 7, 0, 33 };

		System.out.println(thisMain.getAverageInt(arr));
		System.out.println(thisMain.getSum(arr));
		System.out.println(thisMain.getMaxInt(arr));
	}

	/**
	 * Найти в массиве наибольшую сумму подряд идущих элементов.
	 * 
	 * @param arr
	 * @return
	 */
	int getMaxInt(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int i : arr) {
			if (i > max)
				max = i;
		}

		return max;
	}

	/**
	 * Найти сумму всех элементов в массиве, которые делятся на 3 и одновременно не
	 * делятся на 5.
	 * 
	 * @param arr
	 * @return
	 */
	int getSum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			if (i % 3 == 0 && i % 5 != 0)
				sum += i;
		}
		return sum;
	}

	/**
	 * Найти среднее арифметическое положительных элементов массива.
	 * 
	 * @param arr
	 * @return
	 */
	int getAverageInt(int[] arr) {
		int sum = 0;
		int k = 0;
		for (int i : arr) {
			if (i > 0) {
				sum += i;
				k++;
			}
		}
		return sum / k;
	}

}
