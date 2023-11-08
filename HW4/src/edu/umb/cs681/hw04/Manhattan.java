package edu.umb.cs681.hw04;
import java.util.List;
import java.util.stream.IntStream;

public class Manhattan implements DistanceMetric {

//    public static void main(String[] args) {
//        Manhattan m = new Manhattan();
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
	
		public double distance(List<Double> p1, List<Double> p2) {
	        return IntStream.range(0, Math.min(p1.size(), p2.size()))
	                .mapToDouble(i -> Math.abs(p1.get(i) - p2.get(i)))
	                .sum();
	    }
	
		public static void main(String[] args) {
				
			}
    
	    

//    @Override
//    public double distance(List<Double> p1, List<Double> p2) {
//        double sumOfCoordinates = 0;
//        Iterator<Double> it1 = p1.iterator();
//        Iterator<Double> it2 = p2.iterator();
//        while (it1.hasNext() && it2.hasNext()) {
//            double coord1 = it1.next();
//            double coord2 = it2.next();
//            sumOfCoordinates += Math.abs(coord1 - coord2);
//        }
//        return sumOfCoordinates;
//    }
    
    

}
