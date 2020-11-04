package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class School extends AbstractSchool {
	private List<AbstractPerson> studentRoster;
	
	{
		studentRoster = new ArrayList<AbstractPerson>();
	}
	
	/**
	 * enroll Students in School, adding to student roster
	 * @param s		Student object
	 */
	@Override
	public void enroll(AbstractPerson s) {
		this.studentRoster.add(s);
	}
	
	/**
	 * Use supplied comparator to sort the roster
	 */
	@Override
	public void sortRoster(Comparator<AbstractPerson> c) {
		this.studentRoster.sort(c);
	}

	/**
	 * Show Student Roster by using Student toString()
	 */
	@Override
	public void showRoster() {
		System.out.println(this);
	}
	/**
	 * return a String representation of the object state
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\nSchool Roster:\n");
		for (AbstractPerson student : studentRoster) {
			sb.append(student.toString()).append("\n");
		}
		return sb.toString();
	}

	/**
	 * demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t School.demo()...");		
		
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
			School school = new School();
			/**
			 * Create Student objects using Student CSV data
			 * read from CSV file
			 */
			List<Student> students = new ArrayList<>();
			for (String csvString : readCSVData) {
				students.add(new Student(csvString));
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
			School school = new School();
			
			for (String string : readCSVData) {
				school.enroll(factory.getObject(string));
				students.add(factory.getObject(string));
			}
			
			/**
			 * Show Student state
			 */
			System.out.println(students.size() + " Factory created Student objects in list.");
			for (AbstractPerson student : students) {
				System.out.println(student);
			}
			System.out.println(school);
			/**
			 * Sort School Student Roster
			 */
			System.out.println("Sort School Student Roster:");
			System.out.println("Sort Students by ID:");
			school.sortRoster(AbstractPerson.idComparator());
			System.out.println(school);
			System.out.println("Sort Students by AGE:");
			students.sort(AbstractPerson.ageComparator());
			System.out.println(school);
			System.out.println("Sort Students by FIRST NAME:");
			school.sortRoster(AbstractPerson.firstNameComparator());
			System.out.println(school);
			System.out.println("Sort Students by LAST NAME:");
			school.sortRoster(AbstractPerson.lastNameComparator());
			System.out.println(school);
			
			System.out.println("Sort Students by GPA:");
			school.sortRoster( (new Student()).derivedComparator1());
			System.out.println(school);

			/*
			 * Sort Student List
			 */
			System.out.println("Sort Student List:");
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

		System.out.println("\n\t School.demo()... done!");
	}
}
