package org.example._2023_12_06.taski.dryKissYagni;

public class Calc {
	public double calculateArea(int shapeType, double... params) {
		if (shapeType == 1) { // 1.txt - круг
			double radius = params[0];
			return Math.PI * radius * radius;
		} else if (shapeType == 2) { // 2 - квадрат
			double side = params[0];
			return side * side;
		} else if (shapeType == 3) { // 3 - треугольник
			double a = params[0];
			double b = params[1];
			double c = params[2];
			double s = (a + b + c) / 2;
			return Math.sqrt(s * (s - a) * (s - b) * (s - c));
		}
		return 0.0;
	}
}

class CalcMy {
	public double calculateArea(int shapeType, double... params) {
		return switch (shapeType) {
			case 1 -> {
				double radius = params[0];
				yield Math.PI * radius * radius;
			}
			case 2 -> {
				double side = params[0];
				yield side * side;
			}
			case 3 -> extracted(params);
			default -> 0.0;
		};
	}

	private double extracted(double... params) {
		double a = params[0];
		double b = params[1];
		double c = params[2];
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}
}
