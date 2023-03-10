package model;

public class Student {
	private String id;
	private String name;
	private double average;
	
	public Student() {
		super();
	}
	
	public Student(String id, String name, double average) {
		this.id = id;
		this.name = name;
		this.average = average;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", average=" + average + "]";
	}
	
	
}
