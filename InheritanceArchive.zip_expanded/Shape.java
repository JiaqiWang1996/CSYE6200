package edu.neu.csye6200;

public class Shape {
	private final static String description = "I am a shape.";
	
	@Override
	public String toString() {
		return description;
	}

	public static void demo() {
		System.out.println("\n\t" + Shape.class.getName() + ".demo()...");
		
		Shape obj = new Shape();
		System.out.println(obj);
		
		System.out.println("\n\t" + Shape.class.getName() + ".demo()... done!");
	}
}
