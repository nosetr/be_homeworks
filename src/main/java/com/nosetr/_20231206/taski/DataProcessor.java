package com.nosetr._20231206.taski;

import java.util.List;

// Нарушение DRY: Дублирование кода
public class DataProcessor {
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
            //00.totalAge += user.getAge();
        }
        System.out.println("Total Age: " + totalAge);

        double averageAge = (double) totalAge / users.size();
        System.out.println("Average Age: " + averageAge);
    }
}

/**
 * My solution:
 */
class DataProcessorMy {
    public void processData(List<Integer> data) {
        int sum = data.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + getAvg(data.size(), sum));
    }

    public void processUserData(List<User> users) {
        int totalAge = users.stream().mapToInt(User::age).sum();
        System.out.println("Total Age: " + totalAge);
        System.out.println("Average Age: " + getAvg(users.size(), totalAge));
    }
    
    private double getAvg(int i, int sum) {
    	double average = (double) sum / i;
    	return average;
    }
}

