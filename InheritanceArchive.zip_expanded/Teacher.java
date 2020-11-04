package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher extends Person {
	private int employeeId;
	private double wage;
	public Teacher() {
		super(1, 17, "Dan", "Peters", "James", "Peters");
		this.employeeId = 1001;
		this.wage = 75.0;
	}
	public Teacher(int id, int age, String firstName, String lastName, int employeeId, double wage) {
		super(id, age, firstName, lastName, "", "");
		this.employeeId = employeeId;
		this.wage = wage;
	}
	/**
	 * construct a Teacher object from a CSV string:
	 *    "ID,age,firstName,lastName,employeeID,wage"
	 * for example:
	 *    "1,17,Dan,Peters,101,4.0"
	 *    
	 * @param s					Student state CSV String data
	 */
	public Teacher(String csvData) {
		int id = 0;
		int age = 0;
		int employeeId = 0;
		double gpa = 0.0;
		
		String[] tokens = csvData.split(",");
		
		id = Conversions.stringToInt(tokens[0]);
		age = Conversions.stringToInt(tokens[1]);
		employeeId = Conversions.stringToInt(tokens[4]);
		gpa = Conversions.stringToDouble(tokens[5]);
		this.init(id, age, tokens[2], tokens[3], "", "");
		this.employeeId = employeeId;
		this.wage = gpa;
	}
	public Teacher(int employeeId, double wage) {
		super();
		this.employeeId = employeeId;
		this.wage = wage;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#").append(this.getId());
		sb.append(" [").append(this.getEmployeeId()).append("]");
		sb.append(" ").append(this.getFirstName());
		sb.append(" ").append(this.getLastName());
		sb.append(", age ").append(this.getAge());
		sb.append(", earning a hourly wage of ").append(this.getWage());
//		sb.append(", Parent: ").append(this.getParentFirstName());
//		sb.append(" ").append(this.getParentLastName());
		
		return sb.toString();
	}
	public static void demo() {
		System.out.println("\n\t Teacher.demo()...");		
		
		/**
		 * write a CSV file with Teacher data
		 */
		FileUtility fileUtil = new FileUtility();
		String fileName = "teachers.txt";
		List<String> writeTeacherCSVData = new ArrayList<String>(
				Arrays.asList(
				"1,17,Dan,Peters,1001,41.75",
				"2,16,Jan,Petersen,1002,37.65",
				"3,27,Pam,Peterson,1003,93.85")
				);
		fileUtil.writeTextFile(fileName, writeTeacherCSVData);

		/**
		 * read a CSV file with Teacher data
		 */
		List<String> readCSVData = fileUtil.readTextFile(fileName);	
		readCSVData.forEach(System.out::println);
		
		/**
		 * Create Teacher objects using Teacher CSV data
		 * read from CSV file
		 */
		List<Teacher> teachers = new ArrayList<>();
		for (String string : readCSVData) {
			teachers.add(new Teacher(string));
		}
		
		/**
		 * Show Teacher state
		 */
		System.out.println(teachers.size() + " Teacher objects in list.");
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}

		System.out.println("\n\t Teacher.demo()... done!");
	}
	/**
	 * CONSOLE OUTPUT
	 * 
	 */
}
