package edu.neu.csye6200;

/**
 * Demonstrate a class to model a person
 * @author dgpeters
 *
 */
public class Person3 {
	private int id;
	private int age;
	private String firstName;
	private String lastName;

	/**
	 * Object initializer block
	 */
	{
		this.id = 1;
		this.age = 17;
		this.firstName = "Dan";
		this.lastName = "Peters";
		
	}
	/**
	 * Default constructor
	 * Create an object from this class with default values
	 */
	public Person3() {
		super();
	}
	/**
	 * Parameterized constructor
	 * Create an object from this class with supplied values
	 */
	public Person3(int id, int age, String firstName, String lastName) {
		super();//调用父类的方法？
		this.id = id;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Person3");
		
		sb.append(" #").append(id);
		sb.append(" ").append(firstName);
		sb.append(" ").append(lastName);
		sb.append(", age ").append(age);
		
		return sb.toString();	// return StringBuilder string
//		return "Person3 #" + id + " " + firstName + " " + lastName + ", age " + age;
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + Person3.class.getName() + ".demo()...");
		
		/**
		 * memory location to hold object created from Person3 class
		 */
		Person3 obj = new Person3();
		System.out.println(obj);	// call toString() implicitly
		System.out.println(obj.toString());	// call toString() explicitly
		
		/**
		 * Create another Person3 object, with specific attributes
		 */
		System.out.println(new Person3(2, 21, "Gaurav", "Panchal"));
		
		System.out.println("\n\t" + Person3.class.getName() + ".demo()... done!");
	}
	

}
