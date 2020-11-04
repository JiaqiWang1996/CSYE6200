package edu.neu.csye6200;

/**
 * Abstract Person is used to specify (for inheriting class)
 *  WHAT a Person class does, without specifying
 *  HOW a Person class does (implements) it.
 * 
 * @author dpeters
 *
 */
public abstract class AbstractPersonAPI {
	/**
	 * Abstract method is used by Person to speak
	 * (each deriving class which inherits
	 * from this abstract class MUST implement
	 * this speak() method.
	 */
	public abstract void speak(); // API incomplete method

}
