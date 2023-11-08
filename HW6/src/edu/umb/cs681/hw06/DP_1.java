package edu.umb.cs681.hw06;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DP_1 {
	//getting the min,max and average total property values in Boston
	final static int total_value=29;
	
	public void Data1() {
		String filePath = "property.csv"; 
		Path path = Paths.get(filePath);
		try(Stream<String> lines = Files.lines(path)) {
			
			List<List<String>> matrix =lines.map( line -> 
			Stream.of( line.split(",") ).collect(Collectors.toList())).
				collect(Collectors.toList());
			
//			System.out.println(matrix);
			
			//getting only 'total_value' column values
			List<String> values=matrix.stream().skip(1).map(row -> row.get(total_value)).collect(Collectors.toList());
//			System.out.println(values);
			
			//converting the column string values to float values
			List<Float> v = values.stream().filter(str -> !str.isEmpty()).map(Float::parseFloat).collect(Collectors.toList());
//			System.out.println(v);
			
			OptionalDouble min= v.stream().mapToDouble(Float::intValue).min();
			
			System.out.println("Minimum value of Property in Boston: "+min.getAsDouble());
			
			OptionalDouble max= v.stream().mapToDouble(Float::intValue).max();
			
			System.out.println("Max value of Property in Boston: "+max.getAsDouble());
			
			OptionalDouble avg= v.stream().mapToDouble(Float::intValue).average();
			
			System.out.println("Average Property Value in Boston: "+avg.getAsDouble());
			
			System.out.println("\n\n");
			

		}
		catch (IOException ex) {
			System.out.println("Cannot Process Data");}
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
}
