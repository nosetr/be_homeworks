package com.nosetr._20231025;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;

import lombok.Data;

public class Main {	
	public static void main(String[] args) {
		/*****
		 * Задание 1. Сериализация списка студентов
		 * Описание: Создайте класс Student с полями name
		 * (имя студента), age (возраст) и grade (оценка).
		 * Реализуйте сериализацию и десериализацию списка студентов.
		 * Требования:
		 * Используйте потоки для обработки данных.
		 **/
		String fileString = "students.ser";
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(new Student());
		}
		/*
		 * Реализуйте метод saveStudentsToFile(List<Student> students, String filename),
		 * который будет сохранять список студентов в файл.
		 */
		saveStudentsToFile(list, fileString);

		/*
		 * Реализуйте метод List<Student> loadStudentsFromFile(String filename), который
		 * будет читать студентов из файла.
		 */
		list = loadStudentsFromFile(fileString);
		System.out.println(list);

		/*****
		 * Задание 2. Фильтрация студентов по оценке
		 * Описание: Добавьте функционал, который позволит фильтровать студентов с
		 * оценкой выше определенного значения и сохранять их в отдельный файл.
		 * Требования:
		 * Реализуйте метод filterAndSaveStudentsByGrade(List<Student> students, double
		 * gradeThreshold, String filename), который будет сохранять студентов с оценкой
		 * выше gradeThreshold в файл.
		 */
		String fileFilterString = "students_filterd.ser";
		filterAndSaveStudentsByGrade(list, 0.5, fileFilterString);
		System.out.println(loadStudentsFromFile(fileFilterString));

		/*
		 * Задание 3. Средний балл студентов
		 * Описание: Напишите метод, который вычисляет средний балл всех студентов из
		 * файла.
		 * Требования:
		 * Реализуйте метод double calculateAverageGrade(String filename), который
		 * возвращает средний балл студентов.
		 */
		System.out.println(calculateAverageGrade(fileString));
	}

	/*
	 * Реализуйте метод double calculateAverageGrade(String filename), который
	 * возвращает средний балл студентов.
	 */
	static double calculateAverageGrade(String fileString) {
		List<Student> list = loadStudentsFromFile(fileString);
		double result = list.stream().mapToDouble(e -> e.getGrade()).average().getAsDouble();
		return result;
	}

	/**
	 * Реализуйте метод filterAndSaveStudentsByGrade(List<Student> students,
	 * double
	 * gradeThreshold, String filename), который будет сохранять студентов с оценкой
	 * выше gradeThreshold в файл.
	 * 
	 * @param list
	 * @param d
	 * @param fileFilterString
	 */
	static void filterAndSaveStudentsByGrade(List<Student> list, double d, String fileFilterString) {
		List<Student> newList = list.stream().filter(e -> e.getGrade() > d).toList();
		saveStudentsToFile(newList, fileFilterString);
	}

	/**
	 * Реализуйте метод saveStudentsToFile(List<Student> students, String filename),
	 * который будет сохранять список студентов в файл.
	 * 
	 * @param students
	 * @param filename
	 */
	static void saveStudentsToFile(List<Student> students, String filename) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(students);
			System.out.println("Save students was done");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Реализуйте метод List<Student> loadStudentsFromFile(String filename), который
	 * будет читать студентов из файла.
	 * 
	 * @param filename
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static List<Student> loadStudentsFromFile(String filename) {
		List<Student> list = null;
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {
			list = (List<Student>) input.readObject();
			System.out.println("Load students was done");

		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}

/**
 * Описание: Создайте класс Student с полями name
 * (имя студента), age (возраст) и grade (оценка).
 */
@Data
class Student implements Serializable {
	private static final Random RANDOM = new Random();
	private static final Faker FAKER = new Faker();
	private static final long serialVersionUID = -2936687026040726549L;
	private String name;
	private int age;
	private double grade;

	public Student() {
		this.setName(FAKER.name().name());
		this.setAge(RANDOM.nextInt(18, 45));
		double grade = new BigDecimal(String.valueOf(RANDOM.nextDouble(0, 1.01))).setScale(2, RoundingMode.HALF_UP)
				.doubleValue();
		this.setGrade(grade);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]\n";
	}

}
