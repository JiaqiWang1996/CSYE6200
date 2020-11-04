package edu.neu.csye6200;

/**
 * API for all Animal Factories
 * @author dpeters
 *
 */
public abstract class AbstractAnimalFactory {
	/**
	 * Get an Animal object
	 * @return
	 */
	public abstract Animal getObject();
//	public abstract Animal getObject(String csvData);
}
