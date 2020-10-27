package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends Person1 {
	private double gpa = 4.0;

	public Student() {
		super();
	}
	
	public Student(int age, String name) {
		super(age, name);
		// TODO Auto-generated constructor stub
	}

	public Student(int[] celNumber, int age, String name) {
		super(celNumber, age, name);
		// TODO Auto-generated constructor stub
	}

	public Student(double gpa) {
		super();
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Student: ");
		
		sb.append(this.getName());
		sb.append(", age ").append(this.getAge());
		sb.append(" has a GPA of ").append(this.getGpa());
		
//		return "Student " + this.getName() 
//			+ ", age " + this.getAge() 
//			+ ", having a GPA of " + getGpa();
//		return "Student [gpa=" + gpa + "]";
		
		return sb.toString();
	}

	/**
	 * demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + Student.class.getName() + ".demo()...");
		
		Student danStudent = new Student();
		Student samStudent = new Student(21, "Sam");
		Person1 personReference = danStudent;	// use Person1 variable to reference Student object
		System.out.println(personReference);
		personReference = samStudent;	// use Person1 variable to reference Student object
		System.out.println(personReference);

		List<Person1> personList = new ArrayList<>(
			Arrays.asList(
				new Student(),
				new Student(18, "Jan"),
				new Student(19, "Pam"),
				new Student(20, "Anne"),
				new Student(21, "Andy")
				));
		System.out.println(personList.size() + " Students in person list.");
		for (Person1 obj : personList) {
			System.out.println(obj);
		}
		
		System.out.println("\n\t" + Student.class.getName() + ".demo()... done!");
	}
}
