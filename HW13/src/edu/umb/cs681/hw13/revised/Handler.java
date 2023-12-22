package edu.umb.cs681.hw13.revised;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Handler implements Runnable {
    private volatile boolean done = false;
	private final Lock lock = new ReentrantLock();
	public void run() {
	
		final String[] users = { "User 1", "User 2", "User 3" };
	    Random random = new Random();
			while(true) {
				if(done) {
					break;
				}
				
//				Integer users=random.nextInt(users.length());
				String user = users[random.nextInt(users.length)];
				
//				creating users
				
//				for(int i=0;i<10;i++) {
				Database obj=Database.getInstance();
				obj.updateProfile(user,": UserInfo_Updated");
				System.out.println(user +  obj.getProfile(user));
				
//				}
			}

		
	}
	
	public void setDone() {
		// TODO Auto-generated method stub
		lock.lock();
		try {
			done=true;
		}
		finally {
			lock.unlock();
		}
	}
}
