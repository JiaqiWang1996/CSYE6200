package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DemoException {
	/**
	 * MyException derives from Exception (Throwable)
	 * @author dpeters
	 *
	 */
	private class MyException extends Exception {

		public MyException() {
			super();
		}

		public MyException(String exceptionMessage) {
			super(exceptionMessage);
		}
		
	}

	public void throwAnException() throws Exception {
		System.out.println("\n\t" + DemoException.class.getName() + ".throwAnException()...");
		
		throw new Exception("DemoException.throwAnException() *** This is Only a Test *** ");
//		System.out.println("\n\t" + DemoExceptions.class.getName() + ".throwAnException()... done!");		
	}

	public void throwMyException() throws MyException {
		System.out.println("\n\t" + DemoException.class.getName() + ".throwMyException()...");
		
		throw new MyException("DemoException.throwMyException() *** This is Only a Test *** ");
//		throw new MyException();
//		System.out.println("\n\t" + DemoExceptions.class.getName() + ".throwAnException()... done!");		
	}

	public void throwException() throws Exception {
		System.out.println("\n\t" + DemoException.class.getName() + ".throwException()...");
		
		try {
			this.throwAnException();
		} catch (Exception e) {
			System.out.println(DemoException.class.getName() + ".throwException() exception handler!");
			System.out.println("e.getMessage() '" + e.getMessage()+ "'");
			e.printStackTrace();
		}
		System.out.println("\n\t" + DemoException.class.getName() + ".throwException()... done!");		
	}
		
	public void catchMyException() {
		System.out.println("\n\t" + DemoException.class.getName() + ".catchMyException()...");
		
		try {
			this.throwMyException();
		} catch (Exception e) {
			System.out.println(DemoException.class.getName() + ".catchMyException() exception handler!");
			System.out.println("e.getMessage() '" + e.getMessage()+ "'");
			e.printStackTrace();
		} finally {			
			System.out.println("\n\t" + DemoException.class.getName() + ".catchMyException()... FINALLY done!");		
		}
		System.out.println("\n\t" + DemoException.class.getName() + ".catchMyException()... done!");		
		
	}
		
	public void specifyMyException() throws MyException {
		System.out.println("\n\t" + DemoException.class.getName() + ".specifyMyException()...");
		
		this.throwMyException();
		System.out.println("\n\t" + DemoException.class.getName() + ".specifyMyException()... done!");		
		
	}
		
	public void specifyException() {
		System.out.println("\n\t" + DemoException.class.getName() + ".specifyException()...");
		
		/**
		 * uncomment the following code 
		 * to complete coding (i.e. surround with try-catch)
		 * to handle the exception 
		 * as specified by method throwException()
		 */
//		this.throwException();	// must surround this statement with a try-catch
		
		System.out.println("\n\t" + DemoException.class.getName() + ".specifyException()... done!");		
	}
	
	public void handleNumberFormatException() {
		System.out.println("\n\t" + DemoException.class.getName() + ".handleNumberFormatException()... ");
		/**
		 * Exception Handling example
		 */
		String nString = "17";	// string representation of a integer value
//		String nString = "seventeen";	// string representation of a integer value
		int n = 0;		// int representation
		
			try {
				/**
				 * Check for Exception
				 */
				n = Integer.parseInt(nString); // convert String to int
			} catch (NumberFormatException e) {
				System.err.println("INVALID STING REPRESENTATION OF INT VALUE: '" + nString + "'");
				e.printStackTrace();
			}
		System.out.println("n = " + n);
		System.out.println("\n\t" + DemoException.class.getName() + ".handleNumberFormatException()... done!");				
	}
	public static void demo() {
		System.out.println("\n\t" + DemoException.class.getName() + ".demo()...");
		
		DemoException obj = new DemoException();
		
//		obj.catchMyException();
		
		try {
			obj.specifyMyException();
		} catch (Exception e) {
			System.out.println(DemoException.class.getName() + ".demo() exception handler!");
			System.out.println("e.getMessage() '" + e.getMessage()+ "'");
			e.printStackTrace();
		} finally {			
			System.out.println("\n\t" + DemoException.class.getName() + ".demo()... FINALLY done!");		
		}
		
		System.out.println("\n\t" + DemoException.class.getName() + ".demo()...done!");
	}

}
