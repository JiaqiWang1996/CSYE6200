package edu.neu.csye6200;

public class Driver {
	/**
	 * Java Enumerated Type:
	 * specifies ONLY data values allowed
	 * @author dgpeters
	 *
	 */
	enum Criteria {
		BLACK,
		WHITE
	}	// NOTICE, a trailing semicolon ";" is OPTIONAL
	
	private final static int n = 3;	// immutable
	
	/**
	 * This public method is inherited by all derived classes
	 * But Can Not be overridden: it is the only implementation allowed 
	 */
	public final void myAPI() {
		System.out.println("I want my API My Way!");
	}
	public static void main(String[] args) {
		System.out.println(Driver.class.getName() + ".main()");
		
//		DemoParameterPassing.demo();
		
//		Shape.demo();
//		Circle1.demo();
		
//		Child2.demo();

//		n = 7;	// final variable is immutable and cannot be changed 
//		System.out.println("n = " + n);
//		System.out.println(Driver.class.getName() + ".main() done!");
		
//		ExplosionModel.demo();	// use concrete class as API
//		ExplosionModelA.demo();	// use abstract class as API
//		ExplodableModel.demo();	// use interface as an API

//		DemoArrayAndLoops.demo();
		
		Criteria myCriteriaVariable = Criteria.BLACK;
		switch (myCriteriaVariable) {
		case BLACK:
			System.out.println("myCriteriaVariable = Black is " + Criteria.BLACK);
			break;
		case WHITE:
			System.out.println("myCriteriaVariable = WHITE is " + Criteria.WHITE);
			break;
		}
		
		myCriteriaVariable = Criteria.WHITE;
		switch (myCriteriaVariable) {
		case BLACK:
			System.out.println("myCriteriaVariable = Black is " + Criteria.BLACK);
			break;
		case WHITE:
			System.out.println("myCriteriaVariable = WHITE is " + Criteria.WHITE);
			break;
		}

		/**
		 * Bad Practice
		 */
		System.out.println("BAD PRACTICE...");
		int someCriteriaVariable = 0;
//		String someCriteria = "BLACK";
		switch (someCriteriaVariable) {
		case 0:
			System.out.println("myCriteriaVariable = Black is " + 0);
			break;
		case 1:
			System.out.println("myCriteriaVariable = WHITE is " + 1);
			break;
		}
		
//		Student.demo();
		School.demo();
		
//		DemoException.demo();
		
//		MyClass.demo();
	}
	
}
/*
 * 
Explosion: Demonstrate Run-Time Polymorphism

100 Total points.
1. 5 points: Create your own Explosion Concrete Parent Class:
	a. include one explode() method.
2. 10 points: Create your own ExplosionModel derived from AbstractExplosionModel
           a. Include a static demo() method (to be called from Driver) to demonstrate its usage
	with objects derived from Explosion.
3. 10 points: Create your own ExplosionModelA derived from AbstractExplosionModelA
           a. Include a static demo() method (to be called from Driver) to demonstrate its usage
	with objects derived from AbstractExplosion.
4. 10 points: Create your own ExplodableModel derived from AbstractExplodableModel
           a. Include a static demo() method (to be called from Driver) to demonstrate its usage
	with objects implementing from ExplodableAPI.
5. 45 points total (5 points each class): Derive 3 Child classes from your Parent class to use with your object model (ExplosionModel). For each derived class:
	a. override the Explode() method in the Explosion base class
           c.  instantiate class
Repeat and Derive 3 or more classes from an AbstractExplosion abstract class and use with ExplosionModelA.
Repeat and Derive 3 or more classes from an ExplodableAPI interface and use with ExplodableModel.
.
6. 10 points: In the model demo method, use objects from your derived classes to demonstrate Dynamic Run-Time Polymorphism.

7. 10 points: Name and zip compress your Eclipse workspace according to our standard (workspace_202006_dan_peters_explosion.zip) Your Eclipse workspace should contain your working program, compiled without errors with all console output pasted into main() method as a comment.


Explosion: Demonstrate Run-Time Polymorphism Part II

Refactor your assignment to now include:

100 Total POINTS:

10 Points
1. Add an integer metric attribute to each derived class;
2. Add a weight attribute (double) to each derived class;
3. Add a name (String) attribute to each derived class;
4. Change the API accordingly to support retrieval of each new attribute
20 POINTS
5. Change the API accordingly to support sorting of the model contents by new attributes;
60 Points
6. Change each Model demo to demonstrate sorting by each attribute via the new API;

7. 10 points: Name and zip compress your Eclipse workspace according to our standard (workspace_201906_dan_peters_explosion2.zip) Your Eclipse workspace should contain your working program, compiled without errors with all console output pasted into main() method as a comment.

Old assignment and grading not to be used for PART II  
100 Total points.
1. 5 points: Create your own Explosion Concrete Parent Class:
	a. include one explode() method.
2. 10 points: Create your own ExplosionModel derived from AbstractExplosionModel
           a. Include a static demo() method (to be called from Driver.main()) to demonstrate its usage
	with objects derived from Explosion.
3. 10 points: Create your own ExplosionModelA derived from AbstractExplosionModelA
           a. Include a static demo() method (to be called from Driver.main()) to demonstrate its usage
	with objects derived from AbstractExplosion.
4. 10 points: Create your own ExplodableModel derived from AbstractExplodableModel
           a. Include a static demo() method (to be called from Driver.main()) to demonstrate its usage
	with objects implementing from ExplodableAPI.
5. 45 points total (5 points each class): Derive 3 Child classes from your Parent class to use with your object model (ExplosionModel). For each derived class:
	a. override the Explode() method in the Explosion base class
           c.  instantiate class
Repeat and Derive 3 or more classes from an AbstractExplosion abstract class and use with ExplosionModelA.
Repeat and Derive 3 or more classes from an ExplodableAPI interface and use with ExplodableModel.
.
6. 10 points: In the model demo method, use objects from your derived classes to demonstrate Dynamic Run-Time Polymorphism.

7. 10 points: Name and zip compress your Eclipse workspace according to our standard (workspace_201906_dan_peters_explosion.zip) Your Eclipse workspace should contain your working program, compiled without errors with all console output pasted into main() method as a comment.

 * 
 */