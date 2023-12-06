package com.nosetr._20231206.taski;

import java.util.List;

public class DA {

	public void processData(List<Integer> data) {
		int sum = 0;
		for (int num : data) {
			sum += num;
		}
		System.out.println("Sum: " + sum);

		double average = (double) sum / data.size();
		System.out.println("Average: " + average);
	}

	public void processUserData(List<User> users) {
		int totalAge = 0;
		for (User user : users) {
			// totalAge += user.getAge();
		}
		System.out.println("Total Age: " + totalAge);

		double averageAge = (double) totalAge / users.size();
		System.out.println("Average Age: " + averageAge);
	}
}

/**
 * My solution:
 */
class DAMy {

	public void processData(List<Integer> data) {
		int sum = data.stream().mapToInt(Integer::intValue).sum();
		System.out.println("Sum: " + sum);

		double average = (double) sum / data.size();
		System.out.println("Average: " + average);
	}

	public void processUserData(List<User> users) {
		int totalAge = users.stream().mapToInt(User::age).sum();
		System.out.println("Total Age: " + totalAge);

		double averageAge = (double) totalAge / users.size();
		System.out.println("Average Age: " + averageAge);
	}
}

record User(int age) {}
