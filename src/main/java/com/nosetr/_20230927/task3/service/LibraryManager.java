package com.nosetr._20230927.task3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nosetr._20230927.task3.dao.Book;
import com.nosetr._20230927.task3.dao.LibraryUser;

public class LibraryManager {
	private final Generator generator = new Generator();
	/**
	 * Список всех книг в библиотеке.
	 */
	private List<Book> libraryCatalog = generator.booksGen(100);
	/**
	 * Список всех зарегистрированных пользователей библиотеки.
	 */
	private List<LibraryUser> libraryUsers = generator.usersGen(20);

	/**
	 * Метод, который возвращает список доступных книг заданного жанра.
	 * 
	 * @param genre
	 * @return
	 */
	public List<Book> listAvailableBooksByGenre(String genre) {
		List<Book> resultList = new ArrayList<Book>(libraryCatalog);
		for (Iterator<Book> iterator = resultList.iterator(); iterator.hasNext();) {
			Book book = iterator.next();
			if (book.bookGenre() != genre)
				iterator.remove();
		}
		return resultList;
	}

	/**
	 * Метод, который возвращает множество адресов электронной почты пользователей,
	 * зарезервировавших книги.
	 * 
	 * @return
	 */
	public List<String> listUserEmailsWithReservedBooks() {
		List<String> emailList = new ArrayList<String>();
		for (Iterator<LibraryUser> iterator = libraryUsers.iterator(); iterator.hasNext();) {
			LibraryUser user = iterator.next();
			if (user.userBooksReserved() != null)
				emailList.add(user.userEmail());
		}
		return emailList;
	}

	/**
	 * Метод, который добавляет новую книгу в библиотеку.
	 * 
	 * @param book
	 */
	public void addBookToLibrary(Book book) {
		libraryCatalog.add(book);
	}

	/**
	 * Метод, который удаляет книгу из библиотеки.
	 * 
	 * @param book
	 */
	public void removeBookFromLibrary(Book book) {
		for (Iterator<Book> iterator = libraryCatalog.iterator(); iterator.hasNext();) {
			Book book1 = iterator.next();
			if (book1 == book)
				iterator.remove();
		}
	}

	/**
	 * Метод, который позволяет пользователю взять книгу в аренду.
	 * 
	 * @param user
	 * @param book
	 */
	public void borrowBook(LibraryUser user, Book book) {
		user.userBooksBorrowed().add(book);
	}

	/**
	 * Метод, который позволяет пользователю зарезервировать книгу.
	 * 
	 * @param user
	 * @param book
	 */
	public void reserveBook(LibraryUser user, Book book) {
		user.userBooksReserved().add(book);
	}
}
