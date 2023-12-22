package edu.umb.cs681.hw11.util;

import java.util.ArrayList;

import edu.umb.cs681.hw11.Directory;
import edu.umb.cs681.hw11.FSVisitor;
import edu.umb.cs681.hw11.File;
import edu.umb.cs681.hw11.Link;

public class FileSearchVisitor implements FSVisitor {

    private String flnm;

    public FileSearchVisitor(String flnm) {
        this.flnm = flnm;
    }

    private ArrayList<File> newfl = new ArrayList<>();

    @Override
    public void visit(Link lk) {
    }

    @Override
    public void visit(Directory dir) {

    }

    @Override
    public void visit(File fl) {
        if (fl.getName().equals(flnm)){newfl.add(fl);}
    }



    public ArrayList<File> getNewfl() {
        return newfl;
    }
}