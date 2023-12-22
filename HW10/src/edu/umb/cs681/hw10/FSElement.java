package edu.umb.cs681.hw10;


import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private static ReentrantLock lock = new ReentrantLock();


    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent(){
        return this.parent;
    }
    public String getName(){
        return this.name;
    }
    public int getSize(){
        return this.size;
    }
    public LocalDateTime getCreationTime(){
        return this.creationTime;
    }
    
    public ReentrantLock getLock() {
        return this.lock;
    }

    public abstract boolean isDirectory();
    public abstract boolean isFile();
    public abstract boolean isLink();
}
