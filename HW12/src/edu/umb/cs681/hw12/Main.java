package edu.umb.cs681.hw12;

public class Main {
	public static void main(String[] args) {

		ThreadSafeBankAccount2 bankAccount = new ThreadSafeBankAccount2();
		
		WithdrawRunnable wR1 = new WithdrawRunnable(bankAccount);
		
		WithdrawRunnable wR2 = new WithdrawRunnable(bankAccount);
		
		WithdrawRunnable wR3 = new WithdrawRunnable(bankAccount);
		
		WithdrawRunnable wR4 = new WithdrawRunnable(bankAccount);


		DepositRunnable dR1 = new DepositRunnable(bankAccount);

		DepositRunnable dR2 = new DepositRunnable(bankAccount);
		
		DepositRunnable dR3 = new DepositRunnable(bankAccount);
		
		DepositRunnable dR4 = new DepositRunnable(bankAccount);

		
		
		

		Thread t1 = new Thread(dR1);
		
		Thread t2 = new Thread(dR2);
		
		Thread t3 = new Thread(dR3);
		
		Thread t4 = new Thread(dR4);
		
		Thread t5 = new Thread(wR1);
		
		Thread t6 = new Thread(wR2);
		
		Thread t7 = new Thread(wR3);
		
		Thread t8 = new Thread(wR4);
		


		t1.start();
		
		t2.start();
		
		t3.start();
		
		t4.start();
		
		t5.start();
		
		t6.start();

		t7.start();
		
		t8.start();
		

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			
			e1.toString();
		}

		dR1.setDone();
		
		dR2.setDone();
		
		dR3.setDone();
		
		dR4.setDone();
		
		wR1.setDone();
		
		wR2.setDone();
		
		wR3.setDone();
		
		wR4.setDone();

		
		t1.interrupt();
		
		t2.interrupt();
		
		t3.interrupt();
		
		t4.interrupt();
		
		t5.interrupt();
		
		t6.interrupt();
		
		t7.interrupt();
		
		t8.interrupt();

	}

}
