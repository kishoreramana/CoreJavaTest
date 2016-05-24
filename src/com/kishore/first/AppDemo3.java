package com.kishore.first;

public class AppDemo3 {

	private volatile int count = 0;

	public synchronized void increment() {
		count++;
	}

	public static void main(String... strings) {
		AppDemo3 app = new AppDemo3();
		app.doWork();
	}

	public void doWork() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Executing t1...");
				for (int i = 0; i < 10000; i++) {
					increment();
				}
				System.out.println("Completed t1.");
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Executing t2...");
				for (int i = 0; i < 10000; i++) {
					increment();
				}
				System.out.println("Completed t2.");
			}

		});

		try {
			
			t2.start();
			t2.join();
			t1.start();
			t1.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Counter : " + count);
	}
}