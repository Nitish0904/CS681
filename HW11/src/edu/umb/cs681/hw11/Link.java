package edu.umb.cs681.hw11;
import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class Link extends FSElement{
    private final ReentrantLock lock = new ReentrantLock();

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);


    }
    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    public boolean isLink(){
        return true;
    }


    @Override
    public void accept(FSVisitor vst) {
    	lock.lock();
    	try {
    		vst.visit(this);
    		
    	}
    	finally {
    		lock.unlock();
    	}
    }
}

