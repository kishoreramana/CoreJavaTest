package com.kishore.first;

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Hello I am running!!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		running = false;
	}
}

public class AppDemo2 {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();

		System.out.println("Press new line to stop the thread running!!");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();

		proc1.shutDown();
	}

}
