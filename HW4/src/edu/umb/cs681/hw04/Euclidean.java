package edu.umb.cs681.hw04;
import java.util.List;
import java.util.stream.IntStream;

public class Euclidean implements DistanceMetric{
	
//	public static void main(String[] args) {
//        Euclidean m = new Euclidean();
//        List<Double> p1 = List.of(4.0, 6.0);
//        List<Double> p2 = List.of(5.0, 10.0);
//        double res;
//        res = m.distance(p1, p2);
//        System.out.println(res);
//        List<List<Double>> mat = List.of(p1, p2);
//        List<List<Double>> ress;
//        ress = Distance.matrix(mat, m);
//        System.out.println(ress);
//    }
    
    public double distance(List<Double> p1, List<Double> p2){ 
    	
    	double sumOfSquared =IntStream.range(0, Math.min(p1.size(),p2.size()))
    			.mapToDouble(i -> p1.get(i)-p2.get(i)) 
    			.map(n -> n*n).sum();
    	
    	return Math.sqrt(sumOfSquared); 
    	
    }
    
	public static void main(String[] args) {
		
	}

    
//    public double distance(List<Double> p1, List<Double> p2) {
//        // TODO Error handling if p1.size() != p2.size()
//        double sumOfSquared = 0.0;
//        for(int i=0; i < p1.size(); i++) {
//            sumOfSquared += Math.pow( p1.get(i)-p2.get(i), 2 );
//        }
//        return Math.sqrt(sumOfSquared);
//    }

    
}
