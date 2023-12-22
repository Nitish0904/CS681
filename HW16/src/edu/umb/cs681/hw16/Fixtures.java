package edu.umb.cs681.hw16;
import java.time.LocalDateTime;

public class Fixtures {
	public static FileSystem nfs(){

        Directory root = new Directory(null, "prjroot", 0, LocalDateTime.now());
        Directory src = new Directory(root, "src", 0, LocalDateTime.of(2021,9,9,10,25));
        Directory lib = new Directory(root, "lib", 0, LocalDateTime.now());
        Directory test = new Directory(root, "test", 0, LocalDateTime.now());
        File x = new File(root, "x", 30, LocalDateTime.of(2021,9,9,10,25));


        File a = new File(src, "a", 40, LocalDateTime.now());
        File b = new File(src, "b", 45, LocalDateTime.now());
        File c = new File(lib, "c", 50, LocalDateTime.now());

        Directory src_2 = new Directory(test, "src", 0, LocalDateTime.now());
        Link y = new Link(root, "y", 0, LocalDateTime.now(), src_2);

        File d = new File(src_2, "d", 60, LocalDateTime.now());

        root.appendChild(src);
        root.appendChild(lib);
        root.appendChild(test);
        root.appendChild(x);
        root.appendChild(y);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        test.appendChild(src_2);
        src_2.appendChild(d);

        FileSystem flstm = FileSystem.getFileSystem();

        flstm.appendRootDir(root);

        return flstm;
    }
}
