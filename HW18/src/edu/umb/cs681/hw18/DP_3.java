package edu.umb.cs681.hw18;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//east boston min,max and average gross tax

public class DP_3 {
	final static int gt=30;
	final static int ct=6;
	
	public static void main(String[] args) throws IOException {
		String filePath = "property.csv"; 
		Path path = Paths.get(filePath);
		try(Stream<String> lines = Files.lines(path)) {

			List<String> tax = lines.skip(1)
                    .map(line -> line.split(","))
                    .filter(row -> row.length > ct && row[ct].equals("EAST BOSTON"))
                    .filter(row->row.length>gt)
                    .map(row -> row[gt])
                    .collect(Collectors.toList());
			
			List<Float> t = tax.stream().parallel().filter(str -> !str.isEmpty()).map(Float::parseFloat).collect(Collectors.toList());
			
			OptionalDouble min= t.stream().parallel().mapToDouble(Float::intValue).min();
			
			System.out.println("Minimum Gross Tax Value in East Boston: "+min.getAsDouble());
			
			OptionalDouble max= t.stream().parallel().mapToDouble(Float::intValue).max();
			
			System.out.println("Maximum Gross Tax Value in East Boston: "+max.getAsDouble());
			
			OptionalDouble avg= t.stream().parallel().mapToDouble(Float::intValue).average();
			
			System.out.println("Average Gross Tax Value in East Boston: "+avg.getAsDouble());
				
			
		}
		catch (IOException ex) {
			System.out.println("Cannot Process Data");}
	}
}
