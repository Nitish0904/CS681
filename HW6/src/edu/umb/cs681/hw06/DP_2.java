package edu.umb.cs681.hw06;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//land values in 1900 in Boston
public class DP_2 {
	final static int lv=27;
	final static int yr=31;
	
	public void Data2() {
		String filePath = "property.csv"; 
		Path path = Paths.get(filePath);
		try(Stream<String> lines = Files.lines(path)) {
	
			
			List<String> landValues = lines.skip(1)
                    .map(line -> line.split(","))
                    .filter(row -> row.length > yr && row[yr].equals("1990"))
                    .map(row -> row[lv])
                    .collect(Collectors.toList());
			
			List<Float> v = landValues.stream().filter(str -> !str.isEmpty()).map(Float::parseFloat).collect(Collectors.toList());
			
			OptionalDouble min= v.stream().mapToDouble(Float::intValue).min();
			
			System.out.println("Minimum Land Value in Boston in 1900: "+min.getAsDouble());
			
			OptionalDouble max= v.stream().mapToDouble(Float::intValue).max();
			
			System.out.println("Max Land Value in Boston in 1900: "+max.getAsDouble());
			
			OptionalDouble avg= v.stream().mapToDouble(Float::intValue).average();
			
			System.out.println("Average Land Value in Boston in 1900: "+avg.getAsDouble());
			
			System.out.println("\n\n");

//			System.out.println(landValues);
			
//			List<String> land_value=matrix.stream().
			
//			System.out.println(matrix);
			
			
			
//			List<String> land_value=matrix.stream().
//					filter((data) -> data.get(yr).contains("1990")).map(row -> row.get(lv)).
//					collect(Collectors.toList());
//			
			

		}
		catch (IOException ex) {
			System.out.println("Cannot Process Data");}
	}
}
