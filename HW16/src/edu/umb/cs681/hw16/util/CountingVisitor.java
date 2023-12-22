package edu.umb.cs681.hw16.util;
import edu.umb.cs681.hw16.Directory;
import edu.umb.cs681.hw16.FSVisitor;
import edu.umb.cs681.hw16.File;
import edu.umb.cs681.hw16.Link;

public class CountingVisitor implements FSVisitor {
    public int cntlk = 0;
    public int cntdir = 0;
    public int cntfl = 0;

    public void visit(Link lk) {
        cntlk++;
    }

    public void visit(Directory dir) {
        cntdir++;
    }

    public void visit(File fl) {
        cntfl++;
    }

    public int getLinkNumber() {
        return cntlk;
    }

    public int getDirNumber() {
        return cntdir;
    }

    public int getflNumber() {
        return cntfl; }
}
