package edu.umb.cs681.hw11.util;
//import java.io.File;
import java.util.ArrayList;

import edu.umb.cs681.hw11.Directory;
import edu.umb.cs681.hw11.FSVisitor;
import edu.umb.cs681.hw11.Link;
import edu.umb.cs681.hw11.File;


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


	
//	public void visit(edu.umb.cs681.hw11.File fl) {
//		// TODO Auto-generated method stub
//		
//	}
}
