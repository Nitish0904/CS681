package edu.umb.cs681.hw10;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;
//import edu.umb.cs681.hw10.*;

public class Main extends FileSystem implements Runnable {
    
	private final AtomicBoolean running = new AtomicBoolean(true);
	
	public void stop() {
        running.set(false);
    }
	
	public void Runnable() {
		while (running.get()) {
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
	        System.out.println("Child 1 of root: "+flstm.getRootDirs().get(0).getChildren().get(0).getName());
	        System.out.println("Child 2 of root: "+flstm.getRootDirs().get(0).getChildren().get(1).getName());
	        System.out.println("Child 3 of root: "+flstm.getRootDirs().get(0).getChildren().get(2).getName());
	        System.out.println("Child 4 of root: "+flstm.getRootDirs().get(0).getChildren().get(3).getName());
	        System.out.println("Child 5 of root: "+flstm.getRootDirs().get(0).getChildren().get(4).getName());

		}
		
	}
	
	public static void main (String[] args) {
		List<Main> clients = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			Main handler = new Main();
			clients.add(handler);
			Thread thread = new Thread(handler);
			threads.add(thread);
			thread.start();
			System.out.println("Running Thread:" + thread.getName());
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (Main client : clients) {
			System.out.println("stopping thread..." + client.hashCode());
			client.stop();
		}

		for (Thread thread : threads) {
			thread.interrupt();
		}
    }

	@Override
	public void run() {
		Runnable();
		
	}
    		
}
