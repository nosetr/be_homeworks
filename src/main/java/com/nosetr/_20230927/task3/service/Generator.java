package com.nosetr._20230927.task3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import com.github.javafaker.Faker;
import com.nosetr._20230927.task3.dao.Book;
import com.nosetr._20230927.task3.dao.LibraryUser;

public class Generator {
	
	private final Faker FAKER = new Faker(Locale.GERMANY);
	
	private final Random RANDOM = new Random();
	
	public List<Book> booksGen(int count) {
		List<Book> books = new ArrayList<Book>();
		com.github.javafaker.Book bookFaker = FAKER.book();
		
		for (int i = 0; i < count; i++) {
			books.add(new Book(UUID.randomUUID(),
					bookFaker.title(),
					bookFaker.author(),
					bookFaker.genre(),
					RANDOM.nextInt(1900, 2024),
					RANDOM.nextBoolean()));
		}
		return books;
	}
	
	public List<LibraryUser> usersGen(int count) {
		List<LibraryUser> users = new ArrayList<LibraryUser>();
		
		for (int i = 0; i < count; i++) {
			boolean add = users.add(new LibraryUser(UUID.randomUUID(),
					FAKER.name().fullName(), FAKER.internet().emailAddress(),
					FAKER.phoneNumber().phoneNumber(), null, null));
		}
		return users;
	}

}
