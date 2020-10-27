package neu.edu.csye6200;


public class StudentFactory extends AbstractPersonFactoryAPI{
	public Person getObject() {
		return new Student();
	}
	
	public Person getObject(String firstName, String lastName, int age, double GPA) {
		return new Student(firstName,lastName, age,GPA);
	}
}
