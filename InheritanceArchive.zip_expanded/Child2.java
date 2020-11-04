package edu.neu.csye6200;

public class Child2 extends Parent2 {
	
	public Child2() {
		super();
	}

	public Child2(String title, String name) {
		super(title, name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append(", ").append( "is the father of Dan, the child of ").append(super.toString()).append(".");
		
		return sb.toString();
	}
	
	public static void demo() {
		System.out.println("\n\t" + Child2.class.getName() + ".demo()...");
		
		System.out.println(new Child2());
		System.out.println(new Child2("Child", "Dan"));
		
		System.out.println("\n\t" + Child2.class.getName() + ".demo()... done!");
	}
}
