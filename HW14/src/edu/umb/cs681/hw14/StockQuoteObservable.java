package edu.umb.cs681.hw14;


import java.util.HashMap;

public class StockQuoteObservable extends Observable<StockEvent> {
    private HashMap<String,Double> hashMap=new HashMap<>();

    public StockQuoteObservable(){
        this.hashMap=new HashMap<>();
    }

    public  void ChangeQuote(String s,Double d){
        hashMap.put(s,d);
        notifyObservers(new StockEvent(s,d));
    }

    public HashMap<String, Double> getHashMap() {
        return hashMap;
    }

//	@Override
//	public void update(Observable<StockEvent> sender, StockEvent event) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void update(Observable sender, Object event) {
		// TODO Auto-generated method stub
		
	}
}