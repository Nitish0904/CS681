package edu.umb.cs681.hw12;
import java.util.concurrent.locks.ReentrantLock;


public class DepositRunnable implements Runnable {
	private volatile boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	private BankAccount account;

	public DepositRunnable(ThreadSafeBankAccount2 bankAccount) {
		// TODO Auto-generated constructor stub
		this.account = bankAccount;
	}

	
	public void run() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 15; i++) {
			if (done) {
				break;
				}
			System.out.println("depositing in account [d]");
			account.deposit(50);

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
