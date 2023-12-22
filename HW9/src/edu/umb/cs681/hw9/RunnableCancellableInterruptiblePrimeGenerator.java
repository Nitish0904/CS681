package edu.umb.cs681.hw9;

import java.util.concurrent.locks.ReentrantLock;


public class RunnableCancellableInterruptiblePrimeGenerator extends RunnableCancellablePrimeGenerator{
	
	private boolean done = false;
	private final ReentrantLock lock = new ReentrantLock();
	
	public RunnableCancellableInterruptiblePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void generatePrimes(){
		for (long n = from; n <= to; n++) {
			lock.lock();
			try {
				// Stop generating prime numbers if done==true
				if(done){
					System.out.println("Stopped generating prime numbers.");
					this.primes.clear();
					break;
				}		
				if( isPrime(n) ){
					this.primes.add(n);
					System.out.println(n);
				}
			}finally {
				lock.unlock();
			}
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}

	public void setDone() {
		done = true; // Step 1: Set the flag to signal thread to stop
	}

	public static void main(String[] args) {
		RunnableCancellableInterruptiblePrimeGenerator gen = new RunnableCancellableInterruptiblePrimeGenerator(1,100);
		Thread thread = new Thread(gen);
		thread.start();
		gen.setDone(); // Step 1: Set the flag to signal thread to stop
		try {
			thread.join(); // Step 2: Wait for the thread to terminate
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		gen.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
		System.out.println("\n" + gen.getPrimes().size() + " prime numbers are found.");
	}

}
