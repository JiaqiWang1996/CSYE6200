package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class AnimalModel extends AbstractAnimalModel {
	private List<Animal> animals = new ArrayList<Animal>();
	private List<AbstractAnimalFactory> animalFactories = new ArrayList<AbstractAnimalFactory>();
	
	/**
	 * Object Initalizer Block
	 * executed with each constructor
	 */
	{
		// add Animal Factories to model
		this.animalFactories.add(new DogFactory());
		this.animalFactories.add(new CatFactory());
	}
	
	/**
	 * Load Animal objects from supplied Animal Factories
	 */
	@Override
	public void load() {
		System.out.println(this.animalFactories.size() + " animal factories in model.");
		for (AbstractAnimalFactory f : animalFactories) {
			add(f.getObject());
		}
		
//		add(new Dog());
//		add(new Cat());
	}

	@Override
	public void add(Animal e) {
		this.animals.add(e);
	}

	@Override
	public void speakAll() {
		System.out.println(animals.size() + " animals in AnimalModel.");
		for (Animal animal : animals) {
			animal.speak();
		}
	}
	
	public static void demo() {
		System.out.println("\n\t" + AnimalModel.class.getName() + ".demo()...");
		
		AnimalModel obj = new AnimalModel();

		/**
		 * add Animal objects into the AnimalModel
		 */
		obj.add(new Dog());
		obj.add(new Cat());
		/**
		 * Use Factory Pattern
		 */
		System.out.println("Use Animal Factories to abstract constructor...");
		AbstractAnimalFactory factoryDog = new DogFactory();
		AbstractAnimalFactory factoryCat = new CatFactory();
		obj.add(factoryDog.getObject());
		obj.add(factoryCat.getObject());
		
		obj.load();
		
		/**
		 * Allow each Animal to speak
		 */
		obj.speakAll();
		
		System.out.println("\n\t" + AnimalModel.class.getName() + ".demo()...done!");
	}

}
