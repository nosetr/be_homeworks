package com.nosetr._20231123;

class MyPrinter {
	private static final Object lock = new Object();
	private static int currentThread = 0;

	public void printLetter(String letter, int times, int threadId) {
		for (int i = 0; i < times; i++) {
			synchronized (this) {
				System.out.print(letter);
				
			}

			
//			synchronized (lock) {
//				// Проверяем, принадлежит ли поток текущей букве
//				while (currentThread != threadId) {
//					try {
//						lock.wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//
//				System.out.print(letter);
//
//				// Переключаемся на следующий поток
//				currentThread = (currentThread % 3) + 1;
//				lock.notifyAll();
//			}
		}
	}
}
