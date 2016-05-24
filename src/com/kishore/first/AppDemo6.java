package com.kishore.first;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CountProcessor implements Runnable {

	private CountDownLatch latch;

	public CountProcessor(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.println("Started...");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		latch.countDown();
	}
}

public class AppDemo6 {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(100);
		
		for(int i = 0; i < 101; i++){
		executor.submit(new CountProcessor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Completed.");
	}

}
