package edu.umb.cs681.hw17;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

import java.util.List;

public abstract class Observable<StockEvent> implements Observer{
//	private List<Observer<StockEvent>> observers = new LinkedList<>();
//    private final ReentrantLock lock = new ReentrantLock();
	private ConcurrentLinkedQueue<Observer<StockEvent>> observers = new ConcurrentLinkedQueue<>();


	
	public void addObserver(Observer<StockEvent> o) {
//		observers.add(o);
//		lock.lock();
//        try {
            observers.add(o);
//        } finally {
//            lock.unlock();
//        }
	}

	public void clearObservers() {
		observers.clear();
		
	}
	public ConcurrentLinkedQueue<Observer<StockEvent>> getObservers(){
		return observers;
	}
	
	public int countObservers() {
		return observers.size();
		
	}
	public void removeObserver(Observer<StockEvent> o) {
		observers.remove(o);
	}

	public void notifyObservers(StockEvent event) {
//		lock.lock();
		observers.forEach((observer) -> {observer.update(this, event);});
//		observers.forEach( (observer)->{observer.update(this, event);} );
	}
	
}