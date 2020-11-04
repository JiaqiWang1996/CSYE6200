package edu.neu.csye6200;

public class ParentSpeaking implements SpeakableAPI {

	/**
	 * Default Class Constructor
	 */
	public ParentSpeaking() {
		super();
	}

	/**
	 * ParentSpeaking API (as specified by SpeakableAPI Interface)
	 * public method defined for and inherited by all deriving subclasses
	 */
	@Override
	public void speak() {
		/**
		 * Can implement anything
		 */
		System.out.println("I am a parent");
	}
}
