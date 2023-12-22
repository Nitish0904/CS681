package edu.umb.cs681.hw8;

import java.time.LocalDateTime;

public class Link extends FSElement{
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
        vst.visit(this);
    }
}
