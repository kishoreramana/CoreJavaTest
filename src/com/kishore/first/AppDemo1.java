package com.kishore.first;

class Runner implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Number : " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class AppDemo1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Processor());
		t1.start();
		Thread t2 = new Thread(new Processor());
		t2.start();
	}

}
