package edu.umb.cs681.hw04;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    	
    	System.out.println("Calculating Manhattan Distance...");
    	
    	 Manhattan m = new Manhattan();
         List<Double> mp1 = List.of(4.0, 6.0);
         List<Double> mp2 = List.of(5.0, 10.0);
         double mres;
         mres = m.distance(mp1, mp2);
         System.out.println(mres);
         List<List<Double>> mmat = List.of(mp1, mp2);
         List<List<Double>> mress;
         mress = Distance.matrix(mmat, m);
         System.out.println(mress);
         
         System.out.println("\n");
         
     	System.out.println("Calculating Euclidean Distance...");

         Euclidean e = new Euclidean();
         List<Double> ep1 = List.of(4.0, 6.0);
         List<Double> ep2 = List.of(5.0, 10.0);
         double eres;
         eres = e.distance(ep1, ep2);
         System.out.println(eres);
         List<List<Double>> emat = List.of(ep1, ep2);
         List<List<Double>> eress;
         eress = Distance.matrix(emat, e);
         System.out.println(eress);
         
         System.out.println("\n");
         
         System.out.println("Testing Code with 1000 points and 100 dimensions...");
         
         try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
         
    	 
        List<List<Double>> points = getPoints(1000, 100);
        
        DistanceMetric euclidean = new Euclidean();
        DistanceMetric manhattan = new Manhattan();

        List<List<Double>> euclideanMatrix = Distance.matrix(points, euclidean);
        System.out.println("Euclidean Distance Matrix:");
        printMatrix(euclideanMatrix);

        List<List<Double>> manhattanMatrix = Distance.matrix(points, manhattan);
        System.out.println("Manhattan Distance Matrix:");
        printMatrix(manhattanMatrix);
        
        System.out.println("Finish generating points.");
    }

    private static List<List<Double>> getPoints(int pointSize, int dimSize) {
    	
        List<List<Double>> points = new ArrayList<>();
        for (int i = 0; i < pointSize; i++) {
            List<Double> point = new ArrayList<>();
            for (int j = 0; j < dimSize; j++) {
                point.add(Math.random());
            }
            points.add(point);
        }
        return points;
    }

    private static void printMatrix(List<List<Double>> matrix) {
        for (List<Double> row : matrix) {
            for (Double value : row) {
                System.out.print(value + " ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }
}

