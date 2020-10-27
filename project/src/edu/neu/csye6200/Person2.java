package edu.neu.csye6200;

/**
 * a very basic class to model a person.
 * 
 * @author dgpeters
 *
 */
public class Person2 {
	private int age = 17;
	private String name = "Dan";
	
	/**
	 * Object initialization block
	 */
	{
		age = 17;
		name = "Daniel";
	}

	/**
	 * return a String representation of this object's state
	 * (all the values for this object's data members)
	 */
	@Override
	public String toString() {
		return name + ", age " + age;
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + Person2.class.getName() + ".demo()...");
		
		/**
		 * memory location to hold object created from Person2 class
		 */
		Person2 obj = new Person2();
		System.out.println(obj);	// call toString() implicitly
		System.out.println(obj.toString());	// call toString() explicitly
		
		System.out.println("\n\t" + Person2.class.getName() + ".demo()... done!");
	}

}
