package edu.neu.csye6200;

public class Circle1 extends Shape {

	/**
	 * demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + Circle1.class.getName() + ".demo()...");

		/**
		 * Use default constructor to create object
		 */
		Circle1 obj = new Circle1();
				
		/**
		 * use toString() method to output
		 * object state to console (stdout) 
		 */
		System.out.println(obj);
		System.out.println("\n\t" + Circle1.class.getName() + ".demo()... done!");
	}
}
