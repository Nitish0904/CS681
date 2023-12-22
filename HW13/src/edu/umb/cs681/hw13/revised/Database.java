package edu.umb.cs681.hw13.revised;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Database {
    private final Lock lock = new ReentrantLock();
    private Map<String, String> userProfile=new HashMap<>();
    private volatile boolean done = false;
//	@SuppressWarnings("unused")
	private static final Lock instanceLock = new ReentrantLock();
	public static volatile Database instance;


    private Database() {
//        this.userProfile = new HashMap<>();
    }

    public void updateProfile(String userId, String newInfo) {
//        while (!done) {
            lock.lock();
            try {
                // Simulate some processing time for updating the database
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.toString();
                }

                // Race condition: Multiple threads may interfere with database updates
                userProfile.put(userId, newInfo);
                System.out.println("Updated profile for user: " + userId);
            } finally {
                lock.unlock();
            }
//        }
    }

    public String getProfile(String userId) {
    	lock.lock();
    	try {
            return userProfile.get(userId);

    	}
    	finally {
    		lock.unlock();
    	}
    }
    

    
    public static  Database getInstance() {
    	instanceLock.lock();
    	
    	try {
		if (instance == null) {
			instance = new Database();
		}
		}
    	finally {
    		instanceLock.unlock();
    	}

		return instance;
	}
}

