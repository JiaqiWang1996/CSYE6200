package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Student extends Person implements Comparable<Student> {
	private int studentId;
	private double gpa;
	/**
	 * Implement the Comparable interface by providing
	 * this compareTo method as required,
	 * so Student object hava a natural or default order.
	 * (Sort without specifying a Comparator)
	 */
	@Override
	public int compareTo(Student o) {
		return Integer.compare(this.studentId, o.getStudentId()); // sort by ID
//		return Double.compare(this.gpa, o.getGpa());	// sort by GOA
	}
	public Student() {
		super(1,17,"Dan","Peters","Jim","Peters");
		this.studentId = 101;
		this.gpa = 4.0;
	}
	public Student(int id, int age, String firstName, String lastName, String parentFirstName, String parentLastName, int studentId, double gpa) {
		super(id, age, firstName, lastName, parentFirstName, parentLastName);
		this.studentId = studentId;
		this.gpa = gpa;
	}
	/**
	 * construct a Student object from a CSV string:
	 *    "ID,age,firstName,lastName,parentsFirstName,parentsLastName,studentId,gpa"
	 * for example:
	 *    "1,17,Dan,Peters,Jim,Peters,101,4.0"
	 *    
	 * @param s					Student state CSV String data
	 */
	public Student(String csvData) {
		int id = 0;
		int age = 0;
		int studentId = 0;
		double gpa = 0.0;
		
		String[] tokens = csvData.split(",");
		id = Conversions.stringToInt(tokens[0]);
		age = Conversions.stringToInt(tokens[1]);
		studentId = Conversions.stringToInt(tokens[6]);
		gpa = Conversions.stringToDouble(tokens[7]);
		this.init(id, age, tokens[2], tokens[3], tokens[4], tokens[5]);
		this.studentId = studentId;
		this.gpa = gpa;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/**
	 * Derived classes may override these Comparators to customize API
	 * @return
	 */
	@Override
	public Comparator<AbstractPerson> derivedComparator1() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				int retComparisonMetric = 0;
				if ( (o1 instanceof Student) && (o2 instanceof Student)  ) {
					Student s1 = (Student) o1;
					Student s2 = (Student) o2;
					retComparisonMetric = 
							Double.compare(s1.getGpa(), s2.getGpa());
				}
				return retComparisonMetric;
			}
		};
	}
	@Override
	public Comparator<AbstractPerson> derivedComparator2() {
		return new Comparator<AbstractPerson>() {
			
			@Override
			public int compare(AbstractPerson o1, AbstractPerson o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		};
	}

	/**
	 * return a string representation of the object state
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#").append(this.getId());
		sb.append(" ").append(this.getFirstName());
		sb.append(" ").append(this.getLastName());
		sb.append(", age ").append(this.getAge());
		sb.append(", having a GPA of ").append(this.getGpa());
		sb.append(", Parent: ").append(this.getParentFirstName());
		sb.append(" ").append(this.getParentLastName());
		
		return sb.toString();
	}
	public static void demo() {
		System.out.println("\n\t Student.demo()...");		
		
		/**
		 * write a CSV file with Student data
		 */
		FileUtility fileUtil = new FileUtility();
		String fileName = "students.txt";
		List<String> writeStudentCSVData = new ArrayList<String>(
				Arrays.asList(
				"1,17,Dan,Peters,James,Peters,101,4.0",
				"2,16,Jan,Petersen,John,Petersen,102,3.7",
				"3,27,Pam,Peterson,Jack,Peterson,103,3.8")
				);
		fileUtil.writeTextFile(fileName, writeStudentCSVData);

		/**
		 * read a CSV file with Student data
		 */
		List<String> readCSVData = fileUtil.readTextFile(fileName);	
		readCSVData.forEach(System.out::println);
		
		{
			/**
			 * Create Student objects using Student CSV data
			 * read from CSV file
			 */
			List<Student> students = new ArrayList<>();
			for (String string : readCSVData) {
				students.add(new Student(string));
			}
			
			/**
			 * Show Student state
			 */
			System.out.println(students.size() + " Student objects in list.");
			for (Student student : students) {
				System.out.println(student);
			}
		}
//		{
//			/**
//			 * Create Student objects using Student CSV data
//			 * read from CSV file
//			 */
//			AbstractPersonFactory factory = new StudentFactory();
//			List<Person> students = new ArrayList<>();
//			for (String string : readCSVData) {
//				students.add(factory.getObject(string));
//			}
//			
//			/**
//			 * Show Student state
//			 */
//			System.out.println(students.size() + " Factory created Student objects in list.");
//			for (Person student : students) {
//				System.out.println(student);
//			}
//		}
		{
			/**
			 * Create Student objects using Student CSV data
			 * read from CSV file
			 */
			AbstractPersonFactory factory = new StudentFactory();
			List<AbstractPerson> students = new ArrayList<>();
			for (String string : readCSVData) {
				students.add(factory.getObject(string));
			}
			
			/**
			 * Show Student state
			 */
			System.out.println(students.size() + " Factory created Student objects in list.");
			for (AbstractPerson student : students) {
				System.out.println(student);
			}
			/**
			 * Sort Student roster
			 */
			System.out.println("Sort Students by ID:");
			students.sort(AbstractPerson.idComparator());
			students.forEach(System.out::println);
			System.out.println("Sort Students by AGE:");
			students.sort(AbstractPerson.ageComparator());
			students.forEach(System.out::println);
			System.out.println("Sort Students by FIRST NAME:");
			students.sort(AbstractPerson.firstNameComparator());
			students.forEach(System.out::println);
			System.out.println("Sort Students by LAST NAME:");
			students.sort(AbstractPerson.lastNameComparator());
			students.forEach(System.out::println);
			
			System.out.println("Sort Students by GPA:");
			students.sort( (new Student()).derivedComparator1());
			students.forEach(System.out::println);
		}

		System.out.println("\n\t Student.demo()... done!");
	}
	/**
	 * CONSOLE OUTPUT
	 * 
	 */
}
