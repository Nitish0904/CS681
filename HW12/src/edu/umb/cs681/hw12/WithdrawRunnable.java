package edu.umb.cs681.hw12;
import java.util.concurrent.locks.ReentrantLock;


public class WithdrawRunnable implements Runnable {
	private ReentrantLock lock = new ReentrantLock();
	private BankAccount account;
	private volatile boolean done = false;
	
	

	public WithdrawRunnable(ThreadSafeBankAccount2 bankAccount) {
		// TODO Auto-generated constructor stub
		this.account = bankAccount;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 15; i++) {
			if (done) {
				break;
				}
			System.out.println("withdrawing from account [w]");
			account.withdraw(50);
		}
		
	}

	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}




}

