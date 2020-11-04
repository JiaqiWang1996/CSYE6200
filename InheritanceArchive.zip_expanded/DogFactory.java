package edu.neu.csye6200;

/**
 * Factory for creating Dog objects
 * @author dpeters
 *
 */
public class DogFactory extends AbstractAnimalFactory {

	@Override
	public Animal getObject() {
		return new Dog();
	}

}
