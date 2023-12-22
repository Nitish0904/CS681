package edu.umb.cs681.hw10;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class FileSystem {
    private static final AtomicReference<FileSystem> instance = new AtomicReference<>();
    private LinkedList<Directory> rds = new LinkedList<>();

//    private FileSystem() {}  

    public static FileSystem getFileSystem() {
        if (instance.get() == null) {
            instance.compareAndSet(null, new FileSystem());
        }
        return instance.get();
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rds;
    }

    public void appendRootDir(Directory d) {
        this.rds.add(d);
    }

    
}
