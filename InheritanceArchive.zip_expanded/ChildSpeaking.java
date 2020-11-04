package edu.neu.csye6200;

public class ChildSpeaking extends ParentSpeaking {
	/**
	 * Child implementation of ParentSpeaking speak method
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
		System.out.println("I am a child speaking and I am overriding my ParentSpeaking class implementation.");
	}
	
	/**
	 * Demonstrate the use of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + ChildSpeaking.class.getName() + ".demo()...");
		
		/**
		 * childObject is Type Child
		 */
		ChildSpeaking childObject = new ChildSpeaking();	// create Child object
		childObject.speak();				// Child Speak
		
		/**
		 * create Child object BUT
		 * Use in a Parent type variable
		 * parentObject is Type Parent
		 * Polymorphism here Child Is-A Parent
		 */
		ParentSpeaking parentObject = new ChildSpeaking();	// Child Is-A Parent
		parentObject.speak();	// Parent Speak (Polymorphism: Function Overriding Child Speak)
		
		System.out.println("\n\t" + ChildSpeaking.class.getName() + ".demo()... done!");
	}

}
