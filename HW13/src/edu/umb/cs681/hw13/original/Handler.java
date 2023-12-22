package edu.umb.cs681.hw13.original;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Handler implements Runnable {
	private volatile boolean done = false;
	private final Lock lock = new ReentrantLock();
	private final String[] users = { "User 1", "User 2", "User 3" };
	private final Random random = new Random();
	
	public void run() {
		while(true) {
			if(done) {
				break;
			}
			
//			Integer users=random.nextInt(users.length());
			String user = users[random.nextInt(users.length)];
			
//			creating users
			
//			for(int i=0;i<10;i++) {
//			Database obj=new Database();
			Database obj=Database.getInstance();
			obj.updateProfile(user,": UserInfo_Updated");
			System.out.println(user +  obj.getProfile(user));
			
//			}
		}
	}

	public void setDone() {
		// TODO Auto-generated method stub
		done=true;
		
	}
	
}
