package edu.neu.csye6200;

public class MyClass implements MyInterface, Runnable {
	
	@Override
	public void myMethod() {
		System.out.println("MyInterface.MyMethod()...");
	}
	
	@Override
	public void run() {
		System.out.println("running MyClass run()...");
	}
	
	public static void demo() {
		System.out.println("\n\t" + MyClass.class.getName() + " .demo()...");
		
		MyClass obj = new MyClass();
		
		obj.myMethod();
		if (obj instanceof MyClass) {
			System.out.println("obj is a type MyClass");
		}
		if (obj instanceof MyInterface) {
			System.out.println("obj is a type MyInterface");
		}
		if (obj instanceof Runnable) {
			System.out.println("obj is a type Runnable");
		}
		
		System.out.println("\n\t" + MyClass.class.getName() + " .demo()... done!");
	}
}
