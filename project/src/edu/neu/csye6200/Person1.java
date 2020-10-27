package edu.neu.csye6200;

/**
 * Java class to model a person
 * @author dgpeters
 *
 */
public class Person1 {
	private final static int MAJOR_VERSION = 1;
	private final static int MINOR_VERSION = 1;
	private static String revision = null;
	private int[] celNumber = { 6,0,3, 5,5,5, 1,2,1,2};
	private int age = 0;	// Object instance member: age
	private String name = "Dan";	// Object instance member: name
	
	/**
	 * Class Initialization Block
	 * executed once for each class
	 */
	static {
		Person1.revision = new String(MAJOR_VERSION + "." + MINOR_VERSION);
	}
	
	/**
	 * Object Initialization Block
	 * executed with each constructor
	 * (any explicit constructor initialization will be performed AFTER this block.) 
	 */
	{
		this.age = 17;
		this.name = "Daniel";
		int[] a = { 8,0,0, 5,5,5, 1,2,1,2 };
		this.celNumber = a;
	}
	/**
	 * Class Default Constructor:
	 * Instantiate (create) a Person1 object
	 * with default state
	 * (all object data initialized with default values)
	 */
	public Person1() {
		super();
	}
	/**
	 * Class parameterized Constructor:
	 * Instantiate (create) a Person1 object
	 * with state initialized with the supplied arguments
	 * (all object data initialized with supplied values)
	 */
	public Person1(int[] celNumber, int age, String name) {
		super();
		this.celNumber = celNumber;
		this.age = age;
		this.name = name;
	}
	/**
	 * Class parameterized Constructor:
	 * Instantiate (create) a Person1 object
	 * with state initialized with the supplied arguments
	 * (all object data initialized with supplied values)
	 */
	public Person1(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age; // return a copy of primitive int age
	}
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Increment the supplied age by one year
	 * 
	 * @param age	supplied age to increment
	 * 
	 * @return		age after it has been incremented
	 */
	public int birthday(int age) {//reference type
		// grow old by a year
		age = age + 1;
		
		return age;
	}
	/**
	 * Increment the age of the supplied Person object by one year
	 * 
	 * @param p		supplied Person obj to age
	 * 
	 * @return		age after it has been incremented
	 */
	public int birthdayPerson(Person1 p) {
		// grow old by a year
		p.setAge(p.getAge() + 1);
		
		return p.getAge();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get a String representation of the cell phone number.
	 * 
	 * @return	cell phone number
	 */
	public String getCellNumber() {
		StringBuilder sb = new StringBuilder();
		
		for (int n : this.celNumber) {
			sb.append(n);	// build a String
		}
		
		// return completed String
		return sb.toString(); 
	}
	/**
	 * Return a String representation of the current state
	 * (all the current values of data of this object)
	 */
	@Override
	public String toString() {
		return "Person1 [" + revision + "] " + this.name + ", age " + this.age + ", cell: " + getCellNumber();
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + Person1.class.getName() + ".demo()...");

		// instantiate (create) object from Person1 class using class constructor
		Person1 obj = new Person1();
		System.out.println("Show Person state by calling toString() method...");
		System.out.println(obj.toString()); // show age
		/**
		 * let's have a birthday and age by one year
		 * 
		 * 1. get age from object
		 * 2. pass age, int, by value to birthday() (pass a copy)
		 * 3. show what birthday returned (age +1)
		 * 4. show original age from object
		 */
		System.out.println("Person Birthday: " + obj.birthdayPerson(obj));
		
//		obj.setAge(obj.birthday(obj.getAge())); // update obj age
//		System.out.println("Birthday: " + obj.getAge());
		
		System.out.println("Show Person state by print Person object...");
		System.out.println(obj);	// show age
		System.out.println();

		int[] a = {1234567890};
		Person1 daniel = new Person1(a, 17, "Danny Peters");
		System.out.println("Show Person state by print Person object...");
		System.out.println(daniel);	// show age of daniel
		System.out.println();
		
		System.out.println("Cell number: " + obj.getCellNumber());
		System.out.println();
		
		System.out.println("\n\t" + Person1.class.getName() + ".demo()... done!");
	}
}
