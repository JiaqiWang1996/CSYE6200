package neu.edu.csye6200;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import neu.edu.csye6200.SimplePersonFactory.PersonCriteria;




public class StudentModel extends PersonModel{
	public static void compareByGPA(List<Student> list) {
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student a, Student b) {
				return Double.compare(b.getGPA(), a.getGPA());
				}
		});
	}
	public static void demo() {
		SimplePersonFactory factory = new SimplePersonFactory();
		StudentFactory studentFactory = new StudentFactory();

		List<Student> students = new ArrayList<>();
		List<Person> persons = new ArrayList<>();
		
		Student student1 = (Student)factory.getObject(PersonCriteria.Student);
		student1.setAge(16);
		student1.setGPA(3.0);
		student1.setFirstName("Eren1");
		student1.setLastName("Yeager1");
		Student student2 = (Student)factory.getObject(PersonCriteria.Student);
		student2.setAge(18);
		student2.setGPA(4.0);
		student2.setFirstName("Eren2");
		student2.setLastName("Yeager2");
		Student student3 = (Student)factory.getObject(PersonCriteria.Student);
		student3.setAge(17);
		student3.setGPA(3.7);
		student3.setFirstName("Eren3");
		student3.setLastName("Yeager3");
		students.add(student1);
		students.add(student2);
		students.add(student3);
		Student student4 = (Student)studentFactory.getObject("Eren4", "Yeager4", 21,3.1);
		Student student5 = (Student)studentFactory.getObject("Eren5", "Yeager5",22,3.2);
		Student student6 = (Student)studentFactory.getObject("Eren6", "Yeager6",23,3.3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		persons.add(student1);
		persons.add(student2);
		persons.add(student3);
		persons.add(student4);
		persons.add(student5);
		persons.add(student6);
		System.out.println( StudentModel.class.getName() + ".demo()");
		StudentModel.compareByLastName(persons);
		System.out.println("\n\t" + StudentModel.class.getName() + ".compareByLastName(students) next");
		for (Person student : persons) {
			System.out.println(student.toString());
		}
		System.out.println("\n\t" + StudentModel.class.getName() + ".compareByLastName(students) is done!");
		System.out.println("\n\t" + StudentModel.class.getName() + ".compareByAge(students)next");
		compareByAge(persons);
		for (Person student : persons) {
			System.out.println(student.toString());
		}
		System.out.println("\n\t" + StudentModel.class.getName() + ".compareByAge(students) is done!");
		System.out.println("\n\t" + StudentModel.class.getName() + ".compareByGPA(students)next");
		compareByGPA(students);
		for (Person student : students) {
			System.out.println(student.toString());
		}
		System.out.println("\n\t" + StudentModel.class.getName() + ".compareByGPA(students) is done!");
		System.out.println("\n\t" + StudentModel.class.getName() + ".demo() is done!");
	}
}