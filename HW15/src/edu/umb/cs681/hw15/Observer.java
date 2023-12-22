package edu.umb.cs681.hw15;

public interface Observer<StockEvent> {
//	void update(Observable<edu.umb.cs681.hw14.StockEvent> sender, Observable<edu.umb.cs681.hw14.StockEvent> event);

	public void update(Observable<StockEvent> sender, StockEvent event);
}
