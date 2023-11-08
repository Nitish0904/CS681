package edu.umb.cs681.hw06;

public class Runnable {
	public static void main(String[] args) throws InterruptedException {
		//creating thread for Data1()		
		DP_1 obj1=new DP_1();
		//creating thread for Data2()
		DP_2 obj2=new DP_2();
		//creating thread for Data3()
		DP_3 obj3=new DP_3();
//		Thread t1 = new Thread(obj1);
		//creating a thread instance
		Thread t1=new Thread(()->{obj1.Data1();});
		System.out.println("Starting Thread 1...");
		t1.start();
		try {
			t1.join();
			System.out.println("Thread 1 Terminated");
		} catch (Exception ex) {
			System.out.println("Cannot Process Data");}

		
		Thread t2=new Thread(()->{obj2.Data2();});
		System.out.println("Starting Thread 2...");
		t2.start();
		try {
			t2.join();
			System.out.println("Thread 2 Terminated");
		} catch (Exception ex) {
			System.out.println("Cannot Process Data");}
		
		
		Thread t3=new Thread(()->{obj3.Data3();});
		System.out.println("Starting Thread 3...");
		t3.start();
		try {
			t3.join();
			System.out.println("Thread 3 Terminated");
		} catch (Exception ex) {
			System.out.println("Cannot Process Data");}
		
		System.out.println("\n");
		System.out.println("Finished executing sub-threads of Main thread");
		
	
		
	}
}
