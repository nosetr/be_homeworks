package com.nosetr._20230927.casino.roulette;

import java.util.Random;
import java.util.Scanner;

public class Main {
	private final static Scanner SCANNER = new Scanner(System.in);

	private final static Random RANDOM = new Random();

	private static int BUDGET;

	public static void main(String[] args) {

		System.out.println("введите ваш бюджет: ");
		BUDGET = SCANNER.nextInt();

		while (BUDGET > 0) {
			int bit = makeBit();
			int num = putOnNumbers();
			System.out.println("Ставки сделаны. Ставки больше не принимаются...");

			spinRoulette(bit, num);
		}

		theEnd();
	}

	static void spinRoulette(int bit, int num) {
		int rand = RANDOM.nextInt(0, 37);
		System.out.println("выпало число " + rand + " " + getColor(rand));
		if (rand == num) {
			int win = bit * 35;
			BUDGET += win;
			System.out.println("ваш выигрыш составил " + win);
		} else {
			BUDGET -= bit;
			System.out.println("совпадений нет");
		}
		System.out.println("ваш бюджет: " + BUDGET);
	}

	public static String getColor(int number) {
		if (number == 0) {
			return "зеленый";
		} else if ((number >= 1 && number <= 10) || (number >= 19 && number <= 28)) {
			// Эти номера красные
			return "красный";
		} else {
			// Остальные номера черные
			return "черный";
		}
	}

	static int putOnNumbers() {
		int result = -1;
		while (result == -1) {
			System.out.println("на какое число делаете ставку?");
			int bit = SCANNER.nextInt();
			if (bit >= 0 && bit <= 36)
				result = bit;
			else
				System.out.println("число не корректно");
		}
		return result;
	}

	static int makeBit() {
		int result = 0;
		while (result == 0) {
			System.out.println("введите вашу ставку: ");
			int bit = SCANNER.nextInt();
			if (bit > 0 && bit <= BUDGET)
				result = bit;
			else
				System.out.println("ставка не корректна");
		}
		return result;
	}

	static void theEnd() {
		System.out.println("Вы проигрались в пух и прах...");
		SCANNER.close();
		return;
	}

}
