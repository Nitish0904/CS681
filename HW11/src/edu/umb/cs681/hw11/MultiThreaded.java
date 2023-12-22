package edu.umb.cs681.hw11;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import edu.umb.cs681.hw11.util.*;

public class MultiThreaded {
	private volatile boolean done = false;
    private List<File> identifiedFiles = new ArrayList<>();
    
    static LinkedList<File> sharedList = new LinkedList<>();
    
    final List<FileCrawlingVisitor> threadLocal = new ArrayList<>();


    public static void main(String[] args) {
        MultiThreaded obj = new MultiThreaded();
        obj.startCrawlingThreads();
        obj.setDone();
        obj.terminateCrawlingThreads();
    }
    
    private void setDone() {
    	done=true;
    }

    private void startCrawlingThreads() {
//    	int count=4;
        Thread thread1 = new Thread(() -> crawlTree(new FileCrawlingVisitor()));
        System.out.println("Starting Thread 0...");
    	thread1.start();
        Thread thread2 = new Thread(() -> crawlTree(new FileCrawlingVisitor()));
        System.out.println("Starting Thread 1...");
        thread2.start();
        Thread thread3 = new Thread(() -> crawlTree(new FileCrawlingVisitor()));
        System.out.println("Starting Thread 2...");
        thread3.start();
        Thread thread4 = new Thread(() -> crawlTree(new FileCrawlingVisitor()));
        System.out.println("Starting Thread 3...");
        thread4.start();
        
//        for(int i=0;i<count;i++) {
//        	System.out.println("Starting Thread 1...");
//        	thread1.start();
//        	System.out.println("Starting Thread 2...");
//            thread2.start();
//            System.out.println("Starting Thread 3...");
//            thread3.start();
//            thread4.start();
//        }
        
    }

    private void crawlTree(FileCrawlingVisitor visitor) {
//    	System.out.println(thread.curentthread.getName());
        System.out.println("Thread Crawling... " + Thread.currentThread().getName());

    	threadLocal.add(visitor);
        FileSystem flstem;
        flstem = Fixtures.nfs();
        flstem.getRootDirs().getFirst().accept(visitor);
        Directory dir1 = flstem.getRootDirs().get(3);
        Directory dir2 = flstem.getRootDirs().get(2);
        
//        LinkedList<File> sharedList = new LinkedList<>();
        
        sharedList.addAll(dir1.getFiles());
        sharedList.addAll(dir2.getFiles());

//        List<File> files = visitor.getFiles();
        
        
        identifiedFiles=sharedList;

        // Put identified files to the shared list
//        System.out.println("Before : "+identifiedFiles);
//        identifiedFiles=files;
//        identifiedFiles.addAll(files);
//        System.out.println("After : "+identifiedFiles);
        System.out.println("Local storage of Thread Instances : "+threadLocal);

        System.out.println("Files Visited by Thread " + Thread.currentThread().getName() + ": " + sharedList);
        // Print visited files
//        System.out.println("Files Visited by Thread: " + sharedList);
//        System.out.println("Files stored in local storage : "+files);
//        threadLocal.add(visitor);
//        FileSystem flstem;
//        flstem = Fixtures.nfs();
//        flstem.getRootDirs().getFirst().accept(visitor);
//        Directory dir=flstem.getRootDirs().get(3);
//        LinkedList<File> fls = new LinkedList<>();
//        fls.addAll(dir.getFiles());
////        .getRootDirs().get(0).getChildren().get(0).getName()
//
//        ArrayList<File> files=visitor.getFiles();
////        files.add(dir);
//        // Crawl the tree with the given visitor
//
//        identifiedFiles.addAll(files);
    }
    
//    obj.setDone();

    private void terminateCrawlingThreads() {
        if(done) 
        {
        	for (File visitor : identifiedFiles) {
        		Thread.currentThread().interrupt();
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.toString();
                }
//				Thread.currentThread().interrupt();
	        }
        
        	System.out.println("All threads Terminated...\n");
        	
        	System.out.println("Files crawled by threads : ");
        	}
        }
        
//        else {

	        // Step 2: Interrupt and wait for threads to terminate
	        
//        }

      
//        System.out.println("Files Crawled : " + identifiedFiles);
    

}
