package model.entities;

import model.utility.Utility;

public class Employee implements Comparable<Employee> {
	private String name;
	private Double salary;
	private int sortField;
	private int sortOrder = 1;

	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getSortField() {
		return sortField;
	}

	public void setSortField(int sortField) {
		this.sortField = sortField;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public String toString() {
		return Utility.stringFix(name, 20, " ") + "   " + Utility.stringFix(String.format("%.2f", salary), 20, " ");
	}

	@Override
	public int compareTo(Employee other) {
		int iCompare;
		switch  (getSortField()) {
		case 0 :
			iCompare = name.compareTo(other.getName());
			break;
		case  1:
			iCompare = salary.compareTo(other.getSalary());
			break;
		default:
			iCompare = name.compareTo(other.getName());
		}
		return iCompare * getSortOrder();
	}

}
