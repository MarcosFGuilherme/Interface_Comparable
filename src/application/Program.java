package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Program {

	public static void main(String[] args) {
		
		String path = "C:\\Temp\\In\\in.txt";
		
		List<String> employees = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while (line != null) {
				employees.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		for (String emp : employees) {
			System.out.println(emp);
		}
	}

}
