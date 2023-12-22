package edu.umb.cs681.hw13.original;
import java.util.ArrayList;
import java.util.List;
//import edu.umb.cs681.hw13.*;

public class Main {
	public static void main(String[] args) throws InterruptedException {
       
        List<Thread> threadStorage = new ArrayList<>();
        
        List<Handler> handlers = new ArrayList<>();
        
        
        for (int i = 0; i < 10; i++) {
            Handler handler = new Handler();
            handlers.add(handler);
            Thread thread = new Thread(handler);
            threadStorage.add(thread);
            thread.start();
        }
        
        Thread.sleep(5000);
        for (Handler handler : handlers) {
            handler.setDone();
        }
        for (Thread thread : threadStorage) {
                thread.interrupt();
        }
    }
		
		       

//        Database userProfileDatabase = new Database();
//
//        // Simulate multiple users updating their profiles concurrently
//        for (int i = 0; i < 10; i++) {
//            final int userId = i;
//            new Thread(() -> {
//                String newInfo = "UpdatedInfo" + userId;
//                userProfileDatabase.updateProfile("User" + userId, newInfo);
//            }).start();
//        }
//
//        // Wait for all threadStorage to finish
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.toString();
//        }
//
//        // Print User profiles
//        System.out.println("User Profiles After Updation :");
//        for (int i = 0; i < 10; i++) {
//            String userId = "User" + i;
//            System.out.println(userId + ": " + userProfileDatabase.getProfile(userId));
//        }
    
}
