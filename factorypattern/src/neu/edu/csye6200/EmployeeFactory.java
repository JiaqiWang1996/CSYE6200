package neu.edu.csye6200;


public class EmployeeFactory extends AbstractPersonFactoryAPI{
	public Person getObject(String firstName, String lastName, int age, double salary) {
		return new Employee(firstName,lastName,age,salary);
	}
	
	public Person getObject() {
		return new Employee();
	}
}