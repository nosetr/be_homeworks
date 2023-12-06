package com.nosetr._20231206.taski;

import java.util.List;

public class D1 {

    public double calculateAverageValueForGivenList(List<Double> listOfNumbers) {
        double sumOfAllValues = 0;
        for (double currentValue : listOfNumbers) {
            sumOfAllValues += currentValue;
        }
        return sumOfAllValues / listOfNumbers.size();
    }
}

/**
 * My solution:
 */
class D1My {

    public double calculateAverageValueForGivenList(List<Double> list) {
    	return list.stream()
          .mapToDouble(Double::doubleValue)
          .average()
          .orElse(0.0);
    }
}