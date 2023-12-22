package edu.umb.cs681.hw16.util;

import java.util.ArrayList;

import edu.umb.cs681.hw16.Directory;
import edu.umb.cs681.hw16.FSVisitor;
import edu.umb.cs681.hw16.Link;
import edu.umb.cs681.hw16.File;


public class FileCrawlingVisitor implements FSVisitor {
    private ArrayList<File> files = new ArrayList<>();

    
    public void visit(Link lk) {

    }

    
    public void visit(Directory dir) {

    }

    public void visit(File fl) {
        files.add(fl);
    }



    public ArrayList<File> getFiles(){
        return files;
    }


	
//	public void visit(edu.umb.cs681.hw16.File fl) {
//		// TODO Auto-generated method stub
//		
//	}
}
