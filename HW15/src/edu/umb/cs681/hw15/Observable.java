package edu.umb.cs681.hw15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public abstract class Observable<StockEvent> implements Observer{
	private List<Observer<StockEvent>> observers = new LinkedList<>();
	private static final Lock lock = new ReentrantLock();

	
	public void addObserver(Observer<StockEvent> o) {
		
		lock.lock();
        try {
            observers.add(o);
        } finally {
            lock.unlock();
//		observers.add(o);
        }
        
	}

	public void clearObservers() {
		observers.clear();
		
	}
	public List<Observer<StockEvent>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
		
	}
	public void removeObserver(Observer<StockEvent> o) {
		observers.remove(o);
	}

	public void notifyObservers(StockEvent event) {
		ArrayList<Observer<StockEvent>> observerList;

		// List<Observer<StockEvent>> temp = new LinkedList<>(observers);
		// temp.forEach((observer) -> {observer.update(this, event);});

		lock.lock();
        try {
				observerList = new ArrayList<>(observers);
			// private List<Observer<StockEvent>> observers = new LinkedList<>();
            // observers.forEach((observer) -> {
            //     observer.update(this, event);
        }

		finally {
            lock.unlock();
        }

		observers.forEach((observer) -> {
                observer.update(this, event);
            });
        
	} 
        
     
		
}
