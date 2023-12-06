package com.nosetr._20231206.taski;

import java.util.List;

public class DAta {
	public double calculateAverage(List<Double> numbers) {
		double sum = 0;
		for (double num : numbers) {
			sum += num;
		}

		double average = sum / numbers.size();

		double variance = 0;
		for (double num : numbers) {
			variance += Math.pow(num - average, 2);
		}
		double standardDeviation = Math.sqrt(variance / numbers.size());

		return standardDeviation;
	}
}

/**
 * My solution:
 */
class DAtaMy {
	public double calculateAverage(List<Double> numbers) {
		int size = numbers.size();
		double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();

		double average = sum / size;

		double variance = numbers.stream().mapToDouble(num -> Math.pow(num - average, 2)).sum();
		double standardDeviation = Math.sqrt(variance / size);

		return standardDeviation;
	}
}
