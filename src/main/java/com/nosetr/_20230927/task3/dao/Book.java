package com.nosetr._20230927.task3.dao;

import java.util.UUID;

/**
 * bookId (): Уникальный идентификатор книги.
 * 
 * bookTitle (): Название книги.
 * 
 * bookAuthor (): Автор книги.
 * 
 * bookGenre (): Жанр книги.
 * 
 * bookYear (): Год издания книги.
 * 
 * bookAvailable (): Доступность книги (true - доступна, false - не доступна).
 */
public record Book(UUID bookId, String bookTitle, String bookAuthor, String bookGenre, int bookYear,
		boolean bookAvailable) {

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookGenre="
				+ bookGenre + ", bookYear=" + bookYear + ", bookAvailable=" + bookAvailable + "]\n";
	}

	
}
