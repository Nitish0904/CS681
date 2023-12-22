package edu.umb.cs681.hw16.util;
import java.util.ArrayList;

import edu.umb.cs681.hw16.Directory;
import edu.umb.cs681.hw16.FSVisitor;
import edu.umb.cs681.hw16.File;
import edu.umb.cs681.hw16.Link;

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
