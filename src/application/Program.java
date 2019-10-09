package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entities.Employee;
import model.utility.Utility;

public class Program {

	public static void main(String[] args) {

		String path = "C:\\Temp\\In\\employees.txt";

		List<Employee> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}

			String sTitle, sOrder;
			for (int o = 1; o >= -1; o--) {
				sOrder = (o == 1) ? "Crescente" : "Descrescente";
				if (o != 0) {
					for (int f = 0; f < 2; f++) {
						sTitle = (f == 0) ? "Order by name of employee: " : "Order by Salary of employee: ";
						sTitle += "(" + sOrder + ")";
						updateList(list, f, o);
						Collections.sort(list);
						System.out.println(sTitle);
						System.out.println(Utility.stringFix("", 43, "="));
						System.out.print(Utility.stringFix("Employee", 20, " ") + "   ");
						System.out.println(Utility.stringFix("Salary", 20, " "));
						System.out.println(Utility.stringFix("", 20, "-") + "   " + Utility.stringFix("", 20, "-"));
						for (Employee emp : list) {
							System.out.println(emp);
						}
						System.out.println(Utility.stringFix("", 43, "="));
					}
				}
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

	}
	
	public static void updateList(List<Employee> employees, int sortField, int sortOrder) {
		for (Employee emp : employees) {
			emp.setSortField(sortField);
			emp.setSortOrder(sortOrder);
		}
	}

}
