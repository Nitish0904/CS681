package edu.umb.cs681.hw8;
import java.util.ArrayList;



public class FileSystemTest {
    public static void main(String[] args) {
        int threadCnt = 10;
        Thread[] threads = new Thread[threadCnt];
//        ArrayList<Thread> threads = new ArrayList<>();
//        int thread;
        
        System.out.println("Threads Running...");
        System.out.println("\n");

        for (int i = 0; i < threadCnt; i++) {
//        	final int threadNumber = i;
//        	Thread thread=threads.get(i);
//        	long name=threads[i].getId();
        	threads[i] = new Thread(() -> {
                FileSystem fs = FileSystem.getFileSystem();
//                System.out.println("Thread "+threadNumber);
                System.out.println("Instance ID: " + fs.hashCode());
            });
        	threads[i].start();
        }

        for (int i = 0; i < threadCnt; i++) {
//        	Thread thread=threads.get(i);
            try {
            	threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\n");

        
        System.out.println("All threads have accessed the same Instance");
    }
}
