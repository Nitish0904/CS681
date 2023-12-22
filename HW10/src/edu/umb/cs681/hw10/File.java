package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;


public class File extends FSElement{
//	private final ReentrantLock lock;

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
//        this.lock=new ReentrantLock();
    }

    @Override
    public boolean isDirectory() {
    	getLock().lock();
    	try {
            return false;
        } 
    	finally {
            getLock().unlock();
        }
    }

    @Override
    public boolean isFile() {
        getLock().lock();
        try {
            return true;
        } 
        finally {
            getLock().unlock();
        }
    }

    @Override
    public boolean isLink() {
        getLock().lock();
        try {
            return false;
        } finally {
            getLock().unlock();
        }
    }
}