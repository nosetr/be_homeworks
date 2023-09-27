package com.nosetr._20230927.task3.dao;

import java.util.List;
import java.util.UUID;

/**
 * userId (): Уникальный идентификатор пользователя библиотеки.
 * 
 * userName (): Имя пользователя.
 * 
 * userEmail (): Электронная почта пользователя.
 * 
 * userPhone (): Номер телефона пользователя.
 * 
 * userBooksBorrowed (): Список книг, взятых пользователем в аренду.
 * 
 * userBooksReserved (): Множество книг, зарезервированных пользователем.
 */
public record LibraryUser(UUID userId, String userName, String userEmail, String userPhone, List<Book> userBooksBorrowed,
		List<Book> userBooksReserved) {

}
