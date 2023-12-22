package edu.umb.cs681.hw13.revised;

import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
    	 List<Thread> threadStorage = new ArrayList<>();
         
         List<Handler> handlers = new ArrayList<>();
         
         
         for (int i = 0; i < 10; i++) {
             Handler handler = new Handler();
             handlers.add(handler);
             Thread thread = new Thread(handler);
             threadStorage.add(thread);
             thread.start();
         }
         
         try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.toString();
		}
         for (Handler handler : handlers) {
        	 System.out.println("terminated thread");
             handler.setDone();
         }
         for (Thread thread : threadStorage) {
        	 System.out.println("terminated thread ###");
                 thread.interrupt();
         }
    	

    }
}
