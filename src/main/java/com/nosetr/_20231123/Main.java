package com.nosetr._20231123;

public class Main {
  public static void main(String[] args) {
      MyPrinter myPrinter = new MyPrinter();

      Thread threadA = new Thread(() -> myPrinter.printLetter("A", 5, 1));
      Thread threadB = new Thread(() -> myPrinter.printLetter("Б", 5, 2));
      Thread threadC = new Thread(() -> myPrinter.printLetter("В", 5, 3));

      // Запускаем все три потока
      threadA.start();
      threadB.start();
      threadC.start();

      try {
          // Ожидаем завершения всех потоков
          threadA.join();
          threadB.join();
          threadC.join();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      // Печатаем новую строку для читабельности вывода
      System.out.println();
  }
}

