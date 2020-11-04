package edu.neu.csye6200;

/**
 * A Parent class which uses the AbstractPerson API
 * which specifies the API in one method 
 * 
 * 		void speak();
 * 
 * @author dpeters
 *
 */
public class Parent extends AbstractPersonAPI /* extends Thread */ {

	/**
	 * Default Class Constructor
	 */
	public Parent() {
		super();
	}

	/**
	 * Parent API (as specified by AbstractPersonAPI)
	 * public method defined for and inherited by all deriving subclasses
	 */
	public void speak() {
		/**
		 * Can implement anything
		 */
		System.out.println("I am a parent");
	}
}
