package com.nosetr._20230927.task3;

import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;
import com.nosetr._20230927.task3.dao.Book;
import com.nosetr._20230927.task3.service.LibraryManager;

public class Main {

	public static void main(String[] args) {
		Faker faker = new Faker(Locale.GERMANY);
		
		LibraryManager manager = new LibraryManager();
		List<Book> avBook = manager.listAvailableBooksByGenre(faker.book().genre());
		System.out.println(avBook);
		
		
	}

}
