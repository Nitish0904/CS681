package edu.umb.cs681.hw13.original;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
	private Map<String, String> userProfile=new HashMap<>();
	public static volatile Database instance;
//	private boolean done=false;
    private Database() {
//        this.userProfile = new HashMap<>();
    }

    public void updateProfile(String userId, String newInfo) {
        // Simulate some processing time for updating the database
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.toString();
        }

        // Race condition: Multiple threads may interfere with database updates
        userProfile.put(userId, newInfo);
        System.out.println("Updated profile for user: " + userId);
    }

    public String getProfile(String userId) {
        return userProfile.get(userId);
    }
    
    public static Database getInstance() {

		if (instance == null) {
			instance = new Database();
		}

		return instance;
	}
}