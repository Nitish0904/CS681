package edu.umb.cs681.hw10;

import java.lang.annotation.Target;
import java.time.LocalDateTime;

public class Link extends FSElement{
    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);


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
            return false;
        } 
        finally {
            getLock().unlock();
        }
    }

    @Override
    public boolean isLink() {
        getLock().lock();
        try {
            return true;
        } finally {
            getLock().unlock();
        }
    }

}