package edu.umb.cs681.hw16;
import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class File extends FSElement{
    private final ReentrantLock lock = new ReentrantLock();


    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean isLink(){
        return false;
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
