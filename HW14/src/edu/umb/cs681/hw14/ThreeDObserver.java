package edu.umb.cs681.hw14;
import java.util.HashMap;

public class ThreeDObserver implements Observer {

    private HashMap<String, Double> ThreeDMap = new HashMap<>();
    public void update(Observable<StockEvent> sender, StockEvent event) {
        ThreeDMap.put(event.getTicker(), event.getQuote());
        System.out.println("3D Printing");
        System.out.println("Ticker:"+event.getTicker());
        System.out.println("Quote:"+event.getQuote());
    }

    public HashMap<String, Double> getThreeDMap() {
        return ThreeDMap;
    }

	@Override
	public void update(Observable sender, Object event) {
		// TODO Auto-generated method stub
		
	}
}