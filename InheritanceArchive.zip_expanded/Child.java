package edu.neu.csye6200;

/**
 * Child class inherits from Parent class
 * @author dpeters
 *
 */
public class Child extends Parent {
	public Child() {
		super(); // call Parent class default constructor
		// TODO Auto-generated constructor stub
	}

	/**
	 * Child implementation of Parent Speak method
	 * 
	 * NOTE:
	 * @Override is a Java annotation 
	 * NOT PART OF JAVA LANGUAGE
	 * NOT REQUIRED
	 * BUT SHOULD ALWAYS BE PRESENT 
	 * because it will DOUBLE-CHECK your code to MAKE SURE you are REALLY overriding
	 * i.e. spelling, etc...
	 */
	@Override
	public void speak() {
		System.out.println("I am a child and I am overriding my Parent class implementation.");
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + Child.class.getName() + ".demo()...");
		
		/**
		 * childObject is Type Child
		 */
		Child childObject = new Child();	// create Child object
		childObject.speak();				// Child Speak
		
		/**
		 * create Child object BUT
		 * Use in a Parent type variable
		 * parentObject is Type Parent
		 * Polymorphism here Child Is-A Parent
		 */
		Parent parentObject = new Child();	// Child Is-A Parent
		parentObject.speak();	// Parent Speak (Polymorphism: Function Overriding Child Speak)
		
		System.out.println("\n\t" + Child.class.getName() + ".demo()... done!");
	}
}
