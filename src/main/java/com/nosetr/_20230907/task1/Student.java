package com.nosetr._20230907.task1;

import com.nosetr._20230907.task1.enums.Grade;

public class Student extends Person implements Graded {

	Grade grade;

	@Override
	public String getDescription() { return "Name: " + this.name + " Age: " + this.age; }

}
