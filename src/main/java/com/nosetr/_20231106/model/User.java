package com.nosetr._20231106.model;

/**
 * Задание 2: Сервис уведомлений с зависимостями
 * Бизнес логика:
 *
 * User - класс пользователя, содержащий информацию о пользователе.
 * EmailService - сервис для отправки электронной почты.
 * NotificationService - сервис для отправки уведомлений, который использует EmailService.
 */
public class User {
    private String id;
    private String email;

    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}