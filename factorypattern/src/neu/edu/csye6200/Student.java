package neu.edu.csye6200;


public class Student extends Person{
	String firstName;
	String lastName;
	int age;
	double GPA;

	public Student() {}
	
	public Student(String firstName, String lastName, int age, double GPA) {
		super(firstName, lastName, age);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.GPA = GPA;
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

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	@Override
	public String toString() {
		return "Student " + firstName + " " + lastName + ", age " + age + ", GPA " + GPA;
	}
}
	
	