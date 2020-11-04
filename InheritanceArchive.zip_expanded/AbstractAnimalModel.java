package edu.neu.csye6200;

public abstract class AbstractAnimalModel {
	/**
	 * load a small group of animals into model
	 */
	public abstract void load();
	/**
	 * add one animal to the model
	 * @param e
	 */
	public abstract void add(Animal e);
	/**
	 * allow each animal loaded into the model to speak
	 */
	public abstract void speakAll();
}
