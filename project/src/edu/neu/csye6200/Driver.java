package edu.neu.csye6200;

public class Driver {

	public static void main(String[] args) {
		System.out.println(Driver.class.getName() + ".main()...");
		Person1.demo();
		Person2.demo();		// call static demo method
		Person3.demo();		// call static demo method
		
		System.out.println("Driver"  + ".main()... done!");
	}

}
