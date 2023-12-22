package edu.umb.cs681.hw17;

import java.util.ArrayList;
import java.util.List;

public class Main implements java.lang.Runnable {

	public void update(Observable sender, StockEvent event) {
		// TODO Auto-generated method stub
		
	}
	private volatile boolean done = false;
	public void setDone() {
		
		done = true;
	
		}
	


	public void Runnable() {
		while (true) {
			try {
				if (done) {
					System.out.println("Interrupted" + Thread.currentThread().getId());
					break;
				}
				StockQuoteObservable obj = new StockQuoteObservable();
				
				Linechartobserver L1 = new Linechartobserver();
				obj.addObserver(L1);
				
				obj.ChangeQuote("Goldman Sachs", 45000.0);
//				obj.removeObserver(L1);
				obj.ChangeQuote("JP Morgan", 30000.0);

			}
			finally {
				System.out.println("#Thread finished#");
			}
		}
	}
	
	public void run() {
		Runnable();
	}
	
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		List<Main> handlers = new ArrayList<>();

		for (int i = 0; i < 15; i++) {
			Main handler = new Main();
			handlers.add(handler);
			
			Thread thread = new Thread(handler);
			
			threads.add(thread);
			thread.start();
			
			System.out.println("Thread #" + thread.getName());
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (Main handler : handlers) {
			handler.setDone();
		}

		for (Thread thread : threads) {
			thread.interrupt();
		}

	}
	

}
