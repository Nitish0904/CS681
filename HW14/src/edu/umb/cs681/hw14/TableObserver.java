package edu.umb.cs681.hw14;

import java.util.HashMap;

public class TableObserver implements Observer{

    private HashMap<String,Double> TableMap = new HashMap<>();

    public void update(Observable<StockEvent> sender, StockEvent event) {
        TableMap.put(event.getTicker(), event.getQuote());
        System.out.println("Table Printing");
        System.out.println("Ticker:"+event.getTicker());
        System.out.println("Quote:"+event.getQuote());
    }

    public HashMap<String, Double> getTableMap() {
        return TableMap;
    }

	@Override
	public void update(Observable sender, Object event) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void update(Observable<StockEvent> sender, Observable<StockEvent> event) {
//		// TODO Auto-generated method stub
//		
//	}
}