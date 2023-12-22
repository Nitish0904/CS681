package edu.umb.cs681.hw8;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;


public class FileSystem {
	private static ReentrantLock lock = new ReentrantLock();

    private static FileSystem thisInstance;
    LinkedList<Directory> rds = new LinkedList<>();


    public static FileSystem getFileSystem(){
    	lock.lock();
    	try {
	        if(thisInstance == null) {
	            thisInstance = new FileSystem();
	        }
	        return thisInstance;
	    }
    	finally {
    		lock.unlock();
    	}
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rds;
    }

    public void appendRootDir(Directory d){
        this.rds.add(d);
    }
}