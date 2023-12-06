package com.nosetr._20231206.taski;

public class Shape {
	public enum Type {
		CIRCLE,
		SQUARE
	}

	private Type type;

	public Shape(Type type) {
		this.type = type;
	}

	public double calculateArea() {
		if (type == Type.CIRCLE) {
			// Вычисление площади круга
		} else if (type == Type.SQUARE) {
			// Вычисление площади квадрата
		}
		return 0.0;
	}
}


/**
 * My solution:
 */
class ShapeMy {
	private Type type;

	public ShapeMy(Type type) {
		this.type = type;
	}

	public double calculateArea() {
		if (type == Type.CIRCLE) {
			// Вычисление площади круга
		} else if (type == Type.SQUARE) {
			// Вычисление площади квадрата
		}
		return 0.0;
	}
}

enum Type {
	CIRCLE,
	SQUARE
}