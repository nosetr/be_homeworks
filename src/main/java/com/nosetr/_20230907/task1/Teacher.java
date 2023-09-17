package com.nosetr._20230907.task1;

import java.util.Random;

import com.nosetr._20230907.task1.enums.Grade;

public class Teacher extends Person {

	Grade teacherGrade;

	public Grade gradeStudent() {
		Random random = new Random();
		Grade[] grade = Grade.values();
		int i = random.nextInt(grade.length);
		return grade[i];
	}

	@Override
	public String getDescription() { return "Name: " + this.name + " Age: " + this.age; }

}
