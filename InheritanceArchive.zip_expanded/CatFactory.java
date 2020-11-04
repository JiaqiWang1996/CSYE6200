package edu.neu.csye6200;

/**
 * Factory for creating Cat objects
 * @author dpeters
 *
 */
public class CatFactory extends AbstractAnimalFactory {

	@Override
	public Animal getObject() {
		return new Cat();
	}

}
