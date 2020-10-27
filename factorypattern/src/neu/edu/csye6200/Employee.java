package neu.edu.csye6200;


public class Employee extends Person{
	String firstName;
	String lastName;
	int age;
	double wage;
	
	public Employee() {};
	
	public Employee(String firstName, String lastName, int age, double wage) {
		super(firstName, lastName, age);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.wage = wage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "Employee "+ firstName + " " + lastName + ", age " + age + ", wage $" + wage;
	}

}
