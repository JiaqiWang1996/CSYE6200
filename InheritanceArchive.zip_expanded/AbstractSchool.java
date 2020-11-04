package edu.neu.csye6200;

import java.util.Comparator;

/**
 * API for specifying methods for a School class.
 * School class must implement each abstract method.
 * 
 * @author dgpeters
 *
 */
public abstract class AbstractSchool {
	/**
	 * enroll Students in School, adding to student roster
	 * @param s		Student object as an AbstractPerson
	 */
	public abstract void enroll(AbstractPerson s);
	/**
	 * Use supplied comparator to sort the roster
	 */
	public abstract void sortRoster(Comparator<AbstractPerson> c);
	public abstract void showRoster();
}
