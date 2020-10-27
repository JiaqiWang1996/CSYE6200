package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import neu.edu.csye6200.SimplePersonFactory.PersonCriteria;





public class EmployeeModel extends PersonModel//ºÃ≥–personÀ˘”– Ù–‘
{
	public static void compareByWage(List<Employee> employees) {
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee a, Employee b) {
				return Double.compare(a.getWage(), b.getWage());
			}
		});
	}
	
	public static void demo() {
		SimplePersonFactory factory = new SimplePersonFactory();
		EmployeeFactory employeeFactory = new EmployeeFactory();

		List<Employee> employees = new ArrayList<>();
		List<Person> persons = new ArrayList<>();
		
		Employee employee1 = (Employee)factory.getObject(SimplePersonFactory.PersonCriteria.Employee);
		employee1.setAge(18);
		employee1.setWage(20);
		employee1.setFirstName("Jim1");
		employee1.setLastName("Kerry1");
		Employee employee2 = (Employee)factory.getObject(PersonCriteria.Employee);
		employee2.setAge(21);
		employee2.setWage(30);
		employee2.setFirstName("Jim2");
		employee2.setLastName("Kerry2");
		Employee employee3 = (Employee)factory.getObject(PersonCriteria.Employee);
		employee3.setAge(19);
		employee3.setWage(25);
		employee3.setFirstName("Jim3");
		employee3.setLastName("Kerry3");
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		Employee employee4 = (Employee)employeeFactory.getObject("Jim4","Kerry",32,60);
		Employee employee5 = (Employee)employeeFactory.getObject("Jim5","Kerry",27,50);
		Employee employee6 = (Employee)employeeFactory.getObject("Jim6","Kerry",39,70);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
		persons.add(employee1);
		persons.add(employee2);
		persons.add(employee3);
		persons.add(employee4);
		persons.add(employee5);
		persons.add(employee6);
		System.out.println("\n\t" + EmployeeModel.class.getName() + ".demo()");
		EmployeeModel.compareByLastName(persons);
		System.out.println( "\n\t" +EmployeeModel.class.getName() + ".compareByLastName(employees) next ");
		for (Person employee : persons) {
			System.out.println(employee.toString());
		}
		System.out.println("\n\t" + EmployeeModel.class.getName() + ".compareByLastName(employees) is done!");
		System.out.println("\n\t" + EmployeeModel.class.getName() + ".compareBySalary(employees) next");
		compareByWage(employees);
		for (Person employee : employees) {
			System.out.println(employee.toString());
		}
		System.out.println("\n\t" + EmployeeModel.class.getName() + ".compareBySalary(employees) is done!");
		System.out.println("\n\t" + EmployeeModel.class.getName() + ".demo() is done!");
	}
}